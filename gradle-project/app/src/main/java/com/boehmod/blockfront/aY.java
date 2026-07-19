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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aY.class */
public final class aY extends aO {
    private static final float bU = 0.8f;
    private static final float bV = 0.005f;
    private static final float bW = 0.1f;
    public static float bX;
    public static float bZ;
    public static float cb;
    public static float bY = 0.0f;
    public static float ca = 0.0f;
    public static float cc = 0.0f;

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer == null) {
            C0069cm.p.clear();
            C0069cm.q.clear();
            return;
        }
        ca = bZ;
        if (bY > bX) {
            bZ += 0.1f * (bY - bX);
        }
        bY = bX;
        bX = localPlayer.getHealth();
        if (bZ > bU) {
            bZ = bU;
        } else if (bZ > 0.0f) {
            bZ -= bV;
            if (bZ < 0.0f) {
                bZ = 0.0f;
            }
        }
        cc = cb;
        cb = Mth.lerp(0.05f, cb, 0.0f);
        C0069cm.p.removeIf((v0) -> {
            return v0.k();
        });
        C0069cm.q.removeIf((v0) -> {
            return v0.k();
        });
    }
}
