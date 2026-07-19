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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eM.class */
public abstract class eM extends TextureSheetParticle implements InterfaceC0151fo {
    private static final int ir = 5;

    @NotNull
    private final BlockPos.MutableBlockPos a;

    @NotNull
    private final Vector3d d;
    protected float eA;
    private int is;
    private int it;

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract fL mo372a();

    public eM(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6);
        this.a = new BlockPos.MutableBlockPos();
        this.d = new Vector3d();
        this.is = 0;
        this.it = ColorReferences.COLOR_WHITE;
        pickSprite(spriteSet);
    }

    public void ax() {
        ay();
        super.tick();
    }

    private void ay() {
        this.eA = this.quadSize;
        if (this.age % 5 == 0) {
            aA();
        }
        az();
    }

    protected int getLightColor(float f) {
        return this.is;
    }

    public void tick() {
        ay();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.age++;
    }

    @Override // com.boehmod.blockfront.InterfaceC0151fo
    public boolean M() {
        tick();
        return this.removed;
    }

    @Override // com.boehmod.blockfront.InterfaceC0151fo
    @NotNull
    public Vector3dc a(float f) {
        return this.d.set(Mth.lerp(f, this.xo, this.x), Mth.lerp(f, this.yo, this.y), Mth.lerp(f, this.zo, this.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0151fo
    public float l(float f) {
        return getQuadSize(f);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int mo370a(float f) {
        return this.it;
    }

    @Override // com.boehmod.blockfront.InterfaceC0151fo
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public TextureAtlasSprite mo371a(float f) {
        return this.sprite;
    }

    public float getQuadSize(float f) {
        return Mth.lerp(f, this.eA, this.quadSize);
    }

    @Override // com.boehmod.blockfront.InterfaceC0151fo
    public int b(float f) {
        return getLightColor(f);
    }

    protected void az() {
        this.it = FastColor.ARGB32.colorFromFloat(this.alpha, this.rCol, this.gCol, this.bCol);
    }

    private void aA() {
        int iFloor = Mth.floor(this.x);
        int iFloor2 = Mth.floor(this.y);
        int iFloor3 = Mth.floor(this.z);
        if (this.a.getX() != iFloor || this.a.getY() != iFloor2 || this.a.getZ() != iFloor3) {
            this.a.set(iFloor, iFloor2, iFloor3);
            this.is = this.level.hasChunkAt(this.a) ? LevelRenderer.getLightColor(this.level, this.a) : 0;
        }
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
