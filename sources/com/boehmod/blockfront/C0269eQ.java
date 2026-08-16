package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eQ.class */
public final class C0269eQ extends PlayerModel<C0776nu> {
    public C0269eQ(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0776nu c0776nu, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0776nu, f, f2, f3, f4, f5);
        float fM3653t = c0776nu.m3653t(C1270xJ.m7188a(Minecraft.getInstance()));
        ModelPart modelPart = this.head;
        ModelPart modelPart2 = this.hat;
        float f6 = modelPart2.yRot + fM3653t;
        modelPart2.yRot = f6;
        modelPart.yRot = f6;
        ModelPart modelPart3 = this.head;
        float f7 = fM3653t / 4.0f;
        this.hat.zRot = f7;
        modelPart3.zRot = f7;
    }
}
