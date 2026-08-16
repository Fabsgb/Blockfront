package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vC.class */
public final class C1157vC extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dF */
    @NotNull
    private final String f6319dF;

    /* JADX INFO: renamed from: uy */
    private static final int f6320uy = 256;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final CustomPacketPayload.Type<C1157vC> f6321g = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_chat_message"));

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1157vC> f6322h = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6598d(v1);
    }, C1157vC::new);

    public C1157vC(@NotNull String str) {
        this.f6319dF = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1157vC.class), C1157vC.class, "message", "FIELD:Lcom/boehmod/blockfront/vC;->dF:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1157vC.class), C1157vC.class, "message", "FIELD:Lcom/boehmod/blockfront/vC;->dF:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1157vC.class, Object.class), C1157vC.class, "message", "FIELD:Lcom/boehmod/blockfront/vC;->dF:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aD */
    public String m6600aD() {
        return this.f6319dF;
    }

    public C1157vC(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(256));
    }

    /* JADX INFO: renamed from: d */
    public void m6598d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6319dF, 256);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6321g;
    }

    /* JADX INFO: renamed from: a */
    public static void m6599a(@NotNull C1157vC c1157vC, @NotNull IPayloadContext iPayloadContext) {
        MutableComponent mutableComponentLiteral;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String str = c1157vC.f6319dF;
            if (str.isEmpty() || str.length() > 256) {
                return;
            }
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C1280xT)) {
                return;
            }
            C1280xT c1280xT = (C1280xT) abstractC0531jNM179a;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            AbstractC0863pb<?, ?, ?> abstractC0863pbA = c1280xT.mo2354a(uuid);
            if (abstractC0863pbA == null) {
                if (C0549jf.f3276dy) {
                    mutableComponentLiteral = C1265xE.m7139a(str);
                } else {
                    mutableComponentLiteral = Component.literal(str);
                }
                MutableComponent mutableComponent = mutableComponentLiteral;
                serverPlayer.server.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponent}));
                List<ServerPlayer> players = serverPlayer.server.getPlayerList().getPlayers();
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (ServerPlayer serverPlayer2 : players) {
                    if (C1266xF.m7145c(str, serverPlayer2.getScoreboardName())) {
                        objectArrayList.add(serverPlayer2.getScoreboardName());
                    }
                }
                for (ServerPlayer serverPlayer3 : players) {
                    String scoreboardName = serverPlayer3.getScoreboardName();
                    MutableComponent mutableComponentM7146a = mutableComponent;
                    if (serverPlayer3 == serverPlayer) {
                        if (!objectArrayList.isEmpty()) {
                            mutableComponentM7146a = C1266xF.m7147a((Component) mutableComponent, (List<String>) objectArrayList);
                        }
                    } else if (C1266xF.m7145c(str, scoreboardName)) {
                        mutableComponentM7146a = C1266xF.m7146a((Component) mutableComponent, scoreboardName);
                    }
                    serverPlayer3.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponentM7146a}));
                }
                return;
            }
            C0875pn.m4493a(c1280xT, (C1328yo) c1280xT.m7277a(), abstractC0863pbA, serverLevel, serverPlayer, (Component) Component.literal(str), uuid);
        }
    }
}
