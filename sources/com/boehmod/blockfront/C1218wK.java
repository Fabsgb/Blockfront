package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.wK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wK.class */
public final class C1218wK extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: aI */
    private final Vec3 f6618aI;

    /* JADX INFO: renamed from: o */
    private final Vec2 f6619o;

    /* JADX INFO: renamed from: pa */
    private final float f6620pa;

    /* JADX INFO: renamed from: pb */
    private final float f6621pb;

    /* JADX INFO: renamed from: Q */
    private final long f6622Q;

    /* JADX INFO: renamed from: cs */
    @NotNull
    private final List<C1120uS> f6623cs;

    /* JADX INFO: renamed from: uT */
    private static final int f6624uT = 64;

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final CustomPacketPayload.Type<C1218wK> f6625an;

    /* JADX INFO: renamed from: ao */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1218wK> f6626ao;

    /* JADX INFO: renamed from: jw */
    static final /* synthetic */ boolean f6627jw;

    public C1218wK(Vec3 vec3, Vec2 vec2, float f, float f2, long j, @NotNull List<C1120uS> list) {
        this.f6618aI = vec3;
        this.f6619o = vec2;
        this.f6620pa = f;
        this.f6621pb = f2;
        this.f6622Q = j;
        this.f6623cs = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1218wK.class), C1218wK.class, "position;direction;itemSpread;shootBackPitch;shootTick;pellets", "FIELD:Lcom/boehmod/blockfront/wK;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wK;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wK;->pa:F", "FIELD:Lcom/boehmod/blockfront/wK;->pb:F", "FIELD:Lcom/boehmod/blockfront/wK;->Q:J", "FIELD:Lcom/boehmod/blockfront/wK;->cs:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1218wK.class), C1218wK.class, "position;direction;itemSpread;shootBackPitch;shootTick;pellets", "FIELD:Lcom/boehmod/blockfront/wK;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wK;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wK;->pa:F", "FIELD:Lcom/boehmod/blockfront/wK;->pb:F", "FIELD:Lcom/boehmod/blockfront/wK;->Q:J", "FIELD:Lcom/boehmod/blockfront/wK;->cs:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1218wK.class, Object.class), C1218wK.class, "position;direction;itemSpread;shootBackPitch;shootTick;pellets", "FIELD:Lcom/boehmod/blockfront/wK;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wK;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wK;->pa:F", "FIELD:Lcom/boehmod/blockfront/wK;->pb:F", "FIELD:Lcom/boehmod/blockfront/wK;->Q:J", "FIELD:Lcom/boehmod/blockfront/wK;->cs:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: h */
    public Vec3 m6949h() {
        return this.f6618aI;
    }

    /* JADX INFO: renamed from: a */
    public Vec2 m6950a() {
        return this.f6619o;
    }

    /* JADX INFO: renamed from: cb */
    public float m6951cb() {
        return this.f6620pa;
    }

    /* JADX INFO: renamed from: af */
    public float m6952af() {
        return this.f6621pb;
    }

    /* JADX INFO: renamed from: g */
    public long m6953g() {
        return this.f6622Q;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public List<C1120uS> m6954r() {
        return this.f6623cs;
    }

    static {
        f6627jw = !C1218wK.class.desiredAssertionStatus();
        f6625an = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_shot_fired"));
        f6626ao = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6945d(v1);
        }, C1218wK::new);
    }

    public C1218wK(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3(), new Vec2(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readLong(), m6946a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6945d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f6618aI);
        friendlyByteBuf.writeFloat(this.f6619o.x);
        friendlyByteBuf.writeFloat(this.f6619o.y);
        friendlyByteBuf.writeFloat(this.f6620pa);
        friendlyByteBuf.writeFloat(this.f6621pb);
        friendlyByteBuf.writeLong(this.f6622Q);
        friendlyByteBuf.writeVarInt(this.f6623cs.size());
        Iterator<C1120uS> it = this.f6623cs.iterator();
        while (it.hasNext()) {
            it.next().m6409a(friendlyByteBuf);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static List<C1120uS> m6946a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int varInt = friendlyByteBuf.readVarInt();
        if (varInt < 0 || varInt > 64) {
            throw new IllegalArgumentException("Invalid pellet count " + varInt);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(varInt);
        for (int i = 0; i < varInt; i++) {
            objectArrayList.add(C1120uS.m6408a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6625an;
    }

    /* JADX INFO: renamed from: a */
    public static void m6947a(C1218wK c1218wK, @NotNull IPayloadContext iPayloadContext) {
        ItemStack itemInHand;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6627jw && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayer);
            if (abstractC0183bM1153a.m1110dv() || C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a)) {
                return;
            }
            C0816oh c0816ohM6948a = m6948a(serverPlayer);
            if (c0816ohM6948a != null) {
                itemInHand = new ItemStack(c0816ohM6948a.m3764c());
            } else {
                itemInHand = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
            }
            ItemStack itemStack = itemInHand;
            Item item = itemStack.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                Level level = serverPlayer.level();
                if (c1117uP.m6315a(itemStack).m6877a() == EnumC1201vu.ENTITY) {
                    if (c0816ohM6948a != null || c1117uP.m6361a(itemStack, level, (LivingEntity) serverPlayer)) {
                        c1117uP.m6362a(abstractC0184cM2351a, level, (Player) serverPlayer, itemStack);
                        return;
                    }
                    return;
                }
                if (c0816ohM6948a != null) {
                    c0816ohM6948a.m3775b(serverPlayer);
                } else if (!c1117uP.m6361a(itemStack, level, (LivingEntity) serverPlayer)) {
                    return;
                }
                if (c1218wK.f6623cs.isEmpty()) {
                    return;
                }
                AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a = abstractC0531jNM179a.m2353a((Player) serverPlayer);
                boolean z = C0549jf.f3267dp;
                if (abstractC0531jNM179a instanceof C1280xT) {
                    C1280xT c1280xT = (C1280xT) abstractC0531jNM179a;
                    if (z) {
                        C0541jX c0541jXM2421a = new C0542jY(c1280xT.mo2352a()).m2421a(c1280xT, (C1328yo) c1280xT.m7277a(), serverPlayer.serverLevel(), serverPlayer, itemStack, c1117uP, c0816ohM6948a != null, c1218wK.f6623cs, c1218wK.f6618aI, c1218wK.f6619o, c1218wK.f6620pa, c1218wK.f6621pb, c1218wK.f6622Q);
                        if (c0541jXM2421a.m2418aj()) {
                            C1185ve.m6750a(abstractC0531jNM179a, abstractC0184cM2351a, serverPlayer.serverLevel(), (LivingEntity) serverPlayer, abstractC0863pbM2353a, c0541jXM2421a.m2420q());
                            return;
                        }
                        return;
                    }
                }
                C1185ve.m6750a(abstractC0531jNM179a, abstractC0184cM2351a, serverPlayer.serverLevel(), (LivingEntity) serverPlayer, abstractC0863pbM2353a, c1218wK.f6623cs);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0816oh m6948a(@NotNull ServerPlayer serverPlayer) {
        C0755nZ c0755nZM3472a;
        Entity vehicle = serverPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0750nU) || (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a((Entity) serverPlayer)) == null) {
            return null;
        }
        for (AbstractC0818oj<?> abstractC0818oj : c0755nZM3472a.m3514c()) {
            if (abstractC0818oj instanceof C0816oh) {
                C0816oh c0816oh = (C0816oh) abstractC0818oj;
                if (c0816oh.m3763a() == EnumC0817oi.BULLET) {
                    return c0816oh;
                }
            }
        }
        return null;
    }
}
