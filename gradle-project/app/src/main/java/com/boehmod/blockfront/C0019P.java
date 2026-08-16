package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.P */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/P.class */
public class C0019P extends AbstractC0020Q {

    /* JADX INFO: renamed from: ay */
    private final int f232ay;

    /* JADX INFO: renamed from: az */
    private final int f233az;

    /* JADX INFO: renamed from: aA */
    private final int f234aA;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final SimpleParticleType f235a;

    /* JADX INFO: renamed from: aB */
    private int f236aB = 0;

    /* JADX INFO: renamed from: aC */
    private int f237aC = 0;

    public C0019P(int i, int i2, int i3, @NotNull SimpleParticleType simpleParticleType) {
        this.f232ay = i;
        this.f233az = i2;
        this.f234aA = i3;
        this.f235a = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.AbstractC0020Q
    /* JADX INFO: renamed from: a */
    public boolean mo96a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull C0016M c0016m, @NotNull Vector3dc vector3dc) {
        int i = this.f237aC;
        this.f237aC = i + 1;
        if (i >= this.f233az) {
            this.f237aC = 0;
            for (int i2 = 0; i2 < this.f234aA; i2++) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, this.f235a, vector3dc.x(), vector3dc.y(), vector3dc.z(), 0.0d, 0.0d, 0.0d);
            }
        }
        int i3 = this.f236aB;
        this.f236aB = i3 + 1;
        return i3 >= this.f232ay;
    }
}
