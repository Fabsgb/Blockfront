package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.eM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eM.class */
public abstract class AbstractC0264eM extends TextureSheetParticle implements InterfaceC0345fo {

    /* JADX INFO: renamed from: ir */
    private static final int f2086ir = 5;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BlockPos.MutableBlockPos f2087a;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Vector3d f2088d;

    /* JADX INFO: renamed from: eA */
    protected float f2089eA;

    /* JADX INFO: renamed from: is */
    private int f2090is;

    /* JADX INFO: renamed from: it */
    private int f2091it;

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract InterfaceC0316fL mo1452a();

    public AbstractC0264eM(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6);
        this.f2087a = new BlockPos.MutableBlockPos();
        this.f2088d = new Vector3d();
        this.f2090is = 0;
        this.f2091it = ColorReferences.COLOR_WHITE;
        pickSprite(spriteSet);
    }

    /* JADX INFO: renamed from: ax */
    public void m1455ax() {
        m1456ay();
        super.tick();
    }

    /* JADX INFO: renamed from: ay */
    private void m1456ay() {
        this.f2089eA = this.quadSize;
        if (this.age % 5 == 0) {
            m1463aA();
        }
        m1462az();
    }

    protected int getLightColor(float f) {
        return this.f2090is;
    }

    public void tick() {
        m1456ay();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.age++;
    }

    @Override // com.boehmod.blockfront.InterfaceC0345fo
    /* JADX INFO: renamed from: M */
    public boolean mo1457M() {
        tick();
        return this.removed;
    }

    @Override // com.boehmod.blockfront.InterfaceC0345fo
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1458a(float f) {
        return this.f2088d.set(Mth.lerp(f, this.xo, this.x), Mth.lerp(f, this.yo, this.y), Mth.lerp(f, this.zo, this.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0345fo
    /* JADX INFO: renamed from: l */
    public float mo1459l(float f) {
        return getQuadSize(f);
    }

    /* JADX INFO: renamed from: a */
    public int mo1451a(float f) {
        return this.f2091it;
    }

    @Override // com.boehmod.blockfront.InterfaceC0345fo
    @NotNull
    /* JADX INFO: renamed from: a */
    public TextureAtlasSprite mo1460a(float f) {
        return this.sprite;
    }

    public float getQuadSize(float f) {
        return Mth.lerp(f, this.f2089eA, this.quadSize);
    }

    @Override // com.boehmod.blockfront.InterfaceC0345fo
    /* JADX INFO: renamed from: b */
    public int mo1461b(float f) {
        return getLightColor(f);
    }

    /* JADX INFO: renamed from: az */
    protected void m1462az() {
        this.f2091it = FastColor.ARGB32.colorFromFloat(this.alpha, this.rCol, this.gCol, this.bCol);
    }

    /* JADX INFO: renamed from: aA */
    private void m1463aA() {
        int iFloor = Mth.floor(this.x);
        int iFloor2 = Mth.floor(this.y);
        int iFloor3 = Mth.floor(this.z);
        if (this.f2087a.getX() != iFloor || this.f2087a.getY() != iFloor2 || this.f2087a.getZ() != iFloor3) {
            this.f2087a.set(iFloor, iFloor2, iFloor3);
            this.f2090is = this.level.hasChunkAt(this.f2087a) ? LevelRenderer.getLightColor(this.level, this.f2087a) : 0;
        }
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
