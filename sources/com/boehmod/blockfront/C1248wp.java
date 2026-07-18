package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wp.class */
public final class C1248wp extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumC0807oZ f7400c;

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final CustomPacketPayload.Type<C1248wp> f7401as = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_callout"));

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1248wp> f7402at = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7696d(v1);
    }, C1248wp::new);

    /* JADX INFO: renamed from: sQ */
    private static final int f7403sQ = 160;

    public C1248wp(@NotNull EnumC0807oZ enumC0807oZ) {
        this.f7400c = enumC0807oZ;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1248wp.class), C1248wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1248wp.class), C1248wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1248wp.class, Object.class), C1248wp.class, "callout", "FIELD:Lcom/boehmod/blockfront/wp;->c:Lcom/boehmod/blockfront/oZ;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public EnumC0807oZ m7699c() {
        return this.f7400c;
    }

    public C1248wp(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0807oZ) friendlyByteBuf.readEnum(EnumC0807oZ.class));
    }

    /* JADX INFO: renamed from: d */
    public void m7696d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f7400c);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7401as;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m7697a(@NotNull C1248wp c1248wp, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C1300xw)) {
                return;
            }
            C1300xw c1300xw = (C1300xw) abstractC0563juM168a;
            C1276xQ c1276xQ = (C1276xQ) c1300xw.m7950a();
            UUID uuid = serverPlayer.getUUID();
            C1274xO c1274xO = (C1274xO) c1276xQ.m1133a((Player) serverPlayer);
            if (c1274xO.m1087dk()) {
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFA = c1300xw.mo2531a(uuid);
            if (abstractC0787oFA instanceof InterfaceC0900qM) {
                InterfaceC0900qM interfaceC0900qM = (InterfaceC0900qM) abstractC0787oFA;
                ServerLevel serverLevel = serverPlayer.serverLevel();
                C0799oR.m4057a(c1300xw, c1276xQ, abstractC0787oFA, serverLevel, serverPlayer, (Component) Component.literal("[Team] ").append(Component.translatable(c1248wp.f7400c.getTranslation())), uuid);
                interfaceC0900qM.mo4664a(serverPlayer, uuid, c1248wp.f7400c);
                if (c1248wp.f7400c == EnumC0807oZ.FORWARD && (abstractC0787oFA instanceof InterfaceC0973rg)) {
                    m7698a(abstractC0787oFA, (InterfaceC0973rg) abstractC0787oFA, serverLevel, serverPlayer, c1274xO, uuid);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7698a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull InterfaceC0973rg interfaceC0973rg, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b, @NotNull UUID uuid) {
        C1015sV c1015sVM5528a;
        C0796oO c0796oOM3793a;
        if (C0799oR.m4052a((Player) serverPlayer, abstractC0182b)) {
            return;
        }
        C0794oM c0794oMM3598a = abstractC0787oF.m3598a(uuid);
        if (c0794oMM3598a.m3853a(C1089tp.f5710A.getKey()) <= 0 && (c1015sVM5528a = C1015sV.m5528a(c0794oMM3598a.m3854a(C1089tp.f5692i.getKey(), -1))) != null && c1015sVM5528a.m5521bH() && (c0796oOM3793a = abstractC0787oF.m3582b().m3793a(uuid)) != null) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5681n = c0796oOM3793a.m3860a(abstractC0787oF).m5976a().m5681n();
            if (deferredHolderM5681n != null) {
                C1194vo.m6651a(new C1199vt(deferredHolderM5681n, SoundSource.PLAYERS, serverPlayer.getId(), 1.0f, 2.0f), abstractC0787oF);
            }
            C0799oR.m4011a(abstractC0787oF, uuid, C1089tp.f5710A, 1200);
            float fMo5171aT = interfaceC0973rg.mo5171aT();
            for (UUID uuid2 : c0796oOM3793a.m3872h()) {
                ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid2);
                if (serverPlayerM3963a != null && serverPlayerM3963a.distanceTo(serverPlayer) <= fMo5171aT) {
                    C0799oR.m4011a(abstractC0787oF, uuid2, C1089tp.f5709z, f7403sQ);
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (C0680mE c0680mE : serverLevel.getEntitiesOfClass(C0680mE.class, serverPlayer.getBoundingBox().inflate(fMo5171aT))) {
                if (c0796oOM3793a.equals(c0680mE.m3046a()) && c0680mE.distanceTo(serverPlayer) <= fMo5171aT) {
                    c0680mE.m3078t(20 + ((int) (80.0f * threadLocalRandomCurrent.nextFloat())));
                }
            }
        }
    }
}
