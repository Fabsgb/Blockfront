package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vx.class */
public final class C1203vx extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: cg */
    @NotNull
    private final List<Component> f6323cg;

    /* JADX INFO: renamed from: sC */
    private final int f6324sC;

    /* JADX INFO: renamed from: dA */
    @Nullable
    private final String f6325dA;

    /* JADX INFO: renamed from: az */
    @Nullable
    private final Vec3 f6326az;

    /* JADX INFO: renamed from: sD */
    private final int f6327sD;

    /* JADX INFO: renamed from: sE */
    private final int f6328sE;

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final CustomPacketPayload.Type<C1203vx> f6329A = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_game_notification"));

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1203vx> f6330B = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6698g(v1);
    }, C1203vx::new);

    public C1203vx(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        this.f6323cg = list;
        this.f6324sC = i;
        this.f6325dA = str;
        this.f6326az = vec3;
        this.f6327sD = i2;
        this.f6328sE = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1203vx.class), C1203vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1203vx.class), C1203vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1203vx.class, Object.class), C1203vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aK */
    public List<Component> m6700aK() {
        return this.f6323cg;
    }

    /* JADX INFO: renamed from: ck */
    public int m6701ck() {
        return this.f6324sC;
    }

    @Nullable
    /* JADX INFO: renamed from: T */
    public String m6702T() {
        return this.f6325dA;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public Vec3 m6703h() {
        return this.f6326az;
    }

    /* JADX INFO: renamed from: cl */
    public int m6704cl() {
        return this.f6327sD;
    }

    /* JADX INFO: renamed from: H */
    public int m6705H() {
        return this.f6328sE;
    }

    public C1203vx(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readList(friendlyByteBuf -> {
            return (Component) ComponentSerialization.STREAM_CODEC.decode((RegistryFriendlyByteBuf) friendlyByteBuf);
        }), registryFriendlyByteBuf.readInt(), (String) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readUtf();
        }), (Vec3) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readVec3();
        }), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: g */
    public void m6698g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeCollection(this.f6323cg, (friendlyByteBuf, component) -> {
            ComponentSerialization.STREAM_CODEC.encode((RegistryFriendlyByteBuf) friendlyByteBuf, component);
        });
        registryFriendlyByteBuf.writeInt(this.f6324sC);
        registryFriendlyByteBuf.writeNullable(this.f6325dA, (v0, v1) -> {
            v0.writeUtf(v1);
        });
        registryFriendlyByteBuf.writeNullable(this.f6326az, (v0, v1) -> {
            v0.writeVec3(v1);
        });
        registryFriendlyByteBuf.writeInt(this.f6327sD);
        registryFriendlyByteBuf.writeInt(this.f6328sE);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6329A;
    }

    /* JADX INFO: renamed from: b */
    public static void m6699b(C1203vx c1203vx, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2939a(c1203vx, iPayloadContext);
    }
}
