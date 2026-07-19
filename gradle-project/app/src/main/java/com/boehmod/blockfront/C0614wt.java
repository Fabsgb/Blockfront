package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.mm.PacketMMMapRating;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wt.class */
public final class C0614wt extends Record implements CustomPacketPayload {

    @NotNull
    private final String dD;

    @NotNull
    private final String dE;

    @NotNull
    private final String dF;
    private final float of;

    @NotNull
    public static final CustomPacketPayload.Type<C0614wt> aw = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_rate_map"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0614wt> ax = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0614wt::new);

    @NotNull
    private static final MutableComponent w = Component.translatable("bf.message.game.match.summary.vote.rating.thanks");

    public C0614wt(@NotNull String str, @NotNull String str2, @NotNull String str3, float f) {
        this.dD = str;
        this.dE = str2;
        this.dF = str3;
        this.of = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0614wt.class), C0614wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0614wt.class), C0614wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0614wt.class, Object.class), C0614wt.class, "mapName;gameMode;teamName;rating", "FIELD:Lcom/boehmod/blockfront/wt;->dD:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dE:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->dF:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wt;->of:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String ab() {
        return this.dD;
    }

    @NotNull
    public String aB() {
        return this.dE;
    }

    @NotNull
    public String aC() {
        return this.dF;
    }

    public float bX() {
        return this.of;
    }

    public C0614wt(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767), friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.dD);
        friendlyByteBuf.writeUtf(this.dE);
        friendlyByteBuf.writeUtf(this.dF);
        friendlyByteBuf.writeFloat(this.of);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aw;
    }

    public static void a(@NotNull C0614wt c0614wt, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null && oFVarMo604a.m758a().ch()) {
                UUID uuid = serverPlayer.getUUID();
                if (oFVarMo604a.m758a().q(uuid)) {
                    return;
                }
                float fBX = c0614wt.bX();
                if (Float.isNaN(fBX) || fBX < 0.0f || fBX > 5.0f) {
                    return;
                }
                oFVarMo604a.m758a().o(uuid);
                abstractC0264juM166a.m529b().sendPacket(new PacketMMMapRating(c0614wt.ab(), c0614wt.aB(), c0614wt.aC(), fBX, uuid));
                oR.c(serverPlayer, (Component) w);
                oR.a(serverPlayer, (SoundEvent) C0624xc.oX.get(), SoundSource.MASTER);
            }
        }
    }
}
