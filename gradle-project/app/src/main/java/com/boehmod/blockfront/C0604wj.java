package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.wj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wj.class */
public final class C0604wj extends Record implements CustomPacketPayload {

    @NotNull
    private final List<C0556up> cj;
    private final Vec3 aH;
    private final Vec2 o;
    private final float oc;
    private final float od;
    private final long v;
    private final long w;
    private final int sN;

    @NotNull
    public static final CustomPacketPayload.Type<C0604wj> am;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0604wj> an;
    static final /* synthetic */ boolean jd;

    public C0604wj(@NotNull List<C0556up> list, Vec3 vec3, Vec2 vec2, float f, float f2, long j, long j2, int i) {
        this.cj = list;
        this.aH = vec3;
        this.o = vec2;
        this.oc = f;
        this.od = f2;
        this.v = j;
        this.w = j2;
        this.sN = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0604wj.class), C0604wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0604wj.class), C0604wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0604wj.class, Object.class), C0604wj.class, "entityBulletHits;position;direction;itemSpread;shootBackPitch;shootTick;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/wj;->cj:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/wj;->aH:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wj;->o:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/wj;->oc:F", "FIELD:Lcom/boehmod/blockfront/wj;->od:F", "FIELD:Lcom/boehmod/blockfront/wj;->v:J", "FIELD:Lcom/boehmod/blockfront/wj;->w:J", "FIELD:Lcom/boehmod/blockfront/wj;->sN:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<C0556up> aM() {
        return this.cj;
    }

    public Vec3 h() {
        return this.aH;
    }

    public Vec2 a() {
        return this.o;
    }

    public float bV() {
        return this.oc;
    }

    public float ae() {
        return this.od;
    }

    public long f() {
        return this.v;
    }

    public long g() {
        return this.w;
    }

    public int am() {
        return this.sN;
    }

    static {
        jd = !C0604wj.class.desiredAssertionStatus();
        am = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_collision_living"));
        an = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0604wj::new);
    }

    public C0604wj(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0635xn.b(friendlyByteBuf), friendlyByteBuf.readVec3(), new Vec2(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readLong(), friendlyByteBuf.readLong(), friendlyByteBuf.readVarInt());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0635xn.b(friendlyByteBuf, this.cj);
        friendlyByteBuf.writeVec3(this.aH);
        friendlyByteBuf.writeFloat(this.o.x);
        friendlyByteBuf.writeFloat(this.o.y);
        friendlyByteBuf.writeFloat(this.oc);
        friendlyByteBuf.writeFloat(this.od);
        friendlyByteBuf.writeLong(this.v);
        friendlyByteBuf.writeLong(this.w);
        friendlyByteBuf.writeVarInt(this.sN);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return am;
    }

    public static void a(C0604wj c0604wj, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!jd && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarA = abstractC0264juM166a.a((Player) serverPlayer);
            boolean z = iM.df;
            if (abstractC0264juM166a instanceof xw) {
                xw xwVar = (xw) abstractC0264juM166a;
                if (z) {
                    jE jEVarA = a(c0604wj, serverPlayer, xwVar, (xQ) xwVar.a());
                    if (!jEVarA.af()) {
                        return;
                    }
                    uE.a(abstractC0264juM166a, (com.boehmod.blockfront.common.player.c<?>) abstractC0264juM166a.m531a(), serverPlayer.level(), (LivingEntity) serverPlayer, oFVarA, jEVarA.o());
                    return;
                }
            }
            uE.a(abstractC0264juM166a, (com.boehmod.blockfront.common.player.c<?>) abstractC0264juM166a.m531a(), serverPlayer.level(), (LivingEntity) serverPlayer, oFVarA, c0604wj.cj);
        }
    }

    @NotNull
    private static jE a(@NotNull C0604wj c0604wj, @NotNull ServerPlayer serverPlayer, @NotNull xw xwVar, @NotNull xQ xQVar) {
        return new jF(xwVar.mo532a()).a(xwVar, xQVar, serverPlayer.serverLevel(), serverPlayer, c0604wj.cj, c0604wj.aH, c0604wj.o, c0604wj.oc, c0604wj.od, c0604wj.v, c0604wj.w, c0604wj.sN);
    }
}
