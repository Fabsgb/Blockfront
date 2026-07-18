package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uf.class */
public abstract class AbstractC1132uf extends C1058tK implements InterfaceC1070tW {

    /* JADX INFO: renamed from: rQ */
    public static final int f5947rQ = 8;

    /* JADX INFO: renamed from: hJ */
    static final /* synthetic */ boolean f5948hJ;

    /* JADX INFO: renamed from: a */
    abstract boolean mo5951a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    abstract boolean mo5952a(@NotNull Player player, @NotNull Player player2);

    /* JADX INFO: renamed from: a */
    abstract void mo5954a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2);

    @NotNull
    /* JADX INFO: renamed from: a */
    abstract Component mo5955a(@NotNull Player player);

    @NotNull
    /* JADX INFO: renamed from: a */
    abstract Component mo5956a(@NotNull Component component);

    static {
        f5948hJ = !AbstractC1132uf.class.desiredAssertionStatus();
    }

    public AbstractC1132uf(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: cj */
    protected boolean mo5953cj() {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m6249b(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        itemStack.shrink(1);
        player.swing(InteractionHand.MAIN_HAND);
        mo5954a(itemStack, player, player2);
    }

    @NotNull
    public InteractionResult interactLivingEntity(@NotNull ItemStack itemStack, @NotNull Player player, LivingEntity livingEntity, @NotNull InteractionHand interactionHand) {
        int iMo3562aS;
        if (livingEntity.level().isClientSide()) {
            player.swing(InteractionHand.MAIN_HAND);
            C0415hE.m1960a(C0418hH.f2684A);
            return InteractionResult.PASS;
        }
        UUID uuid = player.getUUID();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f5948hJ && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a != null) {
            AbstractC0790oI<?> abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
            if (livingEntity instanceof Player) {
                ServerPlayer serverPlayer = (Player) livingEntity;
                AbstractC0182b abstractC0182bM1136a = abstractC0563juM168a.m2528a().m1136a((Player) serverPlayer);
                boolean zM4052a = C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a);
                Set<UUID> setM3809h = abstractC0790oIM3582b.m3809h();
                if (!zM4052a && mo5951a(abstractC0563juM168a, player, serverPlayer, abstractC0787oFMo2531a, abstractC0790oIM3582b, setM3809h)) {
                    String scoreboardName = player.getScoreboardName();
                    C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
                    MutableComponent mutableComponentLiteral = Component.literal(scoreboardName);
                    if (c0796oOM3793a != null) {
                        mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(c0796oOM3793a.m3876a());
                    }
                    if (mo5952a(player, (Player) serverPlayer)) {
                        C0799oR.m4015a(abstractC0563juM168a, abstractC0787oFMo2531a, uuid, C1089tp.f5695l, 2);
                    }
                    if (player instanceof ServerPlayer) {
                        C0799oR.m3943a((ServerPlayer) player, new C1010sQ(mo5955a(player), 40));
                    }
                    if (serverPlayer instanceof ServerPlayer) {
                        C0799oR.m3970c(serverPlayer, mo5956a((Component) mutableComponentLiteral));
                    }
                    m6249b(itemStack, player, serverPlayer);
                    if (mo5953cj() && (iMo3562aS = abstractC0787oFMo2531a.mo3562aS()) > 0) {
                        abstractC0182bM1136a.m1120a(uuid, serverPlayer.level().getGameTime() + ((long) iMo3562aS));
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (livingEntity instanceof Player) {
            m6249b(itemStack, player, (Player) livingEntity);
        }
        return InteractionResult.PASS;
    }
}
