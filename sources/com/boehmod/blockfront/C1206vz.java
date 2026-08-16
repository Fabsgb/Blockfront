package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vz.class */
public final class C1206vz extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: iZ */
    private final boolean f6566iZ;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final CustomPacketPayload.Type<C1206vz> f6567d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1206vz> f6568e;

    /* JADX INFO: renamed from: ja */
    static final /* synthetic */ boolean f6569ja;

    public C1206vz(boolean z) {
        this.f6566iZ = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1206vz.class), C1206vz.class, "aiming", "FIELD:Lcom/boehmod/blockfront/vz;->iZ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1206vz.class), C1206vz.class, "aiming", "FIELD:Lcom/boehmod/blockfront/vz;->iZ:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1206vz.class, Object.class), C1206vz.class, "aiming", "FIELD:Lcom/boehmod/blockfront/vz;->iZ:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cX */
    public boolean m6898cX() {
        return this.f6566iZ;
    }

    static {
        f6569ja = !C1206vz.class.desiredAssertionStatus();
        f6567d = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_aiming"));
        f6568e = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6896d(v1);
        }, C1206vz::new);
    }

    public C1206vz(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6896d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6566iZ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6567d;
    }

    /* JADX INFO: renamed from: a */
    public static void m6897a(C1206vz c1206vz, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6569ja && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0531jNM179a.m2351a().m1153a(iPayloadContext.player()).m1129ab(c1206vz.f6566iZ);
    }
}
