package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rx.class */
public final class C0990rx extends AbstractC0787oF<C0990rx, C0992rz, C1086tm<C0990rx, C0992rz>> implements InterfaceC0909qV, InterfaceC0972rf {

    /* JADX INFO: renamed from: be */
    @NotNull
    private final List<C0865pe> f5244be;

    /* JADX INFO: renamed from: bf */
    @NotNull
    private final List<C0869pi> f5245bf;

    /* JADX INFO: renamed from: bg */
    @NotNull
    private final List<C0873pm> f5246bg;

    /* JADX INFO: renamed from: bh */
    @NotNull
    private final List<C0871pk> f5247bh;

    /* JADX INFO: renamed from: g */
    @NotNull
    private C0805oX f5248g;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0709mh f5249b;

    /* JADX INFO: renamed from: gN */
    private boolean f5250gN;

    public C0990rx(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "boot", "Bootcamp");
        this.f5244be = new ObjectArrayList();
        this.f5245bf = new ObjectArrayList();
        this.f5246bg = new ObjectArrayList();
        this.f5247bh = new ObjectArrayList();
        this.f5248g = new C0805oX(0.0d, 0.0d, 0.0d, 0.0f, 0.0f);
        this.f5249b = null;
        this.f5250gN = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0991ry mo3559a(@NotNull C0622l c0622l) {
        return new C0991ry(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0992rz mo3560a() {
        return new C0992rz(this, this.f4249b);
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public C0805oX m5421h() {
        return this.f5248g;
    }

    /* JADX INFO: renamed from: f */
    public void m5422f(@NotNull ServerLevel serverLevel) {
        if (this.f5250gN) {
            return;
        }
        this.f5250gN = true;
        this.f5244be.forEach(c0865pe -> {
            serverLevel.getChunkAt(c0865pe.m4150c());
            C0678mC c0678mCCreate = ((EntityType) C1230wX.f7059lb.get()).create(serverLevel);
            if (c0678mCCreate != null) {
                c0678mCCreate.moveTo(c0865pe.f4424c, 0.0f, 0.0f);
                c0678mCCreate.mo3282e(this);
                c0678mCCreate.m3003a(serverLevel, c0865pe);
                c0678mCCreate.m3006f(c0865pe.f4535aB);
                serverLevel.addFreshEntity(c0678mCCreate);
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0990rx, C0992rz> mo3563a() {
        return new C1083tj(C0941rA::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        if (this.f5249b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.f4236bE + "' is missing."));
        }
        super.mo3647g(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0787oF.a> mo3649f() {
        return EnumSet.of(AbstractC0787oF.a.MAP_TYPE, AbstractC0787oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aZ */
    protected boolean mo3575aZ() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C0992rz) this.f4248a).m3806a("Recruits");
        if (c0796oOA == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0992rz) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOA);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        this.f5250gN = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        byteBuf.writeInt(this.f5247bh.size());
        Iterator<C0871pk> it = this.f5247bh.iterator();
        while (it.hasNext()) {
            it.next().mo4111c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        this.f5247bh.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0871pk c0871pk = new C0871pk();
            c0871pk.mo4110b(byteBuf);
            this.f5247bh.add(c0871pk);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0709mh m5423c() {
        return this.f5249b;
    }

    /* JADX INFO: renamed from: a */
    public void m5424a(@Nullable C0709mh c0709mh) {
        this.f5249b = c0709mh;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bd */
    public boolean mo3621bd() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bc */
    public boolean mo3612bc() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bf */
    public boolean mo3635bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo3636a() {
        return CloudAchievements.ACH_USER_BOOTCAMP;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: i */
    public boolean mo4686i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public float mo4687a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public int mo4688a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.InterfaceC0972rf
    /* JADX INFO: renamed from: c */
    public void mo5308c(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        C1088to c1088to = new C1088to("targetsHit");
        C1088to c1088to2 = new C1088to("targetsHitBad");
        C1088to c1088to3 = new C1088to("targetsHitOk");
        C1088to c1088to4 = new C1088to("targetsHitGood");
        C1088to c1088to5 = new C1088to("targetsHitBest");
        int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to) + 1;
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to, iM4009a);
        int i = 0;
        if (iM4009a > 3) {
            switch (iM4009a) {
                case 6:
                    if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to2) == 0) {
                        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to2, 1);
                        C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7632qL.get(), SoundSource.NEUTRAL);
                        i = 2;
                    }
                    break;
                case 12:
                    if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to3) == 0) {
                        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to3, 1);
                        C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7634qN.get(), SoundSource.NEUTRAL);
                        i = 4;
                    }
                    break;
                case 24:
                    if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to4) == 0) {
                        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to4, 1);
                        C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7633qM.get(), SoundSource.NEUTRAL);
                        i = 6;
                    }
                    break;
                case 32:
                    if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to5) == 0) {
                        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, c1088to5, 1);
                        C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7635qO.get(), SoundSource.NEUTRAL);
                        i = 8;
                    }
                    break;
            }
        }
        if (i > 0 && !this.f4249b.m1133a((Player) serverPlayer).hasCompletedBootcamp()) {
            C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5695l, i);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: ak */
    public List<C0871pk> m5425ak() {
        return Collections.unmodifiableList(this.f5247bh);
    }

    @NotNull
    /* JADX INFO: renamed from: al */
    public List<C0869pi> m5426al() {
        return Collections.unmodifiableList(this.f5245bf);
    }

    @NotNull
    /* JADX INFO: renamed from: am */
    public List<C0873pm> m5427am() {
        return Collections.unmodifiableList(this.f5246bg);
    }

    @NotNull
    /* JADX INFO: renamed from: an */
    public List<C0865pe> m5428an() {
        return Collections.unmodifiableList(this.f5244be);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.a(m5421h(), List.copyOf(m5428an()), List.copyOf(m5426al()), List.copyOf(m5427am()), List.copyOf(m5425ak()), Optional.ofNullable(m5423c()));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.a) {
            InterfaceC0978rl.a aVar = (InterfaceC0978rl.a) interfaceC0978rl;
            try {
                C0805oX c0805oXM5349f = aVar.m5349f();
                List<C0865pe> listM5350Q = aVar.m5350Q();
                List<C0869pi> listM5351R = aVar.m5351R();
                List<C0873pm> listM5352S = aVar.m5352S();
                List<C0871pk> listM5353T = aVar.m5353T();
                Optional<C0709mh> optionalM5354g = aVar.m5354g();
                this.f5248g = c0805oXM5349f;
                this.f5244be.clear();
                this.f5244be.addAll(listM5350Q);
                this.f5245bf.clear();
                this.f5245bf.addAll(listM5351R);
                this.f5246bg.clear();
                this.f5246bg.addAll(listM5352S);
                this.f5247bh.clear();
                this.f5247bh.addAll(listM5353T);
                this.f5249b = optionalM5354g.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
