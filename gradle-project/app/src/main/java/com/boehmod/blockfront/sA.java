package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.InterfaceC0471rl;
import com.boehmod.blockfront.oF;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sA.class */
public final class sA extends oF<sA, sC, C0526tm<sA, sC>> implements qQ, qT, qX, InterfaceC0462rc {
    public static final C0411pf c = new C0411pf(null, null, new ItemStack((ItemLike) wY.as.get()), null, null, null, null, null);
    public final List<oX> bz;
    private final List<DeferredHolder<Item, ? extends C0558ur>> bA;
    private final String cG = "Role";
    private final C0272kb j;
    public int rb;

    @NotNull
    public ObjectList<C0512sz> X;

    @NotNull
    public ObjectList<sG> Y;

    public sA(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "ttt", "Trouble in Terrorist Town");
        this.bz = new ObjectArrayList();
        this.bA = ObjectArrayList.of(new DeferredHolder[]{wY.mP, wY.mO, wY.mQ, wY.lT, wY.lU, wY.lI, wY.mj, wY.mx, wY.mL, wY.mM, wY.lQ, wY.lG, wY.mu, wY.mv});
        this.cG = "Role";
        this.j = new C0272kb().a("wp", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            this.bz.add(new oX(player));
            lW.b(player, Component.literal("Weapon spawn added. (" + this.bz.size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext2, strArr2) -> {
            lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.bz.size() + " weapon spawns."));
            this.bz.clear();
        }))).a("spawn", new C0272kb().a("add", new C0272kb((commandContext3, strArr3) -> {
            b().bB.add(new oX(((CommandSourceStack) commandContext3.getSource()).source));
            lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Player spawn added. (" + b().bB.size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext4, strArr4) -> {
            b().bB.clear();
            lW.b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.rb = 0;
        this.X = new ObjectArrayList();
        this.Y = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public sB a(@NotNull C0297l c0297l) {
        return new sB(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public sC a() {
        return new sC(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<sA, sC> mo749a() {
        return new C0523tj(sP::new);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<oF.a> mo1046f() {
        return EnumSet.of(oF.a.MAP_TYPE, oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (this.bz.isEmpty()) {
            list.add(Component.literal("Weapon spawns in game '" + this.bE + "' are missing."));
        }
        if (((sC) this.f268a).bB.isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.bE + "' are missing."));
        }
        super.g(list);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
        ObjectListIterator it = this.Y.iterator();
        while (it.hasNext()) {
            ((sG) it.next()).a(this, cVar, (Level) serverLevel, set);
        }
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return true;
    }

    public void a(@NotNull Level level, @NotNull Set<UUID> set) {
        ObjectListIterator it = this.Y.iterator();
        while (it.hasNext()) {
            ((sG) it.next()).a(this, level, set);
        }
        this.Y.clear();
    }

    public void a(@NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        sG sGVarA = sH.a();
        sGVarA.a(this, (Player) serverPlayer, (Level) serverLevel, set);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.randomat.activate", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.GOLD)});
        MutableComponent mutableComponentWithStyle = Component.translatable(sGVarA.getName()).withStyle(ChatFormatting.GOLD);
        MutableComponent mutableComponentWithStyle2 = Component.translatable(sGVarA.p()).withStyle(ChatFormatting.GRAY);
        oR.a(this, (SoundEvent) C0624xc.ui.get(), SoundSource.MASTER);
        oR.a(this, (List<Component>) List.of(mutableComponentTranslatable, mutableComponentWithStyle, mutableComponentWithStyle2), 80, sGVarA.ak());
        this.Y.add(sGVarA);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((sC) this.f268a).b();
        if (oOVarB == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((sC) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        this.rb = 0;
        if (level != null) {
            a(level, b().h());
        } else {
            this.Y.clear();
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        byteBuf.writeInt(this.X.size());
        ObjectListIterator it = this.X.iterator();
        while (it.hasNext()) {
            ((C0512sz) it.next()).c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        this.X.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0512sz c0512sz = new C0512sz();
            c0512sz.b(byteBuf);
            this.X.add(c0512sz);
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return this.b.a(this.j);
    }

    @Override // com.boehmod.blockfront.oF
    public float aG() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public oU mo753a() {
        return oU.ANYONE;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bb() {
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
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public oJ mo754a() {
        return oJ.NONE;
    }

    @Override // com.boehmod.blockfront.oF
    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo760a() {
        return null;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int bv() {
        return 160;
    }

    public void c(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        UUID uuid;
        ServerPlayer serverPlayerA;
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        Collections.shuffle(objectArrayList);
        int i = 1;
        int i2 = 1;
        boolean z = false;
        if (set.size() >= 14) {
            i = 4;
            i2 = 2;
        }
        if (set.size() >= 12) {
            i = 3;
            i2 = 1;
        } else if (set.size() >= 8) {
            i = 2;
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.roles.all", new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_THEME_TTT_TRAITOR), Component.literal(String.valueOf(i2)).withColor(ColorReferences.COLOR_THEME_TTT_DETECTIVE)}).withStyle(ChatFormatting.GRAY);
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext() && (serverPlayerA = oR.a((uuid = (UUID) it.next()))) != null) {
            if (!oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.f269b.m305a((Player) serverPlayerA))) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C0624xc.pZ;
                sK sKVar = sK.INNOCENT;
                C0411pf c0411pf = null;
                int i3 = 0;
                if (i > 0) {
                    i--;
                    sKVar = sK.TRAITOR;
                    deferredHolder = C0624xc.qa;
                    i3 = 1;
                } else if (i2 > 0) {
                    i2--;
                    sKVar = sK.DETECTIVE;
                    deferredHolder = C0624xc.pY;
                    c0411pf = sC.d;
                    i3 = 2;
                } else if (!z) {
                    z = true;
                    sKVar = sK.JESTER;
                    deferredHolder = C0624xc.HX;
                }
                a(uuid, sKVar);
                oR.a(uuid, (Component) Component.empty(), (Component) Component.empty());
                oR.b(uuid, sKVar.getTitle());
                oR.a(uuid, (Component) Component.empty(), (Component) Component.empty());
                oR.a(uuid, (Component) Component.empty(), sKVar.getDescription());
                oR.a(uuid, (Component) Component.empty(), (Component) Component.empty());
                oR.a(uuid, (Component) Component.empty(), (Component) mutableComponentWithStyle);
                oR.a(uuid, (Component) Component.empty(), (Component) Component.empty());
                oR.m792a((oF<?, ?, ?>) this, uuid, C0529tp.s, i3);
                oR.a(serverLevel, serverPlayerA, c, true);
                if (c0411pf != null) {
                    oR.a(serverLevel, serverPlayerA, c0411pf, true);
                }
                oR.a(uuid, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
                oR.a(uuid, (SoundEvent) C0624xc.qb.get(), SoundSource.MUSIC);
            }
        }
    }

    public void a(@NotNull UUID uuid, @NotNull sK sKVar) {
        oM oMVarA = a(uuid);
        Objects.requireNonNull(this);
        oMVarA.a("Role", sKVar.getKey());
    }

    @CheckForNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sL m1078a() {
        Set<UUID> setK = b().k();
        if (setK.isEmpty()) {
            return sL.BAD;
        }
        sL team = null;
        Iterator<UUID> it = setK.iterator();
        while (it.hasNext()) {
            sK sKVarA = a(it.next());
            if (sKVarA != null && sKVarA != sK.JESTER) {
                if (team == null) {
                    team = sKVarA.getTeam();
                } else if (sKVarA.getTeam() != team) {
                    return null;
                }
            }
        }
        return team;
    }

    public void i(@NotNull ServerPlayer serverPlayer) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectListIterator it = this.X.iterator();
        while (it.hasNext()) {
            C0512sz c0512sz = (C0512sz) it.next();
            if (!c0512sz.bQ() && Mth.sqrt((float) serverPlayer.distanceToSqr(c0512sz.c)) <= 2.0d) {
                objectArrayList.add(c0512sz);
            }
        }
        if (objectArrayList.isEmpty()) {
            oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.magnify.fail").withStyle(ChatFormatting.GRAY));
            return;
        }
        Iterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            ((C0512sz) it2.next()).a(this, (Player) serverPlayer);
        }
    }

    public Set<UUID> a(@NotNull sK sKVar, @NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (a(uuid).equals(sKVar)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    public sK a(@NotNull UUID uuid) {
        oM oMVarA = a(uuid);
        Objects.requireNonNull(this);
        if (oMVarA.f("Role")) {
            Objects.requireNonNull(this);
            return sK.fromKey(oMVarA.l("Role"));
        }
        return sK.PENDING;
    }

    public boolean m(@NotNull UUID uuid) {
        return a(uuid, sK.INNOCENT.getKey());
    }

    public boolean n(@NotNull UUID uuid) {
        return a(uuid, sK.TRAITOR.getKey());
    }

    public boolean o(@NotNull UUID uuid) {
        return a(uuid, sK.DETECTIVE.getKey());
    }

    private boolean a(@NotNull UUID uuid, @NotNull String str) {
        oM oMVarA = a(uuid);
        Objects.requireNonNull(this);
        if (oMVarA.f("Role")) {
            Objects.requireNonNull(this);
            if (oMVarA.l("Role").equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.qQ
    public float aS() {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.qX
    public boolean a(@NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        return a(player.getUUID()) == sK.DETECTIVE && (abstractC0542ub == wY.v.get() || abstractC0542ub == wY.x.get());
    }

    @Override // com.boehmod.blockfront.qX
    public void a(@NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (abstractC0542ub == wY.v.get()) {
                i(serverPlayer);
            }
            if (abstractC0542ub == wY.x.get()) {
                itemStack.shrink(1);
                a(serverPlayer, serverLevel, b().h());
            }
        }
    }

    public void j(@NotNull ServerLevel serverLevel) {
        for (oX oXVar : this.bz) {
            serverLevel.addFreshEntity(new ItemEntity(serverLevel, oXVar.c.x, oXVar.c.y + 0.5d, oXVar.c.z, new ItemStack((C0558ur) ((DeferredHolder) C0631xj.a(this.bA)).get())));
        }
    }

    @Override // com.boehmod.blockfront.qT
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<C0408pc> mo1079a(@NotNull UUID uuid) {
        return a(uuid).getRoleItems();
    }

    @Override // com.boehmod.blockfront.qT
    public C0528to c() {
        return C0529tp.s;
    }

    @Override // com.boehmod.blockfront.qT
    public MutableComponent e() {
        return Component.translatable("bf.message.gamemode.tip.store", new Object[]{Component.literal("M").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.i(List.copyOf(((sC) this.f268a).bB), List.copyOf(this.bz));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.i) {
            InterfaceC0471rl.i iVar = (InterfaceC0471rl.i) interfaceC0471rl;
            try {
                List<oX> listX = iVar.X();
                List<oX> listAe = iVar.ae();
                ((sC) this.f268a).bB.clear();
                ((sC) this.f268a).bB.addAll(listX);
                this.bz.clear();
                this.bz.addAll(listAe);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
