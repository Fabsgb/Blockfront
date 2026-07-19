package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vF.class */
public final class vF extends Record implements CustomPacketPayload {

    @NotNull
    private final sQ a;

    @NotNull
    public static final CustomPacketPayload.Type<vF> I = new CustomPacketPayload.Type<>(C0265jv.d("packet_popup_message"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, vF> J = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, vF::new);

    public vF(@NotNull sQ sQVar) {
        this.a = sQVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vF.class), vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vF.class), vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vF.class, Object.class), vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public sQ a() {
        return this.a;
    }

    public vF(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(new sQ(registryFriendlyByteBuf));
    }

    public void g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a.f(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return I;
    }

    public static void b(vF vFVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vFVar, iPayloadContext);
    }
}
