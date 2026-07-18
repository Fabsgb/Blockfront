package foundry.veil.impl.client.render.light;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.renderer.DDALightRenderer;
import foundry.veil.api.client.render.light.renderer.LightTypeRenderer;
import it.unimi.dsi.fastutil.longs.LongArrayFIFOQueue;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/light/VoxelShadowGrid.class */
@ApiStatus.Internal
public final class VoxelShadowGrid {
    public static final int GRID_SIZE = 64;
    private static final int HALF = 32;
    private static final int GRID_VOLUME = 262144;
    private static final int SLICE_AREA = 4096;
    private static final int MAX_SLICE_UPDATES_PER_FRAME = 2;
    private static final long BUILD_BUDGET_NS = 2000000;
    private static final int MAX_DIRTY_UPDATES_PER_FRAME = 512;
    private static final int MAX_DIRTY_BACKLOG = 16384;
    private static int textureId;
    private static int pboId;
    private static ResourceKey<Level> gridDimension;
    private static int originX;
    private static int originY;
    private static int originZ;
    private static ByteBuffer gridBuffer;
    private static ResourceKey<Level> buildDimension;
    private static int buildOriginX;
    private static int buildOriginY;
    private static int buildOriginZ;
    private static int buildIndex;
    private static ByteBuffer buildBuffer;
    private static boolean rebuildRequested;
    private static final Vector3f uniformGridPos = new Vector3f();
    private static final Object DIRTY_LOCK = new Object();
    private static final LongArrayFIFOQueue DIRTY_QUEUE = new LongArrayFIFOQueue();
    private static final LongOpenHashSet DIRTY_SET = new LongOpenHashSet();
    private static final long[] DRAIN_SCRATCH = new long[512];

    private VoxelShadowGrid() {
    }

    public static void setup() {
        RenderSystem.assertOnRenderThread();
        Minecraft client = Minecraft.getInstance();
        ClientLevel level = client.level;
        if (level == null) {
            return;
        }
        ensureTexture();
        if (gridDimension != null && !Objects.equals(gridDimension, level.dimension())) {
            clearLevel();
        }
        Vec3 cameraPos = client.gameRenderer.getMainCamera().getPosition();
        int cx = (int) Math.floor(cameraPos.x);
        int cy = (int) Math.floor(cameraPos.y);
        int cz = (int) Math.floor(cameraPos.z);
        if (hasOccludedLights()) {
            if (rebuildRequested) {
                rebuildRequested = false;
                clearDirty();
                startFullBuild(level, cx, cy, cz);
            } else if (buildBuffer != null) {
                int maxDelta = Math.max(Math.abs(cx - (buildOriginX + 32)), Math.max(Math.abs(cy - (buildOriginY + 32)), Math.abs(cz - (buildOriginZ + 32))));
                if (!Objects.equals(buildDimension, level.dimension()) || maxDelta >= 32) {
                    startFullBuild(level, cx, cy, cz);
                }
            } else if (gridBuffer == null) {
                startFullBuild(level, cx, cy, cz);
            }
            if (buildBuffer != null) {
                continueFullBuild(level);
            } else {
                shiftTowards(level, cx, cy, cz);
            }
        }
        if (applyDirtyUpdates(level)) {
            uploadBuffer(gridBuffer);
        }
        if (gridBuffer != null && Objects.equals(gridDimension, level.dimension())) {
            uniformGridPos.set(originX, originY, originZ);
        } else {
            uniformGridPos.set(cx - 32, cy - 32, cz - 32);
        }
    }

    public static void markBlockDirty(BlockPos pos) {
        long packed = pos.asLong();
        synchronized (DIRTY_LOCK) {
            if (DIRTY_SET.add(packed)) {
                DIRTY_QUEUE.enqueue(packed);
                if (DIRTY_QUEUE.size() > 16384) {
                    rebuildRequested = true;
                    clearDirty();
                }
            }
        }
    }

    public static void clearLevel() {
        RenderSystem.assertOnRenderThreadOrInit();
        gridDimension = null;
        if (gridBuffer != null) {
            MemoryUtil.memFree(gridBuffer);
            gridBuffer = null;
        }
        buildDimension = null;
        buildIndex = 0;
        if (buildBuffer != null) {
            MemoryUtil.memFree(buildBuffer);
            buildBuffer = null;
        }
        clearDirty();
    }

    public static void close() {
        RenderSystem.assertOnRenderThreadOrInit();
        clearLevel();
        if (pboId != 0) {
            GL15C.glDeleteBuffers(pboId);
            pboId = 0;
        }
        if (textureId != 0) {
            GL15C.glDeleteTextures(textureId);
            textureId = 0;
        }
    }

    private static void clearDirty() {
        synchronized (DIRTY_LOCK) {
            DIRTY_QUEUE.clear();
            DIRTY_SET.clear();
        }
    }

    private static void startFullBuild(ClientLevel level, int cx, int cy, int cz) {
        buildDimension = level.dimension();
        buildOriginX = cx - 32;
        buildOriginY = cy - 32;
        buildOriginZ = cz - 32;
        buildIndex = 0;
        if (buildBuffer == null) {
            buildBuffer = MemoryUtil.memAlloc(262144);
        }
    }

    private static void continueFullBuild(ClientLevel level) {
        if (!Objects.equals(buildDimension, level.dimension())) {
            MemoryUtil.memFree(buildBuffer);
            buildBuffer = null;
            buildDimension = null;
            buildIndex = 0;
            return;
        }
        long deadline = System.nanoTime() + BUILD_BUDGET_NS;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        while (buildIndex < 262144 && System.nanoTime() < deadline) {
            int lx = buildIndex & 63;
            int ly = (buildIndex >> 6) & 63;
            int lz = buildIndex >> 12;
            pos.set(buildOriginX + lx, buildOriginY + ly, buildOriginZ + lz);
            BlockState state = level.getBlockState(pos);
            buildBuffer.put(buildIndex, voxelOccupancy(level, pos, state));
            buildIndex++;
        }
        if (buildIndex < 262144) {
            return;
        }
        if (gridBuffer != null) {
            MemoryUtil.memFree(gridBuffer);
        }
        gridBuffer = buildBuffer;
        gridDimension = buildDimension;
        originX = buildOriginX;
        originY = buildOriginY;
        originZ = buildOriginZ;
        buildBuffer = null;
        buildDimension = null;
        buildIndex = 0;
        uploadBuffer(gridBuffer);
    }

    private static void shiftTowards(ClientLevel level, int cx, int cy, int cz) {
        if (gridBuffer == null || !Objects.equals(gridDimension, level.dimension())) {
            return;
        }
        int dx = cx - (originX + 32);
        int dy = cy - (originY + 32);
        int dz = cz - (originZ + 32);
        if (Math.max(Math.abs(dx), Math.max(Math.abs(dy), Math.abs(dz))) >= 32) {
            startFullBuild(level, cx, cy, cz);
            return;
        }
        boolean changed = false;
        for (int steps = 0; steps < 2 && (dx != 0 || dy != 0 || dz != 0); steps++) {
            int ax = Math.abs(dx);
            int ay = Math.abs(dy);
            int az = Math.abs(dz);
            if (dx != 0 && ax >= ay && ax >= az) {
                if (dx > 0) {
                    shiftXPositive(level);
                    dx--;
                } else {
                    shiftXNegative(level);
                    dx++;
                }
            } else if (dz != 0 && az >= ay) {
                if (dz > 0) {
                    shiftZPositive(level);
                    dz--;
                } else {
                    shiftZNegative(level);
                    dz++;
                }
            } else {
                if (dy == 0) {
                    break;
                }
                if (dy > 0) {
                    shiftYPositive(level);
                    dy--;
                } else {
                    shiftYNegative(level);
                    dy++;
                }
            }
            changed = true;
        }
        if (changed) {
            uploadBuffer(gridBuffer);
        }
    }

    private static boolean applyDirtyUpdates(ClientLevel level) {
        int toDrain;
        if (gridBuffer == null && buildBuffer == null) {
            clearDirty();
            return false;
        }
        synchronized (DIRTY_LOCK) {
            toDrain = Math.min(DIRTY_QUEUE.size(), 512);
            for (int i = 0; i < toDrain; i++) {
                DRAIN_SCRATCH[i] = DIRTY_QUEUE.dequeueLong();
                DIRTY_SET.remove(DRAIN_SCRATCH[i]);
            }
        }
        if (toDrain == 0) {
            return false;
        }
        boolean updatedGrid = false;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int i2 = 0; i2 < toDrain; i2++) {
            long packed = DRAIN_SCRATCH[i2];
            int x = BlockPos.getX(packed);
            int y = BlockPos.getY(packed);
            int z = BlockPos.getZ(packed);
            pos.set(x, y, z);
            byte occupancy = voxelOccupancy(level, pos, level.getBlockState(pos));
            if (buildBuffer != null && Objects.equals(buildDimension, level.dimension())) {
                int bx = x - buildOriginX;
                int by = y - buildOriginY;
                int bz = z - buildOriginZ;
                if ((bx | by | bz) >= 0 && bx < 64 && by < 64 && bz < 64) {
                    buildBuffer.put(bx + (by * 64) + (bz * 4096), occupancy);
                }
            }
            if (gridBuffer != null && Objects.equals(gridDimension, level.dimension())) {
                int gx = x - originX;
                int gy = y - originY;
                int gz = z - originZ;
                if ((gx | gy | gz) >= 0 && gx < 64 && gy < 64 && gz < 64) {
                    gridBuffer.put(gx + (gy * 64) + (gz * 4096), occupancy);
                    updatedGrid = true;
                }
            }
        }
        return updatedGrid;
    }

    private static void shiftXPositive(ClientLevel level) {
        originX++;
        long base = MemoryUtil.memAddress(gridBuffer);
        for (int z = 0; z < 64; z++) {
            for (int y = 0; y < 64; y++) {
                long row = base + (((long) z) * 4096) + (((long) y) * 64);
                MemoryUtil.memCopy(row + 1, row, 63L);
            }
        }
        fillSliceX(level, 63, (originX + 64) - 1, base);
    }

    private static void shiftXNegative(ClientLevel level) {
        originX--;
        long base = MemoryUtil.memAddress(gridBuffer);
        for (int z = 0; z < 64; z++) {
            for (int y = 0; y < 64; y++) {
                long row = base + (((long) z) * 4096) + (((long) y) * 64);
                MemoryUtil.memCopy(row, row + 1, 63L);
            }
        }
        fillSliceX(level, 0, originX, base);
    }

    private static void fillSliceX(ClientLevel level, int writeX, int worldX, long base) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int z = 0; z < 64; z++) {
            for (int y = 0; y < 64; y++) {
                pos.set(worldX, originY + y, originZ + z);
                BlockState state = level.getBlockState(pos);
                MemoryUtil.memPutByte(base + (((long) z) * 4096) + (((long) y) * 64) + ((long) writeX), voxelOccupancy(level, pos, state));
            }
        }
    }

    private static void shiftYPositive(ClientLevel level) {
        originY++;
        long base = MemoryUtil.memAddress(gridBuffer);
        for (int z = 0; z < 64; z++) {
            long plane = base + (((long) z) * 4096);
            MemoryUtil.memCopy(plane + 64, plane, 4032L);
        }
        fillSliceY(level, 63, (originY + 64) - 1, base);
    }

    private static void shiftYNegative(ClientLevel level) {
        originY--;
        long base = MemoryUtil.memAddress(gridBuffer);
        for (int z = 0; z < 64; z++) {
            long plane = base + (((long) z) * 4096);
            MemoryUtil.memCopy(plane, plane + 64, 4032L);
        }
        fillSliceY(level, 0, originY, base);
    }

    private static void fillSliceY(ClientLevel level, int writeY, int worldY, long base) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int z = 0; z < 64; z++) {
            long row = base + (((long) z) * 4096) + (((long) writeY) * 64);
            for (int x = 0; x < 64; x++) {
                pos.set(originX + x, worldY, originZ + z);
                BlockState state = level.getBlockState(pos);
                MemoryUtil.memPutByte(row + ((long) x), voxelOccupancy(level, pos, state));
            }
        }
    }

    private static void shiftZPositive(ClientLevel level) {
        originZ++;
        long base = MemoryUtil.memAddress(gridBuffer);
        MemoryUtil.memCopy(base + 4096, base, 258048L);
        fillSliceZ(level, 63, (originZ + 64) - 1, base);
    }

    private static void shiftZNegative(ClientLevel level) {
        originZ--;
        long base = MemoryUtil.memAddress(gridBuffer);
        MemoryUtil.memCopy(base, base + 4096, 258048L);
        fillSliceZ(level, 0, originZ, base);
    }

    private static void fillSliceZ(ClientLevel level, int writeZ, int worldZ, long base) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        long plane = base + (((long) writeZ) * 4096);
        for (int y = 0; y < 64; y++) {
            long row = plane + (((long) y) * 64);
            for (int x = 0; x < 64; x++) {
                pos.set(originX + x, originY + y, worldZ);
                BlockState state = level.getBlockState(pos);
                MemoryUtil.memPutByte(row + ((long) x), voxelOccupancy(level, pos, state));
            }
        }
    }

    private static byte voxelOccupancy(ClientLevel level, BlockPos pos, BlockState state) {
        return (state.canOcclude() && state.getFluidState().isEmpty() && state.isSolidRender(level, pos)) ? (byte) -1 : (byte) 0;
    }

    private static void uploadBuffer(ByteBuffer buffer) {
        if (buffer == null || pboId == 0) {
            return;
        }
        buffer.position(0);
        buffer.limit(262144);
        int unpackAlignment = GL15C.glGetInteger(3317);
        GL15C.glPixelStorei(3317, 1);
        GL15C.glBindBuffer(35052, pboId);
        GL15C.glBufferData(35052, buffer, 35040);
        GL15C.glBindTexture(32879, textureId);
        GL15C.glTexSubImage3D(32879, 0, 0, 0, 0, 64, 64, 64, 6403, 5121, 0L);
        GL15C.glBindTexture(32879, 0);
        GL15C.glBindBuffer(35052, 0);
        GL15C.glPixelStorei(3317, unpackAlignment);
    }

    private static void ensureTexture() {
        if (textureId != 0) {
            return;
        }
        textureId = GL15C.glGenTextures();
        GL15C.glBindTexture(32879, textureId);
        GL15C.glTexParameteri(32879, 10241, 9728);
        GL15C.glTexParameteri(32879, 10240, 9728);
        GL15C.glTexParameteri(32879, 10242, 33071);
        GL15C.glTexParameteri(32879, 10243, 33071);
        GL15C.glTexParameteri(32879, 32882, 33071);
        ByteBuffer zeros = MemoryUtil.memCalloc(262144);
        GL15C.glTexImage3D(32879, 0, 33321, 64, 64, 64, 0, 6403, 5121, zeros);
        MemoryUtil.memFree(zeros);
        GL15C.glBindTexture(32879, 0);
        pboId = GL15C.glGenBuffers();
        GL15C.glBindBuffer(35052, pboId);
        GL15C.glBufferData(35052, 262144L, 35040);
        GL15C.glBindBuffer(35052, 0);
    }

    private static boolean hasOccludedLights() {
        Collection<LightTypeRenderer<?>> renderers = VeilRenderSystem.renderer().getLightRenderer().getRenderers().values();
        for (LightTypeRenderer<?> renderer : renderers) {
            if (renderer instanceof DDALightRenderer) {
                DDALightRenderer<?> ddaLightRenderer = (DDALightRenderer) renderer;
                if (ddaLightRenderer.hasOccludedLights()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Vector3fc getUniformGridPos() {
        return uniformGridPos;
    }

    public static int getTextureId() {
        return textureId;
    }
}
