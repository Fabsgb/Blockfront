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

/* JADX INFO: renamed from: com.boehmod.blockfront.wp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wp.class */
public final class C1249wp extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: U */
    @NotNull
    private final UUID f6753U;

    /* JADX INFO: renamed from: oS */
    private final float f6754oS;

    /* JADX INFO: renamed from: oT */
    private final float f6755oT;

    /* JADX INFO: renamed from: oU */
    private final float f6756oU;

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final CustomPacketPayload.Type<C1249wp> f6757S = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_rotate_map_effect"));

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1249wp> f6758T = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7071d(v1);
    }, C1249wp::new);

    public C1249wp(@NotNull UUID uuid, float f, float f2, float f3) {
        this.f6753U = uuid;
        this.f6754oS = f;
        this.f6755oT = f2;
        this.f6756oU = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1249wp.class), C1249wp.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/wp;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wp;->oS:F", "FIELD:Lcom/boehmod/blockfront/wp;->oT:F", "FIELD:Lcom/boehmod/blockfront/wp;->oU:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1249wp.class), C1249wp.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/wp;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wp;->oS:F", "FIELD:Lcom/boehmod/blockfront/wp;->oT:F", "FIELD:Lcom/boehmod/blockfront/wp;->oU:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1249wp.class, Object.class), C1249wp.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/wp;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wp;->oS:F", "FIELD:Lcom/boehmod/blockfront/wp;->oT:F", "FIELD:Lcom/boehmod/blockfront/wp;->oU:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m7073l() {
        return this.f6753U;
    }

    /* JADX INFO: renamed from: bX */
    public float m7074bX() {
        return this.f6754oS;
    }

    /* JADX INFO: renamed from: bY */
    public float m7075bY() {
        return this.f6755oT;
    }

    /* JADX INFO: renamed from: bZ */
    public float m7076bZ() {
        return this.f6756oU;
    }

    public C1249wp(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7071d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6753U.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6753U.getLeastSignificantBits());
        friendlyByteBuf.writeFloat(this.f6754oS);
        friendlyByteBuf.writeFloat(this.f6755oT);
        friendlyByteBuf.writeFloat(this.f6756oU);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6757S;
    }

    /* JADX INFO: renamed from: a */
    public static void m7072a(C1249wp c1249wp, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7696B.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null) {
                return;
            }
            C1096tv c1096tvM4089a = abstractC0863pbM2353a.m4089a();
            Object objM6096a = c1096tvM4089a.m6096a(c1249wp.f6753U);
            if (objM6096a instanceof InterfaceC0920qf) {
                ((InterfaceC0920qf) objM6096a).mo4685a(c1249wp.f6754oS, c1249wp.f6755oT, c1249wp.f6756oU);
                c1096tvM4089a.m6088dm();
                C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
                MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
                if (minecraftServerM2335a != null) {
                    C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
                }
            }
        }
    }
}
