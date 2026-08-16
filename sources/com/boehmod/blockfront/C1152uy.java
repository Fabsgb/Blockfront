package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uy.class */
public class C1152uy extends AbstractC1105uD {

    /* JADX INFO: renamed from: jP */
    @NotNull
    private static final Component f6280jP = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    public C1152uy(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    /* JADX INFO: renamed from: a */
    public boolean mo6202a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        return set.contains(uuid2) && C0875pn.m4476a(abstractC0531jN, uuid, uuid2) && player2.getHealth() < player2.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    /* JADX INFO: renamed from: a */
    boolean mo6203a(@NotNull Player player, @NotNull Player player2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    /* JADX INFO: renamed from: ct */
    protected boolean mo6204ct() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    /* JADX INFO: renamed from: a */
    public void mo6205a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        player2.setHealth(player2.getMaxHealth());
        player.playSound((SoundEvent) C1312xz.f8184tx.get(), 1.0f, 1.0f);
        C0875pn.m4479a((LivingEntity) player2, (ParticleOptions) C1309xw.f7879nP.get(), player2.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        if (player2 instanceof ServerPlayer) {
            C1169vO.m6643a(new C1158vD(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), (ServerPlayer) player2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo6206a(@NotNull Player player) {
        return f6280jP;
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo6207a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
