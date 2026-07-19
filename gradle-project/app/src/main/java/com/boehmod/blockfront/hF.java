package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hF.class */
public class hF {

    @NotNull
    private final hG a;
    private float fZ;
    private float ga;
    private float gb;
    private float gc;
    private float gd = 0.0f;
    private float aB = 1.0f;

    public hF(@NotNull hG hGVar) {
        this.a = hGVar;
    }

    @NotNull
    public hF a(float f) {
        this.aB = f;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m450a(float f) {
        aP();
        e(f);
        this.gd += 1.0f;
        return this.gd >= ((float) this.a.aj()) && this.gc <= 0.01f;
    }

    private void aP() {
        if (this.gd < this.a.aj()) {
            this.gc = Mth.lerp(this.a.L(), this.gc, 1.0f);
        } else {
            if (this.a.aj() == 0 && this.gd == 0.0f) {
                this.gc = 1.0f;
            }
            this.gc = Mth.lerp(this.a.M(), this.gc, 0.0f);
        }
        this.gc = Mth.clamp(this.gc, 0.0f, 1.0f);
    }

    private void e(float f) {
        this.fZ = (float) Math.sin(f * this.a.I());
        this.ga = (float) Math.sin(f * this.a.J());
        this.gb = (float) Math.sin(f * this.a.K());
    }

    @NotNull
    public Vector3f b() {
        return new Vector3f(this.fZ, this.ga, this.gb).mul(this.a.F(), this.a.G(), this.a.H()).mul(this.gc * this.aB);
    }

    @NotNull
    public static hF a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        hF hFVar = new hF(hG.a(friendlyByteBuf));
        hFVar.a(friendlyByteBuf.readFloat());
        return hFVar;
    }

    public void b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.a.b(friendlyByteBuf);
        friendlyByteBuf.writeFloat(this.aB);
    }
}
