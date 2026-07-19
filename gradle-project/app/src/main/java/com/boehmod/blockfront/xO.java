package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xO.class */
public class xO extends com.boehmod.blockfront.common.player.b<xw, ServerLevel, ServerPlayer, xM> {

    @NotNull
    private final xL a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xK f399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final jI f400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final jJ f401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xN f402a;
    private boolean jN;

    @Override // com.boehmod.blockfront.common.player.b
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull Player player, @Nullable oF oFVar) {
        a((xw) abstractC0264ju, (ServerLevel) level, (ServerPlayer) player, (oF<?, ?, ?>) oFVar);
    }

    public xO(@NotNull UUID uuid) {
        super(uuid);
        this.a = new xL();
        this.f399a = new xK(this);
        this.f400a = new jI();
        this.f401a = new jJ();
        this.f402a = new xN(this);
        this.jN = false;
    }

    @NotNull
    public xL a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xK m1674a() {
        return this.f399a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jI m1675a() {
        return this.f400a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jJ m1676a() {
        return this.f401a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xN m1677a() {
        return this.f402a;
    }

    public boolean dv() {
        return this.jN;
    }

    public void ac(boolean z) {
        this.jN = z;
    }

    @Override // com.boehmod.blockfront.common.player.b
    @NotNull
    /* JADX INFO: renamed from: a */
    public xM mo300a() {
        return new xM(this);
    }

    public void a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @Nullable oF<?, ?, ?> oFVar) {
        super.a(xwVar, serverLevel, serverPlayer, oFVar);
        this.f399a.c(serverPlayer, oFVar);
        this.f400a.a(xwVar, serverPlayer);
        this.a.e(serverPlayer, xwVar.a());
        this.f402a.a(xwVar, serverLevel, serverPlayer);
        this.f401a.b(serverPlayer.getItemInHand(InteractionHand.MAIN_HAND));
    }
}
