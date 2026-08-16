package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0613kq;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kh.class */
public class C0604kh<T extends InterfaceC0613kq> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Class<T> f3498a;

    /* JADX INFO: renamed from: aT */
    @Nullable
    private final String f3499aT;

    /* JADX INFO: renamed from: me */
    private final int f3500me;

    /* JADX INFO: renamed from: a */
    @Nullable
    private T f3501a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private T f3502b;

    /* JADX INFO: renamed from: dV */
    private boolean f3503dV;

    public C0604kh(@NotNull Class<T> cls, @NotNull String str, @NotNull T t) {
        this.f3500me = C0607kk.m2734c().m2746aE();
        this.f3501a = null;
        this.f3498a = cls;
        this.f3499aT = str;
        this.f3502b = t;
        m2699bu();
    }

    public C0604kh(@NotNull T t) {
        this.f3500me = C0607kk.m2734c().m2746aE();
        this.f3501a = null;
        this.f3498a = (Class<T>) t.getClass();
        this.f3499aT = null;
        this.f3501a = t;
        this.f3503dV = true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public T m2698a() {
        if (((this.f3503dV || this.f3500me == C0607kk.m2734c().m2746aE()) ? false : true) || this.f3501a == null) {
            m2699bu();
        }
        return this.f3501a != null ? this.f3501a : this.f3502b;
    }

    /* JADX INFO: renamed from: bu */
    private void m2699bu() {
        if (this.f3499aT == null) {
            return;
        }
        this.f3501a = (T) C0607kk.m2734c().m2737a(this.f3498a).m2707a(this.f3499aT);
    }

    /* JADX INFO: renamed from: as */
    public boolean m2700as() {
        return m2698a() != null;
    }

    /* JADX INFO: renamed from: at */
    public boolean m2701at() {
        return !m2700as();
    }
}
