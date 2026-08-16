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

/* JADX INFO: renamed from: com.boehmod.blockfront.rO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rO.class */
public final class C0956rO extends AbstractC0954rM {

    /* JADX INFO: renamed from: ry */
    private int f5331ry;

    public C0956rO(int i, int i2) {
        super(null, i, i2);
        this.f5331ry = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: c */
    void mo5293c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: d */
    void mo5294d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        this.f5331ry++;
        if (this.f5331ry % 5 == 0) {
            C0875pn.m4369a(set, (SoundEvent) C1312xz.f8060rd.get(), SoundSource.AMBIENT);
            if (serverLevel.random.nextFloat() < 0.3f) {
                C0875pn.m4372a(set, (SoundEvent) C1312xz.f8061re.get(), SoundSource.AMBIENT, 1.0f, 0.5f);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: a */
    void mo5295a(@NotNull Level level, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5296l() {
        return null;
    }
}
