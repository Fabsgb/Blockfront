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

/* JADX INFO: renamed from: com.boehmod.blockfront.vc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vc.class */
public final class C1182vc extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: du */
    @NotNull
    private final String f6235du;

    /* JADX INFO: renamed from: su */
    private static final int f6236su = 256;

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final CustomPacketPayload.Type<C1182vc> f6237g = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_chat_message"));

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1182vc> f6238h = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6603d(v1);
    }, C1182vc::new);

    public C1182vc(@NotNull String str) {
        this.f6235du = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1182vc.class), C1182vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1182vc.class), C1182vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1182vc.class, Object.class), C1182vc.class, "message", "FIELD:Lcom/boehmod/blockfront/vc;->du:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aw */
    public String m6605aw() {
        return this.f6235du;
    }

    public C1182vc(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(256));
    }

    /* JADX INFO: renamed from: d */
    public void m6603d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6235du, 256);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6237g;
    }

    /* JADX INFO: renamed from: a */
    public static void m6604a(@NotNull C1182vc c1182vc, @NotNull IPayloadContext iPayloadContext) {
        MutableComponent mutableComponentLiteral;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            String str = c1182vc.f6235du;
            if (str.isEmpty() || str.length() > 256) {
                return;
            }
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C1300xw)) {
                return;
            }
            C1300xw c1300xw = (C1300xw) abstractC0563juM168a;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            AbstractC0787oF<?, ?, ?> abstractC0787oFA = c1300xw.mo2531a(uuid);
            if (abstractC0787oFA == null) {
                if (C0476iM.f2926dn) {
                    mutableComponentLiteral = C1285xh.m7816a(str);
                } else {
                    mutableComponentLiteral = Component.literal(str);
                }
                MutableComponent mutableComponent = mutableComponentLiteral;
                serverPlayer.server.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponent}));
                List<ServerPlayer> players = serverPlayer.server.getPlayerList().getPlayers();
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (ServerPlayer serverPlayer2 : players) {
                    if (C1286xi.m7821b(str, serverPlayer2.getScoreboardName())) {
                        objectArrayList.add(serverPlayer2.getScoreboardName());
                    }
                }
                for (ServerPlayer serverPlayer3 : players) {
                    String scoreboardName = serverPlayer3.getScoreboardName();
                    MutableComponent mutableComponentM7822a = mutableComponent;
                    if (serverPlayer3 == serverPlayer) {
                        if (!objectArrayList.isEmpty()) {
                            mutableComponentM7822a = C1286xi.m7823a((Component) mutableComponent, (List<String>) objectArrayList);
                        }
                    } else if (C1286xi.m7821b(str, scoreboardName)) {
                        mutableComponentM7822a = C1286xi.m7822a((Component) mutableComponent, scoreboardName);
                    }
                    serverPlayer3.sendSystemMessage(Component.translatable("chat.type.text", new Object[]{serverPlayer.getDisplayName(), mutableComponentM7822a}));
                }
                return;
            }
            C0799oR.m4057a(c1300xw, (C1276xQ) c1300xw.m7950a(), abstractC0787oFA, serverLevel, serverPlayer, (Component) Component.literal(str), uuid);
        }
    }
}
