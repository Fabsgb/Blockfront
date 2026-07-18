package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wj.class */
public final class C1242wj extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: cj */
    @NotNull
    private final List<C1142up> f7369cj;

    /* JADX INFO: renamed from: aH */
    private final Vec3 f7370aH;

    /* JADX INFO: renamed from: o */
    private final Vec2 f7371o;

    /* JADX INFO: renamed from: oc */
    private final float f7372oc;

    /* JADX INFO: renamed from: od */
    private final float f7373od;

    /* JADX INFO: renamed from: v */
    private final long f7374v;

    /* JADX INFO: renamed from: w */
    private final long f7375w;

    /* JADX INFO: renamed from: sN */
    private final int f7376sN;

    /* JADX INFO: renamed from: am */
    @NotNull
    public static final CustomPacketPayload.Type<C1242wj> f7377am;

    /* JADX INFO: renamed from: an */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1242wj> f7378an;

    /* JADX INFO: renamed from: jd */
    static final /* synthetic */ boolean f7379jd;

    public C1242wj(@NotNull List<C1142up> list, Vec3 vec3, Vec2 vec2, float f, float f2, long j, long j2, int i) {
        this.f7369cj = list;
        this.f7370aH = vec3;
        this.f7371o = vec2;
        this.f7372oc = f;
        this.f7373od = f2;
        this.f7374v = j;
        this.f7375w = j2;
        this.f7376sN = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1242wj.class), C1242wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1242wj.class), C1242wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1242wj.class, Object.class), C1242wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aM */
    public List<C1142up> m7668aM() {
        return this.f7369cj;
    }

    /* JADX INFO: renamed from: h */
    public Vec3 m7669h() {
        return this.f7370aH;
    }

    /* JADX INFO: renamed from: a */
    public Vec2 m7670a() {
        return this.f7371o;
    }

    /* JADX INFO: renamed from: bV */
    public float m7671bV() {
        return this.f7372oc;
    }

    /* JADX INFO: renamed from: ae */
    public float m7672ae() {
        return this.f7373od;
    }

    /* JADX INFO: renamed from: f */
    public long m7673f() {
        return this.f7374v;
    }

    /* JADX INFO: renamed from: g */
    public long m7674g() {
        return this.f7375w;
    }

    /* JADX INFO: renamed from: am */
    public int m7675am() {
        return this.f7376sN;
    }

    static {
        f7379jd = !C1242wj.class.desiredAssertionStatus();
        f7377am = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_collision_living"));
        f7378an = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7665d(v1);
        }, C1242wj::new);
    }

    public C1242wj(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C1291xn.m7879b(friendlyByteBuf), friendlyByteBuf.readVec3(), new Vec2(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readLong(), friendlyByteBuf.readLong(), friendlyByteBuf.readVarInt());
    }

    /* JADX INFO: renamed from: d */
    public void m7665d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C1291xn.m7880b(friendlyByteBuf, this.f7369cj);
        friendlyByteBuf.writeVec3(this.f7370aH);
        friendlyByteBuf.writeFloat(this.f7371o.x);
        friendlyByteBuf.writeFloat(this.f7371o.y);
        friendlyByteBuf.writeFloat(this.f7372oc);
        friendlyByteBuf.writeFloat(this.f7373od);
        friendlyByteBuf.writeLong(this.f7374v);
        friendlyByteBuf.writeLong(this.f7375w);
        friendlyByteBuf.writeVarInt(this.f7376sN);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7377am;
    }

    /* JADX INFO: renamed from: a */
    public static void m7666a(C1242wj c1242wj, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f7379jd && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a = abstractC0563juM168a.m2530a((Player) serverPlayer);
            boolean z = C0476iM.f2918df;
            if (abstractC0563juM168a instanceof C1300xw) {
                C1300xw c1300xw = (C1300xw) abstractC0563juM168a;
                if (z) {
                    C0521jE c0521jEM7667a = m7667a(c1242wj, serverPlayer, c1300xw, (C1276xQ) c1300xw.m7950a());
                    if (!c0521jEM7667a.m2284af()) {
                        return;
                    }
                    C1105uE.m6098a(abstractC0563juM168a, (AbstractC0183c<?>) abstractC0563juM168a.m2528a(), serverPlayer.level(), (LivingEntity) serverPlayer, abstractC0787oFM2530a, c0521jEM7667a.m2286o());
                    return;
                }
            }
            C1105uE.m6098a(abstractC0563juM168a, (AbstractC0183c<?>) abstractC0563juM168a.m2528a(), serverPlayer.level(), (LivingEntity) serverPlayer, abstractC0787oFM2530a, c1242wj.f7369cj);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0521jE m7667a(@NotNull C1242wj c1242wj, @NotNull ServerPlayer serverPlayer, @NotNull C1300xw c1300xw, @NotNull C1276xQ c1276xQ) {
        return new C0522jF(c1300xw.mo2529a()).m2287a(c1300xw, c1276xQ, serverPlayer.serverLevel(), serverPlayer, c1242wj.f7369cj, c1242wj.f7370aH, c1242wj.f7371o, c1242wj.f7372oc, c1242wj.f7373od, c1242wj.f7374v, c1242wj.f7375w, c1242wj.f7376sN);
    }
}
