package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hP.class */
public class hP {
    private final String ap;
    private final List<hM> T;
    private final boolean cJ;

    public hP(@NotNull String str, boolean z) {
        this.T = new ObjectArrayList();
        this.ap = str;
        this.cJ = z;
    }

    public hP(@NotNull String str) {
        this(str, true);
    }

    public void a(@NotNull hM hMVar) {
        this.T.add(hMVar);
    }

    public String getName() {
        return this.ap;
    }

    public List<hM> l() {
        return Collections.unmodifiableList(this.T);
    }

    public boolean s() {
        return this.cJ;
    }
}
