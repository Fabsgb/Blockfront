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

/* JADX INFO: renamed from: com.boehmod.blockfront.vW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vW.class */
public final class C1177vW extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: cp */
    @NotNull
    private final List<Component> f6404cp;

    /* JADX INFO: renamed from: uG */
    private final int f6405uG;

    /* JADX INFO: renamed from: dL */
    @Nullable
    private final String f6406dL;

    /* JADX INFO: renamed from: aA */
    @Nullable
    private final Vec3 f6407aA;

    /* JADX INFO: renamed from: uH */
    private final int f6408uH;

    /* JADX INFO: renamed from: uI */
    private final int f6409uI;

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final CustomPacketPayload.Type<C1177vW> f6410z = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_game_notification"));

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1177vW> f6411A = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6691g(v1);
    }, C1177vW::new);

    public C1177vW(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        this.f6404cp = list;
        this.f6405uG = i;
        this.f6406dL = str;
        this.f6407aA = vec3;
        this.f6408uH = i2;
        this.f6409uI = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1177vW.class), C1177vW.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vW;->cp:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vW;->uG:I", "FIELD:Lcom/boehmod/blockfront/vW;->dL:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vW;->aA:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vW;->uH:I", "FIELD:Lcom/boehmod/blockfront/vW;->uI:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1177vW.class), C1177vW.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vW;->cp:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vW;->uG:I", "FIELD:Lcom/boehmod/blockfront/vW;->dL:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vW;->aA:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vW;->uH:I", "FIELD:Lcom/boehmod/blockfront/vW;->uI:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1177vW.class, Object.class), C1177vW.class, "messages;time;key;position;pointerColor;backgroundColor", "FIELD:Lcom/boehmod/blockfront/vW;->cp:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/vW;->uG:I", "FIELD:Lcom/boehmod/blockfront/vW;->dL:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vW;->aA:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/vW;->uH:I", "FIELD:Lcom/boehmod/blockfront/vW;->uI:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aR */
    public List<Component> m6693aR() {
        return this.f6404cp;
    }

    /* JADX INFO: renamed from: cA */
    public int m6694cA() {
        return this.f6405uG;
    }

    @Nullable
    /* JADX INFO: renamed from: aa */
    public String m6695aa() {
        return this.f6406dL;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public Vec3 m6696h() {
        return this.f6407aA;
    }

    /* JADX INFO: renamed from: cB */
    public int m6697cB() {
        return this.f6408uH;
    }

    /* JADX INFO: renamed from: L */
    public int m6698L() {
        return this.f6409uI;
    }

    public C1177vW(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(registryFriendlyByteBuf.readList(friendlyByteBuf -> {
            return (Component) ComponentSerialization.STREAM_CODEC.decode((RegistryFriendlyByteBuf) friendlyByteBuf);
        }), registryFriendlyByteBuf.readInt(), (String) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readUtf();
        }), (Vec3) registryFriendlyByteBuf.readNullable((v0) -> {
            return v0.readVec3();
        }), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: g */
    public void m6691g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeCollection(this.f6404cp, (friendlyByteBuf, component) -> {
            ComponentSerialization.STREAM_CODEC.encode((RegistryFriendlyByteBuf) friendlyByteBuf, component);
        });
        registryFriendlyByteBuf.writeInt(this.f6405uG);
        registryFriendlyByteBuf.writeNullable(this.f6406dL, (v0, v1) -> {
            v0.writeUtf(v1);
        });
        registryFriendlyByteBuf.writeNullable(this.f6407aA, (v0, v1) -> {
            v0.writeVec3(v1);
        });
        registryFriendlyByteBuf.writeInt(this.f6408uH);
        registryFriendlyByteBuf.writeInt(this.f6409uI);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6410z;
    }

    /* JADX INFO: renamed from: b */
    public static void m6692b(C1177vW c1177vW, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2950a(c1177vW, iPayloadContext);
    }
}
