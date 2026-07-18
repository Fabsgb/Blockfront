package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wl.class */
public final class C1244wl extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: je */
    private final boolean f7384je;

    /* JADX INFO: renamed from: ao */
    @NotNull
    public static final CustomPacketPayload.Type<C1244wl> f7385ao = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_damage_effects"));

    /* JADX INFO: renamed from: ap */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1244wl> f7386ap = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7680d(v1);
    }, C1244wl::new);

    public C1244wl(boolean z) {
        this.f7384je = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1244wl.class), C1244wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1244wl.class), C1244wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1244wl.class, Object.class), C1244wl.class, "isBot", "FIELD:Lcom/boehmod/blockfront/wl;->je:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: de */
    public boolean m7682de() {
        return this.f7384je;
    }

    public C1244wl(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m7680d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f7384je);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7385ao;
    }

    /* JADX INFO: renamed from: b */
    public static void m7681b(C1244wl c1244wl, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2958a(c1244wl, iPayloadContext);
    }
}
