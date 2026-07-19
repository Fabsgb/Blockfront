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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wD.class */
public final class wD extends Record implements CustomPacketPayload {

    @NotNull
    private final ItemStack r;

    @NotNull
    private final Vec3 aI;
    private final int sU;
    private final boolean jn;
    private final boolean jo;
    private final boolean jp;

    @NotNull
    public static final CustomPacketPayload.Type<wD> aG = new CustomPacketPayload.Type<>(C0265jv.d("packet_gun_sound"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, wD> aH = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, wD::new);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, wD.class), wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, wD.class), wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, wD.class, Object.class), wD.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/wD;->r:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wD;->aI:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/wD;->sU:I", "FIELD:Lcom/boehmod/blockfront/wD;->jn:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wD;->jp:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ItemStack m() {
        return this.r;
    }

    @NotNull
    public Vec3 h() {
        return this.aI;
    }

    public int cq() {
        return this.sU;
    }

    public boolean dh() {
        return this.jn;
    }

    public boolean di() {
        return this.jo;
    }

    public boolean dj() {
        return this.jp;
    }

    public wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2, boolean z3) {
        this.r = itemStack.copy();
        this.aI = vec3;
        this.sU = i;
        this.jn = z;
        this.jo = z2;
        this.jp = z3;
    }

    public wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2) {
        this(itemStack, vec3, i, z, z2, false);
    }

    public wD(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z) {
        this(itemStack, vec3, i, z, false, false);
    }

    public wD(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0635xn.a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean());
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0635xn.a(registryFriendlyByteBuf, this.r);
        registryFriendlyByteBuf.writeVec3(this.aI);
        registryFriendlyByteBuf.writeInt(this.sU);
        registryFriendlyByteBuf.writeBoolean(this.jn);
        registryFriendlyByteBuf.writeBoolean(this.jo);
        registryFriendlyByteBuf.writeBoolean(this.jp);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aG;
    }

    public static void b(wD wDVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(wDVar, iPayloadContext);
    }
}
