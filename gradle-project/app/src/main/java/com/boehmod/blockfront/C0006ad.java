package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ad.class */
public class C0006ad extends AbstractC0003aa {
    private static final int al = 5;
    private static final int am = 4;
    private static final float s = 0.03f;
    private static final int an = 10;
    private static final int ao = 8;
    private static final int ap = 800;

    @NotNull
    private static final ResourceLocation m = C0265jv.d("textures/misc/overlay_snowstorm.png");
    private static final float t = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
        if (f <= 0.0f) {
            return;
        }
        float f2 = 24.0f * f;
        int i = (int) f2;
        if (randomSource.nextFloat() < f2 - i) {
            i++;
        }
        if (i <= 0) {
            return;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = randomSource.nextInt(10) - 5;
            int iNextInt2 = randomSource.nextInt(8) - 4;
            int iNextInt3 = randomSource.nextInt(10) - 5;
            mutableBlockPos.setWithOffset(blockPos, iNextInt, iNextInt2, iNextInt3);
            if (!clientLevel.getBlockState(mutableBlockPos).canOcclude() && clientLevel.canSeeSky(mutableBlockPos)) {
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nV.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0003aa
    public void a(@NotNull Minecraft minecraft, C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        C0040bk.a(guiGraphics, m, f2 * 0.6f * c0297l.m587a().n(f));
    }
}
