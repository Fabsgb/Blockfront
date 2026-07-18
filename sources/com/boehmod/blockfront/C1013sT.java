package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sT.class */
public class C1013sT extends AbstractC1012sS {

    /* JADX INFO: renamed from: rk */
    private static final int f5306rk = 80;

    /* JADX INFO: renamed from: rl */
    private static final int f5307rl = 16;

    /* JADX INFO: renamed from: fp */
    @NotNull
    private static final ResourceLocation f5308fp = C0564jv.m2555d("textures/misc/ping/regular.png");

    /* JADX INFO: renamed from: fq */
    @NotNull
    private static final ResourceLocation f5309fq = C0564jv.m2555d("textures/misc/ping/regular_warning.png");

    /* JADX INFO: renamed from: fr */
    @NotNull
    private static final ResourceLocation f5310fr = C0564jv.m2555d("textures/misc/ping/regular_warning_flipped.png");

    /* JADX INFO: renamed from: hk */
    private boolean f5311hk;

    /* JADX INFO: renamed from: hl */
    private boolean f5312hl;

    /* JADX INFO: renamed from: hm */
    private boolean f5313hm;

    /* JADX INFO: renamed from: rm */
    private int f5314rm;

    /* JADX INFO: renamed from: hn */
    private boolean f5315hn;

    public C1013sT(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        super(uuid, uuid2, vec3);
        this.f5311hk = false;
        this.f5312hl = false;
        this.f5313hm = false;
        this.f5314rm = 0;
        this.f5315hn = false;
    }

    /* JADX INFO: renamed from: R */
    public void m5494R(boolean z) {
        this.f5312hl = z;
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    /* JADX INFO: renamed from: a */
    public boolean mo5485a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0788oG<?, ?> abstractC0788oG) {
        if (!this.f5311hk) {
            this.f5311hk = true;
            m5495a(minecraft, c0622l, abstractC0788oG);
        }
        if (this.f5312hl) {
            if (!this.f5315hn) {
                this.f5315hn = true;
                m5496b(minecraft, c0622l, abstractC0788oG);
            }
            int i = this.f5314rm;
            this.f5314rm = i + 1;
            if (i >= 5) {
                this.f5313hm = !this.f5313hm;
                this.f5314rm = 0;
            }
        }
        return super.mo5485a(minecraft, c0622l, abstractC0788oG);
    }

    /* JADX INFO: renamed from: a */
    private void m5495a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, AbstractC0788oG<?, ?> abstractC0788oG) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = m5484c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C1280xc.f7575pG.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    /* JADX INFO: renamed from: b */
    private void m5496b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, AbstractC0788oG<?, ?> abstractC0788oG) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = m5484c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C1280xc.f7576pH.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    @NotNull
    public ResourceLocation getIcon() {
        if (this.f5312hl) {
            return this.f5313hm ? f5309fq : f5310fr;
        }
        return f5308fp;
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    /* JADX INFO: renamed from: bL */
    public int mo5488bL() {
        return 80;
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    /* JADX INFO: renamed from: bM */
    public int mo5489bM() {
        return 16;
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    /* JADX INFO: renamed from: a */
    public int mo5490a(@NotNull AbstractC0788oG<?, ?> abstractC0788oG, float f) {
        if (this.f5312hl) {
            return this.f5313hm ? ColorReferences.COLOR_THEME_RED_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.AbstractC1012sS
    /* JADX INFO: renamed from: cU */
    protected void mo5492cU() {
        m5494R(true);
    }
}
