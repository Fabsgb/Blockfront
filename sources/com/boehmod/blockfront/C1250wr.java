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

/* JADX INFO: renamed from: com.boehmod.blockfront.wr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wr.class */
public final class C1250wr extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: U */
    @NotNull
    private final UUID f7407U;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final ItemStack f7408q;

    /* JADX INFO: renamed from: oe */
    private final float f7409oe;

    /* JADX INFO: renamed from: au */
    @NotNull
    public static final CustomPacketPayload.Type<C1250wr> f7410au = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_killed_message"));

    /* JADX INFO: renamed from: av */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1250wr> f7411av = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7703g(v1);
    }, C1250wr::new);

    public C1250wr(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.f7407U = uuid;
        this.f7408q = itemStack;
        this.f7409oe = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1250wr.class), C1250wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1250wr.class), C1250wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1250wr.class, Object.class), C1250wr.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wr;->U:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wr;->q:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wr;->oe:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m7705b() {
        return this.f7407U;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public ItemStack m7706l() {
        return this.f7408q;
    }

    /* JADX INFO: renamed from: bW */
    public float m7707bW() {
        return this.f7409oe;
    }

    public C1250wr(@NotNull C1011sR c1011sR) {
        this(c1011sR.getUUID(), c1011sR.m5479k(), c1011sR.m5480aU());
    }

    public C1250wr(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readUUID(), C1291xn.m7869a(registryFriendlyByteBuf), registryFriendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: g */
    public void m7703g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUUID(this.f7407U);
        C1291xn.m7870a(registryFriendlyByteBuf, this.f7408q);
        registryFriendlyByteBuf.writeFloat(this.f7409oe);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7410au;
    }

    /* JADX INFO: renamed from: b */
    public static void m7704b(C1250wr c1250wr, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2929a(c1250wr, iPayloadContext);
    }
}
