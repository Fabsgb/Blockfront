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

/* JADX INFO: renamed from: com.boehmod.blockfront.pm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pm.class */
public class C0874pm {

    /* JADX INFO: renamed from: pf */
    private static final int f4769pf = 1;

    /* JADX INFO: renamed from: pg */
    private int f4770pg = 1;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Object2IntMap<UUID> f4771d = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: s */
    @Nullable
    private UUID f4772s = null;

    /* JADX INFO: renamed from: cH */
    public void m4339cH() {
        this.f4770pg++;
        this.f4771d.replaceAll((uuid, num) -> {
            return Integer.valueOf(num.intValue() + 1);
        });
        m4340cI();
    }

    /* JADX INFO: renamed from: cI */
    private void m4340cI() {
        this.f4772s = null;
        int i = -1;
        ObjectIterator it = this.f4771d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            UUID uuid = (UUID) entry.getKey();
            int intValue = entry.getIntValue();
            if (intValue > i) {
                i = intValue;
                this.f4772s = uuid;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m4341a(@NotNull UUID uuid) {
        return this.f4771d.getOrDefault(uuid, 1);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public UUID m4342g() {
        return this.f4772s;
    }

    /* JADX INFO: renamed from: br */
    public int m4343br() {
        return this.f4770pg;
    }

    /* JADX INFO: renamed from: bd */
    public void m4344bd() {
        this.f4770pg = 1;
        this.f4771d.clear();
        m4340cI();
    }

    /* JADX INFO: renamed from: g */
    public void m4345g(@NotNull UUID uuid) {
        this.f4771d.removeInt(uuid);
        if (this.f4772s != null && this.f4772s.equals(uuid)) {
            this.f4772s = null;
        }
        m4340cI();
    }

    /* JADX INFO: renamed from: h */
    public void m4346h(@NotNull UUID uuid) {
        this.f4771d.putIfAbsent(uuid, 1);
        if (this.f4772s == null) {
            this.f4772s = uuid;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4347a(@NotNull C0874pm c0874pm) {
        this.f4770pg = c0874pm.f4770pg;
        this.f4772s = c0874pm.f4772s;
        ObjectIterator it = c0874pm.f4771d.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            this.f4771d.put((UUID) entry.getKey(), entry.getIntValue());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4348b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4770pg = byteBuf.readInt();
        if (!IPacket.readBoolean(byteBuf)) {
            this.f4772s = null;
        } else {
            this.f4772s = IPacket.readUUID(byteBuf);
        }
        this.f4771d.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4771d.put(IPacket.readUUID(byteBuf), byteBuf.readInt());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4349c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f4770pg);
        boolean z = this.f4772s != null;
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            IPacket.writeUUID(byteBuf, this.f4772s);
        }
        byteBuf.writeInt(this.f4771d.size());
        ObjectIterator it = this.f4771d.keySet().iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            IPacket.writeUUID(byteBuf, uuid);
            byteBuf.writeInt(this.f4771d.getInt(uuid));
        }
    }
}
