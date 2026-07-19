package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wr.class */
public final class C0612wr extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID U;

    @NotNull
    private final ItemStack q;
    private final float oe;

    @NotNull
    public static final CustomPacketPayload.Type<C0612wr> au = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_killed_message"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0612wr> av = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0612wr::new);

    public C0612wr(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.U = uuid;
        this.q = itemStack;
        this.oe = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0612wr.class), C0612wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0612wr.class), C0612wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0612wr.class, Object.class), C0612wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID b() {
        return this.U;
    }

    @NotNull
    public ItemStack l() {
        return this.q;
    }

    public float bW() {
        return this.oe;
    }

    public C0612wr(@NotNull sR sRVar) {
        this(sRVar.getUUID(), sRVar.k(), sRVar.aU());
    }

    public C0612wr(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readUUID(), C0635xn.a(registryFriendlyByteBuf), registryFriendlyByteBuf.readFloat());
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUUID(this.U);
        C0635xn.a(registryFriendlyByteBuf, this.q);
        registryFriendlyByteBuf.writeFloat(this.oe);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return au;
    }

    public static void b(C0612wr c0612wr, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0612wr, iPayloadContext);
    }
}
