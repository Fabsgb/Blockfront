package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wE.class */
public final class wE extends Record implements CustomPacketPayload {

    @NotNull
    private final Item d;

    @NotNull
    public static final CustomPacketPayload.Type<wE> aH;

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, wE> aI;
    static final /* synthetic */ boolean jq;

    public wE(@NotNull Item item) {
        this.d = item;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, wE.class), wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, wE.class), wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, wE.class, Object.class), wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Item c() {
        return this.d;
    }

    static {
        jq = !wE.class.desiredAssertionStatus();
        aH = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_store_buy"));
        aI = CustomPacketPayload.codec((v0, v1) -> {
            v0.g(v1);
        }, wE::new);
    }

    public wE(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0636xo.f(registryFriendlyByteBuf.readUtf()).get());
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(C0636xo.a(this.d));
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aH;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r0 = (com.boehmod.blockfront.qU) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.boehmod.blockfront.wE r4, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.network.handling.IPayloadContext r5) {
        /*
            com.boehmod.blockfront.a r0 = com.boehmod.blockfront.C0002a.a()
            com.boehmod.blockfront.ju r0 = r0.m166a()
            r6 = r0
            boolean r0 = com.boehmod.blockfront.wE.jq
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
            com.boehmod.blockfront.oF r0 = r0.mo604a(r1)
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof com.boehmod.blockfront.qU
            if (r0 == 0) goto L55
            r0 = r9
            com.boehmod.blockfront.qU r0 = (com.boehmod.blockfront.qU) r0
            r10 = r0
            goto L56
        L55:
            return
        L56:
            r0 = r10
            r1 = r7
            r2 = r4
            net.minecraft.world.item.Item r2 = r2.d
            com.boehmod.blockfront.pc r0 = r0.a(r1, r2)
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L73
            r0 = r10
            r1 = r7
            r2 = r11
            r0.a(r1, r2)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.wE.a(com.boehmod.blockfront.wE, net.neoforged.neoforge.network.handling.IPayloadContext):void");
    }
}
