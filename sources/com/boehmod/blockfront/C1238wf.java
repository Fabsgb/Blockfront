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

/* JADX INFO: renamed from: com.boehmod.blockfront.wf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wf.class */
public final class C1238wf extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: T */
    @NotNull
    private final UUID f7353T;

    /* JADX INFO: renamed from: sJ */
    private final int f7354sJ;

    /* JADX INFO: renamed from: sK */
    private final int f7355sK;

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final CustomPacketPayload.Type<C1238wf> f7356ai = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_weather_transition"));

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1238wf> f7357aj = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7650d(v1);
    }, C1238wf::new);

    public C1238wf(@NotNull UUID uuid, int i, int i2) {
        this.f7353T = uuid;
        this.f7354sJ = i;
        this.f7355sK = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1238wf.class), C1238wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1238wf.class), C1238wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1238wf.class, Object.class), C1238wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public UUID m7652n() {
        return this.f7353T;
    }

    /* JADX INFO: renamed from: cn */
    public int m7653cn() {
        return this.f7354sJ;
    }

    /* JADX INFO: renamed from: co */
    public int m7654co() {
        return this.f7355sK;
    }

    public C1238wf(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readInt(), friendlyByteBuf.readVarInt());
    }

    /* JADX INFO: renamed from: d */
    public void m7650d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f7353T);
        friendlyByteBuf.writeInt(this.f7354sJ);
        friendlyByteBuf.writeVarInt(this.f7355sK);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7356ai;
    }

    /* JADX INFO: renamed from: b */
    public static void m7651b(@NotNull C1238wf c1238wf, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2968a(c1238wf, iPayloadContext);
    }
}
