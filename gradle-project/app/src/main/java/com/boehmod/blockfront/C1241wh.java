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

/* JADX INFO: renamed from: com.boehmod.blockfront.wh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wh.class */
public final class C1241wh extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumC0960rS f6713c;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final BlockPos f6714h;

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final CustomPacketPayload.Type<C1241wh> f6715K;

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1241wh> f6716L;

    /* JADX INFO: renamed from: kb */
    @NotNull
    private static final Component f6717kb;

    /* JADX INFO: renamed from: oR */
    private static final float f6718oR = 32.0f;

    /* JADX INFO: renamed from: uJ */
    private static final int f6719uJ = 600;

    /* JADX INFO: renamed from: jf */
    static final /* synthetic */ boolean f6720jf;

    public C1241wh(@NotNull EnumC0960rS enumC0960rS, @NotNull BlockPos blockPos) {
        this.f6713c = enumC0960rS;
        this.f6714h = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1241wh.class), C1241wh.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/wh;->c:Lcom/boehmod/blockfront/rS;", "FIELD:Lcom/boehmod/blockfront/wh;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1241wh.class), C1241wh.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/wh;->c:Lcom/boehmod/blockfront/rS;", "FIELD:Lcom/boehmod/blockfront/wh;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1241wh.class, Object.class), C1241wh.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/wh;->c:Lcom/boehmod/blockfront/rS;", "FIELD:Lcom/boehmod/blockfront/wh;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0960rS m7039b() {
        return this.f6713c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockPos m7040a() {
        return this.f6714h;
    }

    static {
        f6720jf = !C1241wh.class.desiredAssertionStatus();
        f6715K = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_radio_command"));
        f6716L = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7036d(v1);
        }, C1241wh::new);
        f6717kb = Component.translatable("bf.message.gamemode.radio.command.fail.spawnclose");
    }

    public C1241wh(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0960rS) friendlyByteBuf.readEnum(EnumC0960rS.class), friendlyByteBuf.readBlockPos());
    }

    /* JADX INFO: renamed from: d */
    public void m7036d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6713c);
        friendlyByteBuf.writeBlockPos(this.f6714h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6715K;
    }

    /* JADX INFO: renamed from: a */
    public static void m7037a(C1241wh c1241wh, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0866pe abstractC0866peM4018b;
        C0872pk c0872pkM4229a;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6720jf && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a == null || !abstractC0863pbMo2354a.m4023a().equals(EnumC0871pj.GAME) || (c0872pkM4229a = (abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b()).m4229a(uuid)) == null) {
                return;
            }
            EnumC0960rS enumC0960rS = c1241wh.f6713c;
            BlockPos blockPos = c1241wh.f6714h;
            boolean zHasCooldown = enumC0960rS.hasCooldown();
            C1060tL cooldownStat = enumC0960rS.getCooldownStat();
            int iM4303a = c0872pkM4229a.m4303a(cooldownStat, 0);
            if (iM4303a > 0 && zHasCooldown) {
                C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f7984pF.get(), SoundSource.MASTER);
                C0875pn.m4409a(serverPlayer, C0875pn.f4776iY, (Component) Component.translatable(enumC0960rS.isWaypoint() ? "bf.message.gamemode.radio.command.fail.time.waypoint" : "bf.message.gamemode.radio.command.fail.time", new Object[]{Component.literal(C0129bt.m602a(iM4303a)).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            ItemStack mainHandItem = serverPlayer.getMainHandItem();
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1102uA)) {
                if (enumC0960rS.hasSpawnProtection() && m7038a(blockPos, serverPlayer, abstractC0866peM4018b)) {
                    return;
                }
                if (zHasCooldown) {
                    c0872pkM4229a.m4300a(cooldownStat, enumC0960rS.getMaxCooldown());
                }
                AbstractC0954rM c0959rR = null;
                C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f7983pE.get(), SoundSource.MASTER);
                switch (enumC0960rS) {
                    case AIR_STRIKE:
                        c0959rR = new C0955rN(serverPlayer, blockPos.getCenter(), 20, 200);
                        break;
                    case PRECISION_AIR_STRIKE:
                        c0959rR = new C0958rQ(serverPlayer, blockPos.getCenter(), 20, 20);
                        break;
                    case SMOKE_STRIKE:
                        c0959rR = new C0959rR(serverPlayer, blockPos.getCenter(), 20, C0358g.f2490g);
                        break;
                }
                Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                C0875pn.m4429a((AbstractC0866pe<?>) abstractC0866peM4018b, c0872pkM4229a, (Component) Component.translatable("bf.message.gamemode.radio.command.toteam", new Object[]{Component.translatable(enumC0960rS.getLocale()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY), 100, (String) null, vec3, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
                C1242wi c1242wi = new C1242wi(enumC0960rS.getIconName(), 600, vec3, enumC0960rS);
                C1174vT c1174vT = new C1174vT(C1312xz.f7986pH, SoundSource.MASTER, serverPlayerPlayer.getId(), 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f), 1.0f);
                Iterator<UUID> it = c0872pkM4229a.m4308h().iterator();
                while (it.hasNext()) {
                    ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
                    if (serverPlayerM4399a != null) {
                        C0875pn.m4366a(serverPlayerM4399a, (SoundEvent) C1312xz.f7985pG.get(), SoundSource.MASTER, 1.25f);
                        C1169vO.m6643a(c1242wi, serverPlayerM4399a);
                        C1169vO.m6643a(c1174vT, serverPlayerM4399a);
                    }
                }
                if (c0959rR != null) {
                    abstractC0863pbMo2354a.m4061a(c0959rR);
                    if (c0959rR.mo5296l() != null) {
                        C0875pn.m4409a(serverPlayer, C0875pn.f4776iY, c0959rR.mo5296l());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7038a(@NotNull BlockPos blockPos, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0866pe<?> abstractC0866pe) {
        Iterator<C0872pk> it = abstractC0866pe.m4244C().iterator();
        while (it.hasNext()) {
            Iterator<C0881pt> it2 = it.next().m4309D().iterator();
            while (it2.hasNext()) {
                if (C1270xJ.m7193a(blockPos, it2.next().f4827c, 32.0d)) {
                    C0875pn.m4409a(serverPlayer, C0875pn.f4776iY, f6717kb);
                    return true;
                }
            }
        }
        return false;
    }
}
