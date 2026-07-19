package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vV.class */
public final class vV extends Record implements CustomPacketPayload {

    @NotNull
    private final Holder<SoundEvent> d;

    @NotNull
    private final SoundSource c;
    private final float nZ;
    private final float oa;

    @NotNull
    private final Vec3 aG;

    @NotNull
    public static final CustomPacketPayload.Type<vV> Y = new CustomPacketPayload.Type<>(C0265jv.d("packet_sound_position"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, vV> Z = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, vV::new);

    public vV(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2, @NotNull Vec3 vec3) {
        this.d = holder;
        this.c = soundSource;
        this.nZ = f;
        this.oa = f2;
        this.aG = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vV.class), vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vV.class), vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vV.class, Object.class), vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Holder<SoundEvent> c() {
        return this.d;
    }

    @NotNull
    public SoundSource a() {
        return this.c;
    }

    public float bP() {
        return this.nZ;
    }

    public float bO() {
        return this.oa;
    }

    @NotNull
    public Vec3 h() {
        return this.aG;
    }

    public vV(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVec3());
    }

    public vV(Holder<SoundEvent> holder, SoundSource soundSource, float f, Vec3 vec3) {
        this(holder, soundSource, f, 1.0f, vec3);
    }

    public void g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.d);
        registryFriendlyByteBuf.writeEnum(this.c);
        registryFriendlyByteBuf.writeFloat(this.nZ);
        registryFriendlyByteBuf.writeFloat(this.oa);
        registryFriendlyByteBuf.writeVec3(this.aG);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return Y;
    }

    public static void b(vV vVVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vVVar, iPayloadContext);
    }
}
