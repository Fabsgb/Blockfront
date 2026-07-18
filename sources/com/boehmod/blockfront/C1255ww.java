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

/* JADX INFO: renamed from: com.boehmod.blockfront.ww */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ww.class */
public final class C1255ww extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dG */
    @NotNull
    private final String f7431dG;

    /* JADX INFO: renamed from: dH */
    @NotNull
    private final String f7432dH;

    /* JADX INFO: renamed from: az */
    @NotNull
    public static final CustomPacketPayload.Type<C1255ww> f7433az;

    /* JADX INFO: renamed from: aA */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1255ww> f7434aA;

    /* JADX INFO: renamed from: jj */
    static final /* synthetic */ boolean f7435jj;

    public C1255ww(@NotNull String str, @NotNull String str2) {
        this.f7431dG = str;
        this.f7432dH = str2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1255ww.class), C1255ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1255ww.class), C1255ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1255ww.class, Object.class), C1255ww.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/ww;->dG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/ww;->dH:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: ab */
    public String m7727ab() {
        return this.f7431dG;
    }

    @NotNull
    /* JADX INFO: renamed from: aD */
    public String m7728aD() {
        return this.f7432dH;
    }

    static {
        f7435jj = !C1255ww.class.desiredAssertionStatus();
        f7433az = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_vote_map"));
        f7434aA = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7725d(v1);
        }, C1255ww::new);
    }

    public C1255ww(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767));
    }

    /* JADX INFO: renamed from: d */
    public void m7725d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f7431dG);
        friendlyByteBuf.writeUtf(this.f7432dH);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7433az;
    }

    /* JADX INFO: renamed from: a */
    public static void m7726a(C1255ww c1255ww, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f7435jj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayerPlayer.getUUID());
        if (abstractC0787oFMo2531a != null && (serverPlayerPlayer instanceof ServerPlayer)) {
            abstractC0787oFMo2531a.m3629a().m6028a(serverPlayerPlayer, c1255ww.f7431dG, c1255ww.f7432dH);
        }
    }
}
