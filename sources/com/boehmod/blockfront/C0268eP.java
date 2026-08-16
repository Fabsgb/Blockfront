package com.boehmod.blockfront;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eP.class */
public class C0268eP extends PlayerModel<C0768nm> {
    public C0268eP(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0768nm c0768nm, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0768nm, f, f2, f3, f4, f5);
        c0768nm.mo3634a(this, C0129bt.m466g() + c0768nm.getId());
    }
}
