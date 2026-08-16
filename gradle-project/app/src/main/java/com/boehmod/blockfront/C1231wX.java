package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wX.class */
public final class C1231wX extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: pf */
    private final float f6679pf;

    /* JADX INFO: renamed from: aA */
    @NotNull
    public static final CustomPacketPayload.Type<C1231wX> f6680aA = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_grenade_throw"));

    /* JADX INFO: renamed from: aB */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1231wX> f6681aB = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7003d(v1);
    }, C1231wX::new);

    public C1231wX(float f) {
        this.f6679pf = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1231wX.class), C1231wX.class, "force", "FIELD:Lcom/boehmod/blockfront/wX;->pf:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1231wX.class), C1231wX.class, "force", "FIELD:Lcom/boehmod/blockfront/wX;->pf:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1231wX.class, Object.class), C1231wX.class, "force", "FIELD:Lcom/boehmod/blockfront/wX;->pf:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cf */
    public float m7005cf() {
        return this.f6679pf;
    }

    public C1231wX(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7003d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f6679pf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6680aA;
    }

    /* JADX INFO: renamed from: a */
    public static void m7004a(C1231wX c1231wX, @NotNull IPayloadContext iPayloadContext) {
        C0755nZ c0755nZM3472a;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0750nU) && (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a(entity)) != null && c0755nZM3472a.f4186fL) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1109uH) {
                C1109uH c1109uH = (C1109uH) item;
                AbstractC0184c<?> abstractC0184cM2351a = C0030a.m175a().m179a().m2351a();
                int iClamp = 0;
                AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) entity);
                if (abstractC0183bM1153a instanceof C1326ym) {
                    C1325yl c1325ylM8302a = ((C1326ym) abstractC0183bM1153a).m8302a();
                    if (c1325ylM8302a.m8293K() && c1325ylM8302a.m8294a() == c1109uH) {
                        iClamp = Mth.clamp(c1325ylM8302a.m8295b(entity.level().getGameTime()), 0, c1109uH.mo6210al());
                    }
                    c1325ylM8302a.m8296e();
                }
                c1109uH.m6224a(abstractC0184cM2351a, mainHandItem, entity.level(), (ServerPlayer) entity, Math.min(c1231wX.f6679pf, 2.0f), iClamp);
                C1169vO.m6643a((CustomPacketPayload) new C1253wt(C0435hX.f2775y), (ServerPlayer) entity);
            }
        }
    }
}
