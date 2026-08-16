package com.boehmod.blockfront;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gF.class */
public class C0364gF<T extends BlockEntity & GeoAnimatable> extends AbstractC0367gI<T> {
    public C0364gF(@NotNull BlockEntityRendererProvider.Context context) {
    }

    @NotNull
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(2.25d);
    }

    @Override // com.boehmod.blockfront.AbstractC0367gI
    /* JADX INFO: renamed from: a */
    public boolean mo1744a(@NotNull T t) {
        return false;
    }
}
