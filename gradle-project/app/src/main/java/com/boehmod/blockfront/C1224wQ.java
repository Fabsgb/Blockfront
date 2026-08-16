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

/* JADX INFO: renamed from: com.boehmod.blockfront.wQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wQ.class */
public class C1224wQ implements CustomPacketPayload {

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final CustomPacketPayload.Type<C1224wQ> f6649at = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_map_vote_info"));

    /* JADX INFO: renamed from: au */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1224wQ> f6650au = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6976d(v1);
    }, (v1) -> {
        return new C1224wQ(v1);
    });

    /* JADX INFO: renamed from: b */
    private ByteBuf f6651b;

    public C1224wQ(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            abstractC0863pb.m4065a().m5920c(byteBufBuffer);
            this.f6651b = byteBufBuffer;
        } catch (IOException e) {
            C0530jM.logError("Failed to write map vote manager data to packet", e);
            this.f6651b = Unpooled.EMPTY_BUFFER;
        }
    }

    public C1224wQ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6651b = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6976d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        byte[] bArr = new byte[this.f6651b.readableBytes()];
        this.f6651b.getBytes(this.f6651b.readerIndex(), bArr);
        friendlyByteBuf.writeByteArray(bArr);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6649at;
    }

    /* JADX INFO: renamed from: b */
    public static void m6977b(C1224wQ c1224wQ, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0676m.m2975a(c1224wQ, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ByteBuf m6978a() {
        return this.f6651b;
    }

    /* JADX INFO: renamed from: dF */
    public void m6979dF() {
        if (this.f6651b != null && this.f6651b.refCnt() > 0) {
            this.f6651b.release();
        }
    }
}
