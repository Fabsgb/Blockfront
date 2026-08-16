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

/* JADX INFO: renamed from: com.boehmod.blockfront.wH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wH.class */
public final class C1215wH extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uR */
    private final int f6607uR;

    /* JADX INFO: renamed from: cr */
    @NotNull
    private final List<C1115uN> f6608cr;

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final CustomPacketPayload.Type<C1215wH> f6609ak = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_bullet_collision_living_client"));

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1215wH> f6610al = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6934d(v1);
    }, C1215wH::new);

    public C1215wH(int i, @NotNull List<C1115uN> list) {
        this.f6607uR = i;
        this.f6608cr = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1215wH.class), C1215wH.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wH;->uR:I", "FIELD:Lcom/boehmod/blockfront/wH;->cr:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1215wH.class), C1215wH.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wH;->uR:I", "FIELD:Lcom/boehmod/blockfront/wH;->cr:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1215wH.class, Object.class), C1215wH.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wH;->uR:I", "FIELD:Lcom/boehmod/blockfront/wH;->cr:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: aB */
    public int m6936aB() {
        return this.f6607uR;
    }

    @NotNull
    /* JADX INFO: renamed from: aT */
    public List<C1115uN> m6937aT() {
        return this.f6608cr;
    }

    public C1215wH(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C1271xK.m7206b(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6934d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6607uR);
        C1271xK.m7207b(friendlyByteBuf, this.f6608cr);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6609ak;
    }

    /* JADX INFO: renamed from: b */
    public static void m6935b(C1215wH c1215wH, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2944a(c1215wH, iPayloadContext);
    }
}
