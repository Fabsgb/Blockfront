package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vF.class */
public final class C1159vF extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1010sQ f6129a;

    /* JADX INFO: renamed from: I */
    @NotNull
    public static final CustomPacketPayload.Type<C1159vF> f6130I = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_popup_message"));

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1159vF> f6131J = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6501g(v1);
    }, C1159vF::new);

    public C1159vF(@NotNull C1010sQ c1010sQ) {
        this.f6129a = c1010sQ;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1159vF.class), C1159vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1159vF.class), C1159vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1159vF.class, Object.class), C1159vF.class, "gamePopups", "FIELD:Lcom/boehmod/blockfront/vF;->a:Lcom/boehmod/blockfront/sQ;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1010sQ m6503a() {
        return this.f6129a;
    }

    public C1159vF(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(new C1010sQ(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6501g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f6129a.m5474f(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6130I;
    }

    /* JADX INFO: renamed from: b */
    public static void m6502b(C1159vF c1159vF, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2940a(c1159vF, iPayloadContext);
    }
}
