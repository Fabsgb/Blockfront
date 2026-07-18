package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wz.class */
public final class C1258wz extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: oh */
    private final float f7442oh;

    /* JADX INFO: renamed from: aC */
    @NotNull
    public static final CustomPacketPayload.Type<C1258wz> f7443aC = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_grenade_throw"));

    /* JADX INFO: renamed from: aD */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1258wz> f7444aD = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7735d(v1);
    }, C1258wz::new);

    public C1258wz(float f) {
        this.f7442oh = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1258wz.class), C1258wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1258wz.class), C1258wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1258wz.class, Object.class), C1258wz.class, "force", "FIELD:Lcom/boehmod/blockfront/wz;->oh:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bZ */
    public float m7737bZ() {
        return this.f7442oh;
    }

    public C1258wz(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7735d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f7442oh);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7443aC;
    }

    /* JADX INFO: renamed from: a */
    public static void m7736a(C1258wz c1258wz, @NotNull IPayloadContext iPayloadContext) {
        C0732nD c0732nDM3535a;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a(entity)) != null && c0732nDM3535a.f3938fr) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1136uj) {
                C1136uj c1136uj = (C1136uj) item;
                AbstractC0183c<?> abstractC0183cM2528a = C0029a.m164a().m168a().m2528a();
                int iClamp = 0;
                AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) entity);
                if (abstractC0182bM1136a instanceof C1274xO) {
                    C1273xN c1273xNM7786a = ((C1274xO) abstractC0182bM1136a).m7786a();
                    if (c1273xNM7786a.m7777J() && c1273xNM7786a.m7778a() == c1136uj) {
                        iClamp = Mth.clamp(c1273xNM7786a.m7779a(entity.level().getGameTime()), 0, c1136uj.mo6250ab());
                    }
                    c1273xNM7786a.m7780e();
                }
                c1136uj.m6263a(abstractC0183cM2528a, mainHandItem, entity.level(), (ServerPlayer) entity, Math.min(c1258wz.f7442oh, 2.0f), iClamp);
                C1194vo.m6648a((CustomPacketPayload) new C1173vT(C0418hH.f2682y), (ServerPlayer) entity);
            }
        }
    }
}
