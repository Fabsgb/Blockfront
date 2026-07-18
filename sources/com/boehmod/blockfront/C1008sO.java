package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sO.class */
public class C1008sO extends AbstractC1084tk<C0994sA, C0996sC> implements InterfaceC1082ti<C0994sA, C0996sC> {

    /* JADX INFO: renamed from: l */
    private final C0797oP f5283l = new C0797oP(0, 15).m3890a(5);

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        serverPlayer.setGameMode(GameType.SPECTATOR);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        C0994sA c0994sA = (C0994sA) c1085tl.m5989c();
        C0996sC c0996sC = (C0996sC) c1085tl.m5990c();
        AbstractC0183c<?> abstractC0183cM5992b = c1085tl.m5992b();
        Set<UUID> setM5994m = c1085tl.m5994m();
        c0994sA.f5264X.clear();
        C0799oR.m4020f(setM5994m);
        C0799oR.m3957b(abstractC0183cM5992b, setM5994m);
        c0996sC.m5458a(abstractC0183cM5992b);
        C0799oR.m3947a(c1085tl.m5993a(), setM5994m, abstractC0183cM5992b);
        C0799oR.m3923d(setM5994m);
        for (UUID uuid : setM5994m) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a != null) {
                C0799oR.m3966a(abstractC0183cM5992b, serverPlayerM3963a, c0996sC.m5457j());
                serverPlayerM3963a.setGameMode(GameType.ADVENTURE);
            }
            c0994sA.m5436a(uuid, EnumC1004sK.PENDING);
            C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) c0994sA, uuid, C1089tp.f5702s, 0);
        }
        c0994sA.m5445j(c1085tl.m5993a());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        Set<UUID> setM5994m = c1085tl.m5994m();
        if (((C0994sA) c1085tl.m5989c()).m3618a(setM5994m)) {
            this.f5283l.m3892c(setM5994m);
        } else {
            this.f5283l.m3891cu();
        }
        if (this.f5283l.m3899bb() <= 5) {
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c1085tl.m5989c(), (Component) Component.translatable("bf.message.gamemode.ttt.role.reminder", new Object[]{Component.literal(String.valueOf(this.f5283l.m3899bb())).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        return !this.f5283l.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0994sA, C0996sC> mo5148a(@NotNull C0994sA c0994sA) {
        return new C1007sN();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C0994sA c0994sA) {
        return this.f5283l;
    }
}
