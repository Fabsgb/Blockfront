package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vw.class */
public final class C0590vw extends Record implements CustomPacketPayload {

    @Nullable
    private final oX k;

    @NotNull
    public static final CustomPacketPayload.Type<C0590vw> z = new CustomPacketPayload.Type<>(C0265jv.d("packet_frozen"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0590vw> A = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, (v1) -> {
        return new C0590vw(v1);
    });

    public C0590vw(@Nullable oX oXVar) {
        this.k = oXVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0590vw.class), C0590vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0590vw.class), C0590vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0590vw.class, Object.class), C0590vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public oX k() {
        return this.k;
    }

    public C0590vw(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean() ? oX.a(friendlyByteBuf) : null);
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.k != null);
        if (this.k != null) {
            this.k.b(friendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return z;
    }

    public static void b(C0590vw c0590vw, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0590vw, iPayloadContext);
    }
}
