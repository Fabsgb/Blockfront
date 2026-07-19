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

/* JADX INFO: renamed from: com.boehmod.blockfront.vi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vi.class */
public final class C0576vi extends Record implements CustomPacketPayload {
    private final byte[] g;

    @NotNull
    public static final CustomPacketPayload.Type<C0576vi> m = new CustomPacketPayload.Type<>(C0265jv.d("packet_create_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0576vi> n = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0576vi::new);

    public C0576vi(byte[] bArr) {
        this.g = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0576vi.class), C0576vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0576vi.class), C0576vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0576vi.class, Object.class), C0576vi.class, "effectData", "FIELD:Lcom/boehmod/blockfront/vi;->g:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public byte[] d() {
        return this.g;
    }

    public C0576vi(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.g);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return m;
    }

    public static void a(C0576vi c0576vi, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            Item item2 = (Item) wY.A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null) {
                return;
            }
            sY sYVarM767a = oFVarA.m767a();
            pA pAVar = (pA) pB.d.decode(Unpooled.wrappedBuffer(c0576vi.g));
            pAVar.y = UUID.randomUUID();
            sYVarM767a.a(pAVar);
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
        }
    }
}
