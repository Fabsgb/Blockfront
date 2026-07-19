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

/* JADX INFO: renamed from: com.boehmod.blockfront.tr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tr.class */
public final class C0531tr {
    private String s;
    private String db;
    private String dc;
    private UUID D;

    @NotNull
    private final Set<UUID> r = new ObjectOpenHashSet();

    @NotNull
    private final List<sZ> bT = new ObjectArrayList();

    public C0531tr() {
    }

    public C0531tr(@NotNull oF<?, ?, ?> oFVar) {
        sX sXVarM751a = oFVar.m751a();
        sY sYVarM767a = oFVar.m767a();
        this.D = oFVar.m757e();
        this.s = sXVarM751a.getName();
        this.db = sYVarM767a.getName();
        this.dc = oFVar.M();
        Iterator<oO> it = oFVar.b().A().iterator();
        while (it.hasNext()) {
            this.bT.add(it.next().a(oFVar).m1156a());
        }
    }

    public void m(@NotNull UUID uuid) {
        this.r.add(uuid);
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.s = IPacket.readString(byteBuf);
        this.db = IPacket.readString(byteBuf);
        this.dc = IPacket.readString(byteBuf);
        this.bT.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            sZ sZVarA = sZ.a(byteBuf.readInt());
            if (sZVarA != null) {
                this.bT.add(sZVarA);
            }
        }
        this.r.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.r.add(IPacket.readUUID(byteBuf));
        }
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.s);
        IPacket.writeString(byteBuf, this.db);
        IPacket.writeString(byteBuf, this.dc);
        byteBuf.writeInt(this.bT.size());
        Iterator<sZ> it = this.bT.iterator();
        while (it.hasNext()) {
            byteBuf.writeInt(it.next().bN());
        }
        byteBuf.writeInt(this.r.size());
        Iterator<UUID> it2 = this.r.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @NotNull
    public UUID a() {
        return this.D;
    }

    @NotNull
    public Set<UUID> h() {
        return this.r;
    }

    public String getName() {
        return this.s;
    }

    public String aq() {
        return this.db;
    }

    @NotNull
    public String ar() {
        return this.dc;
    }

    @NotNull
    public List<sZ> A() {
        return Collections.unmodifiableList(this.bT);
    }
}
