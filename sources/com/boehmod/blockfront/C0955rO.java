package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rO.class */
public final class C0955rO extends AbstractC0787oF<C0955rO, C0958rR, C1086tm<C0955rO, C0958rR>> implements InterfaceC0905qR, InterfaceC0909qV, InterfaceC0913qZ, InterfaceC0967ra, InterfaceC0969rc, InterfaceC0970rd, InterfaceC0971re {

    /* JADX INFO: renamed from: pS */
    public static final int f5050pS = 50;

    /* JADX INFO: renamed from: f */
    private final C0597kb f5051f;

    /* JADX INFO: renamed from: bm */
    @NotNull
    public final List<Supplier<? extends C1144ur>> f5052bm;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0709mh f5053c;

    /* JADX INFO: renamed from: gW */
    static final /* synthetic */ boolean f5054gW;

    static {
        f5054gW = !C0955rO.class.desiredAssertionStatus();
    }

    public C0955rO(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "gg", "Gun Game");
        this.f5051f = new C0597kb().m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            String str = strArr[0];
            C0805oX c0805oX = new C0805oX(((CommandSourceStack) commandContext.getSource()).source);
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3874b(c0805oX);
                C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(c0796oOA.getName() + " team spawn added. (" + c0796oOA.m3873B().size() + ")"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2624a(C0599kd.f3307a).m2630a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? m3583c() : List.of();
        })).m2628a("clear", new C0597kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3875ct();
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(c0796oOA.getName() + " team's spawns cleared."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2630a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? m3583c() : List.of();
        })));
        this.f5052bm = C0957rQ.m5241ar();
        this.f5053c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0709mh m5226d() {
        return this.f5053c;
    }

    /* JADX INFO: renamed from: b */
    public void m5227b(@Nullable C0709mh c0709mh) {
        this.f5053c = c0709mh;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0956rP mo3559a(@NotNull C0622l c0622l) {
        return new C0956rP(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0958rR mo3560a() {
        return new C0958rR(this, this.f4249b);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1144ur m5228a(int i) {
        Supplier<? extends C1144ur> supplier;
        if (!this.f5052bm.isEmpty() && i >= 0 && i < this.f5052bm.size() && (supplier = this.f5052bm.get(i)) != null) {
            return supplier.get();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1144ur m5229b(int i) {
        int i2;
        if (!this.f5052bm.isEmpty() && (i2 = i + 1) < this.f5052bm.size()) {
            return this.f5052bm.get(i2).get();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C1144ur m5230c(int i) {
        int i2;
        if (this.f5052bm.isEmpty() || (i2 = i - 1) < 0) {
            return null;
        }
        return this.f5052bm.get(i2).get();
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            byteBuf.writeInt(this.f5052bm.size());
            Iterator<Supplier<? extends C1144ur>> it = this.f5052bm.iterator();
            while (it.hasNext()) {
                IPacket.writeString(byteBuf, C1292xo.m7892a(it.next().get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.f5052bm.clear();
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                Item item = C1292xo.m7893f(IPacket.readString(byteBuf)).get();
                if (item instanceof C1144ur) {
                    C1144ur c1144ur = (C1144ur) item;
                    this.f5052bm.add(() -> {
                        return c1144ur;
                    });
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return super.mo3646a().m2623a(this.f5051f);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0955rO, C0958rR> mo3563a() {
        return new C1083tj(C0961rU::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aZ */
    protected boolean mo3575aZ() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOB = ((C0958rR) this.f4248a).mo3805b();
        if (c0796oOB == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0958rR) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOB);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        this.f5052bm.clear();
        this.f5052bm.addAll(C0957rQ.m5241ar());
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bd */
    public boolean mo3621bd() {
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
        return CloudAchievements.ACH_MATCH_WIN_GG;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return false;
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
        return 40;
    }

    @Override // com.boehmod.blockfront.InterfaceC0969rc
    /* JADX INFO: renamed from: b */
    public int mo5208b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0969rc
    /* JADX INFO: renamed from: bv */
    public int mo5209bv() {
        return 160;
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: a */
    public Component mo5161a(@NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C0958rR) this.f4248a).m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = ((C0958rR) this.f4248a).m3806a(C1089tp.f5729cZ);
        if (!f5054gW && c0796oOA == null) {
            throw new AssertionError();
        }
        if (f5054gW || c0796oOA2 != null) {
            return m3643a((Player) serverPlayer, c0796oOA.m3884aZ(), c0796oOA2.m3884aZ());
        }
        throw new AssertionError();
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: b */
    public void mo5162b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        m3639a(abstractC0563ju, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: bx */
    public int mo5163bx() {
        return C1089tp.f5684rx;
    }

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: bw */
    public int mo5164bw() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: j */
    public boolean mo5165j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: k */
    public boolean mo5166k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0913qZ
    /* JADX INFO: renamed from: bC */
    public boolean mo4698bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0905qR
    /* JADX INFO: renamed from: d */
    public boolean mo4678d(@NotNull ServerPlayer serverPlayer) {
        return this.f4235a == EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.d(Optional.ofNullable(m5226d()));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.d) {
            try {
                this.f5053c = ((InterfaceC0978rl.d) interfaceC0978rl).m5365h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
