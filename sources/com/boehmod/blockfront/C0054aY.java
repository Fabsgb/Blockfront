package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aY.class */
public final class C0054aY extends AbstractC0044aO {

    /* JADX INFO: renamed from: bU */
    private static final float f375bU = 0.8f;

    /* JADX INFO: renamed from: bV */
    private static final float f376bV = 0.005f;

    /* JADX INFO: renamed from: bW */
    private static final float f377bW = 0.1f;

    /* JADX INFO: renamed from: bX */
    public static float f378bX;

    /* JADX INFO: renamed from: bZ */
    public static float f380bZ;

    /* JADX INFO: renamed from: cb */
    public static float f382cb;

    /* JADX INFO: renamed from: bY */
    public static float f379bY = 0.0f;

    /* JADX INFO: renamed from: ca */
    public static float f381ca = 0.0f;

    /* JADX INFO: renamed from: cc */
    public static float f383cc = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer == null) {
            C0178cm.f1457p.clear();
            C0178cm.f1458q.clear();
            return;
        }
        f381ca = f380bZ;
        if (f379bY > f378bX) {
            f380bZ += 0.1f * (f379bY - f378bX);
        }
        f379bY = f378bX;
        f378bX = localPlayer.getHealth();
        if (f380bZ > f375bU) {
            f380bZ = f375bU;
        } else if (f380bZ > 0.0f) {
            f380bZ -= f376bV;
            if (f380bZ < 0.0f) {
                f380bZ = 0.0f;
            }
        }
        f383cc = f382cb;
        f382cb = Mth.lerp(0.05f, f382cb, 0.0f);
        C0178cm.f1457p.removeIf((v0) -> {
            return v0.m1033k();
        });
        C0178cm.f1458q.removeIf((v0) -> {
            return v0.m1064k();
        });
    }
}
