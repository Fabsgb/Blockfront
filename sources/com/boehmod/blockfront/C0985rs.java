package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rs.class */
public final class C0985rs extends AbstractC0982rp {

    /* JADX INFO: renamed from: lD */
    private static final float f5228lD = 5.0f;

    /* JADX INFO: renamed from: pA */
    private static final int f5229pA = 2;

    /* JADX INFO: renamed from: gL */
    private final boolean f5230gL;

    /* JADX INFO: renamed from: ad */
    private final Vec3 f5231ad;

    /* JADX INFO: renamed from: pB */
    private int f5232pB;

    /* JADX INFO: renamed from: pC */
    private int f5233pC;

    /* JADX INFO: renamed from: b */
    private Vec3 f5234b;

    /* JADX INFO: renamed from: gM */
    private boolean f5235gM;

    public C0985rs(@NotNull AbstractC0790oI<?> abstractC0790oI, int i, int i2, @NotNull ThreadLocalRandom threadLocalRandom) {
        super(null, i, i2);
        this.f5232pB = 0;
        this.f5233pC = 0;
        this.f5235gM = false;
        C0805oX c0805oXM3790c = abstractC0790oI.m3790c();
        Vec3 vec3 = new Vec3(c0805oXM3790c.f4424c.x, 0.0d, c0805oXM3790c.f4424c.z);
        this.f5230gL = threadLocalRandom.nextFloat() < 0.2f;
        Vec3 vec3Add = vec3.add((-100.0f) + threadLocalRandom.nextFloat(200.0f), 0.0d, (-100.0f) + threadLocalRandom.nextFloat(200.0f));
        this.f5234b = vec3Add;
        this.f5231ad = vec3Add;
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: a */
    public boolean mo5416a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        float fSin = Mth.sin(this.f5233pC / 30.0f);
        float fSin2 = Mth.sin(this.f5233pC / 28.0f);
        float f = fSin * fSin;
        float f2 = fSin2 * fSin2;
        this.f5234b = this.f5231ad.add(120.0f * f, 280.0d, 120.0f * f2);
        if (!this.f5235gM && this.f5230gL) {
            this.f5235gM = true;
            Vec3 vec3Add = this.f5234b.add(0.0d, 30.0d, 0.0d);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7645qY.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7646qZ.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
        }
        return super.mo5416a(serverLevel, abstractC0787oF, set);
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: c */
    void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: d */
    void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        this.f5233pC++;
        int i = this.f5232pB;
        this.f5232pB = i + 1;
        if (i >= 2) {
            this.f5232pB = 0;
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7642qV.get(), SoundSource.AMBIENT, 8.0f, this.f5231ad);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7643qW.get(), SoundSource.AMBIENT, 20.0f, this.f5231ad);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7644qX.get(), SoundSource.AMBIENT, 20.0f, this.f5231ad);
            C0386gc c0386gc = new C0386gc((Holder<Item>) C1231wY.f7189lA, this.f5231ad.add(4.0d, 4.0d, 4.0d), this.f5234b.add(4.0d, 4.0d, 4.0d), 5.0f);
            C0386gc c0386gc2 = new C0386gc((Holder<Item>) C1231wY.f7189lA, this.f5231ad, this.f5234b, 5.0f);
            C1194vo.m6651a(new C1245wm(0, c0386gc), abstractC0787oF);
            C1194vo.m6651a(new C1245wm(0, c0386gc2), abstractC0787oF);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: a */
    void mo5419a(@NotNull Level level, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        if (this.f5230gL) {
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7647ra.get(), SoundSource.AMBIENT, 50.0f, this.f5234b.add(0.0d, 30.0d, 0.0d));
            C1194vo.m6651a(new C1239wg(2), abstractC0787oF);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5420l() {
        return null;
    }
}
