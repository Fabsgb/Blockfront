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

/* JADX INFO: renamed from: com.boehmod.blockfront.wv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wv.class */
public final class C1254wv extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1015sV f7426b;

    /* JADX INFO: renamed from: sS */
    private final int f7427sS;

    /* JADX INFO: renamed from: ay */
    @NotNull
    public static final CustomPacketPayload.Type<C1254wv> f7428ay;

    /* JADX INFO: renamed from: az */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1254wv> f7429az;

    /* JADX INFO: renamed from: ji */
    static final /* synthetic */ boolean f7430ji;

    public C1254wv(@NotNull C1015sV c1015sV, int i) {
        this.f7426b = c1015sV;
        this.f7427sS = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1254wv.class), C1254wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1254wv.class), C1254wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1254wv.class, Object.class), C1254wv.class, "classType;classIndex", "FIELD:Lcom/boehmod/blockfront/wv;->b:Lcom/boehmod/blockfront/sV;", "FIELD:Lcom/boehmod/blockfront/wv;->sS:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1015sV m7723d() {
        return this.f7426b;
    }

    /* JADX INFO: renamed from: cr */
    public int m7724cr() {
        return this.f7427sS;
    }

    static {
        f7430ji = !C1254wv.class.desiredAssertionStatus();
        f7428ay = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_change_class_request"));
        f7429az = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7721d(v1);
        }, C1254wv::new);
    }

    public C1254wv(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C1015sV.m5528a(friendlyByteBuf.readVarInt()), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m7721d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVarInt(this.f7426b.m5523bN());
        friendlyByteBuf.writeInt(this.f7427sS);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7428ay;
    }

    /* JADX INFO: renamed from: a */
    public static void m7722a(C1254wv c1254wv, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            ServerLevel serverLevel = serverPlayer.serverLevel();
            UUID uuid = serverPlayer.getUUID();
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f7430ji && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3638a(abstractC0563juM168a, serverLevel, serverPlayer, uuid, c1254wv.f7426b, c1254wv.f7427sS);
            }
        }
    }
}
