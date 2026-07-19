package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bb.class */
public class C0031bb extends aO {
    public static final float cd = 0.04f;
    public static final float ce = 0.31f;

    @NotNull
    public static tL a = tL.IDLE;

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            a = tL.IDLE;
            return;
        }
        double d = localPlayer.walkDist - localPlayer.walkDistO;
        boolean z2 = false;
        if (!localPlayer.onGround()) {
            Vec3 vec3Position = localPlayer.position();
            BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Position, vec3Position.add(0.0d, -0.75d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty()));
            if (blockHitResultClip instanceof BlockHitResult) {
                z2 = blockHitResultClip.getType() == HitResult.Type.MISS;
            }
        }
        boolean z3 = localPlayer.getVehicle() != null;
        boolean z4 = d > 0.03999999910593033d;
        boolean z5 = z4 && localPlayer.isSprinting();
        boolean z6 = Math.abs(localPlayer.getDeltaMovement().y) >= 0.3100000023841858d || z2;
        tL tLVar = tL.IDLE;
        if (!z3) {
            if (localPlayer.isCrouching()) {
                tLVar = tL.CRAWLING;
            }
            if (z4) {
                tLVar = tL.WALKING;
            }
            if (z5) {
                tLVar = tL.SPRINTING;
            }
            if (z6) {
                tLVar = tL.JUMPING;
            }
        }
        a = tLVar;
    }
}
