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

/* JADX INFO: renamed from: com.boehmod.blockfront.vH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vH.class */
public final class C1162vH extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: I */
    @NotNull
    private final UUID f6340I;

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final CustomPacketPayload.Type<C1162vH> f6341l = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_copy_map_effect"));

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1162vH> f6342m = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6620d(v1);
    }, C1162vH::new);

    public C1162vH(@NotNull UUID uuid) {
        this.f6340I = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1162vH.class), C1162vH.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vH;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1162vH.class), C1162vH.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vH;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1162vH.class, Object.class), C1162vH.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vH;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6622l() {
        return this.f6340I;
    }

    public C1162vH(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    /* JADX INFO: renamed from: d */
    public void m6620d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6340I.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6340I.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6341l;
    }

    /* JADX INFO: renamed from: a */
    public static void m6621a(C1162vH c1162vH, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C1096tv c1096tvM4089a;
        AbstractC0858pW abstractC0858pWM6096a;
        C0576kF c0576kFM6101a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (abstractC0858pWM6096a = (c1096tvM4089a = abstractC0863pbM2353a.m4089a()).m6096a(c1162vH.f6340I)) == null) {
                return;
            }
            RandomSource random = player.getRandom();
            Vec3 vec3 = new Vec3(random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d);
            if (c1096tvM4089a.m6100p(c1162vH.f6340I) && (c0576kFM6101a = c1096tvM4089a.m6101a(c1162vH.f6340I)) != null) {
                c1096tvM4089a.m6102a(new C0576kF(c0576kFM6101a.m2604H(), c0576kFM6101a.m2605k().add(vec3), c0576kFM6101a.m2607b() != null ? c0576kFM6101a.m2607b().deepCopy() : null));
                C0607kk c0607kkM2734c = C0607kk.m2734c();
                c1096tvM4089a.m6099b(c0607kkM2734c);
                c1096tvM4089a.m6088dm();
                C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
                MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
                if (minecraftServerM2335a != null) {
                    C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
                }
                RunnableC0603kg runnableC0603kgM2735a = c0607kkM2734c.m2735a();
                if (runnableC0603kgM2735a != null) {
                    runnableC0603kgM2735a.m2692i(abstractC0863pbM2353a.m4027a().getName() + ".json");
                }
                C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C1095tu.class);
                if (c0605kiM2737a != null) {
                    c0605kiM2737a.m2713j(abstractC0863pbM2353a.m4027a().getName());
                    return;
                }
                return;
            }
            ByteBuf byteBufBuffer = Unpooled.buffer();
            C0859pX.f4606d.encode(byteBufBuffer, abstractC0858pWM6096a);
            AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0859pX.f4606d.decode(byteBufBuffer);
            abstractC0858pW.f4592y = UUID.randomUUID();
            abstractC0858pW.f4593c = abstractC0858pW.f4593c.add(vec3);
            c1096tvM4089a.m6093a(abstractC0858pW);
            c1096tvM4089a.m6088dm();
            C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
            MinecraftServer minecraftServerM2335a2 = C0529jL.m2335a();
            if (minecraftServerM2335a2 != null) {
                C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a2.overworld(), null);
            }
        }
    }
}
