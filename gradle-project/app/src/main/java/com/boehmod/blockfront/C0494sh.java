package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sh.class */
public class C0494sh extends AbstractC0524tk<rV, rX> implements InterfaceC0522ti<rV, rX> {

    @NotNull
    private final oP e = new oP(0, 25).a(10);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<rV, rX> c0525tl) {
        rV rVVar = (rV) c0525tl.c();
        ServerLevel serverLevelA = c0525tl.a();
        Set<UUID> setM = c0525tl.m();
        rVVar.a("main").ifPresent(c0489sc -> {
            c0489sc.Q(true);
        });
        oR.b(c0525tl.m1162b(), setM);
        if (!rVVar.a(serverLevelA) && rVVar.m1045a(serverLevelA).isEmpty()) {
            this.e.c(setM);
            if (!this.e.bs()) {
                rVVar.b(serverLevelA, setM);
                this.e.cu();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<rV, rX> c0525tl) {
        return ((rX) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), this.e) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<rV, rX> c0525tl) {
        rV rVVar = (rV) c0525tl.c();
        Set<UUID> setM = c0525tl.m();
        oR.a(setM, (SoundEvent) C0624xc.qk.get(), SoundSource.MASTER);
        C0409pd c0409pdA = ((rX) c0525tl.m1161c()).a(c0525tl.a(), setM, this.e);
        if (c0409pdA != null) {
            rVVar.a(c0525tl.a(), c0525tl.b(), C0529tp.l, true, c0409pdA, setM);
            if (c0409pdA.o != null) {
                Iterator<UUID> it = c0409pdA.o.iterator();
                while (it.hasNext()) {
                    oR.a(c0525tl.b(), rVVar, it.next(), C0529tp.Q);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rV, rX> a(@NotNull rV rVVar) {
        return new C0493sg();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull rV rVVar) {
        return this.e;
    }
}
