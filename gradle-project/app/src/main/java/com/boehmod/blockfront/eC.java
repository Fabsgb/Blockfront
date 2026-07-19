package com.boehmod.blockfront;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eC.class */
public class eC extends PlayerModel<mQ> {
    public eC(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull mQ mQVar, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(mQVar, f, f2, f3, f4, f5);
        mQVar.a(this, C0040bk.g() + mQVar.getId());
    }
}
