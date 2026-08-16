package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wG.class */
public final class C1214wG extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uQ */
    private final int f6603uQ;

    /* JADX INFO: renamed from: cq */
    @NotNull
    private final List<C1114uM> f6604cq;

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final CustomPacketPayload.Type<C1214wG> f6605aj = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_bullet_collision_block_client"));

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1214wG> f6606ak = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6930d(v1);
    }, C1214wG::new);

    public C1214wG(int i, @NotNull List<C1114uM> list) {
        this.f6603uQ = i;
        this.f6604cq = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1214wG.class), C1214wG.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wG;->uQ:I", "FIELD:Lcom/boehmod/blockfront/wG;->cq:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1214wG.class), C1214wG.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wG;->uQ:I", "FIELD:Lcom/boehmod/blockfront/wG;->cq:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1214wG.class, Object.class), C1214wG.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wG;->uQ:I", "FIELD:Lcom/boehmod/blockfront/wG;->cq:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cG */
    public int m6932cG() {
        return this.f6603uQ;
    }

    @NotNull
    /* JADX INFO: renamed from: aS */
    public List<C1114uM> m6933aS() {
        return this.f6604cq;
    }

    public C1214wG(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C1271xK.m7204a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6930d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6603uQ);
        C1271xK.m7205a(friendlyByteBuf, this.f6604cq);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6605aj;
    }

    /* JADX INFO: renamed from: b */
    public static void m6931b(C1214wG c1214wG, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2945a(c1214wG, iPayloadContext);
    }
}
