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

/* JADX INFO: renamed from: com.boehmod.blockfront.vI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vI.class */
public final class C1162vI extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumC0988rv f6140c;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final BlockPos f6141h;

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final CustomPacketPayload.Type<C1162vI> f6142L;

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1162vI> f6143M;

    /* JADX INFO: renamed from: jO */
    @NotNull
    private static final Component f6144jO;

    /* JADX INFO: renamed from: nT */
    private static final float f6145nT = 32.0f;

    /* JADX INFO: renamed from: sF */
    private static final int f6146sF = 600;

    /* JADX INFO: renamed from: iM */
    static final /* synthetic */ boolean f6147iM;

    public C1162vI(@NotNull EnumC0988rv enumC0988rv, @NotNull BlockPos blockPos) {
        this.f6140c = enumC0988rv;
        this.f6141h = blockPos;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1162vI.class), C1162vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1162vI.class), C1162vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1162vI.class, Object.class), C1162vI.class, "gameEventType;blockPos", "FIELD:Lcom/boehmod/blockfront/vI;->c:Lcom/boehmod/blockfront/rv;", "FIELD:Lcom/boehmod/blockfront/vI;->h:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public EnumC0988rv m6516b() {
        return this.f6140c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockPos m6517a() {
        return this.f6141h;
    }

    static {
        f6147iM = !C1162vI.class.desiredAssertionStatus();
        f6142L = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_radio_command"));
        f6143M = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6513d(v1);
        }, C1162vI::new);
        f6144jO = Component.translatable("bf.message.gamemode.radio.command.fail.spawnclose");
    }

    public C1162vI(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((EnumC0988rv) friendlyByteBuf.readEnum(EnumC0988rv.class), friendlyByteBuf.readBlockPos());
    }

    /* JADX INFO: renamed from: d */
    public void m6513d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f6140c);
        friendlyByteBuf.writeBlockPos(this.f6141h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6142L;
    }

    /* JADX INFO: renamed from: a */
    public static void m6514a(C1162vI c1162vI, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0790oI abstractC0790oIM3582b;
        C0796oO c0796oOM3793a;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f6147iM && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a == null || !abstractC0787oFMo2531a.m3587a().equals(EnumC0795oN.GAME) || (c0796oOM3793a = (abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b()).m3793a(uuid)) == null) {
                return;
            }
            EnumC0988rv enumC0988rv = c1162vI.f6140c;
            BlockPos blockPos = c1162vI.f6141h;
            boolean zHasCooldown = enumC0988rv.hasCooldown();
            C1088to cooldownStat = enumC0988rv.getCooldownStat();
            int iM3867a = c0796oOM3793a.m3867a(cooldownStat, 0);
            if (iM3867a > 0 && zHasCooldown) {
                C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7572pD.get(), SoundSource.MASTER);
                C0799oR.m3973a(serverPlayer, C0799oR.f4380iM, (Component) Component.translatable(enumC0988rv.isWaypoint() ? "bf.message.gamemode.radio.command.fail.time.waypoint" : "bf.message.gamemode.radio.command.fail.time", new Object[]{Component.literal(C0119bk.m502a(iM3867a)).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            ItemStack mainHandItem = serverPlayer.getMainHandItem();
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1129uc)) {
                if (enumC0988rv.hasSpawnProtection() && m6515a(blockPos, serverPlayer, abstractC0790oIM3582b)) {
                    return;
                }
                if (zHasCooldown) {
                    c0796oOM3793a.m3864a(cooldownStat, enumC0988rv.getMaxCooldown());
                }
                AbstractC0982rp c0987ru = null;
                C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7571pC.get(), SoundSource.MASTER);
                switch (enumC0988rv) {
                    case AIR_STRIKE:
                        c0987ru = new C0983rq(serverPlayer, blockPos.getCenter(), 20, 200);
                        break;
                    case PRECISION_AIR_STRIKE:
                        c0987ru = new C0986rt(serverPlayer, blockPos.getCenter(), 20, 20);
                        break;
                    case SMOKE_STRIKE:
                        c0987ru = new C0987ru(serverPlayer, blockPos.getCenter(), 20, C0357g.f2439g);
                        break;
                }
                Vec3 vec3 = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                C0799oR.m3993a((AbstractC0790oI<?>) abstractC0790oIM3582b, c0796oOM3793a, (Component) Component.translatable("bf.message.gamemode.radio.command.toteam", new Object[]{Component.translatable(enumC0988rv.getLocale()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY), 100, (String) null, vec3, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
                C1163vJ c1163vJ = new C1163vJ(enumC0988rv.getIconName(), 600, vec3, enumC0988rv);
                C1199vt c1199vt = new C1199vt(C1280xc.f7574pF, SoundSource.MASTER, serverPlayerPlayer.getId(), 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f), 1.0f);
                Iterator<UUID> it = c0796oOM3793a.m3872h().iterator();
                while (it.hasNext()) {
                    ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
                    if (serverPlayerM3963a != null) {
                        C0799oR.m3930a(serverPlayerM3963a, (SoundEvent) C1280xc.f7573pE.get(), SoundSource.MASTER, 1.25f);
                        C1194vo.m6648a(c1163vJ, serverPlayerM3963a);
                        C1194vo.m6648a(c1199vt, serverPlayerM3963a);
                    }
                }
                if (c0987ru != null) {
                    abstractC0787oFMo2531a.m3625a(c0987ru);
                    if (c0987ru.mo5420l() != null) {
                        C0799oR.m3973a(serverPlayer, C0799oR.f4380iM, c0987ru.mo5420l());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6515a(@NotNull BlockPos blockPos, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0790oI<?> abstractC0790oI) {
        Iterator<C0796oO> it = abstractC0790oI.m3808A().iterator();
        while (it.hasNext()) {
            Iterator<C0805oX> it2 = it.next().m3873B().iterator();
            while (it2.hasNext()) {
                if (C1290xm.m7866a(blockPos, it2.next().f4424c, 32.0d)) {
                    C0799oR.m3973a(serverPlayer, C0799oR.f4380iM, f6144jO);
                    return true;
                }
            }
        }
        return false;
    }
}
