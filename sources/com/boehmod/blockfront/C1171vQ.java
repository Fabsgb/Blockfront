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

/* JADX INFO: renamed from: com.boehmod.blockfront.vQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vQ.class */
public final class C1171vQ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: K */
    @NotNull
    private final UUID f6373K;

    /* JADX INFO: renamed from: h */
    private final byte[] f6374h;

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final CustomPacketPayload.Type<C1171vQ> f6375t = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_edit_map_effect"));

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1171vQ> f6376u = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6660d(v1);
    }, C1171vQ::new);

    public C1171vQ(@NotNull UUID uuid, byte[] bArr) {
        this.f6373K = uuid;
        this.f6374h = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1171vQ.class), C1171vQ.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vQ;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vQ;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1171vQ.class), C1171vQ.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vQ;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vQ;->h:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1171vQ.class, Object.class), C1171vQ.class, "mapEffectID;effectData", "FIELD:Lcom/boehmod/blockfront/vQ;->K:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vQ;->h:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public UUID m6662l() {
        return this.f6373K;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6663d() {
        return this.f6374h;
    }

    public C1171vQ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6660d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.f6373K.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.f6373K.getLeastSignificantBits());
        friendlyByteBuf.writeByteArray(this.f6374h);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6375t;
    }

    /* JADX INFO: renamed from: a */
    public static void m6661a(C1171vQ c1171vQ, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C1096tv c1096tvM4089a;
        AbstractC0858pW abstractC0858pWM6096a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (abstractC0858pWM6096a = (c1096tvM4089a = abstractC0863pbM2353a.m4089a()).m6096a(c1171vQ.f6373K)) == null) {
                return;
            }
            AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0859pX.f4606d.decode(Unpooled.wrappedBuffer(c1171vQ.f6374h));
            abstractC0858pW.f4592y = c1171vQ.f6373K;
            abstractC0858pW.f4596gF = abstractC0858pWM6096a.f4596gF;
            c1096tvM4089a.m6098c(abstractC0858pW);
            c1096tvM4089a.m6088dm();
            C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (minecraftServerM2335a != null) {
                C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
            }
        }
    }
}
