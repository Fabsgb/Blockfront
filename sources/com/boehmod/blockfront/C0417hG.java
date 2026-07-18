package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hG.class */
public final class C0417hG extends Record {

    /* JADX INFO: renamed from: ge */
    private final float f2650ge;

    /* JADX INFO: renamed from: gf */
    private final float f2651gf;

    /* JADX INFO: renamed from: gg */
    private final float f2652gg;

    /* JADX INFO: renamed from: gh */
    private final float f2653gh;

    /* JADX INFO: renamed from: gi */
    private final float f2654gi;

    /* JADX INFO: renamed from: gj */
    private final float f2655gj;

    /* JADX INFO: renamed from: gk */
    private final float f2656gk;

    /* JADX INFO: renamed from: gl */
    private final float f2657gl;

    /* JADX INFO: renamed from: jo */
    private final int f2658jo;

    public C0417hG(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        this.f2650ge = f;
        this.f2651gf = f2;
        this.f2652gg = f3;
        this.f2653gh = f4;
        this.f2654gi = f5;
        this.f2655gj = f6;
        this.f2656gk = f7;
        this.f2657gl = f8;
        this.f2658jo = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0417hG.class), C0417hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0417hG.class), C0417hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0417hG.class, Object.class), C0417hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: F */
    public float m1977F() {
        return this.f2650ge;
    }

    /* JADX INFO: renamed from: G */
    public float m1978G() {
        return this.f2651gf;
    }

    /* JADX INFO: renamed from: H */
    public float m1979H() {
        return this.f2652gg;
    }

    /* JADX INFO: renamed from: I */
    public float m1980I() {
        return this.f2653gh;
    }

    /* JADX INFO: renamed from: J */
    public float m1981J() {
        return this.f2654gi;
    }

    /* JADX INFO: renamed from: K */
    public float m1982K() {
        return this.f2655gj;
    }

    /* JADX INFO: renamed from: L */
    public float m1983L() {
        return this.f2656gk;
    }

    /* JADX INFO: renamed from: M */
    public float m1984M() {
        return this.f2657gl;
    }

    /* JADX INFO: renamed from: aj */
    public int m1985aj() {
        return this.f2658jo;
    }

    /* JADX INFO: renamed from: b */
    public void m1975b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f2650ge);
        friendlyByteBuf.writeFloat(this.f2651gf);
        friendlyByteBuf.writeFloat(this.f2652gg);
        friendlyByteBuf.writeFloat(this.f2653gh);
        friendlyByteBuf.writeFloat(this.f2654gi);
        friendlyByteBuf.writeFloat(this.f2655gj);
        friendlyByteBuf.writeFloat(this.f2656gk);
        friendlyByteBuf.writeFloat(this.f2657gl);
        friendlyByteBuf.writeVarInt(this.f2658jo);
    }

    /* JADX INFO: renamed from: a */
    public static C0417hG m1976a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0417hG(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readVarInt());
    }
}
