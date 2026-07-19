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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tS.class */
public abstract class tS extends tO<tS> {

    @NotNull
    private final AnimatableInstanceCache c;

    @NotNull
    private final List<String> bW;

    @NotNull
    private final String dh;
    static final /* synthetic */ boolean hD;

    static {
        hD = !tS.class.desiredAssertionStatus();
    }

    public tS(@NotNull String str, @NotNull String str2, @NotNull Item.Properties properties) {
        super(str, properties);
        this.c = GeckoLibUtil.createInstanceCache(this);
        this.bW = new ObjectArrayList();
        this.dh = str2;
    }

    public void q(@NotNull String str) {
        this.bW.add(str);
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull SoundKeyframeEvent<tS> soundKeyframeEvent) {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0031. Please report as an issue. */
    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull CustomInstructionKeyframeEvent<tS> customInstructionKeyframeEvent) {
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
            hE.f(instructions);
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this.dh, 0, this::a).setSoundKeyframeHandler(this::a).setCustomInstructionKeyframeHandler(this::b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.c;
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected PlayState a(@NotNull AnimationState<tS> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAt = ((tS) animationState.getAnimatable()).at();
        if (((ItemStack) animationState.getData(DataTickets.ITEMSTACK)) == null) {
            return PlayState.STOP;
        }
        C0297l c0297lB = C0297l.b();
        if (!hD && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zDk = ((fV) c0297lB.a()).a(minecraft).dk();
        String str = "animation." + strAt + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.bW.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            for (String str2 : this.bW) {
                if (!str2.contains("fire")) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                }
            }
            this.bW.clear();
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
