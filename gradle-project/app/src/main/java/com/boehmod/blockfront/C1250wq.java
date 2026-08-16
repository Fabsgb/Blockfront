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

/* JADX INFO: renamed from: com.boehmod.blockfront.wq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wq.class */
public final class C1250wq extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: d */
    @Nullable
    private final C0680mD f6759d;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Optional<C0685mI> f6760t;

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final CustomPacketPayload.Type<C1250wq> f6761T = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sequence"));

    /* JADX INFO: renamed from: U */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1250wq> f6762U = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7077g(v1);
    }, C1250wq::new);

    public C1250wq(@Nullable C0680mD c0680mD, @NotNull Optional<C0685mI> optional) {
        this.f6759d = c0680mD;
        this.f6760t = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1250wq.class), C1250wq.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/wq;->d:Lcom/boehmod/blockfront/mD;", "FIELD:Lcom/boehmod/blockfront/wq;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1250wq.class), C1250wq.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/wq;->d:Lcom/boehmod/blockfront/mD;", "FIELD:Lcom/boehmod/blockfront/wq;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1250wq.class, Object.class), C1250wq.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/wq;->d:Lcom/boehmod/blockfront/mD;", "FIELD:Lcom/boehmod/blockfront/wq;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public C0680mD m7081e() {
        return this.f6759d;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Optional<C0685mI> m7082p() {
        return this.f6760t;
    }

    public C1250wq(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0680mD.m3037a(registryFriendlyByteBuf), m7078a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7077g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (this.f6759d == null) {
            return;
        }
        try {
            this.f6759d.m3041a(registryFriendlyByteBuf);
            try {
                m7079a(registryFriendlyByteBuf, this.f6760t.orElse(null));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static Optional<C0685mI> m7078a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (registryFriendlyByteBuf.readBoolean()) {
            return Optional.of(C0685mI.m3082a(registryFriendlyByteBuf));
        }
        return Optional.empty();
    }

    /* JADX INFO: renamed from: a */
    public static void m7079a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @Nullable C0685mI c0685mI) throws IOException {
        boolean z = c0685mI != null;
        registryFriendlyByteBuf.writeBoolean(z);
        if (z) {
            c0685mI.m3086a(registryFriendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6761T;
    }

    /* JADX INFO: renamed from: b */
    public static void m7080b(C1250wq c1250wq, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2973a(c1250wq, iPayloadContext);
    }
}
