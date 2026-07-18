package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wm.class */
public final class C1245wm extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sP */
    private final int f7387sP;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0386gc f7388b;

    /* JADX INFO: renamed from: ap */
    @NotNull
    public static final CustomPacketPayload.Type<C1245wm> f7389ap = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_tracer_to_client"));

    /* JADX INFO: renamed from: aq */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1245wm> f7390aq = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7683g(v1);
    }, C1245wm::new);

    public C1245wm(int i, @NotNull C0386gc c0386gc) {
        this.f7387sP = i;
        this.f7388b = c0386gc;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1245wm.class), C1245wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1245wm.class), C1245wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1245wm.class, Object.class), C1245wm.class, "entityId;bulletTracer", "FIELD:Lcom/boehmod/blockfront/wm;->sP:I", "FIELD:Lcom/boehmod/blockfront/wm;->b:Lcom/boehmod/blockfront/gc;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: al */
    public int m7685al() {
        return this.f7387sP;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0386gc m7686b() {
        return this.f7388b;
    }

    public C1245wm(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readInt(), C0386gc.m1848a(registryFriendlyByteBuf));
    }

    /* JADX INFO: renamed from: g */
    public void m7683g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.f7387sP);
        this.f7388b.m1854a(registryFriendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7389ap;
    }

    /* JADX INFO: renamed from: b */
    public static void m7684b(C1245wm c1245wm, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2941a(c1245wm, iPayloadContext);
    }
}
