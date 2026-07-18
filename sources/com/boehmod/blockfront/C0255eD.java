package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eD.class */
public final class C0255eD extends PlayerModel<C0700mY> {
    public C0255eD(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0700mY c0700mY, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0700mY, f, f2, f3, f4, f5);
        float fM3146q = c0700mY.m3146q(C1290xm.m7861a(Minecraft.getInstance()));
        ModelPart modelPart = this.head;
        ModelPart modelPart2 = this.hat;
        float f6 = modelPart2.yRot + fM3146q;
        modelPart2.yRot = f6;
        modelPart.yRot = f6;
        ModelPart modelPart3 = this.head;
        float f7 = fM3146q / 4.0f;
        this.hat.zRot = f7;
        modelPart3.zRot = f7;
    }
}
