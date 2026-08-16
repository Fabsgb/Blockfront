package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tq.class */
public class C1091tq extends AbstractC1090tp {

    /* JADX INFO: renamed from: tl */
    private static final int f5870tl = 80;

    /* JADX INFO: renamed from: tm */
    private static final int f5871tm = 16;

    /* JADX INFO: renamed from: fo */
    @NotNull
    private static final ResourceLocation f5872fo = C0532jO.m2378d("textures/misc/ping/regular.png");

    /* JADX INFO: renamed from: fp */
    @NotNull
    private static final ResourceLocation f5873fp = C0532jO.m2378d("textures/misc/ping/regular_warning.png");

    /* JADX INFO: renamed from: fq */
    @NotNull
    private static final ResourceLocation f5874fq = C0532jO.m2378d("textures/misc/ping/regular_warning_flipped.png");

    /* JADX INFO: renamed from: hE */
    private boolean f5875hE;

    /* JADX INFO: renamed from: hF */
    private boolean f5876hF;

    /* JADX INFO: renamed from: hG */
    private boolean f5877hG;

    /* JADX INFO: renamed from: tn */
    private int f5878tn;

    /* JADX INFO: renamed from: hH */
    private boolean f5879hH;

    public C1091tq(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        super(uuid, uuid2, vec3);
        this.f5875hE = false;
        this.f5876hF = false;
        this.f5877hG = false;
        this.f5878tn = 0;
        this.f5879hH = false;
    }

    /* JADX INFO: renamed from: S */
    public void m5982S(boolean z) {
        this.f5876hF = z;
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    /* JADX INFO: renamed from: a */
    public boolean mo5973a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0864pc<?, ?> abstractC0864pc) {
        if (!this.f5875hE) {
            this.f5875hE = true;
            m5983a(minecraft, c0623l, abstractC0864pc);
        }
        if (this.f5876hF) {
            if (!this.f5879hH) {
                this.f5879hH = true;
                m5984b(minecraft, c0623l, abstractC0864pc);
            }
            int i = this.f5878tn;
            this.f5878tn = i + 1;
            if (i >= 5) {
                this.f5877hG = !this.f5877hG;
                this.f5878tn = 0;
            }
        }
        return super.mo5973a(minecraft, c0623l, abstractC0864pc);
    }

    /* JADX INFO: renamed from: a */
    private void m5983a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, AbstractC0864pc<?, ?> abstractC0864pc) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = m5972c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C1312xz.f7987pI.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    /* JADX INFO: renamed from: b */
    private void m5984b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, AbstractC0864pc<?, ?> abstractC0864pc) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = m5972c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C1312xz.f7988pJ.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    @NotNull
    public ResourceLocation getIcon() {
        if (this.f5876hF) {
            return this.f5877hG ? f5873fp : f5874fq;
        }
        return f5872fo;
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    /* JADX INFO: renamed from: ca */
    public int mo5976ca() {
        return 80;
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    /* JADX INFO: renamed from: cb */
    public int mo5977cb() {
        return 16;
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    /* JADX INFO: renamed from: a */
    public int mo5978a(@NotNull AbstractC0864pc<?, ?> abstractC0864pc, float f) {
        if (this.f5876hF) {
            return this.f5877hG ? ColorReferences.COLOR_THEME_RED_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.AbstractC1090tp
    /* JADX INFO: renamed from: dg */
    protected void mo5980dg() {
        m5982S(true);
    }
}
