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

/* JADX INFO: renamed from: com.boehmod.blockfront.vc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vc.class */
public final class C0570vc extends Record implements CustomPacketPayload {

    @NotNull
    private final String du;
    private static final int su = 256;

    @NotNull
    public static final CustomPacketPayload.Type<C0570vc> g = new CustomPacketPayload.Type<>(C0265jv.d("packet_chat_message"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0570vc> h = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0570vc::new);

    public C0570vc(@NotNull String str) {
        this.du = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0570vc.class), C0570vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0570vc.class), C0570vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0570vc.class, Object.class), C0570vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String aw() {
        return this.du;
    }

    public C0570vc(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(256));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.du, 256);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return g;
    }

    public static void a(@NotNull C0570vc c0570vc, @NotNull IPayloadContext iPayloadContext) {
        MutableComponent mutableComponentLiteral;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String str = c0570vc.du;
            if (str.isEmpty() || str.length() > 256) {
                return;
            }
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof xw)) {
                return;
            }
            xw xwVar = (xw) abstractC0264juM166a;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            oF<?, ?, ?> oFVarA = xwVar.mo604a(uuid);
            if (oFVarA == null) {
                if (iM.dn) {
                    mutableComponentLiteral = C0629xh.a(str);
                } else {
                    mutableComponentLiteral = Component.literal(str);
                }
                MutableComponent mutableComponent = mutableComponentLiteral;
                serverPlayer.server.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponent}));
                List<ServerPlayer> players = serverPlayer.server.getPlayerList().getPlayers();
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (ServerPlayer serverPlayer2 : players) {
                    if (C0630xi.b(str, serverPlayer2.getScoreboardName())) {
                        objectArrayList.add(serverPlayer2.getScoreboardName());
                    }
                }
                for (ServerPlayer serverPlayer3 : players) {
                    String scoreboardName = serverPlayer3.getScoreboardName();
                    MutableComponent mutableComponentA = mutableComponent;
                    if (serverPlayer3 == serverPlayer) {
                        if (!objectArrayList.isEmpty()) {
                            mutableComponentA = C0630xi.a((Component) mutableComponent, (List<String>) objectArrayList);
                        }
                    } else if (C0630xi.b(str, scoreboardName)) {
                        mutableComponentA = C0630xi.a((Component) mutableComponent, scoreboardName);
                    }
                    serverPlayer3.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponentA}));
                }
                return;
            }
            oR.a(xwVar, (xQ) xwVar.a(), oFVarA, serverLevel, serverPlayer, (Component) Component.literal(str), uuid);
        }
    }
}
