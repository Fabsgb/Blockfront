package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vh.class */
public final class C1187vh extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: H */
    @NotNull
    private final UUID f6256H;

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final CustomPacketPayload.Type<C1187vh> f6257l = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_copy_map_effect"));

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1187vh> f6258m = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6625d(v1);
    }, C1187vh::new);

    public C1187vh(@NotNull UUID uuid) {
        this.f6256H = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1187vh.class), C1187vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1187vh.class), C1187vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1187vh.class, Object.class), C1187vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6627l() {
        return this.f6256H;
    }

    public C1187vh(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    /* JADX INFO: renamed from: d */
    public void m6625d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6256H.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6256H.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6257l;
    }

    /* JADX INFO: renamed from: a */
    public static void m6626a(C1187vh c1187vh, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C1018sY c1018sYM3653a;
        AbstractC0835pA abstractC0835pAM5608a;
        C0605kj c0605kjM5613a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (abstractC0835pAM5608a = (c1018sYM3653a = abstractC0787oFM2530a.m3653a()).m5608a(c1187vh.f6256H)) == null) {
                return;
            }
            RandomSource random = player.getRandom();
            Vec3 vec3 = new Vec3(random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d);
            if (c1018sYM3653a.m5612p(c1187vh.f6256H) && (c0605kjM5613a = c1018sYM3653a.m5613a(c1187vh.f6256H)) != null) {
                c1018sYM3653a.m5614a(new C0605kj(c0605kjM5613a.m2651A(), c0605kjM5613a.m2652j().add(vec3), c0605kjM5613a.m2654b() != null ? c0605kjM5613a.m2654b().deepCopy() : null));
                C0531jO c0531jOM2372c = C0531jO.m2372c();
                c1018sYM3653a.m5611b(c0531jOM2372c);
                c1018sYM3653a.m5600da();
                C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
                MinecraftServer minecraftServerM2514a = C0561js.m2514a();
                if (minecraftServerM2514a != null) {
                    C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
                }
                RunnableC0527jK runnableC0527jKM2373a = c0531jOM2372c.m2373a();
                if (runnableC0527jKM2373a != null) {
                    runnableC0527jKM2373a.m2332i(abstractC0787oFM2530a.m3591a().getName() + ".json");
                }
                C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C1017sX.class);
                if (c0529jMM2375a != null) {
                    c0529jMM2375a.m2351j(abstractC0787oFM2530a.m3591a().getName());
                    return;
                }
                return;
            }
            ByteBuf byteBufBuffer = Unpooled.buffer();
            C0836pB.f4477d.encode(byteBufBuffer, abstractC0835pAM5608a);
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0836pB.f4477d.decode(byteBufBuffer);
            abstractC0835pA.f4463y = UUID.randomUUID();
            abstractC0835pA.f4464c = abstractC0835pA.f4464c.add(vec3);
            c1018sYM3653a.m5605a(abstractC0835pA);
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a2 = C0561js.m2514a();
            if (minecraftServerM2514a2 != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a2.overworld(), null);
            }
        }
    }
}
