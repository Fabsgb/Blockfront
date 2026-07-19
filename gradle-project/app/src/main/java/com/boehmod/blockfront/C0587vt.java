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

/* JADX INFO: renamed from: com.boehmod.blockfront.vt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vt.class */
public final class C0587vt extends Record implements CustomPacketPayload {

    @NotNull
    private final Holder<SoundEvent> b;
    private final SoundSource a;
    private final int sx;
    private final float nQ;
    private final float nR;
    private final int sy;
    public static final int sz = 1;
    public static final int sA = 2;
    public static final int sB = 4;

    @NotNull
    public static final CustomPacketPayload.Type<C0587vt> w = new CustomPacketPayload.Type<>(C0265jv.d("packet_entity_sound"));

    @NotNull
    public static final StreamCodec<RegistryFriendlyByteBuf, C0587vt> x = CustomPacketPayload.codec((v0, v1) -> {
        v0.g(v1);
    }, C0587vt::new);

    public C0587vt(@NotNull Holder<SoundEvent> holder, SoundSource soundSource, int i, float f, float f2, int i2) {
        this.b = holder;
        this.a = soundSource;
        this.sx = i;
        this.nQ = f;
        this.nR = f2;
        this.sy = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0587vt.class), C0587vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0587vt.class), C0587vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0587vt.class, Object.class), C0587vt.class, "soundEvent;soundSource;livingEntityID;pitch;volume;flags", "FIELD:Lcom/boehmod/blockfront/vt;->b:Lnet/minecraft/core/Holder;", "FIELD:Lcom/boehmod/blockfront/vt;->a:Lnet/minecraft/sounds/SoundSource;", "FIELD:Lcom/boehmod/blockfront/vt;->sx:I", "FIELD:Lcom/boehmod/blockfront/vt;->nQ:F", "FIELD:Lcom/boehmod/blockfront/vt;->nR:F", "FIELD:Lcom/boehmod/blockfront/vt;->sy:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Holder<SoundEvent> b() {
        return this.b;
    }

    public SoundSource a() {
        return this.a;
    }

    public int ci() {
        return this.sx;
    }

    public float bO() {
        return this.nQ;
    }

    public float bP() {
        return this.nR;
    }

    public int cj() {
        return this.sy;
    }

    public C0587vt(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f) {
        this(holder, soundSource, i, f, 2.0f);
    }

    public C0587vt(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, int i, float f, float f2) {
        this(holder, soundSource, i, f, f2, 0);
    }

    public C0587vt(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this(C0635xn.b(registryFriendlyByteBuf), registryFriendlyByteBuf.readEnum(SoundSource.class), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readVarInt());
    }

    public void g(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0635xn.b(registryFriendlyByteBuf, this.b);
        registryFriendlyByteBuf.writeEnum(this.a);
        registryFriendlyByteBuf.writeInt(this.sx);
        registryFriendlyByteBuf.writeFloat(this.nQ);
        registryFriendlyByteBuf.writeFloat(this.nR);
        registryFriendlyByteBuf.writeVarInt(this.sy);
    }

    public boolean cQ() {
        return (this.sy & 1) != 0;
    }

    public boolean cR() {
        return (this.sy & 2) != 0;
    }

    public boolean cS() {
        return (this.sy & 4) != 0;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return w;
    }

    public static void b(C0587vt c0587vt, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0587vt, iPayloadContext);
    }
}
