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

/* JADX INFO: renamed from: com.boehmod.blockfront.bj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bj.class */
public class C0119bj extends AbstractC0053aW {

    /* JADX INFO: renamed from: cj */
    public static final float f801cj = 0.04f;

    /* JADX INFO: renamed from: ck */
    public static final float f802ck = 0.31f;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static EnumC1137uj f803a = EnumC1137uj.IDLE;

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            f803a = EnumC1137uj.IDLE;
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
        EnumC1137uj enumC1137uj = EnumC1137uj.IDLE;
        if (!z3) {
            if (localPlayer.isCrouching()) {
                enumC1137uj = EnumC1137uj.CRAWLING;
            }
            if (z4) {
                enumC1137uj = EnumC1137uj.WALKING;
            }
            if (z5) {
                enumC1137uj = EnumC1137uj.SPRINTING;
            }
            if (z6) {
                enumC1137uj = EnumC1137uj.JUMPING;
            }
        }
        f803a = enumC1137uj;
    }
}
