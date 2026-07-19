package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/J.class */
public class J extends K {
    private final int K;
    private final int L;
    private final int M;

    @NotNull
    private final SimpleParticleType a;
    private int N = 0;
    private int O = 0;

    public J(int i, int i2, int i3, @NotNull SimpleParticleType simpleParticleType) {
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.a = simpleParticleType;
    }

    @Override // com.boehmod.blockfront.K
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull G g, @NotNull Vector3dc vector3dc) {
        int i = this.O;
        this.O = i + 1;
        if (i >= this.L) {
            this.O = 0;
            for (int i2 = 0; i2 < this.M; i2++) {
                iG.a(minecraft, c0297l, clientLevel, this.a, vector3dc.x(), vector3dc.y(), vector3dc.z(), 0.0d, 0.0d, 0.0d);
            }
        }
        int i3 = this.N;
        this.N = i3 + 1;
        return i3 >= this.K;
    }
}
