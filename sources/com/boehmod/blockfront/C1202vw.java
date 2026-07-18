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

/* JADX INFO: renamed from: com.boehmod.blockfront.vw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vw.class */
public final class C1202vw extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: k */
    @Nullable
    private final C0805oX f6320k;

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final CustomPacketPayload.Type<C1202vw> f6321z = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_frozen"));

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1202vw> f6322A = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6695d(v1);
    }, (v1) -> {
        return new C1202vw(v1);
    });

    public C1202vw(@Nullable C0805oX c0805oX) {
        this.f6320k = c0805oX;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1202vw.class), C1202vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1202vw.class), C1202vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1202vw.class, Object.class), C1202vw.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vw;->k:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public C0805oX m6697k() {
        return this.f6320k;
    }

    public C1202vw(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean() ? C0805oX.m4151a(friendlyByteBuf) : null);
    }

    /* JADX INFO: renamed from: d */
    public void m6695d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6320k != null);
        if (this.f6320k != null) {
            this.f6320k.m4152b(friendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6321z;
    }

    /* JADX INFO: renamed from: b */
    public static void m6696b(C1202vw c1202vw, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2926a(c1202vw, iPayloadContext);
    }
}
