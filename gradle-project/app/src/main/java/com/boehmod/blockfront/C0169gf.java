package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gf.class */
public final class C0169gf {
    private C0169gf() {
    }

    public static boolean a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (oFVarM591a = c0297lB.m591a()) == null) {
            return false;
        }
        List<pE> listAz = oFVarM591a.m767a().az();
        if (listAz.isEmpty()) {
            return false;
        }
        Iterator<pE> it = listAz.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3);
        }
        return true;
    }
}
