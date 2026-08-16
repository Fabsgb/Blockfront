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

/* JADX INFO: renamed from: com.boehmod.blockfront.us */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/us.class */
public final class C1146us extends AbstractC1153uz implements InterfaceC1128ua {

    /* JADX INFO: renamed from: tP */
    private static final int f6277tP = 80;

    public C1146us(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: a */
    public void mo6579a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        Object objMo2354a = abstractC0531jN.mo2354a(player.getUUID());
        if (objMo2354a instanceof InterfaceC0975rh) {
            ((InterfaceC0975rh) objMo2354a).m5550a((Level) serverLevel, player, itemStack);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: a */
    public boolean mo6196a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        if (abstractC0863pb instanceof InterfaceC0975rh) {
            return ((InterfaceC0975rh) abstractC0863pb).m5549a(level, player);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    /* JADX INFO: renamed from: cj */
    public int mo6197cj() {
        return 80;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    /* JADX INFO: renamed from: az */
    public String mo6198az() {
        return "bf.message.planting";
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    public int getColor() {
        return ColorReferences.COLOR_TEAM_AXIS;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    public ResourceLocation getIcon() {
        return C0034aD.f292p;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: cl */
    public int mo6199cl() {
        return 4;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo6200x() {
        return (SoundEvent) C1312xz.f8218uf.get();
    }
}
