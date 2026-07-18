package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eH.class */
public class C0259eH extends C0261eJ<C0637lO> {
    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(@NotNull C0637lO c0637lO) {
        return c0637lO.m2821o();
    }

    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(@NotNull C0637lO c0637lO) {
        return c0637lO.m2822p();
    }

    @Override // com.boehmod.blockfront.C0261eJ
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation mo1442a(@NotNull C0637lO c0637lO) {
        return c0637lO.m2824q();
    }

    @Override // com.boehmod.blockfront.C0261eJ, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(@NotNull C0637lO c0637lO) {
        ResourceLocation resourceLocationM2824q = c0637lO.m2824q();
        return ResourceLocation.fromNamespaceAndPath(resourceLocationM2824q.getNamespace(), "textures/" + resourceLocationM2824q.getPath() + ".png");
    }
}
