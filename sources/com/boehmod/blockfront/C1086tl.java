package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tl.class */
public class C1086tl extends AbstractC1056tH<C1018sX, C1020sZ> implements InterfaceC1054tF<C1018sX, C1020sZ> {

    /* JADX INFO: renamed from: l */
    private final C0873pl f5847l = new C0873pl(0, 15).m4326a(5);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        serverPlayer.setGameMode(GameType.SPECTATOR);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        C1018sX c1018sX = (C1018sX) c1057tI.m5869c();
        C1020sZ c1020sZ = (C1020sZ) c1057tI.m5870c();
        AbstractC0184c<?> abstractC0184cM5872b = c1057tI.m5872b();
        Set<UUID> setM5874m = c1057tI.m5874m();
        c1018sX.f5593ag.clear();
        C0875pn.m4456f(setM5874m);
        C0875pn.m4393b(abstractC0184cM5872b, setM5874m);
        c1020sZ.m5736a(abstractC0184cM5872b);
        C0875pn.m4383a(c1057tI.m5873a(), setM5874m, abstractC0184cM5872b);
        C0875pn.m4359d(setM5874m);
        for (UUID uuid : setM5874m) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a != null) {
                C0875pn.m4402a(abstractC0184cM5872b, serverPlayerM4399a, c1020sZ.m5735j());
                serverPlayerM4399a.setGameMode(GameType.ADVENTURE);
            }
            c1018sX.m5714a(uuid, EnumC1082th.PENDING);
            C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) c1018sX, uuid, C1062tN.f5755s, 0);
        }
        c1018sX.m5723j(c1057tI.m5873a());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        Set<UUID> setM5874m = c1057tI.m5874m();
        if (((C1018sX) c1057tI.m5869c()).m4054a(setM5874m)) {
            this.f5847l.m4328c(setM5874m);
        } else {
            this.f5847l.m4327cG();
        }
        if (this.f5847l.m4335bq() <= 5) {
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c1057tI.m5869c(), (Component) Component.translatable("bf.message.gamemode.ttt.role.reminder", new Object[]{Component.literal(String.valueOf(this.f5847l.m4335bq())).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        return !this.f5847l.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1018sX, C1020sZ> mo5319a(@NotNull C1018sX c1018sX) {
        return new C1085tk();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1018sX c1018sX) {
        return this.f5847l;
    }
}
