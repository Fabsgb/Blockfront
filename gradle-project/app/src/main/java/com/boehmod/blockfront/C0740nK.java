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

/* JADX INFO: renamed from: com.boehmod.blockfront.nK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nK.class */
public final class C0740nK extends AbstractC0736nG implements InterfaceC0738nI {

    /* JADX INFO: renamed from: du */
    @NotNull
    private static final ResourceLocation f4067du = C0532jO.m2378d("textures/misc/worldpoint/medical.png");

    /* JADX INFO: renamed from: iE */
    @NotNull
    private static final Component f4068iE = Component.translatable("bf.popup.message.medic.bag.player.healed").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: iF */
    @NotNull
    private static final Component f4069iF = Component.translatable("bf.message.gamemode.medic.bag.heal");

    /* JADX INFO: renamed from: jQ */
    public static final float f4070jQ = 5.0f;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final IntSet f4071d;

    public C0740nK(@NotNull EntityType<? extends C0740nK> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4071d = new IntOpenHashSet();
    }

    @Override // com.boehmod.blockfront.AbstractC0736nG
    /* JADX INFO: renamed from: a */
    void mo3367a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe) {
        if (this.f3861a == null) {
            return;
        }
        UUID uuid = serverPlayer.getUUID();
        UUID uuid2 = this.f3861a.getUUID();
        if (serverPlayer.getHealth() >= serverPlayer.getMaxHealth()) {
            return;
        }
        C0875pn.m4373a(serverPlayer, (SoundEvent) C1312xz.f8208tV.get(), SoundSource.NEUTRAL, 1.0f, position());
        if (C0875pn.m4477a(abstractC0866pe, uuid, uuid2)) {
            if (!uuid.equals(uuid2) && m3384b(serverPlayer.getId())) {
                C0875pn.m4451a(abstractC0531jN, abstractC0863pb, uuid2, C1062tN.f5748l, 1);
            }
            ServerPlayer serverPlayer2 = this.f3861a;
            if (serverPlayer2 instanceof ServerPlayer) {
                C0875pn.m4379a(serverPlayer2, new C1088tn(f4068iE, 40));
            }
            m3383y(serverPlayer.getId());
            int iMo3998bh = abstractC0863pb.mo3998bh();
            if (iMo3998bh > 0) {
                abstractC0531jN.m2351a().m1153a((Player) serverPlayer).m1137a(uuid2, serverPlayer.level().getGameTime() + ((long) iMo3998bh));
            }
        }
        serverPlayer.heal(5.0f);
        serverPlayer.sendSystemMessage(f4069iF);
        C1169vO.m6643a(new C1158vD(ChatFormatting.GREEN.getColor().intValue() - 16777216, 1.0f, 0.015f, 0.2f), serverPlayer);
    }

    /* JADX INFO: renamed from: y */
    public void m3383y(int i) {
        this.f4071d.add(i);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3384b(int i) {
        return !this.f4071d.contains(i);
    }

    @Override // com.boehmod.blockfront.InterfaceC0738nI
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return f4067du;
    }
}
