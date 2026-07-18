package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rG.class */
public class C0947rG extends AbstractC1084tk<C0942rB, C0945rE> implements InterfaceC1082ti<C0942rB, C0945rE> {

    /* JADX INFO: renamed from: gR */
    private boolean f5033gR = false;

    /* JADX INFO: renamed from: gS */
    private boolean f5034gS = false;

    /* JADX INFO: renamed from: gT */
    private boolean f5035gT = false;

    /* JADX INFO: renamed from: gU */
    private boolean f5036gU = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0797oP f5037b = new C0797oP(20, 0).m3890a(20);

    /* JADX INFO: renamed from: gV */
    static final /* synthetic */ boolean f5038gV;

    static {
        f5038gV = !C0947rG.class.desiredAssertionStatus();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0942rB, C0945rE> c1085tl) {
        C0799oR.m3925a(c1085tl.m5994m(), C0431hU.m2020a().m2021a(EnumC1123uW.START).m2025a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0942rB, C0945rE> c1085tl) {
        C0942rB c0942rB = (C0942rB) c1085tl.m5989c();
        C0945rE c0945rE = (C0945rE) c1085tl.m5990c();
        ServerLevel serverLevelM5993a = c1085tl.m5993a();
        Set<UUID> setM5994m = c1085tl.m5994m();
        this.f5037b.m3892c(setM5994m);
        C0796oO c0796oOA = c0945rE.m3806a(C1089tp.f5730da);
        if (!f5038gV && c0796oOA == null) {
            throw new AssertionError();
        }
        int iM3866a = c0796oOA.m3866a(C1089tp.f5695l);
        C0796oO c0796oOA2 = c0945rE.m3806a(C1089tp.f5729cZ);
        if (!f5038gV && c0796oOA2 == null) {
            throw new AssertionError();
        }
        int iM3866a2 = c0796oOA2.m3866a(C1089tp.f5695l);
        C0799oR.m3957b(c1085tl.m5992b(), setM5994m);
        c0942rB.m5158ao().forEach(c0804oW -> {
            c0804oW.m4122a(serverLevelM5993a, (Set<UUID>) setM5994m);
        });
        c0942rB.m5150b(c1085tl.m5991b(), c1085tl.m5992b(), serverLevelM5993a, setM5994m);
        c0942rB.m5160g(serverLevelM5993a);
        int iM3899bb = this.f5037b.m3899bb();
        boolean z = iM3866a >= 440 || iM3866a2 >= 440 || iM3899bb <= 120;
        boolean z2 = iM3866a >= 460 || iM3866a2 >= 460 || iM3899bb <= 60;
        boolean z3 = iM3866a >= 480 || iM3866a2 >= 480 || iM3899bb <= 30;
        if (z && !this.f5034gS) {
            this.f5034gS = true;
            C0799oR.m3925a(setM5994m, C0431hU.m2020a().m2023c(EnumC1123uW.SUSPENSE_ONE));
        }
        if (z2 && !this.f5035gT) {
            this.f5035gT = true;
            C0799oR.m3925a(setM5994m, C0431hU.m2020a().m2023c(EnumC1123uW.SUSPENSE_TWO));
        }
        if (z3 && !this.f5036gU) {
            this.f5036gU = true;
            C0799oR.m3925a(setM5994m, C0431hU.m2020a().m2023c(EnumC1123uW.SUSPENSE_THREE));
        }
        if (!this.f5033gR) {
            if (iM3866a >= 250) {
                this.f5033gR = true;
                C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0942rB, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(c0796oOA.m3860a((AbstractC0787oF<?, ?, ?>) c0942rB).m5976a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(c0796oOA.m3876a()), 80, "game.winning");
            } else if (iM3866a2 >= 250) {
                this.f5033gR = true;
                C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0942rB, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(c0796oOA2.m3860a((AbstractC0787oF<?, ?, ?>) c0942rB).m5976a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(c0796oOA2.m3876a()), 80, "game.winning");
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0942rB, C0945rE> c1085tl) {
        return ((C0945rE) c1085tl.m5990c()).mo3824a(c1085tl.m5993a(), c1085tl.m5994m(), this.f5037b) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0942rB, C0945rE> mo5148a(@NotNull C0942rB c0942rB) {
        return new C0946rF();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0942rB, C0945rE> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        if (enumC0800oS == EnumC0800oS.NEW) {
            C0942rB.m5149a((C0942rB) c1085tl.m5989c(), c1085tl.m5991b(), serverPlayer.getUUID(), true);
            C0799oR.m3926a(serverPlayer.getUUID(), C0431hU.m2020a().m2022b(EnumC1123uW.START_GENERIC).m2025a(5));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C0942rB c0942rB) {
        return this.f5037b;
    }
}
