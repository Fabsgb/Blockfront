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

/* JADX INFO: renamed from: com.boehmod.blockfront.ua, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ua.class */
public class C0541ua extends AbstractC0546uf {

    @NotNull
    private static final Component jC = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    public C0541ua(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Player player, @NotNull Player player2, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        return set.contains(uuid2) && oR.a(abstractC0264ju, uuid, uuid2) && player2.getHealth() < player2.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    boolean a(@NotNull Player player, @NotNull Player player2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    protected boolean cj() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    public void a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        player2.setHealth(player2.getMaxHealth());
        player.playSound((SoundEvent) C0624xc.tw.get(), 1.0f, 1.0f);
        oR.a((LivingEntity) player2, (ParticleOptions) wZ.nP.get(), player2.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        if (player2 instanceof ServerPlayer) {
            C0582vo.a(new C0571vd(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), (ServerPlayer) player2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    @NotNull
    Component a(@NotNull Player player) {
        return jC;
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    @NotNull
    Component a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
