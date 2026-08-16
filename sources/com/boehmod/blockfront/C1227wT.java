package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wT.class */
public final class C1227wT extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1093ts f6663b;

    /* JADX INFO: renamed from: uW */
    private final int f6664uW;

    /* JADX INFO: renamed from: aw */
    @NotNull
    public static final CustomPacketPayload.Type<C1227wT> f6665aw;

    /* JADX INFO: renamed from: ax */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1227wT> f6666ax;

    /* JADX INFO: renamed from: jA */
    static final /* synthetic */ boolean f6667jA;

    public C1227wT(@NotNull C1093ts c1093ts, int i) {
        this.f6663b = c1093ts;
        this.f6664uW = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1227wT.class), C1227wT.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wT;->b:Lcom/boehmod/blockfront/ts;", "FIELD:Lcom/boehmod/blockfront/wT;->uW:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1227wT.class), C1227wT.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wT;->b:Lcom/boehmod/blockfront/ts;", "FIELD:Lcom/boehmod/blockfront/wT;->uW:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1227wT.class, Object.class), C1227wT.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wT;->b:Lcom/boehmod/blockfront/ts;", "FIELD:Lcom/boehmod/blockfront/wT;->uW:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1093ts m6991d() {
        return this.f6663b;
    }

    /* JADX INFO: renamed from: cH */
    public int m6992cH() {
        return this.f6664uW;
    }

    static {
        f6667jA = !C1227wT.class.desiredAssertionStatus();
        f6665aw = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_change_class_request"));
        f6666ax = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6989d(v1);
        }, C1227wT::new);
    }

    public C1227wT(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C1093ts.m6016a(friendlyByteBuf.readVarInt()), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m6989d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVarInt(this.f6663b.m6011cc());
        friendlyByteBuf.writeInt(this.f6664uW);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6665aw;
    }

    /* JADX INFO: renamed from: a */
    public static void m6990a(C1227wT c1227wT, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            ServerLevel serverLevel = serverPlayer.serverLevel();
            UUID uuid = serverPlayer.getUUID();
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6667jA && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4074a(abstractC0531jNM179a, serverLevel, serverPlayer, uuid, c1227wT.f6663b, c1227wT.f6664uW);
            }
        }
    }
}
