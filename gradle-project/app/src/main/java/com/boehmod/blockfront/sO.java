package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sO.class */
public class sO extends AbstractC0524tk<sA, sC> implements InterfaceC0522ti<sA, sC> {
    private final oP l = new oP(0, 15).a(5);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<sA, sC> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        serverPlayer.setGameMode(GameType.SPECTATOR);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<sA, sC> c0525tl) {
        sA sAVar = (sA) c0525tl.c();
        sC sCVar = (sC) c0525tl.m1161c();
        com.boehmod.blockfront.common.player.c<?> cVarM1162b = c0525tl.m1162b();
        Set<UUID> setM = c0525tl.m();
        sAVar.X.clear();
        oR.f(setM);
        oR.b(cVarM1162b, setM);
        sCVar.a(cVarM1162b);
        oR.a(c0525tl.a(), setM, cVarM1162b);
        oR.d(setM);
        for (UUID uuid : setM) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA != null) {
                oR.a(cVarM1162b, serverPlayerA, sCVar.j());
                serverPlayerA.setGameMode(GameType.ADVENTURE);
            }
            sAVar.a(uuid, sK.PENDING);
            oR.m792a((oF<?, ?, ?>) sAVar, uuid, C0529tp.s, 0);
        }
        sAVar.j(c0525tl.a());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<sA, sC> c0525tl) {
        Set<UUID> setM = c0525tl.m();
        if (((sA) c0525tl.c()).a(setM)) {
            this.l.c(setM);
        } else {
            this.l.cu();
        }
        if (this.l.bb() <= 5) {
            oR.a((oF<?, ?, ?>) c0525tl.c(), (Component) Component.translatable("bf.message.gamemode.ttt.role.reminder", new Object[]{Component.literal(String.valueOf(this.l.bb())).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<sA, sC> c0525tl) {
        return !this.l.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<sA, sC> a(@NotNull sA sAVar) {
        return new sN();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull sA sAVar) {
        return this.l;
    }
}
