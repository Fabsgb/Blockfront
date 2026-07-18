package com.boehmod.blockfront;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.AreaLightData;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

/* JADX INFO: renamed from: com.boehmod.blockfront.lR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lR.class */
public class C0640lR extends C0635lM {

    /* JADX INFO: renamed from: hA */
    private static final float f3523hA = 12.0f;

    /* JADX INFO: renamed from: kp */
    private static final int f3524kp = 16716049;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<AreaLightData> f3525d;

    /* JADX INFO: renamed from: e */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<PointLightData> f3526e;

    /* JADX INFO: renamed from: hB */
    private float f3527hB;

    public C0640lR(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3527hB = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2834a(@NotNull BlockPos blockPos, @NotNull C0640lR c0640lR) {
        c0640lR.f3527hB += 12.0f;
        Vec3 center = blockPos.getCenter();
        if (c0640lR.f3526e == null) {
            c0640lR.f3526e = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setBrightness(10.0f).setRadius(3.0f).setPosition(center.x, center.y - 0.5d, center.z).setColor(f3524kp));
        } else {
            ((PointLightData) c0640lR.f3526e.getLightData()).setBrightness(5.0f + Mth.sin(C0119bk.m366g() / 4.0f));
        }
        if (c0640lR.f3525d == null) {
            AreaLightData color = new AreaLightData().setSize(0.75d, 0.75d).setDistance(16.0f).setBrightness(3.5f).setColor(f3524kp);
            color.getPosition().set(center.x, center.y - 0.5d, center.z);
            c0640lR.f3525d = VeilRenderSystem.renderer().getLightRenderer().addLight(color);
        } else {
            AreaLightData areaLightData = (AreaLightData) c0640lR.f3525d.getLightData();
            areaLightData.getOrientation().set(new Quaternionf().rotateX(-0.17453292f).rotateY(c0640lR.f3527hB * 0.017453292f));
            areaLightData.markDirty();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.f3525d != null) {
            this.f3525d.free();
            this.f3525d = null;
        }
        if (this.f3526e != null) {
            this.f3526e.free();
            this.f3526e = null;
        }
        super.setRemoved();
    }
}
