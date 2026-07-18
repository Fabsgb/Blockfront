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

/* JADX INFO: renamed from: com.boehmod.blockfront.vJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vJ.class */
public final class C1163vJ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dB */
    @NotNull
    private final String f6149dB;

    /* JADX INFO: renamed from: sG */
    private final int f6150sG;

    /* JADX INFO: renamed from: aB */
    @NotNull
    private final Vec3 f6151aB;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final EnumC0988rv f6152d;

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final CustomPacketPayload.Type<C1163vJ> f6153M = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_radio_point"));

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1163vJ> f6154N = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6518d(v1);
    }, C1163vJ::new);

    public C1163vJ(@NotNull String str, int i, @NotNull Vec3 vec3, @NotNull EnumC0988rv enumC0988rv) {
        this.f6149dB = str;
        this.f6150sG = i;
        this.f6151aB = vec3;
        this.f6152d = enumC0988rv;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1163vJ.class), C1163vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1163vJ.class), C1163vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1163vJ.class, Object.class), C1163vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: az */
    public String m6520az() {
        return this.f6149dB;
    }

    /* JADX INFO: renamed from: ck */
    public int m6521ck() {
        return this.f6150sG;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6522h() {
        return this.f6151aB;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0988rv m6523b() {
        return this.f6152d;
    }

    public C1163vJ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readInt(), friendlyByteBuf.readVec3(), (EnumC0988rv) friendlyByteBuf.readEnum(EnumC0988rv.class));
    }

    /* JADX INFO: renamed from: d */
    public void m6518d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6149dB);
        friendlyByteBuf.writeInt(this.f6150sG);
        friendlyByteBuf.writeVec3(this.f6151aB);
        friendlyByteBuf.writeEnum(this.f6152d);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6153M;
    }

    /* JADX INFO: renamed from: b */
    public static void m6519b(C1163vJ c1163vJ, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2944a(c1163vJ, iPayloadContext);
    }
}
