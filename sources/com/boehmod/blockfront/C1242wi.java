package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wi.class */
public final class C1242wi extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dM */
    @NotNull
    private final String f6722dM;

    /* JADX INFO: renamed from: uK */
    private final int f6723uK;

    /* JADX INFO: renamed from: aC */
    @NotNull
    private final Vec3 f6724aC;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final EnumC0960rS f6725d;

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final CustomPacketPayload.Type<C1242wi> f6726L = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_radio_point"));

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1242wi> f6727M = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7041d(v1);
    }, C1242wi::new);

    public C1242wi(@NotNull String str, int i, @NotNull Vec3 vec3, @NotNull EnumC0960rS enumC0960rS) {
        this.f6722dM = str;
        this.f6723uK = i;
        this.f6724aC = vec3;
        this.f6725d = enumC0960rS;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1242wi.class), C1242wi.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/wi;->dM:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wi;->uK:I", "FIELD:Lcom/boehmod/blockfront/wi;->aC:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wi;->d:Lcom/boehmod/blockfront/rS;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1242wi.class), C1242wi.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/wi;->dM:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wi;->uK:I", "FIELD:Lcom/boehmod/blockfront/wi;->aC:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wi;->d:Lcom/boehmod/blockfront/rS;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1242wi.class, Object.class), C1242wi.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/wi;->dM:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wi;->uK:I", "FIELD:Lcom/boehmod/blockfront/wi;->aC:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wi;->d:Lcom/boehmod/blockfront/rS;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aG */
    public String m7043aG() {
        return this.f6722dM;
    }

    /* JADX INFO: renamed from: cA */
    public int m7044cA() {
        return this.f6723uK;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7045h() {
        return this.f6724aC;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0960rS m7046b() {
        return this.f6725d;
    }

    public C1242wi(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readInt(), friendlyByteBuf.readVec3(), (EnumC0960rS) friendlyByteBuf.readEnum(EnumC0960rS.class));
    }

    /* JADX INFO: renamed from: d */
    public void m7041d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6722dM);
        friendlyByteBuf.writeInt(this.f6723uK);
        friendlyByteBuf.writeVec3(this.f6724aC);
        friendlyByteBuf.writeEnum(this.f6725d);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6726L;
    }

    /* JADX INFO: renamed from: b */
    public static void m7042b(C1242wi c1242wi, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2955a(c1242wi, iPayloadContext);
    }
}
