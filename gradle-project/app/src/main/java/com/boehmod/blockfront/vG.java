package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vG.class */
public final class vG extends Record implements CustomPacketPayload {

    @NotNull
    private final hG O;

    @NotNull
    private final Vector3f n;
    private final float nS;

    @NotNull
    public static final CustomPacketPayload.Type<vG> J = new CustomPacketPayload.Type<>(C0265jv.d("packet_positioned_shake_node"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vG> K = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vG::new);

    public vG(@NotNull hG hGVar, @NotNull Vector3f vector3f, float f) {
        this.O = hGVar;
        this.n = vector3f;
        this.nS = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vG.class), vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vG.class), vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vG.class, Object.class), vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public hG b() {
        return this.O;
    }

    @NotNull
    public Vector3f d() {
        return this.n;
    }

    public float bQ() {
        return this.nS;
    }

    public vG(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(hG.a(friendlyByteBuf), friendlyByteBuf.readVector3f(), friendlyByteBuf.readFloat());
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        this.O.b(friendlyByteBuf);
        friendlyByteBuf.writeVector3f(this.n);
        friendlyByteBuf.writeFloat(this.nS);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return J;
    }

    public static void b(vG vGVar, @NotNull IPayloadContext iPayloadContext) {
        c(vGVar, iPayloadContext);
    }

    @OnlyIn(Dist.CLIENT)
    public static void c(vG vGVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vGVar, iPayloadContext);
    }
}
