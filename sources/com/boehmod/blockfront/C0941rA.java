package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rA.class */
public class C0941rA extends AbstractC1084tk<C0990rx, C0992rz> {

    /* JADX INFO: renamed from: iW */
    public static final Component f5008iW = Component.translatable("bf.message.disconnect.bootcamp.complete");

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0990rx, C0992rz> c1085tl) {
        ((C0990rx) c1085tl.m5989c()).m5422f(c1085tl.m5993a());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0990rx, C0992rz> c1085tl) {
        C0990rx c0990rx = (C0990rx) c1085tl.m5989c();
        ServerLevel serverLevelM5993a = c1085tl.m5993a();
        Set<UUID> setM5994m = c1085tl.m5994m();
        Iterator<C0869pi> it = c0990rx.m5426al().iterator();
        while (it.hasNext()) {
            it.next().m4362a(c0990rx, serverLevelM5993a, setM5994m);
        }
        Iterator<C0873pm> it2 = c0990rx.m5427am().iterator();
        while (it2.hasNext()) {
            it2.next().m4406b(serverLevelM5993a, c0990rx, setM5994m);
        }
        for (ServerPlayer serverPlayer : c0990rx.m5421h().m4134a(serverLevelM5993a, 5, setM5994m)) {
            if (serverPlayer instanceof ServerPlayer) {
                m5147a(c1085tl.m5991b(), c1085tl.m5992b(), c0990rx, serverPlayer, setM5994m);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0990rx, C0992rz> c1085tl) {
        return c1085tl.m5994m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0990rx, C0992rz> mo5148a(@NotNull C0990rx c0990rx) {
        return c0990rx.mo3563a();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0990rx, C0992rz> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
    }

    /* JADX INFO: renamed from: a */
    private void m5147a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull C0990rx c0990rx, @NotNull ServerPlayer serverPlayer, @NotNull Set<UUID> set) {
        UUID uuid = serverPlayer.getUUID();
        C0482iS c0482iSM1133a = abstractC0183c.m1133a((Player) serverPlayer);
        CloudAchievement cloudAchievementMo3636a = c0990rx.mo3636a();
        AbstractC0473iJ abstractC0473iJM2520b = abstractC0563ju.m2520b();
        C0799oR.m4025a(abstractC0563ju, uuid, cloudAchievementMo3636a);
        if (!c0482iSM1133a.hasCompletedBootcamp()) {
            abstractC0473iJM2520b.sendPacket(new PacketPlayerDataIncreaseValue(uuid, "bootcamp", 1));
        }
        C0799oR.m3962b(serverPlayer, f5008iW);
        C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c0990rx, (Component) Component.translatable("bf.message.ingame.bootcamp.complete", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}));
    }
}
