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

/* JADX INFO: renamed from: com.boehmod.blockfront.no, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/no.class */
public final class C0366no extends AbstractC0362nk implements InterfaceC0364nm {

    @NotNull
    private static final ResourceLocation dw = C0265jv.d("textures/misc/worldpoint/medical.png");

    @NotNull
    private static final Component is = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    @NotNull
    private static final Component it = Component.translatable("bf.message.gamemode.medic.bag.heal");
    public static final float iX = 5.0f;

    @NotNull
    private final IntSet b;

    public C0366no(@NotNull EntityType<? extends C0366no> entityType, @NotNull Level level) {
        super(entityType, level);
        this.b = new IntOpenHashSet();
    }

    @Override // com.boehmod.blockfront.AbstractC0362nk
    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar) {
        if (this.f236a == null) {
            return;
        }
        UUID uuid = serverPlayer.getUUID();
        UUID uuid2 = this.f236a.getUUID();
        if (serverPlayer.getHealth() >= serverPlayer.getMaxHealth()) {
            return;
        }
        oR.a(serverPlayer, (SoundEvent) C0624xc.tU.get(), SoundSource.NEUTRAL, 1.0f, position());
        if (oR.a(oIVar, uuid, uuid2)) {
            if (!uuid.equals(uuid2) && b(serverPlayer.getId())) {
                oR.a(abstractC0264ju, oFVar, uuid2, C0529tp.l, 1);
            }
            ServerPlayer serverPlayer2 = this.f236a;
            if (serverPlayer2 instanceof ServerPlayer) {
                oR.a(serverPlayer2, new sQ(is, 40));
            }
            x(serverPlayer.getId());
            int iAS = oFVar.aS();
            if (iAS > 0) {
                abstractC0264ju.m531a().m305a((Player) serverPlayer).a(uuid2, serverPlayer.level().getGameTime() + ((long) iAS));
            }
        }
        serverPlayer.heal(5.0f);
        serverPlayer.sendSystemMessage(it);
        C0582vo.a(new C0571vd(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), serverPlayer);
    }

    public void x(int i) {
        this.b.add(i);
    }

    public boolean b(int i) {
        return !this.b.contains(i);
    }

    @Override // com.boehmod.blockfront.InterfaceC0364nm
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return dw;
    }
}
