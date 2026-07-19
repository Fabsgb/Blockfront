package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hG.class */
public final class hG extends Record {
    private final float ge;
    private final float gf;

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    private final float f415gg;
    private final float gh;
    private final float gi;
    private final float gj;
    private final float gk;
    private final float gl;
    private final int jo;

    public hG(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        this.ge = f;
        this.gf = f2;
        this.f415gg = f3;
        this.gh = f4;
        this.gi = f5;
        this.gj = f6;
        this.gk = f7;
        this.gl = f8;
        this.jo = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, hG.class), hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, hG.class), hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, hG.class, Object.class), hG.class, "pitchAmplitude;yawAmplitude;rollAmplitude;pitchFrequency;yawFrequency;rollFrequency;easeInLerp;easeOutLerp;idleTime", "FIELD:Lcom/boehmod/blockfront/hG;->ge:F", "FIELD:Lcom/boehmod/blockfront/hG;->gf:F", "FIELD:Lcom/boehmod/blockfront/hG;->gg:F", "FIELD:Lcom/boehmod/blockfront/hG;->gh:F", "FIELD:Lcom/boehmod/blockfront/hG;->gi:F", "FIELD:Lcom/boehmod/blockfront/hG;->gj:F", "FIELD:Lcom/boehmod/blockfront/hG;->gk:F", "FIELD:Lcom/boehmod/blockfront/hG;->gl:F", "FIELD:Lcom/boehmod/blockfront/hG;->jo:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public float F() {
        return this.ge;
    }

    public float G() {
        return this.gf;
    }

    public float H() {
        return this.f415gg;
    }

    public float I() {
        return this.gh;
    }

    public float J() {
        return this.gi;
    }

    public float K() {
        return this.gj;
    }

    public float L() {
        return this.gk;
    }

    public float M() {
        return this.gl;
    }

    public int aj() {
        return this.jo;
    }

    public void b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeFloat(this.ge);
        friendlyByteBuf.writeFloat(this.gf);
        friendlyByteBuf.writeFloat(this.f415gg);
        friendlyByteBuf.writeFloat(this.gh);
        friendlyByteBuf.writeFloat(this.gi);
        friendlyByteBuf.writeFloat(this.gj);
        friendlyByteBuf.writeFloat(this.gk);
        friendlyByteBuf.writeFloat(this.gl);
        friendlyByteBuf.writeVarInt(this.jo);
    }

    public static hG a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new hG(friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readVarInt());
    }
}
