package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tY.class */
public final class C1072tY extends AbstractC1128ub {

    /* JADX INFO: renamed from: rN */
    private static final int f5639rN = 60;

    /* JADX INFO: renamed from: gh */
    private static final ResourceLocation f5640gh = C0564jv.m2555d("textures/gui/game/troubletown/detective.png");

    public C1072tY(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: a */
    public boolean mo5963a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    /* JADX INFO: renamed from: bU */
    public int mo5834bU() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    /* JADX INFO: renamed from: as */
    public String mo5835as() {
        return "bf.message.magnifying.glass.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    public int getColor() {
        return EnumC1004sK.DETECTIVE.getColor();
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    public ResourceLocation getIcon() {
        return f5640gh;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: bW */
    public int mo5964bW() {
        return 16;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo5965x() {
        return SoundEvents.BOOK_PAGE_TURN;
    }
}
