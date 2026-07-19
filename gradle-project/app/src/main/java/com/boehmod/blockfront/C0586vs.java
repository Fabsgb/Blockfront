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

/* JADX INFO: renamed from: com.boehmod.blockfront.vs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vs.class */
public final class C0586vs extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID K;

    @Nullable
    private final String dz;
    private static final Gson c = new Gson();

    @NotNull
    public static final CustomPacketPayload.Type<C0586vs> v = new CustomPacketPayload.Type<>(C0265jv.d("packet_edit_template_reference"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0586vs> w = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0586vs::new);

    public C0586vs(@NotNull UUID uuid, @Nullable String str) {
        this.K = uuid;
        this.dz = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0586vs.class), C0586vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0586vs.class), C0586vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0586vs.class, Object.class), C0586vs.class, "referenceEffectUUID;overridesJson", "FIELD:Lcom/boehmod/blockfront/vs;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vs;->dz:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID m() {
        return this.K;
    }

    @Nullable
    public String ay() {
        return this.dz;
    }

    public C0586vs(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUtf() : null);
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.K.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.K.getLeastSignificantBits());
        friendlyByteBuf.writeBoolean(this.dz != null);
        if (this.dz != null) {
            friendlyByteBuf.writeUtf(this.dz);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return v;
    }

    @NotNull
    public static C0586vs a(@NotNull UUID uuid, @Nullable JsonObject jsonObject) {
        return new C0586vs(uuid, jsonObject != null ? c.toJson(jsonObject) : null);
    }

    public static void a(@NotNull C0586vs c0586vs, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        JsonObject jsonObject;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            Item item2 = (Item) wY.A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null) {
                return;
            }
            sY sYVarM767a = oFVarA.m767a();
            C0280kj c0280kjM1103a = sYVarM767a.m1103a(c0586vs.K);
            if (c0280kjM1103a == null) {
                C0263jt.a("[PacketEditTemplateReference] No template reference found for UUID %s.", c0586vs.K);
                return;
            }
            if (c0586vs.dz != null) {
                jsonObject = (JsonObject) c.fromJson(c0586vs.dz, JsonObject.class);
            } else {
                jsonObject = null;
            }
            c0280kjM1103a.c(jsonObject);
            jO jOVarC = jO.c();
            sYVarM767a.b(jOVarC);
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
            jK jKVarA = jOVarC.a();
            if (jKVarA != null) {
                jKVarA.i(oFVarA.m751a().getName() + ".json");
            }
            jM jMVarA = jOVarC.a(sX.class);
            if (jMVarA != null) {
                jMVarA.j(oFVarA.m751a().getName());
            }
        }
    }
}
