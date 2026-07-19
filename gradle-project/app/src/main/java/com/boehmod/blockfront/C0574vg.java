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

/* JADX INFO: renamed from: com.boehmod.blockfront.vg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vg.class */
public final class C0574vg extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID G;

    @NotNull
    private final String dv;

    @NotNull
    public static final CustomPacketPayload.Type<C0574vg> k = new CustomPacketPayload.Type<>(C0265jv.d("packet_convert_to_template"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0574vg> l = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0574vg::new);

    public C0574vg(@NotNull UUID uuid, @NotNull String str) {
        this.G = uuid;
        this.dv = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0574vg.class), C0574vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0574vg.class), C0574vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0574vg.class, Object.class), C0574vg.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vg;->G:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vg;->dv:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID k() {
        return this.G;
    }

    @NotNull
    public String B() {
        return this.dv;
    }

    public C0574vg(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.G.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.G.getLeastSignificantBits());
        friendlyByteBuf.writeUtf(this.dv);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return k;
    }

    public static void a(@NotNull C0574vg c0574vg, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        sY sYVarM767a;
        pA pAVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            Item item2 = (Item) wY.A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (pAVarA = (sYVarM767a = oFVarA.m767a()).a(c0574vg.G)) == null || sYVarM767a.p(c0574vg.G)) {
                return;
            }
            Vec3 vec3 = pAVarA.c;
            DataResult dataResultEncodeStart = pB.H.encodeStart(JsonOps.INSTANCE, pAVarA);
            if (dataResultEncodeStart.isError()) {
                C0263jt.a("[PacketConvertToTemplate] Failed to encode effect %s: %s", c0574vg.G, dataResultEncodeStart.error().map(error -> {
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
            DataResult dataResult = pB.H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
            if (dataResult.isError()) {
                C0263jt.a("[PacketConvertToTemplate] Failed to re-parse zeroed effect: %s", dataResult.error().map(error2 -> {
                    return error2.message();
                }).orElse("unknown"));
                return;
            }
            pA pAVar = (pA) dataResult.getOrThrow();
            jO jOVarC = jO.c();
            jM jMVarA = jOVarC.a(C0279ki.class);
            if (jMVarA == null) {
                return;
            }
            jMVarA.c(c0574vg.dv, new C0279ki(pAVar));
            sYVarM767a.b(pAVarA);
            sYVarM767a.a(new C0280kj(c0574vg.dv, vec3));
            sYVarM767a.b(jOVarC);
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
            jM jMVarA2 = jOVarC.a(sX.class);
            if (jMVarA2 != null) {
                jMVarA2.j(oFVarA.m751a().getName());
            }
        }
    }
}
