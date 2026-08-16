package com.boehmod.blockfront;

import java.util.Random;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aY.class */
public final class C0055aY extends AbstractC0053aW {

    /* JADX INFO: renamed from: bi */
    public static float f401bi = 0.0f;

    /* JADX INFO: renamed from: bj */
    public static float f402bj = 0.0f;

    /* JADX INFO: renamed from: com.boehmod.blockfront.aY$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aY$a.class */
    private enum a {
        PLAYER,
        SPECTATOR,
        CINEMATIC,
        DEATH_FADE
    }

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        C0432hU.m1992aV();
        m254b(localPlayer);
        m255c(localPlayer);
        m253a(c0623l, minecraft, c0394gj, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m253a(@NotNull C0623l c0623l, @NotNull Minecraft minecraft, @NotNull C0394gj c0394gj, @NotNull LocalPlayer localPlayer) {
        LocalPlayer playerByUUID;
        a aVar = a.PLAYER;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623l.m2874a();
        if (c0623l.m2875d() || (localPlayer.isSpectator() && abstractC0863pbM2874a != null && abstractC0863pbM2874a.mo4047bl())) {
            aVar = a.SPECTATOR;
        } else if (c0394gj.m1104dt() || localPlayer.isDeadOrDying()) {
            aVar = a.DEATH_FADE;
        }
        C0681mE c0681mEM2895a = c0623l.m2895a();
        if (c0681mEM2895a.m3074aJ()) {
            aVar = a.CINEMATIC;
        }
        switch (aVar) {
            case PLAYER:
                if (minecraft.getCameraEntity() != localPlayer) {
                    C0490iZ.m2215a(minecraft, (Entity) localPlayer);
                }
                f402bj = 0.0f;
                f401bi = 0.0f;
                break;
            case SPECTATOR:
                LocalPlayer localPlayer2 = localPlayer;
                UUID uuidR = c0394gj.m1116r();
                if (uuidR != null && minecraft.level != null && (playerByUUID = minecraft.level.getPlayerByUUID(uuidR)) != null) {
                    localPlayer2 = playerByUUID;
                }
                if (minecraft.getCameraEntity() != localPlayer2) {
                    C0490iZ.m2215a(minecraft, (Entity) localPlayer2);
                }
                f402bj = 0.0f;
                f401bi = 0.0f;
                break;
            case CINEMATIC:
                C0777nv c0777nvM3077a = c0681mEM2895a.m3077a();
                if (c0777nvM3077a != null && minecraft.getCameraEntity() != c0777nvM3077a) {
                    C0490iZ.m2215a(minecraft, c0777nvM3077a);
                }
                f402bj = 0.0f;
                f401bi = 0.0f;
                break;
            case DEATH_FADE:
                f402bj = f401bi;
                f401bi = C1270xJ.m7161d(f401bi, 2.0f, 0.02f);
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m254b(@NotNull LocalPlayer localPlayer) {
        float f = localPlayer.walkDist - localPlayer.walkDistO;
        boolean zIsSprinting = localPlayer.isSprinting();
        boolean z = localPlayer.onGround() && f > 0.0f;
        C0034aD.f299aa = C0034aD.f298Z;
        C0034aD.f298Z = Mth.lerp(0.3f, C0034aD.f298Z, zIsSprinting ? 0.6f : 0.0f);
        C0034aD.f297Y = C0034aD.f296X;
        C0034aD.f296X = Mth.lerp(0.3f, C0034aD.f296X, z ? 0.6f : 0.0f);
        C0034aD.f301ac = C0034aD.f300ab;
        C0034aD.f300ab = Mth.lerp(0.4f, C0034aD.f300ab, 0.0f);
        Vec3 vec3Scale = localPlayer.position().subtract(localPlayer.xOld, localPlayer.yOld, localPlayer.zOld).yRot(((localPlayer.getYRot() + 90.0f) * 0.017453292f) - 1.5707964f).scale(10.0d);
        Item item = localPlayer.getMainHandItem().getItem();
        if (item instanceof AbstractC1140um) {
            ((AbstractC1140um) item).f6252ny += Mth.abs((float) ((vec3Scale.x + vec3Scale.y) + vec3Scale.z)) / 100.0f;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m255c(@NotNull LocalPlayer localPlayer) {
        float f;
        boolean zIsSprinting = localPlayer.isSprinting();
        C0036aF.f327au = C0036aF.f326at;
        if (zIsSprinting) {
            f = 0.1f;
        } else {
            f = C1117uP.f6063il ? 0.4f : 0.2f;
        }
        C0036aF.f326at = Mth.lerp(f, C0036aF.f326at, zIsSprinting ? 1.25f : 0.0f);
    }
}
