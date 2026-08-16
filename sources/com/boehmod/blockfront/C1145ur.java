package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ur */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ur.class */
public final class C1145ur extends AbstractC1153uz {

    /* JADX INFO: renamed from: tO */
    private static final int f6275tO = 100;

    /* JADX INFO: renamed from: nJ */
    private static final float f6276nJ = 0.75f;

    public C1145ur(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: a */
    public void mo6579a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        UUID uuid = player.getUUID();
        Object objMo2354a = abstractC0531jN.mo2354a(uuid);
        if (objMo2354a instanceof InterfaceC0975rh) {
            InterfaceC0975rh interfaceC0975rh = (InterfaceC0975rh) objMo2354a;
            C0700mX c0700mX = (C0700mX) C0875pn.m4491a((Level) serverLevel, (Entity) player, C0700mX.class, 0.75f);
            if (c0700mX != null && !c0700mX.m3151aO() && interfaceC0975rh.m5548a((Level) serverLevel, player, c0700mX) && (player instanceof ServerPlayer)) {
                c0700mX.m3147bG();
                interfaceC0975rh.m5547a(c0700mX, (ServerPlayer) player, uuid);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: a */
    public boolean mo6196a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        if (Minecraft.getInstance().player == null) {
            return false;
        }
        C0700mX c0700mX = (C0700mX) C0875pn.m4491a(level, (Entity) player, C0700mX.class, 0.75f);
        if (abstractC0863pb instanceof InterfaceC0975rh) {
            return (c0700mX == null || c0700mX.m3151aO() || !((InterfaceC0975rh) abstractC0863pb).m5548a(level, player, c0700mX)) ? false : true;
        }
        return c0700mX != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    /* JADX INFO: renamed from: cj */
    public int mo6197cj() {
        return 100;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    /* JADX INFO: renamed from: az */
    public String mo6198az() {
        return "bf.message.bomb.defusal.kit.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    public int getColor() {
        return ColorReferences.COLOR_TEAM_ALLIES;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz, com.boehmod.blockfront.InterfaceC1128ua
    @NotNull
    public ResourceLocation getIcon() {
        return C0034aD.f291o;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    /* JADX INFO: renamed from: cl */
    public int mo6199cl() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC1153uz
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo6200x() {
        return SoundEvents.SNOW_GOLEM_SHEAR;
    }
}
