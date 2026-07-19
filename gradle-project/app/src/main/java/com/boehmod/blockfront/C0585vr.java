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

/* JADX INFO: renamed from: com.boehmod.blockfront.vr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vr.class */
public final class C0585vr extends Record implements CustomPacketPayload {

    @NotNull
    private final String dy;
    private final byte[] i;

    @NotNull
    public static final CustomPacketPayload.Type<C0585vr> u = new CustomPacketPayload.Type<>(C0265jv.d("packet_edit_template"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0585vr> v = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0585vr::new);

    public C0585vr(@NotNull String str, byte[] bArr) {
        this.dy = str;
        this.i = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0585vr.class), C0585vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0585vr.class), C0585vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0585vr.class, Object.class), C0585vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String B() {
        return this.dy;
    }

    public byte[] d() {
        return this.i;
    }

    public C0585vr(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.dy);
        friendlyByteBuf.writeByteArray(this.i);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return u;
    }

    public static void a(@NotNull C0585vr c0585vr, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            Item item2 = (Item) wY.A.get();
            if ((mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) && C0002a.a().m166a() != null) {
                jM jMVarA = jO.c().a(C0279ki.class);
                if (jMVarA == null) {
                    C0263jt.a("[PacketEditTemplate] Templates registry not found.", new Object[0]);
                } else if (jMVarA.a(c0585vr.dy) == null) {
                    C0263jt.a("[PacketEditTemplate] Template '%s' not found.", c0585vr.dy);
                } else {
                    jMVarA.c(c0585vr.dy, new C0279ki((pA) pB.d.decode(Unpooled.wrappedBuffer(c0585vr.i))));
                    jN.n(c0585vr.dy);
                }
            }
        }
    }
}
