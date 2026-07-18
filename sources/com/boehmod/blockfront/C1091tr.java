package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tr.class */
public final class C1091tr {

    /* JADX INFO: renamed from: s */
    private String f5737s;

    /* JADX INFO: renamed from: db */
    private String f5738db;

    /* JADX INFO: renamed from: dc */
    private String f5739dc;

    /* JADX INFO: renamed from: D */
    private UUID f5740D;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Set<UUID> f5736r = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: bT */
    @NotNull
    private final List<C1019sZ> f5741bT = new ObjectArrayList();

    public C1091tr() {
    }

    public C1091tr(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C1017sX c1017sXM3591a = abstractC0787oF.m3591a();
        C1018sY c1018sYM3653a = abstractC0787oF.m3653a();
        this.f5740D = abstractC0787oF.m3628e();
        this.f5737s = c1017sXM3591a.getName();
        this.f5738db = c1018sYM3653a.getName();
        this.f5739dc = abstractC0787oF.m3594M();
        Iterator<C0796oO> it = abstractC0787oF.m3582b().m3808A().iterator();
        while (it.hasNext()) {
            this.f5741bT.add(it.next().m3860a(abstractC0787oF).m5976a());
        }
    }

    /* JADX INFO: renamed from: m */
    public void m6018m(@NotNull UUID uuid) {
        this.f5736r.add(uuid);
    }

    /* JADX INFO: renamed from: b */
    public void m6019b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5737s = IPacket.readString(byteBuf);
        this.f5738db = IPacket.readString(byteBuf);
        this.f5739dc = IPacket.readString(byteBuf);
        this.f5741bT.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C1019sZ c1019sZM5667a = C1019sZ.m5667a(byteBuf.readInt());
            if (c1019sZM5667a != null) {
                this.f5741bT.add(c1019sZM5667a);
            }
        }
        this.f5736r.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5736r.add(IPacket.readUUID(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6020c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5737s);
        IPacket.writeString(byteBuf, this.f5738db);
        IPacket.writeString(byteBuf, this.f5739dc);
        byteBuf.writeInt(this.f5741bT.size());
        Iterator<C1019sZ> it = this.f5741bT.iterator();
        while (it.hasNext()) {
            byteBuf.writeInt(it.next().m5668bN());
        }
        byteBuf.writeInt(this.f5736r.size());
        Iterator<UUID> it2 = this.f5736r.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID m6021a() {
        return this.f5740D;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m6022h() {
        return this.f5736r;
    }

    public String getName() {
        return this.f5737s;
    }

    /* JADX INFO: renamed from: aq */
    public String m6023aq() {
        return this.f5738db;
    }

    @NotNull
    /* JADX INFO: renamed from: ar */
    public String m6024ar() {
        return this.f5739dc;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public List<C1019sZ> m6025A() {
        return Collections.unmodifiableList(this.f5741bT);
    }
}
