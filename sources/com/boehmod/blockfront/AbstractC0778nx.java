package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec2;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nx.class */
public abstract class AbstractC0778nx<V extends AbstractC0779ny> {

    /* JADX INFO: renamed from: fb */
    public boolean f4148fb;

    /* JADX INFO: renamed from: fc */
    public boolean f4149fc;

    /* JADX INFO: renamed from: fd */
    public boolean f4150fd;

    /* JADX INFO: renamed from: fe */
    public boolean f4151fe;

    /* JADX INFO: renamed from: ff */
    public boolean f4152ff;

    /* JADX INFO: renamed from: fg */
    public boolean f4153fg;

    /* JADX INFO: renamed from: jf */
    private float f4154jf;

    /* JADX INFO: renamed from: jh */
    private float f4156jh;

    /* JADX INFO: renamed from: jj */
    private float f4158jj;

    /* JADX INFO: renamed from: jl */
    private float f4160jl;

    /* JADX INFO: renamed from: lY */
    public int f4145lY = 0;

    /* JADX INFO: renamed from: jd */
    public float f4146jd = 0.0f;

    /* JADX INFO: renamed from: je */
    public float f4147je = 0.0f;

    /* JADX INFO: renamed from: jg */
    private float f4155jg = 0.0f;

    /* JADX INFO: renamed from: ji */
    private float f4157ji = 0.0f;

    /* JADX INFO: renamed from: jk */
    private float f4159jk = 0.0f;

    /* JADX INFO: renamed from: jm */
    private float f4161jm = 0.0f;

    /* JADX INFO: renamed from: c */
    public abstract void mo3356c(@NotNull V v);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Vec2 mo3357a(@NotNull V v);

    @NotNull
    /* JADX INFO: renamed from: b */
    public abstract Vec2 mo3358b(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3359a(@NotNull V v, boolean z);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3360a(@NotNull V v, @NotNull LocalPlayer localPlayer);

    /* JADX INFO: renamed from: a */
    public abstract float mo3361a(@NotNull C0733nE<?> c0733nE);

    /* JADX INFO: renamed from: r */
    public float m3486r(float f) {
        return C1290xm.m7843e(this.f4158jj, this.f4159jk, f);
    }

    /* JADX INFO: renamed from: s */
    public float m3487s(float f) {
        return C1290xm.m7843e(this.f4160jl, this.f4161jm, f);
    }

    /* JADX INFO: renamed from: t */
    public float m3488t(float f) {
        return C1290xm.m7843e(this.f4154jf, this.f4155jg, f);
    }

    /* JADX INFO: renamed from: u */
    public float m3489u(float f) {
        return C1290xm.m7843e(this.f4156jh, this.f4157ji, f);
    }

    /* JADX INFO: renamed from: b */
    public void m3490b(@NotNull V v) {
        if (v.level().isClientSide()) {
            Vec2 vec2Mo3358b = mo3358b((AbstractC0779ny) v);
            this.f4159jk = this.f4158jj;
            this.f4161jm = this.f4160jl;
            this.f4158jj -= vec2Mo3358b.x;
            this.f4160jl += vec2Mo3358b.y;
            Vec2 vec2Mo3357a = mo3357a(v);
            this.f4155jg = this.f4154jf;
            this.f4157ji = this.f4156jh;
            this.f4154jf = vec2Mo3357a.x;
            this.f4156jh = vec2Mo3357a.y;
        }
        mo3356c(v);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3491a(@NotNull LocalPlayer localPlayer, @NotNull V v, boolean z) {
        if (z) {
            m3492k(localPlayer);
            mo3360a(v, localPlayer);
        }
        mo3359a(v, z);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: k */
    public void m3492k(@NotNull LocalPlayer localPlayer) {
        Input input = localPlayer.input;
        Minecraft minecraft = Minecraft.getInstance();
        this.f4150fd = input.left;
        this.f4151fe = input.right;
        this.f4148fb = input.up;
        this.f4149fc = input.down;
        this.f4152ff = minecraft.options.keySprint.isDown();
        this.f4153fg = input.jumping;
        int i = this.f4145lY;
        this.f4145lY = i + 1;
        if (i >= 5) {
            this.f4145lY = 0;
            C1194vo.m6653c(new C1233wa(this.f4148fb, this.f4149fc, this.f4150fd, this.f4151fe, this.f4152ff, this.f4153fg, this.f4146jd));
        }
    }
}
