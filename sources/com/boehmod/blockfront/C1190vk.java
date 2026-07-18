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

/* JADX INFO: renamed from: com.boehmod.blockfront.vk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vk.class */
public final class C1190vk extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: ax */
    @NotNull
    private final Vec3 f6266ax;

    /* JADX INFO: renamed from: nO */
    private final float f6267nO;

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final CustomPacketPayload.Type<C1190vk> f6268o = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_damage_indicator"));

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1190vk> f6269p = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6635d(v1);
    }, C1190vk::new);

    public C1190vk(@NotNull Vec3 vec3, float f) {
        this.f6266ax = vec3;
        this.f6267nO = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1190vk.class), C1190vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1190vk.class), C1190vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1190vk.class, Object.class), C1190vk.class, "position;alpha", "FIELD:Lcom/boehmod/blockfront/vk;->ax:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vk;->nO:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6637h() {
        return this.f6266ax;
    }

    /* JADX INFO: renamed from: D */
    public float m6638D() {
        return this.f6267nO;
    }

    public C1190vk(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6635d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f6266ax);
        friendlyByteBuf.writeFloat(this.f6267nO);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6268o;
    }

    /* JADX INFO: renamed from: b */
    public static void m6636b(C1190vk c1190vk, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2957a(c1190vk, iPayloadContext);
    }
}
