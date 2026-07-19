package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wu.class */
public final class C0615wu extends Record implements CustomPacketPayload {
    private final int sR;

    @NotNull
    public static final CustomPacketPayload.Type<C0615wu> ax;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0615wu> ay;
    static final /* synthetic */ boolean jh;

    public C0615wu(int i) {
        this.sR = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0615wu.class), C0615wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0615wu.class), C0615wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0615wu.class, Object.class), C0615wu.class, "index", "FIELD:Lcom/boehmod/blockfront/wu;->sR:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int bz() {
        return this.sR;
    }

    static {
        jh = !C0615wu.class.desiredAssertionStatus();
        ax = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_buy_item_request"));
        ay = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0615wu::new);
    }

    public C0615wu(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sR);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(C0615wu c0615wu, @NotNull IPayloadContext iPayloadContext) {
        oF<?, ?, ?> oFVarMo604a;
        C0408pc c0408pc;
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!jh && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
            UUID uuid = player2.getUUID();
            com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a(player2);
            if (oR.a(player2, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a) || bVarM305a.dk() || (oFVarMo604a = abstractC0264juM166a.mo604a(uuid)) == 0 || !(oFVarMo604a instanceof qT)) {
                return;
            }
            qT qTVar = (qT) oFVarMo604a;
            if (oFVarMo604a.m750a() == oN.GAME && (c0408pc = qTVar.mo1079a(uuid).get(c0615wu.sR)) != null) {
                int iBk = c0408pc.bk();
                C0528to c0528toC = qTVar.c();
                int iA = oR.a(oFVarMo604a, uuid, c0528toC);
                if (iA >= iBk) {
                    player2.addItem(c0408pc.a().copy());
                    oR.m792a(oFVarMo604a, uuid, c0528toC, iA - iBk);
                    oR.a((ServerPlayer) player2, (SoundEvent) C0624xc.sN.get(), SoundSource.NEUTRAL);
                    oR.c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout", new Object[]{c0408pc.a().getDisplayName(), Component.literal(String.valueOf(iBk)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
                    return;
                }
                oR.c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout.fail", new Object[]{Component.literal(String.valueOf(iBk)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
