package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vE.class */
public final class C1158vE extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0182b<?, ?, ?, ?> f6126a;

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final CustomPacketPayload.Type<C1158vE> f6127H = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_player_data"));

    /* JADX INFO: renamed from: I */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1158vE> f6128I = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6498d(v1);
    }, C1158vE::new);

    public C1158vE(@NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        this.f6126a = abstractC0182b;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1158vE.class), C1158vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1158vE.class), C1158vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1158vE.class, Object.class), C1158vE.class, "playerData", "FIELD:Lcom/boehmod/blockfront/vE;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0182b<?, ?, ?, ?> m6500a() {
        return this.f6126a;
    }

    public C1158vE(FriendlyByteBuf friendlyByteBuf) {
        this(C1291xn.m7873a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6498d(FriendlyByteBuf friendlyByteBuf) {
        C1291xn.m7874a(friendlyByteBuf, this.f6126a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6127H;
    }

    /* JADX INFO: renamed from: b */
    public static void m6499b(C1158vE c1158vE, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2930a(c1158vE, iPayloadContext);
    }
}
