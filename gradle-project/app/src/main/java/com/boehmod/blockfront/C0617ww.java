package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ww, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ww.class */
public final class C0617ww extends Record implements CustomPacketPayload {

    @NotNull
    private final String dG;

    @NotNull
    private final String dH;

    @NotNull
    public static final CustomPacketPayload.Type<C0617ww> az;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0617ww> aA;
    static final /* synthetic */ boolean jj;

    public C0617ww(@NotNull String str, @NotNull String str2) {
        this.dG = str;
        this.dH = str2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0617ww.class), C0617ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0617ww.class), C0617ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0617ww.class, Object.class), C0617ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String ab() {
        return this.dG;
    }

    @NotNull
    public String aD() {
        return this.dH;
    }

    static {
        jj = !C0617ww.class.desiredAssertionStatus();
        az = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_vote_map"));
        aA = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0617ww::new);
    }

    public C0617ww(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767));
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.dG);
        friendlyByteBuf.writeUtf(this.dH);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return az;
    }

    public static void a(C0617ww c0617ww, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayerPlayer.getUUID());
        if (oFVarMo604a != null && (serverPlayerPlayer instanceof ServerPlayer)) {
            oFVarMo604a.m758a().a(serverPlayerPlayer, c0617ww.dG, c0617ww.dH);
        }
    }
}
