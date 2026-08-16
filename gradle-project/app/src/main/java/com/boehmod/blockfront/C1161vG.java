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

/* JADX INFO: renamed from: com.boehmod.blockfront.vG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vG.class */
public final class C1161vG extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: H */
    @NotNull
    private final UUID f6336H;

    /* JADX INFO: renamed from: dG */
    @NotNull
    private final String f6337dG;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final CustomPacketPayload.Type<C1161vG> f6338k = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_convert_to_template"));

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1161vG> f6339l = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6614d(v1);
    }, C1161vG::new);

    public C1161vG(@NotNull UUID uuid, @NotNull String str) {
        this.f6336H = uuid;
        this.f6337dG = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1161vG.class), C1161vG.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vG;->H:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vG;->dG:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1161vG.class), C1161vG.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vG;->H:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vG;->dG:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1161vG.class, Object.class), C1161vG.class, "effectUUID;templateName", "FIELD:Lcom/boehmod/blockfront/vG;->H:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vG;->dG:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public UUID m6616k() {
        return this.f6336H;
    }

    @NotNull
    /* JADX INFO: renamed from: I */
    public String m6617I() {
        return this.f6337dG;
    }

    public C1161vG(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
    }

    /* JADX INFO: renamed from: d */
    public void m6614d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6336H.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6336H.getLeastSignificantBits());
        friendlyByteBuf.writeUtf(this.f6337dG);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6338k;
    }

    /* JADX INFO: renamed from: a */
    public static void m6615a(@NotNull C1161vG c1161vG, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C1096tv c1096tvM4089a;
        AbstractC0858pW abstractC0858pWM6096a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            Item item2 = (Item) C1308xv.f7695A.get();
            if (mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) {
                if (!C0605ki.m2710m(c1161vG.f6337dG)) {
                    C0530jM.m2337a("[PacketConvertToTemplate] Rejected unsafe template name '%s' from player '%s'.", c1161vG.f6337dG, player.getUUID());
                    return;
                }
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (abstractC0531jNM179a == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (abstractC0858pWM6096a = (c1096tvM4089a = abstractC0863pbM2353a.m4089a()).m6096a(c1161vG.f6336H)) == null || c1096tvM4089a.m6100p(c1161vG.f6336H)) {
                    return;
                }
                Vec3 vec3 = abstractC0858pWM6096a.f4593c;
                DataResult dataResultEncodeStart = C0859pX.f4605H.encodeStart(JsonOps.INSTANCE, abstractC0858pWM6096a);
                if (dataResultEncodeStart.isError()) {
                    C0530jM.m2337a("[PacketConvertToTemplate] Failed to encode effect %s: %s", c1161vG.f6336H, dataResultEncodeStart.error().map(error -> {
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
                DataResult dataResult = C0859pX.f4605H.parse(JsonOps.INSTANCE, jsonObjectDeepCopy);
                if (dataResult.isError()) {
                    C0530jM.m2337a("[PacketConvertToTemplate] Failed to re-parse zeroed effect: %s", dataResult.error().map(error2 -> {
                        return error2.message();
                    }).orElse("unknown"));
                    return;
                }
                AbstractC0858pW abstractC0858pW = (AbstractC0858pW) dataResult.getOrThrow();
                C0607kk c0607kkM2734c = C0607kk.m2734c();
                C0605ki c0605kiM2737a = c0607kkM2734c.m2737a(C0575kE.class);
                if (c0605kiM2737a == null) {
                    return;
                }
                c0605kiM2737a.m2714c(c1161vG.f6337dG, new C0575kE(abstractC0858pW));
                c1096tvM4089a.m6097b(abstractC0858pWM6096a);
                c1096tvM4089a.m6102a(new C0576kF(c1161vG.f6337dG, vec3));
                c1096tvM4089a.m6099b(c0607kkM2734c);
                c1096tvM4089a.m6088dm();
                C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
                MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
                if (minecraftServerM2335a != null) {
                    C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
                }
                C0605ki c0605kiM2737a2 = c0607kkM2734c.m2737a(C1095tu.class);
                if (c0605kiM2737a2 != null) {
                    c0605kiM2737a2.m2713j(abstractC0863pbM2353a.m4027a().getName());
                }
            }
        }
    }
}
