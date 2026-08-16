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

/* JADX INFO: renamed from: com.boehmod.blockfront.tT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tT.class */
public class C1068tT extends C1136ui implements GeoItem {

    /* JADX INFO: renamed from: do */
    @NotNull
    private static final String f5803do = "gui_controller";

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AnimatableInstanceCache f5804b;

    /* JADX INFO: renamed from: dp */
    @NotNull
    private final String f5805dp;

    /* JADX INFO: renamed from: fL */
    @NotNull
    private final ResourceLocation f5806fL;

    /* JADX INFO: renamed from: fM */
    @NotNull
    private final ResourceLocation f5807fM;

    /* JADX INFO: renamed from: fN */
    @NotNull
    private final ResourceLocation f5808fN;

    public C1068tT(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f5804b = GeckoLibUtil.createInstanceCache(this);
        this.f5805dp = str;
        this.f5806fL = C0532jO.m2378d("textures/item/" + this.f5805dp + ".png");
        this.f5807fM = C0532jO.m2378d("animations/item/" + this.f5805dp + ".animation.json");
        this.f5808fN = C0532jO.m2378d("geo/item/" + this.f5805dp + ".geo.json");
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.tT.1

            /* JADX INFO: renamed from: a */
            private C0449hl f5809a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.f5809a == null) {
                    this.f5809a = new C0449hl(this);
                }
                return this.f5809a;
            }
        });
    }

    @NotNull
    /* JADX INFO: renamed from: P */
    public ResourceLocation m5927P() {
        return this.f5806fL;
    }

    @NotNull
    /* JADX INFO: renamed from: Q */
    public ResourceLocation m5928Q() {
        return this.f5807fM;
    }

    @NotNull
    /* JADX INFO: renamed from: R */
    public ResourceLocation m5929R() {
        return this.f5808fN;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, f5803do, 0, this::m5930a));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState m5930a(@NotNull AnimationState<C1068tT> animationState) {
        AnimationController<T> controller = animationState.getController();
        if (controller.getAnimationState() == AnimationController.State.STOPPED) {
            controller.forceAnimationReset();
            controller.stop();
            animationState.setAnimation(RawAnimation.begin().then(("animation." + this.f5805dp + ".") + "idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f5804b;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }
}
