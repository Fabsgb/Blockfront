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

/* JADX INFO: renamed from: com.boehmod.blockfront.rP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rP.class */
public final class C0957rP extends AbstractC0954rM {

    /* JADX INFO: renamed from: mC */
    private static final float f5332mC = 5.0f;

    /* JADX INFO: renamed from: rz */
    private static final int f5333rz = 2;

    /* JADX INFO: renamed from: hf */
    private final boolean f5334hf;

    /* JADX INFO: renamed from: ae */
    private final Vec3 f5335ae;

    /* JADX INFO: renamed from: rA */
    private int f5336rA;

    /* JADX INFO: renamed from: rB */
    private int f5337rB;

    /* JADX INFO: renamed from: b */
    private Vec3 f5338b;

    /* JADX INFO: renamed from: hg */
    private boolean f5339hg;

    public C0957rP(@NotNull AbstractC0866pe<?> abstractC0866pe, int i, int i2, @NotNull ThreadLocalRandom threadLocalRandom) {
        super(null, i, i2);
        this.f5336rA = 0;
        this.f5337rB = 0;
        this.f5339hg = false;
        C0881pt c0881ptM4226c = abstractC0866pe.m4226c();
        Vec3 vec3 = new Vec3(c0881ptM4226c.f4827c.x, 0.0d, c0881ptM4226c.f4827c.z);
        this.f5334hf = threadLocalRandom.nextFloat() < 0.2f;
        Vec3 vec3Add = vec3.add((-100.0f) + threadLocalRandom.nextFloat(200.0f), 0.0d, (-100.0f) + threadLocalRandom.nextFloat(200.0f));
        this.f5338b = vec3Add;
        this.f5335ae = vec3Add;
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: a */
    public boolean mo5292a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        float fSin = Mth.sin(this.f5337rB / 30.0f);
        float fSin2 = Mth.sin(this.f5337rB / 28.0f);
        this.f5338b = this.f5335ae.add(120.0f * fSin * fSin, 280.0d, 120.0f * fSin2 * fSin2);
        if (!this.f5339hg && this.f5334hf) {
            this.f5339hg = true;
            Vec3 vec3Add = this.f5338b.add(0.0d, 30.0d, 0.0d);
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8057ra.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8058rb.get(), SoundSource.AMBIENT, 50.0f, vec3Add);
        }
        return super.mo5292a(serverLevel, abstractC0863pb, set);
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: c */
    void mo5293c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: d */
    void mo5294d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        this.f5337rB++;
        int i = this.f5336rA;
        this.f5336rA = i + 1;
        if (i >= 2) {
            this.f5336rA = 0;
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8054qX.get(), SoundSource.AMBIENT, 8.0f, this.f5335ae);
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8055qY.get(), SoundSource.AMBIENT, 20.0f, this.f5335ae);
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8056qZ.get(), SoundSource.AMBIENT, 20.0f, this.f5335ae);
            C0403gs c0403gs = new C0403gs((Holder<Item>) C1308xv.f7754lA, this.f5335ae.add(4.0d, 4.0d, 4.0d), this.f5338b.add(4.0d, 4.0d, 4.0d), 5.0f);
            C0403gs c0403gs2 = new C0403gs((Holder<Item>) C1308xv.f7754lA, this.f5335ae, this.f5338b, 5.0f);
            C1169vO.m6646a(new C1217wJ(0, c0403gs), abstractC0863pb);
            C1169vO.m6646a(new C1217wJ(0, c0403gs2), abstractC0863pb);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: a */
    void mo5295a(@NotNull Level level, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        if (this.f5334hf) {
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8059rc.get(), SoundSource.AMBIENT, 50.0f, this.f5338b.add(0.0d, 30.0d, 0.0d));
            C1169vO.m6646a(new C1213wF(2), abstractC0863pb);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5296l() {
        return null;
    }
}
