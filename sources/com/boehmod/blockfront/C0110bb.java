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

/* JADX INFO: renamed from: com.boehmod.blockfront.bb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bb.class */
public class C0110bb extends AbstractC0044aO {

    /* JADX INFO: renamed from: cd */
    public static final float f670cd = 0.04f;

    /* JADX INFO: renamed from: ce */
    public static final float f671ce = 0.31f;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static EnumC1059tL f672a = EnumC1059tL.IDLE;

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            f672a = EnumC1059tL.IDLE;
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
        EnumC1059tL enumC1059tL = EnumC1059tL.IDLE;
        if (!z3) {
            if (localPlayer.isCrouching()) {
                enumC1059tL = EnumC1059tL.CRAWLING;
            }
            if (z4) {
                enumC1059tL = EnumC1059tL.WALKING;
            }
            if (z5) {
                enumC1059tL = EnumC1059tL.SPRINTING;
            }
            if (z6) {
                enumC1059tL = EnumC1059tL.JUMPING;
            }
        }
        f672a = enumC1059tL;
    }
}
