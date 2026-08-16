package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.we */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/we.class */
public final class C1238we extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1088tn f6702a;

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final CustomPacketPayload.Type<C1238we> f6703H = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_popup_message"));

    /* JADX INFO: renamed from: I */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1238we> f6704I = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7024g(v1);
    }, C1238we::new);

    public C1238we(@NotNull C1088tn c1088tn) {
        this.f6702a = c1088tn;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1238we.class), C1238we.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/we;->a:Lcom/boehmod/blockfront/tn;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1238we.class), C1238we.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/we;->a:Lcom/boehmod/blockfront/tn;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1238we.class, Object.class), C1238we.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/we;->a:Lcom/boehmod/blockfront/tn;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1088tn m7026a() {
        return this.f6702a;
    }

    public C1238we(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(new C1088tn(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7024g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f6702a.m5962f(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6703H;
    }

    /* JADX INFO: renamed from: b */
    public static void m7025b(C1238we c1238we, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2951a(c1238we, iPayloadContext);
    }
}
