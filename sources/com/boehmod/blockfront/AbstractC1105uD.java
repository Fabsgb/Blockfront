package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uD.class */
public abstract class AbstractC1105uD extends C1136ui implements InterfaceC1148uu {

    /* JADX INFO: renamed from: tT */
    public static final int f6013tT = 8;

    /* JADX INFO: renamed from: id */
    static final /* synthetic */ boolean f6014id;

    /* JADX INFO: renamed from: a */
    abstract boolean mo6202a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    abstract boolean mo6203a(@NotNull Player player, @NotNull Player player2);

    /* JADX INFO: renamed from: a */
    abstract void mo6205a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2);

    @NotNull
    /* JADX INFO: renamed from: a */
    abstract Component mo6206a(@NotNull Player player);

    @NotNull
    /* JADX INFO: renamed from: a */
    abstract Component mo6207a(@NotNull Component component);

    static {
        f6014id = !AbstractC1105uD.class.desiredAssertionStatus();
    }

    public AbstractC1105uD(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: ct */
    protected boolean mo6204ct() {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m6208b(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        itemStack.shrink(1);
        player.swing(InteractionHand.MAIN_HAND);
        mo6205a(itemStack, player, player2);
    }

    @NotNull
    public InteractionResult interactLivingEntity(@NotNull ItemStack itemStack, @NotNull Player player, LivingEntity livingEntity, @NotNull InteractionHand interactionHand) {
        int iMo3998bh;
        if (livingEntity.level().isClientSide()) {
            player.swing(InteractionHand.MAIN_HAND);
            C0432hU.m1986a(C0435hX.f2777A);
            return InteractionResult.PASS;
        }
        UUID uuid = player.getUUID();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6014id && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a != null) {
            AbstractC0866pe<?> abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
            if (livingEntity instanceof Player) {
                ServerPlayer serverPlayer = (Player) livingEntity;
                AbstractC0183b abstractC0183bM1153a = abstractC0531jNM179a.m2351a().m1153a((Player) serverPlayer);
                boolean zM4488a = C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a);
                Set<UUID> setM4245h = abstractC0866peM4018b.m4245h();
                if (!zM4488a && mo6202a(abstractC0531jNM179a, player, serverPlayer, abstractC0863pbMo2354a, abstractC0866peM4018b, setM4245h)) {
                    String scoreboardName = player.getScoreboardName();
                    C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
                    MutableComponent mutableComponentLiteral = Component.literal(scoreboardName);
                    if (c0872pkM4229a != null) {
                        mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(c0872pkM4229a.m4312a());
                    }
                    if (mo6203a(player, (Player) serverPlayer)) {
                        C0875pn.m4451a(abstractC0531jNM179a, abstractC0863pbMo2354a, uuid, C1062tN.f5748l, 2);
                    }
                    if (player instanceof ServerPlayer) {
                        C0875pn.m4379a((ServerPlayer) player, new C1088tn(mo6206a(player), 40));
                    }
                    if (serverPlayer instanceof ServerPlayer) {
                        C0875pn.m4406c(serverPlayer, mo6207a((Component) mutableComponentLiteral));
                    }
                    m6208b(itemStack, player, serverPlayer);
                    if (mo6204ct() && (iMo3998bh = abstractC0863pbMo2354a.mo3998bh()) > 0) {
                        abstractC0183bM1153a.m1137a(uuid, serverPlayer.level().getGameTime() + ((long) iMo3998bh));
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (livingEntity instanceof Player) {
            m6208b(itemStack, player, (Player) livingEntity);
        }
        return InteractionResult.PASS;
    }
}
