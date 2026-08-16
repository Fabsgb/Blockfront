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

/* JADX INFO: renamed from: com.boehmod.blockfront.uo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uo.class */
public class C1142uo extends AbstractC1105uD {

    /* JADX INFO: renamed from: jO */
    @NotNull
    private static final Component f6270jO = Component.translatable("bf.popup.message.adrenaline.syringe.adrenalized").withStyle(ChatFormatting.GREEN);

    public C1142uo(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    /* JADX INFO: renamed from: a */
    boolean mo6202a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Player player, @NotNull Player player2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Set<UUID> set) {
        UUID uuid = player.getUUID();
        UUID uuid2 = player2.getUUID();
        if (set.contains(uuid2)) {
            return C0875pn.m4476a(abstractC0531jN, uuid, uuid2);
        }
        return false;
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
        player2.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0358g.f2490g, 1, false, false));
        player2.addEffect(new MobEffectInstance(MobEffects.REGENERATION, C0358g.f2490g, 1, false, false));
        player.playSound((SoundEvent) C1312xz.f8184tx.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo6206a(@NotNull Player player) {
        return f6270jO;
    }

    @Override // com.boehmod.blockfront.AbstractC1105uD
    @NotNull
    /* JADX INFO: renamed from: a */
    Component mo6207a(@NotNull Component component) {
        return Component.translatable("bf.message.gamemode.adrenalinesyringe.adrenalize", new Object[]{component}).withStyle(ChatFormatting.GRAY);
    }
}
