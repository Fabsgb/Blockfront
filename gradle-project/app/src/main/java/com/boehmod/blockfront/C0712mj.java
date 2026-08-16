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

/* JADX INFO: renamed from: com.boehmod.blockfront.mj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mj.class */
public class C0712mj extends BlockEntity implements GeoBlockEntity {

    /* JADX INFO: renamed from: by */
    @NotNull
    private static final String f3959by = "block_controller";

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AnimatableInstanceCache f3960a;

    /* JADX INFO: renamed from: ah */
    @NotNull
    private final List<String> f3961ah;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0750nU f3962a;

    /* JADX INFO: renamed from: bz */
    @Nullable
    private String f3963bz;

    /* JADX INFO: renamed from: dk */
    @Nullable
    private ResourceLocation f3964dk;

    /* JADX INFO: renamed from: G */
    @Nullable
    private Vec3 f3965G;

    /* JADX INFO: renamed from: ai */
    @NotNull
    private final List<SoundInstance> f3966ai;

    /* JADX INFO: renamed from: ip */
    private float f3967ip;

    /* JADX INFO: renamed from: ep */
    private boolean f3968ep;

    /* JADX INFO: renamed from: eq */
    private boolean f3969eq;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final ThreadLocal<AnimatableInstanceCache> f3970f;

    public C0712mj(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3960a = GeckoLibUtil.createInstanceCache(this);
        this.f3961ah = new ObjectArrayList();
        this.f3962a = null;
        this.f3963bz = null;
        this.f3964dk = null;
        this.f3965G = null;
        this.f3966ai = new ObjectArrayList();
        this.f3967ip = 0.0f;
        this.f3968ep = false;
        this.f3969eq = false;
        this.f3970f = new ThreadLocal<>();
    }

    /* JADX INFO: renamed from: bB */
    public void m3236bB() {
        this.f3968ep = true;
    }

    /* JADX INFO: renamed from: bC */
    public void m3237bC() {
        this.f3969eq = true;
    }

    /* JADX INFO: renamed from: aw */
    public boolean mo3235aw() {
        return this.f3968ep || this.f3962a != null;
    }

    /* JADX INFO: renamed from: ax */
    public boolean m3238ax() {
        return this.f3969eq;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0750nU m3239a() {
        return this.f3962a;
    }

    /* JADX INFO: renamed from: a */
    public void m3240a(@NotNull AbstractC0750nU abstractC0750nU) {
        this.f3962a = abstractC0750nU;
    }

    /* JADX INFO: renamed from: p */
    public void m3241p(@NotNull String str) {
        this.f3963bz = str;
    }

    /* JADX INFO: renamed from: c */
    public void m3242c(@NotNull Vec3 vec3) {
        this.f3965G = vec3;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3243a(@NotNull SoundInstance soundInstance) {
        this.f3966ai.add(soundInstance);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: s */
    public List<SoundInstance> m3244s() {
        return this.f3966ai;
    }

    /* JADX INFO: renamed from: f */
    public void m3245f(@NotNull ResourceLocation resourceLocation) {
        this.f3964dk = resourceLocation;
    }

    /* JADX INFO: renamed from: al */
    public float mo3246al() {
        return 0.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: o */
    public ResourceLocation m3247o() {
        return this.f3964dk;
    }

    /* JADX INFO: renamed from: q */
    public void m3248q(@NotNull String str) {
        this.f3961ah.add(str);
    }

    /* JADX INFO: renamed from: am */
    public float m3249am() {
        return this.f3967ip;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public <E extends BlockEntity & GeoAnimatable> PlayState mo3250a(@NotNull AnimationState<E> animationState) {
        if (this.f3967ip > 0.0f) {
            this.f3967ip -= animationState.getPartialTick();
        }
        AnimationController<T> controller = animationState.getController();
        String path = BuiltInRegistries.BLOCK.getKey(animationState.getAnimatable().getBlockState().getBlock()).getPath();
        String str = this.f3963bz != null ? this.f3963bz : "idle";
        if (!this.f3961ah.isEmpty()) {
            controller.forceAnimationReset();
            controller.stop();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            Iterator<String> it = this.f3961ah.iterator();
            while (it.hasNext()) {
                rawAnimationBegin.then("animation." + path + "." + it.next(), Animation.LoopType.PLAY_ONCE);
            }
            this.f3961ah.clear();
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
    protected void m3251a(@NotNull CustomInstructionKeyframeEvent<C0712mj> customInstructionKeyframeEvent) {
        Supplier<SoundEvent> supplierM7215d;
        Supplier<SoundEvent> supplierM7215d2;
        String instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        if (instructions.contains("fire;")) {
            this.f3967ip = 5.0f;
        }
        if (instructions.startsWith("pshake(") && instructions.endsWith(");") && this.f3965G != null) {
            C0432hU.m1985a(instructions, this.f3965G);
        }
        if (instructions.startsWith("explosion(") && instructions.endsWith(");") && this.f3965G != null) {
            C0693mQ.m3102b(instructions, Vec3.ZERO);
        }
        if (instructions.startsWith("sound(") && instructions.endsWith(");") && this.f3965G != null) {
            String[] strArrSplit = instructions.substring(6, instructions.length() - 2).split(",");
            if (strArrSplit.length >= 1 && (supplierM7215d2 = C1272xL.m7215d(strArrSplit[0].trim())) != null) {
                float f = strArrSplit.length >= 2 ? Float.parseFloat(strArrSplit[1].trim()) : 1.0f;
                float f2 = strArrSplit.length >= 3 ? Float.parseFloat(strArrSplit[2].trim()) : 1.0f;
                SoundManager soundManager = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance(supplierM7215d2.get(), SoundSource.AMBIENT, f, f2, RandomSource.create(), this.f3965G.x, this.f3965G.y, this.f3965G.z);
                soundManager.play(simpleSoundInstance);
                m3243a((SoundInstance) simpleSoundInstance);
            }
        }
        if (instructions.startsWith("positionedSound(") && instructions.endsWith(");")) {
            String[] strArrSplit2 = instructions.substring(16, instructions.length() - 2).split(",");
            if (strArrSplit2.length >= 4 && (supplierM7215d = C1272xL.m7215d(strArrSplit2[0].trim())) != null) {
                float f3 = Float.parseFloat(strArrSplit2[1].trim());
                float f4 = Float.parseFloat(strArrSplit2[2].trim());
                float f5 = Float.parseFloat(strArrSplit2[3].trim());
                float f6 = strArrSplit2.length >= 5 ? Float.parseFloat(strArrSplit2[4].trim()) : 1.0f;
                float f7 = strArrSplit2.length >= 6 ? Float.parseFloat(strArrSplit2[5].trim()) : 1.0f;
                SoundManager soundManager2 = Minecraft.getInstance().getSoundManager();
                SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance(supplierM7215d.get(), SoundSource.AMBIENT, f6, f7, RandomSource.create(), f3, f4, f5);
                m3243a((SoundInstance) simpleSoundInstance2);
                soundManager2.play(simpleSoundInstance2);
            }
        }
        if (instructions.startsWith("enableEffect(") && instructions.endsWith(");")) {
            String strTrim = instructions.substring(13, instructions.length() - 2).trim();
            C0623l c0623lM740a = C0136c.m740a();
            if (c0623lM740a != null && c0623lM740a.m2874a() != null) {
                c0623lM740a.m2874a().m4089a().m6095a(strTrim, true);
            }
        }
        if (instructions.startsWith("disableEffect(") && instructions.endsWith(");")) {
            String strTrim2 = instructions.substring(14, instructions.length() - 2).trim();
            C0623l c0623lM740a2 = C0136c.m740a();
            if (c0623lM740a2 != null && c0623lM740a2.m2874a() != null) {
                c0623lM740a2.m2874a().m4089a().m6095a(strTrim2, false);
            }
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, f3959by, (AnimationController.AnimationStateHandler<C0712mj>) this::mo3250a).setCustomInstructionKeyframeHandler(this::m3251a));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        if (!mo3235aw()) {
            AnimatableInstanceCache animatableInstanceCache = this.f3970f.get();
            if (animatableInstanceCache == null) {
                ThreadLocal<AnimatableInstanceCache> threadLocal = this.f3970f;
                AnimatableInstanceCache animatableInstanceCacheCreateInstanceCache = GeckoLibUtil.createInstanceCache(this);
                animatableInstanceCache = animatableInstanceCacheCreateInstanceCache;
                threadLocal.set(animatableInstanceCacheCreateInstanceCache);
            }
            return animatableInstanceCache;
        }
        return this.f3960a;
    }
}
