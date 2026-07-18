package com.boehmod.blockfront;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vQ.class */
public final class C1170vQ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: d */
    @Nullable
    private final C0709mh f6183d;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Optional<C0714mm> f6184t;

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final CustomPacketPayload.Type<C1170vQ> f6185T = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sequence"));

    /* JADX INFO: renamed from: U */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1170vQ> f6186U = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6551g(v1);
    }, C1170vQ::new);

    public C1170vQ(@Nullable C0709mh c0709mh, @NotNull Optional<C0714mm> optional) {
        this.f6183d = c0709mh;
        this.f6184t = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1170vQ.class), C1170vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1170vQ.class), C1170vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1170vQ.class, Object.class), C1170vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public C0709mh m6555e() {
        return this.f6183d;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Optional<C0714mm> m6556p() {
        return this.f6184t;
    }

    public C1170vQ(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0709mh.m3206a(registryFriendlyByteBuf), m6552a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m6551g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (this.f6183d == null) {
            return;
        }
        try {
            this.f6183d.m3210a(registryFriendlyByteBuf);
            try {
                m6553a(registryFriendlyByteBuf, this.f6184t.orElse(null));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Optional<C0714mm> m6552a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (registryFriendlyByteBuf.readBoolean()) {
            return Optional.of(C0714mm.m3249a(registryFriendlyByteBuf));
        }
        return Optional.empty();
    }

    /* JADX INFO: renamed from: a */
    public static void m6553a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @Nullable C0714mm c0714mm) throws IOException {
        boolean z = c0714mm != null;
        registryFriendlyByteBuf.writeBoolean(z);
        if (z) {
            c0714mm.m3253a(registryFriendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6185T;
    }

    /* JADX INFO: renamed from: b */
    public static void m6554b(C1170vQ c1170vQ, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2962a(c1170vQ, iPayloadContext);
    }
}
