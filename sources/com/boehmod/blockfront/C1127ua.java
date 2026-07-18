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

/* JADX INFO: renamed from: com.boehmod.blockfront.ua */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ua.class */
public class C1127ua extends AbstractC1132uf {

    /* JADX INFO: renamed from: jC */
    @NotNull
    private static final Component f5931jC = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    public C1127ua(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    /* JADX INFO: renamed from: a */
    public boolean mo5951a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        return set.contains(uuid2) && C0799oR.m4040a(abstractC0563ju, uuid, uuid2) && player2.getHealth() < player2.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    /* JADX INFO: renamed from: a */
    boolean mo5952a(@NotNull Player player, @NotNull Player player2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    /* JADX INFO: renamed from: cj */
    protected boolean mo5953cj() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    /* JADX INFO: renamed from: a */
    public void mo5954a(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Player player2) {
        player2.setHealth(player2.getMaxHealth());
        player.playSound((SoundEvent) C1280xc.f7773tw.get(), 1.0f, 1.0f);
        C0799oR.m4043a((LivingEntity) player2, (ParticleOptions) C1232wZ.f7314nP.get(), player2.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        if (player2 instanceof ServerPlayer) {
            C1194vo.m6648a(new C1183vd(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), (ServerPlayer) player2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo5955a(@NotNull Player player) {
        return f5931jC;
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo5956a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
