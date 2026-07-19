package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tU.class */
public final class tU extends AbstractC0542ub implements tC {
    private static final int rM = 80;

    public tU(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        Object objMo604a = abstractC0264ju.mo604a(player.getUUID());
        if (objMo604a instanceof qK) {
            ((qK) objMo604a).a((Level) serverLevel, player, itemStack);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC0542ub
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        if (oFVar instanceof qK) {
            return ((qK) oFVar).a(level, player);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int bU() {
        return 80;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public String as() {
        return "bf.message.planting";
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int getColor() {
        return ColorReferences.COLOR_TEAM_AXIS;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public ResourceLocation getIcon() {
        return C0025aw.p;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public int bW() {
        return 4;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    @NotNull
    public SoundEvent x() {
        return (SoundEvent) C0624xc.ue.get();
    }
}
