package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eK.class */
public abstract class eK extends AbstractC0153fq {
    protected abstract float b();

    protected abstract float v();

    protected eK(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.quadSize = 0.1f;
        this.eA = 0.1f;
        this.lifetime = 3;
        this.alpha = b();
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        setSize(0.001f, 0.001f);
    }

    @Override // com.boehmod.blockfront.eM
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo
    /* JADX INFO: renamed from: a */
    public int mo370a(float f) {
        return super.a(f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.quadSize += v();
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.c;
    }
}
