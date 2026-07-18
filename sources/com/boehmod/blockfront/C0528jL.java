package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0537jU;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jL.class */
public class C0528jL<T extends InterfaceC0537jU> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Class<T> f3121a;

    /* JADX INFO: renamed from: aK */
    @Nullable
    private final String f3122aK;

    /* JADX INFO: renamed from: ki */
    private final int f3123ki;

    /* JADX INFO: renamed from: a */
    @Nullable
    private T f3124a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private T f3125b;

    /* JADX INFO: renamed from: dC */
    private boolean f3126dC;

    public C0528jL(@NotNull Class<T> cls, @NotNull String str, @NotNull T t) {
        this.f3123ki = C0531jO.m2372c().m2384ap();
        this.f3124a = null;
        this.f3121a = cls;
        this.f3122aK = str;
        this.f3125b = t;
        m2339bj();
    }

    public C0528jL(@NotNull T t) {
        this.f3123ki = C0531jO.m2372c().m2384ap();
        this.f3124a = null;
        this.f3121a = (Class<T>) t.getClass();
        this.f3122aK = null;
        this.f3124a = t;
        this.f3126dC = true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public T m2338a() {
        if (((this.f3126dC || this.f3123ki == C0531jO.m2372c().m2384ap()) ? false : true) || this.f3124a == null) {
            m2339bj();
        }
        return this.f3124a != null ? this.f3124a : this.f3125b;
    }

    /* JADX INFO: renamed from: bj */
    private void m2339bj() {
        if (this.f3122aK == null) {
            return;
        }
        this.f3124a = (T) C0531jO.m2372c().m2375a(this.f3121a).m2347a(this.f3122aK);
    }

    /* JADX INFO: renamed from: ai */
    public boolean m2340ai() {
        return m2338a() != null;
    }

    /* JADX INFO: renamed from: aj */
    public boolean m2341aj() {
        return !m2340ai();
    }
}
