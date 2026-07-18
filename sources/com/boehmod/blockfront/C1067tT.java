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

/* JADX INFO: renamed from: com.boehmod.blockfront.tT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tT.class */
public final class C1067tT extends AbstractC1128ub {

    /* JADX INFO: renamed from: rL */
    private static final int f5636rL = 100;

    /* JADX INFO: renamed from: mK */
    private static final float f5637mK = 0.75f;

    public C1067tT(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: a */
    public void mo5962a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        UUID uuid = player.getUUID();
        Object objMo2531a = abstractC0563ju.mo2531a(uuid);
        if (objMo2531a instanceof InterfaceC0898qK) {
            InterfaceC0898qK interfaceC0898qK = (InterfaceC0898qK) objMo2531a;
            C0677mB c0677mB = (C0677mB) C0799oR.m4055a((Level) serverLevel, (Entity) player, C0677mB.class, 0.75f);
            if (c0677mB != null && !c0677mB.m3000aD() && interfaceC0898qK.m4653a((Level) serverLevel, player, c0677mB) && (player instanceof ServerPlayer)) {
                c0677mB.m2996bv();
                interfaceC0898qK.m4652a(c0677mB, (ServerPlayer) player, uuid);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: a */
    public boolean mo5963a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        if (Minecraft.getInstance().player == null) {
            return false;
        }
        C0677mB c0677mB = (C0677mB) C0799oR.m4055a(level, (Entity) player, C0677mB.class, 0.75f);
        if (abstractC0787oF instanceof InterfaceC0898qK) {
            return (c0677mB == null || c0677mB.m3000aD() || !((InterfaceC0898qK) abstractC0787oF).m4653a(level, player, c0677mB)) ? false : true;
        }
        return c0677mB != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    /* JADX INFO: renamed from: bU */
    public int mo5834bU() {
        return 100;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    /* JADX INFO: renamed from: as */
    public String mo5835as() {
        return "bf.message.bomb.defusal.kit.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    public int getColor() {
        return ColorReferences.COLOR_TEAM_ALLIES;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub, com.boehmod.blockfront.InterfaceC1050tC
    @NotNull
    public ResourceLocation getIcon() {
        return C0078aw.f469o;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    /* JADX INFO: renamed from: bW */
    public int mo5964bW() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC1128ub
    @NotNull
    /* JADX INFO: renamed from: x */
    public SoundEvent mo5965x() {
        return SoundEvents.SNOW_GOLEM_SHEAR;
    }
}
