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

/* JADX INFO: renamed from: com.boehmod.blockfront.aQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aQ.class */
public final class C0046aQ extends AbstractC0044aO {

    /* JADX INFO: renamed from: bc */
    public static float f298bc = 0.0f;

    /* JADX INFO: renamed from: bd */
    public static float f299bd = 0.0f;

    /* JADX INFO: renamed from: com.boehmod.blockfront.aQ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aQ$a.class */
    private enum a {
        PLAYER,
        SPECTATOR,
        CINEMATIC,
        DEATH_FADE
    }

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        C0415hE.m1965d(f);
        m212b(localPlayer);
        m213c(localPlayer);
        m211a(c0622l, minecraft, c0324fT, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m211a(@NotNull C0622l c0622l, @NotNull Minecraft minecraft, @NotNull C0324fT c0324fT, @NotNull LocalPlayer localPlayer) {
        LocalPlayer playerByUUID;
        a aVar = a.PLAYER;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622l.m2688a();
        if (c0622l.m2689d() || (localPlayer.isSpectator() && abstractC0787oFM2688a != null && abstractC0787oFM2688a.mo3611bb())) {
            aVar = a.SPECTATOR;
        } else if (c0324fT.m1087dk() || localPlayer.isDeadOrDying()) {
            aVar = a.DEATH_FADE;
        }
        C0710mi c0710miM2709a = c0622l.m2709a();
        if (c0710miM2709a.m3241ay()) {
            aVar = a.CINEMATIC;
        }
        switch (aVar) {
            case PLAYER:
                if (minecraft.getCameraEntity() != localPlayer) {
                    C0470iG.m2123a(minecraft, (Entity) localPlayer);
                }
                f299bd = 0.0f;
                f298bc = 0.0f;
                break;
            case SPECTATOR:
                LocalPlayer localPlayer2 = localPlayer;
                UUID uuidQ = c0324fT.m1099q();
                if (uuidQ != null && minecraft.level != null && (playerByUUID = minecraft.level.getPlayerByUUID(uuidQ)) != null) {
                    localPlayer2 = playerByUUID;
                }
                if (minecraft.getCameraEntity() != localPlayer2) {
                    C0470iG.m2123a(minecraft, (Entity) localPlayer2);
                }
                f299bd = 0.0f;
                f298bc = 0.0f;
                break;
            case CINEMATIC:
                C0701mZ c0701mZM3244a = c0710miM2709a.m3244a();
                if (c0701mZM3244a != null && minecraft.getCameraEntity() != c0701mZM3244a) {
                    C0470iG.m2123a(minecraft, c0701mZM3244a);
                }
                f299bd = 0.0f;
                f298bc = 0.0f;
                break;
            case DEATH_FADE:
                f299bd = f298bc;
                f298bc = C1290xm.m7835d(f298bc, 2.0f, 0.02f);
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m212b(@NotNull LocalPlayer localPlayer) {
        float f = localPlayer.walkDist - localPlayer.walkDistO;
        boolean zIsSprinting = localPlayer.isSprinting();
        boolean z = localPlayer.onGround() && f > 0.0f;
        C0078aw.f477V = C0078aw.f476U;
        C0078aw.f476U = Mth.lerp(0.3f, C0078aw.f476U, zIsSprinting ? 0.6f : 0.0f);
        C0078aw.f475T = C0078aw.f474S;
        C0078aw.f474S = Mth.lerp(0.3f, C0078aw.f474S, z ? 0.6f : 0.0f);
        C0078aw.f479X = C0078aw.f478W;
        C0078aw.f478W = Mth.lerp(0.4f, C0078aw.f478W, 0.0f);
        Vec3 vec3Scale = localPlayer.position().subtract(localPlayer.xOld, localPlayer.yOld, localPlayer.zOld).yRot(((localPlayer.getYRot() + 90.0f) * 0.017453292f) - 1.5707964f).scale(10.0d);
        Item item = localPlayer.getMainHandItem().getItem();
        if (item instanceof AbstractC1062tO) {
            ((AbstractC1062tO) item).f5613mz += Mth.abs((float) ((vec3Scale.x + vec3Scale.y) + vec3Scale.z)) / 100.0f;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m213c(@NotNull LocalPlayer localPlayer) {
        boolean zIsSprinting = localPlayer.isSprinting();
        C0080ay.f505ap = C0080ay.f504ao;
        C0080ay.f504ao = Mth.lerp(zIsSprinting ? 0.1f : C1144ur.f5994hR ? 0.4f : 0.2f, C0080ay.f504ao, zIsSprinting ? 1.25f : 0.0f);
    }
}
