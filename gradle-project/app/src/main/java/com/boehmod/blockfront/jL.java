package com.boehmod.blockfront;

import com.boehmod.blockfront.jU;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jL.class */
public class jL<T extends jU> {

    @NotNull
    private final Class<T> a;

    @Nullable
    private final String aK;
    private final int ki;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private T f183a;

    @Nullable
    private T b;
    private boolean dC;

    public jL(@NotNull Class<T> cls, @NotNull String str, @NotNull T t) {
        this.ki = jO.c().ap();
        this.f183a = null;
        this.a = cls;
        this.aK = str;
        this.b = t;
        bj();
    }

    public jL(@NotNull T t) {
        this.ki = jO.c().ap();
        this.f183a = null;
        this.a = (Class<T>) t.getClass();
        this.aK = null;
        this.f183a = t;
        this.dC = true;
    }

    @Nullable
    public T a() {
        if (((this.dC || this.ki == jO.c().ap()) ? false : true) || this.f183a == null) {
            bj();
        }
        return this.f183a != null ? this.f183a : this.b;
    }

    private void bj() {
        if (this.aK == null) {
            return;
        }
        this.f183a = (T) jO.c().a(this.a).a(this.aK);
    }

    public boolean ai() {
        return a() != null;
    }

    public boolean aj() {
        return !ai();
    }
}
