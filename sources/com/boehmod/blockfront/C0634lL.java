package com.boehmod.blockfront;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.lL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lL.class */
public class C0634lL extends C0635lM {

    /* JADX INFO: renamed from: kl */
    private static final int f3476kl = 20;

    /* JADX INFO: renamed from: ht */
    private static final float f3477ht = 2.0f;

    /* JADX INFO: renamed from: hu */
    private static final float f3478hu = 0.75f;

    /* JADX INFO: renamed from: hv */
    private static final float f3479hv = 2.0f;

    /* JADX INFO: renamed from: hw */
    private static final float f3480hw = 10.0f;

    /* JADX INFO: renamed from: km */
    private int f3481km;

    /* JADX INFO: renamed from: dV */
    private boolean f3482dV;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> f3483b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> f3484c;

    public C0634lL(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3481km = 0;
        this.f3482dV = false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2803a(@NotNull BlockPos blockPos, @NotNull C0634lL c0634lL) {
        LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
        Vec3 center = blockPos.getCenter();
        if (c0634lL.f3483b == null) {
            c0634lL.f3483b = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(2.0f).setRadius(2.0f).setColor(16716049));
        }
        if (c0634lL.f3484c == null) {
            c0634lL.f3484c = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(0.75f).setRadius(10.0f).setColor(16716049));
        }
        int i = c0634lL.f3481km;
        c0634lL.f3481km = i - 1;
        if (i <= 0) {
            c0634lL.f3481km = 20;
            c0634lL.f3482dV = !c0634lL.f3482dV;
            if (c0634lL.f3483b != null) {
                c0634lL.f3483b.getLightData().setBrightness(c0634lL.f3482dV ? 2.0f : 0.0f);
            }
            if (c0634lL.f3484c != null) {
                c0634lL.f3484c.getLightData().setBrightness(c0634lL.f3482dV ? 0.75f : 0.0f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.f3483b != null) {
            this.f3483b.free();
            this.f3483b = null;
        }
        if (this.f3484c != null) {
            this.f3484c.free();
            this.f3484c = null;
        }
        super.setRemoved();
    }
}
