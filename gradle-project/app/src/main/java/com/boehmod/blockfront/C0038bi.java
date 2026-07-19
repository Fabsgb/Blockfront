package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bi.class */
public class C0038bi {
    public static final int bs = 8;
    private static final int bt = 128;
    private static final int bu = 16;
    private static final int bv = 512;
    private static final int bw = 1;
    private static final int bx = 5;
    private static final int by = 40;
    public static final float cr = 0.7f;

    @NotNull
    private static final ResourceLocation w = C0265jv.d("textures/gui/shadoweffect.png");

    @NotNull
    private static final ResourceLocation x = C0265jv.d("textures/gui/compass/waypoint_pp_player.png");

    @NotNull
    private static final LongList a = new LongArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final Deque<Long> f61a = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final Long2ObjectMap<ResourceLocation> f62a = new Long2ObjectOpenHashMap();

    @NotNull
    private static final ObjectList<BlockPos> h = new ObjectArrayList();
    private static int bz = 0;
    private static int bA = 0;

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull Collection<C0045bp> collection, int i, int i2, float f, int i3, int i4) {
        int i5 = i + (i3 / 2);
        int i6 = i2 + (i4 / 2);
        Vector3f vector3f = localPlayer.position().toVector3f();
        float yRot = localPlayer.getYRot() + 180.0f;
        poseStack.pushPose();
        C0040bk.a(guiGraphics, i, i2, i3, i4, C0040bk.p());
        C0040bk.a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2, 301989887);
        C0040bk.a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2);
        a(poseStack, guiGraphics, i5, i6, vector3f.x, vector3f.z, f);
        guiGraphics.disableScissor();
        a(poseStack, guiGraphics, font, collection, i, i2, i3, i4, i5, i6, vector3f.x, vector3f.z, f, i + i3, i2 + i4);
        C0040bk.b(poseStack, guiGraphics, x, i5, i6, 6, 6, yRot);
        poseStack.popPose();
    }

    private static void a(PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        float f6 = f5 * 16.0f;
        ObjectIterator it = f62a.long2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry) it.next();
            long longKey = entry.getLongKey();
            ResourceLocation resourceLocation = (ResourceLocation) entry.getValue();
            float x2 = f + (((ChunkPos.getX(longKey) * 16) - f3) * f5);
            float z = f2 + (((ChunkPos.getZ(longKey) * 16) - f4) * f5);
            if (x2 >= 0.0f && z >= 0.0f && x2 <= f * 2.0f && z <= f2 * 2.0f) {
                C0040bk.a(poseStack, guiGraphics, resourceLocation, x2, z, f6, f6, 0.65f);
            }
        }
    }

    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Collection<C0045bp> collection, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        for (C0045bp c0045bp : collection) {
            Vec3 vec3M239c = c0045bp.m239c();
            float f8 = (float) (((double) f) + ((vec3M239c.x - ((double) f3)) * ((double) f5)));
            float f9 = (float) (((double) f2) + ((vec3M239c.z - ((double) f4)) * ((double) f5)));
            C0040bk.a(guiGraphics, i, i2, i3, i4);
            c0045bp.a(poseStack, guiGraphics, font, f8, f9);
            guiGraphics.disableScissor();
            if (f8 < i) {
                f8 = i;
            }
            if (f8 > f6 - 5.0f) {
                f8 = f6 - 5.0f;
            }
            if (f9 < i2) {
                f9 = i2;
            }
            if (f9 > f7 - 5.0f) {
                f9 = f7 - 5.0f;
            }
            c0045bp.a(poseStack, guiGraphics, f8, f9, c0045bp.b());
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (minecraft.options.hideGui) {
            j(minecraft);
        }
        int i = bz;
        bz = i - 1;
        if (i <= 0) {
            bz = 5;
            c(minecraft, clientLevel);
        }
        int i2 = bA;
        bA = i2 - 1;
        if (i2 <= 0) {
            bA = 40;
            d(localPlayer);
        }
    }

    private static void d(@NotNull LocalPlayer localPlayer) {
        double x2 = localPlayer.getX();
        double z = localPlayer.getZ();
        for (int i = -8; i < 8; i++) {
            for (int i2 = -8; i2 < 8; i2++) {
                long jAsLong = ChunkPos.asLong(SectionPos.blockToSectionCoord((int) (x2 + ((double) (i * 16)))), SectionPos.blockToSectionCoord((int) (z + ((double) (i2 * 16)))));
                if (!f62a.containsKey(jAsLong)) {
                    a.add(jAsLong);
                }
            }
        }
    }

    private static void c(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel) {
        if (!a.isEmpty()) {
            try {
                a(minecraft, clientLevel, a.getLong(0));
                a.removeLong(0);
            } catch (IOException e) {
                C0263jt.a("Failed to render queued chunk.", e, new Object[0]);
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, long j) throws IOException {
        int x2 = ChunkPos.getX(j) * 16;
        int z = ChunkPos.getZ(j) * 16;
        NativeImage nativeImage = new NativeImage(16, 16, false);
        int maxBuildHeight = clientLevel.getMaxBuildHeight();
        for (int i = 0; i < 16; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                nativeImage.setPixelRGBA(i, i2, a(clientLevel, x2 + i, z + i2, maxBuildHeight));
            }
        }
        a(minecraft, j, nativeImage);
    }

    private static int a(@NotNull ClientLevel clientLevel, int i, int i2, int i3) {
        h.clear();
        int i4 = -1;
        for (int i5 = i3 - 1; i5 > 0 && h.size() < 3; i5--) {
            BlockPos blockPos = new BlockPos(i, i5, i2);
            if (a(clientLevel, blockPos, clientLevel.getBlockState(blockPos))) {
                h.add(blockPos);
                if (i4 == -1) {
                    i4 = i5;
                }
            }
        }
        if (h.isEmpty()) {
            return 0;
        }
        int iA = a(clientLevel);
        if (m226a(clientLevel, i, i2, i4)) {
            iA = (-16777216) | (((int) (((iA >> 16) & 255) * 0.7f)) << 16) | (((int) (((iA >> 8) & 255) * 0.7f)) << 8) | ((int) ((iA & 255) * 0.7f));
        }
        return iA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m226a(@NotNull ClientLevel clientLevel, int i, int i2, int i3) {
        int[] iArr = {1, -1, 0, 0};
        int[] iArr2 = {0, 0, 1, -1};
        for (int i4 = 0; i4 < 4; i4++) {
            if (Math.abs(a(clientLevel, i + iArr[i4], i2 + iArr2[i4]) - i3) > 1) {
                return true;
            }
        }
        return false;
    }

    private static int a(@NotNull ClientLevel clientLevel, int i, int i2) {
        for (int maxBuildHeight = clientLevel.getMaxBuildHeight() - 1; maxBuildHeight > 0; maxBuildHeight--) {
            BlockPos blockPos = new BlockPos(i, maxBuildHeight, i2);
            if (a(clientLevel, blockPos, clientLevel.getBlockState(blockPos))) {
                return maxBuildHeight;
            }
        }
        return 0;
    }

    private static boolean a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        Block block = blockState.getBlock();
        return !clientLevel.canSeeSky(blockPos) && (blockState.isSolid() || (block instanceof SlabBlock) || (block instanceof SnowLayerBlock) || !blockState.getFluidState().isEmpty());
    }

    private static int a(@NotNull ClientLevel clientLevel) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        ObjectListIterator it = h.iterator();
        while (it.hasNext()) {
            BlockPos blockPos = (BlockPos) it.next();
            BlockState blockState = clientLevel.getBlockState(blockPos);
            int iCalculateRGBColor = blockState.getMapColor(clientLevel, blockPos).calculateRGBColor(MapColor.Brightness.HIGH);
            if (blockState.getFluidState().is(Fluids.WATER)) {
                z = true;
            }
            i += (iCalculateRGBColor >> 16) & 255;
            i2 += (iCalculateRGBColor >> 8) & 255;
            i3 += iCalculateRGBColor & 255;
        }
        int size = h.size();
        if (size > 0) {
            return ((z ? 128 : 255) << 24) | ((i / size) << 16) | ((i2 / size) << 8) | (i3 / size);
        }
        return 0;
    }

    private static void a(@NotNull Minecraft minecraft, long j, @NotNull NativeImage nativeImage) {
        ResourceLocation resourceLocationD = C0265jv.d("chunk" + j);
        minecraft.getTextureManager().register(resourceLocationD, new DynamicTexture(nativeImage));
        f62a.put(j, resourceLocationD);
        a(minecraft, j);
    }

    private static void a(@NotNull Minecraft minecraft, long j) {
        TextureManager textureManager = minecraft.getTextureManager();
        f61a.remove(Long.valueOf(j));
        f61a.addFirst(Long.valueOf(j));
        while (f61a.size() > 512) {
            long jLongValue = f61a.removeLast().longValue();
            textureManager.release((ResourceLocation) f62a.get(jLongValue));
            f62a.remove(jLongValue);
        }
    }

    public static void j(@NotNull Minecraft minecraft) {
        TextureManager textureManager = minecraft.getTextureManager();
        a.clear();
        ObjectIterator it = f62a.values().iterator();
        while (it.hasNext()) {
            textureManager.release((ResourceLocation) it.next());
        }
        f62a.clear();
    }
}
