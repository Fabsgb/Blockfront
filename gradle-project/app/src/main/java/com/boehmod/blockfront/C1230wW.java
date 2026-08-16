package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wW.class */
public final class C1230wW extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: pe */
    private final float f6676pe;

    /* JADX INFO: renamed from: az */
    @NotNull
    public static final CustomPacketPayload.Type<C1230wW> f6677az = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_grenade_flash"));

    /* JADX INFO: renamed from: aA */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1230wW> f6678aA = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7000d(v1);
    }, C1230wW::new);

    public C1230wW(float f) {
        this.f6676pe = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1230wW.class), C1230wW.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wW;->pe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1230wW.class), C1230wW.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wW;->pe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1230wW.class, Object.class), C1230wW.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wW;->pe:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: ce */
    public float m7002ce() {
        return this.f6676pe;
    }

    public C1230wW(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7000d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f6676pe);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6677az;
    }

    /* JADX INFO: renamed from: b */
    public static void m7001b(C1230wW c1230wW, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2946a(c1230wW, iPayloadContext);
    }
}
