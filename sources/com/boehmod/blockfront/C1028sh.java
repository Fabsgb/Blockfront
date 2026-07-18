package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sh.class */
public class C1028sh extends AbstractC1084tk<C0962rV, C0964rX> implements InterfaceC1082ti<C0962rV, C0964rX> {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0797oP f5441e = new C0797oP(0, 25).m3890a(10);

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0962rV, C0964rX> c1085tl) {
        C0962rV c0962rV = (C0962rV) c1085tl.m5989c();
        ServerLevel serverLevelM5993a = c1085tl.m5993a();
        Set<UUID> setM5994m = c1085tl.m5994m();
        c0962rV.m5252a("main").ifPresent(c1022sc -> {
            c1022sc.m5693Q(true);
        });
        C0799oR.m3957b(c1085tl.m5992b(), setM5994m);
        if (!c0962rV.m5258a(serverLevelM5993a) && c0962rV.m5263a(serverLevelM5993a).isEmpty()) {
            this.f5441e.m3892c(setM5994m);
            if (!this.f5441e.m3896bs()) {
                c0962rV.m5260b(serverLevelM5993a, setM5994m);
                this.f5441e.m3891cu();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0962rV, C0964rX> c1085tl) {
        return ((C0964rX) c1085tl.m5990c()).mo3824a(c1085tl.m5993a(), c1085tl.m5994m(), this.f5441e) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<C0962rV, C0964rX> c1085tl) {
        C0962rV c0962rV = (C0962rV) c1085tl.m5989c();
        Set<UUID> setM5994m = c1085tl.m5994m();
        C0799oR.m3933a(setM5994m, (SoundEvent) C1280xc.f7605qk.get(), SoundSource.MASTER);
        C0864pd c0864pdMo3824a = ((C0964rX) c1085tl.m5990c()).mo3824a(c1085tl.m5993a(), setM5994m, this.f5441e);
        if (c0864pdMo3824a != null) {
            c0962rV.m3574a(c1085tl.m5993a(), c1085tl.m5991b(), C1089tp.f5695l, true, c0864pdMo3824a, setM5994m);
            if (c0864pdMo3824a.f4533o != null) {
                Iterator<UUID> it = c0864pdMo3824a.f4533o.iterator();
                while (it.hasNext()) {
                    C0799oR.m4014a(c1085tl.m5991b(), c0962rV, it.next(), C1089tp.f5726Q);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0962rV, C0964rX> mo5148a(@NotNull C0962rV c0962rV) {
        return new C1027sg();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C0962rV c0962rV) {
        return this.f5441e;
    }
}
