package com.boehmod.blockfront;

import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vR.class */
public final class C1172vR extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dJ */
    @NotNull
    private final String f6377dJ;

    /* JADX INFO: renamed from: i */
    private final byte[] f6378i;

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final CustomPacketPayload.Type<C1172vR> f6379u = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_edit_template"));

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1172vR> f6380v = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6664d(v1);
    }, C1172vR::new);

    public C1172vR(@NotNull String str, byte[] bArr) {
        this.f6377dJ = str;
        this.f6378i = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1172vR.class), C1172vR.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vR;->dJ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vR;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1172vR.class), C1172vR.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vR;->dJ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vR;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1172vR.class, Object.class), C1172vR.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vR;->dJ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vR;->i:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: I */
    public String m6666I() {
        return this.f6377dJ;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6667d() {
        return this.f6378i;
    }

    public C1172vR(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6664d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6377dJ);
        friendlyByteBuf.writeByteArray(this.f6378i);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6379u;
    }

    /* JADX INFO: renamed from: a */
    public static void m6665a(@NotNull C1172vR c1172vR, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            Item item2 = (Item) C1308xv.f7695A.get();
            if ((mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) && C0030a.m175a().m179a() != null) {
                C0605ki c0605kiM2737a = C0607kk.m2734c().m2737a(C0575kE.class);
                if (c0605kiM2737a == null) {
                    C0530jM.m2337a("[PacketEditTemplate] Templates registry not found.", new Object[0]);
                } else if (c0605kiM2737a.m2707a(c1172vR.f6377dJ) == null) {
                    C0530jM.m2337a("[PacketEditTemplate] Template '%s' not found.", c1172vR.f6377dJ);
                } else {
                    c0605kiM2737a.m2714c(c1172vR.f6377dJ, new C0575kE((AbstractC0858pW) C0859pX.f4606d.decode(Unpooled.wrappedBuffer(c1172vR.f6378i))));
                    C0606kj.m2729n(c1172vR.f6377dJ);
                }
            }
        }
    }
}
