package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rX.class */
public class C0965rX extends AbstractC1056tH<C0962rU, C0964rW> {

    /* JADX INFO: renamed from: jj */
    public static final Component f5360jj = Component.translatable("bf.message.disconnect.bootcamp.complete");

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C0962rU, C0964rW> c1057tI) {
        ((C0962rU) c1057tI.m5869c()).m5298f(c1057tI.m5873a());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C0962rU, C0964rW> c1057tI) {
        C0962rU c0962rU = (C0962rU) c1057tI.m5869c();
        ServerLevel serverLevelM5873a = c1057tI.m5873a();
        Set<UUID> setM5874m = c1057tI.m5874m();
        Iterator<C0840pE> it = c0962rU.m5305an().iterator();
        while (it.hasNext()) {
            it.next().m3847a(c0962rU, serverLevelM5873a, setM5874m);
        }
        Iterator<C0844pI> it2 = c0962rU.m5306ao().iterator();
        while (it2.hasNext()) {
            it2.next().m3894b(serverLevelM5873a, c0962rU, setM5874m);
        }
        for (ServerPlayer serverPlayer : c0962rU.m5297h().m4571a(serverLevelM5873a, 5, setM5874m)) {
            if (serverPlayer instanceof ServerPlayer) {
                m5318a(c1057tI.m5871b(), c1057tI.m5872b(), c0962rU, serverPlayer, setM5874m);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C0962rU, C0964rW> c1057tI) {
        return c1057tI.m5874m().isEmpty();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C0962rU, C0964rW> mo5319a(@NotNull C0962rU c0962rU) {
        return c0962rU.mo3999a();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C0962rU, C0964rW> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
    }

    /* JADX INFO: renamed from: a */
    private void m5318a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull C0962rU c0962rU, @NotNull ServerPlayer serverPlayer, @NotNull Set<UUID> set) {
        UUID uuid = serverPlayer.getUUID();
        C0555jl c0555jlM1150a = abstractC0184c.m1150a((Player) serverPlayer);
        CloudAchievement cloudAchievementMo4072a = c0962rU.mo4072a();
        AbstractC0546jc abstractC0546jcM2342b = abstractC0531jN.m2342b();
        C0875pn.m4461a(abstractC0531jN, uuid, cloudAchievementMo4072a);
        if (!c0555jlM1150a.hasCompletedBootcamp()) {
            abstractC0546jcM2342b.sendPacket(new PacketPlayerDataIncreaseValue(uuid, "bootcamp", 1));
        }
        C0875pn.m4398b(serverPlayer, f5360jj);
        C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c0962rU, (Component) Component.translatable("bf.message.ingame.bootcamp.complete", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}));
    }
}
