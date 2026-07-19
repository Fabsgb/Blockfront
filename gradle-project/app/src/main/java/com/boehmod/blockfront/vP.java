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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vP.class */
public final class vP extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID S;
    private final float nU;
    private final float nV;
    private final float nW;

    /* JADX INFO: renamed from: S, reason: collision with other field name */
    @NotNull
    public static final CustomPacketPayload.Type<vP> f323S = new CustomPacketPayload.Type<>(C0265jv.d("packet_rotate_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vP> T = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vP::new);

    public vP(@NotNull UUID uuid, float f, float f2, float f3) {
        this.S = uuid;
        this.nU = f;
        this.nV = f2;
        this.nW = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vP.class), vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vP.class), vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vP.class, Object.class), vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID l() {
        return this.S;
    }

    public float bR() {
        return this.nU;
    }

    public float bS() {
        return this.nV;
    }

    public float bT() {
        return this.nW;
    }

    public vP(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.S.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.S.getLeastSignificantBits());
        friendlyByteBuf.writeFloat(this.nU);
        friendlyByteBuf.writeFloat(this.nV);
        friendlyByteBuf.writeFloat(this.nW);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f323S;
    }

    public static void a(vP vPVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.B.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null) {
                return;
            }
            sY sYVarM767a = oFVarA.m767a();
            Object objA = sYVarM767a.a(vPVar.S);
            if (objA instanceof pJ) {
                ((pJ) objA).a(vPVar.nU, vPVar.nV, vPVar.nW);
                sYVarM767a.da();
                C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
                MinecraftServer minecraftServerA = C0262js.a();
                if (minecraftServerA != null) {
                    jN.a(oFVarA, minecraftServerA.overworld(), null);
                }
            }
        }
    }
}
