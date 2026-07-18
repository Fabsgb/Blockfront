package com.boehmod.blockfront;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gp.class */
public class C0399gp<T extends BlockEntity & GeoAnimatable> extends AbstractC0402gs<T> {
    public C0399gp(@NotNull BlockEntityRendererProvider.Context context) {
    }

    @NotNull
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(2.25d);
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: a */
    public boolean mo1889a(@NotNull T t) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: R */
    public boolean mo1890R() {
        return true;
    }
}
