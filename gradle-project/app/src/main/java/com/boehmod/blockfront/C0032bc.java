package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bc.class */
public class C0032bc extends aO {
    public static float cf = 0.0f;
    public static float cg = 0.0f;
    public static float ch = 0.0f;
    public static float ci = 0.0f;
    public static float cj = 0.0f;
    public static float ck = 0.0f;
    public static float cl = 0.0f;
    public static float cm = 0.0f;
    private static final float cn = 0.85f;

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        cg = cf;
        ci = ch;
        ck = cj;
        cm = cl;
        if (localPlayer != null) {
            Item item = localPlayer.getMainHandItem().getItem();
            if (item instanceof C0558ur) {
                C0536tw c0536twM1224a = ((C0558ur) item).m1224a();
                cf = Mth.lerp(c0536twM1224a.bf() * (C0558ur.hR ? 2.0f : 1.0f), cf, 0.0f);
                float fBe = c0536twM1224a.be() * (1.0f - (aU.bv * 0.5f)) * cf;
                float fBd = c0536twM1224a.bd() * (C0558ur.hR ? 0.25f : 1.0f) * cf;
                float fBc = c0536twM1224a.bc() * (C0558ur.hR ? 0.75f : 1.0f) * cf;
                ch = Mth.lerp(cn, ch, fBe);
                cj = Mth.lerp(cn, cj, fBd);
                cl = Mth.lerp(cn, cl, fBc);
                return;
            }
        }
        cf = 0.0f;
        ch = Mth.lerp(cn, ch, 0.0f);
        cj = Mth.lerp(cn, cj, 0.0f);
        cl = Mth.lerp(cn, cl, 0.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static void a(@NotNull C0536tw c0536tw) throws MatchException {
        float fBk;
        switch (C0031bb.a) {
            case IDLE:
                fBk = c0536tw.bg();
                break;
            case WALKING:
                fBk = c0536tw.bh();
                break;
            case SPRINTING:
                fBk = c0536tw.bi();
                break;
            case CRAWLING:
                fBk = c0536tw.bj();
                break;
            case JUMPING:
                fBk = c0536tw.bk();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        float f = fBk;
        float f2 = (C0558ur.hR ? f * 0.5f : f) * (1.0f - (aU.bv * 0.5f));
        cf += f2;
        cg = (cg + f2) * 0.8f;
    }
}
