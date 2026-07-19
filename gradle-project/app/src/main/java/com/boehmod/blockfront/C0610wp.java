package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wp.class */
public final class C0610wp extends Record implements CustomPacketPayload {

    @NotNull
    private final oZ c;

    @NotNull
    public static final CustomPacketPayload.Type<C0610wp> as = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_callout"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0610wp> at = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0610wp::new);
    private static final int sQ = 160;

    public C0610wp(@NotNull oZ oZVar) {
        this.c = oZVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0610wp.class), C0610wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0610wp.class), C0610wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0610wp.class, Object.class), C0610wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public oZ c() {
        return this.c;
    }

    public C0610wp(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((oZ) friendlyByteBuf.readEnum(oZ.class));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.c);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return as;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@NotNull C0610wp c0610wp, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof xw)) {
                return;
            }
            xw xwVar = (xw) abstractC0264juM166a;
            xQ xQVar = (xQ) xwVar.a();
            UUID uuid = serverPlayer.getUUID();
            xO xOVar = (xO) xQVar.a((Player) serverPlayer);
            if (xOVar.dk()) {
                return;
            }
            oF<?, ?, ?> oFVarA = xwVar.mo604a(uuid);
            if (oFVarA instanceof qM) {
                qM qMVar = (qM) oFVarA;
                ServerLevel serverLevel = serverPlayer.serverLevel();
                oR.a(xwVar, xQVar, oFVarA, serverLevel, serverPlayer, (Component) Component.literal("[Team] ").append(Component.translatable(c0610wp.c.getTranslation())), uuid);
                qMVar.a(serverPlayer, uuid, c0610wp.c);
                if (c0610wp.c == oZ.FORWARD && (oFVarA instanceof InterfaceC0466rg)) {
                    a(oFVarA, (InterfaceC0466rg) oFVarA, serverLevel, serverPlayer, xOVar, uuid);
                }
            }
        }
    }

    private static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull InterfaceC0466rg interfaceC0466rg, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar, @NotNull UUID uuid) {
        sV sVVarA;
        oO oOVarA;
        if (oR.a((Player) serverPlayer, bVar)) {
            return;
        }
        oM oMVarA = oFVar.a(uuid);
        if (oMVarA.a(C0529tp.A.getKey()) <= 0 && (sVVarA = sV.a(oMVarA.a(C0529tp.i.getKey(), -1))) != null && sVVarA.bH() && (oOVarA = oFVar.b().a(uuid)) != null) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderN = oOVarA.a(oFVar).m1156a().n();
            if (deferredHolderN != null) {
                C0582vo.a(new C0587vt(deferredHolderN, SoundSource.PLAYERS, serverPlayer.getId(), 1.0f, 2.0f), oFVar);
            }
            oR.m792a(oFVar, uuid, C0529tp.A, 1200);
            float fAT = interfaceC0466rg.aT();
            for (UUID uuid2 : oOVarA.h()) {
                ServerPlayer serverPlayerA = oR.a(uuid2);
                if (serverPlayerA != null && serverPlayerA.distanceTo(serverPlayer) <= fAT) {
                    oR.m792a(oFVar, uuid2, C0529tp.z, sQ);
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (mE mEVar : serverLevel.getEntitiesOfClass(mE.class, serverPlayer.getBoundingBox().inflate(fAT))) {
                if (oOVarA.equals(mEVar.m671a()) && mEVar.distanceTo(serverPlayer) <= fAT) {
                    mEVar.t(20 + ((int) (80.0f * threadLocalRandomCurrent.nextFloat())));
                }
            }
        }
    }
}
