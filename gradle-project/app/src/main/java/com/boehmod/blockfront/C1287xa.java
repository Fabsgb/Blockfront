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

/* JADX INFO: renamed from: com.boehmod.blockfront.xa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xa.class */
public final class C1287xa extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: t */
    @NotNull
    private final ItemStack f6916t;

    /* JADX INFO: renamed from: aJ */
    @NotNull
    private final Vec3 f6917aJ;

    /* JADX INFO: renamed from: uY */
    private final int f6918uY;

    /* JADX INFO: renamed from: jE */
    private final boolean f6919jE;

    /* JADX INFO: renamed from: jF */
    private final boolean f6920jF;

    /* JADX INFO: renamed from: jG */
    private final boolean f6921jG;

    /* JADX INFO: renamed from: aD */
    @NotNull
    public static final CustomPacketPayload.Type<C1287xa> f6922aD = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_gun_sound"));

    /* JADX INFO: renamed from: aE */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1287xa> f6923aE = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7309g(v1);
    }, C1287xa::new);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1287xa.class), C1287xa.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/xa;->t:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/xa;->aJ:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/xa;->uY:I", "FIELD:Lcom/boehmod/blockfront/xa;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1287xa.class), C1287xa.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/xa;->t:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/xa;->aJ:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/xa;->uY:I", "FIELD:Lcom/boehmod/blockfront/xa;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1287xa.class, Object.class), C1287xa.class, "itemStack;position;entityID;lastRound;force;decoy", "FIELD:Lcom/boehmod/blockfront/xa;->t:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/xa;->aJ:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/xa;->uY:I", "FIELD:Lcom/boehmod/blockfront/xa;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xa;->jG:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public ItemStack m7311o() {
        return this.f6916t;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7312h() {
        return this.f6917aJ;
    }

    /* JADX INFO: renamed from: cG */
    public int m7313cG() {
        return this.f6918uY;
    }

    /* JADX INFO: renamed from: dq */
    public boolean m7314dq() {
        return this.f6919jE;
    }

    /* JADX INFO: renamed from: dr */
    public boolean m7315dr() {
        return this.f6920jF;
    }

    /* JADX INFO: renamed from: ds */
    public boolean m7316ds() {
        return this.f6921jG;
    }

    public C1287xa(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2, boolean z3) {
        this.f6916t = itemStack.copy();
        this.f6917aJ = vec3;
        this.f6918uY = i;
        this.f6919jE = z;
        this.f6920jF = z2;
        this.f6921jG = z3;
    }

    public C1287xa(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z, boolean z2) {
        this(itemStack, vec3, i, z, z2, false);
    }

    public C1287xa(@NotNull ItemStack itemStack, @NotNull Vec3 vec3, int i, boolean z) {
        this(itemStack, vec3, i, z, false, false);
    }

    public C1287xa(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1271xK.m7196a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean(), registryFriendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: g */
    public void m7309g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1271xK.m7197a(registryFriendlyByteBuf, this.f6916t);
        registryFriendlyByteBuf.writeVec3(this.f6917aJ);
        registryFriendlyByteBuf.writeInt(this.f6918uY);
        registryFriendlyByteBuf.writeBoolean(this.f6919jE);
        registryFriendlyByteBuf.writeBoolean(this.f6920jF);
        registryFriendlyByteBuf.writeBoolean(this.f6921jG);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6922aD;
    }

    /* JADX INFO: renamed from: b */
    public static void m7310b(C1287xa c1287xa, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2943a(c1287xa, iPayloadContext);
    }
}
