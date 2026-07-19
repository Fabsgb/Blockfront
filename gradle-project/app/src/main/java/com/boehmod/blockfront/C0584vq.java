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

/* JADX INFO: renamed from: com.boehmod.blockfront.vq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vq.class */
public final class C0584vq extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID J;
    private final byte[] h;

    @NotNull
    public static final CustomPacketPayload.Type<C0584vq> t = new CustomPacketPayload.Type<>(C0265jv.d("packet_edit_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0584vq> u = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0584vq::new);

    public C0584vq(@NotNull UUID uuid, byte[] bArr) {
        this.J = uuid;
        this.h = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0584vq.class), C0584vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0584vq.class), C0584vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0584vq.class, Object.class), C0584vq.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vq;->J:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vq;->h:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID l() {
        return this.J;
    }

    public byte[] d() {
        return this.h;
    }

    public C0584vq(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.J.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.J.getLeastSignificantBits());
        friendlyByteBuf.writeByteArray(this.h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return t;
    }

    public static void a(C0584vq c0584vq, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        sY sYVarM767a;
        pA pAVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (pAVarA = (sYVarM767a = oFVarA.m767a()).a(c0584vq.J)) == null) {
                return;
            }
            pA pAVar = (pA) pB.d.decode(Unpooled.wrappedBuffer(c0584vq.h));
            pAVar.y = c0584vq.J;
            pAVar.gl = pAVarA.gl;
            sYVarM767a.c(pAVar);
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
        }
    }
}
