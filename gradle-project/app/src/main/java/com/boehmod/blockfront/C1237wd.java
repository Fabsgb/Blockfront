package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wd.class */
public final class C1237wd extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0183b<?, ?, ?, ?> f6699a;

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final CustomPacketPayload.Type<C1237wd> f6700G = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_player_data"));

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1237wd> f6701H = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7021d(v1);
    }, C1237wd::new);

    public C1237wd(@NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        this.f6699a = abstractC0183b;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1237wd.class), C1237wd.class, "playerData", "FIELD:Lcom/boehmod/blockfront/wd;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1237wd.class), C1237wd.class, "playerData", "FIELD:Lcom/boehmod/blockfront/wd;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1237wd.class, Object.class), C1237wd.class, "playerData", "FIELD:Lcom/boehmod/blockfront/wd;->a:Lcom/boehmod/blockfront/common/player/b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0183b<?, ?, ?, ?> m7023a() {
        return this.f6699a;
    }

    public C1237wd(FriendlyByteBuf friendlyByteBuf) {
        this(C1271xK.m7200a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7021d(FriendlyByteBuf friendlyByteBuf) {
        C1271xK.m7201a(friendlyByteBuf, this.f6699a);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6700G;
    }

    /* JADX INFO: renamed from: b */
    public static void m7022b(C1237wd c1237wd, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2942a(c1237wd, iPayloadContext);
    }
}
