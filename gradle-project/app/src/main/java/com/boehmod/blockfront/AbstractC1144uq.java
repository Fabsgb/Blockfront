package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.uq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uq.class */
public abstract class AbstractC1144uq extends AbstractC1140um<AbstractC1144uq> {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AnimatableInstanceCache f6271c;

    /* JADX INFO: renamed from: cd */
    @NotNull
    private final List<String> f6272cd;

    /* JADX INFO: renamed from: ds */
    @NotNull
    private final String f6273ds;

    /* JADX INFO: renamed from: hX */
    static final /* synthetic */ boolean f6274hX;

    static {
        f6274hX = !AbstractC1144uq.class.desiredAssertionStatus();
    }

    public AbstractC1144uq(@NotNull String str, @NotNull String str2, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f6271c = GeckoLibUtil.createInstanceCache(this);
        this.f6272cd = new ObjectArrayList();
        this.f6273ds = str2;
    }

    /* JADX INFO: renamed from: q */
    public void m6578q(@NotNull String str) {
        this.f6272cd.add(str);
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo6387a(@NotNull SoundKeyframeEvent<AbstractC1144uq> soundKeyframeEvent) {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0031. Please report as an issue. */
    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo6388b(@NotNull CustomInstructionKeyframeEvent<AbstractC1144uq> customInstructionKeyframeEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        String instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        instructions.hashCode();
        switch (-1) {
        }
        if (instructions.startsWith("shake(") && instructions.endsWith(");")) {
            C0432hU.m1984f(instructions);
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this.f6273ds, 0, this::mo6383a).setSoundKeyframeHandler(this::mo6387a).setCustomInstructionKeyframeHandler(this::mo6388b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f6271c;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState mo6383a(@NotNull AnimationState<AbstractC1144uq> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAA = ((AbstractC1144uq) animationState.getAnimatable()).m6574aA();
        if (((ItemStack) animationState.getData(DataTickets.ITEMSTACK)) == null) {
            return PlayState.STOP;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f6274hX && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zDt = ((C0396gl) c0623lM2852b.m2855a()).m1885a(minecraft).m1104dt();
        String str = "animation." + strAA + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.f6272cd.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            for (String str2 : this.f6272cd) {
                if (!str2.contains("fire")) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                }
            }
            this.f6272cd.clear();
            rawAnimationBegin.thenPlayAndHold(str + "idle");
            animationState.resetCurrentAnimation();
            animationState.setAnimation(rawAnimationBegin);
        } else if (controller.getAnimationState() == AnimationController.State.STOPPED || zDt) {
            animationState.resetCurrentAnimation();
            animationState.setAnimation(RawAnimation.begin().thenPlayAndHold(str + "idle"));
        }
        return PlayState.CONTINUE;
    }
}
