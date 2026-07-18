package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rr.class */
public final class C0984rr extends AbstractC0982rp {

    /* JADX INFO: renamed from: pz */
    private int f5227pz;

    public C0984rr(int i, int i2) {
        super(null, i, i2);
        this.f5227pz = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: c */
    void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: d */
    void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        this.f5227pz++;
        if (this.f5227pz % 5 == 0) {
            C0799oR.m3933a(set, (SoundEvent) C1280xc.f7648rb.get(), SoundSource.AMBIENT);
            if (serverLevel.random.nextFloat() < 0.3f) {
                C0799oR.m3936a(set, (SoundEvent) C1280xc.f7649rc.get(), SoundSource.AMBIENT, 1.0f, 0.5f);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: a */
    void mo5419a(@NotNull Level level, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5420l() {
        return null;
    }
}
