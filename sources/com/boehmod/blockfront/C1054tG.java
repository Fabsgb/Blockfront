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

/* JADX INFO: renamed from: com.boehmod.blockfront.tG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tG.class */
public class C1054tG extends Item {

    /* JADX INFO: renamed from: aH */
    public static final double f5571aH = 64.0d;

    public C1054tG(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.m5861e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tG$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tG$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {

        /* JADX INFO: renamed from: E */
        @Nullable
        private static UUID f5572E = null;

        private a() {
        }

        @Nullable
        /* JADX INFO: renamed from: j */
        public static UUID m5860j() {
            return f5572E;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: e */
        public static void m5861e(@NotNull Player player) {
            if (f5572E != null) {
                C1018sY c1018sYM5866b = m5866b();
                if (c1018sYM5866b == null) {
                    return;
                }
                AbstractC0835pA abstractC0835pAM5608a = c1018sYM5866b.m5608a(f5572E);
                if (!(abstractC0835pAM5608a instanceof InterfaceC0844pJ)) {
                    m5863dj();
                    return;
                }
                InterfaceC0844pJ interfaceC0844pJ = (InterfaceC0844pJ) abstractC0835pAM5608a;
                Vec3 eyePosition = player.getEyePosition(1.0f);
                BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, eyePosition.add(player.getViewVector(1.0f).scale(64.0d)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
                if (blockHitResultClip.getType() == HitResult.Type.MISS) {
                    m5865a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
                    return;
                }
                interfaceC0844pJ.mo4275g(blockHitResultClip.getLocation().subtract(abstractC0835pAM5608a.f4464c).normalize());
                C1194vo.m6653c(new C1169vP(f5572E, interfaceC0844pJ.mo4271aO(), interfaceC0844pJ.mo4272aP(), interfaceC0844pJ.mo4273aQ()));
                m5863dj();
                m5865a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            AbstractC0835pA abstractC0835pAM5864a = m5864a(player);
            if (abstractC0835pAM5864a == null) {
                return;
            }
            f5572E = abstractC0835pAM5864a.f4463y;
            m5865a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        /* JADX INFO: renamed from: di */
        public static void m5862di() {
            if (f5572E == null) {
                return;
            }
            m5863dj();
            m5865a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: dj */
        private static void m5863dj() {
            f5572E = null;
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static AbstractC0835pA m5864a(@NotNull Player player) {
            C1018sY c1018sYM5866b = m5866b();
            if (c1018sYM5866b == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            AbstractC0835pA abstractC0835pA = null;
            double d = Double.MAX_VALUE;
            for (AbstractC0835pA abstractC0835pA2 : c1018sYM5866b.m5619ax()) {
                if (abstractC0835pA2 instanceof InterfaceC0844pJ) {
                    Optional optionalClip = abstractC0835pA2.m4215i().clip(eyePosition, vec3Add);
                    if (!optionalClip.isEmpty()) {
                        double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                        if (dDistanceToSqr < d) {
                            d = dDistanceToSqr;
                            abstractC0835pA = abstractC0835pA2;
                        }
                    }
                }
            }
            return abstractC0835pA;
        }

        /* JADX INFO: renamed from: a */
        private static void m5865a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static C1018sY m5866b() {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C0622l) || (abstractC0787oFM2688a = ((C0622l) abstractC0563juM168a).m2688a()) == null) {
                return null;
            }
            return abstractC0787oFM2688a.m3653a();
        }
    }
}
