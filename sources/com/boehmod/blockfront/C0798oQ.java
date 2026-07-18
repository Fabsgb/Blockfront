package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.oQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oQ.class */
public class C0798oQ {

    /* JADX INFO: renamed from: ng */
    private static final int f4373ng = 1;

    /* JADX INFO: renamed from: nh */
    private int f4374nh = 1;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Object2IntMap<UUID> f4375d = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: s */
    @Nullable
    private UUID f4376s = null;

    /* JADX INFO: renamed from: cv */
    public void m3903cv() {
        this.f4374nh++;
        this.f4375d.replaceAll((uuid, num) -> {
            return Integer.valueOf(num.intValue() + 1);
        });
        m3904cw();
    }

    /* JADX INFO: renamed from: cw */
    private void m3904cw() {
        this.f4376s = null;
        int i = -1;
        ObjectIterator it = this.f4375d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            UUID uuid = (UUID) entry.getKey();
            int intValue = entry.getIntValue();
            if (intValue > i) {
                i = intValue;
                this.f4376s = uuid;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m3905a(@NotNull UUID uuid) {
        return this.f4375d.getOrDefault(uuid, 1);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public UUID m3906g() {
        return this.f4376s;
    }

    /* JADX INFO: renamed from: bc */
    public int m3907bc() {
        return this.f4374nh;
    }

    /* JADX INFO: renamed from: bf */
    public void m3908bf() {
        this.f4374nh = 1;
        this.f4375d.clear();
        m3904cw();
    }

    /* JADX INFO: renamed from: g */
    public void m3909g(@NotNull UUID uuid) {
        this.f4375d.removeInt(uuid);
        if (this.f4376s != null && this.f4376s.equals(uuid)) {
            this.f4376s = null;
        }
        m3904cw();
    }

    /* JADX INFO: renamed from: h */
    public void m3910h(@NotNull UUID uuid) {
        this.f4375d.putIfAbsent(uuid, 1);
        if (this.f4376s == null) {
            this.f4376s = uuid;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3911a(@NotNull C0798oQ c0798oQ) {
        this.f4374nh = c0798oQ.f4374nh;
        this.f4376s = c0798oQ.f4376s;
        ObjectIterator it = c0798oQ.f4375d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            this.f4375d.put((UUID) entry.getKey(), entry.getIntValue());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3912b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4374nh = byteBuf.readInt();
        if (!IPacket.readBoolean(byteBuf)) {
            this.f4376s = null;
        } else {
            this.f4376s = IPacket.readUUID(byteBuf);
        }
        this.f4375d.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4375d.put(IPacket.readUUID(byteBuf), byteBuf.readInt());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3913c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4374nh);
        boolean z = this.f4376s != null;
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            IPacket.writeUUID(byteBuf, this.f4376s);
        }
        byteBuf.writeInt(this.f4375d.size());
        ObjectIterator it = this.f4375d.keySet().iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            IPacket.writeUUID(byteBuf, uuid);
            byteBuf.writeInt(this.f4375d.getInt(uuid));
        }
    }
}
