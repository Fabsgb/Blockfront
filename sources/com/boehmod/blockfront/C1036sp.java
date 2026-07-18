package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sp.class */
public class C1036sp extends AbstractC1084tk<C1030sj, C1034sn> implements InterfaceC1082ti<C1030sj, C1034sn> {

    /* JADX INFO: renamed from: qR */
    public static final int f5517qR = 8;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C0797oP f5518f = new C0797oP(0, 8).m3890a(8);

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        C0799oR.m3956a(c1085tl.m5992b(), c1085tl.m5994m());
        C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c1085tl.m5989c(), (Component) Component.translatable("bf.message.gamemode.of.intermission").withColor(ColorReferences.COLOR_STOPWATCH), 80, "of.intermission");
        ((C1030sj) c1085tl.m5989c()).m5746a(c1085tl.m5991b(), c1085tl.m5993a(), c1085tl.m5992b());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        this.f5518f.m3892c(c1085tl.m5994m());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        return !this.f5518f.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        C0799oR.m3957b(c1085tl.m5992b(), c1085tl.m5994m());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C1030sj, C1034sn> mo5148a(@NotNull C1030sj c1030sj) {
        return new C1038sr(2);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C1030sj c1030sj) {
        return this.f5518f;
    }
}
