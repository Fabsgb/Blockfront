package com.boehmod.blockfront;

import java.util.Optional;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ue */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ue.class */
public class C1132ue extends Item {

    /* JADX INFO: renamed from: aU */
    public static final double f6210aU = 64.0d;

    public C1132ue(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.m6497e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ue$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ue$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {

        /* JADX INFO: renamed from: F */
        @Nullable
        private static UUID f6211F = null;

        private a() {
        }

        @Nullable
        /* JADX INFO: renamed from: j */
        public static UUID m6496j() {
            return f6211F;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: e */
        public static void m6497e(@NotNull Player player) {
            if (f6211F != null) {
                C1096tv c1096tvM6502b = m6502b();
                if (c1096tvM6502b == null) {
                    return;
                }
                AbstractC0858pW abstractC0858pWM6096a = c1096tvM6502b.m6096a(f6211F);
                if (!(abstractC0858pWM6096a instanceof InterfaceC0920qf)) {
                    m6499dv();
                    return;
                }
                InterfaceC0920qf interfaceC0920qf = (InterfaceC0920qf) abstractC0858pWM6096a;
                Vec3 eyePosition = player.getEyePosition(1.0f);
                BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, eyePosition.add(player.getViewVector(1.0f).scale(64.0d)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
                if (blockHitResultClip.getType() == HitResult.Type.MISS) {
                    m6501a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
                    return;
                }
                interfaceC0920qf.mo4686g(blockHitResultClip.getLocation().subtract(abstractC0858pWM6096a.f4593c).normalize());
                C1169vO.m6648c(new C1249wp(f6211F, interfaceC0920qf.mo4682aU(), interfaceC0920qf.mo4683aV(), interfaceC0920qf.mo4684aW()));
                m6499dv();
                m6501a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            AbstractC0858pW abstractC0858pWM6500a = m6500a(player);
            if (abstractC0858pWM6500a == null) {
                return;
            }
            f6211F = abstractC0858pWM6500a.f4592y;
            m6501a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        /* JADX INFO: renamed from: du */
        public static void m6498du() {
            if (f6211F == null) {
                return;
            }
            m6499dv();
            m6501a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: dv */
        private static void m6499dv() {
            f6211F = null;
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static AbstractC0858pW m6500a(@NotNull Player player) {
            C1096tv c1096tvM6502b = m6502b();
            if (c1096tvM6502b == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            AbstractC0858pW abstractC0858pW = null;
            double d = Double.MAX_VALUE;
            for (AbstractC0858pW abstractC0858pW2 : c1096tvM6502b.m6107az()) {
                if (abstractC0858pW2 instanceof InterfaceC0920qf) {
                    Optional optionalClip = abstractC0858pW2.m3950i().clip(eyePosition, vec3Add);
                    if (!optionalClip.isEmpty()) {
                        double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                        if (dDistanceToSqr < d) {
                            d = dDistanceToSqr;
                            abstractC0858pW = abstractC0858pW2;
                        }
                    }
                }
            }
            return abstractC0858pW;
        }

        /* JADX INFO: renamed from: a */
        private static void m6501a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static C1096tv m6502b() {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C0623l) || (abstractC0863pbM2874a = ((C0623l) abstractC0531jNM179a).m2874a()) == null) {
                return null;
            }
            return abstractC0863pbM2874a.m4089a();
        }
    }
}
