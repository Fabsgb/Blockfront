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

/* JADX INFO: renamed from: com.boehmod.blockfront.bc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bc.class */
public class C0111bc extends AbstractC0044aO {

    /* JADX INFO: renamed from: cf */
    public static float f673cf = 0.0f;

    /* JADX INFO: renamed from: cg */
    public static float f674cg = 0.0f;

    /* JADX INFO: renamed from: ch */
    public static float f675ch = 0.0f;

    /* JADX INFO: renamed from: ci */
    public static float f676ci = 0.0f;

    /* JADX INFO: renamed from: cj */
    public static float f677cj = 0.0f;

    /* JADX INFO: renamed from: ck */
    public static float f678ck = 0.0f;

    /* JADX INFO: renamed from: cl */
    public static float f679cl = 0.0f;

    /* JADX INFO: renamed from: cm */
    public static float f680cm = 0.0f;

    /* JADX INFO: renamed from: cn */
    private static final float f681cn = 0.85f;

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        f674cg = f673cf;
        f676ci = f675ch;
        f678ck = f677cj;
        f680cm = f679cl;
        if (localPlayer != null) {
            Item item = localPlayer.getMainHandItem().getItem();
            if (item instanceof C1144ur) {
                C1096tw c1096twM6417a = ((C1144ur) item).m6417a();
                f673cf = Mth.lerp(c1096twM6417a.m6048bf() * (C1144ur.f5994hR ? 2.0f : 1.0f), f673cf, 0.0f);
                float fM6047be = c1096twM6417a.m6047be() * (1.0f - (C0050aU.f330bv * 0.5f)) * f673cf;
                float fM6046bd = c1096twM6417a.m6046bd() * (C1144ur.f5994hR ? 0.25f : 1.0f) * f673cf;
                float fM6045bc = c1096twM6417a.m6045bc() * (C1144ur.f5994hR ? 0.75f : 1.0f) * f673cf;
                f675ch = Mth.lerp(f681cn, f675ch, fM6047be);
                f677cj = Mth.lerp(f681cn, f677cj, fM6046bd);
                f679cl = Mth.lerp(f681cn, f679cl, fM6045bc);
                return;
            }
        }
        f673cf = 0.0f;
        f675ch = Mth.lerp(f681cn, f675ch, 0.0f);
        f677cj = Mth.lerp(f681cn, f677cj, 0.0f);
        f679cl = Mth.lerp(f681cn, f679cl, 0.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static void m335a(@NotNull C1096tw c1096tw) throws MatchException {
        float fM6053bk;
        switch (C0110bb.f672a) {
            case IDLE:
                fM6053bk = c1096tw.m6049bg();
                break;
            case WALKING:
                fM6053bk = c1096tw.m6050bh();
                break;
            case SPRINTING:
                fM6053bk = c1096tw.m6051bi();
                break;
            case CRAWLING:
                fM6053bk = c1096tw.m6052bj();
                break;
            case JUMPING:
                fM6053bk = c1096tw.m6053bk();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        float f = fM6053bk;
        float f2 = (C1144ur.f5994hR ? f * 0.5f : f) * (1.0f - (C0050aU.f330bv * 0.5f));
        f673cf += f2;
        f674cg = (f674cg + f2) * 0.8f;
    }
}
