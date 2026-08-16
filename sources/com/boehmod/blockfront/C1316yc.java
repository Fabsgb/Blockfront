package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.CommandEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yc.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1316yc {

    /* JADX INFO: renamed from: kt */
    private static final Component f9039kt;

    /* JADX INFO: renamed from: jZ */
    static final /* synthetic */ boolean f9040jZ;

    static {
        f9040jZ = !C1316yc.class.desiredAssertionStatus();
        f9039kt = Component.translatable("bf.message.gamemode.command.fail").withStyle(ChatFormatting.RED);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8268a(@NotNull CommandEvent commandEvent) {
        Player player = ((CommandSourceStack) commandEvent.getParseResults().getContext().getSource()).getPlayer();
        if (player == null) {
            return;
        }
        UUID uuid = player.getUUID();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f9040jZ && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        C0555jl c0555jlM1150a = abstractC0531jNM179a.m2351a().m1150a(player);
        if (abstractC0531jNM179a.mo2354a(uuid) != null && !player.hasPermissions(3) && !c0555jlM1150a.m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
            commandEvent.setCanceled(true);
            C0875pn.m4406c((ServerPlayer) player, f9039kt);
        }
    }
}
