package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wo.class */
public final class C1248wo extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: T */
    @NotNull
    private final UUID f6750T;

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final CustomPacketPayload.Type<C1248wo> f6751R = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_report_chat_message"));

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1248wo> f6752S = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7068d(v1);
    }, C1248wo::new);

    public C1248wo(@NotNull UUID uuid) {
        this.f6750T = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1248wo.class), C1248wo.class, "messageUUID", "FIELD:Lcom/boehmod/blockfront/wo;->T:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1248wo.class), C1248wo.class, "messageUUID", "FIELD:Lcom/boehmod/blockfront/wo;->T:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1248wo.class, Object.class), C1248wo.class, "messageUUID", "FIELD:Lcom/boehmod/blockfront/wo;->T:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public UUID m7070q() {
        return this.f6750T;
    }

    public C1248wo(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID());
    }

    /* JADX INFO: renamed from: d */
    public void m7068d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6750T);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6751R;
    }

    /* JADX INFO: renamed from: a */
    public static void m7069a(@NotNull C1248wo c1248wo, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C1280xT)) {
                return;
            }
            C1280xT c1280xT = (C1280xT) abstractC0531jNM179a;
            c1280xT.m7280a().m8307a(c1280xT, serverPlayer, c1248wo.f6750T);
        }
    }
}
