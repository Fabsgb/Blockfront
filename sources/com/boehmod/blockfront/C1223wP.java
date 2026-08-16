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

/* JADX INFO: renamed from: com.boehmod.blockfront.wP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wP.class */
public final class C1223wP extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: W */
    @NotNull
    private final UUID f6644W;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final ItemStack f6645s;

    /* JADX INFO: renamed from: pc */
    private final float f6646pc;

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final CustomPacketPayload.Type<C1223wP> f6647as = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_killed_message"));

    /* JADX INFO: renamed from: at */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1223wP> f6648at = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6971g(v1);
    }, C1223wP::new);

    public C1223wP(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.f6644W = uuid;
        this.f6645s = itemStack;
        this.f6646pc = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1223wP.class), C1223wP.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wP;->W:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wP;->s:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wP;->pc:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1223wP.class), C1223wP.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wP;->W:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wP;->s:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wP;->pc:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1223wP.class, Object.class), C1223wP.class, "playerUUID;itemUsed;userHealth", "FIELD:Lcom/boehmod/blockfront/wP;->W:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wP;->s:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/wP;->pc:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m6973b() {
        return this.f6644W;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public ItemStack m6974n() {
        return this.f6645s;
    }

    /* JADX INFO: renamed from: cc */
    public float m6975cc() {
        return this.f6646pc;
    }

    public C1223wP(@NotNull C1089to c1089to) {
        this(c1089to.getUUID(), c1089to.m5967m(), c1089to.m5968ba());
    }

    public C1223wP(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readUUID(), C1271xK.m7196a(registryFriendlyByteBuf), registryFriendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: g */
    public void m6971g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUUID(this.f6644W);
        C1271xK.m7197a(registryFriendlyByteBuf, this.f6645s);
        registryFriendlyByteBuf.writeFloat(this.f6646pc);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6647as;
    }

    /* JADX INFO: renamed from: b */
    public static void m6972b(C1223wP c1223wP, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2941a(c1223wP, iPayloadContext);
    }
}
