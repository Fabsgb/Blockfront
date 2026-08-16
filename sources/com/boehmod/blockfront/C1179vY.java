package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vY.class */
public final class C1179vY implements CustomPacketPayload {

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final CustomPacketPayload.Type<C1179vY> f6417B;

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1179vY> f6418C;

    /* JADX INFO: renamed from: jd */
    static final /* synthetic */ boolean f6419jd;

    static {
        f6419jd = !C1179vY.class.desiredAssertionStatus();
        f6417B = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_war_cry"));
        f6418C = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6703d(v1);
        }, C1179vY::new);
    }

    public C1179vY() {
    }

    public C1179vY(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6703d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6417B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6704a(C1179vY c1179vY, @NotNull IPayloadContext iPayloadContext) {
        C0872pk c0872pkM4229a;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6419jd && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a instanceof InterfaceC0945rD) {
                InterfaceC0945rD interfaceC0945rD = (InterfaceC0945rD) abstractC0863pbMo2354a;
                AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
                Level level = serverPlayer.level();
                if (InterfaceC0945rD.m5182a(abstractC0184cM2351a, serverPlayer) && interfaceC0945rD.mo5184a(level, serverPlayer, uuid) && (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) != null) {
                    interfaceC0945rD.mo5185a(level, serverPlayer, uuid);
                    InterfaceC0945rD.m5183a(abstractC0863pbMo2354a, c0872pkM4229a.m4296a(abstractC0863pbMo2354a), serverPlayer, uuid);
                }
            }
        }
    }
}
