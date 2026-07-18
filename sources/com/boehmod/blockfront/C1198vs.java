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

/* JADX INFO: renamed from: com.boehmod.blockfront.vs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vs.class */
public final class C1198vs extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: K */
    @NotNull
    private final UUID f6297K;

    /* JADX INFO: renamed from: dz */
    @Nullable
    private final String f6298dz;

    /* JADX INFO: renamed from: c */
    private static final Gson f6299c = new Gson();

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final CustomPacketPayload.Type<C1198vs> f6300v = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_edit_template_reference"));

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1198vs> f6301w = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6673d(v1);
    }, C1198vs::new);

    public C1198vs(@NotNull UUID uuid, @Nullable String str) {
        this.f6297K = uuid;
        this.f6298dz = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1198vs.class), C1198vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1198vs.class), C1198vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1198vs.class, Object.class), C1198vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public UUID m6676m() {
        return this.f6297K;
    }

    @Nullable
    /* JADX INFO: renamed from: ay */
    public String m6677ay() {
        return this.f6298dz;
    }

    public C1198vs(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUtf() : null);
    }

    /* JADX INFO: renamed from: d */
    public void m6673d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6297K.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6297K.getLeastSignificantBits());
        friendlyByteBuf.writeBoolean(this.f6298dz != null);
        if (this.f6298dz != null) {
            friendlyByteBuf.writeUtf(this.f6298dz);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6300v;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1198vs m6674a(@NotNull UUID uuid, @Nullable JsonObject jsonObject) {
        return new C1198vs(uuid, jsonObject != null ? f6299c.toJson(jsonObject) : null);
    }

    /* JADX INFO: renamed from: a */
    public static void m6675a(@NotNull C1198vs c1198vs, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        JsonObject jsonObject;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            Item item2 = (Item) C1231wY.f7130A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null) {
                return;
            }
            C1018sY c1018sYM3653a = abstractC0787oFM2530a.m3653a();
            C0605kj c0605kjM5613a = c1018sYM3653a.m5613a(c1198vs.f6297K);
            if (c0605kjM5613a == null) {
                C0562jt.m2515a("[PacketEditTemplateReference] No template reference found for UUID %s.", c1198vs.f6297K);
                return;
            }
            if (c1198vs.f6298dz != null) {
                jsonObject = (JsonObject) f6299c.fromJson(c1198vs.f6298dz, JsonObject.class);
            } else {
                jsonObject = null;
            }
            c0605kjM5613a.m2655c(jsonObject);
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
            }
        }
    }
}
