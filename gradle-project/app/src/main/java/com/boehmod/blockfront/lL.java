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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lL.class */
public class lL extends lM {
    private static final int kl = 20;
    private static final float ht = 2.0f;
    private static final float hu = 0.75f;
    private static final float hv = 2.0f;
    private static final float hw = 10.0f;
    private int km;
    private boolean dV;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> b;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private LightRenderHandle<?> c;

    public lL(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.km = 0;
        this.dV = false;
    }

    @OnlyIn(Dist.CLIENT)
    public static void a(@NotNull BlockPos blockPos, @NotNull lL lLVar) {
        LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
        Vec3 center = blockPos.getCenter();
        if (lLVar.b == null) {
            lLVar.b = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(2.0f).setRadius(2.0f).setColor(16716049));
        }
        if (lLVar.c == null) {
            lLVar.c = lightRenderer.addLight(new PointLightData().setPosition(center.x, center.y, center.z).setBrightness(0.75f).setRadius(10.0f).setColor(16716049));
        }
        int i = lLVar.km;
        lLVar.km = i - 1;
        if (i <= 0) {
            lLVar.km = 20;
            lLVar.dV = !lLVar.dV;
            if (lLVar.b != null) {
                lLVar.b.getLightData().setBrightness(lLVar.dV ? 2.0f : 0.0f);
            }
            if (lLVar.c != null) {
                lLVar.c.getLightData().setBrightness(lLVar.dV ? 0.75f : 0.0f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void setRemoved() {
        if (this.b != null) {
            this.b.free();
            this.b = null;
        }
        if (this.c != null) {
            this.c.free();
            this.c = null;
        }
        super.setRemoved();
    }
}
