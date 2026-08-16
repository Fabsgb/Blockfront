package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sl.class */
public final class C1033sl extends AbstractC0863pb<C1033sl, C1036so, C1058tJ<C1033sl, C1036so>> implements InterfaceC0942rA, InterfaceC0943rB, InterfaceC0982ro, InterfaceC0986rs, InterfaceC0990rw, InterfaceC0991rx, InterfaceC0993rz {

    /* JADX INFO: renamed from: rT */
    public static final int f5627rT = 50;

    /* JADX INFO: renamed from: f */
    private final C0620kx f5628f;

    /* JADX INFO: renamed from: bt */
    @NotNull
    public final List<Supplier<? extends C1117uP>> f5629bt;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0680mD f5630c;

    /* JADX INFO: renamed from: hq */
    static final /* synthetic */ boolean f5631hq;

    static {
        f5631hq = !C1033sl.class.desiredAssertionStatus();
    }

    public C1033sl(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "gg", "Gun Game");
        this.f5628f = new C0620kx().m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            String str = strArr[0];
            C0881pt c0881pt = new C0881pt(((CommandSourceStack) commandContext.getSource()).source);
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4310b(c0881pt);
                C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(c0872pkA.getName() + " team spawn added. (" + c0872pkA.m4309D().size() + ")"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2836a(C0622kz.f3554a).m2842a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? m4019c() : List.of();
        })).m2840a("clear", new C0620kx((commandContext3, strArr3) -> {
            String str = strArr3[0];
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4311cF();
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(c0872pkA.getName() + " team's spawns cleared."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2842a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? m4019c() : List.of();
        })));
        this.f5629bt = C1035sn.m5778at();
        this.f5630c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0680mD m5763d() {
        return this.f5630c;
    }

    /* JADX INFO: renamed from: b */
    public void m5764b(@Nullable C0680mD c0680mD) {
        this.f5630c = c0680mD;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1034sm mo3995a(@NotNull C0623l c0623l) {
        return new C1034sm(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1036so mo3996a() {
        return new C1036so(this, this.f4643b);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1117uP m5765a(int i) {
        Supplier<? extends C1117uP> supplier;
        if (!this.f5629bt.isEmpty() && i >= 0 && i < this.f5629bt.size() && (supplier = this.f5629bt.get(i)) != null) {
            return supplier.get();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1117uP m5766b(int i) {
        int i2;
        if (!this.f5629bt.isEmpty() && (i2 = i + 1) < this.f5629bt.size()) {
            return this.f5629bt.get(i2).get();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C1117uP m5767c(int i) {
        int i2;
        if (this.f5629bt.isEmpty() || (i2 = i - 1) < 0) {
            return null;
        }
        return this.f5629bt.get(i2).get();
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            byteBuf.writeInt(this.f5629bt.size());
            Iterator<Supplier<? extends C1117uP>> it = this.f5629bt.iterator();
            while (it.hasNext()) {
                IPacket.writeString(byteBuf, C1272xL.m7219a(it.next().get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.f5629bt.clear();
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                Item item = C1272xL.m7220f(IPacket.readString(byteBuf)).get();
                if (item instanceof C1117uP) {
                    C1117uP c1117uP = (C1117uP) item;
                    this.f5629bt.add(() -> {
                        return c1117uP;
                    });
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return super.mo4082a().m2835a(this.f5628f);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1033sl, C1036so> mo3999a() {
        return new C1055tG(C1039sr::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bj */
    protected boolean mo4011bj() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkB = ((C1036so) this.f4642a).mo4241b();
        if (c0872pkB == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1036so) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkB);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        this.f5629bt.clear();
        this.f5629bt.addAll(C1035sn.m5778at());
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bn */
    public boolean mo4057bn() {
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
        return CloudAchievements.ACH_MATCH_WIN_GG;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return false;
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
        return 40;
    }

    @Override // com.boehmod.blockfront.InterfaceC0993rz
    /* JADX INFO: renamed from: b */
    public int mo5568b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0993rz
    /* JADX INFO: renamed from: bK */
    public int mo5569bK() {
        return 160;
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: a */
    public Component mo5178a(@NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C1036so) this.f4642a).m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA2 = ((C1036so) this.f4642a).m4242a(C1062tN.f5782dk);
        if (!f5631hq && c0872pkA == null) {
            throw new AssertionError();
        }
        if (f5631hq || c0872pkA2 != null) {
            return m4079a((Player) serverPlayer, c0872pkA.m4320bo(), c0872pkA2.m4320bo());
        }
        throw new AssertionError();
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: b */
    public void mo5179b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        m4075a(abstractC0531jN, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: bM */
    public int mo5180bM() {
        return C1062tN.f5737tA;
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: bL */
    public int mo5175bL() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: j */
    public boolean mo5176j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: k */
    public boolean mo5177k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0990rw
    /* JADX INFO: renamed from: bM */
    public boolean mo5348bM() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0982ro
    /* JADX INFO: renamed from: e */
    public boolean mo5354e(@NotNull ServerPlayer serverPlayer) {
        return this.f4629a == EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.d(Optional.ofNullable(m5763d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.d) {
            try {
                this.f5630c = ((InterfaceC0950rI.d) interfaceC0950rI).m5241h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
