package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uw.class */
public final class C1150uw extends AbstractC1153uz {

    /* JADX INFO: renamed from: tQ */
    private static final int f6278tQ = 60;

    /* JADX INFO: renamed from: gg */
    private static final ResourceLocation f6279gg = C0532jO.m2378d("textures/gui/game/troubletown/detective.png");

    public C1150uw(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: a */
    public boolean mo6196a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    /* JADX INFO: renamed from: cj */
    public int mo6197cj() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    /* JADX INFO: renamed from: az */
    public String mo6198az() {
        return "bf.message.magnifying.glass.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    public int getColor() {
        return EnumC1082th.DETECTIVE.getColor();
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    public ResourceLocation getIcon() {
        return f6279gg;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: cl */
    public int mo6199cl() {
        return 16;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo6200x() {
        return SoundEvents.BOOK_PAGE_TURN;
    }
}
