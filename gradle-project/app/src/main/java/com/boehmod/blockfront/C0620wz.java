package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wz.class */
public final class C0620wz extends Record implements CustomPacketPayload {
    private final float oh;

    @NotNull
    public static final CustomPacketPayload.Type<C0620wz> aC = new CustomPacketPayload.Type<>(C0265jv.d("packet_grenade_throw"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0620wz> aD = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0620wz::new);

    public C0620wz(float f) {
        this.oh = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0620wz.class), C0620wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0620wz.class), C0620wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0620wz.class, Object.class), C0620wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float bZ() {
        return this.oh;
    }

    public C0620wz(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.oh);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aC;
    }

    public static void a(C0620wz c0620wz, @NotNull IPayloadContext iPayloadContext) {
        nD nDVarA;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a(entity)) != null && nDVarA.fr) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C0550uj) {
                C0550uj c0550uj = (C0550uj) item;
                com.boehmod.blockfront.common.player.c<?> cVarM531a = C0002a.a().m166a().m531a();
                int iClamp = 0;
                com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) entity);
                if (bVarM305a instanceof xO) {
                    xN xNVarM1677a = ((xO) bVarM305a).m1677a();
                    if (xNVarM1677a.J() && xNVarM1677a.a() == c0550uj) {
                        iClamp = Mth.clamp(xNVarM1677a.a(entity.level().getGameTime()), 0, c0550uj.ab());
                    }
                    xNVarM1677a.e();
                }
                c0550uj.a(cVarM531a, mainHandItem, entity.level(), (ServerPlayer) entity, Math.min(c0620wz.oh, 2.0f), iClamp);
                C0582vo.a((CustomPacketPayload) new vT(hH.y), (ServerPlayer) entity);
            }
        }
    }
}
