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

/* JADX INFO: renamed from: com.boehmod.blockfront.vI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vI.class */
public final class C1163vI extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: g */
    private final byte[] f6343g;

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final CustomPacketPayload.Type<C1163vI> f6344m = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_create_map_effect"));

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1163vI> f6345n = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6623d(v1);
    }, C1163vI::new);

    public C1163vI(byte[] bArr) {
        this.f6343g = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1163vI.class), C1163vI.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vI;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1163vI.class), C1163vI.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vI;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1163vI.class, Object.class), C1163vI.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vI;->g:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6625d() {
        return this.f6343g;
    }

    public C1163vI(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6623d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f6343g);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6344m;
    }

    /* JADX INFO: renamed from: a */
    public static void m6624a(C1163vI c1163vI, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            Item item2 = (Item) C1308xv.f7695A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null) {
                return;
            }
            C1096tv c1096tvM4089a = abstractC0863pbM2353a.m4089a();
            AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0859pX.f4606d.decode(Unpooled.wrappedBuffer(c1163vI.f6343g));
            abstractC0858pW.f4592y = UUID.randomUUID();
            c1096tvM4089a.m6093a(abstractC0858pW);
            c1096tvM4089a.m6088dm();
            C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (minecraftServerM2335a != null) {
                C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
            }
        }
    }
}
