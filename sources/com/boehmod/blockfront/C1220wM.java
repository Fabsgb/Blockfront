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

/* JADX INFO: renamed from: com.boehmod.blockfront.wM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wM.class */
public class C1220wM implements CustomPacketPayload {

    /* JADX INFO: renamed from: ap */
    @NotNull
    public static final CustomPacketPayload.Type<C1220wM> f6631ap;

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1220wM> f6632aq;

    /* JADX INFO: renamed from: a */
    @Nullable
    private ByteBuf f6633a;

    /* JADX INFO: renamed from: jx */
    private final boolean f6634jx;

    /* JADX INFO: renamed from: bO */
    @Nullable
    private String f6635bO;

    /* JADX INFO: renamed from: jy */
    static final /* synthetic */ boolean f6636jy;

    static {
        f6636jy = !C1220wM.class.desiredAssertionStatus();
        f6631ap = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game"));
        f6632aq = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6958d(v1);
        }, (v1) -> {
            return new C1220wM(v1);
        });
    }

    public C1220wM(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z) {
        this.f6635bO = null;
        this.f6634jx = abstractC0863pb != null;
        this.f6633a = null;
        if (abstractC0863pb != null) {
            this.f6635bO = abstractC0863pb.m4030T();
            try {
                ByteBuf byteBufBuffer = Unpooled.buffer(1024);
                abstractC0863pb.mo4050a(byteBufBuffer, z);
                abstractC0863pb.m4051f(byteBufBuffer);
                this.f6633a = byteBufBuffer;
            } catch (Exception e) {
                C0530jM.m2338a("Failed to send game data update to player.", e, new Object[0]);
                this.f6633a = Unpooled.EMPTY_BUFFER;
            }
        }
    }

    public C1220wM(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6635bO = null;
        this.f6634jx = friendlyByteBuf.readBoolean();
        if (this.f6634jx) {
            this.f6635bO = friendlyByteBuf.readUtf(32767);
            this.f6633a = Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray());
        } else {
            this.f6633a = null;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6958d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6634jx);
        if (this.f6634jx) {
            if (!f6636jy && this.f6635bO == null) {
                throw new AssertionError("Game type is null!");
            }
            friendlyByteBuf.writeUtf(this.f6635bO);
            if (this.f6633a != null) {
                byte[] bArr = new byte[this.f6633a.readableBytes()];
                this.f6633a.getBytes(this.f6633a.readerIndex(), bArr);
                friendlyByteBuf.writeByteArray(bArr);
                return;
            }
            friendlyByteBuf.writeByteArray(new byte[0]);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6631ap;
    }

    /* JADX INFO: renamed from: b */
    public static void m6959b(C1220wM c1220wM, @NotNull IPayloadContext iPayloadContext) {
        try {
            C0676m.m2939a(c1220wM, iPayloadContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ByteBuf m6960a() {
        return this.f6633a != null ? this.f6633a : Unpooled.EMPTY_BUFFER;
    }

    /* JADX INFO: renamed from: do */
    public boolean m6961do() {
        return this.f6634jx;
    }

    @Nullable
    /* JADX INFO: renamed from: T */
    public String m6962T() {
        return this.f6635bO;
    }

    /* JADX INFO: renamed from: dF */
    public void m6963dF() {
        if (this.f6633a != null && this.f6633a.refCnt() > 0) {
            this.f6633a.release();
        }
    }
}
