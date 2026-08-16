package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vK.class */
public final class C1165vK extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: ay */
    @NotNull
    private final Vec3 f6350ay;

    /* JADX INFO: renamed from: oM */
    private final float f6351oM;

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final CustomPacketPayload.Type<C1165vK> f6352o = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_damage_indicator"));

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1165vK> f6353p = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6630d(v1);
    }, C1165vK::new);

    public C1165vK(@NotNull Vec3 vec3, float f) {
        this.f6350ay = vec3;
        this.f6351oM = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1165vK.class), C1165vK.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vK;->ay:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vK;->oM:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1165vK.class), C1165vK.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vK;->ay:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vK;->oM:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1165vK.class, Object.class), C1165vK.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vK;->ay:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vK;->oM:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6632h() {
        return this.f6350ay;
    }

    /* JADX INFO: renamed from: D */
    public float m6633D() {
        return this.f6351oM;
    }

    public C1165vK(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6630d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f6350ay);
        friendlyByteBuf.writeFloat(this.f6351oM);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6352o;
    }

    /* JADX INFO: renamed from: b */
    public static void m6631b(C1165vK c1165vK, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2968a(c1165vK, iPayloadContext);
    }
}
