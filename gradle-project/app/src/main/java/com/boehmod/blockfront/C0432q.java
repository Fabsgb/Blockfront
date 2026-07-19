package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/q.class */
public final class C0432q {
    private static final int s = 160;

    @NotNull
    private final Set<UUID> a = new ObjectOpenHashSet();

    @NotNull
    private final Set<UUID> b = new ObjectOpenHashSet();

    @NotNull
    private final Set<UUID> c = new ObjectOpenHashSet();
    private int t = 0;

    public void a(@NotNull C0163g c0163g, @NotNull iS iSVar) {
        if (!c0163g.a().isConnected()) {
            this.a.clear();
            this.b.clear();
            return;
        }
        int i = this.t;
        this.t = i + 1;
        if (i >= s) {
            this.t = 0;
            c0163g.a().b(RequestType.PLAYER_FRIENDS, iSVar.getUUID());
        }
    }

    public boolean c(@NotNull UUID uuid) {
        return this.a.contains(uuid);
    }

    @NotNull
    public Set<UUID> a() {
        return Collections.unmodifiableSet(this.a);
    }

    @NotNull
    public Set<UUID> b() {
        return Collections.unmodifiableSet(this.b);
    }

    @NotNull
    public Set<UUID> c() {
        return Collections.unmodifiableSet(this.c);
    }

    public void a(@NotNull Set<UUID> set, @NotNull Set<UUID> set2, @NotNull Set<UUID> set3) {
        this.a.clear();
        this.a.addAll(set);
        this.b.clear();
        this.b.addAll(set2);
        this.c.clear();
        this.c.addAll(set3);
    }
}
