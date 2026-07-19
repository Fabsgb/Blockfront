package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.InterfaceC0471rl;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rO.class */
public final class rO extends oF<rO, rR, C0526tm<rO, rR>> implements qR, qV, qZ, InterfaceC0460ra, InterfaceC0462rc, InterfaceC0463rd, InterfaceC0464re {
    public static final int pS = 50;
    private final C0272kb f;

    @NotNull
    public final List<Supplier<? extends C0558ur>> bm;

    @Nullable
    private C0332mh c;
    static final /* synthetic */ boolean gW;

    static {
        gW = !rO.class.desiredAssertionStatus();
    }

    public rO(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "gg", "Gun Game");
        this.f = new C0272kb().a("spawn", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            String str = strArr[0];
            oX oXVar = new oX(((CommandSourceStack) commandContext.getSource()).source);
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.b(oXVar);
                lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(oOVarA.getName() + " team spawn added. (" + oOVarA.B().size() + ")"));
            }
        }).a(C0274kd.a(new String[]{"team"})).a(C0274kd.a).a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? c() : List.of();
        })).a("clear", new C0272kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.ct();
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(oOVarA.getName() + " team's spawns cleared."));
            }
        }).a(C0274kd.a(new String[]{"team"})).a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? c() : List.of();
        })));
        this.bm = rQ.ar();
        this.c = null;
    }

    @Nullable
    public C0332mh d() {
        return this.c;
    }

    public void b(@Nullable C0332mh c0332mh) {
        this.c = c0332mh;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rP a(@NotNull C0297l c0297l) {
        return new rP(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rR a() {
        return new rR(this, this.f269b);
    }

    @Nullable
    public C0558ur a(int i) {
        Supplier<? extends C0558ur> supplier;
        if (!this.bm.isEmpty() && i >= 0 && i < this.bm.size() && (supplier = this.bm.get(i)) != null) {
            return supplier.get();
        }
        return null;
    }

    @Nullable
    public C0558ur b(int i) {
        int i2;
        if (!this.bm.isEmpty() && (i2 = i + 1) < this.bm.size()) {
            return this.bm.get(i2).get();
        }
        return null;
    }

    @Nullable
    public C0558ur c(int i) {
        int i2;
        if (this.bm.isEmpty() || (i2 = i - 1) < 0) {
            return null;
        }
        return this.bm.get(i2).get();
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        IPacket.writeBoolean(byteBuf, z);
        if (z) {
            byteBuf.writeInt(this.bm.size());
            Iterator<Supplier<? extends C0558ur>> it = this.bm.iterator();
            while (it.hasNext()) {
                IPacket.writeString(byteBuf, C0636xo.a(it.next().get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.bm.clear();
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                Item item = C0636xo.f(IPacket.readString(byteBuf)).get();
                if (item instanceof C0558ur) {
                    C0558ur c0558ur = (C0558ur) item;
                    this.bm.add(() -> {
                        return c0558ur;
                    });
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return super.mo763a().a(this.f);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<rO, rR> mo749a() {
        return new C0523tj(rU::new);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((rR) this.f268a).b();
        if (oOVarB == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((rR) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        this.bm.clear();
        this.bm.addAll(rQ.ar());
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public int aW() {
        return 2;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bd() {
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
        return CloudAchievements.ACH_MATCH_WIN_GG;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return false;
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
        return 40;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int bv() {
        return 160;
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public Component a(@NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((rR) this.f268a).a(C0529tp.da);
        oO oOVarA2 = ((rR) this.f268a).a(C0529tp.cZ);
        if (!gW && oOVarA == null) {
            throw new AssertionError();
        }
        if (gW || oOVarA2 != null) {
            return a((Player) serverPlayer, oOVarA.aZ(), oOVarA2.aZ());
        }
        throw new AssertionError();
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        a(abstractC0264ju, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public int bx() {
        return C0529tp.rx;
    }

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public int bw() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public boolean j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public boolean k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.qZ
    /* JADX INFO: renamed from: bC */
    public boolean mo1047bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.qR
    public boolean d(@NotNull ServerPlayer serverPlayer) {
        return this.f263a == oN.GAME;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.d(Optional.ofNullable(d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.d) {
            try {
                this.c = ((InterfaceC0471rl.d) interfaceC0471rl).h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
