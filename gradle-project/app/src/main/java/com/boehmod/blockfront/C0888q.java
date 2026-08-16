package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.q */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/q.class */
public final class C0888q {

    /* JADX INFO: renamed from: u */
    private static final int f4867u = 160;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Set<UUID> f4868a = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Set<UUID> f4869b = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Set<UUID> f4870c = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: v */
    private int f4871v = 0;

    /* JADX INFO: renamed from: a */
    public void m4639a(@NotNull C0358g c0358g, @NotNull C0555jl c0555jl) {
        if (!c0358g.m1722a().isConnected()) {
            this.f4868a.clear();
            this.f4869b.clear();
            return;
        }
        int i = this.f4871v;
        this.f4871v = i + 1;
        if (i >= f4867u) {
            this.f4871v = 0;
            c0358g.m1722a().m2492b(RequestType.PLAYER_FRIENDS, c0555jl.getUUID());
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m4640c(@NotNull UUID uuid) {
        return this.f4868a.contains(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m4641a() {
        return Collections.unmodifiableSet(this.f4868a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Set<UUID> m4642b() {
        return Collections.unmodifiableSet(this.f4869b);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Set<UUID> m4643c() {
        return Collections.unmodifiableSet(this.f4870c);
    }

    /* JADX INFO: renamed from: a */
    public void m4644a(@NotNull Set<UUID> set, @NotNull Set<UUID> set2, @NotNull Set<UUID> set3) {
        this.f4868a.clear();
        this.f4868a.addAll(set);
        this.f4869b.clear();
        this.f4869b.addAll(set2);
        this.f4870c.clear();
        this.f4870c.addAll(set3);
    }
}
