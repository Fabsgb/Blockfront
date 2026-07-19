package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vS.class */
public final class vS extends Record implements CustomPacketPayload {
    private final oX l;

    @NotNull
    public static final CustomPacketPayload.Type<vS> V;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vS> W;
    static final /* synthetic */ boolean iQ;

    public vS(oX oXVar) {
        this.l = oXVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vS.class), vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vS.class), vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vS.class, Object.class), vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public oX k() {
        return this.l;
    }

    static {
        iQ = !vS.class.desiredAssertionStatus();
        V = new CustomPacketPayload.Type<>(C0265jv.d("packet_sequence_position"));
        W = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vS::new);
    }

    public vS(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(oX.a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.l.b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return V;
    }

    public static void a(vS vSVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!iQ && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) serverPlayerPlayer);
        if (bVarM305a instanceof xO) {
            ((xO) bVarM305a).a().a(serverPlayerPlayer, cVarM531a, vSVar.k());
        }
    }
}
