package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ws, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ws.class */
public class C0613ws implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0613ws> av = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_map_vote_info"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0613ws> aw = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, (v1) -> {
        return new C0613ws(v1);
    });
    private ByteBuf b;

    public C0613ws(@NotNull oF<?, ?, ?> oFVar) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            oFVar.m758a().c(byteBufBuffer);
            this.b = byteBufBuffer;
        } catch (IOException e) {
            C0263jt.logError("Failed to write map vote manager data to packet", e);
            this.b = Unpooled.EMPTY_BUFFER;
        }
    }

    public C0613ws(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.b = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        byte[] bArr = new byte[this.b.readableBytes()];
        this.b.getBytes(this.b.readerIndex(), bArr);
        friendlyByteBuf.writeByteArray(bArr);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return av;
    }

    public static void b(C0613ws c0613ws, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0324m.a(c0613ws, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public ByteBuf a() {
        return this.b;
    }

    public void dv() {
        if (this.b != null && this.b.refCnt() > 0) {
            this.b.release();
        }
    }
}
