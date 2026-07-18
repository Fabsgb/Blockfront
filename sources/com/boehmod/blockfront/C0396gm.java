package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gm.class */
public class C0396gm<T extends BlockEntity & GeoAnimatable> extends C0394gk<T> {
    public C0396gm(BlockEntityRendererProvider.Context context) {
        super(new C0260eI());
    }

    @Override // com.boehmod.blockfront.C0394gk, com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: R */
    public boolean mo1890R() {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.player == null || minecraft.player.isCreative();
    }

    @Override // com.boehmod.blockfront.C0394gk, com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: a */
    public boolean mo1889a(@NotNull T t) {
        Minecraft minecraft = Minecraft.getInstance();
        if ((minecraft.player == null || !minecraft.player.isCreative()) && C0476iM.f2916aw != null) {
            return super.mo1889a(t);
        }
        return false;
    }

    public boolean shouldRender(@NotNull T t, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && minecraft.player.isCreative()) {
            return true;
        }
        if (C0476iM.f2916aw == null) {
            return false;
        }
        return super.shouldRender(t, vec3);
    }
}
