package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gC.class */
public class C0361gC<T extends BlockEntity & GeoAnimatable> extends C0359gA<T> {
    public C0361gC(BlockEntityRendererProvider.Context context) {
        super(new C0274eV());
    }

    @Override // com.boehmod.blockfront.C0359gA, com.boehmod.blockfront.AbstractC0367gI
    /* JADX INFO: renamed from: a */
    public boolean mo1744a(@NotNull T t) {
        Minecraft minecraft = Minecraft.getInstance();
        if ((minecraft.player == null || !minecraft.player.isCreative()) && C0549jf.f3265aC != null) {
            return super.mo1744a(t);
        }
        return false;
    }

    public boolean shouldRender(@NotNull T t, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && minecraft.player.isCreative()) {
            return true;
        }
        if (C0549jf.f3265aC == null) {
            return false;
        }
        return super.shouldRender(t, vec3);
    }
}
