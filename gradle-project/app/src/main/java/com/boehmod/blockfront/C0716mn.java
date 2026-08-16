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

/* JADX INFO: renamed from: com.boehmod.blockfront.mn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mn.class */
public class C0716mn extends C0711mi {

    /* JADX INFO: renamed from: is */
    private static final float f3997is = 12.0f;

    /* JADX INFO: renamed from: mm */
    private static final int f3998mm = 16716049;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<AreaLightData> f3999d;

    /* JADX INFO: renamed from: e */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<PointLightData> f4000e;

    /* JADX INFO: renamed from: it */
    private float f4001it;

    public C0716mn(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f4001it = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m3265a(@NotNull BlockPos blockPos, @NotNull C0716mn c0716mn) {
        c0716mn.f4001it += 12.0f;
        Vec3 center = blockPos.getCenter();
        if (c0716mn.f4000e == null) {
            c0716mn.f4000e = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setBrightness(10.0f).setRadius(3.0f).setPosition(center.x, center.y - 0.5d, center.z).setColor(f3998mm));
        } else {
            ((PointLightData) c0716mn.f4000e.getLightData()).setBrightness(5.0f + Mth.sin(C0129bt.m466g() / 4.0f));
        }
        if (c0716mn.f3999d == null) {
            AreaLightData color = new AreaLightData().setSize(0.75d, 0.75d).setDistance(16.0f).setBrightness(3.5f).setColor(f3998mm);
            color.getPosition().set(center.x, center.y - 0.5d, center.z);
            c0716mn.f3999d = VeilRenderSystem.renderer().getLightRenderer().addLight(color);
        } else {
            AreaLightData areaLightData = (AreaLightData) c0716mn.f3999d.getLightData();
            areaLightData.getOrientation().set(new Quaternionf().rotateX(-0.17453292f).rotateY(c0716mn.f4001it * 0.017453292f));
            areaLightData.markDirty();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.f3999d != null) {
            this.f3999d.free();
            this.f3999d = null;
        }
        if (this.f4000e != null) {
            this.f4000e.free();
            this.f4000e = null;
        }
        super.setRemoved();
    }
}
