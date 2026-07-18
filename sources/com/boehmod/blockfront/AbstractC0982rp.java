package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rp.class */
public abstract class AbstractC0982rp {

    /* JADX INFO: renamed from: b */
    @Nullable
    protected final ServerPlayer f5215b;

    /* JADX INFO: renamed from: pr */
    protected int f5216pr;

    /* JADX INFO: renamed from: ps */
    protected int f5217ps;

    /* JADX INFO: renamed from: gK */
    private boolean f5218gK = false;

    /* JADX INFO: renamed from: c */
    abstract void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: d */
    abstract void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    abstract void mo5419a(@NotNull Level level, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set);

    @Nullable
    /* JADX INFO: renamed from: l */
    public abstract Component mo5420l();

    public AbstractC0982rp(@Nullable ServerPlayer serverPlayer, int i, int i2) {
        this.f5215b = serverPlayer;
        this.f5216pr = i;
        this.f5217ps = i2;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo5416a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        if (abstractC0787oF.m3587a() != EnumC0795oN.GAME) {
            return false;
        }
        if (this.f5216pr > 0) {
            this.f5216pr--;
            return true;
        }
        if (!this.f5218gK) {
            this.f5218gK = true;
            mo5417c(serverLevel, abstractC0787oF, set);
        }
        int i = this.f5217ps;
        this.f5217ps = i - 1;
        if (i > 0) {
            mo5418d(serverLevel, abstractC0787oF, set);
            return true;
        }
        mo5419a((Level) serverLevel, abstractC0787oF, set);
        return false;
    }
}
