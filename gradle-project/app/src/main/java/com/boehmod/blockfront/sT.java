package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sT.class */
public class sT extends sS {
    private static final int rk = 80;
    private static final int rl = 16;

    @NotNull
    private static final ResourceLocation fp = C0265jv.d("textures/misc/ping/regular.png");

    @NotNull
    private static final ResourceLocation fq = C0265jv.d("textures/misc/ping/regular_warning.png");

    @NotNull
    private static final ResourceLocation fr = C0265jv.d("textures/misc/ping/regular_warning_flipped.png");
    private boolean hk;
    private boolean hl;
    private boolean hm;
    private int rm;
    private boolean hn;

    public sT(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        super(uuid, uuid2, vec3);
        this.hk = false;
        this.hl = false;
        this.hm = false;
        this.rm = 0;
        this.hn = false;
    }

    public void R(boolean z) {
        this.hl = z;
    }

    @Override // com.boehmod.blockfront.sS
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oG<?, ?> oGVar) {
        if (!this.hk) {
            this.hk = true;
            m1089a(minecraft, c0297l, oGVar);
        }
        if (this.hl) {
            if (!this.hn) {
                this.hn = true;
                b(minecraft, c0297l, oGVar);
            }
            int i = this.rm;
            this.rm = i + 1;
            if (i >= 5) {
                this.hm = !this.hm;
                this.rm = 0;
            }
        }
        return super.a(minecraft, c0297l, oGVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m1089a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, oG<?, ?> oGVar) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C0624xc.pG.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    private void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, oG<?, ?> oGVar) {
        if (minecraft.level == null) {
            return;
        }
        Vec3 vec3C = c();
        minecraft.level.playLocalSound(vec3C.x, vec3C.y, vec3C.z, (SoundEvent) C0624xc.pH.get(), SoundSource.MASTER, 15.0f, 1.0f, false);
    }

    @Override // com.boehmod.blockfront.sS
    @NotNull
    public ResourceLocation getIcon() {
        if (this.hl) {
            return this.hm ? fq : fr;
        }
        return fp;
    }

    @Override // com.boehmod.blockfront.sS
    public int bL() {
        return 80;
    }

    @Override // com.boehmod.blockfront.sS
    public int bM() {
        return 16;
    }

    @Override // com.boehmod.blockfront.sS
    public int a(@NotNull oG<?, ?> oGVar, float f) {
        if (this.hl) {
            return this.hm ? ColorReferences.COLOR_THEME_RED_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.sS
    protected void cU() {
        R(true);
    }
}
