package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wg.class */
public final class C0601wg extends Record implements CustomPacketPayload {
    private final int sL;

    @NotNull
    public static final CustomPacketPayload.Type<C0601wg> aj = new CustomPacketPayload.Type<>(C0265jv.d("packet_world_flash"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0601wg> ak = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0601wg::new);

    public C0601wg(int i) {
        this.sL = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0601wg.class), C0601wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0601wg.class), C0601wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0601wg.class, Object.class), C0601wg.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wg;->sL:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int cp() {
        return this.sL;
    }

    public C0601wg(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sL);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aj;
    }

    public static void b(C0601wg c0601wg, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0601wg, iPayloadContext);
    }
}
