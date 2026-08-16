package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wO.class */
public final class C1222wO extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0847pL f6641a;

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final CustomPacketPayload.Type<C1222wO> f6642ar = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_kill_feed"));

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1222wO> f6643as = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6968g(v1);
    }, C1222wO::new);

    public C1222wO(@NotNull C0847pL c0847pL) {
        this.f6641a = c0847pL;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1222wO.class), C1222wO.class, "entry", "FIELD:Lcom/boehmod/blockfront/wO;->a:Lcom/boehmod/blockfront/pL;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1222wO.class), C1222wO.class, "entry", "FIELD:Lcom/boehmod/blockfront/wO;->a:Lcom/boehmod/blockfront/pL;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1222wO.class, Object.class), C1222wO.class, "entry", "FIELD:Lcom/boehmod/blockfront/wO;->a:Lcom/boehmod/blockfront/pL;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0847pL m6970a() {
        return this.f6641a;
    }

    public C1222wO(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0847pL.m3919a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6968g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f6641a.m3918a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6642ar;
    }

    /* JADX INFO: renamed from: b */
    public static void m6969b(C1222wO c1222wO, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2940a(c1222wO, iPayloadContext);
    }
}
