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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vQ.class */
public final class vQ extends Record implements CustomPacketPayload {

    @Nullable
    private final C0332mh d;

    @NotNull
    private final Optional<C0337mm> t;

    @NotNull
    public static final CustomPacketPayload.Type<vQ> T = new CustomPacketPayload.Type<>(C0265jv.d("packet_sequence"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, vQ> U = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, vQ::new);

    public vQ(@Nullable C0332mh c0332mh, @NotNull Optional<C0337mm> optional) {
        this.d = c0332mh;
        this.t = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vQ.class), vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vQ.class), vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vQ.class, Object.class), vQ.class, "sequence;settings", "FIELD:Lcom/boehmod/blockfront/vQ;->d:Lcom/boehmod/blockfront/mh;", "FIELD:Lcom/boehmod/blockfront/vQ;->t:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public C0332mh e() {
        return this.d;
    }

    @NotNull
    public Optional<C0337mm> p() {
        return this.t;
    }

    public vQ(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0332mh.a(registryFriendlyByteBuf), a(registryFriendlyByteBuf));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (this.d == null) {
            return;
        }
        try {
            this.d.m694a(registryFriendlyByteBuf);
            try {
                a(registryFriendlyByteBuf, this.t.orElse(null));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Optional<C0337mm> a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        if (registryFriendlyByteBuf.readBoolean()) {
            return Optional.of(C0337mm.a(registryFriendlyByteBuf));
        }
        return Optional.empty();
    }

    public static void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @Nullable C0337mm c0337mm) throws IOException {
        boolean z = c0337mm != null;
        registryFriendlyByteBuf.writeBoolean(z);
        if (z) {
            c0337mm.m700a(registryFriendlyByteBuf);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return T;
    }

    public static void b(vQ vQVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vQVar, iPayloadContext);
    }
}
