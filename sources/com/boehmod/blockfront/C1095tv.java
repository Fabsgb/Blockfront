package com.boehmod.blockfront;

import java.util.function.Consumer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.tv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tv.class */
public class C1095tv extends C1058tK implements GeoItem {

    /* JADX INFO: renamed from: dd */
    @NotNull
    private static final String f5750dd = "gui_controller";

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AnimatableInstanceCache f5751b;

    /* JADX INFO: renamed from: de */
    @NotNull
    private final String f5752de;

    /* JADX INFO: renamed from: fM */
    @NotNull
    private final ResourceLocation f5753fM;

    /* JADX INFO: renamed from: fN */
    @NotNull
    private final ResourceLocation f5754fN;

    /* JADX INFO: renamed from: fO */
    @NotNull
    private final ResourceLocation f5755fO;

    public C1095tv(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f5751b = GeckoLibUtil.createInstanceCache(this);
        this.f5752de = str;
        this.f5753fM = C0564jv.m2555d("textures/item/" + this.f5752de + ".png");
        this.f5754fN = C0564jv.m2555d("animations/item/" + this.f5752de + ".animation.json");
        this.f5755fO = C0564jv.m2555d("geo/item/" + this.f5752de + ".geo.json");
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.tv.1

            /* JADX INFO: renamed from: a */
            private C0379gV f5756a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.f5756a == null) {
                    this.f5756a = new C0379gV(this);
                }
                return this.f5756a;
            }
        });
    }

    @NotNull
    /* JADX INFO: renamed from: O */
    public ResourceLocation m6041O() {
        return this.f5753fM;
    }

    @NotNull
    /* JADX INFO: renamed from: P */
    public ResourceLocation m6042P() {
        return this.f5754fN;
    }

    @NotNull
    /* JADX INFO: renamed from: Q */
    public ResourceLocation m6043Q() {
        return this.f5755fO;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, f5750dd, 0, this::m6044a));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState m6044a(@NotNull AnimationState<C1095tv> animationState) {
        AnimationController<T> controller = animationState.getController();
        if (controller.getAnimationState() == AnimationController.State.STOPPED) {
            controller.forceAnimationReset();
            controller.stop();
            animationState.setAnimation(RawAnimation.begin().then(("animation." + this.f5752de + ".") + "idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f5751b;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }
}
