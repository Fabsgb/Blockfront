package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uf.class */
public abstract class AbstractC0546uf extends tK implements tW {
    public static final int rQ = 8;
    static final /* synthetic */ boolean hJ;

    abstract boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Player player, @NotNull Player player2, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, @NotNull Set<UUID> set);

    abstract boolean a(@NotNull Player player, @NotNull Player player2);

    abstract void a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2);

    @NotNull
    abstract Component a(@NotNull Player player);

    @NotNull
    abstract Component a(@NotNull Component component);

    static {
        hJ = !AbstractC0546uf.class.desiredAssertionStatus();
    }

    public AbstractC0546uf(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    protected boolean cj() {
        return false;
    }

    public void b(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        itemStack.shrink(1);
        player.swing(InteractionHand.MAIN_HAND);
        a(itemStack, player, player2);
    }

    @NotNull
    public InteractionResult interactLivingEntity(@NotNull ItemStack itemStack, @NotNull Player player, LivingEntity livingEntity, @NotNull InteractionHand interactionHand) {
        int iAS;
        if (livingEntity.level().isClientSide()) {
            player.swing(InteractionHand.MAIN_HAND);
            hE.a(hH.A);
            return InteractionResult.PASS;
        }
        UUID uuid = player.getUUID();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!hJ && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a != null) {
            oI<?> oIVarB = oFVarMo604a.b();
            if (livingEntity instanceof Player) {
                ServerPlayer serverPlayer = (Player) livingEntity;
                com.boehmod.blockfront.common.player.b bVarM305a = abstractC0264juM166a.m531a().m305a((Player) serverPlayer);
                boolean zA = oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a);
                Set<UUID> setH = oIVarB.h();
                if (!zA && a(abstractC0264juM166a, player, serverPlayer, oFVarMo604a, oIVarB, setH)) {
                    String scoreboardName = player.getScoreboardName();
                    oO oOVarA = oIVarB.a(uuid);
                    MutableComponent mutableComponentLiteral = Component.literal(scoreboardName);
                    if (oOVarA != null) {
                        mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(oOVarA.a());
                    }
                    if (a(player, (Player) serverPlayer)) {
                        oR.a(abstractC0264juM166a, oFVarMo604a, uuid, C0529tp.l, 2);
                    }
                    if (player instanceof ServerPlayer) {
                        oR.a((ServerPlayer) player, new sQ(a(player), 40));
                    }
                    if (serverPlayer instanceof ServerPlayer) {
                        oR.c(serverPlayer, a((Component) mutableComponentLiteral));
                    }
                    b(itemStack, player, serverPlayer);
                    if (cj() && (iAS = oFVarMo604a.aS()) > 0) {
                        bVarM305a.a(uuid, serverPlayer.level().getGameTime() + ((long) iAS));
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (livingEntity instanceof Player) {
            b(itemStack, player, (Player) livingEntity);
        }
        return InteractionResult.PASS;
    }
}
