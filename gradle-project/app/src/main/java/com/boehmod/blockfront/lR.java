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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lR.class */
public class lR extends lM {
    private static final float hA = 12.0f;
    private static final int kp = 16716049;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<AreaLightData> d;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<PointLightData> e;
    private float hB;

    public lR(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.hB = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    public static void a(@NotNull BlockPos blockPos, @NotNull lR lRVar) {
        lRVar.hB += 12.0f;
        Vec3 center = blockPos.getCenter();
        if (lRVar.e == null) {
            lRVar.e = VeilRenderSystem.renderer().getLightRenderer().addLight(new PointLightData().setBrightness(10.0f).setRadius(3.0f).setPosition(center.x, center.y - 0.5d, center.z).setColor(kp));
        } else {
            ((PointLightData) lRVar.e.getLightData()).setBrightness(5.0f + Mth.sin(C0040bk.g() / 4.0f));
        }
        if (lRVar.d == null) {
            AreaLightData color = new AreaLightData().setSize(0.75d, 0.75d).setDistance(16.0f).setBrightness(3.5f).setColor(kp);
            color.getPosition().set(center.x, center.y - 0.5d, center.z);
            lRVar.d = VeilRenderSystem.renderer().getLightRenderer().addLight(color);
        } else {
            AreaLightData areaLightData = (AreaLightData) lRVar.d.getLightData();
            areaLightData.getOrientation().set(new Quaternionf().rotateX(-0.17453292f).rotateY(lRVar.hB * 0.017453292f));
            areaLightData.markDirty();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.d != null) {
            this.d.free();
            this.d = null;
        }
        if (this.e != null) {
            this.e.free();
            this.e = null;
        }
        super.setRemoved();
    }
}
