package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wm.class */
public final class C0607wm extends Record implements CustomPacketPayload {
    private final int sP;

    @NotNull
    private final C0166gc b;

    @NotNull
    public static final CustomPacketPayload.Type<C0607wm> ap = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_tracer_to_client"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0607wm> aq = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0607wm::new);

    public C0607wm(int i, @NotNull C0166gc c0166gc) {
        this.sP = i;
        this.b = c0166gc;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0607wm.class), C0607wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0607wm.class), C0607wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0607wm.class, Object.class), C0607wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int al() {
        return this.sP;
    }

    @NotNull
    public C0166gc b() {
        return this.b;
    }

    public C0607wm(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readInt(), C0166gc.a(registryFriendlyByteBuf));
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.sP);
        this.b.m434a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ap;
    }

    public static void b(C0607wm c0607wm, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0607wm, iPayloadContext);
    }
}
