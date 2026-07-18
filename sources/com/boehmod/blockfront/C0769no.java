package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.no */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/no.class */
public final class C0769no extends AbstractC0765nk implements InterfaceC0767nm {

    /* JADX INFO: renamed from: dw */
    @NotNull
    private static final ResourceLocation f4112dw = C0564jv.m2555d("textures/misc/worldpoint/medical.png");

    /* JADX INFO: renamed from: is */
    @NotNull
    private static final Component f4113is = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: it */
    @NotNull
    private static final Component f4114it = Component.translatable("bf.message.gamemode.medic.bag.heal");

    /* JADX INFO: renamed from: iX */
    public static final float f4115iX = 5.0f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final IntSet f4116b;

    public C0769no(@NotNull EntityType<? extends C0769no> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4116b = new IntOpenHashSet();
    }

    @Override // com.boehmod.blockfront.AbstractC0765nk
    /* JADX INFO: renamed from: a */
    void mo3444a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI) {
        if (this.f3611a == null) {
            return;
        }
        UUID uuid = serverPlayer.getUUID();
        UUID uuid2 = this.f3611a.getUUID();
        if (serverPlayer.getHealth() >= serverPlayer.getMaxHealth()) {
            return;
        }
        C0799oR.m3937a(serverPlayer, (SoundEvent) C1280xc.f7797tU.get(), SoundSource.NEUTRAL, 1.0f, position());
        if (C0799oR.m4041a(abstractC0790oI, uuid, uuid2)) {
            if (!uuid.equals(uuid2) && m3461b(serverPlayer.getId())) {
                C0799oR.m4015a(abstractC0563ju, abstractC0787oF, uuid2, C1089tp.f5695l, 1);
            }
            ServerPlayer serverPlayer2 = this.f3611a;
            if (serverPlayer2 instanceof ServerPlayer) {
                C0799oR.m3943a(serverPlayer2, new C1010sQ(f4113is, 40));
            }
            m3460x(serverPlayer.getId());
            int iMo3562aS = abstractC0787oF.mo3562aS();
            if (iMo3562aS > 0) {
                abstractC0563ju.m2528a().m1136a((Player) serverPlayer).m1120a(uuid2, serverPlayer.level().getGameTime() + ((long) iMo3562aS));
            }
        }
        serverPlayer.heal(5.0f);
        serverPlayer.sendSystemMessage(f4114it);
        C1194vo.m6648a(new C1183vd(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), serverPlayer);
    }

    /* JADX INFO: renamed from: x */
    public void m3460x(int i) {
        this.f4116b.add(i);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3461b(int i) {
        return !this.f4116b.contains(i);
    }

    @Override // com.boehmod.blockfront.InterfaceC0767nm
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return f4112dw;
    }
}
