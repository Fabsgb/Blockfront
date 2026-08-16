package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rM.class */
public abstract class AbstractC0954rM {

    /* JADX INFO: renamed from: c */
    @Nullable
    protected final ServerPlayer f5319c;

    /* JADX INFO: renamed from: rq */
    protected int f5320rq;

    /* JADX INFO: renamed from: rr */
    protected int f5321rr;

    /* JADX INFO: renamed from: he */
    private boolean f5322he = false;

    /* JADX INFO: renamed from: c */
    abstract void mo5293c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: d */
    abstract void mo5294d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    abstract void mo5295a(@NotNull Level level, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set);

    @Nullable
    /* JADX INFO: renamed from: l */
    public abstract Component mo5296l();

    public AbstractC0954rM(@Nullable ServerPlayer serverPlayer, int i, int i2) {
        this.f5319c = serverPlayer;
        this.f5320rq = i;
        this.f5321rr = i2;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo5292a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        if (abstractC0863pb.m4023a() != EnumC0871pj.GAME) {
            return false;
        }
        if (this.f5320rq > 0) {
            this.f5320rq--;
            return true;
        }
        if (!this.f5322he) {
            this.f5322he = true;
            mo5293c(serverLevel, abstractC0863pb, set);
        }
        int i = this.f5321rr;
        this.f5321rr = i - 1;
        if (i > 0) {
            mo5294d(serverLevel, abstractC0863pb, set);
            return true;
        }
        mo5295a((Level) serverLevel, abstractC0863pb, set);
        return false;
    }
}
