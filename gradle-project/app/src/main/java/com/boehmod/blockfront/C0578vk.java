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

/* JADX INFO: renamed from: com.boehmod.blockfront.vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vk.class */
public final class C0578vk extends Record implements CustomPacketPayload {

    @NotNull
    private final Vec3 ax;
    private final float nO;

    @NotNull
    public static final CustomPacketPayload.Type<C0578vk> o = new CustomPacketPayload.Type<>(C0265jv.d("packet_damage_indicator"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0578vk> p = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0578vk::new);

    public C0578vk(@NotNull Vec3 vec3, float f) {
        this.ax = vec3;
        this.nO = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0578vk.class), C0578vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0578vk.class), C0578vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0578vk.class, Object.class), C0578vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Vec3 h() {
        return this.ax;
    }

    public float D() {
        return this.nO;
    }

    public C0578vk(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3(), friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.ax);
        friendlyByteBuf.writeFloat(this.nO);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return o;
    }

    public static void b(C0578vk c0578vk, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0578vk, iPayloadContext);
    }
}
