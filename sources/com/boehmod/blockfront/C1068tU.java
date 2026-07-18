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

/* JADX INFO: renamed from: com.boehmod.blockfront.tU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tU.class */
public final class C1068tU extends AbstractC1128ub implements InterfaceC1050tC {

    /* JADX INFO: renamed from: rM */
    private static final int f5638rM = 80;

    public C1068tU(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: a */
    public void mo5962a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        Object objMo2531a = abstractC0563ju.mo2531a(player.getUUID());
        if (objMo2531a instanceof InterfaceC0898qK) {
            ((InterfaceC0898qK) objMo2531a).m4655a((Level) serverLevel, player, itemStack);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: a */
    public boolean mo5963a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        if (abstractC0787oF instanceof InterfaceC0898qK) {
            return ((InterfaceC0898qK) abstractC0787oF).m4654a(level, player);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    /* JADX INFO: renamed from: bU */
    public int mo5834bU() {
        return 80;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    /* JADX INFO: renamed from: as */
    public String mo5835as() {
        return "bf.message.planting";
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    public int getColor() {
        return ColorReferences.COLOR_TEAM_AXIS;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    public ResourceLocation getIcon() {
        return C0078aw.f470p;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: bW */
    public int mo5964bW() {
        return 4;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo5965x() {
        return (SoundEvent) C1280xc.f7807ue.get();
    }
}
