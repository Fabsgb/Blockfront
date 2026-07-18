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

/* JADX INFO: renamed from: com.boehmod.blockfront.ws */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ws.class */
public class C1251ws implements CustomPacketPayload {

    /* JADX INFO: renamed from: av */
    @NotNull
    public static final CustomPacketPayload.Type<C1251ws> f7412av = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_map_vote_info"));

    /* JADX INFO: renamed from: aw */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1251ws> f7413aw = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7708d(v1);
    }, (v1) -> {
        return new C1251ws(v1);
    });

    /* JADX INFO: renamed from: b */
    private ByteBuf f7414b;

    public C1251ws(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        try {
            abstractC0787oF.m3629a().m6034c(byteBufBuffer);
            this.f7414b = byteBufBuffer;
        } catch (IOException e) {
            C0562jt.logError("Failed to write map vote manager data to packet", e);
            this.f7414b = Unpooled.EMPTY_BUFFER;
        }
    }

    public C1251ws(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f7414b = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m7708d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        byte[] bArr = new byte[this.f7414b.readableBytes()];
        this.f7414b.getBytes(this.f7414b.readerIndex(), bArr);
        friendlyByteBuf.writeByteArray(bArr);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7412av;
    }

    /* JADX INFO: renamed from: b */
    public static void m7709b(C1251ws c1251ws, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0675m.m2964a(c1251ws, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ByteBuf m7710a() {
        return this.f7414b;
    }

    /* JADX INFO: renamed from: dv */
    public void m7711dv() {
        if (this.f7414b != null && this.f7414b.refCnt() > 0) {
            this.f7414b.release();
        }
    }
}
