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

/* JADX INFO: renamed from: com.boehmod.blockfront.tP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tP.class */
public final class C1064tP {

    /* JADX INFO: renamed from: x */
    private String f5790x;

    /* JADX INFO: renamed from: dm */
    private String f5791dm;

    /* JADX INFO: renamed from: dn */
    private String f5792dn;

    /* JADX INFO: renamed from: E */
    private UUID f5793E;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Set<UUID> f5789s = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: ca */
    @NotNull
    private final List<C1097tw> f5794ca = new ObjectArrayList();

    public C1064tP() {
    }

    public C1064tP(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C1095tu c1095tuM4027a = abstractC0863pb.m4027a();
        C1096tv c1096tvM4089a = abstractC0863pb.m4089a();
        this.f5793E = abstractC0863pb.m4064e();
        this.f5790x = c1095tuM4027a.getName();
        this.f5791dm = c1096tvM4089a.getName();
        this.f5792dn = abstractC0863pb.m4030T();
        Iterator<C0872pk> it = abstractC0863pb.m4018b().m4244C().iterator();
        while (it.hasNext()) {
            this.f5794ca.add(it.next().m4296a(abstractC0863pb).m6179a());
        }
    }

    /* JADX INFO: renamed from: m */
    public void m5904m(@NotNull UUID uuid) {
        this.f5789s.add(uuid);
    }

    /* JADX INFO: renamed from: b */
    public void m5905b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5790x = IPacket.readString(byteBuf);
        this.f5791dm = IPacket.readString(byteBuf);
        this.f5792dn = IPacket.readString(byteBuf);
        this.f5794ca.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C1097tw c1097twM6155a = C1097tw.m6155a(byteBuf.readInt());
            if (c1097twM6155a != null) {
                this.f5794ca.add(c1097twM6155a);
            }
        }
        this.f5789s.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f5789s.add(IPacket.readUUID(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5906c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5790x);
        IPacket.writeString(byteBuf, this.f5791dm);
        IPacket.writeString(byteBuf, this.f5792dn);
        byteBuf.writeInt(this.f5794ca.size());
        Iterator<C1097tw> it = this.f5794ca.iterator();
        while (it.hasNext()) {
            byteBuf.writeInt(it.next().m6156cc());
        }
        byteBuf.writeInt(this.f5789s.size());
        Iterator<UUID> it2 = this.f5789s.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID m5907a() {
        return this.f5793E;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m5908h() {
        return this.f5789s;
    }

    public String getName() {
        return this.f5790x;
    }

    /* JADX INFO: renamed from: ax */
    public String m5909ax() {
        return this.f5791dm;
    }

    @NotNull
    /* JADX INFO: renamed from: ay */
    public String m5910ay() {
        return this.f5792dn;
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public List<C1097tw> m5911C() {
        return Collections.unmodifiableList(this.f5794ca);
    }
}
