package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vV.class */
public final class C1176vV extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: k */
    @Nullable
    private final C0881pt f6401k;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final CustomPacketPayload.Type<C1176vV> f6402y = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_frozen"));

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1176vV> f6403z = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6688d(v1);
    }, (v1) -> {
        return new C1176vV(v1);
    });

    public C1176vV(@Nullable C0881pt c0881pt) {
        this.f6401k = c0881pt;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1176vV.class), C1176vV.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vV;->k:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1176vV.class), C1176vV.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vV;->k:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1176vV.class, Object.class), C1176vV.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vV;->k:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public C0881pt m6690k() {
        return this.f6401k;
    }

    public C1176vV(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean() ? C0881pt.m4588a(friendlyByteBuf) : null);
    }

    /* JADX INFO: renamed from: d */
    public void m6688d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6401k != null);
        if (this.f6401k != null) {
            this.f6401k.m4589b(friendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6402y;
    }

    /* JADX INFO: renamed from: b */
    public static void m6689b(C1176vV c1176vV, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2938a(c1176vV, iPayloadContext);
    }
}
