package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.J */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/J.class */
public class C0012J extends AbstractC0013K {

    /* JADX INFO: renamed from: K */
    private final int f189K;

    /* JADX INFO: renamed from: L */
    private final int f190L;

    /* JADX INFO: renamed from: M */
    private final int f191M;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final SimpleParticleType f192a;

    /* JADX INFO: renamed from: N */
    private int f193N = 0;

    /* JADX INFO: renamed from: O */
    private int f194O = 0;

    public C0012J(int i, int i2, int i3, @NotNull SimpleParticleType simpleParticleType) {
        this.f189K = i;
        this.f190L = i2;
        this.f191M = i3;
        this.f192a = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.AbstractC0013K
    /* JADX INFO: renamed from: a */
    public boolean mo63a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull C0009G c0009g, @NotNull Vector3dc vector3dc) {
        int i = this.f194O;
        this.f194O = i + 1;
        if (i >= this.f190L) {
            this.f194O = 0;
            for (int i2 = 0; i2 < this.f191M; i2++) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, this.f192a, vector3dc.x(), vector3dc.y(), vector3dc.z(), 0.0d, 0.0d, 0.0d);
            }
        }
        int i3 = this.f193N;
        this.f193N = i3 + 1;
        return i3 >= this.f189K;
    }
}
