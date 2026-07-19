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

/* JADX INFO: renamed from: com.boehmod.blockfront.gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gc.class */
public final class C0166gc {
    private static final float eZ = 12.0f;
    private static final float fa = 2.5f;
    private static final float fb = 7.525f;
    private static final float fc = 10.0f;
    private static final float fd = 100.0f;
    private static final float fe = 0.4f;
    public static final float ff = 0.5f;
    public static final float fg = 10.0f;
    public static final float fh = 15.0f;
    public static final float fi = 0.05f;

    @Nullable
    private static SoundInstance b = null;
    private final float fj;

    @NotNull
    private final Vec3 m;
    private final float fk;
    private final float fl;
    private final int iN;
    private boolean cq;
    private final boolean cr;

    @NotNull
    private final Vec3 n;

    @NotNull
    private Vec3 o;

    @NotNull
    private Vec3 p;
    private int iO;
    private boolean cs;

    @NotNull
    private final Holder<Item> a;

    public C0166gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f, float f2, int i) {
        this.cq = false;
        this.cs = false;
        this.a = holder;
        this.n = vec3;
        this.o = vec3;
        this.p = vec3;
        this.m = vec32;
        this.fk = f;
        this.fl = f2;
        this.iN = i;
        this.fj = (float) vec3.distanceTo(this.m);
        this.cr = this.fj >= 128.0f;
    }

    public C0166gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        this(holder, vec3, vec32, 2.5f, fb, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0166gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f) {
        this(holder, vec3, vec32, f, fb, ColorReferences.COLOR_BULLET_TRACER);
    }

    public C0166gc(@NotNull Holder<Item> holder, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i) {
        this(holder, vec3, vec32, 2.5f, fb, i);
    }

    @NotNull
    public static C0166gc a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new C0166gc(C0635xn.m1693a(registryFriendlyByteBuf), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readVec3(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readFloat(), registryFriendlyByteBuf.readInt());
    }

    @NotNull
    public C0166gc a() {
        this.cs = true;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        this.p = this.o;
        this.o = C0634xm.a(this.o, this.m, this.fl);
        this.iO++;
        if (!this.cs) {
            m433a(minecraft, c0297l, localPlayer, clientLevel, random);
        }
        return P();
    }

    public boolean P() {
        return r() >= 1.0f || this.iO >= 60;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m433a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Random random) {
        SoundManager soundManager = minecraft.getSoundManager();
        if (Mth.sqrt((float) localPlayer.distanceToSqr(this.o)) <= 12.0f && !this.cq) {
            this.cq = true;
            if (this.o.distanceToSqr(this.m) > 100.0d) {
                aY.cb += 0.05f;
                if (random.nextFloat() < 0.4f) {
                    a(c0297l, clientLevel, soundManager, random);
                }
            }
            Object objValue = this.a.value();
            if (objValue instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) objValue;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderX = c0558ur.m1221a(new ItemStack(c0558ur)).X();
                if (deferredHolderX != null) {
                    soundManager.play(new C0220ic(this, (SoundEvent) deferredHolderX.get(), SoundSource.AMBIENT, 0.9f + (0.2f * random.nextFloat()), 10.0f));
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) ((DeferredHolder) C0631xj.a((List) C0624xc.ac)).get();
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(this.o.x, this.o.y, this.o.z, soundEvent, SoundSource.AMBIENT, 15.0f, 1.0f, false);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = (c0297l.m587a().O() > 0.4f ? 1 : (c0297l.m587a().O() == 0.4f ? 0 : -1)) <= 0 ? C0624xc.uN : C0624xc.uO;
        if (b != null) {
            soundManager.stop(b);
        }
        b = SimpleSoundInstance.forLocalAmbience((SoundEvent) deferredHolder.get(), 0.9f + (0.2f * random.nextFloat()), 0.5f);
        soundManager.play(b);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m434a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0635xn.a(registryFriendlyByteBuf, this.a);
        registryFriendlyByteBuf.writeVec3(this.n);
        registryFriendlyByteBuf.writeVec3(this.m);
        registryFriendlyByteBuf.writeFloat(this.fk);
        registryFriendlyByteBuf.writeFloat(this.fl);
        registryFriendlyByteBuf.writeInt(this.iN);
    }

    public int getColor() {
        return this.iN;
    }

    @NotNull
    public Vec3 a(float f) {
        return C0634xm.b(this.o, this.p, f);
    }

    @NotNull
    public Vec3 c() {
        return this.o;
    }

    @NotNull
    public Vec3 d() {
        return this.p;
    }

    @NotNull
    public Vec3 e() {
        return this.o.subtract(this.p);
    }

    public float A() {
        return this.fk;
    }

    public boolean Q() {
        return this.cr;
    }

    public float r() {
        return 1.0f - (((float) this.o.distanceTo(this.m)) / this.fj);
    }
}
