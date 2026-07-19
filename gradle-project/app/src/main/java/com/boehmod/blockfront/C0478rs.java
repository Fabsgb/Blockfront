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

/* JADX INFO: renamed from: com.boehmod.blockfront.rs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rs.class */
public final class C0478rs extends AbstractC0475rp {
    private static final float lD = 5.0f;
    private static final int pA = 2;
    private final boolean gL;
    private final Vec3 ad;
    private int pB;
    private int pC;
    private Vec3 b;
    private boolean gM;

    public C0478rs(@NotNull oI<?> oIVar, int i, int i2, @NotNull ThreadLocalRandom threadLocalRandom) {
        super(null, i, i2);
        this.pB = 0;
        this.pC = 0;
        this.gM = false;
        oX oXVarC = oIVar.c();
        Vec3 vec3 = new Vec3(oXVarC.c.x, 0.0d, oXVarC.c.z);
        this.gL = threadLocalRandom.nextFloat() < 0.2f;
        Vec3 vec3Add = vec3.add((-100.0f) + threadLocalRandom.nextFloat(200.0f), 0.0d, (-100.0f) + threadLocalRandom.nextFloat(200.0f));
        this.b = vec3Add;
        this.ad = vec3Add;
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    public boolean a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        float fSin = Mth.sin(this.pC / 30.0f);
        float fSin2 = Mth.sin(this.pC / 28.0f);
        float f = fSin * fSin;
        float f2 = fSin2 * fSin2;
        this.b = this.ad.add(120.0f * f, 280.0d, 120.0f * f2);
        if (!this.gM && this.gL) {
            this.gM = true;
            Vec3 vec3Add = this.b.add(0.0d, 30.0d, 0.0d);
            oR.a(set, (SoundEvent) C0624xc.qY.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
            oR.a(set, (SoundEvent) C0624xc.qZ.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
        }
        return super.a(serverLevel, oFVar, set);
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void c(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void d(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        this.pC++;
        int i = this.pB;
        this.pB = i + 1;
        if (i >= 2) {
            this.pB = 0;
            oR.a(set, (SoundEvent) C0624xc.qV.get(), SoundSource.AMBIENT, 8.0f, this.ad);
            oR.a(set, (SoundEvent) C0624xc.qW.get(), SoundSource.AMBIENT, 20.0f, this.ad);
            oR.a(set, (SoundEvent) C0624xc.qX.get(), SoundSource.AMBIENT, 20.0f, this.ad);
            C0166gc c0166gc = new C0166gc((Holder<Item>) wY.lA, this.ad.add(4.0d, 4.0d, 4.0d), this.b.add(4.0d, 4.0d, 4.0d), 5.0f);
            C0166gc c0166gc2 = new C0166gc((Holder<Item>) wY.lA, this.ad, this.b, 5.0f);
            C0582vo.a(new C0607wm(0, c0166gc), oFVar);
            C0582vo.a(new C0607wm(0, c0166gc2), oFVar);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void a(@NotNull Level level, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        if (this.gL) {
            oR.a(set, (SoundEvent) C0624xc.ra.get(), SoundSource.AMBIENT, 50.0f, this.b.add(0.0d, 30.0d, 0.0d));
            C0582vo.a(new C0601wg(2), oFVar);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    @Nullable
    public Component l() {
        return null;
    }
}
