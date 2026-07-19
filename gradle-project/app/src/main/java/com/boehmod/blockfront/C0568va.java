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

/* JADX INFO: renamed from: com.boehmod.blockfront.va, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/va.class */
public final class C0568va extends Record implements CustomPacketPayload {

    @NotNull
    private final oZ b;

    @NotNull
    private final UUID F;

    @NotNull
    public static final CustomPacketPayload.Type<C0568va> e = new CustomPacketPayload.Type<>(C0265jv.d("packet_callout_waypoint"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0568va> f = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0568va::new);

    public C0568va(@NotNull oZ oZVar, @NotNull UUID uuid) {
        this.b = oZVar;
        this.F = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0568va.class), C0568va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0568va.class), C0568va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0568va.class, Object.class), C0568va.class, "calloutType;playerUUID", "FIELD:Lcom/boehmod/blockfront/va;->b:Lcom/boehmod/blockfront/oZ;", "FIELD:Lcom/boehmod/blockfront/va;->F:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public oZ b() {
        return this.b;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public UUID m1267b() {
        return this.F;
    }

    public C0568va(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((oZ) friendlyByteBuf.readEnum(oZ.class), friendlyByteBuf.readUUID());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.b);
        friendlyByteBuf.writeUUID(this.F);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return e;
    }

    public static void b(C0568va c0568va, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0568va, iPayloadContext);
    }
}
