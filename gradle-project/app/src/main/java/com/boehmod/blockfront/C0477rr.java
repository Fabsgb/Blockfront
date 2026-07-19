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

/* JADX INFO: renamed from: com.boehmod.blockfront.rr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rr.class */
public final class C0477rr extends AbstractC0475rp {
    private int pz;

    public C0477rr(int i, int i2) {
        super(null, i, i2);
        this.pz = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void c(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void d(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        this.pz++;
        if (this.pz % 5 == 0) {
            oR.a(set, (SoundEvent) C0624xc.rb.get(), SoundSource.AMBIENT);
            if (serverLevel.random.nextFloat() < 0.3f) {
                oR.a(set, (SoundEvent) C0624xc.rc.get(), SoundSource.AMBIENT, 1.0f, 0.5f);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void a(@NotNull Level level, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    @Nullable
    public Component l() {
        return null;
    }
}
