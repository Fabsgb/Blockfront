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

/* JADX INFO: renamed from: com.boehmod.blockfront.wf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wf.class */
public final class C0600wf extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID T;
    private final int sJ;
    private final int sK;

    @NotNull
    public static final CustomPacketPayload.Type<C0600wf> ai = new CustomPacketPayload.Type<>(C0265jv.d("packet_weather_transition"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0600wf> aj = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0600wf::new);

    public C0600wf(@NotNull UUID uuid, int i, int i2) {
        this.T = uuid;
        this.sJ = i;
        this.sK = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0600wf.class), C0600wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0600wf.class), C0600wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0600wf.class, Object.class), C0600wf.class, "mapEffectId;newEntryIndex;transitionTicks", "FIELD:Lcom/boehmod/blockfront/wf;->T:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wf;->sJ:I", "FIELD:Lcom/boehmod/blockfront/wf;->sK:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID n() {
        return this.T;
    }

    public int cn() {
        return this.sJ;
    }

    public int co() {
        return this.sK;
    }

    public C0600wf(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readInt(), friendlyByteBuf.readVarInt());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.T);
        friendlyByteBuf.writeInt(this.sJ);
        friendlyByteBuf.writeVarInt(this.sK);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ai;
    }

    public static void b(@NotNull C0600wf c0600wf, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0600wf, iPayloadContext);
    }
}
