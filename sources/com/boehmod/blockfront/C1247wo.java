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

/* JADX INFO: renamed from: com.boehmod.blockfront.wo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wo.class */
public class C1247wo implements CustomPacketPayload {

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final CustomPacketPayload.Type<C1247wo> f7394ar;

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1247wo> f7395as;

    /* JADX INFO: renamed from: a */
    @Nullable
    private ByteBuf f7396a;

    /* JADX INFO: renamed from: jf */
    private final boolean f7397jf;

    /* JADX INFO: renamed from: bF */
    @Nullable
    private String f7398bF;

    /* JADX INFO: renamed from: jg */
    static final /* synthetic */ boolean f7399jg;

    static {
        f7399jg = !C1247wo.class.desiredAssertionStatus();
        f7394ar = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game"));
        f7395as = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7690d(v1);
        }, (v1) -> {
            return new C1247wo(v1);
        });
    }

    public C1247wo(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z) {
        this.f7398bF = null;
        this.f7397jf = abstractC0787oF != null;
        this.f7396a = null;
        if (abstractC0787oF != null) {
            this.f7398bF = abstractC0787oF.m3594M();
            try {
                ByteBuf byteBufBuffer = Unpooled.buffer(InterfaceC1294xq.f8656tR);
                abstractC0787oF.mo3614a(byteBufBuffer, z);
                abstractC0787oF.m3615f(byteBufBuffer);
                this.f7396a = byteBufBuffer;
            } catch (Exception e) {
                C0562jt.m2516a("Failed to send game data update to player.", e, new Object[0]);
                this.f7396a = Unpooled.EMPTY_BUFFER;
            }
        }
    }

    public C1247wo(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f7398bF = null;
        this.f7397jf = friendlyByteBuf.readBoolean();
        if (this.f7397jf) {
            this.f7398bF = friendlyByteBuf.readUtf(32767);
            this.f7396a = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
        } else {
            this.f7396a = null;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m7690d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f7397jf);
        if (this.f7397jf) {
            if (!f7399jg && this.f7398bF == null) {
                throw new AssertionError("Game type is null!");
            }
            friendlyByteBuf.writeUtf(this.f7398bF);
            if (this.f7396a != null) {
                byte[] bArr = new byte[this.f7396a.readableBytes()];
                this.f7396a.getBytes(this.f7396a.readerIndex(), bArr);
                friendlyByteBuf.writeByteArray(bArr);
                return;
            }
            friendlyByteBuf.writeByteArray(new byte[0]);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7394ar;
    }

    /* JADX INFO: renamed from: b */
    public static void m7691b(C1247wo c1247wo, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0675m.m2927a(c1247wo, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ByteBuf m7692a() {
        return this.f7396a != null ? this.f7396a : Unpooled.EMPTY_BUFFER;
    }

    /* JADX INFO: renamed from: df */
    public boolean m7693df() {
        return this.f7397jf;
    }

    @Nullable
    /* JADX INFO: renamed from: M */
    public String m7694M() {
        return this.f7398bF;
    }

    /* JADX INFO: renamed from: dv */
    public void m7695dv() {
        if (this.f7396a != null && this.f7396a.refCnt() > 0) {
            this.f7396a.release();
        }
    }
}
