package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.InterfaceC0471rl;
import com.boehmod.blockfront.oF;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rx.class */
public final class C0483rx extends oF<C0483rx, C0485rz, C0526tm<C0483rx, C0485rz>> implements qV, InterfaceC0465rf {

    @NotNull
    private final List<C0410pe> be;

    @NotNull
    private final List<C0414pi> bf;

    @NotNull
    private final List<C0418pm> bg;

    @NotNull
    private final List<C0416pk> bh;

    @NotNull
    private oX g;

    @Nullable
    private C0332mh b;
    private boolean gN;

    public C0483rx(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "boot", "Bootcamp");
        this.be = new ObjectArrayList();
        this.bf = new ObjectArrayList();
        this.bg = new ObjectArrayList();
        this.bh = new ObjectArrayList();
        this.g = new oX(0.0d, 0.0d, 0.0d, 0.0f, 0.0f);
        this.b = null;
        this.gN = false;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public C0484ry a(@NotNull C0297l c0297l) {
        return new C0484ry(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public C0485rz a() {
        return new C0485rz(this, this.f269b);
    }

    @NotNull
    public oX h() {
        return this.g;
    }

    public void f(@NotNull ServerLevel serverLevel) {
        if (this.gN) {
            return;
        }
        this.gN = true;
        this.be.forEach(c0410pe -> {
            serverLevel.getChunkAt(c0410pe.c());
            mC mCVarCreate = ((EntityType) wX.lb.get()).create(serverLevel);
            if (mCVarCreate != null) {
                mCVarCreate.moveTo(c0410pe.c, 0.0f, 0.0f);
                mCVarCreate.e(this);
                mCVarCreate.a(serverLevel, c0410pe);
                mCVarCreate.f(c0410pe.aB);
                serverLevel.addFreshEntity(mCVarCreate);
            }
        });
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<C0483rx, C0485rz> mo749a() {
        return new C0523tj(rA::new);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (this.b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.bE + "' is missing."));
        }
        super.g(list);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<oF.a> mo1046f() {
        return EnumSet.of(oF.a.MAP_TYPE, oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((C0485rz) this.f268a).a("Recruits");
        if (oOVarA == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0485rz) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarA);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        this.gN = false;
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        byteBuf.writeInt(this.bh.size());
        Iterator<C0416pk> it = this.bh.iterator();
        while (it.hasNext()) {
            it.next().c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        this.bh.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0416pk c0416pk = new C0416pk();
            c0416pk.b(byteBuf);
            this.bh.add(c0416pk);
        }
    }

    @Nullable
    public C0332mh c() {
        return this.b;
    }

    public void a(@Nullable C0332mh c0332mh) {
        this.b = c0332mh;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public int aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bd() {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bc() {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo760a() {
        return CloudAchievements.ACH_USER_BOOTCAMP;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.qV
    public boolean i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.qV
    public float a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.qV
    /* JADX INFO: renamed from: a */
    public int mo922a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.InterfaceC0465rf
    public void c(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        C0528to c0528to = new C0528to("targetsHit");
        C0528to c0528to2 = new C0528to("targetsHitBad");
        C0528to c0528to3 = new C0528to("targetsHitOk");
        C0528to c0528to4 = new C0528to("targetsHitGood");
        C0528to c0528to5 = new C0528to("targetsHitBest");
        int iA = oR.a((oF<?, ?, ?>) this, uuid, c0528to) + 1;
        oR.m792a((oF<?, ?, ?>) this, uuid, c0528to, iA);
        int i = 0;
        if (iA > 3) {
            switch (iA) {
                case 6:
                    if (oR.a((oF<?, ?, ?>) this, uuid, c0528to2) == 0) {
                        oR.m792a((oF<?, ?, ?>) this, uuid, c0528to2, 1);
                        oR.a(serverPlayer, (SoundEvent) C0624xc.qL.get(), SoundSource.NEUTRAL);
                        i = 2;
                    }
                    break;
                case 12:
                    if (oR.a((oF<?, ?, ?>) this, uuid, c0528to3) == 0) {
                        oR.m792a((oF<?, ?, ?>) this, uuid, c0528to3, 1);
                        oR.a(serverPlayer, (SoundEvent) C0624xc.qN.get(), SoundSource.NEUTRAL);
                        i = 4;
                    }
                    break;
                case 24:
                    if (oR.a((oF<?, ?, ?>) this, uuid, c0528to4) == 0) {
                        oR.m792a((oF<?, ?, ?>) this, uuid, c0528to4, 1);
                        oR.a(serverPlayer, (SoundEvent) C0624xc.qM.get(), SoundSource.NEUTRAL);
                        i = 6;
                    }
                    break;
                case 32:
                    if (oR.a((oF<?, ?, ?>) this, uuid, c0528to5) == 0) {
                        oR.m792a((oF<?, ?, ?>) this, uuid, c0528to5, 1);
                        oR.a(serverPlayer, (SoundEvent) C0624xc.qO.get(), SoundSource.NEUTRAL);
                        i = 8;
                    }
                    break;
            }
        }
        if (i > 0 && !this.f269b.a((Player) serverPlayer).hasCompletedBootcamp()) {
            oR.a(abstractC0264ju, this, uuid, C0529tp.l, i);
        }
    }

    @NotNull
    public List<C0416pk> ak() {
        return Collections.unmodifiableList(this.bh);
    }

    @NotNull
    public List<C0414pi> al() {
        return Collections.unmodifiableList(this.bf);
    }

    @NotNull
    public List<C0418pm> am() {
        return Collections.unmodifiableList(this.bg);
    }

    @NotNull
    public List<C0410pe> an() {
        return Collections.unmodifiableList(this.be);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.a(h(), List.copyOf(an()), List.copyOf(al()), List.copyOf(am()), List.copyOf(ak()), Optional.ofNullable(c()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.a) {
            InterfaceC0471rl.a aVar = (InterfaceC0471rl.a) interfaceC0471rl;
            try {
                oX oXVarF = aVar.f();
                List<C0410pe> listQ = aVar.Q();
                List<C0414pi> listR = aVar.R();
                List<C0418pm> listS = aVar.S();
                List<C0416pk> listT = aVar.T();
                Optional<C0332mh> optionalG = aVar.g();
                this.g = oXVarF;
                this.be.clear();
                this.be.addAll(listQ);
                this.bf.clear();
                this.bf.addAll(listR);
                this.bg.clear();
                this.bg.addAll(listS);
                this.bh.clear();
                this.bh.addAll(listT);
                this.b = optionalG.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
