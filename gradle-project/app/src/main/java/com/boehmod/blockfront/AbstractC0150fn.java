package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fn.class */
public abstract class AbstractC0150fn extends fD {
    protected final float eT;

    public abstract float w();

    protected AbstractC0150fn(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.eT = (float) Math.random();
        setSize(0.05f, 0.05f);
        setParticleSpeed(d4, d5, d6);
        this.quadSize = 0.5f + this.eT;
        this.eA = this.quadSize;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        if (this.alpha <= 0.0f) {
            remove();
            return;
        }
        this.alpha = C0634xm.d(this.alpha, 0.0f, w());
        if (this.age > 5) {
            this.quadSize = Mth.lerp(0.02f, this.quadSize, 2.0f + this.eT);
        }
        this.xd = Mth.lerp(0.30000001192092896d, this.xd, 0.0d);
        this.yd = Mth.lerp(0.30000001192092896d, this.yd, 0.0d);
        this.zd = Mth.lerp(0.30000001192092896d, this.zd, 0.0d);
        setPos(this.x + this.xd, this.y + this.yd, this.z + this.zd);
    }
}
