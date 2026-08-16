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

/* JADX INFO: renamed from: com.boehmod.blockfront.wE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wE.class */
public final class C1212wE extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: V */
    @NotNull
    private final UUID f6595V;

    /* JADX INFO: renamed from: uN */
    private final int f6596uN;

    /* JADX INFO: renamed from: uO */
    private final int f6597uO;

    /* JADX INFO: renamed from: ah */
    @NotNull
    public static final CustomPacketPayload.Type<C1212wE> f6598ah = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_weather_transition"));

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1212wE> f6599ai = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6922d(v1);
    }, C1212wE::new);

    public C1212wE(@NotNull UUID uuid, int i, int i2) {
        this.f6595V = uuid;
        this.f6596uN = i;
        this.f6597uO = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1212wE.class), C1212wE.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wE;->V:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wE;->uN:I", "FIELD:Lcom/boehmod/blockfront/wE;->uO:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1212wE.class), C1212wE.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wE;->V:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wE;->uN:I", "FIELD:Lcom/boehmod/blockfront/wE;->uO:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1212wE.class, Object.class), C1212wE.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wE;->V:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wE;->uN:I", "FIELD:Lcom/boehmod/blockfront/wE;->uO:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public UUID m6924n() {
        return this.f6595V;
    }

    /* JADX INFO: renamed from: cD */
    public int m6925cD() {
        return this.f6596uN;
    }

    /* JADX INFO: renamed from: cE */
    public int m6926cE() {
        return this.f6597uO;
    }

    public C1212wE(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readInt(), friendlyByteBuf.readVarInt());
    }

    /* JADX INFO: renamed from: d */
    public void m6922d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6595V);
        friendlyByteBuf.writeInt(this.f6596uN);
        friendlyByteBuf.writeVarInt(this.f6597uO);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6598ah;
    }

    /* JADX INFO: renamed from: b */
    public static void m6923b(@NotNull C1212wE c1212wE, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2979a(c1212wE, iPayloadContext);
    }
}
