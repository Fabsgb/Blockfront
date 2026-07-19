package com.boehmod.bflib.cloud.packet.common.patreon;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse.class */
public final class PacketPatreonLinkResponse extends Record implements IPacket {

    @NotNull
    private final String oauthUrl;

    @NotNull
    private final String authCode;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketPatreonLinkResponse");

    public PacketPatreonLinkResponse(@NotNull String oauthUrl, @NotNull String authCode) {
        this.oauthUrl = oauthUrl;
        this.authCode = authCode;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPatreonLinkResponse.class), PacketPatreonLinkResponse.class, "oauthUrl;authCode", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->oauthUrl:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->authCode:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPatreonLinkResponse.class), PacketPatreonLinkResponse.class, "oauthUrl;authCode", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->oauthUrl:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->authCode:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPatreonLinkResponse.class, Object.class), PacketPatreonLinkResponse.class, "oauthUrl;authCode", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->oauthUrl:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/patreon/PacketPatreonLinkResponse;->authCode:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String oauthUrl() {
        return this.oauthUrl;
    }

    @NotNull
    public String authCode() {
        return this.authCode;
    }

    public PacketPatreonLinkResponse(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.oauthUrl);
        IPacket.writeString(byteBuffer, this.authCode);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
