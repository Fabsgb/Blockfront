package com.boehmod.bflib.cloud.common;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/GroupRecord.class */
public final class GroupRecord extends Record {

    @NotNull
    private final String name;

    @NotNull
    private final String tag;
    private final String color;
    private final long discordRoleId;

    public GroupRecord(@NotNull String name, @NotNull String tag, String color, long discordRoleId) {
        this.name = name;
        this.tag = tag;
        this.color = color;
        this.discordRoleId = discordRoleId;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GroupRecord.class), GroupRecord.class, "name;tag;color;discordRoleId", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->tag:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->color:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->discordRoleId:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GroupRecord.class), GroupRecord.class, "name;tag;color;discordRoleId", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->tag:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->color:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->discordRoleId:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GroupRecord.class, Object.class), GroupRecord.class, "name;tag;color;discordRoleId", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->tag:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->color:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/GroupRecord;->discordRoleId:J").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String name() {
        return this.name;
    }

    @NotNull
    public String tag() {
        return this.tag;
    }

    public String color() {
        return this.color;
    }

    public long discordRoleId() {
        return this.discordRoleId;
    }
}
