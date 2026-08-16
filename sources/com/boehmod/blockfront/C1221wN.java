package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wN.class */
public final class C1221wN extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumC0883pv f6637c;

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final CustomPacketPayload.Type<C1221wN> f6638aq = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_callout"));

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1221wN> f6639ar = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6964d(v1);
    }, C1221wN::new);

    /* JADX INFO: renamed from: uU */
    private static final int f6640uU = 160;

    public C1221wN(@NotNull EnumC0883pv enumC0883pv) {
        this.f6637c = enumC0883pv;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1221wN.class), C1221wN.class, "callout", "FIELD:Lcom/boehmod/blockfront/wN;->c:Lcom/boehmod/blockfront/pv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1221wN.class), C1221wN.class, "callout", "FIELD:Lcom/boehmod/blockfront/wN;->c:Lcom/boehmod/blockfront/pv;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1221wN.class, Object.class), C1221wN.class, "callout", "FIELD:Lcom/boehmod/blockfront/wN;->c:Lcom/boehmod/blockfront/pv;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public EnumC0883pv m6967c() {
        return this.f6637c;
    }

    public C1221wN(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0883pv) friendlyByteBuf.readEnum(EnumC0883pv.class));
    }

    /* JADX INFO: renamed from: d */
    public void m6964d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6637c);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6638aq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6965a(@NotNull C1221wN c1221wN, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C1280xT)) {
                return;
            }
            C1280xT c1280xT = (C1280xT) abstractC0531jNM179a;
            C1328yo c1328yo = (C1328yo) c1280xT.m7277a();
            UUID uuid = serverPlayer.getUUID();
            C1326ym c1326ym = (C1326ym) c1328yo.m1150a((Player) serverPlayer);
            if (c1326ym.m1104dt()) {
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbA = c1280xT.mo2354a(uuid);
            if (abstractC0863pbA instanceof InterfaceC0977rj) {
                InterfaceC0977rj interfaceC0977rj = (InterfaceC0977rj) abstractC0863pbA;
                ServerLevel serverLevel = serverPlayer.serverLevel();
                C0875pn.m4493a(c1280xT, c1328yo, abstractC0863pbA, serverLevel, serverPlayer, (Component) Component.literal("[Team] ").append(Component.translatable(c1221wN.f6637c.getTranslation())), uuid);
                interfaceC0977rj.mo5350a(serverPlayer, uuid, c1221wN.f6637c);
                if (c1221wN.f6637c == EnumC0883pv.FORWARD && (abstractC0863pbA instanceof InterfaceC0945rD)) {
                    m6966a(abstractC0863pbA, (InterfaceC0945rD) abstractC0863pbA, serverLevel, serverPlayer, c1326ym, uuid);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m6966a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull InterfaceC0945rD interfaceC0945rD, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b, @NotNull UUID uuid) {
        C1093ts c1093tsM6016a;
        C0872pk c0872pkM4229a;
        if (C0875pn.m4488a((Player) serverPlayer, abstractC0183b)) {
            return;
        }
        C0870pi c0870piM4034a = abstractC0863pb.m4034a(uuid);
        if (c0870piM4034a.m4289a(C1062tN.f5763A.getKey()) <= 0 && (c1093tsM6016a = C1093ts.m6016a(c0870piM4034a.m4290a(C1062tN.f5745i.getKey(), -1))) != null && c1093tsM6016a.m6009bR() && (c0872pkM4229a = abstractC0863pb.m4018b().m4229a(uuid)) != null) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6169n = c0872pkM4229a.m4296a(abstractC0863pb).m6179a().m6169n();
            if (deferredHolderM6169n != null) {
                C1169vO.m6646a(new C1174vT(deferredHolderM6169n, SoundSource.PLAYERS, serverPlayer.getId(), 1.0f, 2.0f), abstractC0863pb);
            }
            C0875pn.m4447a(abstractC0863pb, uuid, C1062tN.f5763A, 1200);
            float fMo5186aZ = interfaceC0945rD.mo5186aZ();
            for (UUID uuid2 : c0872pkM4229a.m4308h()) {
                ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid2);
                if (serverPlayerM4399a != null && serverPlayerM4399a.distanceTo(serverPlayer) <= fMo5186aZ) {
                    C0875pn.m4447a(abstractC0863pb, uuid2, C1062tN.f5762z, f6640uU);
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (C0756na c0756na : serverLevel.getEntitiesOfClass(C0756na.class, serverPlayer.getBoundingBox().inflate(fMo5186aZ))) {
                if (c0872pkM4229a.equals(c0756na.m3553a()) && c0756na.distanceTo(serverPlayer) <= fMo5186aZ) {
                    c0756na.m3585u(20 + ((int) (80.0f * threadLocalRandomCurrent.nextFloat())));
                }
            }
        }
    }
}
