package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wD.class */
public final class C1210wD extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: r */
    @NotNull
    private final ItemStack f6352r;

    /* JADX INFO: renamed from: aI */
    @NotNull
    private final Vec3 f6353aI;

    /* JADX INFO: renamed from: sU */
    private final int f6354sU;

    /* JADX INFO: renamed from: jn */
    private final boolean f6355jn;

    /* JADX INFO: renamed from: jo */
    private final boolean f6356jo;

    /* JADX INFO: renamed from: jp */
    private final boolean f6357jp;

    /* JADX INFO: renamed from: aG */
    @NotNull
    public static final CustomPacketPayload.Type<C1210wD> f6358aG = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_sound"));

    /* JADX INFO: renamed from: aH */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1210wD> f6359aH = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6721g(v1);
    }, C1210wD::new);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1210wD.class), C1210wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1210wD.class), C1210wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1210wD.class, Object.class), C1210wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public ItemStack m6723m() {
        return this.f6352r;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6724h() {
        return this.f6353aI;
    }

    /* JADX INFO: renamed from: cq */
    public int m6725cq() {
        return this.f6354sU;
    }

    /* JADX INFO: renamed from: dh */
    public boolean m6726dh() {
        return this.f6355jn;
    }

    /* JADX INFO: renamed from: di */
    public boolean m6727di() {
        return this.f6356jo;
    }

    /* JADX INFO: renamed from: dj */
    public boolean m6728dj() {
        return this.f6357jp;
    }

    public C1210wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2, boolean z3) {
        this.f6352r = itemStack.copy();
        this.f6353aI = vec3;
        this.f6354sU = i;
        this.f6355jn = z;
        this.f6356jo = z2;
        this.f6357jp = z3;
    }

    public C1210wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2) {
        this(itemStack, vec3, i, z, z2, false);
    }

    public C1210wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z) {
        this(itemStack, vec3, i, z, false, false);
    }

    public C1210wD(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1291xn.m7869a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: g */
    public void m6721g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1291xn.m7870a(registryFriendlyByteBuf, this.f6352r);
        registryFriendlyByteBuf.writeVec3(this.f6353aI);
        registryFriendlyByteBuf.writeInt(this.f6354sU);
        registryFriendlyByteBuf.writeBoolean(this.f6355jn);
        registryFriendlyByteBuf.writeBoolean(this.f6356jo);
        registryFriendlyByteBuf.writeBoolean(this.f6357jp);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6358aG;
    }

    /* JADX INFO: renamed from: b */
    public static void m6722b(C1210wD c1210wD, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2932a(c1210wD, iPayloadContext);
    }
}
