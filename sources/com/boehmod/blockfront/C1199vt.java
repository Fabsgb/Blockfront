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
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vt.class */
public final class C1199vt extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Holder<SoundEvent> f6302b;

    /* JADX INFO: renamed from: a */
    private final SoundSource f6303a;

    /* JADX INFO: renamed from: sx */
    private final int f6304sx;

    /* JADX INFO: renamed from: nQ */
    private final float f6305nQ;

    /* JADX INFO: renamed from: nR */
    private final float f6306nR;

    /* JADX INFO: renamed from: sy */
    private final int f6307sy;

    /* JADX INFO: renamed from: sz */
    public static final int f6308sz = 1;

    /* JADX INFO: renamed from: sA */
    public static final int f6309sA = 2;

    /* JADX INFO: renamed from: sB */
    public static final int f6310sB = 4;

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final CustomPacketPayload.Type<C1199vt> f6311w = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_entity_sound"));

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1199vt> f6312x = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6678g(v1);
    }, C1199vt::new);

    public C1199vt(@NotNull Holder<SoundEvent> holder, SoundSource soundSource, int i, float f, float f2, int i2) {
        this.f6302b = holder;
        this.f6303a = soundSource;
        this.f6304sx = i;
        this.f6305nQ = f;
        this.f6306nR = f2;
        this.f6307sy = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1199vt.class), C1199vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1199vt.class), C1199vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1199vt.class, Object.class), C1199vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Holder<SoundEvent> m6683b() {
        return this.f6302b;
    }

    /* JADX INFO: renamed from: a */
    public SoundSource m6684a() {
        return this.f6303a;
    }

    /* JADX INFO: renamed from: ci */
    public int m6685ci() {
        return this.f6304sx;
    }

    /* JADX INFO: renamed from: bO */
    public float m6686bO() {
        return this.f6305nQ;
    }

    /* JADX INFO: renamed from: bP */
    public float m6687bP() {
        return this.f6306nR;
    }

    /* JADX INFO: renamed from: cj */
    public int m6688cj() {
        return this.f6307sy;
    }

    public C1199vt(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f) {
        this(holder, soundSource, i, f, 2.0f);
    }

    public C1199vt(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f, float f2) {
        this(holder, soundSource, i, f, f2, 0);
    }

    public C1199vt(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1291xn.m7875b(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVarInt());
    }

    /* JADX INFO: renamed from: g */
    public void m6678g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1291xn.m7876b(registryFriendlyByteBuf, this.f6302b);
        registryFriendlyByteBuf.writeEnum(this.f6303a);
        registryFriendlyByteBuf.writeInt(this.f6304sx);
        registryFriendlyByteBuf.writeFloat(this.f6305nQ);
        registryFriendlyByteBuf.writeFloat(this.f6306nR);
        registryFriendlyByteBuf.writeVarInt(this.f6307sy);
    }

    /* JADX INFO: renamed from: cQ */
    public boolean m6679cQ() {
        return (this.f6307sy & 1) != 0;
    }

    /* JADX INFO: renamed from: cR */
    public boolean m6680cR() {
        return (this.f6307sy & 2) != 0;
    }

    /* JADX INFO: renamed from: cS */
    public boolean m6681cS() {
        return (this.f6307sy & 4) != 0;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6311w;
    }

    /* JADX INFO: renamed from: b */
    public static void m6682b(C1199vt c1199vt, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2945a(c1199vt, iPayloadContext);
    }
}
