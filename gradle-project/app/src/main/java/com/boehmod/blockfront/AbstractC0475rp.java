package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rp.class */
public abstract class AbstractC0475rp {

    @Nullable
    protected final ServerPlayer b;
    protected int pr;
    protected int ps;
    private boolean gK = false;

    abstract void c(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set);

    abstract void d(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set);

    abstract void a(@NotNull Level level, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set);

    @Nullable
    public abstract Component l();

    public AbstractC0475rp(@Nullable ServerPlayer serverPlayer, int i, int i2) {
        this.b = serverPlayer;
        this.pr = i;
        this.ps = i2;
    }

    public boolean a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        if (oFVar.m750a() != oN.GAME) {
            return false;
        }
        if (this.pr > 0) {
            this.pr--;
            return true;
        }
        if (!this.gK) {
            this.gK = true;
            c(serverLevel, oFVar, set);
        }
        int i = this.ps;
        this.ps = i - 1;
        if (i > 0) {
            d(serverLevel, oFVar, set);
            return true;
        }
        a((Level) serverLevel, oFVar, set);
        return false;
    }
}
