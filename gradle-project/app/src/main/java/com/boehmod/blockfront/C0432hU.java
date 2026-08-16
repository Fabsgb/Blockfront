package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.hU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hU.class */
public class C0432hU {

    /* JADX INFO: renamed from: T */
    @NotNull
    private static final List<C0433hV> f2712T;

    /* JADX INFO: renamed from: ak */
    private static final double f2713ak = 0.25d;

    /* JADX INFO: renamed from: gd */
    private static final float f2714gd = 0.3f;

    /* JADX INFO: renamed from: ge */
    private static final float f2715ge = 0.9f;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final Vector3f f2716j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final Vector3f f2717k;

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Vector3f f2718l;

    /* JADX INFO: renamed from: gf */
    private static float f2719gf;

    /* JADX INFO: renamed from: gg */
    private static float f2720gg;

    /* JADX INFO: renamed from: cN */
    static final /* synthetic */ boolean f2721cN;

    static {
        f2721cN = !C0432hU.class.desiredAssertionStatus();
        f2712T = new ObjectArrayList();
        f2716j = new Vector3f();
        f2717k = new Vector3f();
        f2718l = new Vector3f();
        f2719gf = 0.0f;
        f2720gg = Float.NEGATIVE_INFINITY;
    }

    /* JADX INFO: renamed from: f */
    public static void m1984f(@NotNull String str) {
        String[] strArrSplit = str.substring(6, str.length() - 2).split(",");
        if (strArrSplit.length == 9) {
            try {
                m1986a(new C0434hW(Float.parseFloat(strArrSplit[0].trim()), Float.parseFloat(strArrSplit[1].trim()), Float.parseFloat(strArrSplit[2].trim()), Float.parseFloat(strArrSplit[3].trim()), Float.parseFloat(strArrSplit[4].trim()), Float.parseFloat(strArrSplit[5].trim()), Float.parseFloat(strArrSplit[6].trim()), Float.parseFloat(strArrSplit[7].trim()), Integer.parseInt(strArrSplit[8].trim())));
            } catch (NumberFormatException e) {
                C0530jM.logError("Failed to parse shake instruction: " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1985a(@NotNull String str, @NotNull Vec3 vec3) {
        String[] strArrSplit = str.substring(7, str.length() - 2).split(",");
        if (strArrSplit.length == 10) {
            try {
                float f = Float.parseFloat(strArrSplit[0].trim());
                float f2 = Float.parseFloat(strArrSplit[1].trim());
                float f3 = Float.parseFloat(strArrSplit[2].trim());
                float f4 = Float.parseFloat(strArrSplit[3].trim());
                float f5 = Float.parseFloat(strArrSplit[4].trim());
                float f6 = Float.parseFloat(strArrSplit[5].trim());
                float f7 = Float.parseFloat(strArrSplit[6].trim());
                float f8 = Float.parseFloat(strArrSplit[7].trim());
                int i = Integer.parseInt(strArrSplit[8].trim());
                float f9 = Float.parseFloat(strArrSplit[9].trim());
                LocalPlayer localPlayer = Minecraft.getInstance().player;
                if (localPlayer == null) {
                    return;
                }
                m1989a(new C0434hW(f, f2, f3, f4, f5, f6, f7, f8, i), localPlayer, vec3, f9);
            } catch (NumberFormatException e) {
                C0530jM.logError("Failed to parse positioned shake instruction: " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1986a(@NotNull C0434hW c0434hW) {
        m1988a(new C0433hV(c0434hW));
    }

    /* JADX INFO: renamed from: a */
    public static void m1987a(@NotNull C0434hW c0434hW, float f) {
        m1988a(new C0433hV(c0434hW).m1993a(f));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m1988a(@NotNull C0433hV c0433hV) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2721cN && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2895a().m3074aJ()) {
            return;
        }
        for (C0433hV c0433hV2 : f2712T) {
            if (c0433hV2.m1996a().equals(c0433hV.m1996a())) {
                c0433hV2.m1998b(c0433hV);
                return;
            }
        }
        f2712T.add(c0433hV);
    }

    /* JADX INFO: renamed from: a */
    public static void m1989a(@NotNull C0434hW c0434hW, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, float f) {
        float fMax = Math.max(0.0f, Math.min(1.0f - (((float) Math.sqrt(localPlayer.position().distanceToSqr(vec3.x, vec3.y, vec3.z))) / f), 1.0f));
        if (fMax <= 0.0f) {
            return;
        }
        C0433hV c0433hVM1993a = new C0433hV(c0434hW).m1993a(fMax);
        m1990a(c0433hVM1993a, localPlayer, vec3);
        m1988a(c0433hVM1993a);
    }

    /* JADX INFO: renamed from: a */
    public static void m1990a(@NotNull C0433hV c0433hV, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3) {
        Vec3 vec3Subtract = vec3.subtract(localPlayer.position());
        if (vec3Subtract.horizontalDistanceSqr() < 0.25d) {
            return;
        }
        float radians = (float) Math.toRadians(Mth.degreesDifference(localPlayer.getYRot(), (float) Math.toDegrees(Mth.atan2(-vec3Subtract.x, vec3Subtract.z))));
        float fSin = Mth.sin(radians);
        float fCos = Mth.cos(radians);
        float f = Math.abs(fSin) > 0.3f ? -Math.signum(fSin) : 0.0f;
        c0433hV.m1995a(Math.abs(fCos) > 0.3f ? -Math.signum(fCos) : 0.0f, f, f);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m1991a(float f) {
        float f2 = f2719gf + f;
        float f3 = f2 - f2720gg;
        if (f3 > 0.0f) {
            f2720gg = f2;
            f2717k.set(0.0f, 0.0f, 0.0f);
            Iterator<C0433hV> it = f2712T.iterator();
            while (it.hasNext()) {
                it.next().m2003a(f2717k, f);
            }
            f2718l.lerp(f2717k, 1.0f - ((float) Math.pow(0.10000002384185791d, f3)));
        }
        return f2716j.set(f2718l);
    }

    /* JADX INFO: renamed from: aV */
    public static void m1992aV() {
        f2712T.removeIf((v0) -> {
            return v0.m2001l();
        });
        f2719gf += 1.0f;
    }
}
