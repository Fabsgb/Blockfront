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

/* JADX INFO: renamed from: com.boehmod.blockfront.tQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tQ.class */
public class C1064tQ extends AbstractC1132uf {

    /* JADX INFO: renamed from: jB */
    @NotNull
    private static final Component f5631jB = Component.translatable("bf.popup.message.adrenaline.syringe.adrenalized").withStyle(ChatFormatting.GREEN);

    public C1064tQ(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    /* JADX INFO: renamed from: a */
    boolean mo5951a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        if (set.contains(uuid2)) {
            return C0799oR.m4040a(abstractC0563ju, uuid, uuid2);
        }
        return false;
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
        player2.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0357g.f2439g, 1, false, false));
        player2.addEffect(new MobEffectInstance(MobEffects.REGENERATION, C0357g.f2439g, 1, false, false));
        player.playSound((SoundEvent) C1280xc.f7773tw.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo5955a(@NotNull Player player) {
        return f5631jB;
    }

    @Override // com.boehmod.blockfront.AbstractC1132uf
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo5956a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.adrenalinesyringe.adrenalize", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
