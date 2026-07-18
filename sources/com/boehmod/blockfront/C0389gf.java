package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gf.class */
public final class C0389gf {
    private C0389gf() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1870a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return false;
        }
        List<InterfaceC0839pE> listM5597az = abstractC0787oFM2688a.m3653a().m5597az();
        if (listM5597az.isEmpty()) {
            return false;
        }
        Iterator<InterfaceC0839pE> it = listM5597az.iterator();
        while (it.hasNext()) {
            it.next().mo4265a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3);
        }
        return true;
    }
}
