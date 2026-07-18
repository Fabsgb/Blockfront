package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.hE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hE.class */
public class C0415hE {

    /* JADX INFO: renamed from: Q */
    @NotNull
    private static final List<C0416hF> f2634Q;

    /* JADX INFO: renamed from: fT */
    private static float f2635fT;

    /* JADX INFO: renamed from: fU */
    private static float f2636fU;

    /* JADX INFO: renamed from: fV */
    private static float f2637fV;

    /* JADX INFO: renamed from: fW */
    private static float f2638fW;

    /* JADX INFO: renamed from: fX */
    private static float f2639fX;

    /* JADX INFO: renamed from: fY */
    private static float f2640fY;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final Vector3f f2641j;

    /* JADX INFO: renamed from: cE */
    static final /* synthetic */ boolean f2642cE;

    static {
        f2642cE = !C0415hE.class.desiredAssertionStatus();
        f2634Q = new ObjectArrayList();
        f2635fT = 0.0f;
        f2636fU = 0.0f;
        f2637fV = 0.0f;
        f2638fW = 0.0f;
        f2639fX = 0.0f;
        f2640fY = 0.0f;
        f2641j = new Vector3f();
    }

    /* JADX INFO: renamed from: f */
    public static void m1958f(@NotNull String str) {
        String[] strArrSplit = str.substring(6, str.length() - 2).split(",");
        if (strArrSplit.length == 9) {
            try {
                m1960a(new C0417hG(Float.parseFloat(strArrSplit[0].trim()), Float.parseFloat(strArrSplit[1].trim()), Float.parseFloat(strArrSplit[2].trim()), Float.parseFloat(strArrSplit[3].trim()), Float.parseFloat(strArrSplit[4].trim()), Float.parseFloat(strArrSplit[5].trim()), Float.parseFloat(strArrSplit[6].trim()), Float.parseFloat(strArrSplit[7].trim()), Integer.parseInt(strArrSplit[8].trim())));
            } catch (NumberFormatException e) {
                C0562jt.logError("Failed to parse shake instruction: " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1959a(@NotNull String str, @NotNull Vec3 vec3) {
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
                m1963a(new C0417hG(f, f2, f3, f4, f5, f6, f7, f8, i), localPlayer, vec3, f9);
            } catch (NumberFormatException e) {
                C0562jt.logError("Failed to parse positioned shake instruction: " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1960a(@NotNull C0417hG c0417hG) {
        m1962a(new C0416hF(c0417hG));
    }

    /* JADX INFO: renamed from: a */
    public static void m1961a(@NotNull C0417hG c0417hG, float f) {
        m1962a(new C0416hF(c0417hG).m1968a(f));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m1962a(@NotNull C0416hF c0416hF) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2642cE && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2709a().m3241ay()) {
            return;
        }
        f2634Q.add(c0416hF);
    }

    /* JADX INFO: renamed from: a */
    public static void m1963a(@NotNull C0417hG c0417hG, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, float f) {
        m1961a(c0417hG, Math.max(0.0f, Math.min(1.0f - (((float) Math.sqrt(localPlayer.position().distanceToSqr(vec3.x, vec3.y, vec3.z))) / f), 1.0f)));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m1964a(float f) {
        return f2641j.set(C1290xm.m7843e(f2635fT, f2638fW, f), C1290xm.m7843e(f2636fU, f2639fX, f), C1290xm.m7843e(f2637fV, f2640fY, f));
    }

    /* JADX INFO: renamed from: d */
    public static void m1965d(float f) {
        f2634Q.removeIf(c0416hF -> {
            return c0416hF.m1969a(f);
        });
        f2638fW = f2635fT;
        f2639fX = f2636fU;
        f2640fY = f2637fV;
        Vector3f vector3fM1966a = m1966a();
        f2635fT = vector3fM1966a.x;
        f2636fU = vector3fM1966a.y;
        f2637fV = vector3fM1966a.z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m1966a() {
        Vector3f vector3f = new Vector3f();
        Iterator<C0416hF> it = f2634Q.iterator();
        while (it.hasNext()) {
            vector3f.add(it.next().m1972b());
        }
        return vector3f;
    }
}
