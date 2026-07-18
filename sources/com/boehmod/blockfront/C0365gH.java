package com.boehmod.blockfront;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gH.class */
public class C0365gH<T extends Entity> extends EntityRenderer<T> {
    public C0365gH(@NotNull EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.0f;
        this.shadowStrength = 0.0f;
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T t) {
        return C0564jv.m2555d("textures/entity/nothing");
    }

    public boolean shouldShowName(@NotNull T t) {
        return false;
    }
}
