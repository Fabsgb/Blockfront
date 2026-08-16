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
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vN.class */
public final class C1168vN extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: J */
    @NotNull
    private final UUID f6360J;

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final CustomPacketPayload.Type<C1168vN> f6361r = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_delete_map_effect"));

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1168vN> f6362s = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6640d(v1);
    }, C1168vN::new);

    public C1168vN(@NotNull UUID uuid) {
        this.f6360J = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1168vN.class), C1168vN.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vN;->J:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1168vN.class), C1168vN.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vN;->J:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1168vN.class, Object.class), C1168vN.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vN;->J:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6642l() {
        return this.f6360J;
    }

    public C1168vN(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    /* JADX INFO: renamed from: d */
    public void m6640d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6360J.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6360J.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6361r;
    }

    /* JADX INFO: renamed from: a */
    public static void m6641a(C1168vN c1168vN, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C1096tv c1096tvM4089a;
        AbstractC0858pW abstractC0858pWM6096a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (abstractC0858pWM6096a = (c1096tvM4089a = abstractC0863pbM2353a.m4089a()).m6096a(c1168vN.f6360J)) == null) {
                return;
            }
            if (c1096tvM4089a.m6100p(c1168vN.f6360J)) {
                C0576kF c0576kFM6101a = c1096tvM4089a.m6101a(c1168vN.f6360J);
                if (c0576kFM6101a != null) {
                    c1096tvM4089a.m6103b(c0576kFM6101a);
                    C0607kk c0607kkM2734c = C0607kk.m2734c();
                    RunnableC0603kg runnableC0603kgM2735a = c0607kkM2734c.m2735a();
                    if (runnableC0603kgM2735a != null) {
                        runnableC0603kgM2735a.m2692i(abstractC0863pbM2353a.m4027a().getName() + ".json");
                    }
                    C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C1095tu.class);
                    if (c0605kiM2737a != null) {
                        c0605kiM2737a.m2713j(abstractC0863pbM2353a.m4027a().getName());
                    }
                }
            } else {
                c1096tvM4089a.m6097b(abstractC0858pWM6096a);
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
