package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ws */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ws.class */
public final class C1252ws extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: l */
    private final C0881pt f6766l;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final CustomPacketPayload.Type<C1252ws> f6767V;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1252ws> f6768W;

    /* JADX INFO: renamed from: jj */
    static final /* synthetic */ boolean f6769jj;

    public C1252ws(C0881pt c0881pt) {
        this.f6766l = c0881pt;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1252ws.class), C1252ws.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/ws;->l:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1252ws.class), C1252ws.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/ws;->l:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1252ws.class, Object.class), C1252ws.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/ws;->l:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: k */
    public C0881pt m7087k() {
        return this.f6766l;
    }

    static {
        f6769jj = !C1252ws.class.desiredAssertionStatus();
        f6767V = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sequence_position"));
        f6768W = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7085d(v1);
        }, C1252ws::new);
    }

    public C1252ws(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0881pt.m4588a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7085d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6766l.m4589b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6767V;
    }

    /* JADX INFO: renamed from: a */
    public static void m7086a(C1252ws c1252ws, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6769jj && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayerPlayer);
        if (abstractC0183bM1153a instanceof C1326ym) {
            ((C1326ym) abstractC0183bM1153a).m8298a().m8283a(serverPlayerPlayer, abstractC0184cM2351a, c1252ws.m7087k());
        }
    }
}
