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

/* JADX INFO: renamed from: com.boehmod.blockfront.aj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aj.class */
public class C0066aj extends AbstractC0063ag {

    /* JADX INFO: renamed from: aZ */
    private static final int f435aZ = 5;

    /* JADX INFO: renamed from: ba */
    private static final int f436ba = 4;

    /* JADX INFO: renamed from: x */
    private static final float f437x = 0.03f;

    /* JADX INFO: renamed from: bb */
    private static final int f438bb = 10;

    /* JADX INFO: renamed from: bc */
    private static final int f439bc = 8;

    /* JADX INFO: renamed from: bd */
    private static final int f440bd = 800;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final ResourceLocation f441m = C0532jO.m2378d("textures/misc/overlay_snowstorm.png");

    /* JADX INFO: renamed from: y */
    private static final float f442y = 0.6f;

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo278a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f) {
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
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7885nV.get(), vec3.x + ((double) iNextInt), vec3.y + ((double) iNextInt2), vec3.z + ((double) iNextInt3), 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063ag
    /* JADX INFO: renamed from: a */
    public void mo279a(@NotNull Minecraft minecraft, C0623l c0623l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        C0129bt.m655a(guiGraphics, f441m, f2 * 0.6f * c0623l.m2869a().m2288n(f));
    }
}
