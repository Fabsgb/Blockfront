package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wy.class */
public final class C0619wy extends Record implements CustomPacketPayload {
    private final float og;

    @NotNull
    public static final CustomPacketPayload.Type<C0619wy> aB = new CustomPacketPayload.Type<>(C0265jv.d("packet_grenade_flash"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0619wy> aC = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0619wy::new);

    public C0619wy(float f) {
        this.og = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0619wy.class), C0619wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0619wy.class), C0619wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0619wy.class, Object.class), C0619wy.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wy;->og:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float bY() {
        return this.og;
    }

    public C0619wy(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.og);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aB;
    }

    public static void b(C0619wy c0619wy, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0619wy, iPayloadContext);
    }
}
