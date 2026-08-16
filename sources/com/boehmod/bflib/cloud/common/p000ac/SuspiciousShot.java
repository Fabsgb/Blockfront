package com.boehmod.bflib.cloud.common.p000ac;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/ac/SuspiciousShot.class */
public final class SuspiciousShot extends Record {

    @NotNull
    private final SuspiciousShotReason reason;

    @NotNull
    private final String detail;

    @NotNull
    private final String weapon;
    private final long shootTick;
    private final long timestamp;

    public SuspiciousShot(@NotNull SuspiciousShotReason reason, @NotNull String detail, @NotNull String weapon, long shootTick, long timestamp) {
        this.reason = reason;
        this.detail = detail;
        this.weapon = weapon;
        this.shootTick = shootTick;
        this.timestamp = timestamp;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SuspiciousShot.class), SuspiciousShot.class, "reason;detail;weapon;shootTick;timestamp", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->reason:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->detail:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->weapon:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->shootTick:J", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->timestamp:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SuspiciousShot.class), SuspiciousShot.class, "reason;detail;weapon;shootTick;timestamp", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->reason:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->detail:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->weapon:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->shootTick:J", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->timestamp:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SuspiciousShot.class, Object.class), SuspiciousShot.class, "reason;detail;weapon;shootTick;timestamp", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->reason:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShotReason;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->detail:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->weapon:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->shootTick:J", "FIELD:Lcom/boehmod/bflib/cloud/common/ac/SuspiciousShot;->timestamp:J").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public SuspiciousShotReason reason() {
        return this.reason;
    }

    @NotNull
    public String detail() {
        return this.detail;
    }

    @NotNull
    public String weapon() {
        return this.weapon;
    }

    public long shootTick() {
        return this.shootTick;
    }

    public long timestamp() {
        return this.timestamp;
    }

    public SuspiciousShot(@NotNull ByteBuf byteBuffer) throws IOException {
        this((SuspiciousShotReason) IPacket.readEnum(byteBuffer, SuspiciousShotReason.class), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readLong(), byteBuffer.readLong());
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnum(byteBuffer, this.reason);
        IPacket.writeString(byteBuffer, this.detail);
        IPacket.writeString(byteBuffer, this.weapon);
        byteBuffer.writeLong(this.shootTick);
        byteBuffer.writeLong(this.timestamp);
    }
}
