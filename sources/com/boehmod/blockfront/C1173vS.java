package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vS.class */
public final class C1173vS extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: L */
    @NotNull
    private final UUID f6381L;

    /* JADX INFO: renamed from: dK */
    @Nullable
    private final String f6382dK;

    /* JADX INFO: renamed from: c */
    private static final Gson f6383c = new Gson();

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final CustomPacketPayload.Type<C1173vS> f6384v = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_edit_template_reference"));

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1173vS> f6385w = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6668d(v1);
    }, C1173vS::new);

    public C1173vS(@NotNull UUID uuid, @Nullable String str) {
        this.f6381L = uuid;
        this.f6382dK = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1173vS.class), C1173vS.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vS;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vS;->dK:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1173vS.class), C1173vS.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vS;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vS;->dK:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1173vS.class, Object.class), C1173vS.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vS;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vS;->dK:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public UUID m6671m() {
        return this.f6381L;
    }

    @Nullable
    /* JADX INFO: renamed from: aF */
    public String m6672aF() {
        return this.f6382dK;
    }

    public C1173vS(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUtf() : null);
    }

    /* JADX INFO: renamed from: d */
    public void m6668d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6381L.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6381L.getLeastSignificantBits());
        friendlyByteBuf.writeBoolean(this.f6382dK != null);
        if (this.f6382dK != null) {
            friendlyByteBuf.writeUtf(this.f6382dK);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6384v;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1173vS m6669a(@NotNull UUID uuid, @Nullable JsonObject jsonObject) {
        return new C1173vS(uuid, jsonObject != null ? f6383c.toJson(jsonObject) : null);
    }

    /* JADX INFO: renamed from: a */
    public static void m6670a(@NotNull C1173vS c1173vS, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        JsonObject jsonObject;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            Item item2 = (Item) C1308xv.f7695A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null) {
                return;
            }
            C1096tv c1096tvM4089a = abstractC0863pbM2353a.m4089a();
            C0576kF c0576kFM6101a = c1096tvM4089a.m6101a(c1173vS.f6381L);
            if (c0576kFM6101a == null) {
                C0530jM.m2337a("[PacketEditTemplateReference] No template reference found for UUID %s.", c1173vS.f6381L);
                return;
            }
            if (c1173vS.f6382dK != null) {
                jsonObject = (JsonObject) f6383c.fromJson(c1173vS.f6382dK, JsonObject.class);
            } else {
                jsonObject = null;
            }
            c0576kFM6101a.m2608c(jsonObject);
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
            }
        }
    }
}
