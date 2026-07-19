package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gm.class */
public class C0176gm<T extends BlockEntity & GeoAnimatable> extends C0174gk<T> {
    public C0176gm(BlockEntityRendererProvider.Context context) {
        super(new eI());
    }

    @Override // com.boehmod.blockfront.C0174gk, com.boehmod.blockfront.AbstractC0182gs
    public boolean R() {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.player == null || minecraft.player.isCreative();
    }

    @Override // com.boehmod.blockfront.C0174gk, com.boehmod.blockfront.AbstractC0182gs
    public boolean a(@NotNull T t) {
        Minecraft minecraft = Minecraft.getInstance();
        if ((minecraft.player == null || !minecraft.player.isCreative()) && iM.aw != null) {
            return super.a(t);
        }
        return false;
    }

    public boolean shouldRender(@NotNull T t, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && minecraft.player.isCreative()) {
            return true;
        }
        if (iM.aw == null) {
            return false;
        }
        return super.shouldRender(t, vec3);
    }
}
