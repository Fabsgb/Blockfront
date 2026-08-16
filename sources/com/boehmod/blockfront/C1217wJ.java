package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wJ.class */
public final class C1217wJ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uS */
    private final int f6614uS;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0403gs f6615b;

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final CustomPacketPayload.Type<C1217wJ> f6616am = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_bullet_tracer_to_client"));

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1217wJ> f6617an = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6941g(v1);
    }, C1217wJ::new);

    public C1217wJ(int i, @NotNull C0403gs c0403gs) {
        this.f6614uS = i;
        this.f6615b = c0403gs;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1217wJ.class), C1217wJ.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wJ;->uS:I", "FIELD:Lcom/boehmod/blockfront/wJ;->b:Lcom/boehmod/blockfront/gs;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1217wJ.class), C1217wJ.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wJ;->uS:I", "FIELD:Lcom/boehmod/blockfront/wJ;->b:Lcom/boehmod/blockfront/gs;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1217wJ.class, Object.class), C1217wJ.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wJ;->uS:I", "FIELD:Lcom/boehmod/blockfront/wJ;->b:Lcom/boehmod/blockfront/gs;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: aB */
    public int m6943aB() {
        return this.f6614uS;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0403gs m6944b() {
        return this.f6615b;
    }

    public C1217wJ(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readInt(), C0403gs.m1912a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6941g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.f6614uS);
        this.f6615b.m1919a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6616am;
    }

    /* JADX INFO: renamed from: b */
    public static void m6942b(C1217wJ c1217wJ, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2952a(c1217wJ, iPayloadContext);
    }
}
