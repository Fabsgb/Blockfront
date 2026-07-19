package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PlayerStatExtra.class */
public final class PlayerStatExtra extends Record {

    @Nullable
    private final String item;

    @Nullable
    private final String gunType;
    private final int classType;
    public static final int CLASS_ABSENT = -1;

    @NotNull
    public static final PlayerStatExtra EMPTY = new PlayerStatExtra(null, null, -1);

    public PlayerStatExtra(@Nullable String item, @Nullable String gunType, int classType) {
        this.item = item;
        this.gunType = gunType;
        this.classType = classType;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PlayerStatExtra.class), PlayerStatExtra.class, "item;gunType;classType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->item:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->gunType:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->classType:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PlayerStatExtra.class), PlayerStatExtra.class, "item;gunType;classType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->item:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->gunType:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->classType:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PlayerStatExtra.class, Object.class), PlayerStatExtra.class, "item;gunType;classType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->item:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->gunType:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;->classType:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public String item() {
        return this.item;
    }

    @Nullable
    public String gunType() {
        return this.gunType;
    }

    public int classType() {
        return this.classType;
    }

    public void write(@NotNull ByteBuf byteBuffer) {
        IPacket.writeBoolean(byteBuffer, this.item != null);
        if (this.item != null) {
            IPacket.writeString(byteBuffer, this.item);
        }
        IPacket.writeBoolean(byteBuffer, this.gunType != null);
        if (this.gunType != null) {
            IPacket.writeString(byteBuffer, this.gunType);
        }
        byteBuffer.writeInt(this.classType);
    }

    @NotNull
    public static PlayerStatExtra read(@NotNull ByteBuf byteBuffer) {
        String item = IPacket.readBoolean(byteBuffer) ? IPacket.readString(byteBuffer) : null;
        String gunType = IPacket.readBoolean(byteBuffer) ? IPacket.readString(byteBuffer) : null;
        int classType = byteBuffer.readInt();
        return new PlayerStatExtra(item, gunType, classType);
    }
}
