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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tG.class */
public class tG extends Item {
    public static final double aH = 64.0d;

    public tG(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tG$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {

        @Nullable
        private static UUID E = null;

        private a() {
        }

        @Nullable
        public static UUID j() {
            return E;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void e(@NotNull Player player) {
            if (E != null) {
                sY sYVarB = b();
                if (sYVarB == null) {
                    return;
                }
                pA pAVarA = sYVarB.a(E);
                if (!(pAVarA instanceof pJ)) {
                    dj();
                    return;
                }
                pJ pJVar = (pJ) pAVarA;
                Vec3 eyePosition = player.getEyePosition(1.0f);
                BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, eyePosition.add(player.getViewVector(1.0f).scale(64.0d)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
                if (blockHitResultClip.getType() == HitResult.Type.MISS) {
                    a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
                    return;
                }
                pJVar.g(blockHitResultClip.getLocation().subtract(pAVarA.c).normalize());
                C0582vo.c(new vP(E, pJVar.aO(), pJVar.aP(), pJVar.aQ()));
                dj();
                a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            pA pAVarA2 = a(player);
            if (pAVarA2 == null) {
                return;
            }
            E = pAVarA2.y;
            a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        public static void di() {
            if (E == null) {
                return;
            }
            dj();
            a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        private static void dj() {
            E = null;
        }

        @Nullable
        private static pA a(@NotNull Player player) {
            sY sYVarB = b();
            if (sYVarB == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            pA pAVar = null;
            double d = Double.MAX_VALUE;
            for (pA pAVar2 : sYVarB.ax()) {
                if (pAVar2 instanceof pJ) {
                    Optional optionalClip = pAVar2.i().clip(eyePosition, vec3Add);
                    if (!optionalClip.isEmpty()) {
                        double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                        if (dDistanceToSqr < d) {
                            d = dDistanceToSqr;
                            pAVar = pAVar2;
                        }
                    }
                }
            }
            return pAVar;
        }

        private static void a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        private static sY b() {
            oF<?, ?, ?> oFVarM591a;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof C0297l) || (oFVarM591a = ((C0297l) abstractC0264juM166a).m591a()) == null) {
                return null;
            }
            return oFVarM591a.m767a();
        }
    }
}
