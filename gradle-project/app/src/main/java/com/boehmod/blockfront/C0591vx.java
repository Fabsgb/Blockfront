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

/* JADX INFO: renamed from: com.boehmod.blockfront.vx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vx.class */
public final class C0591vx extends Record implements CustomPacketPayload {

    @NotNull
    private final List<Component> cg;
    private final int sC;

    @Nullable
    private final String dA;

    @Nullable
    private final Vec3 az;
    private final int sD;
    private final int sE;

    @NotNull
    public static final CustomPacketPayload.Type<C0591vx> A = new CustomPacketPayload.Type<>(C0265jv.d("packet_game_notification"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0591vx> B = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0591vx::new);

    public C0591vx(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        this.cg = list;
        this.sC = i;
        this.dA = str;
        this.az = vec3;
        this.sD = i2;
        this.sE = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0591vx.class), C0591vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0591vx.class), C0591vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0591vx.class, Object.class), C0591vx.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vx;->cg:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vx;->sC:I", "FIELD:Lcom/boehmod/blockfront/vx;->dA:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vx;->az:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vx;->sD:I", "FIELD:Lcom/boehmod/blockfront/vx;->sE:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<Component> aK() {
        return this.cg;
    }

    public int ck() {
        return this.sC;
    }

    @Nullable
    public String T() {
        return this.dA;
    }

    @Nullable
    public Vec3 h() {
        return this.az;
    }

    public int cl() {
        return this.sD;
    }

    public int H() {
        return this.sE;
    }

    public C0591vx(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readList(friendlyByteBuf -> {
            return (Component) ComponentSerialization.STREAM_CODEC.decode((RegistryFriendlyByteBuf) friendlyByteBuf);
        }), registryFriendlyByteBuf.readInt(), (String) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readUtf();
        }), (Vec3) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readVec3();
        }), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readInt());
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeCollection(this.cg, (friendlyByteBuf, component) -> {
            ComponentSerialization.STREAM_CODEC.encode((RegistryFriendlyByteBuf) friendlyByteBuf, component);
        });
        registryFriendlyByteBuf.writeInt(this.sC);
        registryFriendlyByteBuf.writeNullable(this.dA, (v0, v1) -> {
            v0.writeUtf(v1);
        });
        registryFriendlyByteBuf.writeNullable(this.az, (v0, v1) -> {
            v0.writeVec3(v1);
        });
        registryFriendlyByteBuf.writeInt(this.sD);
        registryFriendlyByteBuf.writeInt(this.sE);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return A;
    }

    public static void b(C0591vx c0591vx, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0591vx, iPayloadContext);
    }
}
