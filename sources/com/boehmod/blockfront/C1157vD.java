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

/* JADX INFO: renamed from: com.boehmod.blockfront.vD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vD.class */
public final class C1157vD extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: M */
    @NotNull
    private final UUID f6122M;

    /* JADX INFO: renamed from: aA */
    @NotNull
    private final Vec3 f6123aA;

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final CustomPacketPayload.Type<C1157vD> f6124G = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_move_map_effect"));

    /* JADX INFO: renamed from: H */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1157vD> f6125H = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6494d(v1);
    }, C1157vD::new);

    public C1157vD(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.f6122M = uuid;
        this.f6123aA = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1157vD.class), C1157vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1157vD.class), C1157vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1157vD.class, Object.class), C1157vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6496l() {
        return this.f6122M;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public Vec3 m6497E() {
        return this.f6123aA;
    }

    public C1157vD(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    /* JADX INFO: renamed from: d */
    public void m6494d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6122M.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6122M.getLeastSignificantBits());
        friendlyByteBuf.writeDouble(this.f6123aA.x);
        friendlyByteBuf.writeDouble(this.f6123aA.y);
        friendlyByteBuf.writeDouble(this.f6123aA.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6124G;
    }

    /* JADX INFO: renamed from: a */
    public static void m6495a(C1157vD c1157vD, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C1018sY c1018sYM3653a;
        AbstractC0835pA abstractC0835pAM5608a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (abstractC0835pAM5608a = (c1018sYM3653a = abstractC0787oFM2530a.m3653a()).m5608a(c1157vD.f6122M)) == null) {
                return;
            }
            if (c1018sYM3653a.m5612p(c1157vD.f6122M)) {
                C0605kj c0605kjM5613a = c1018sYM3653a.m5613a(c1157vD.f6122M);
                if (c0605kjM5613a == null) {
                    return;
                }
                C0531jO c0531jOM2372c = C0531jO.m2372c();
                C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C0604ki.class);
                C0604ki c0604ki = c0529jMM2375a != null ? (C0604ki) c0529jMM2375a.m2347a(c0605kjM5613a.m2651A()) : null;
                c0605kjM5613a.m2653b(c1157vD.f6123aA.subtract(c0604ki != null ? c0604ki.m2645a().f4464c : Vec3.ZERO));
                c1018sYM3653a.m5611b(c0531jOM2372c);
                RunnableC0527jK runnableC0527jKM2373a = c0531jOM2372c.m2373a();
                if (runnableC0527jKM2373a != null) {
                    runnableC0527jKM2373a.m2332i(abstractC0787oFM2530a.m3591a().getName() + ".json");
                }
                C0529jM c0529jMM2375a2 = c0531jOM2372c.m2375a(C1017sX.class);
                if (c0529jMM2375a2 != null) {
                    c0529jMM2375a2.m2351j(abstractC0787oFM2530a.m3591a().getName());
                }
            } else {
                abstractC0835pAM5608a.f4464c = c1157vD.f6123aA;
            }
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
            }
        }
    }
}
