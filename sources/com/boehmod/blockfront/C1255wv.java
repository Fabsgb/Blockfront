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

/* JADX INFO: renamed from: com.boehmod.blockfront.wv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wv.class */
public final class C1255wv extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Holder<SoundEvent> f6779d;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final SoundSource f6780c;

    /* JADX INFO: renamed from: oX */
    private final float f6781oX;

    /* JADX INFO: renamed from: oY */
    private final float f6782oY;

    /* JADX INFO: renamed from: aH */
    @NotNull
    private final Vec3 f6783aH;

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final CustomPacketPayload.Type<C1255wv> f6784Y = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sound_position"));

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1255wv> f6785Z = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7097g(v1);
    }, C1255wv::new);

    public C1255wv(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2, @NotNull Vec3 vec3) {
        this.f6779d = holder;
        this.f6780c = soundSource;
        this.f6781oX = f;
        this.f6782oY = f2;
        this.f6783aH = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1255wv.class), C1255wv.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/wv;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wv;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wv;->oX:F", "FIELD:Lcom/boehmod/blockfront/wv;->oY:F", "FIELD:Lcom/boehmod/blockfront/wv;->aH:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1255wv.class), C1255wv.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/wv;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wv;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wv;->oX:F", "FIELD:Lcom/boehmod/blockfront/wv;->oY:F", "FIELD:Lcom/boehmod/blockfront/wv;->aH:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1255wv.class, Object.class), C1255wv.class, "sound;soundSource;volume;pitch;position", "FIELD:Lcom/boehmod/blockfront/wv;->d:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/wv;->c:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/wv;->oX:F", "FIELD:Lcom/boehmod/blockfront/wv;->oY:F", "FIELD:Lcom/boehmod/blockfront/wv;->aH:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Holder<SoundEvent> m7099c() {
        return this.f6779d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SoundSource m7100a() {
        return this.f6780c;
    }

    /* JADX INFO: renamed from: bV */
    public float m7101bV() {
        return this.f6781oX;
    }

    /* JADX INFO: renamed from: bU */
    public float m7102bU() {
        return this.f6782oY;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7103h() {
        return this.f6783aH;
    }

    public C1255wv(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this((Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVec3());
    }

    public C1255wv(Holder<SoundEvent> holder, SoundSource soundSource, float f, Vec3 vec3) {
        this(holder, soundSource, f, 1.0f, vec3);
    }

    /* JADX INFO: renamed from: g */
    public void m7097g(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f6779d);
        registryFriendlyByteBuf.writeEnum(this.f6780c);
        registryFriendlyByteBuf.writeFloat(this.f6781oX);
        registryFriendlyByteBuf.writeFloat(this.f6782oY);
        registryFriendlyByteBuf.writeVec3(this.f6783aH);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6784Y;
    }

    /* JADX INFO: renamed from: b */
    public static void m7098b(C1255wv c1255wv, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2948a(c1255wv, iPayloadContext);
    }
}
