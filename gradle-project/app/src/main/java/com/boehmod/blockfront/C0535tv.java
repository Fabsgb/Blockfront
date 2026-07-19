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

/* JADX INFO: renamed from: com.boehmod.blockfront.tv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tv.class */
public class C0535tv extends tK implements GeoItem {

    @NotNull
    private static final String dd = "gui_controller";

    @NotNull
    private final AnimatableInstanceCache b;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    @NotNull
    private final String f421de;

    @NotNull
    private final ResourceLocation fM;

    @NotNull
    private final ResourceLocation fN;

    @NotNull
    private final ResourceLocation fO;

    public C0535tv(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.b = GeckoLibUtil.createInstanceCache(this);
        this.f421de = str;
        this.fM = C0265jv.d("textures/item/" + this.f421de + ".png");
        this.fN = C0265jv.d("animations/item/" + this.f421de + ".animation.json");
        this.fO = C0265jv.d("geo/item/" + this.f421de + ".geo.json");
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.tv.1
            private gV a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new gV(this);
                }
                return this.a;
            }
        });
    }

    @NotNull
    public ResourceLocation O() {
        return this.fM;
    }

    @NotNull
    public ResourceLocation P() {
        return this.fN;
    }

    @NotNull
    public ResourceLocation Q() {
        return this.fO;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, dd, 0, this::a));
    }

    @OnlyIn(Dist.CLIENT)
    protected PlayState a(@NotNull AnimationState<C0535tv> animationState) {
        AnimationController<T> controller = animationState.getController();
        if (controller.getAnimationState() == AnimationController.State.STOPPED) {
            controller.forceAnimationReset();
            controller.stop();
            animationState.setAnimation(RawAnimation.begin().then(("animation." + this.f421de + ".") + "idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }
}
