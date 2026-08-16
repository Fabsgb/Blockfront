package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wS.class */
public final class C1226wS extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uV */
    private final int f6659uV;

    /* JADX INFO: renamed from: av */
    @NotNull
    public static final CustomPacketPayload.Type<C1226wS> f6660av;

    /* JADX INFO: renamed from: aw */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1226wS> f6661aw;

    /* JADX INFO: renamed from: jz */
    static final /* synthetic */ boolean f6662jz;

    public C1226wS(int i) {
        this.f6659uV = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1226wS.class), C1226wS.class, "index", "FIELD:Lcom/boehmod/blockfront/wS;->uV:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1226wS.class), C1226wS.class, "index", "FIELD:Lcom/boehmod/blockfront/wS;->uV:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1226wS.class, Object.class), C1226wS.class, "index", "FIELD:Lcom/boehmod/blockfront/wS;->uV:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bO */
    public int m6988bO() {
        return this.f6659uV;
    }

    static {
        f6662jz = !C1226wS.class.desiredAssertionStatus();
        f6660av = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_buy_item_request"));
        f6661aw = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6986d(v1);
        }, C1226wS::new);
    }

    public C1226wS(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: d */
    public void m6986d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6659uV);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6660av;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6987a(C1226wS c1226wS, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        C0886py c0886py;
        Player player = iPayloadContext.player();
        if (player instanceof ServerPlayer) {
            Player player2 = (ServerPlayer) player;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6662jz && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            UUID uuid = player2.getUUID();
            AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a(player2);
            if (C0875pn.m4488a(player2, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a) || abstractC0183bM1153a.m1104dt() || (abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid)) == 0 || !(abstractC0863pbMo2354a instanceof InterfaceC0984rq)) {
                return;
            }
            InterfaceC0984rq interfaceC0984rq = (InterfaceC0984rq) abstractC0863pbMo2354a;
            if (abstractC0863pbMo2354a.m4023a() == EnumC0871pj.GAME && (c0886py = interfaceC0984rq.mo5554a(uuid).get(c1226wS.f6659uV)) != null) {
                int iM4637bz = c0886py.m4637bz();
                C1060tL c1060tLMo5555c = interfaceC0984rq.mo5555c();
                int iM4445a = C0875pn.m4445a(abstractC0863pbMo2354a, uuid, c1060tLMo5555c);
                if (iM4445a >= iM4637bz) {
                    player2.addItem(c0886py.m4636c().copy());
                    C0875pn.m4447a(abstractC0863pbMo2354a, uuid, c1060tLMo5555c, iM4445a - iM4637bz);
                    C0875pn.m4364a((ServerPlayer) player2, (SoundEvent) C1312xz.f8149sO.get(), SoundSource.NEUTRAL);
                    C0875pn.m4406c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout", new Object[]{c0886py.m4636c().getDisplayName(), Component.literal(String.valueOf(iM4637bz)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY));
                    return;
                }
                C0875pn.m4406c((ServerPlayer) player2, (Component) Component.translatable("bf.message.gamemode.ttt.loadout.fail", new Object[]{Component.literal(String.valueOf(iM4637bz)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
