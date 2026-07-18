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

/* JADX INFO: renamed from: com.boehmod.blockfront.vP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vP.class */
public final class C1169vP extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: S */
    @NotNull
    private final UUID f6177S;

    /* JADX INFO: renamed from: nU */
    private final float f6178nU;

    /* JADX INFO: renamed from: nV */
    private final float f6179nV;

    /* JADX INFO: renamed from: nW */
    private final float f6180nW;

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final CustomPacketPayload.Type<C1169vP> f6181S = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_rotate_map_effect"));

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1169vP> f6182T = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6545d(v1);
    }, C1169vP::new);

    public C1169vP(@NotNull UUID uuid, float f, float f2, float f3) {
        this.f6177S = uuid;
        this.f6178nU = f;
        this.f6179nV = f2;
        this.f6180nW = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1169vP.class), C1169vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1169vP.class), C1169vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1169vP.class, Object.class), C1169vP.class, "mapEffectID;rotationX;rotationY;rotationZ", "FIELD:Lcom/boehmod/blockfront/vP;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vP;->nU:F", "FIELD:Lcom/boehmod/blockfront/vP;->nV:F", "FIELD:Lcom/boehmod/blockfront/vP;->nW:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6547l() {
        return this.f6177S;
    }

    /* JADX INFO: renamed from: bR */
    public float m6548bR() {
        return this.f6178nU;
    }

    /* JADX INFO: renamed from: bS */
    public float m6549bS() {
        return this.f6179nV;
    }

    /* JADX INFO: renamed from: bT */
    public float m6550bT() {
        return this.f6180nW;
    }

    public C1169vP(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6545d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6177S.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6177S.getLeastSignificantBits());
        friendlyByteBuf.writeFloat(this.f6178nU);
        friendlyByteBuf.writeFloat(this.f6179nV);
        friendlyByteBuf.writeFloat(this.f6180nW);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6181S;
    }

    /* JADX INFO: renamed from: a */
    public static void m6546a(C1169vP c1169vP, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7131B.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null) {
                return;
            }
            C1018sY c1018sYM3653a = abstractC0787oFM2530a.m3653a();
            Object objM5608a = c1018sYM3653a.m5608a(c1169vP.f6177S);
            if (objM5608a instanceof InterfaceC0844pJ) {
                ((InterfaceC0844pJ) objM5608a).mo4274a(c1169vP.f6178nU, c1169vP.f6179nV, c1169vP.f6180nW);
                c1018sYM3653a.m5600da();
                C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
                MinecraftServer minecraftServerM2514a = C0561js.m2514a();
                if (minecraftServerM2514a != null) {
                    C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
                }
            }
        }
    }
}
