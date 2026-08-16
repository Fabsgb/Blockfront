package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gs.class */
public final class C0403gs {

    /* JADX INFO: renamed from: ff */
    private static final float f2601ff = 12.0f;

    /* JADX INFO: renamed from: fg */
    private static final float f2602fg = 2.5f;

    /* JADX INFO: renamed from: fh */
    private static final float f2603fh = 7.525f;

    /* JADX INFO: renamed from: fi */
    private static final float f2604fi = 10.0f;

    /* JADX INFO: renamed from: fj */
    private static final float f2605fj = 100.0f;

    /* JADX INFO: renamed from: fk */
    private static final float f2606fk = 0.4f;

    /* JADX INFO: renamed from: fl */
    public static final float f2607fl = 0.5f;

    /* JADX INFO: renamed from: fm */
    public static final float f2608fm = 10.0f;

    /* JADX INFO: renamed from: fn */
    public static final float f2609fn = 15.0f;

    /* JADX INFO: renamed from: fo */
    public static final float f2610fo = 0.05f;

    /* JADX INFO: renamed from: fp */
    private static final float f2611fp = 0.3f;

    /* JADX INFO: renamed from: fq */
    private static final float f2612fq = 0.5f;

    /* JADX INFO: renamed from: fr */
    private static final float f2613fr = 0.4f;

    /* JADX INFO: renamed from: fs */
    private static final float f2614fs = 2.5f;

    /* JADX INFO: renamed from: b */
    @Nullable
    private static SoundInstance f2615b = null;

    /* JADX INFO: renamed from: ft */
    private final float f2616ft;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Vec3 f2617m;

    /* JADX INFO: renamed from: fu */
    private final float f2618fu;

    /* JADX INFO: renamed from: fv */
    private final float f2619fv;

    /* JADX INFO: renamed from: ki */
    private final int f2620ki;

    /* JADX INFO: renamed from: cz */
    private boolean f2621cz;

    /* JADX INFO: renamed from: cA */
    private final boolean f2622cA;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Vec3 f2623n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private Vec3 f2624o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private Vec3 f2625p;

    /* JADX INFO: renamed from: kj */
    private int f2626kj;

    /* JADX INFO: renamed from: cB */
    private boolean f2627cB;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Holder<Item> f2628a;

    public C0403gs(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f, float f2, int i) {
        this.f2621cz = false;
        this.f2627cB = false;
        this.f2628a = holder;
        this.f2623n = vec3;
        this.f2624o = vec3;
        this.f2625p = vec3;
        this.f2617m = vec4;
        this.f2618fu = f;
        this.f2619fv = f2;
        this.f2620ki = i;
        this.f2616ft = (float) vec3.distanceTo(this.f2617m);
        this.f2622cA = this.f2616ft >= 128.0f;
    }

    public C0403gs(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        this(holder, vec3, vec4, 2.5f, f2603fh, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0403gs(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f) {
        this(holder, vec3, vec4, f, f2603fh, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0403gs(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec4, int i) {
        this(holder, vec3, vec4, 2.5f, f2603fh, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0403gs m1912a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new C0403gs(C1271xK.m7198a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readInt());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0403gs m1913a() {
        this.f2627cB = true;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean m1914a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        this.f2625p = this.f2624o;
        this.f2624o = C1270xJ.m7163a(this.f2624o, this.f2617m, this.f2619fv);
        this.f2626kj++;
        if (!this.f2627cB) {
            m1916a(minecraft, c0623l, localPlayer, clientLevel, random);
        }
        return m1915R();
    }

    /* JADX INFO: renamed from: R */
    public boolean m1915R() {
        return m1926r() >= 1.0f || this.f2626kj >= 60;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m1916a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        SoundManager soundManager = minecraft.getSoundManager();
        float fSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.f2624o));
        if (fSqrt <= 12.0f && !this.f2621cz) {
            this.f2621cz = true;
            if (this.f2624o.distanceToSqr(this.f2617m) > 100.0d) {
                C0116bg.f796ch += 0.05f;
                m1917a(localPlayer, fSqrt);
                if (random.nextFloat() < 0.4f) {
                    m1918a(c0623l, clientLevel, soundManager, random);
                }
            }
            Object objValue = this.f2628a.value();
            if (objValue instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) objValue;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6866X = c1117uP.m6384a(new ItemStack(c1117uP)).m6866X();
                if (deferredHolderM6866X != null) {
                    soundManager.play(new C0510it(this, (SoundEvent) deferredHolderM6866X.get(), SoundSource.AMBIENT, 0.9f + (0.2f * random.nextFloat()), 10.0f));
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m1917a(@NotNull LocalPlayer localPlayer, float f) {
        C0433hV c0433hVM1994a = new C0433hV(C0435hX.f2787K).m1993a(0.3f + (0.5f * (1.0f - (f / 12.0f)))).m1994a(0.4f, 2.5f);
        C0432hU.m1990a(c0433hVM1994a, localPlayer, this.f2624o);
        C0432hU.m1988a(c0433hVM1994a);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m1918a(@NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) ((DeferredHolder) C1267xG.m7152a((List) C1312xz.f7912al)).get();
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(this.f2624o.x, this.f2624o.y, this.f2624o.z, soundEvent, SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = (c0623l.m2869a().m2289O() > 0.4f ? 1 : (c0623l.m2869a().m2289O() == 0.4f ? 0 : -1)) <= 0 ? C1312xz.f8255uQ : C1312xz.f8256uR;
        if (f2615b != null) {
            soundManager.stop(f2615b);
        }
        f2615b = SimpleSoundInstance.forLocalAmbience((SoundEvent) deferredHolder.get(), 0.9f + (0.2f * random.nextFloat()), 0.5f);
        soundManager.play(f2615b);
    }

    /* JADX INFO: renamed from: a */
    public void m1919a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1271xK.m7199a(registryFriendlyByteBuf, this.f2628a);
        registryFriendlyByteBuf.writeVec3(this.f2623n);
        registryFriendlyByteBuf.writeVec3(this.f2617m);
        registryFriendlyByteBuf.writeFloat(this.f2618fu);
        registryFriendlyByteBuf.writeFloat(this.f2619fv);
        registryFriendlyByteBuf.writeInt(this.f2620ki);
    }

    public int getColor() {
        return this.f2620ki;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 m1920a(float f) {
        return C1270xJ.m7172b(this.f2624o, this.f2625p, f);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m1921c() {
        return this.f2624o;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Vec3 m1922d() {
        return this.f2625p;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public Vec3 m1923e() {
        return this.f2624o.subtract(this.f2625p);
    }

    /* JADX INFO: renamed from: A */
    public float m1924A() {
        return this.f2618fu;
    }

    /* JADX INFO: renamed from: S */
    public boolean m1925S() {
        return this.f2622cA;
    }

    /* JADX INFO: renamed from: r */
    public float m1926r() {
        return 1.0f - (((float) this.f2624o.distanceTo(this.f2617m)) / this.f2616ft);
    }
}
