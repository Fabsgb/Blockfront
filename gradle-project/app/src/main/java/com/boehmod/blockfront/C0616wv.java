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

/* JADX INFO: renamed from: com.boehmod.blockfront.wv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wv.class */
public final class C0616wv extends Record implements CustomPacketPayload {

    @NotNull
    private final sV b;
    private final int sS;

    @NotNull
    public static final CustomPacketPayload.Type<C0616wv> ay;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0616wv> az;
    static final /* synthetic */ boolean ji;

    public C0616wv(@NotNull sV sVVar, int i) {
        this.b = sVVar;
        this.sS = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0616wv.class), C0616wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0616wv.class), C0616wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0616wv.class, Object.class), C0616wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public sV d() {
        return this.b;
    }

    public int cr() {
        return this.sS;
    }

    static {
        ji = !C0616wv.class.desiredAssertionStatus();
        ay = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_change_class_request"));
        az = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0616wv::new);
    }

    public C0616wv(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(sV.a(friendlyByteBuf.readVarInt()), friendlyByteBuf.readInt());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVarInt(this.b.bN());
        friendlyByteBuf.writeInt(this.sS);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ay;
    }

    public static void a(C0616wv c0616wv, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            ServerLevel serverLevel = serverPlayer.serverLevel();
            UUID uuid = serverPlayer.getUUID();
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!ji && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a != null) {
                oFVarMo604a.a(abstractC0264juM166a, serverLevel, serverPlayer, uuid, c0616wv.b, c0616wv.sS);
            }
        }
    }
}
