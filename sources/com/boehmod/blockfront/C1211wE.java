package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wE.class */
public final class C1211wE extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Item f6360d;

    /* JADX INFO: renamed from: aH */
    @NotNull
    public static final CustomPacketPayload.Type<C1211wE> f6361aH;

    /* JADX INFO: renamed from: aI */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1211wE> f6362aI;

    /* JADX INFO: renamed from: jq */
    static final /* synthetic */ boolean f6363jq;

    public C1211wE(@NotNull Item item) {
        this.f6360d = item;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1211wE.class), C1211wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1211wE.class), C1211wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1211wE.class, Object.class), C1211wE.class, "item", "FIELD:Lcom/boehmod/blockfront/wE;->d:Lnet/minecraft/world/item/Item;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Item m6731c() {
        return this.f6360d;
    }

    static {
        f6363jq = !C1211wE.class.desiredAssertionStatus();
        f6361aH = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_store_buy"));
        f6362aI = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6729g(v1);
        }, C1211wE::new);
    }

    public C1211wE(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1292xo.m7893f(registryFriendlyByteBuf.readUtf()).get());
    }

    /* JADX INFO: renamed from: g */
    public void m6729g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(C1292xo.m7892a(this.f6360d));
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6361aH;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r0 = (com.boehmod.blockfront.InterfaceC0908qU) r0;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m6730a(com.boehmod.blockfront.C1211wE r4, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.network.handling.IPayloadContext r5) {
        /*
            com.boehmod.blockfront.a r0 = com.boehmod.blockfront.C0029a.m164a()
            com.boehmod.blockfront.ju r0 = r0.m168a()
            r6 = r0
            boolean r0 = com.boehmod.blockfront.C1211wE.f6363jq
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
            com.boehmod.blockfront.oF r0 = r0.mo2531a(r1)
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof com.boehmod.blockfront.InterfaceC0908qU
            if (r0 == 0) goto L55
            r0 = r9
            com.boehmod.blockfront.qU r0 = (com.boehmod.blockfront.InterfaceC0908qU) r0
            r10 = r0
            goto L56
        L55:
            return
        L56:
            r0 = r10
            r1 = r7
            r2 = r4
            net.minecraft.world.item.Item r2 = r2.f6360d
            com.boehmod.blockfront.pc r0 = r0.mo4685a(r1, r2)
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L73
            r0 = r10
            r1 = r7
            r2 = r11
            r0.mo4684a(r1, r2)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C1211wE.m6730a(com.boehmod.blockfront.wE, net.neoforged.neoforge.network.handling.IPayloadContext):void");
    }
}
