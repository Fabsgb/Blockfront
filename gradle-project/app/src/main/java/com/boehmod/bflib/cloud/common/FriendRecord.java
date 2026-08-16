package com.boehmod.bflib.cloud.common;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.sql.Timestamp;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/FriendRecord.class */
public final class FriendRecord extends Record {

    @NotNull
    private final UUID player;

    @NotNull
    private final UUID friend;

    @NotNull
    private final Timestamp time;

    public FriendRecord(@NotNull UUID player, @NotNull UUID friend, @NotNull Timestamp time) {
        this.player = player;
        this.friend = friend;
        this.time = time;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FriendRecord.class), FriendRecord.class, "player;friend;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->friend:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FriendRecord.class), FriendRecord.class, "player;friend;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->friend:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FriendRecord.class, Object.class), FriendRecord.class, "player;friend;time", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->friend:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/FriendRecord;->time:Ljava/sql/Timestamp;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID player() {
        return this.player;
    }

    @NotNull
    public UUID friend() {
        return this.friend;
    }

    @NotNull
    public Timestamp time() {
        return this.time;
    }
}
