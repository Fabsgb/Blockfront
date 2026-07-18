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

/* JADX INFO: renamed from: com.boehmod.blockfront.vV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vV.class */
public final class C1175vV extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Holder<SoundEvent> f6203d;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final SoundSource f6204c;

    /* JADX INFO: renamed from: nZ */
    private final float f6205nZ;

    /* JADX INFO: renamed from: oa */
    private final float f6206oa;

    /* JADX INFO: renamed from: aG */
    @NotNull
    private final Vec3 f6207aG;

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final CustomPacketPayload.Type<C1175vV> f6208Y = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sound_position"));

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1175vV> f6209Z = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6571g(v1);
    }, C1175vV::new);

    public C1175vV(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2, @NotNull Vec3 vec3) {
        this.f6203d = holder;
        this.f6204c = soundSource;
        this.f6205nZ = f;
        this.f6206oa = f2;
        this.f6207aG = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1175vV.class), C1175vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1175vV.class), C1175vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1175vV.class, Object.class), C1175vV.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/vV;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vV;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vV;->nZ:F", "FIELD:Lcom/boehmod/blockfront/vV;->oa:F", "FIELD:Lcom/boehmod/blockfront/vV;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Holder<SoundEvent> m6573c() {
        return this.f6203d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SoundSource m6574a() {
        return this.f6204c;
    }

    /* JADX INFO: renamed from: bP */
    public float m6575bP() {
        return this.f6205nZ;
    }

    /* JADX INFO: renamed from: bO */
    public float m6576bO() {
        return this.f6206oa;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6577h() {
        return this.f6207aG;
    }

    public C1175vV(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVec3());
    }

    public C1175vV(Holder<SoundEvent> holder, SoundSource soundSource, float f, Vec3 vec3) {
        this(holder, soundSource, f, 1.0f, vec3);
    }

    /* JADX INFO: renamed from: g */
    public void m6571g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6203d);
        registryFriendlyByteBuf.writeEnum(this.f6204c);
        registryFriendlyByteBuf.writeFloat(this.f6205nZ);
        registryFriendlyByteBuf.writeFloat(this.f6206oa);
        registryFriendlyByteBuf.writeVec3(this.f6207aG);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6208Y;
    }

    /* JADX INFO: renamed from: b */
    public static void m6572b(C1175vV c1175vV, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2937a(c1175vV, iPayloadContext);
    }
}
