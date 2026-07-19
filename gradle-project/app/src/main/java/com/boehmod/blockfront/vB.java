package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vB.class */
public final class vB extends Record implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<vB> E = new CustomPacketPayload.Type<>(C0265jv.d("packet_horn"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vB> F = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vB::new);

    public vB() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vB.class), vB.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vB.class), vB.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vB.class, Object.class), vB.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public vB(FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        r0 = (com.boehmod.blockfront.AbstractC0376ny) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.boehmod.blockfront.vB r5, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.network.handling.IPayloadContext r6) {
        /*
            r0 = r6
            net.minecraft.world.entity.player.Player r0 = r0.player()
            r7 = r0
            r0 = r7
            net.minecraft.world.entity.Entity r0 = r0.getVehicle()
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof com.boehmod.blockfront.AbstractC0376ny
            if (r0 == 0) goto L1e
            r0 = r9
            com.boehmod.blockfront.ny r0 = (com.boehmod.blockfront.AbstractC0376ny) r0
            r8 = r0
            goto L1f
        L1e:
            return
        L1f:
            r0 = r8
            net.minecraft.world.entity.Entity r0 = r0.m743a()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L33
            r0 = r9
            r1 = r7
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
        L33:
            return
        L34:
            r0 = r8
            com.boehmod.blockfront.nP r0 = r0.mo740a()
            r10 = r0
            r0 = r10
            net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.sounds.SoundEvent, net.minecraft.sounds.SoundEvent> r0 = r0.aG
            if (r0 == 0) goto L54
            r0 = r8
            r1 = r10
            net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.sounds.SoundEvent, net.minecraft.sounds.SoundEvent> r1 = r1.aG
            java.lang.Object r1 = r1.get()
            net.minecraft.sounds.SoundEvent r1 = (net.minecraft.sounds.SoundEvent) r1
            r2 = 1075838976(0x40200000, float:2.5)
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.playSound(r1, r2, r3)
        L54:
            r0 = r10
            net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.sounds.SoundEvent, net.minecraft.sounds.SoundEvent> r0 = r0.aH
            if (r0 == 0) goto L6e
            r0 = r8
            r1 = r10
            net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.sounds.SoundEvent, net.minecraft.sounds.SoundEvent> r1 = r1.aH
            java.lang.Object r1 = r1.get()
            net.minecraft.sounds.SoundEvent r1 = (net.minecraft.sounds.SoundEvent) r1
            r2 = 1084227584(0x40a00000, float:5.0)
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.playSound(r1, r2, r3)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.vB.a(com.boehmod.blockfront.vB, net.neoforged.neoforge.network.handling.IPayloadContext):void");
    }
}
