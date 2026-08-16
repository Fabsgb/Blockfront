package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xb.class */
public final class C1288xb extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Item f6924c;

    /* JADX INFO: renamed from: aE */
    @NotNull
    public static final CustomPacketPayload.Type<C1288xb> f6925aE;

    /* JADX INFO: renamed from: aF */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1288xb> f6926aF;

    /* JADX INFO: renamed from: jH */
    static final /* synthetic */ boolean f6927jH;

    public C1288xb(@NotNull Item item) {
        this.f6924c = item;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1288xb.class), C1288xb.class, "item", "FIELD:Lcom/boehmod/blockfront/xb;->c:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1288xb.class), C1288xb.class, "item", "FIELD:Lcom/boehmod/blockfront/xb;->c:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1288xb.class, Object.class), C1288xb.class, "item", "FIELD:Lcom/boehmod/blockfront/xb;->c:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Item m7319c() {
        return this.f6924c;
    }

    static {
        f6927jH = !C1288xb.class.desiredAssertionStatus();
        f6925aE = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_gun_store_buy"));
        f6926aF = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7317g(v1);
        }, C1288xb::new);
    }

    public C1288xb(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1272xL.m7220f(registryFriendlyByteBuf.readUtf()).get());
    }

    /* JADX INFO: renamed from: g */
    public void m7317g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(C1272xL.m7219a(this.f6924c));
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6925aE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r0 = (com.boehmod.blockfront.InterfaceC0985rr) r0;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m7318a(com.boehmod.blockfront.C1288xb r4, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.network.handling.IPayloadContext r5) {
        /*
            com.boehmod.blockfront.a r0 = com.boehmod.blockfront.C0030a.m175a()
            com.boehmod.blockfront.jN r0 = r0.m179a()
            r6 = r0
            boolean r0 = com.boehmod.blockfront.C1288xb.f6927jH
            if (r0 != 0) goto L1b
            r0 = r6
            if (r0 != 0) goto L1b
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            java.lang.String r2 = "Manager is null"
            r1.<init>(r2)
            throw r0
        L1b:
            r0 = r5
            net.minecraft.world.entity.player.Player r0 = r0.player()
            r8 = r0
            r0 = r8
            boolean r0 = r0 instanceof net.minecraft.server.level.ServerPlayer
            if (r0 == 0) goto L34
            r0 = r8
            net.minecraft.server.level.ServerPlayer r0 = (net.minecraft.server.level.ServerPlayer) r0
            r7 = r0
            goto L35
        L34:
            return
        L35:
            r0 = r7
            java.util.UUID r0 = r0.getUUID()
            r8 = r0
            r0 = r6
            r1 = r8
            com.boehmod.blockfront.pb r0 = r0.mo2354a(r1)
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof com.boehmod.blockfront.InterfaceC0985rr
            if (r0 == 0) goto L55
            r0 = r9
            com.boehmod.blockfront.rr r0 = (com.boehmod.blockfront.InterfaceC0985rr) r0
            r10 = r0
            goto L56
        L55:
            return
        L56:
            r0 = r10
            r1 = r7
            r2 = r4
            net.minecraft.world.item.Item r2 = r2.f6924c
            com.boehmod.blockfront.py r0 = r0.mo5559a(r1, r2)
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L73
            r0 = r10
            r1 = r7
            r2 = r11
            r0.mo5558a(r1, r2)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C1288xb.m7318a(com.boehmod.blockfront.xb, net.neoforged.neoforge.network.handling.IPayloadContext):void");
    }
}
