package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.vS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vS.class */
public final class C1172vS extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: l */
    private final C0805oX f6190l;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final CustomPacketPayload.Type<C1172vS> f6191V;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1172vS> f6192W;

    /* JADX INFO: renamed from: iQ */
    static final /* synthetic */ boolean f6193iQ;

    public C1172vS(C0805oX c0805oX) {
        this.f6190l = c0805oX;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1172vS.class), C1172vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1172vS.class), C1172vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1172vS.class, Object.class), C1172vS.class, "blockLocation", "FIELD:Lcom/boehmod/blockfront/vS;->l:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: k */
    public C0805oX m6561k() {
        return this.f6190l;
    }

    static {
        f6193iQ = !C1172vS.class.desiredAssertionStatus();
        f6191V = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sequence_position"));
        f6192W = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6559d(v1);
        }, C1172vS::new);
    }

    public C1172vS(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0805oX.m4151a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6559d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6190l.m4152b(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6191V;
    }

    /* JADX INFO: renamed from: a */
    public static void m6560a(C1172vS c1172vS, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f6193iQ && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) serverPlayerPlayer);
        if (abstractC0182bM1136a instanceof C1274xO) {
            ((C1274xO) abstractC0182bM1136a).m7782a().m7767a(serverPlayerPlayer, abstractC0183cM2528a, c1172vS.m6561k());
        }
    }
}
