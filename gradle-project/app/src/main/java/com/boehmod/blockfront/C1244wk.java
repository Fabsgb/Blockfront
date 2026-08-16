package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wk.class */
public final class C1244wk extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: O */
    @NotNull
    private final UUID f6731O;

    /* JADX INFO: renamed from: P */
    @NotNull
    private final UUID f6732P;

    /* JADX INFO: renamed from: aD */
    @NotNull
    private final Vec3 f6733aD;

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final CustomPacketPayload.Type<C1244wk> f6734N = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_regular_ping"));

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1244wk> f6735O = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7051d(v1);
    }, C1244wk::new);

    public C1244wk(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f6731O = uuid;
        this.f6732P = uuid2;
        this.f6733aD = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1244wk.class), C1244wk.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/wk;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1244wk.class), C1244wk.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/wk;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1244wk.class, Object.class), C1244wk.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/wk;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wk;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public UUID m7053o() {
        return this.f6731O;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m7054p() {
        return this.f6732P;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7055h() {
        return this.f6733aD;
    }

    public C1244wk(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m7051d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6731O);
        friendlyByteBuf.writeUUID(this.f6732P);
        friendlyByteBuf.writeVec3(this.f6733aD);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6734N;
    }

    /* JADX INFO: renamed from: b */
    public static void m7052b(C1244wk c1244wk, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2977a(c1244wk, iPayloadContext);
    }
}
