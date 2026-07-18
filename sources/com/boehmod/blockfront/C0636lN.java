package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.lN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lN.class */
public class C0636lN extends BlockEntity implements GeoBlockEntity {

    /* JADX INFO: renamed from: bp */
    @NotNull
    private static final String f3485bp = "block_controller";

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AnimatableInstanceCache f3486a;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private final List<String> f3487aa;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0779ny f3488a;

    /* JADX INFO: renamed from: bq */
    @Nullable
    private String f3489bq;

    /* JADX INFO: renamed from: dk */
    @Nullable
    private ResourceLocation f3490dk;

    /* JADX INFO: renamed from: F */
    @Nullable
    private Vec3 f3491F;

    /* JADX INFO: renamed from: ab */
    @NotNull
    private final List<SoundInstance> f3492ab;

    /* JADX INFO: renamed from: hx */
    private float f3493hx;

    /* JADX INFO: renamed from: dW */
    private boolean f3494dW;

    /* JADX INFO: renamed from: dX */
    private boolean f3495dX;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final ThreadLocal<AnimatableInstanceCache> f3496f;

    public C0636lN(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3486a = GeckoLibUtil.createInstanceCache(this);
        this.f3487aa = new ObjectArrayList();
        this.f3488a = null;
        this.f3489bq = null;
        this.f3490dk = null;
        this.f3491F = null;
        this.f3492ab = new ObjectArrayList();
        this.f3493hx = 0.0f;
        this.f3494dW = false;
        this.f3495dX = false;
        this.f3496f = new ThreadLocal<>();
    }

    /* JADX INFO: renamed from: bq */
    public void m2805bq() {
        this.f3494dW = true;
    }

    /* JADX INFO: renamed from: br */
    public void m2806br() {
        this.f3495dX = true;
    }

    /* JADX INFO: renamed from: am */
    public boolean mo2804am() {
        return this.f3494dW || this.f3488a != null;
    }

    /* JADX INFO: renamed from: an */
    public boolean m2807an() {
        return this.f3495dX;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0779ny m2808a() {
        return this.f3488a;
    }

    /* JADX INFO: renamed from: a */
    public void m2809a(@NotNull AbstractC0779ny abstractC0779ny) {
        this.f3488a = abstractC0779ny;
    }

    /* JADX INFO: renamed from: p */
    public void m2810p(@NotNull String str) {
        this.f3489bq = str;
    }

    /* JADX INFO: renamed from: c */
    public void m2811c(@NotNull Vec3 vec3) {
        this.f3491F = vec3;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m2812a(@NotNull SoundInstance soundInstance) {
        this.f3492ab.add(soundInstance);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: q */
    public List<SoundInstance> m2813q() {
        return this.f3492ab;
    }

    /* JADX INFO: renamed from: b */
    public void m2814b(@NotNull ResourceLocation resourceLocation) {
        this.f3490dk = resourceLocation;
    }

    /* JADX INFO: renamed from: af */
    public float mo2815af() {
        return 0.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: n */
    public ResourceLocation m2816n() {
        return this.f3490dk;
    }

    /* JADX INFO: renamed from: q */
    public void m2817q(@NotNull String str) {
        this.f3487aa.add(str);
    }

    /* JADX INFO: renamed from: ag */
    public float m2818ag() {
        return this.f3493hx;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public <E extends BlockEntity & GeoAnimatable> PlayState mo2819a(@NotNull AnimationState<E> animationState) {
        if (this.f3493hx > 0.0f) {
            this.f3493hx -= animationState.getPartialTick();
        }
        AnimationController<T> controller = animationState.getController();
        String path = BuiltInRegistries.BLOCK.getKey(animationState.getAnimatable().getBlockState().getBlock()).getPath();
        String str = this.f3489bq != null ? this.f3489bq : "idle";
        if (!this.f3487aa.isEmpty()) {
            controller.forceAnimationReset();
            controller.stop();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            Iterator<String> it = this.f3487aa.iterator();
            while (it.hasNext()) {
                rawAnimationBegin.then("animation." + path + "." + it.next(), Animation.LoopType.PLAY_ONCE);
            }
            this.f3487aa.clear();
            rawAnimationBegin.then("animation." + path + "." + str, Animation.LoopType.LOOP);
            animationState.setAnimation(rawAnimationBegin);
        }
        if (controller.getAnimationState() == AnimationController.State.STOPPED) {
            controller.setAnimation(RawAnimation.begin().thenLoop("animation." + path + "." + str));
        }
        return PlayState.CONTINUE;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void m2820a(@NotNull CustomInstructionKeyframeEvent<C0636lN> customInstructionKeyframeEvent) {
        Supplier<SoundEvent> supplierM7888d;
        Supplier<SoundEvent> supplierM7888d2;
        String instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        if (instructions.contains("fire;")) {
            this.f3493hx = 5.0f;
        }
        if (instructions.startsWith("pshake(") && instructions.endsWith(");") && this.f3491F != null) {
            C0415hE.m1959a(instructions, this.f3491F);
        }
        if (instructions.startsWith("explosion(") && instructions.endsWith(");") && this.f3491F != null) {
            C0722mu.m3268b(instructions, Vec3.ZERO);
        }
        if (instructions.startsWith("sound(") && instructions.endsWith(");") && this.f3491F != null) {
            String[] strArrSplit = instructions.substring(6, instructions.length() - 2).split(",");
            if (strArrSplit.length >= 1 && (supplierM7888d2 = C1292xo.m7888d(strArrSplit[0].trim())) != null) {
                float f = strArrSplit.length >= 2 ? Float.parseFloat(strArrSplit[1].trim()) : 1.0f;
                float f2 = strArrSplit.length >= 3 ? Float.parseFloat(strArrSplit[2].trim()) : 1.0f;
                SoundManager soundManager = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance(supplierM7888d2.get(), SoundSource.AMBIENT, f, f2, RandomSource.create(), this.f3491F.x, this.f3491F.y, this.f3491F.z);
                soundManager.play(simpleSoundInstance);
                m2812a((SoundInstance) simpleSoundInstance);
            }
        }
        if (instructions.startsWith("positionedSound(") && instructions.endsWith(");")) {
            String[] strArrSplit2 = instructions.substring(16, instructions.length() - 2).split(",");
            if (strArrSplit2.length >= 4 && (supplierM7888d = C1292xo.m7888d(strArrSplit2[0].trim())) != null) {
                float f3 = Float.parseFloat(strArrSplit2[1].trim());
                float f4 = Float.parseFloat(strArrSplit2[2].trim());
                float f5 = Float.parseFloat(strArrSplit2[3].trim());
                float f6 = strArrSplit2.length >= 5 ? Float.parseFloat(strArrSplit2[4].trim()) : 1.0f;
                float f7 = strArrSplit2.length >= 6 ? Float.parseFloat(strArrSplit2[5].trim()) : 1.0f;
                SoundManager soundManager2 = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance(supplierM7888d.get(), SoundSource.AMBIENT, f6, f7, RandomSource.create(), f3, f4, f5);
                m2812a((SoundInstance) simpleSoundInstance2);
                soundManager2.play(simpleSoundInstance2);
            }
        }
        if (instructions.startsWith("enableEffect(") && instructions.endsWith(");")) {
            String strTrim = instructions.substring(13, instructions.length() - 2).trim();
            C0622l c0622lM716a = C0135c.m716a();
            if (c0622lM716a != null && c0622lM716a.m2688a() != null) {
                c0622lM716a.m2688a().m3653a().m5607a(strTrim, true);
            }
        }
        if (instructions.startsWith("disableEffect(") && instructions.endsWith(");")) {
            String strTrim2 = instructions.substring(14, instructions.length() - 2).trim();
            C0622l c0622lM716a2 = C0135c.m716a();
            if (c0622lM716a2 != null && c0622lM716a2.m2688a() != null) {
                c0622lM716a2.m2688a().m3653a().m5607a(strTrim2, false);
            }
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, f3485bp, (AnimationController.AnimationStateHandler<C0636lN>) this::mo2819a).setCustomInstructionKeyframeHandler(this::m2820a));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        if (!mo2804am()) {
            AnimatableInstanceCache animatableInstanceCache = this.f3496f.get();
            if (animatableInstanceCache == null) {
                ThreadLocal<AnimatableInstanceCache> threadLocal = this.f3496f;
                AnimatableInstanceCache animatableInstanceCacheCreateInstanceCache = GeckoLibUtil.createInstanceCache(this);
                animatableInstanceCache = animatableInstanceCacheCreateInstanceCache;
                threadLocal.set(animatableInstanceCacheCreateInstanceCache);
            }
            return animatableInstanceCache;
        }
        return this.f3486a;
    }
}
