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

/* JADX INFO: renamed from: com.boehmod.blockfront.gc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gc.class */
public final class C0386gc {

    /* JADX INFO: renamed from: eZ */
    private static final float f2546eZ = 12.0f;

    /* JADX INFO: renamed from: fa */
    private static final float f2547fa = 2.5f;

    /* JADX INFO: renamed from: fb */
    private static final float f2548fb = 7.525f;

    /* JADX INFO: renamed from: fc */
    private static final float f2549fc = 10.0f;

    /* JADX INFO: renamed from: fd */
    private static final float f2550fd = 100.0f;

    /* JADX INFO: renamed from: fe */
    private static final float f2551fe = 0.4f;

    /* JADX INFO: renamed from: ff */
    public static final float f2552ff = 0.5f;

    /* JADX INFO: renamed from: fg */
    public static final float f2553fg = 10.0f;

    /* JADX INFO: renamed from: fh */
    public static final float f2554fh = 15.0f;

    /* JADX INFO: renamed from: fi */
    public static final float f2555fi = 0.05f;

    /* JADX INFO: renamed from: b */
    @Nullable
    private static SoundInstance f2556b = null;

    /* JADX INFO: renamed from: fj */
    private final float f2557fj;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Vec3 f2558m;

    /* JADX INFO: renamed from: fk */
    private final float f2559fk;

    /* JADX INFO: renamed from: fl */
    private final float f2560fl;

    /* JADX INFO: renamed from: iN */
    private final int f2561iN;

    /* JADX INFO: renamed from: cq */
    private boolean f2562cq;

    /* JADX INFO: renamed from: cr */
    private final boolean f2563cr;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Vec3 f2564n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private Vec3 f2565o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private Vec3 f2566p;

    /* JADX INFO: renamed from: iO */
    private int f2567iO;

    /* JADX INFO: renamed from: cs */
    private boolean f2568cs;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Holder<Item> f2569a;

    public C0386gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f, float f2, int i) {
        this.f2562cq = false;
        this.f2568cs = false;
        this.f2569a = holder;
        this.f2564n = vec3;
        this.f2565o = vec3;
        this.f2566p = vec3;
        this.f2558m = vec32;
        this.f2559fk = f;
        this.f2560fl = f2;
        this.f2561iN = i;
        this.f2557fj = (float) vec3.distanceTo(this.f2558m);
        this.f2563cr = this.f2557fj >= 128.0f;
    }

    public C0386gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        this(holder, vec3, vec32, 2.5f, f2548fb, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0386gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f) {
        this(holder, vec3, vec32, f, f2548fb, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0386gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i) {
        this(holder, vec3, vec32, 2.5f, f2548fb, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0386gc m1848a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new C0386gc(C1291xn.m7871a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readInt());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0386gc m1849a() {
        this.f2568cs = true;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean m1850a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        this.f2566p = this.f2565o;
        this.f2565o = C1290xm.m7837a(this.f2565o, this.f2558m, this.f2560fl);
        this.f2567iO++;
        if (!this.f2568cs) {
            m1852a(minecraft, c0622l, localPlayer, clientLevel, random);
        }
        return m1851P();
    }

    /* JADX INFO: renamed from: P */
    public boolean m1851P() {
        return m1861r() >= 1.0f || this.f2567iO >= 60;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m1852a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        SoundManager soundManager = minecraft.getSoundManager();
        if (Mth.sqrt((float) localPlayer.distanceToSqr(this.f2565o)) <= 12.0f && !this.f2562cq) {
            this.f2562cq = true;
            if (this.f2565o.distanceToSqr(this.f2558m) > 100.0d) {
                C0054aY.f382cb += 0.05f;
                if (random.nextFloat() < 0.4f) {
                    m1853a(c0622l, clientLevel, soundManager, random);
                }
            }
            Object objValue = this.f2569a.value();
            if (objValue instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) objValue;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6213X = c1144ur.m6408a(new ItemStack(c1144ur)).m6213X();
                if (deferredHolderM6213X != null) {
                    soundManager.play(new C0492ic(this, (SoundEvent) deferredHolderM6213X.get(), SoundSource.AMBIENT, 0.9f + (0.2f * random.nextFloat()), 10.0f));
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m1853a(@NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) ((DeferredHolder) C1287xj.m7828a((List) C1280xc.f7500ac)).get();
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(this.f2565o.x, this.f2565o.y, this.f2565o.z, soundEvent, SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = (c0622l.m2683a().m2234O() > 0.4f ? 1 : (c0622l.m2683a().m2234O() == 0.4f ? 0 : -1)) <= 0 ? C1280xc.f7842uN : C1280xc.f7843uO;
        if (f2556b != null) {
            soundManager.stop(f2556b);
        }
        f2556b = SimpleSoundInstance.forLocalAmbience((SoundEvent) deferredHolder.get(), 0.9f + (0.2f * random.nextFloat()), 0.5f);
        soundManager.play(f2556b);
    }

    /* JADX INFO: renamed from: a */
    public void m1854a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C1291xn.m7872a(registryFriendlyByteBuf, this.f2569a);
        registryFriendlyByteBuf.writeVec3(this.f2564n);
        registryFriendlyByteBuf.writeVec3(this.f2558m);
        registryFriendlyByteBuf.writeFloat(this.f2559fk);
        registryFriendlyByteBuf.writeFloat(this.f2560fl);
        registryFriendlyByteBuf.writeInt(this.f2561iN);
    }

    public int getColor() {
        return this.f2561iN;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 m1855a(float f) {
        return C1290xm.m7845b(this.f2565o, this.f2566p, f);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m1856c() {
        return this.f2565o;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Vec3 m1857d() {
        return this.f2566p;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public Vec3 m1858e() {
        return this.f2565o.subtract(this.f2566p);
    }

    /* JADX INFO: renamed from: A */
    public float m1859A() {
        return this.f2559fk;
    }

    /* JADX INFO: renamed from: Q */
    public boolean m1860Q() {
        return this.f2563cr;
    }

    /* JADX INFO: renamed from: r */
    public float m1861r() {
        return 1.0f - (((float) this.f2565o.distanceTo(this.f2558m)) / this.f2557fj);
    }
}
