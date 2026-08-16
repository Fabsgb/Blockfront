package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wI.class */
public final class C1216wI extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jv */
    private final boolean f6611jv;

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final CustomPacketPayload.Type<C1216wI> f6612al = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_bullet_damage_effects"));

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1216wI> f6613am = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6938d(v1);
    }, C1216wI::new);

    public C1216wI(boolean z) {
        this.f6611jv = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1216wI.class), C1216wI.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wI;->jv:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1216wI.class), C1216wI.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wI;->jv:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1216wI.class, Object.class), C1216wI.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wI;->jv:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: dn */
    public boolean m6940dn() {
        return this.f6611jv;
    }

    public C1216wI(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6938d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6611jv);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6612al;
    }

    /* JADX INFO: renamed from: b */
    public static void m6939b(C1216wI c1216wI, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2969a(c1216wI, iPayloadContext);
    }
}
