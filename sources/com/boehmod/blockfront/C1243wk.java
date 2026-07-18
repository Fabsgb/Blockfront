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

/* JADX INFO: renamed from: com.boehmod.blockfront.wk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wk.class */
public final class C1243wk extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sO */
    private final int f7380sO;

    /* JADX INFO: renamed from: ck */
    @NotNull
    private final List<C1142up> f7381ck;

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final CustomPacketPayload.Type<C1243wk> f7382an = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_collision_living_client"));

    /* JADX INFO: renamed from: ao */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1243wk> f7383ao = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7676d(v1);
    }, C1243wk::new);

    public C1243wk(int i, @NotNull List<C1142up> list) {
        this.f7380sO = i;
        this.f7381ck = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1243wk.class), C1243wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1243wk.class), C1243wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1243wk.class, Object.class), C1243wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: al */
    public int m7678al() {
        return this.f7380sO;
    }

    @NotNull
    /* JADX INFO: renamed from: aN */
    public List<C1142up> m7679aN() {
        return this.f7381ck;
    }

    public C1243wk(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C1291xn.m7879b(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7676d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f7380sO);
        C1291xn.m7880b(friendlyByteBuf, this.f7381ck);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7382an;
    }

    /* JADX INFO: renamed from: b */
    public static void m7677b(C1243wk c1243wk, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2933a(c1243wk, iPayloadContext);
    }
}
