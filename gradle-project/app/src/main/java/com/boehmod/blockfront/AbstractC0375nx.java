package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec2;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nx.class */
public abstract class AbstractC0375nx<V extends AbstractC0376ny> {
    public boolean fb;
    public boolean fc;
    public boolean fd;
    public boolean fe;
    public boolean ff;
    public boolean fg;
    private float jf;
    private float jh;
    private float jj;
    private float jl;
    public int lY = 0;
    public float jd = 0.0f;
    public float je = 0.0f;
    private float jg = 0.0f;
    private float ji = 0.0f;
    private float jk = 0.0f;
    private float jm = 0.0f;

    public abstract void c(@NotNull V v);

    @NotNull
    public abstract Vec2 a(@NotNull V v);

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public abstract Vec2 mo737b(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull V v, boolean z);

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull V v, @NotNull LocalPlayer localPlayer);

    public abstract float a(@NotNull nE<?> nEVar);

    public float r(float f) {
        return C0634xm.e(this.jj, this.jk, f);
    }

    public float s(float f) {
        return C0634xm.e(this.jl, this.jm, f);
    }

    public float t(float f) {
        return C0634xm.e(this.jf, this.jg, f);
    }

    public float u(float f) {
        return C0634xm.e(this.jh, this.ji, f);
    }

    public void b(@NotNull V v) {
        if (v.level().isClientSide()) {
            Vec2 vec2Mo737b = mo737b((AbstractC0376ny) v);
            this.jk = this.jj;
            this.jm = this.jl;
            this.jj -= vec2Mo737b.x;
            this.jl += vec2Mo737b.y;
            Vec2 vec2A = a(v);
            this.jg = this.jf;
            this.ji = this.jh;
            this.jf = vec2A.x;
            this.jh = vec2A.y;
        }
        c(v);
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull LocalPlayer localPlayer, @NotNull V v, boolean z) {
        if (z) {
            k(localPlayer);
            a(v, localPlayer);
        }
        a(v, z);
    }

    @OnlyIn(Dist.CLIENT)
    public void k(@NotNull LocalPlayer localPlayer) {
        Input input = localPlayer.input;
        Minecraft minecraft = Minecraft.getInstance();
        this.fd = input.left;
        this.fe = input.right;
        this.fb = input.up;
        this.fc = input.down;
        this.ff = minecraft.options.keySprint.isDown();
        this.fg = input.jumping;
        int i = this.lY;
        this.lY = i + 1;
        if (i >= 5) {
            this.lY = 0;
            C0582vo.c(new C0595wa(this.fb, this.fc, this.fd, this.fe, this.ff, this.fg, this.jd));
        }
    }
}
