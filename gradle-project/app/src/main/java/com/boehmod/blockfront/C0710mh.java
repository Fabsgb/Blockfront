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

/* JADX INFO: renamed from: com.boehmod.blockfront.mh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mh.class */
public class C0710mh extends C0711mi {

    /* JADX INFO: renamed from: mi */
    private static final int f3950mi = 20;

    /* JADX INFO: renamed from: il */
    private static final float f3951il = 2.0f;

    /* JADX INFO: renamed from: im */
    private static final float f3952im = 0.75f;

    /* JADX INFO: renamed from: in */
    private static final float f3953in = 2.0f;

    /* JADX INFO: renamed from: io */
    private static final float f3954io = 10.0f;

    /* JADX INFO: renamed from: mj */
    private int f3955mj;

    /* JADX INFO: renamed from: eo */
    private boolean f3956eo;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> f3957b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> f3958c;

    public C0710mh(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3955mj = 0;
        this.f3956eo = false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m3234a(@NotNull BlockPos blockPos, @NotNull C0710mh c0710mh) {
        LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
        Vec3 center = blockPos.getCenter();
        if (c0710mh.f3957b == null) {
            c0710mh.f3957b = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(2.0f).setRadius(2.0f).setColor(16716049));
        }
        if (c0710mh.f3958c == null) {
            c0710mh.f3958c = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(0.75f).setRadius(10.0f).setColor(16716049));
        }
        int i = c0710mh.f3955mj;
        c0710mh.f3955mj = i - 1;
        if (i <= 0) {
            c0710mh.f3955mj = 20;
            c0710mh.f3956eo = !c0710mh.f3956eo;
            if (c0710mh.f3957b != null) {
                c0710mh.f3957b.getLightData().setBrightness(c0710mh.f3956eo ? 2.0f : 0.0f);
            }
            if (c0710mh.f3958c != null) {
                c0710mh.f3958c.getLightData().setBrightness(c0710mh.f3956eo ? 0.75f : 0.0f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.f3957b != null) {
            this.f3957b.free();
            this.f3957b = null;
        }
        if (this.f3958c != null) {
            this.f3958c.free();
            this.f3958c = null;
        }
        super.setRemoved();
    }
}
