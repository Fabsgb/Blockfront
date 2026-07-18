package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uZ.class */
public final class C1126uZ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: iF */
    private final boolean f5927iF;

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final CustomPacketPayload.Type<C1126uZ> f5928d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1126uZ> f5929e;

    /* JADX INFO: renamed from: iG */
    static final /* synthetic */ boolean f5930iG;

    public C1126uZ(boolean z) {
        this.f5927iF = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1126uZ.class), C1126uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1126uZ.class), C1126uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1126uZ.class, Object.class), C1126uZ.class, "aiming", "FIELD:Lcom/boehmod/blockfront/uZ;->iF:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cO */
    public boolean m6245cO() {
        return this.f5927iF;
    }

    static {
        f5930iG = !C1126uZ.class.desiredAssertionStatus();
        f5928d = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_aiming"));
        f5929e = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6243d(v1);
        }, C1126uZ::new);
    }

    public C1126uZ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6243d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f5927iF);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f5928d;
    }

    /* JADX INFO: renamed from: a */
    public static void m6244a(C1126uZ c1126uZ, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f5930iG && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0563juM168a.m2528a().m1136a(iPayloadContext.player()).m1112aa(c1126uZ.f5927iF);
    }
}
