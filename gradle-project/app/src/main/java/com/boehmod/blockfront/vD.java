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
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vD.class */
public final class vD extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID M;

    @NotNull
    private final Vec3 aA;

    @NotNull
    public static final CustomPacketPayload.Type<vD> G = new CustomPacketPayload.Type<>(C0265jv.d("packet_move_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vD> H = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vD::new);

    public vD(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.M = uuid;
        this.aA = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vD.class), vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vD.class), vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vD.class, Object.class), vD.class, "mapEffectID;newPosition", "FIELD:Lcom/boehmod/blockfront/vD;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vD;->aA:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID l() {
        return this.M;
    }

    @NotNull
    public Vec3 E() {
        return this.aA;
    }

    public vD(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.M.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.M.getLeastSignificantBits());
        friendlyByteBuf.writeDouble(this.aA.x);
        friendlyByteBuf.writeDouble(this.aA.y);
        friendlyByteBuf.writeDouble(this.aA.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return G;
    }

    public static void a(vD vDVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        sY sYVarM767a;
        pA pAVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (pAVarA = (sYVarM767a = oFVarA.m767a()).a(vDVar.M)) == null) {
                return;
            }
            if (sYVarM767a.p(vDVar.M)) {
                C0280kj c0280kjM1103a = sYVarM767a.m1103a(vDVar.M);
                if (c0280kjM1103a == null) {
                    return;
                }
                jO jOVarC = jO.c();
                jM jMVarA = jOVarC.a(C0279ki.class);
                C0279ki c0279ki = jMVarA != null ? (C0279ki) jMVarA.a(c0280kjM1103a.A()) : null;
                c0280kjM1103a.b(vDVar.aA.subtract(c0279ki != null ? c0279ki.a().c : Vec3.ZERO));
                sYVarM767a.b(jOVarC);
                jK jKVarA = jOVarC.a();
                if (jKVarA != null) {
                    jKVarA.i(oFVarA.m751a().getName() + ".json");
                }
                jM jMVarA2 = jOVarC.a(sX.class);
                if (jMVarA2 != null) {
                    jMVarA2.j(oFVarA.m751a().getName());
                }
            } else {
                pAVarA.c = vDVar.aA;
            }
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
        }
    }
}
