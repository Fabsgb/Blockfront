package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMMapRating;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wt.class */
public final class C1252wt extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dD */
    @NotNull
    private final String f7415dD;

    /* JADX INFO: renamed from: dE */
    @NotNull
    private final String f7416dE;

    /* JADX INFO: renamed from: dF */
    @NotNull
    private final String f7417dF;

    /* JADX INFO: renamed from: of */
    private final float f7418of;

    /* JADX INFO: renamed from: aw */
    @NotNull
    public static final CustomPacketPayload.Type<C1252wt> f7419aw = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_rate_map"));

    /* JADX INFO: renamed from: ax */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1252wt> f7420ax = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7712d(v1);
    }, C1252wt::new);

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final MutableComponent f7421w = Component.translatable("bf.message.game.match.summary.vote.rating.thanks");

    public C1252wt(@NotNull String str, @NotNull String str2, @NotNull String str3, float f) {
        this.f7415dD = str;
        this.f7416dE = str2;
        this.f7417dF = str3;
        this.f7418of = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1252wt.class), C1252wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1252wt.class), C1252wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1252wt.class, Object.class), C1252wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: ab */
    public String m7714ab() {
        return this.f7415dD;
    }

    @NotNull
    /* JADX INFO: renamed from: aB */
    public String m7715aB() {
        return this.f7416dE;
    }

    @NotNull
    /* JADX INFO: renamed from: aC */
    public String m7716aC() {
        return this.f7417dF;
    }

    /* JADX INFO: renamed from: bX */
    public float m7717bX() {
        return this.f7418of;
    }

    public C1252wt(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7712d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f7415dD);
        friendlyByteBuf.writeUtf(this.f7416dE);
        friendlyByteBuf.writeUtf(this.f7417dF);
        friendlyByteBuf.writeFloat(this.f7418of);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7419aw;
    }

    /* JADX INFO: renamed from: a */
    public static void m7713a(@NotNull C1252wt c1252wt, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null && abstractC0787oFMo2531a.m3629a().m6026ch()) {
                UUID uuid = serverPlayer.getUUID();
                if (abstractC0787oFMo2531a.m3629a().m6036q(uuid)) {
                    return;
                }
                float fM7717bX = c1252wt.m7717bX();
                if (Float.isNaN(fM7717bX) || fM7717bX < 0.0f || fM7717bX > 5.0f) {
                    return;
                }
                abstractC0787oFMo2531a.m3629a().m6037o(uuid);
                abstractC0563juM168a.m2520b().sendPacket(new PacketMMMapRating(c1252wt.m7714ab(), c1252wt.m7715aB(), c1252wt.m7716aC(), fM7717bX, uuid));
                C0799oR.m3970c(serverPlayer, (Component) f7421w);
                C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7540oX.get(), SoundSource.MASTER);
            }
        }
    }
}
