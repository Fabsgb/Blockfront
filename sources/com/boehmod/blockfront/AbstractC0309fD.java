package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fD.class */
public abstract class AbstractC0309fD extends C0325fT {

    /* JADX INFO: renamed from: eW */
    protected final float f2397eW;

    /* JADX INFO: renamed from: w */
    public abstract float mo1659w();

    protected AbstractC0309fD(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2397eW = (float) Math.random();
        setSize(0.05f, 0.05f);
        setParticleSpeed(d4, d5, d6);
        this.quadSize = 0.5f + this.f2397eW;
        this.f2440eD = this.quadSize;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        if (this.alpha <= 0.0f) {
            remove();
            return;
        }
        this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, mo1659w());
        if (this.age > 5) {
            this.quadSize = Mth.lerp(0.02f, this.quadSize, 2.0f + this.f2397eW);
        }
        this.xd = Mth.lerp(0.30000001192092896d, this.xd, 0.0d);
        this.yd = Mth.lerp(0.30000001192092896d, this.yd, 0.0d);
        this.zd = Mth.lerp(0.30000001192092896d, this.zd, 0.0d);
        setPos(this.x + this.xd, this.y + this.yd, this.z + this.zd);
    }
}
