package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wl.class */
public final class C0606wl extends Record implements CustomPacketPayload {
    private final boolean je;

    @NotNull
    public static final CustomPacketPayload.Type<C0606wl> ao = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_damage_effects"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0606wl> ap = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0606wl::new);

    public C0606wl(boolean z) {
        this.je = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0606wl.class), C0606wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0606wl.class), C0606wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0606wl.class, Object.class), C0606wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean de() {
        return this.je;
    }

    public C0606wl(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.je);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ao;
    }

    public static void b(C0606wl c0606wl, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0606wl, iPayloadContext);
    }
}
