package com.boehmod.blockfront;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.vg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vg.class */
public final class C1186vg extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: G */
    @NotNull
    private final UUID f6252G;

    /* JADX INFO: renamed from: dv */
    @NotNull
    private final String f6253dv;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final CustomPacketPayload.Type<C1186vg> f6254k = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_convert_to_template"));

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1186vg> f6255l = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6619d(v1);
    }, C1186vg::new);

    public C1186vg(@NotNull UUID uuid, @NotNull String str) {
        this.f6252G = uuid;
        this.f6253dv = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1186vg.class), C1186vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1186vg.class), C1186vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1186vg.class, Object.class), C1186vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public UUID m6621k() {
        return this.f6252G;
    }

    @NotNull
    /* JADX INFO: renamed from: B */
    public String m6622B() {
        return this.f6253dv;
    }

    public C1186vg(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
    }

    /* JADX INFO: renamed from: d */
    public void m6619d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6252G.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6252G.getLeastSignificantBits());
        friendlyByteBuf.writeUtf(this.f6253dv);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6254k;
    }

    /* JADX INFO: renamed from: a */
    public static void m6620a(@NotNull C1186vg c1186vg, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C1018sY c1018sYM3653a;
        AbstractC0835pA abstractC0835pAM5608a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            Item item2 = (Item) C1231wY.f7130A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (abstractC0835pAM5608a = (c1018sYM3653a = abstractC0787oFM2530a.m3653a()).m5608a(c1186vg.f6252G)) == null || c1018sYM3653a.m5612p(c1186vg.f6252G)) {
                return;
            }
            Vec3 vec3 = abstractC0835pAM5608a.f4464c;
            DataResult dataResultEncodeStart = C0836pB.f4476H.encodeStart(JsonOps.INSTANCE, abstractC0835pAM5608a);
            if (dataResultEncodeStart.isError()) {
                C0562jt.m2515a("[PacketConvertToTemplate] Failed to encode effect %s: %s", c1186vg.f6252G, dataResultEncodeStart.error().map(error -> {
                    return error.message();
                }).orElse("unknown"));
                return;
            }
            JsonObject jsonObjectDeepCopy = ((JsonElement) dataResultEncodeStart.getOrThrow()).getAsJsonObject().deepCopy();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("x", Double.valueOf(0.0d));
            jsonObject.addProperty("y", Double.valueOf(0.0d));
            jsonObject.addProperty("z", Double.valueOf(0.0d));
            jsonObjectDeepCopy.add("position", jsonObject);
            DataResult dataResult = C0836pB.f4476H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
            if (dataResult.isError()) {
                C0562jt.m2515a("[PacketConvertToTemplate] Failed to re-parse zeroed effect: %s", dataResult.error().map(error2 -> {
                    return error2.message();
                }).orElse("unknown"));
                return;
            }
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) dataResult.getOrThrow();
            C0531jO c0531jOM2372c = C0531jO.m2372c();
            C0529jM c0529jMM2375a = c0531jOM2372c.m2375a(C0604ki.class);
            if (c0529jMM2375a == null) {
                return;
            }
            c0529jMM2375a.m2352c(c1186vg.f6253dv, new C0604ki(abstractC0835pA));
            c1018sYM3653a.m5609b(abstractC0835pAM5608a);
            c1018sYM3653a.m5614a(new C0605kj(c1186vg.f6253dv, vec3));
            c1018sYM3653a.m5611b(c0531jOM2372c);
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
            }
            C0529jM c0529jMM2375a2 = c0531jOM2372c.m2375a(C1017sX.class);
            if (c0529jMM2375a2 != null) {
                c0529jMM2375a2.m2351j(abstractC0787oFM2530a.m3591a().getName());
            }
        }
    }
}
