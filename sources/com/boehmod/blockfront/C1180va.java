package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.va */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/va.class */
public final class C1180va extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumC0807oZ f6227b;

    /* JADX INFO: renamed from: F */
    @NotNull
    private final UUID f6228F;

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final CustomPacketPayload.Type<C1180va> f6229e = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_callout_waypoint"));

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1180va> f6230f = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6595d(v1);
    }, C1180va::new);

    public C1180va(@NotNull EnumC0807oZ enumC0807oZ, @NotNull UUID uuid) {
        this.f6227b = enumC0807oZ;
        this.f6228F = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1180va.class), C1180va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1180va.class), C1180va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1180va.class, Object.class), C1180va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0807oZ m6597b() {
        return this.f6227b;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m6598b() {
        return this.f6228F;
    }

    public C1180va(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0807oZ) friendlyByteBuf.readEnum(EnumC0807oZ.class), friendlyByteBuf.readUUID());
    }

    /* JADX INFO: renamed from: d */
    public void m6595d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6227b);
        friendlyByteBuf.writeUUID(this.f6228F);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6229e;
    }

    /* JADX INFO: renamed from: b */
    public static void m6596b(C1180va c1180va, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2947a(c1180va, iPayloadContext);
    }
}
