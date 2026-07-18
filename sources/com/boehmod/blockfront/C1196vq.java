package com.boehmod.blockfront;

import io.netty.buffer.Unpooled;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.vq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vq.class */
public final class C1196vq extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: J */
    @NotNull
    private final UUID f6289J;

    /* JADX INFO: renamed from: h */
    private final byte[] f6290h;

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final CustomPacketPayload.Type<C1196vq> f6291t = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_edit_map_effect"));

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1196vq> f6292u = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6665d(v1);
    }, C1196vq::new);

    public C1196vq(@NotNull UUID uuid, byte[] bArr) {
        this.f6289J = uuid;
        this.f6290h = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1196vq.class), C1196vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1196vq.class), C1196vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1196vq.class, Object.class), C1196vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6667l() {
        return this.f6289J;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6668d() {
        return this.f6290h;
    }

    public C1196vq(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6665d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6289J.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6289J.getLeastSignificantBits());
        friendlyByteBuf.writeByteArray(this.f6290h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6291t;
    }

    /* JADX INFO: renamed from: a */
    public static void m6666a(C1196vq c1196vq, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C1018sY c1018sYM3653a;
        AbstractC0835pA abstractC0835pAM5608a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (abstractC0835pAM5608a = (c1018sYM3653a = abstractC0787oFM2530a.m3653a()).m5608a(c1196vq.f6289J)) == null) {
                return;
            }
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0836pB.f4477d.decode(Unpooled.wrappedBuffer(c1196vq.f6290h));
            abstractC0835pA.f4463y = c1196vq.f6289J;
            abstractC0835pA.f4467gl = abstractC0835pAM5608a.f4467gl;
            c1018sYM3653a.m5610c(abstractC0835pA);
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
            }
        }
    }
}
