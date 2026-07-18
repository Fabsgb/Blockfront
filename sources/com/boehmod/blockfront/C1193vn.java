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

/* JADX INFO: renamed from: com.boehmod.blockfront.vn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vn.class */
public final class C1193vn extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: I */
    @NotNull
    private final UUID f6276I;

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final CustomPacketPayload.Type<C1193vn> f6277r = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_delete_map_effect"));

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1193vn> f6278s = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6645d(v1);
    }, C1193vn::new);

    public C1193vn(@NotNull UUID uuid) {
        this.f6276I = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1193vn.class), C1193vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1193vn.class), C1193vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1193vn.class, Object.class), C1193vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6647l() {
        return this.f6276I;
    }

    public C1193vn(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    /* JADX INFO: renamed from: d */
    public void m6645d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6276I.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6276I.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6277r;
    }

    /* JADX INFO: renamed from: a */
    public static void m6646a(C1193vn c1193vn, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C1018sY c1018sYM3653a;
        AbstractC0835pA abstractC0835pAM5608a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (abstractC0835pAM5608a = (c1018sYM3653a = abstractC0787oFM2530a.m3653a()).m5608a(c1193vn.f6276I)) == null) {
                return;
            }
            if (c1018sYM3653a.m5612p(c1193vn.f6276I)) {
                C0605kj c0605kjM5613a = c1018sYM3653a.m5613a(c1193vn.f6276I);
                if (c0605kjM5613a != null) {
                    c1018sYM3653a.m5615b(c0605kjM5613a);
                    C0531jO c0531jOM2372c = C0531jO.m2372c();
                    RunnableC0527jK runnableC0527jKM2373a = c0531jOM2372c.m2373a();
                    if (runnableC0527jKM2373a != null) {
                        runnableC0527jKM2373a.m2332i(abstractC0787oFM2530a.m3591a().getName() + ".json");
                    }
                    C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C1017sX.class);
                    if (c0529jMM2375a != null) {
                        c0529jMM2375a.m2351j(abstractC0787oFM2530a.m3591a().getName());
                    }
                }
            } else {
                c1018sYM3653a.m5609b(abstractC0835pAM5608a);
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
