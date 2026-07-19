package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wo.class */
public class C0609wo implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0609wo> ar;

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0609wo> as;

    @Nullable
    private ByteBuf a;
    private final boolean jf;

    @Nullable
    private String bF;
    static final /* synthetic */ boolean jg;

    static {
        jg = !C0609wo.class.desiredAssertionStatus();
        ar = new CustomPacketPayload.Type<>(C0265jv.d("packet_game"));
        as = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, (v1) -> {
            return new C0609wo(v1);
        });
    }

    public C0609wo(@Nullable oF<?, ?, ?> oFVar, boolean z) {
        this.bF = null;
        this.jf = oFVar != null;
        this.a = null;
        if (oFVar != null) {
            this.bF = oFVar.M();
            try {
                ByteBuf byteBufBuffer = Unpooled.buffer(InterfaceC0638xq.tR);
                oFVar.a(byteBufBuffer, z);
                oFVar.f(byteBufBuffer);
                this.a = byteBufBuffer;
            } catch (Exception e) {
                C0263jt.a("Failed to send game data update to player.", e, new Object[0]);
                this.a = Unpooled.EMPTY_BUFFER;
            }
        }
    }

    public C0609wo(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.bF = null;
        this.jf = friendlyByteBuf.readBoolean();
        if (this.jf) {
            this.bF = friendlyByteBuf.readUtf(32767);
            this.a = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
        } else {
            this.a = null;
        }
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.jf);
        if (this.jf) {
            if (!jg && this.bF == null) {
                throw new AssertionError("Game type is null!");
            }
            friendlyByteBuf.writeUtf(this.bF);
            if (this.a != null) {
                byte[] bArr = new byte[this.a.readableBytes()];
                this.a.getBytes(this.a.readerIndex(), bArr);
                friendlyByteBuf.writeByteArray(bArr);
                return;
            }
            friendlyByteBuf.writeByteArray(new byte[0]);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ar;
    }

    public static void b(C0609wo c0609wo, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0324m.a(c0609wo, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public ByteBuf a() {
        return this.a != null ? this.a : Unpooled.EMPTY_BUFFER;
    }

    public boolean df() {
        return this.jf;
    }

    @Nullable
    public String M() {
        return this.bF;
    }

    public void dv() {
        if (this.a != null && this.a.refCnt() > 0) {
            this.a.release();
        }
    }
}
