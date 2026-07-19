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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oQ.class */
public class oQ {
    private static final int ng = 1;
    private int nh = 1;

    @NotNull
    private final Object2IntMap<UUID> d = new Object2IntOpenHashMap();

    @Nullable
    private UUID s = null;

    public void cv() {
        this.nh++;
        this.d.replaceAll((uuid, num) -> {
            return Integer.valueOf(num.intValue() + 1);
        });
        cw();
    }

    private void cw() {
        this.s = null;
        int i = -1;
        ObjectIterator it = this.d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            UUID uuid = (UUID) entry.getKey();
            int intValue = entry.getIntValue();
            if (intValue > i) {
                i = intValue;
                this.s = uuid;
            }
        }
    }

    public int a(@NotNull UUID uuid) {
        return this.d.getOrDefault(uuid, 1);
    }

    @Nullable
    public UUID g() {
        return this.s;
    }

    public int bc() {
        return this.nh;
    }

    public void bf() {
        this.nh = 1;
        this.d.clear();
        cw();
    }

    public void g(@NotNull UUID uuid) {
        this.d.removeInt(uuid);
        if (this.s != null && this.s.equals(uuid)) {
            this.s = null;
        }
        cw();
    }

    public void h(@NotNull UUID uuid) {
        this.d.putIfAbsent(uuid, 1);
        if (this.s == null) {
            this.s = uuid;
        }
    }

    public void a(@NotNull oQ oQVar) {
        this.nh = oQVar.nh;
        this.s = oQVar.s;
        ObjectIterator it = oQVar.d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            this.d.put((UUID) entry.getKey(), entry.getIntValue());
        }
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.nh = byteBuf.readInt();
        if (!IPacket.readBoolean(byteBuf)) {
            this.s = null;
        } else {
            this.s = IPacket.readUUID(byteBuf);
        }
        this.d.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.d.put(IPacket.readUUID(byteBuf), byteBuf.readInt());
        }
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.nh);
        boolean z = this.s != null;
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            IPacket.writeUUID(byteBuf, this.s);
        }
        byteBuf.writeInt(this.d.size());
        ObjectIterator it = this.d.keySet().iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            IPacket.writeUUID(byteBuf, uuid);
            byteBuf.writeInt(this.d.getInt(uuid));
        }
    }
}
