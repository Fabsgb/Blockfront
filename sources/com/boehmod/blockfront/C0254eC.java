package com.boehmod.blockfront;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eC.class */
public class C0254eC extends PlayerModel<C0692mQ> {
    public C0254eC(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0692mQ c0692mQ, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0692mQ, f, f2, f3, f4, f5);
        c0692mQ.mo3127a(this, C0119bk.m366g() + c0692mQ.getId());
    }
}
