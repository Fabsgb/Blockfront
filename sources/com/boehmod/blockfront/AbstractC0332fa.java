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

/* JADX INFO: renamed from: com.boehmod.blockfront.fa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fa.class */
public abstract class AbstractC0332fa extends TextureSheetParticle implements InterfaceC0310fE {

    /* JADX INFO: renamed from: jL */
    private static final int f2437jL = 5;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final BlockPos.MutableBlockPos f2438b;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Vector3d f2439d;

    /* JADX INFO: renamed from: eD */
    protected float f2440eD;

    /* JADX INFO: renamed from: jM */
    private int f2441jM;

    /* JADX INFO: renamed from: jN */
    private int f2442jN;

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract InterfaceC0386gb mo1545a();

    public AbstractC0332fa(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6);
        this.f2438b = new BlockPos.MutableBlockPos();
        this.f2439d = new Vector3d();
        this.f2441jM = 0;
        this.f2442jN = ColorReferences.COLOR_WHITE;
        pickSprite(spriteSet);
    }

    /* JADX INFO: renamed from: aD */
    public void m1693aD() {
        m1694aE();
        super.tick();
    }

    /* JADX INFO: renamed from: aE */
    private void m1694aE() {
        this.f2440eD = this.quadSize;
        if (this.age % 5 == 0) {
            m1696aG();
        }
        m1695aF();
    }

    protected int getLightColor(float f) {
        return this.f2441jM;
    }

    public void tick() {
        m1694aE();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.age++;
    }

    @Override // com.boehmod.blockfront.InterfaceC0310fE
    /* JADX INFO: renamed from: O */
    public boolean mo1660O() {
        tick();
        return this.removed;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1657a(float f) {
        return this.f2439d.set(Mth.lerp(f, this.xo, this.x), Mth.lerp(f, this.yo, this.y), Mth.lerp(f, this.zo, this.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0310fE
    /* JADX INFO: renamed from: k */
    public float mo1661k(float f) {
        return getQuadSize(f);
    }

    /* JADX INFO: renamed from: b */
    public int mo1544b(float f) {
        return this.f2442jN;
    }

    @Override // com.boehmod.blockfront.InterfaceC0310fE
    @NotNull
    /* JADX INFO: renamed from: a */
    public TextureAtlasSprite mo1662a(float f) {
        return this.sprite;
    }

    public float getQuadSize(float f) {
        return Mth.lerp(f, this.f2440eD, this.quadSize);
    }

    @Override // com.boehmod.blockfront.InterfaceC0310fE
    /* JADX INFO: renamed from: c */
    public int mo1663c(float f) {
        return getLightColor(f);
    }

    /* JADX INFO: renamed from: aF */
    protected void m1695aF() {
        this.f2442jN = FastColor.ARGB32.colorFromFloat(this.alpha, this.rCol, this.gCol, this.bCol);
    }

    /* JADX INFO: renamed from: aG */
    private void m1696aG() {
        int iFloor = Mth.floor(this.x);
        int iFloor2 = Mth.floor(this.y);
        int iFloor3 = Mth.floor(this.z);
        if (this.f2438b.getX() != iFloor || this.f2438b.getY() != iFloor2 || this.f2438b.getZ() != iFloor3) {
            this.f2438b.set(iFloor, iFloor2, iFloor3);
            this.f2441jM = this.level.hasChunkAt(this.f2438b) ? LevelRenderer.getLightColor(this.level, this.f2438b) : 0;
        }
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
