package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wF.class */
public final class C1213wF extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uP */
    private final int f6600uP;

    /* JADX INFO: renamed from: ai */
    @NotNull
    public static final CustomPacketPayload.Type<C1213wF> f6601ai = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_world_flash"));

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1213wF> f6602aj = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6927d(v1);
    }, C1213wF::new);

    public C1213wF(int i) {
        this.f6600uP = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1213wF.class), C1213wF.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wF;->uP:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1213wF.class), C1213wF.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wF;->uP:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1213wF.class, Object.class), C1213wF.class, "flashTime", "FIELD:Lcom/boehmod/blockfront/wF;->uP:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cF */
    public int m6929cF() {
        return this.f6600uP;
    }

    public C1213wF(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m6927d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6600uP);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6601ai;
    }

    /* JADX INFO: renamed from: b */
    public static void m6928b(C1213wF c1213wF, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2954a(c1213wF, iPayloadContext);
    }
}
