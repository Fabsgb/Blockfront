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

/* JADX INFO: renamed from: com.boehmod.blockfront.ad */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ad.class */
public class C0059ad extends AbstractC0056aa {

    /* JADX INFO: renamed from: al */
    private static final int f392al = 5;

    /* JADX INFO: renamed from: am */
    private static final int f393am = 4;

    /* JADX INFO: renamed from: s */
    private static final float f394s = 0.03f;

    /* JADX INFO: renamed from: an */
    private static final int f395an = 10;

    /* JADX INFO: renamed from: ao */
    private static final int f396ao = 8;

    /* JADX INFO: renamed from: ap */
    private static final int f397ap = 800;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final ResourceLocation f398m = C0564jv.m2555d("textures/misc/overlay_snowstorm.png");

    /* JADX INFO: renamed from: t */
    private static final float f399t = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo225a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
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
                C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7320nV.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0056aa
    /* JADX INFO: renamed from: a */
    public void mo226a(@NotNull Minecraft minecraft, C0622l c0622l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        C0119bk.m552a(guiGraphics, f398m, f2 * 0.6f * c0622l.m2683a().m2233n(f));
    }
}
