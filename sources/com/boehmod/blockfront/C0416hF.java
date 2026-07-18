package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.hF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hF.class */
public class C0416hF {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0417hG f2643a;

    /* JADX INFO: renamed from: fZ */
    private float f2644fZ;

    /* JADX INFO: renamed from: ga */
    private float f2645ga;

    /* JADX INFO: renamed from: gb */
    private float f2646gb;

    /* JADX INFO: renamed from: gc */
    private float f2647gc;

    /* JADX INFO: renamed from: gd */
    private float f2648gd = 0.0f;

    /* JADX INFO: renamed from: aB */
    private float f2649aB = 1.0f;

    public C0416hF(@NotNull C0417hG c0417hG) {
        this.f2643a = c0417hG;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0416hF m1968a(float f) {
        this.f2649aB = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1969a(float f) {
        m1970aP();
        m1971e(f);
        this.f2648gd += 1.0f;
        return this.f2648gd >= ((float) this.f2643a.m1985aj()) && this.f2647gc <= 0.01f;
    }

    /* JADX INFO: renamed from: aP */
    private void m1970aP() {
        if (this.f2648gd < this.f2643a.m1985aj()) {
            this.f2647gc = Mth.lerp(this.f2643a.m1983L(), this.f2647gc, 1.0f);
        } else {
            if (this.f2643a.m1985aj() == 0 && this.f2648gd == 0.0f) {
                this.f2647gc = 1.0f;
            }
            this.f2647gc = Mth.lerp(this.f2643a.m1984M(), this.f2647gc, 0.0f);
        }
        this.f2647gc = Mth.clamp(this.f2647gc, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: e */
    private void m1971e(float f) {
        this.f2644fZ = (float) Math.sin(f * this.f2643a.m1980I());
        this.f2645ga = (float) Math.sin(f * this.f2643a.m1981J());
        this.f2646gb = (float) Math.sin(f * this.f2643a.m1982K());
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vector3f m1972b() {
        return new Vector3f(this.f2644fZ, this.f2645ga, this.f2646gb).mul(this.f2643a.m1977F(), this.f2643a.m1978G(), this.f2643a.m1979H()).mul(this.f2647gc * this.f2649aB);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0416hF m1973a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0416hF c0416hF = new C0416hF(C0417hG.m1976a(friendlyByteBuf));
        c0416hF.m1968a(friendlyByteBuf.readFloat());
        return c0416hF;
    }

    /* JADX INFO: renamed from: b */
    public void m1974b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f2643a.m1975b(friendlyByteBuf);
        friendlyByteBuf.writeFloat(this.f2649aB);
    }
}
