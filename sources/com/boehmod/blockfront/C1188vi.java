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

/* JADX INFO: renamed from: com.boehmod.blockfront.vi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vi.class */
public final class C1188vi extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: g */
    private final byte[] f6259g;

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final CustomPacketPayload.Type<C1188vi> f6260m = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_create_map_effect"));

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1188vi> f6261n = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6628d(v1);
    }, C1188vi::new);

    public C1188vi(byte[] bArr) {
        this.f6259g = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1188vi.class), C1188vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1188vi.class), C1188vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1188vi.class, Object.class), C1188vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6630d() {
        return this.f6259g;
    }

    public C1188vi(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6628d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f6259g);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6260m;
    }

    /* JADX INFO: renamed from: a */
    public static void m6629a(C1188vi c1188vi, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            Item item2 = (Item) C1231wY.f7130A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null) {
                return;
            }
            C1018sY c1018sYM3653a = abstractC0787oFM2530a.m3653a();
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0836pB.f4477d.decode(Unpooled.wrappedBuffer(c1188vi.f6259g));
            abstractC0835pA.f4463y = UUID.randomUUID();
            c1018sYM3653a.m5605a(abstractC0835pA);
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
            }
        }
    }
}
