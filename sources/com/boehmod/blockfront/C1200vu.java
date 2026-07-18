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

/* JADX INFO: renamed from: com.boehmod.blockfront.vu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vu.class */
public final class C1200vu extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0786oE f6313a;

    /* JADX INFO: renamed from: ay */
    @NotNull
    private final Vec3 f6314ay;

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final CustomPacketPayload.Type<C1200vu> f6315x = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_explosion"));

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1200vu> f6316y = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6689d(v1);
    }, C1200vu::new);

    public C1200vu(@NotNull EnumC0786oE enumC0786oE, @NotNull Vec3 vec3) {
        this.f6313a = enumC0786oE;
        this.f6314ay = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1200vu.class), C1200vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1200vu.class), C1200vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1200vu.class, Object.class), C1200vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0786oE m6691a() {
        return this.f6313a;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6692h() {
        return this.f6314ay;
    }

    public C1200vu(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0786oE) friendlyByteBuf.readEnum(EnumC0786oE.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6689d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6313a);
        friendlyByteBuf.writeVec3(this.f6314ay);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6315x;
    }

    /* JADX INFO: renamed from: b */
    public static void m6690b(C1200vu c1200vu, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2946a(c1200vu, iPayloadContext);
    }
}
