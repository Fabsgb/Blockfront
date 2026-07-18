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

/* JADX INFO: renamed from: com.boehmod.blockfront.bi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bi.class */
public class C0117bi {

    /* JADX INFO: renamed from: bs */
    public static final int f703bs = 8;

    /* JADX INFO: renamed from: bt */
    private static final int f706bt = 128;

    /* JADX INFO: renamed from: bu */
    private static final int f707bu = 16;

    /* JADX INFO: renamed from: bv */
    private static final int f708bv = 512;

    /* JADX INFO: renamed from: bw */
    private static final int f709bw = 1;

    /* JADX INFO: renamed from: bx */
    private static final int f712bx = 5;

    /* JADX INFO: renamed from: by */
    private static final int f713by = 40;

    /* JADX INFO: renamed from: cr */
    public static final float f716cr = 0.7f;

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final ResourceLocation f704w = C0564jv.m2555d("textures/gui/shadoweffect.png");

    /* JADX INFO: renamed from: x */
    @NotNull
    private static final ResourceLocation f705x = C0564jv.m2555d("textures/gui/compass/waypoint_pp_player.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final LongList f710a = new LongArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Deque<Long> f711a = new ArrayDeque();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Long2ObjectMap<ResourceLocation> f714a = new Long2ObjectOpenHashMap();

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final ObjectList<BlockPos> f715h = new ObjectArrayList();

    /* JADX INFO: renamed from: bz */
    private static int f717bz = 0;

    /* JADX INFO: renamed from: bA */
    private static int f718bA = 0;

    /* JADX INFO: renamed from: a */
    public static void m348a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull Collection<C0124bp> collection, int i, int i2, float f, int i3, int i4) {
        int i5 = i + (i3 / 2);
        int i6 = i2 + (i4 / 2);
        Vector3f vector3f = localPlayer.position().toVector3f();
        float yRot = localPlayer.getYRot() + 180.0f;
        poseStack.pushPose();
        C0119bk.m415a(guiGraphics, i, i2, i3, i4, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2, 301989887);
        C0119bk.m517a(guiGraphics, i + 1, i2 + 1, i3 - 2, i4 - 2);
        m349a(poseStack, guiGraphics, i5, i6, vector3f.x, vector3f.z, f);
        guiGraphics.disableScissor();
        m350a(poseStack, guiGraphics, font, collection, i, i2, i3, i4, i5, i6, vector3f.x, vector3f.z, f, i + i3, i2 + i4);
        C0119bk.m443b(poseStack, guiGraphics, f705x, i5, i6, 6, 6, yRot);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m349a(PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        float f6 = f5 * 16.0f;
        ObjectIterator it = f714a.long2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry) it.next();
            long longKey = entry.getLongKey();
            ResourceLocation resourceLocation = (ResourceLocation) entry.getValue();
            float x = f + (((ChunkPos.getX(longKey) * 16) - f3) * f5);
            float z = f2 + (((ChunkPos.getZ(longKey) * 16) - f4) * f5);
            if (x >= 0.0f && z >= 0.0f && x <= f * 2.0f && z <= f2 * 2.0f) {
                C0119bk.m432a(poseStack, guiGraphics, resourceLocation, x, z, f6, f6, 0.65f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m350a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Collection<C0124bp> collection, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        for (C0124bp c0124bp : collection) {
            Vec3 vec3M633c = c0124bp.m633c();
            float f8 = (float) (((double) f) + ((vec3M633c.x - ((double) f3)) * ((double) f5)));
            float f9 = (float) (((double) f2) + ((vec3M633c.z - ((double) f4)) * ((double) f5)));
            C0119bk.m517a(guiGraphics, i, i2, i3, i4);
            c0124bp.m628a(poseStack, guiGraphics, font, f8, f9);
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
            c0124bp.m627a(poseStack, guiGraphics, f8, f9, c0124bp.m631b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m351a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (minecraft.options.hideGui) {
            m362j(minecraft);
        }
        int i = f717bz;
        f717bz = i - 1;
        if (i <= 0) {
            f717bz = 5;
            m353c(minecraft, clientLevel);
        }
        int i2 = f718bA;
        f718bA = i2 - 1;
        if (i2 <= 0) {
            f718bA = 40;
            m352d(localPlayer);
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m352d(@NotNull LocalPlayer localPlayer) {
        double x = localPlayer.getX();
        double z = localPlayer.getZ();
        for (int i = -8; i < 8; i++) {
            for (int i2 = -8; i2 < 8; i2++) {
                long jAsLong = ChunkPos.asLong(SectionPos.blockToSectionCoord((int) (x + ((double) (i * 16)))), SectionPos.blockToSectionCoord((int) (z + ((double) (i2 * 16)))));
                if (!f714a.containsKey(jAsLong)) {
                    f710a.add(jAsLong);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m353c(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel) {
        if (!f710a.isEmpty()) {
            try {
                m354a(minecraft, clientLevel, f710a.getLong(0));
                f710a.removeLong(0);
            } catch (IOException e) {
                C0562jt.m2516a("Failed to render queued chunk.", e, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m354a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, long j) throws IOException {
        int x = ChunkPos.getX(j) * 16;
        int z = ChunkPos.getZ(j) * 16;
        NativeImage nativeImage = new NativeImage(16, 16, false);
        int maxBuildHeight = clientLevel.getMaxBuildHeight();
        for (int i = 0; i < 16; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                nativeImage.setPixelRGBA(i, i2, m355a(clientLevel, x + i, z + i2, maxBuildHeight));
            }
        }
        m360a(minecraft, j, nativeImage);
    }

    /* JADX INFO: renamed from: a */
    private static int m355a(@NotNull ClientLevel clientLevel, int i, int i2, int i3) {
        f715h.clear();
        int i4 = -1;
        for (int i5 = i3 - 1; i5 > 0 && f715h.size() < 3; i5--) {
            BlockPos blockPos = new BlockPos(i, i5, i2);
            if (m358a(clientLevel, blockPos, clientLevel.getBlockState(blockPos))) {
                f715h.add(blockPos);
                if (i4 == -1) {
                    i4 = i5;
                }
            }
        }
        if (f715h.isEmpty()) {
            return 0;
        }
        int iM359a = m359a(clientLevel);
        if (m356a(clientLevel, i, i2, i4)) {
            iM359a = (-16777216) | (((int) (((iM359a >> 16) & 255) * 0.7f)) << 16) | (((int) (((iM359a >> 8) & 255) * 0.7f)) << 8) | ((int) ((iM359a & 255) * 0.7f));
        }
        return iM359a;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m356a(@NotNull ClientLevel clientLevel, int i, int i2, int i3) {
        int[] iArr = {1, -1, 0, 0};
        int[] iArr2 = {0, 0, 1, -1};
        for (int i4 = 0; i4 < 4; i4++) {
            if (Math.abs(m357a(clientLevel, i + iArr[i4], i2 + iArr2[i4]) - i3) > 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static int m357a(@NotNull ClientLevel clientLevel, int i, int i2) {
        for (int maxBuildHeight = clientLevel.getMaxBuildHeight() - 1; maxBuildHeight > 0; maxBuildHeight--) {
            BlockPos blockPos = new BlockPos(i, maxBuildHeight, i2);
            if (m358a(clientLevel, blockPos, clientLevel.getBlockState(blockPos))) {
                return maxBuildHeight;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m358a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        Block block = blockState.getBlock();
        return !clientLevel.canSeeSky(blockPos) && (blockState.isSolid() || (block instanceof SlabBlock) || (block instanceof SnowLayerBlock) || !blockState.getFluidState().isEmpty());
    }

    /* JADX INFO: renamed from: a */
    private static int m359a(@NotNull ClientLevel clientLevel) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        ObjectListIterator it = f715h.iterator();
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
        int size = f715h.size();
        if (size > 0) {
            return ((z ? 128 : 255) << 24) | ((i / size) << 16) | ((i2 / size) << 8) | (i3 / size);
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private static void m360a(@NotNull Minecraft minecraft, long j, @NotNull NativeImage nativeImage) {
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d("chunk" + j);
        minecraft.getTextureManager().register(resourceLocationM2555d, new DynamicTexture(nativeImage));
        f714a.put(j, resourceLocationM2555d);
        m361a(minecraft, j);
    }

    /* JADX INFO: renamed from: a */
    private static void m361a(@NotNull Minecraft minecraft, long j) {
        TextureManager textureManager = minecraft.getTextureManager();
        f711a.remove(Long.valueOf(j));
        f711a.addFirst(Long.valueOf(j));
        while (f711a.size() > 512) {
            long jLongValue = f711a.removeLast().longValue();
            textureManager.release((ResourceLocation) f714a.get(jLongValue));
            f714a.remove(jLongValue);
        }
    }

    /* JADX INFO: renamed from: j */
    public static void m362j(@NotNull Minecraft minecraft) {
        TextureManager textureManager = minecraft.getTextureManager();
        f710a.clear();
        ObjectIterator it = f714a.values().iterator();
        while (it.hasNext()) {
            textureManager.release((ResourceLocation) it.next());
        }
        f714a.clear();
    }
}
