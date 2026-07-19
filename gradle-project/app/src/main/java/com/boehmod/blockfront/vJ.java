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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vJ.class */
public final class vJ extends Record implements CustomPacketPayload {

    @NotNull
    private final String dB;
    private final int sG;

    @NotNull
    private final Vec3 aB;

    @NotNull
    private final EnumC0481rv d;

    @NotNull
    public static final CustomPacketPayload.Type<vJ> M = new CustomPacketPayload.Type<>(C0265jv.d("packet_radio_point"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vJ> N = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vJ::new);

    public vJ(@NotNull String str, int i, @NotNull Vec3 vec3, @NotNull EnumC0481rv enumC0481rv) {
        this.dB = str;
        this.sG = i;
        this.aB = vec3;
        this.d = enumC0481rv;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vJ.class), vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vJ.class), vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vJ.class, Object.class), vJ.class, "icon;time;position;gameEventType", "FIELD:Lcom/boehmod/blockfront/vJ;->dB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->sG:I", "FIELD:Lcom/boehmod/blockfront/vJ;->aB:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vJ;->d:Lcom/boehmod/blockfront/rv;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String az() {
        return this.dB;
    }

    public int ck() {
        return this.sG;
    }

    @NotNull
    public Vec3 h() {
        return this.aB;
    }

    @NotNull
    public EnumC0481rv b() {
        return this.d;
    }

    public vJ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readInt(), friendlyByteBuf.readVec3(), (EnumC0481rv) friendlyByteBuf.readEnum(EnumC0481rv.class));
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.dB);
        friendlyByteBuf.writeInt(this.sG);
        friendlyByteBuf.writeVec3(this.aB);
        friendlyByteBuf.writeEnum(this.d);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return M;
    }

    public static void b(vJ vJVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vJVar, iPayloadContext);
    }
}
