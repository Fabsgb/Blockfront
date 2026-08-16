package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eU.class */
public class C0273eU extends C0275eW<C0713mk> {
    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(@NotNull C0713mk c0713mk) {
        return c0713mk.m3252p();
    }

    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(@NotNull C0713mk c0713mk) {
        return c0713mk.m3253q();
    }

    @Override // com.boehmod.blockfront.C0275eW
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation mo1521a(@NotNull C0713mk c0713mk) {
        return c0713mk.m3255r();
    }

    @Override // com.boehmod.blockfront.C0275eW, software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(@NotNull C0713mk c0713mk) {
        ResourceLocation resourceLocationM3255r = c0713mk.m3255r();
        return ResourceLocation.fromNamespaceAndPath(resourceLocationM3255r.getNamespace(), "textures/" + resourceLocationM3255r.getPath() + ".png");
    }
}
