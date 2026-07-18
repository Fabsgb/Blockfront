package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xO.class */
public class C1274xO extends AbstractC0182b<C1300xw, ServerLevel, ServerPlayer, C1272xM> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1271xL f7479a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1270xK f7480a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0525jI f7481a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0526jJ f7482a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1273xN f7483a;

    /* JADX INFO: renamed from: jN */
    private boolean f7484jN;

    @Override // com.boehmod.blockfront.common.player.AbstractC0182b
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1079a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull Player player, @Nullable AbstractC0787oF abstractC0787oF) {
        m7789a((C1300xw) abstractC0563ju, (ServerLevel) level, (ServerPlayer) player, (AbstractC0787oF<?, ?, ?>) abstractC0787oF);
    }

    public C1274xO(@NotNull UUID uuid) {
        super(uuid);
        this.f7479a = new C1271xL();
        this.f7480a = new C1270xK(this);
        this.f7481a = new C0525jI();
        this.f7482a = new C0526jJ();
        this.f7483a = new C1273xN(this);
        this.f7484jN = false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1271xL m7782a() {
        return this.f7479a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1270xK m7783a() {
        return this.f7480a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0525jI m7784a() {
        return this.f7481a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0526jJ m7785a() {
        return this.f7482a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1273xN m7786a() {
        return this.f7483a;
    }

    /* JADX INFO: renamed from: dv */
    public boolean m7787dv() {
        return this.f7484jN;
    }

    /* JADX INFO: renamed from: ac */
    public void m7788ac(boolean z) {
        this.f7484jN = z;
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0182b
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1272xM mo1078a() {
        return new C1272xM(this);
    }

    /* JADX INFO: renamed from: a */
    public void m7789a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        super.mo1079a(c1300xw, serverLevel, serverPlayer, abstractC0787oF);
        this.f7480a.m7764c(serverPlayer, abstractC0787oF);
        this.f7481a.m2325a(c1300xw, serverPlayer);
        this.f7479a.m7773e(serverPlayer, c1300xw.m7950a());
        this.f7483a.m7781a(c1300xw, serverLevel, serverPlayer);
        this.f7482a.m2326b(serverPlayer.getItemInHand(InteractionHand.MAIN_HAND));
    }
}
