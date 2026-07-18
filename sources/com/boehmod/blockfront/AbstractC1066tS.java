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

/* JADX INFO: renamed from: com.boehmod.blockfront.tS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tS.class */
public abstract class AbstractC1066tS extends AbstractC1062tO<AbstractC1066tS> {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AnimatableInstanceCache f5632c;

    /* JADX INFO: renamed from: bW */
    @NotNull
    private final List<String> f5633bW;

    /* JADX INFO: renamed from: dh */
    @NotNull
    private final String f5634dh;

    /* JADX INFO: renamed from: hD */
    static final /* synthetic */ boolean f5635hD;

    static {
        f5635hD = !AbstractC1066tS.class.desiredAssertionStatus();
    }

    public AbstractC1066tS(@NotNull String str, @NotNull String str2, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f5632c = GeckoLibUtil.createInstanceCache(this);
        this.f5633bW = new ObjectArrayList();
        this.f5634dh = str2;
    }

    /* JADX INFO: renamed from: q */
    public void m5961q(@NotNull String str) {
        this.f5633bW.add(str);
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo5944a(@NotNull SoundKeyframeEvent<AbstractC1066tS> soundKeyframeEvent) {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0031. Please report as an issue. */
    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo5945b(@NotNull CustomInstructionKeyframeEvent<AbstractC1066tS> customInstructionKeyframeEvent) {
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
            C0415hE.m1958f(instructions);
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this.f5634dh, 0, this::mo5943a).setSoundKeyframeHandler(this::mo5944a).setCustomInstructionKeyframeHandler(this::mo5945b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f5632c;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState mo5943a(@NotNull AnimationState<AbstractC1066tS> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAt = ((AbstractC1066tS) animationState.getAnimatable()).m5942at();
        if (((ItemStack) animationState.getData(DataTickets.ITEMSTACK)) == null) {
            return PlayState.STOP;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f5635hD && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zDk = ((C0326fV) c0622lM2667b.m2670a()).m1675a(minecraft).m1087dk();
        String str = "animation." + strAt + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.f5633bW.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            for (String str2 : this.f5633bW) {
                if (!str2.contains("fire")) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                }
            }
            this.f5633bW.clear();
            rawAnimationBegin.thenPlayAndHold(str + "idle");
            animationState.resetCurrentAnimation();
            animationState.setAnimation(rawAnimationBegin);
        } else if (controller.getAnimationState() == AnimationController.State.STOPPED || zDk) {
            animationState.resetCurrentAnimation();
            animationState.setAnimation(RawAnimation.begin().thenPlayAndHold(str + "idle"));
        }
        return PlayState.CONTINUE;
    }
}
