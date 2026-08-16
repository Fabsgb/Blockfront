package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gv.class */
public final class C0406gv {
    private C0406gv() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1935a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return false;
        }
        List<InterfaceC0915qa> listM6085aB = abstractC0863pbM2874a.m4089a().m6085aB();
        if (listM6085aB.isEmpty()) {
            return false;
        }
        Iterator<InterfaceC0915qa> it = listM6085aB.iterator();
        while (it.hasNext()) {
            it.next().mo5067a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3);
        }
        return true;
    }
}
