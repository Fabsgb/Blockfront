package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eK.class */
public abstract class AbstractC0262eK extends AbstractC0347fq {
    /* JADX INFO: renamed from: b */
    protected abstract float mo1449b();

    /* JADX INFO: renamed from: v */
    protected abstract float mo1450v();

    protected AbstractC0262eK(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.quadSize = 0.1f;
        this.f2089eA = 0.1f;
        this.lifetime = 3;
        this.alpha = mo1449b();
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        setSize(0.001f, 0.001f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    protected int getLightColor(float f) {
        return 15728880;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo
    /* JADX INFO: renamed from: a */
    public int mo1451a(float f) {
        return super.mo1458a(f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.tick();
        this.quadSize += mo1450v();
        int i = this.age;
        this.age = i + 1;
        if (i >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2337c;
    }
}
