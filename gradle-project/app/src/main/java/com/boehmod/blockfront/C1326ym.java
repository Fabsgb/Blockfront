package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ym */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ym.class */
public class C1326ym extends AbstractC0183b<C1280xT, ServerLevel, ServerPlayer, C1324yk> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1323yj f9063a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1322yi f9064a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0599kc f9065a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0600kd f9066a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1325yl f9067a;

    /* JADX INFO: renamed from: kd */
    private boolean f9068kd;

    @Override // com.boehmod.blockfront.common.player.AbstractC0183b
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1096a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull Player player, @Nullable AbstractC0863pb abstractC0863pb) {
        m8305a((C1280xT) abstractC0531jN, (ServerLevel) level, (ServerPlayer) player, (AbstractC0863pb<?, ?, ?>) abstractC0863pb);
    }

    public C1326ym(@NotNull UUID uuid) {
        super(uuid);
        this.f9063a = new C1323yj();
        this.f9064a = new C1322yi(this);
        this.f9065a = new C0599kc();
        this.f9066a = new C0600kd();
        this.f9067a = new C1325yl(this);
        this.f9068kd = false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1323yj m8298a() {
        return this.f9063a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1322yi m8299a() {
        return this.f9064a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0599kc m8300a() {
        return this.f9065a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0600kd m8301a() {
        return this.f9066a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1325yl m8302a() {
        return this.f9067a;
    }

    /* JADX INFO: renamed from: dE */
    public boolean m8303dE() {
        return this.f9068kd;
    }

    /* JADX INFO: renamed from: ad */
    public void m8304ad(boolean z) {
        this.f9068kd = z;
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183b
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1324yk mo1095a() {
        return new C1324yk(this);
    }

    /* JADX INFO: renamed from: a */
    public void m8305a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        super.mo1096a(c1280xT, serverLevel, serverPlayer, abstractC0863pb);
        this.f9064a.m8280c(serverPlayer, abstractC0863pb);
        this.f9065a.m2654a(c1280xT, serverPlayer, this);
        this.f9063a.m8289e(serverPlayer, c1280xT.m7277a());
        this.f9067a.m8297a(c1280xT, serverLevel, serverPlayer);
    }
}
