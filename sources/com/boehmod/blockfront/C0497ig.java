package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ig */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ig.class */
public class C0497ig {

    /* JADX INFO: renamed from: aw */
    private final String f3086aw;

    /* JADX INFO: renamed from: W */
    private final List<C0494id> f3087W;

    /* JADX INFO: renamed from: cS */
    private final boolean f3088cS;

    public C0497ig(@NotNull String str, boolean z) {
        this.f3087W = new ObjectArrayList();
        this.f3086aw = str;
        this.f3088cS = z;
    }

    public C0497ig(@NotNull String str) {
        this(str, true);
    }

    /* JADX INFO: renamed from: a */
    public void m2235a(@NotNull C0494id c0494id) {
        this.f3087W.add(c0494id);
    }

    public String getName() {
        return this.f3086aw;
    }

    /* JADX INFO: renamed from: n */
    public List<C0494id> m2236n() {
        return Collections.unmodifiableList(this.f3087W);
    }

    /* JADX INFO: renamed from: t */
    public boolean m2237t() {
        return this.f3088cS;
    }
}
