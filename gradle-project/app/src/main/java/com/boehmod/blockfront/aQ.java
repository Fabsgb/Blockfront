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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aQ.class */
public final class aQ extends aO {
    public static float bc = 0.0f;
    public static float bd = 0.0f;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aQ$a.class */
    private enum a {
        PLAYER,
        SPECTATOR,
        CINEMATIC,
        DEATH_FADE
    }

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        hE.d(f);
        b(localPlayer);
        c(localPlayer);
        a(c0297l, minecraft, fTVar, localPlayer);
    }

    private void a(@NotNull C0297l c0297l, @NotNull Minecraft minecraft, @NotNull fT fTVar, @NotNull LocalPlayer localPlayer) {
        LocalPlayer playerByUUID;
        a aVar = a.PLAYER;
        oF<?, ?, ?> oFVarM591a = c0297l.m591a();
        if (c0297l.m592d() || (localPlayer.isSpectator() && oFVarM591a != null && oFVarM591a.bb())) {
            aVar = a.SPECTATOR;
        } else if (fTVar.dk() || localPlayer.isDeadOrDying()) {
            aVar = a.DEATH_FADE;
        }
        C0333mi c0333miM602a = c0297l.m602a();
        if (c0333miM602a.ay()) {
            aVar = a.CINEMATIC;
        }
        switch (aVar) {
            case PLAYER:
                if (minecraft.getCameraEntity() != localPlayer) {
                    iG.a(minecraft, (Entity) localPlayer);
                }
                bd = 0.0f;
                bc = 0.0f;
                break;
            case SPECTATOR:
                LocalPlayer localPlayer2 = localPlayer;
                UUID uuidQ = fTVar.q();
                if (uuidQ != null && minecraft.level != null && (playerByUUID = minecraft.level.getPlayerByUUID(uuidQ)) != null) {
                    localPlayer2 = playerByUUID;
                }
                if (minecraft.getCameraEntity() != localPlayer2) {
                    iG.a(minecraft, (Entity) localPlayer2);
                }
                bd = 0.0f;
                bc = 0.0f;
                break;
            case CINEMATIC:
                mZ mZVarA = c0333miM602a.a();
                if (mZVarA != null && minecraft.getCameraEntity() != mZVarA) {
                    iG.a(minecraft, mZVarA);
                }
                bd = 0.0f;
                bc = 0.0f;
                break;
            case DEATH_FADE:
                bd = bc;
                bc = C0634xm.d(bc, 2.0f, 0.02f);
                break;
        }
    }

    private void b(@NotNull LocalPlayer localPlayer) {
        float f = localPlayer.walkDist - localPlayer.walkDistO;
        boolean zIsSprinting = localPlayer.isSprinting();
        boolean z = localPlayer.onGround() && f > 0.0f;
        C0025aw.V = C0025aw.U;
        C0025aw.U = Mth.lerp(0.3f, C0025aw.U, zIsSprinting ? 0.6f : 0.0f);
        C0025aw.T = C0025aw.S;
        C0025aw.S = Mth.lerp(0.3f, C0025aw.S, z ? 0.6f : 0.0f);
        C0025aw.X = C0025aw.W;
        C0025aw.W = Mth.lerp(0.4f, C0025aw.W, 0.0f);
        Vec3 vec3Scale = localPlayer.position().subtract(localPlayer.xOld, localPlayer.yOld, localPlayer.zOld).yRot(((localPlayer.getYRot() + 90.0f) * 0.017453292f) - 1.5707964f).scale(10.0d);
        Item item = localPlayer.getMainHandItem().getItem();
        if (item instanceof tO) {
            ((tO) item).mz += Mth.abs((float) ((vec3Scale.x + vec3Scale.y) + vec3Scale.z)) / 100.0f;
        }
    }

    private void c(@NotNull LocalPlayer localPlayer) {
        boolean zIsSprinting = localPlayer.isSprinting();
        C0027ay.ap = C0027ay.ao;
        C0027ay.ao = Mth.lerp(zIsSprinting ? 0.1f : C0558ur.hR ? 0.4f : 0.2f, C0027ay.ao, zIsSprinting ? 1.25f : 0.0f);
    }
}
