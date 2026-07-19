package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vI.class */
public final class vI extends Record implements CustomPacketPayload {

    @NotNull
    private final EnumC0481rv c;

    @NotNull
    private final BlockPos h;

    @NotNull
    public static final CustomPacketPayload.Type<vI> L;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vI> M;

    @NotNull
    private static final Component jO;
    private static final float nT = 32.0f;
    private static final int sF = 600;
    static final /* synthetic */ boolean iM;

    public vI(@NotNull EnumC0481rv enumC0481rv, @NotNull BlockPos blockPos) {
        this.c = enumC0481rv;
        this.h = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vI.class), vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vI.class), vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vI.class, Object.class), vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public EnumC0481rv b() {
        return this.c;
    }

    @NotNull
    public BlockPos a() {
        return this.h;
    }

    static {
        iM = !vI.class.desiredAssertionStatus();
        L = new CustomPacketPayload.Type<>(C0265jv.d("packet_radio_command"));
        M = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vI::new);
        jO = Component.translatable("bf.message.gamemode.radio.command.fail.spawnclose");
    }

    public vI(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0481rv) friendlyByteBuf.readEnum(EnumC0481rv.class), friendlyByteBuf.readBlockPos());
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.c);
        friendlyByteBuf.writeBlockPos(this.h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return L;
    }

    public static void a(vI vIVar, @NotNull IPayloadContext iPayloadContext) {
        oI oIVarB;
        oO oOVarA;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!iM && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a == null || !oFVarMo604a.m750a().equals(oN.GAME) || (oOVarA = (oIVarB = oFVarMo604a.b()).a(uuid)) == null) {
                return;
            }
            EnumC0481rv enumC0481rv = vIVar.c;
            BlockPos blockPos = vIVar.h;
            boolean zHasCooldown = enumC0481rv.hasCooldown();
            C0528to cooldownStat = enumC0481rv.getCooldownStat();
            int iM790a = oOVarA.m790a(cooldownStat, 0);
            if (iM790a > 0 && zHasCooldown) {
                oR.a(serverPlayer, (SoundEvent) C0624xc.pD.get(), SoundSource.MASTER);
                oR.a(serverPlayer, oR.iM, (Component) Component.translatable(enumC0481rv.isWaypoint() ? "bf.message.gamemode.radio.command.fail.time.waypoint" : "bf.message.gamemode.radio.command.fail.time", new Object[]{Component.literal(C0040bk.a(iM790a)).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            ItemStack mainHandItem = serverPlayer.getMainHandItem();
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C0543uc)) {
                if (enumC0481rv.hasSpawnProtection() && a(blockPos, serverPlayer, oIVarB)) {
                    return;
                }
                if (zHasCooldown) {
                    oOVarA.a(cooldownStat, enumC0481rv.getMaxCooldown());
                }
                AbstractC0475rp c0480ru = null;
                oR.a(serverPlayer, (SoundEvent) C0624xc.pC.get(), SoundSource.MASTER);
                switch (enumC0481rv) {
                    case AIR_STRIKE:
                        c0480ru = new C0476rq(serverPlayer, blockPos.getCenter(), 20, 200);
                        break;
                    case PRECISION_AIR_STRIKE:
                        c0480ru = new C0479rt(serverPlayer, blockPos.getCenter(), 20, 20);
                        break;
                    case SMOKE_STRIKE:
                        c0480ru = new C0480ru(serverPlayer, blockPos.getCenter(), 20, C0163g.g);
                        break;
                }
                Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                oR.a((oI<?>) oIVarB, oOVarA, (Component) Component.translatable("bf.message.gamemode.radio.command.toteam", new Object[]{Component.translatable(enumC0481rv.getLocale()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY), 100, (String) null, vec3, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
                vJ vJVar = new vJ(enumC0481rv.getIconName(), 600, vec3, enumC0481rv);
                C0587vt c0587vt = new C0587vt(C0624xc.pF, SoundSource.MASTER, serverPlayerPlayer.getId(), 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f), 1.0f);
                Iterator<UUID> it = oOVarA.h().iterator();
                while (it.hasNext()) {
                    ServerPlayer serverPlayerA = oR.a(it.next());
                    if (serverPlayerA != null) {
                        oR.a(serverPlayerA, (SoundEvent) C0624xc.pE.get(), SoundSource.MASTER, 1.25f);
                        C0582vo.a(vJVar, serverPlayerA);
                        C0582vo.a(c0587vt, serverPlayerA);
                    }
                }
                if (c0480ru != null) {
                    oFVarMo604a.a(c0480ru);
                    if (c0480ru.l() != null) {
                        oR.a(serverPlayer, oR.iM, c0480ru.l());
                    }
                }
            }
        }
    }

    private static boolean a(@NotNull BlockPos blockPos, @NotNull ServerPlayer serverPlayer, @NotNull oI<?> oIVar) {
        Iterator<oO> it = oIVar.A().iterator();
        while (it.hasNext()) {
            Iterator<oX> it2 = it.next().B().iterator();
            while (it2.hasNext()) {
                if (C0634xm.a(blockPos, it2.next().c, 32.0d)) {
                    oR.a(serverPlayer, oR.iM, jO);
                    return true;
                }
            }
        }
        return false;
    }
}
