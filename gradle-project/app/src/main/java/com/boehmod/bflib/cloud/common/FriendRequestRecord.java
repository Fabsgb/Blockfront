package com.boehmod.bflib.cloud.common;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.sql.Timestamp;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/FriendRequestRecord.class */
public final class FriendRequestRecord extends Record {

    @NotNull
    private final UUID sender;

    @NotNull
    private final UUID receiver;

    @NotNull
    private final Timestamp time;

    public FriendRequestRecord(@NotNull UUID sender, @NotNull UUID receiver, @NotNull Timestamp time) {
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FriendRequestRecord.class), FriendRequestRecord.class, "sender;receiver;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->sender:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->receiver:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FriendRequestRecord.class), FriendRequestRecord.class, "sender;receiver;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->sender:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->receiver:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FriendRequestRecord.class, Object.class), FriendRequestRecord.class, "sender;receiver;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->sender:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->receiver:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRequestRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID sender() {
        return this.sender;
    }

    @NotNull
    public UUID receiver() {
        return this.receiver;
    }

    @NotNull
    public Timestamp time() {
        return this.time;
    }
}
