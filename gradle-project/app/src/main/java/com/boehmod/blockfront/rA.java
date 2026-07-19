package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rA.class */
public class rA extends AbstractC0524tk<C0483rx, C0485rz> {
    public static final Component iW = Component.translatable("bf.message.disconnect.bootcamp.complete");

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0483rx, C0485rz> c0525tl) {
        ((C0483rx) c0525tl.c()).f(c0525tl.a());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<C0483rx, C0485rz> c0525tl) {
        C0483rx c0483rx = (C0483rx) c0525tl.c();
        ServerLevel serverLevelA = c0525tl.a();
        Set<UUID> setM = c0525tl.m();
        Iterator<C0414pi> it = c0483rx.al().iterator();
        while (it.hasNext()) {
            it.next().a(c0483rx, serverLevelA, setM);
        }
        Iterator<C0418pm> it2 = c0483rx.am().iterator();
        while (it2.hasNext()) {
            it2.next().b(serverLevelA, c0483rx, setM);
        }
        for (ServerPlayer serverPlayer : c0483rx.h().a(serverLevelA, 5, setM)) {
            if (serverPlayer instanceof ServerPlayer) {
                a(c0525tl.b(), c0525tl.m1162b(), c0483rx, serverPlayer, setM);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo1022a(@NotNull C0525tl<C0483rx, C0485rz> c0525tl) {
        return c0525tl.m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<C0483rx, C0485rz> a(@NotNull C0483rx c0483rx) {
        return c0483rx.mo749a();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0483rx, C0485rz> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull C0483rx c0483rx, @NotNull ServerPlayer serverPlayer, @NotNull Set<UUID> set) {
        UUID uuid = serverPlayer.getUUID();
        iS iSVarA = cVar.a((Player) serverPlayer);
        CloudAchievement cloudAchievementMo760a = c0483rx.mo760a();
        iJ iJVarM529b = abstractC0264ju.m529b();
        oR.a(abstractC0264ju, uuid, cloudAchievementMo760a);
        if (!iSVarA.hasCompletedBootcamp()) {
            iJVarM529b.sendPacket(new PacketPlayerDataIncreaseValue(uuid, "bootcamp", 1));
        }
        oR.b(serverPlayer, iW);
        oR.a((oF<?, ?, ?>) c0483rx, (Component) Component.translatable("bf.message.ingame.bootcamp.complete", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}));
    }
}
