package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eH.class */
public class eH extends eJ<lO> {
    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(@NotNull lO lOVar) {
        return lOVar.o();
    }

    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(@NotNull lO lOVar) {
        return lOVar.p();
    }

    @Override // com.boehmod.blockfront.eJ
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation a(@NotNull lO lOVar) {
        return lOVar.q();
    }

    @Override // com.boehmod.blockfront.eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(@NotNull lO lOVar) {
        ResourceLocation resourceLocationQ = lOVar.q();
        return ResourceLocation.fromNamespaceAndPath(resourceLocationQ.getNamespace(), "textures/" + resourceLocationQ.getPath() + ".png");
    }
}
