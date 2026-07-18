package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.C0186f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.vK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vK.class */
public final class C1164vK extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0186f f6155b;

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final CustomPacketPayload.Type<C1164vK> f6156N = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_region_selection"));

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1164vK> f6157O = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6525d(v1);
    }, C1164vK::new);

    public C1164vK(@NotNull C0186f c0186f) {
        this.f6155b = c0186f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1164vK.class), C1164vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1164vK.class), C1164vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1164vK.class, Object.class), C1164vK.class, "selection", "FIELD:Lcom/boehmod/blockfront/vK;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0186f m6527a() {
        return this.f6155b;
    }

    public C1164vK(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(m6524a(friendlyByteBuf));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0186f m6524a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0186f c0186f = new C0186f();
        c0186f.m1169f(friendlyByteBuf);
        return c0186f;
    }

    /* JADX INFO: renamed from: d */
    public void m6525d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6155b.m1168d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6156N;
    }

    /* JADX INFO: renamed from: a */
    public static void m6526a(@NotNull C1164vK c1164vK, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Item item = (Item) C1231wY.f7132C.get();
            if (((player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item) || c1164vK.f6155b.m1162bu()) && (abstractC0563juM168a = C0029a.m164a().m168a()) != null) {
                abstractC0563juM168a.m2528a().m1136a(player).m1098b().m1167b(c1164vK.f6155b);
            }
        }
    }
}
