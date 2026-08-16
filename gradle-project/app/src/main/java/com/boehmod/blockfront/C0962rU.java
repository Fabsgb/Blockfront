package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rU.class */
public final class C0962rU extends AbstractC0863pb<C0962rU, C0964rW, C1058tJ<C0962rU, C0964rW>> implements InterfaceC0944rC, InterfaceC0986rs {

    /* JADX INFO: renamed from: bl */
    @NotNull
    private final List<C0836pA> f5348bl;

    /* JADX INFO: renamed from: bm */
    @NotNull
    private final List<C0840pE> f5349bm;

    /* JADX INFO: renamed from: bn */
    @NotNull
    private final List<C0844pI> f5350bn;

    /* JADX INFO: renamed from: bo */
    @NotNull
    private final List<C0842pG> f5351bo;

    /* JADX INFO: renamed from: g */
    @NotNull
    private C0881pt f5352g;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0680mD f5353b;

    /* JADX INFO: renamed from: hh */
    private boolean f5354hh;

    public C0962rU(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "boot", "Bootcamp");
        this.f5348bl = new ObjectArrayList();
        this.f5349bm = new ObjectArrayList();
        this.f5350bn = new ObjectArrayList();
        this.f5351bo = new ObjectArrayList();
        this.f5352g = new C0881pt(0.0d, 0.0d, 0.0d, 0.0f, 0.0f);
        this.f5353b = null;
        this.f5354hh = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0963rV mo3995a(@NotNull C0623l c0623l) {
        return new C0963rV(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0964rW mo3996a() {
        return new C0964rW(this, this.f4643b);
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public C0881pt m5297h() {
        return this.f5352g;
    }

    /* JADX INFO: renamed from: f */
    public void m5298f(@NotNull ServerLevel serverLevel) {
        if (this.f5354hh) {
            return;
        }
        this.f5354hh = true;
        this.f5348bl.forEach(c0836pA -> {
            serverLevel.getChunkAt(c0836pA.m4587c());
            C0701mY c0701mYCreate = ((EntityType) C1307xu.f7624lb.get()).create(serverLevel);
            if (c0701mYCreate != null) {
                c0701mYCreate.moveTo(c0836pA.f4827c, 0.0f, 0.0f);
                c0701mYCreate.mo3117e(this);
                c0701mYCreate.m3154a(serverLevel, c0836pA);
                c0701mYCreate.m3157g(c0836pA.f4504aI);
                serverLevel.addFreshEntity(c0701mYCreate);
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C0962rU, C0964rW> mo3999a() {
        return new C1055tG(C0965rX::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        if (this.f5353b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.f4630bN + "' is missing."));
        }
        super.mo4083h(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0863pb.a> mo4085f() {
        return EnumSet.of(AbstractC0863pb.a.MAP_TYPE, AbstractC0863pb.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bj */
    protected boolean mo4011bj() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C0964rW) this.f4642a).m4242a("Recruits");
        if (c0872pkA == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0964rW) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkA);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        this.f5354hh = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        byteBuf.writeInt(this.f5351bo.size());
        Iterator<C0842pG> it = this.f5351bo.iterator();
        while (it.hasNext()) {
            it.next().mo3870c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        this.f5351bo.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0842pG c0842pG = new C0842pG();
            c0842pG.mo3869b(byteBuf);
            this.f5351bo.add(c0842pG);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0680mD m5299c() {
        return this.f5353b;
    }

    /* JADX INFO: renamed from: a */
    public void m5300a(@Nullable C0680mD c0680mD) {
        this.f5353b = c0680mD;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bn */
    public boolean mo4057bn() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bm */
    public boolean mo4048bm() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bp */
    public boolean mo4071bp() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo4072a() {
        return CloudAchievements.ACH_USER_BOOTCAMP;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: i */
    public boolean mo5301i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public float mo5302a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public int mo5303a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.InterfaceC0944rC
    /* JADX INFO: renamed from: c */
    public void mo5181c(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        C1060tL c1060tL = new C1060tL("targetsHit");
        C1060tL c1060tL2 = new C1060tL("targetsHitBad");
        C1060tL c1060tL3 = new C1060tL("targetsHitOk");
        C1060tL c1060tL4 = new C1060tL("targetsHitGood");
        C1060tL c1060tL5 = new C1060tL("targetsHitBest");
        int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL) + 1;
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL, iM4445a);
        int i = 0;
        if (iM4445a > 3) {
            switch (iM4445a) {
                case 6:
                    if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL2) == 0) {
                        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL2, 1);
                        C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8044qN.get(), SoundSource.NEUTRAL);
                        i = 2;
                    }
                    break;
                case 12:
                    if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL3) == 0) {
                        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL3, 1);
                        C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8046qP.get(), SoundSource.NEUTRAL);
                        i = 4;
                    }
                    break;
                case 24:
                    if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL4) == 0) {
                        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL4, 1);
                        C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8045qO.get(), SoundSource.NEUTRAL);
                        i = 6;
                    }
                    break;
                case 32:
                    if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL5) == 0) {
                        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, c1060tL5, 1);
                        C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8047qQ.get(), SoundSource.NEUTRAL);
                        i = 8;
                    }
                    break;
            }
        }
        if (i > 0 && !this.f4643b.m1150a((Player) serverPlayer).hasCompletedBootcamp()) {
            C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5748l, i);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: am */
    public List<C0842pG> m5304am() {
        return Collections.unmodifiableList(this.f5351bo);
    }

    @NotNull
    /* JADX INFO: renamed from: an */
    public List<C0840pE> m5305an() {
        return Collections.unmodifiableList(this.f5349bm);
    }

    @NotNull
    /* JADX INFO: renamed from: ao */
    public List<C0844pI> m5306ao() {
        return Collections.unmodifiableList(this.f5350bn);
    }

    @NotNull
    /* JADX INFO: renamed from: ap */
    public List<C0836pA> m5307ap() {
        return Collections.unmodifiableList(this.f5348bl);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.a(m5297h(), List.copyOf(m5307ap()), List.copyOf(m5305an()), List.copyOf(m5306ao()), List.copyOf(m5304am()), Optional.ofNullable(m5299c()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.a) {
            InterfaceC0950rI.a aVar = (InterfaceC0950rI.a) interfaceC0950rI;
            try {
                C0881pt c0881ptM5225f = aVar.m5225f();
                List<C0836pA> listM5226S = aVar.m5226S();
                List<C0840pE> listM5227T = aVar.m5227T();
                List<C0844pI> listM5228U = aVar.m5228U();
                List<C0842pG> listM5229V = aVar.m5229V();
                Optional<C0680mD> optionalM5230g = aVar.m5230g();
                this.f5352g = c0881ptM5225f;
                this.f5348bl.clear();
                this.f5348bl.addAll(listM5226S);
                this.f5349bm.clear();
                this.f5349bm.addAll(listM5227T);
                this.f5350bn.clear();
                this.f5350bn.addAll(listM5228U);
                this.f5351bo.clear();
                this.f5351bo.addAll(listM5229V);
                this.f5353b = optionalM5230g.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
