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

/* JADX INFO: renamed from: com.boehmod.blockfront.vu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vu.class */
public final class C0588vu extends Record implements CustomPacketPayload {

    @NotNull
    private final oE a;

    @NotNull
    private final Vec3 ay;

    @NotNull
    public static final CustomPacketPayload.Type<C0588vu> x = new CustomPacketPayload.Type<>(C0265jv.d("packet_explosion"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0588vu> y = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0588vu::new);

    public C0588vu(@NotNull oE oEVar, @NotNull Vec3 vec3) {
        this.a = oEVar;
        this.ay = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0588vu.class), C0588vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0588vu.class), C0588vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0588vu.class, Object.class), C0588vu.class, "explosionType;position", "FIELD:Lcom/boehmod/blockfront/vu;->a:Lcom/boehmod/blockfront/oE;", "FIELD:Lcom/boehmod/blockfront/vu;->ay:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public oE a() {
        return this.a;
    }

    @NotNull
    public Vec3 h() {
        return this.ay;
    }

    public C0588vu(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((oE) friendlyByteBuf.readEnum(oE.class), friendlyByteBuf.readVec3());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.a);
        friendlyByteBuf.writeVec3(this.ay);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return x;
    }

    public static void b(C0588vu c0588vu, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0588vu, iPayloadContext);
    }
}
