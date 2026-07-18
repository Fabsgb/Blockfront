package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.q */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/q.class */
public final class C0887q {

    /* JADX INFO: renamed from: s */
    private static final int f4622s = 160;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Set<UUID> f4623a = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Set<UUID> f4624b = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Set<UUID> f4625c = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: t */
    private int f4626t = 0;

    /* JADX INFO: renamed from: a */
    public void m4456a(@NotNull C0357g c0357g, @NotNull C0482iS c0482iS) {
        if (!c0357g.m1716a().isConnected()) {
            this.f4623a.clear();
            this.f4624b.clear();
            return;
        }
        int i = this.f4626t;
        this.f4626t = i + 1;
        if (i >= f4622s) {
            this.f4626t = 0;
            c0357g.m1716a().m2165b(RequestType.PLAYER_FRIENDS, c0482iS.getUUID());
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m4457c(@NotNull UUID uuid) {
        return this.f4623a.contains(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m4458a() {
        return Collections.unmodifiableSet(this.f4623a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Set<UUID> m4459b() {
        return Collections.unmodifiableSet(this.f4624b);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Set<UUID> m4460c() {
        return Collections.unmodifiableSet(this.f4625c);
    }

    /* JADX INFO: renamed from: a */
    public void m4461a(@NotNull Set<UUID> set, @NotNull Set<UUID> set2, @NotNull Set<UUID> set3) {
        this.f4623a.clear();
        this.f4623a.addAll(set);
        this.f4624b.clear();
        this.f4624b.addAll(set2);
        this.f4625c.clear();
        this.f4625c.addAll(set3);
    }
}
