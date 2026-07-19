package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vE.class */
public final class vE extends Record implements CustomPacketPayload {

    @NotNull
    private final com.boehmod.blockfront.common.player.b<?, ?, ?, ?> a;

    @NotNull
    public static final CustomPacketPayload.Type<vE> H = new CustomPacketPayload.Type<>(C0265jv.d("packet_player_data"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vE> I = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vE::new);

    public vE(@NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vE.class), vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vE.class), vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vE.class, Object.class), vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public com.boehmod.blockfront.common.player.b<?, ?, ?, ?> a() {
        return this.a;
    }

    public vE(FriendlyByteBuf friendlyByteBuf) {
        this(C0635xn.a(friendlyByteBuf));
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        C0635xn.a(friendlyByteBuf, this.a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return H;
    }

    public static void b(vE vEVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vEVar, iPayloadContext);
    }
}
