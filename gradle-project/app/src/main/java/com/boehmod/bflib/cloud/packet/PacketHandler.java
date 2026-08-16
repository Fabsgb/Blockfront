package com.boehmod.bflib.cloud.packet;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketHandler.class */
public final class PacketHandler<T extends IPacket, H extends Connection> extends Record {

    @Nullable
    private final ConnectionType connectionType;

    @NotNull
    private final IPacketHandlerFunction<T, H> function;

    @NotNull
    private final Class<H> handlerType;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketHandler.class), PacketHandler.class, "connectionType;function;handlerType", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->connectionType:Lcom/boehmod/bflib/cloud/common/ConnectionType;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->function:Lcom/boehmod/bflib/cloud/packet/IPacketHandlerFunction;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->handlerType:Ljava/lang/Class;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketHandler.class), PacketHandler.class, "connectionType;function;handlerType", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->connectionType:Lcom/boehmod/bflib/cloud/common/ConnectionType;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->function:Lcom/boehmod/bflib/cloud/packet/IPacketHandlerFunction;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->handlerType:Ljava/lang/Class;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketHandler.class, Object.class), PacketHandler.class, "connectionType;function;handlerType", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->connectionType:Lcom/boehmod/bflib/cloud/common/ConnectionType;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->function:Lcom/boehmod/bflib/cloud/packet/IPacketHandlerFunction;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketHandler;->handlerType:Ljava/lang/Class;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public Class<H> handlerType() {
        return this.handlerType;
    }

    public PacketHandler(@Nullable ConnectionType connectionType, @NotNull IPacketHandlerFunction<T, H> function, @NotNull Class<H> handlerType) {
        this.connectionType = connectionType;
        this.function = function;
        this.handlerType = handlerType;
    }

    @NotNull
    public IPacketHandlerFunction<T, H> function() {
        return this.function;
    }

    @Nullable
    public ConnectionType connectionType() {
        return this.connectionType;
    }
}
