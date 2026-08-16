package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wc.class */
public final class C1236wc extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: N */
    @NotNull
    private final UUID f6695N;

    /* JADX INFO: renamed from: aB */
    @NotNull
    private final Vec3 f6696aB;

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final CustomPacketPayload.Type<C1236wc> f6697F = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_move_map_effect"));

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1236wc> f6698G = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7017d(v1);
    }, C1236wc::new);

    public C1236wc(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.f6695N = uuid;
        this.f6696aB = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1236wc.class), C1236wc.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/wc;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wc;->aB:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1236wc.class), C1236wc.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/wc;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wc;->aB:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1236wc.class, Object.class), C1236wc.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/wc;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wc;->aB:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m7019l() {
        return this.f6695N;
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public Vec3 m7020F() {
        return this.f6696aB;
    }

    public C1236wc(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    /* JADX INFO: renamed from: d */
    public void m7017d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6695N.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6695N.getLeastSignificantBits());
        friendlyByteBuf.writeDouble(this.f6696aB.x);
        friendlyByteBuf.writeDouble(this.f6696aB.y);
        friendlyByteBuf.writeDouble(this.f6696aB.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6697F;
    }

    /* JADX INFO: renamed from: a */
    public static void m7018a(C1236wc c1236wc, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C1096tv c1096tvM4089a;
        AbstractC0858pW abstractC0858pWM6096a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (abstractC0858pWM6096a = (c1096tvM4089a = abstractC0863pbM2353a.m4089a()).m6096a(c1236wc.f6695N)) == null) {
                return;
            }
            if (c1096tvM4089a.m6100p(c1236wc.f6695N)) {
                C0576kF c0576kFM6101a = c1096tvM4089a.m6101a(c1236wc.f6695N);
                if (c0576kFM6101a == null) {
                    return;
                }
                C0607kk c0607kkM2734c = C0607kk.m2734c();
                C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C0575kE.class);
                C0575kE c0575kE = c0605kiM2737a != null ? (C0575kE) c0605kiM2737a.m2707a(c0576kFM6101a.m2604H()) : null;
                c0576kFM6101a.m2606b(c1236wc.f6696aB.subtract(c0575kE != null ? c0575kE.m2595a().f4593c : Vec3.ZERO));
                c1096tvM4089a.m6099b(c0607kkM2734c);
                RunnableC0603kg runnableC0603kgM2735a = c0607kkM2734c.m2735a();
                if (runnableC0603kgM2735a != null) {
                    runnableC0603kgM2735a.m2692i(abstractC0863pbM2353a.m4027a().getName() + ".json");
                }
                C0605ki c0605kiM2737a2 = c0607kkM2734c.m2737a(C1095tu.class);
                if (c0605kiM2737a2 != null) {
                    c0605kiM2737a2.m2713j(abstractC0863pbM2353a.m4027a().getName());
                }
            } else {
                abstractC0858pWM6096a.f4593c = c1236wc.f6696aB;
            }
            c1096tvM4089a.m6088dm();
            C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (minecraftServerM2335a != null) {
                C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
            }
        }
    }
}
