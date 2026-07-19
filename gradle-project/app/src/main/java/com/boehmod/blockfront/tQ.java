package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tQ.class */
public class tQ extends AbstractC0546uf {

    @NotNull
    private static final Component jB = Component.translatable("bf.popup.message.adrenaline.syringe.adrenalized").withStyle(ChatFormatting.GREEN);

    public tQ(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Player player, @NotNull Player player2, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        if (set.contains(uuid2)) {
            return oR.a(abstractC0264ju, uuid, uuid2);
        }
        return false;
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
        player2.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0163g.g, 1, false, false));
        player2.addEffect(new MobEffectInstance(MobEffects.REGENERATION, C0163g.g, 1, false, false));
        player.playSound((SoundEvent) C0624xc.tw.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    @NotNull
    Component a(@NotNull Player player) {
        return jB;
    }

    @Override // com.boehmod.blockfront.AbstractC0546uf
    @NotNull
    Component a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.adrenalinesyringe.adrenalize", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
