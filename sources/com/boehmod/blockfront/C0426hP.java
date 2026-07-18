package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hP.class */
public class C0426hP {

    /* JADX INFO: renamed from: ap */
    private final String f2784ap;

    /* JADX INFO: renamed from: T */
    private final List<C0423hM> f2785T;

    /* JADX INFO: renamed from: cJ */
    private final boolean f2786cJ;

    public C0426hP(@NotNull String str, boolean z) {
        this.f2785T = new ObjectArrayList();
        this.f2784ap = str;
        this.f2786cJ = z;
    }

    public C0426hP(@NotNull String str) {
        this(str, true);
    }

    /* JADX INFO: renamed from: a */
    public void m2001a(@NotNull C0423hM c0423hM) {
        this.f2785T.add(c0423hM);
    }

    public String getName() {
        return this.f2784ap;
    }

    /* JADX INFO: renamed from: l */
    public List<C0423hM> m2002l() {
        return Collections.unmodifiableList(this.f2785T);
    }

    /* JADX INFO: renamed from: s */
    public boolean m2003s() {
        return this.f2786cJ;
    }
}
