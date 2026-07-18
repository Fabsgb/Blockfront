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

/* JADX INFO: renamed from: com.boehmod.blockfront.wi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wi.class */
public final class C1241wi extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sM */
    private final int f7365sM;

    /* JADX INFO: renamed from: ci */
    @NotNull
    private final List<C1141uo> f7366ci;

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final CustomPacketPayload.Type<C1241wi> f7367al = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_collision_block_client"));

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1241wi> f7368am = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7661d(v1);
    }, C1241wi::new);

    public C1241wi(int i, @NotNull List<C1141uo> list) {
        this.f7365sM = i;
        this.f7366ci = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1241wi.class), C1241wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1241wi.class), C1241wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1241wi.class, Object.class), C1241wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cq */
    public int m7663cq() {
        return this.f7365sM;
    }

    @NotNull
    /* JADX INFO: renamed from: aL */
    public List<C1141uo> m7664aL() {
        return this.f7366ci;
    }

    public C1241wi(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C1291xn.m7877a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7661d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f7365sM);
        C1291xn.m7878a(friendlyByteBuf, this.f7366ci);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7367al;
    }

    /* JADX INFO: renamed from: b */
    public static void m7662b(C1241wi c1241wi, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2934a(c1241wi, iPayloadContext);
    }
}
