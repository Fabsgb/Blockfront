package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vM.class */
public final class C1167vM extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0057aa f6357a;

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final CustomPacketPayload.Type<C1167vM> f6358q = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_debug_line"));

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1167vM> f6359r = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6637d(v1);
    }, C1167vM::new);

    public C1167vM(@NotNull C0057aa c0057aa) {
        this.f6357a = c0057aa;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1167vM.class), C1167vM.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vM;->a:Lcom/boehmod/blockfront/aa;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1167vM.class), C1167vM.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vM;->a:Lcom/boehmod/blockfront/aa;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1167vM.class, Object.class), C1167vM.class, "debugLine", "FIELD:Lcom/boehmod/blockfront/vM;->a:Lcom/boehmod/blockfront/aa;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0057aa m6639a() {
        return this.f6357a;
    }

    public C1167vM(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0057aa.m257a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6637d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6357a.m258a(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6358q;
    }

    /* JADX INFO: renamed from: b */
    public static void m6638b(C1167vM c1167vM, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2966a(c1167vM, iPayloadContext);
    }
}
