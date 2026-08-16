package com.boehmod.bflib.cloud.packet.common.server;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch.class */
public final class PacketPlayerDataIncreaseValueBatch extends Record implements IPacket {

    @NotNull
    private final List<Entry> entries;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f111ID = new PacketIdentifier("PacketPlayerDataIncreaseValueBatch");

    public PacketPlayerDataIncreaseValueBatch(@NotNull List<Entry> entries) {
        this.entries = entries;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPlayerDataIncreaseValueBatch.class), PacketPlayerDataIncreaseValueBatch.class, "entries", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch;->entries:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPlayerDataIncreaseValueBatch.class), PacketPlayerDataIncreaseValueBatch.class, "entries", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch;->entries:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPlayerDataIncreaseValueBatch.class, Object.class), PacketPlayerDataIncreaseValueBatch.class, "entries", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch;->entries:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public List<Entry> entries() {
        return this.entries;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry.class */
    public static final class Entry extends Record {

        @NotNull
        private final PlayerStatExtra extra;

        @NotNull
        private final UUID uuid;

        @NotNull
        private final String value;
        private final int amount;

        public Entry(@NotNull PlayerStatExtra extra, @NotNull UUID uuid, @NotNull String value, int amount) {
            this.extra = extra;
            this.uuid = uuid;
            this.value = value;
            this.amount = amount;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Entry.class), Entry.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Entry.class), Entry.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Entry.class, Object.class), Entry.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValueBatch$Entry;->amount:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @NotNull
        public PlayerStatExtra extra() {
            return this.extra;
        }

        @NotNull
        public UUID uuid() {
            return this.uuid;
        }

        @NotNull
        public String value() {
            return this.value;
        }

        public int amount() {
            return this.amount;
        }
    }

    public PacketPlayerDataIncreaseValueBatch(@NotNull ByteBuf byteBuffer) throws IOException {
        this(readEntries(byteBuffer));
    }

    @NotNull
    private static List<Entry> readEntries(@NotNull ByteBuf byteBuffer) throws IOException {
        int count = byteBuffer.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(count);
        for (int i = 0; i < count; i++) {
            objectArrayList.add(new Entry(PlayerStatExtra.read(byteBuffer), IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readInt()));
        }
        return objectArrayList;
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.entries.size());
        for (Entry entry : this.entries) {
            entry.extra().write(byteBuffer);
            IPacket.writeUUID(byteBuffer, entry.uuid());
            IPacket.writeString(byteBuffer, entry.value());
            byteBuffer.writeInt(entry.amount());
        }
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f111ID;
    }
}
