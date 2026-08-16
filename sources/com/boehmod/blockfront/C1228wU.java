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

/* JADX INFO: renamed from: com.boehmod.blockfront.wU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wU.class */
public final class C1228wU extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dR */
    @NotNull
    private final String f6668dR;

    /* JADX INFO: renamed from: dS */
    @NotNull
    private final String f6669dS;

    /* JADX INFO: renamed from: ax */
    @NotNull
    public static final CustomPacketPayload.Type<C1228wU> f6670ax;

    /* JADX INFO: renamed from: ay */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1228wU> f6671ay;

    /* JADX INFO: renamed from: jB */
    static final /* synthetic */ boolean f6672jB;

    public C1228wU(@NotNull String str, @NotNull String str2) {
        this.f6668dR = str;
        this.f6669dS = str2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1228wU.class), C1228wU.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/wU;->dR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wU;->dS:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1228wU.class), C1228wU.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/wU;->dR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wU;->dS:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1228wU.class, Object.class), C1228wU.class, "mapName;mapGame", "FIELD:Lcom/boehmod/blockfront/wU;->dR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/wU;->dS:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: ai */
    public String m6995ai() {
        return this.f6668dR;
    }

    @NotNull
    /* JADX INFO: renamed from: aK */
    public String m6996aK() {
        return this.f6669dS;
    }

    static {
        f6672jB = !C1228wU.class.desiredAssertionStatus();
        f6670ax = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_vote_map"));
        f6671ay = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6993d(v1);
        }, C1228wU::new);
    }

    public C1228wU(FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(32767), friendlyByteBuf.readUtf(32767));
    }

    /* JADX INFO: renamed from: d */
    public void m6993d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6668dR);
        friendlyByteBuf.writeUtf(this.f6669dS);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6670ax;
    }

    /* JADX INFO: renamed from: a */
    public static void m6994a(C1228wU c1228wU, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6672jB && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayerPlayer.getUUID());
        if (abstractC0863pbMo2354a != null && (serverPlayerPlayer instanceof ServerPlayer)) {
            abstractC0863pbMo2354a.m4065a().m5914a(serverPlayerPlayer, c1228wU.f6668dR, c1228wU.f6669dS);
        }
    }
}
