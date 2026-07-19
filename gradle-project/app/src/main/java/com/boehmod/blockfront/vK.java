package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vK.class */
public final class vK extends Record implements CustomPacketPayload {

    @NotNull
    private final com.boehmod.blockfront.common.player.f b;

    @NotNull
    public static final CustomPacketPayload.Type<vK> N = new CustomPacketPayload.Type<>(C0265jv.d("packet_region_selection"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vK> O = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vK::new);

    public vK(@NotNull com.boehmod.blockfront.common.player.f fVar) {
        this.b = fVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vK.class), vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vK.class), vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vK.class, Object.class), vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public com.boehmod.blockfront.common.player.f a() {
        return this.b;
    }

    public vK(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(a(friendlyByteBuf));
    }

    @NotNull
    private static com.boehmod.blockfront.common.player.f a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        com.boehmod.blockfront.common.player.f fVar = new com.boehmod.blockfront.common.player.f();
        fVar.f(friendlyByteBuf);
        return fVar;
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.b.d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return N;
    }

    public static void a(@NotNull vK vKVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Item item = (Item) wY.C.get();
            if (((player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item) || vKVar.b.bu()) && (abstractC0264juM166a = C0002a.a().m166a()) != null) {
                abstractC0264juM166a.m531a().m305a(player).m301b().b(vKVar.b);
            }
        }
    }
}
