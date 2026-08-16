package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hW.class */
public final class C0434hW extends Record {

    /* JADX INFO: renamed from: gz */
    private final float f2743gz;

    /* JADX INFO: renamed from: gA */
    private final float f2744gA;

    /* JADX INFO: renamed from: gB */
    private final float f2745gB;

    /* JADX INFO: renamed from: gC */
    private final float f2746gC;

    /* JADX INFO: renamed from: gD */
    private final float f2747gD;

    /* JADX INFO: renamed from: gE */
    private final float f2748gE;

    /* JADX INFO: renamed from: gF */
    private final float f2749gF;

    /* JADX INFO: renamed from: gG */
    private final float f2750gG;

    /* JADX INFO: renamed from: kJ */
    private final int f2751kJ;

    public C0434hW(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        this.f2743gz = f;
        this.f2744gA = f2;
        this.f2745gB = f3;
        this.f2746gC = f4;
        this.f2747gD = f5;
        this.f2748gE = f6;
        this.f2749gF = f7;
        this.f2750gG = f8;
        this.f2751kJ = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0434hW.class), C0434hW.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hW;->gz:F", "FIELD:Lcom/boehmod/blockfront/hW;->gA:F", "FIELD:Lcom/boehmod/blockfront/hW;->gB:F", "FIELD:Lcom/boehmod/blockfront/hW;->gC:F", "FIELD:Lcom/boehmod/blockfront/hW;->gD:F", "FIELD:Lcom/boehmod/blockfront/hW;->gE:F", "FIELD:Lcom/boehmod/blockfront/hW;->gF:F", "FIELD:Lcom/boehmod/blockfront/hW;->gG:F", "FIELD:Lcom/boehmod/blockfront/hW;->kJ:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0434hW.class), C0434hW.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hW;->gz:F", "FIELD:Lcom/boehmod/blockfront/hW;->gA:F", "FIELD:Lcom/boehmod/blockfront/hW;->gB:F", "FIELD:Lcom/boehmod/blockfront/hW;->gC:F", "FIELD:Lcom/boehmod/blockfront/hW;->gD:F", "FIELD:Lcom/boehmod/blockfront/hW;->gE:F", "FIELD:Lcom/boehmod/blockfront/hW;->gF:F", "FIELD:Lcom/boehmod/blockfront/hW;->gG:F", "FIELD:Lcom/boehmod/blockfront/hW;->kJ:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0434hW.class, Object.class), C0434hW.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hW;->gz:F", "FIELD:Lcom/boehmod/blockfront/hW;->gA:F", "FIELD:Lcom/boehmod/blockfront/hW;->gB:F", "FIELD:Lcom/boehmod/blockfront/hW;->gC:F", "FIELD:Lcom/boehmod/blockfront/hW;->gD:F", "FIELD:Lcom/boehmod/blockfront/hW;->gE:F", "FIELD:Lcom/boehmod/blockfront/hW;->gF:F", "FIELD:Lcom/boehmod/blockfront/hW;->gG:F", "FIELD:Lcom/boehmod/blockfront/hW;->kJ:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: F */
    public float m2008F() {
        return this.f2743gz;
    }

    /* JADX INFO: renamed from: G */
    public float m2009G() {
        return this.f2744gA;
    }

    /* JADX INFO: renamed from: H */
    public float m2010H() {
        return this.f2745gB;
    }

    /* JADX INFO: renamed from: I */
    public float m2011I() {
        return this.f2746gC;
    }

    /* JADX INFO: renamed from: J */
    public float m2012J() {
        return this.f2747gD;
    }

    /* JADX INFO: renamed from: K */
    public float m2013K() {
        return this.f2748gE;
    }

    /* JADX INFO: renamed from: L */
    public float m2014L() {
        return this.f2749gF;
    }

    /* JADX INFO: renamed from: M */
    public float m2015M() {
        return this.f2750gG;
    }

    /* JADX INFO: renamed from: av */
    public int m2016av() {
        return this.f2751kJ;
    }

    /* JADX INFO: renamed from: b */
    public void m2006b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.f2743gz);
        friendlyByteBuf.writeFloat(this.f2744gA);
        friendlyByteBuf.writeFloat(this.f2745gB);
        friendlyByteBuf.writeFloat(this.f2746gC);
        friendlyByteBuf.writeFloat(this.f2747gD);
        friendlyByteBuf.writeFloat(this.f2748gE);
        friendlyByteBuf.writeFloat(this.f2749gF);
        friendlyByteBuf.writeFloat(this.f2750gG);
        friendlyByteBuf.writeVarInt(this.f2751kJ);
    }

    /* JADX INFO: renamed from: a */
    public static C0434hW m2007a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0434hW(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readVarInt());
    }
}
