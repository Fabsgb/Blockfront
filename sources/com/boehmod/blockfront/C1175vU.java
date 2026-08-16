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

/* JADX INFO: renamed from: com.boehmod.blockfront.vU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vU.class */
public final class C1175vU extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0862pa f6397a;

    /* JADX INFO: renamed from: az */
    @NotNull
    private final Vec3 f6398az;

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final CustomPacketPayload.Type<C1175vU> f6399x = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_explosion"));

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1175vU> f6400y = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6684d(v1);
    }, C1175vU::new);

    public C1175vU(@NotNull EnumC0862pa enumC0862pa, @NotNull Vec3 vec3) {
        this.f6397a = enumC0862pa;
        this.f6398az = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1175vU.class), C1175vU.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vU;->a:Lcom/boehmod/blockfront/pa;", "FIELD:Lcom/boehmod/blockfront/vU;->az:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1175vU.class), C1175vU.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vU;->a:Lcom/boehmod/blockfront/pa;", "FIELD:Lcom/boehmod/blockfront/vU;->az:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1175vU.class, Object.class), C1175vU.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vU;->a:Lcom/boehmod/blockfront/pa;", "FIELD:Lcom/boehmod/blockfront/vU;->az:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0862pa m6686a() {
        return this.f6397a;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6687h() {
        return this.f6398az;
    }

    public C1175vU(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0862pa) friendlyByteBuf.readEnum(EnumC0862pa.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6684d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6397a);
        friendlyByteBuf.writeVec3(this.f6398az);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6399x;
    }

    /* JADX INFO: renamed from: b */
    public static void m6685b(C1175vU c1175vU, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2957a(c1175vU, iPayloadContext);
    }
}
