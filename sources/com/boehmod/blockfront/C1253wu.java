package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wu.class */
public final class C1253wu extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sR */
    private final int f7422sR;

    /* JADX INFO: renamed from: ax */
    @NotNull
    public static final CustomPacketPayload.Type<C1253wu> f7423ax;

    /* JADX INFO: renamed from: ay */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1253wu> f7424ay;

    /* JADX INFO: renamed from: jh */
    static final /* synthetic */ boolean f7425jh;

    public C1253wu(int i) {
        this.f7422sR = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1253wu.class), C1253wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1253wu.class), C1253wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1253wu.class, Object.class), C1253wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bz */
    public int m7720bz() {
        return this.f7422sR;
    }

    static {
        f7425jh = !C1253wu.class.desiredAssertionStatus();
        f7423ax = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_buy_item_request"));
        f7424ay = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7718d(v1);
        }, C1253wu::new);
    }

    public C1253wu(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m7718d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f7422sR);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7423ax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m7719a(C1253wu c1253wu, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a;
        C0863pc c0863pc;
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f7425jh && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            UUID uuid = player2.getUUID();
            AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a(player2);
            if (C0799oR.m4052a(player2, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a) || abstractC0182bM1136a.m1087dk() || (abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid)) == 0 || !(abstractC0787oFMo2531a instanceof InterfaceC0907qT)) {
                return;
            }
            InterfaceC0907qT interfaceC0907qT = (InterfaceC0907qT) abstractC0787oFMo2531a;
            if (abstractC0787oFMo2531a.m3587a() == EnumC0795oN.GAME && (c0863pc = interfaceC0907qT.mo4680a(uuid).get(c1253wu.f7422sR)) != null) {
                int iM4312bk = c0863pc.m4312bk();
                C1088to c1088toMo4681c = interfaceC0907qT.mo4681c();
                int iM4009a = C0799oR.m4009a(abstractC0787oFMo2531a, uuid, c1088toMo4681c);
                if (iM4009a >= iM4312bk) {
                    player2.addItem(c0863pc.m4311a().copy());
                    C0799oR.m4011a(abstractC0787oFMo2531a, uuid, c1088toMo4681c, iM4009a - iM4312bk);
                    C0799oR.m3928a((ServerPlayer) player2, (SoundEvent) C1280xc.f7738sN.get(), SoundSource.NEUTRAL);
                    C0799oR.m3970c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout", new Object[]{c0863pc.m4311a().getDisplayName(), Component.literal(String.valueOf(iM4312bk)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
                    return;
                }
                C0799oR.m3970c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout.fail", new Object[]{Component.literal(String.valueOf(iM4312bk)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
