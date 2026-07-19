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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lN.class */
public class lN extends BlockEntity implements GeoBlockEntity {

    @NotNull
    private static final String bp = "block_controller";

    @NotNull
    private final AnimatableInstanceCache a;

    @NotNull
    private final List<String> aa;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private AbstractC0376ny f231a;

    @Nullable
    private String bq;

    @Nullable
    private ResourceLocation dk;

    @Nullable
    private Vec3 F;

    @NotNull
    private final List<SoundInstance> ab;
    private float hx;
    private boolean dW;
    private boolean dX;

    @NotNull
    private final ThreadLocal<AnimatableInstanceCache> f;

    public lN(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.aa = new ObjectArrayList();
        this.f231a = null;
        this.bq = null;
        this.dk = null;
        this.F = null;
        this.ab = new ObjectArrayList();
        this.hx = 0.0f;
        this.dW = false;
        this.dX = false;
        this.f = new ThreadLocal<>();
    }

    public void bq() {
        this.dW = true;
    }

    public void br() {
        this.dX = true;
    }

    public boolean am() {
        return this.dW || this.f231a != null;
    }

    public boolean an() {
        return this.dX;
    }

    @Nullable
    public AbstractC0376ny a() {
        return this.f231a;
    }

    public void a(@NotNull AbstractC0376ny abstractC0376ny) {
        this.f231a = abstractC0376ny;
    }

    public void p(@NotNull String str) {
        this.bq = str;
    }

    public void c(@NotNull Vec3 vec3) {
        this.F = vec3;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull SoundInstance soundInstance) {
        this.ab.add(soundInstance);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public List<SoundInstance> q() {
        return this.ab;
    }

    public void b(@NotNull ResourceLocation resourceLocation) {
        this.dk = resourceLocation;
    }

    public float af() {
        return 0.0f;
    }

    @Nullable
    public ResourceLocation n() {
        return this.dk;
    }

    public void q(@NotNull String str) {
        this.aa.add(str);
    }

    public float ag() {
        return this.hx;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public <E extends BlockEntity & GeoAnimatable> PlayState a(@NotNull AnimationState<E> animationState) {
        if (this.hx > 0.0f) {
            this.hx -= animationState.getPartialTick();
        }
        AnimationController<T> controller = animationState.getController();
        String path = BuiltInRegistries.BLOCK.getKey(animationState.getAnimatable().getBlockState().getBlock()).getPath();
        String str = this.bq != null ? this.bq : "idle";
        if (!this.aa.isEmpty()) {
            controller.forceAnimationReset();
            controller.stop();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            Iterator<String> it = this.aa.iterator();
            while (it.hasNext()) {
                rawAnimationBegin.then("animation." + path + "." + it.next(), Animation.LoopType.PLAY_ONCE);
            }
            this.aa.clear();
            rawAnimationBegin.then("animation." + path + "." + str, Animation.LoopType.LOOP);
            animationState.setAnimation(rawAnimationBegin);
        }
        if (controller.getAnimationState() == AnimationController.State.STOPPED) {
            controller.setAnimation(RawAnimation.begin().thenLoop("animation." + path + "." + str));
        }
        return PlayState.CONTINUE;
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull CustomInstructionKeyframeEvent<lN> customInstructionKeyframeEvent) {
        Supplier<SoundEvent> supplierD;
        Supplier<SoundEvent> supplierD2;
        String instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        if (instructions.contains("fire;")) {
            this.hx = 5.0f;
        }
        if (instructions.startsWith("pshake(") && instructions.endsWith(");") && this.F != null) {
            hE.a(instructions, this.F);
        }
        if (instructions.startsWith("explosion(") && instructions.endsWith(");") && this.F != null) {
            C0345mu.b(instructions, Vec3.ZERO);
        }
        if (instructions.startsWith("sound(") && instructions.endsWith(");") && this.F != null) {
            String[] strArrSplit = instructions.substring(6, instructions.length() - 2).split(",");
            if (strArrSplit.length >= 1 && (supplierD2 = C0636xo.d(strArrSplit[0].trim())) != null) {
                float f = strArrSplit.length >= 2 ? Float.parseFloat(strArrSplit[1].trim()) : 1.0f;
                float f2 = strArrSplit.length >= 3 ? Float.parseFloat(strArrSplit[2].trim()) : 1.0f;
                SoundManager soundManager = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance(supplierD2.get(), SoundSource.AMBIENT, f, f2, RandomSource.create(), this.F.x, this.F.y, this.F.z);
                soundManager.play(simpleSoundInstance);
                a((SoundInstance) simpleSoundInstance);
            }
        }
        if (instructions.startsWith("positionedSound(") && instructions.endsWith(");")) {
            String[] strArrSplit2 = instructions.substring(16, instructions.length() - 2).split(",");
            if (strArrSplit2.length >= 4 && (supplierD = C0636xo.d(strArrSplit2[0].trim())) != null) {
                float f3 = Float.parseFloat(strArrSplit2[1].trim());
                float f4 = Float.parseFloat(strArrSplit2[2].trim());
                float f5 = Float.parseFloat(strArrSplit2[3].trim());
                float f6 = strArrSplit2.length >= 5 ? Float.parseFloat(strArrSplit2[4].trim()) : 1.0f;
                float f7 = strArrSplit2.length >= 6 ? Float.parseFloat(strArrSplit2[5].trim()) : 1.0f;
                SoundManager soundManager2 = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance(supplierD.get(), SoundSource.AMBIENT, f6, f7, RandomSource.create(), f3, f4, f5);
                a((SoundInstance) simpleSoundInstance2);
                soundManager2.play(simpleSoundInstance2);
            }
        }
        if (instructions.startsWith("enableEffect(") && instructions.endsWith(");")) {
            String strTrim = instructions.substring(13, instructions.length() - 2).trim();
            C0297l c0297lA = C0056c.a();
            if (c0297lA != null && c0297lA.m591a() != null) {
                c0297lA.m591a().m767a().a(strTrim, true);
            }
        }
        if (instructions.startsWith("disableEffect(") && instructions.endsWith(");")) {
            String strTrim2 = instructions.substring(14, instructions.length() - 2).trim();
            C0297l c0297lA2 = C0056c.a();
            if (c0297lA2 != null && c0297lA2.m591a() != null) {
                c0297lA2.m591a().m767a().a(strTrim2, false);
            }
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, bp, (AnimationController.AnimationStateHandler<lN>) this::a).setCustomInstructionKeyframeHandler(this::a));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        if (!am()) {
            AnimatableInstanceCache animatableInstanceCache = this.f.get();
            if (animatableInstanceCache == null) {
                ThreadLocal<AnimatableInstanceCache> threadLocal = this.f;
                AnimatableInstanceCache animatableInstanceCacheCreateInstanceCache = GeckoLibUtil.createInstanceCache(this);
                animatableInstanceCache = animatableInstanceCacheCreateInstanceCache;
                threadLocal.set(animatableInstanceCacheCreateInstanceCache);
            }
            return animatableInstanceCache;
        }
        return this.a;
    }
}
