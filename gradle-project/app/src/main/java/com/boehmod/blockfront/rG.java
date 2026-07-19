package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rG.class */
public class rG extends AbstractC0524tk<rB, rE> implements InterfaceC0522ti<rB, rE> {
    private boolean gR = false;
    private boolean gS = false;
    private boolean gT = false;
    private boolean gU = false;

    @NotNull
    private final oP b = new oP(20, 0).a(20);
    static final /* synthetic */ boolean gV;

    static {
        gV = !rG.class.desiredAssertionStatus();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rB, rE> c0525tl) {
        oR.a(c0525tl.m(), hU.a().a(uW.START).a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<rB, rE> c0525tl) {
        rB rBVar = (rB) c0525tl.c();
        rE rEVar = (rE) c0525tl.m1161c();
        ServerLevel serverLevelA = c0525tl.a();
        Set<UUID> setM = c0525tl.m();
        this.b.c(setM);
        oO oOVarA = rEVar.a(C0529tp.da);
        if (!gV && oOVarA == null) {
            throw new AssertionError();
        }
        int iA = oOVarA.a(C0529tp.l);
        oO oOVarA2 = rEVar.a(C0529tp.cZ);
        if (!gV && oOVarA2 == null) {
            throw new AssertionError();
        }
        int iA2 = oOVarA2.a(C0529tp.l);
        oR.b(c0525tl.m1162b(), setM);
        rBVar.ao().forEach(oWVar -> {
            oWVar.a(serverLevelA, (Set<UUID>) setM);
        });
        rBVar.b(c0525tl.b(), c0525tl.m1162b(), serverLevelA, setM);
        rBVar.g(serverLevelA);
        int iBb = this.b.bb();
        boolean z = iA >= 440 || iA2 >= 440 || iBb <= 120;
        boolean z2 = iA >= 460 || iA2 >= 460 || iBb <= 60;
        boolean z3 = iA >= 480 || iA2 >= 480 || iBb <= 30;
        if (z && !this.gS) {
            this.gS = true;
            oR.a(setM, hU.a().c(uW.SUSPENSE_ONE));
        }
        if (z2 && !this.gT) {
            this.gT = true;
            oR.a(setM, hU.a().c(uW.SUSPENSE_TWO));
        }
        if (z3 && !this.gU) {
            this.gU = true;
            oR.a(setM, hU.a().c(uW.SUSPENSE_THREE));
        }
        if (!this.gR) {
            if (iA >= 250) {
                this.gR = true;
                oR.a((oF<?, ?, ?>) rBVar, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(oOVarA.a((oF<?, ?, ?>) rBVar).m1156a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(oOVarA.a()), 80, "game.winning");
            } else if (iA2 >= 250) {
                this.gR = true;
                oR.a((oF<?, ?, ?>) rBVar, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(oOVarA2.a((oF<?, ?, ?>) rBVar).m1156a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(oOVarA2.a()), 80, "game.winning");
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<rB, rE> c0525tl) {
        return ((rE) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), this.b) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rB, rE> a(@NotNull rB rBVar) {
        return new rF();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rB, rE> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        if (oSVar == oS.NEW) {
            rB.a((rB) c0525tl.c(), c0525tl.b(), serverPlayer.getUUID(), true);
            oR.a(serverPlayer.getUUID(), hU.a().b(uW.START_GENERIC).a(5));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull rB rBVar) {
        return this.b;
    }
}
