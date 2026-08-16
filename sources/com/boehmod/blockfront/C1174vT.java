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

/* JADX INFO: renamed from: com.boehmod.blockfront.vT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vT.class */
public final class C1174vT extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Holder<SoundEvent> f6386b;

    /* JADX INFO: renamed from: a */
    private final SoundSource f6387a;

    /* JADX INFO: renamed from: uB */
    private final int f6388uB;

    /* JADX INFO: renamed from: oO */
    private final float f6389oO;

    /* JADX INFO: renamed from: oP */
    private final float f6390oP;

    /* JADX INFO: renamed from: uC */
    private final int f6391uC;

    /* JADX INFO: renamed from: uD */
    public static final int f6392uD = 1;

    /* JADX INFO: renamed from: uE */
    public static final int f6393uE = 2;

    /* JADX INFO: renamed from: uF */
    public static final int f6394uF = 4;

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final CustomPacketPayload.Type<C1174vT> f6395w = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_entity_sound"));

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C1174vT> f6396x = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6673g(v1);
    }, C1174vT::new);

    public C1174vT(@NotNull Holder<SoundEvent> holder, SoundSource soundSource, int i, float f, float f2, int i2) {
        this.f6386b = holder;
        this.f6387a = soundSource;
        this.f6388uB = i;
        this.f6389oO = f;
        this.f6390oP = f2;
        this.f6391uC = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1174vT.class), C1174vT.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vT;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vT;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vT;->uB:I", "FIELD:Lcom/boehmod/blockfront/vT;->oO:F", "FIELD:Lcom/boehmod/blockfront/vT;->oP:F", "FIELD:Lcom/boehmod/blockfront/vT;->uC:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1174vT.class), C1174vT.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vT;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vT;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vT;->uB:I", "FIELD:Lcom/boehmod/blockfront/vT;->oO:F", "FIELD:Lcom/boehmod/blockfront/vT;->oP:F", "FIELD:Lcom/boehmod/blockfront/vT;->uC:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1174vT.class, Object.class), C1174vT.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vT;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vT;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vT;->uB:I", "FIELD:Lcom/boehmod/blockfront/vT;->oO:F", "FIELD:Lcom/boehmod/blockfront/vT;->oP:F", "FIELD:Lcom/boehmod/blockfront/vT;->uC:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Holder<SoundEvent> m6678b() {
        return this.f6386b;
    }

    /* JADX INFO: renamed from: a */
    public SoundSource m6679a() {
        return this.f6387a;
    }

    /* JADX INFO: renamed from: cy */
    public int m6680cy() {
        return this.f6388uB;
    }

    /* JADX INFO: renamed from: bU */
    public float m6681bU() {
        return this.f6389oO;
    }

    /* JADX INFO: renamed from: bV */
    public float m6682bV() {
        return this.f6390oP;
    }

    /* JADX INFO: renamed from: cz */
    public int m6683cz() {
        return this.f6391uC;
    }

    public C1174vT(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f) {
        this(holder, soundSource, i, f, 2.0f);
    }

    public C1174vT(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f, float f2) {
        this(holder, soundSource, i, f, f2, 0);
    }

    public C1174vT(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C1271xK.m7202b(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVarInt());
    }

    /* JADX INFO: renamed from: g */
    public void m6673g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1271xK.m7203b(registryFriendlyByteBuf, this.f6386b);
        registryFriendlyByteBuf.writeEnum(this.f6387a);
        registryFriendlyByteBuf.writeInt(this.f6388uB);
        registryFriendlyByteBuf.writeFloat(this.f6389oO);
        registryFriendlyByteBuf.writeFloat(this.f6390oP);
        registryFriendlyByteBuf.writeVarInt(this.f6391uC);
    }

    /* JADX INFO: renamed from: cZ */
    public boolean m6674cZ() {
        return (this.f6391uC & 1) != 0;
    }

    /* JADX INFO: renamed from: da */
    public boolean m6675da() {
        return (this.f6391uC & 2) != 0;
    }

    /* JADX INFO: renamed from: db */
    public boolean m6676db() {
        return (this.f6391uC & 4) != 0;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6395w;
    }

    /* JADX INFO: renamed from: b */
    public static void m6677b(C1174vT c1174vT, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2956a(c1174vT, iPayloadContext);
    }
}
