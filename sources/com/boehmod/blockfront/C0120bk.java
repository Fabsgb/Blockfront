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

/* JADX INFO: renamed from: com.boehmod.blockfront.bk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bk.class */
public class C0120bk extends AbstractC0053aW {

    /* JADX INFO: renamed from: cl */
    public static float f804cl = 0.0f;

    /* JADX INFO: renamed from: cm */
    public static float f805cm = 0.0f;

    /* JADX INFO: renamed from: cn */
    public static float f806cn = 0.0f;

    /* JADX INFO: renamed from: co */
    public static float f807co = 0.0f;

    /* JADX INFO: renamed from: cp */
    public static float f808cp = 0.0f;

    /* JADX INFO: renamed from: cq */
    public static float f809cq = 0.0f;

    /* JADX INFO: renamed from: cr */
    public static float f810cr = 0.0f;

    /* JADX INFO: renamed from: cs */
    public static float f811cs = 0.0f;

    /* JADX INFO: renamed from: ct */
    private static final float f812ct = 0.85f;

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        f805cm = f804cl;
        f807co = f806cn;
        f809cq = f808cp;
        f811cs = f810cr;
        if (localPlayer != null) {
            Item item = localPlayer.getMainHandItem().getItem();
            if (item instanceof C1117uP) {
                C1069tU c1069tUM6395a = ((C1117uP) item).m6395a();
                f804cl = Mth.lerp(c1069tUM6395a.m5934bl() * (C1117uP.f6063il ? 2.0f : 1.0f), f804cl, 0.0f);
                float fM5933bk = c1069tUM6395a.m5933bk() * (1.0f - (C0112bc.f744bB * 0.5f)) * f804cl;
                float fM5932bj = c1069tUM6395a.m5932bj() * (C1117uP.f6063il ? 0.25f : 1.0f) * f804cl;
                float fM5931bi = c1069tUM6395a.m5931bi() * (C1117uP.f6063il ? 0.75f : 1.0f) * f804cl;
                f806cn = Mth.lerp(f812ct, f806cn, fM5933bk);
                f808cp = Mth.lerp(f812ct, f808cp, fM5932bj);
                f810cr = Mth.lerp(f812ct, f810cr, fM5931bi);
                return;
            }
        }
        f804cl = 0.0f;
        f806cn = Mth.lerp(f812ct, f806cn, 0.0f);
        f808cp = Mth.lerp(f812ct, f808cp, 0.0f);
        f810cr = Mth.lerp(f812ct, f810cr, 0.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static void m428a(@NotNull C1069tU c1069tU) throws MatchException {
        float fM5939bq;
        switch (C0119bj.f803a) {
            case IDLE:
                fM5939bq = c1069tU.m5935bm();
                break;
            case WALKING:
                fM5939bq = c1069tU.m5936bn();
                break;
            case SPRINTING:
                fM5939bq = c1069tU.m5937bo();
                break;
            case CRAWLING:
                fM5939bq = c1069tU.m5938bp();
                break;
            case JUMPING:
                fM5939bq = c1069tU.m5939bq();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        float f = fM5939bq;
        float f2 = (C1117uP.f6063il ? f * 0.5f : f) * (1.0f - (C0112bc.f744bB * 0.5f));
        f804cl += f2;
        f805cm = (f805cm + f2) * 0.8f;
    }
}
