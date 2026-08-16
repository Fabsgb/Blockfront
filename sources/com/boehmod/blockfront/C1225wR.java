package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMMapRating;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wR.class */
public final class C1225wR extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dO */
    @NotNull
    private final String f6652dO;

    /* JADX INFO: renamed from: dP */
    @NotNull
    private final String f6653dP;

    /* JADX INFO: renamed from: dQ */
    @NotNull
    private final String f6654dQ;

    /* JADX INFO: renamed from: pd */
    private final float f6655pd;

    /* JADX INFO: renamed from: au */
    @NotNull
    public static final CustomPacketPayload.Type<C1225wR> f6656au = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_rate_map"));

    /* JADX INFO: renamed from: av */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1225wR> f6657av = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6980d(v1);
    }, C1225wR::new);

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final MutableComponent f6658w = Component.translatable("bf.message.game.match.summary.vote.rating.thanks");

    public C1225wR(@NotNull String str, @NotNull String str2, @NotNull String str3, float f) {
        this.f6652dO = str;
        this.f6653dP = str2;
        this.f6654dQ = str3;
        this.f6655pd = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1225wR.class), C1225wR.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wR;->dO:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dP:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->pd:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1225wR.class), C1225wR.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wR;->dO:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dP:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->pd:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1225wR.class, Object.class), C1225wR.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wR;->dO:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dP:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->dQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wR;->pd:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: ai */
    public String m6982ai() {
        return this.f6652dO;
    }

    @NotNull
    /* JADX INFO: renamed from: aI */
    public String m6983aI() {
        return this.f6653dP;
    }

    @NotNull
    /* JADX INFO: renamed from: aJ */
    public String m6984aJ() {
        return this.f6654dQ;
    }

    /* JADX INFO: renamed from: cd */
    public float m6985cd() {
        return this.f6655pd;
    }

    public C1225wR(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6980d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6652dO);
        friendlyByteBuf.writeUtf(this.f6653dP);
        friendlyByteBuf.writeUtf(this.f6654dQ);
        friendlyByteBuf.writeFloat(this.f6655pd);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6656au;
    }

    /* JADX INFO: renamed from: a */
    public static void m6981a(@NotNull C1225wR c1225wR, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null && abstractC0863pbMo2354a.m4065a().m5912cr()) {
                UUID uuid = serverPlayer.getUUID();
                if (abstractC0863pbMo2354a.m4065a().m5922q(uuid)) {
                    return;
                }
                float fM6985cd = c1225wR.m6985cd();
                if (Float.isNaN(fM6985cd) || fM6985cd < 0.0f || fM6985cd > 5.0f) {
                    return;
                }
                abstractC0863pbMo2354a.m4065a().m5923o(uuid);
                abstractC0531jNM179a.m2342b().sendPacket(new PacketMMMapRating(c1225wR.m6982ai(), c1225wR.m6983aI(), c1225wR.m6984aJ(), fM6985cd, uuid));
                C0875pn.m4406c(serverPlayer, (Component) f6658w);
                C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f7952oZ.get(), SoundSource.MASTER);
            }
        }
    }
}
