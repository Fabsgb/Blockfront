package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.C0187f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wj.class */
public final class C1243wj extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0187f f6728b;

    /* JADX INFO: renamed from: M */
    @NotNull
    public static final CustomPacketPayload.Type<C1243wj> f6729M = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_region_selection"));

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1243wj> f6730N = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7048d(v1);
    }, C1243wj::new);

    public C1243wj(@NotNull C0187f c0187f) {
        this.f6728b = c0187f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1243wj.class), C1243wj.class, "selection", "FIELD:Lcom/boehmod/blockfront/wj;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1243wj.class), C1243wj.class, "selection", "FIELD:Lcom/boehmod/blockfront/wj;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1243wj.class, Object.class), C1243wj.class, "selection", "FIELD:Lcom/boehmod/blockfront/wj;->b:Lcom/boehmod/blockfront/common/player/f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0187f m7050a() {
        return this.f6728b;
    }

    public C1243wj(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(m7047a(friendlyByteBuf));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0187f m7047a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0187f c0187f = new C0187f();
        c0187f.m1186f(friendlyByteBuf);
        return c0187f;
    }

    /* JADX INFO: renamed from: d */
    public void m7048d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f6728b.m1185d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6729M;
    }

    /* JADX INFO: renamed from: a */
    public static void m7049a(@NotNull C1243wj c1243wj, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Item item = (Item) C1308xv.f7697C.get();
            if (((player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item) || c1243wj.f6728b.m1179bE()) && (abstractC0531jNM179a = C0030a.m175a().m179a()) != null) {
                abstractC0531jNM179a.m2351a().m1153a(player).m1115b().m1184b(c1243wj.f6728b);
            }
        }
    }
}
