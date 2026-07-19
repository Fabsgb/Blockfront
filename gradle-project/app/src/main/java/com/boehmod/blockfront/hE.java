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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hE.class */
public class hE {

    @NotNull
    private static final List<hF> Q;
    private static float fT;
    private static float fU;
    private static float fV;
    private static float fW;
    private static float fX;
    private static float fY;

    @NotNull
    private static final Vector3f j;
    static final /* synthetic */ boolean cE;

    static {
        cE = !hE.class.desiredAssertionStatus();
        Q = new ObjectArrayList();
        fT = 0.0f;
        fU = 0.0f;
        fV = 0.0f;
        fW = 0.0f;
        fX = 0.0f;
        fY = 0.0f;
        j = new Vector3f();
    }

    public static void f(@NotNull String str) {
        String[] strArrSplit = str.substring(6, str.length() - 2).split(",");
        if (strArrSplit.length == 9) {
            try {
                a(new hG(Float.parseFloat(strArrSplit[0].trim()), Float.parseFloat(strArrSplit[1].trim()), Float.parseFloat(strArrSplit[2].trim()), Float.parseFloat(strArrSplit[3].trim()), Float.parseFloat(strArrSplit[4].trim()), Float.parseFloat(strArrSplit[5].trim()), Float.parseFloat(strArrSplit[6].trim()), Float.parseFloat(strArrSplit[7].trim()), Integer.parseInt(strArrSplit[8].trim())));
            } catch (NumberFormatException e) {
                C0263jt.logError("Failed to parse shake instruction: " + str, new Object[0]);
            }
        }
    }

    public static void a(@NotNull String str, @NotNull Vec3 vec3) {
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
                a(new hG(f, f2, f3, f4, f5, f6, f7, f8, i), localPlayer, vec3, f9);
            } catch (NumberFormatException e) {
                C0263jt.logError("Failed to parse positioned shake instruction: " + str, new Object[0]);
            }
        }
    }

    public static void a(@NotNull hG hGVar) {
        a(new hF(hGVar));
    }

    public static void a(@NotNull hG hGVar, float f) {
        a(new hF(hGVar).a(f));
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull hF hFVar) {
        C0297l c0297lB = C0297l.b();
        if (!cE && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m602a().ay()) {
            return;
        }
        Q.add(hFVar);
    }

    public static void a(@NotNull hG hGVar, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, float f) {
        a(hGVar, Math.max(0.0f, Math.min(1.0f - (((float) Math.sqrt(localPlayer.position().distanceToSqr(vec3.x, vec3.y, vec3.z))) / f), 1.0f)));
    }

    @NotNull
    public static Vector3f a(float f) {
        return j.set(C0634xm.e(fT, fW, f), C0634xm.e(fU, fX, f), C0634xm.e(fV, fY, f));
    }

    public static void d(float f) {
        Q.removeIf(hFVar -> {
            return hFVar.m450a(f);
        });
        fW = fT;
        fX = fU;
        fY = fV;
        Vector3f vector3fA = a();
        fT = vector3fA.x;
        fU = vector3fA.y;
        fV = vector3fA.z;
    }

    @NotNull
    public static Vector3f a() {
        Vector3f vector3f = new Vector3f();
        Iterator<hF> it = Q.iterator();
        while (it.hasNext()) {
            vector3f.add(it.next().b());
        }
        return vector3f;
    }
}
