package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0881pt;
import com.boehmod.blockfront.C1169vO;
import com.boehmod.blockfront.C1176vV;
import com.boehmod.blockfront.C1237wd;
import com.boehmod.blockfront.common.player.AbstractC0182a;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.b */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/b.class */
public abstract class AbstractC0183b<M extends AbstractC0531jN<?, ?, ?>, L extends Level, P extends Player, B extends AbstractC0182a<?>> {

    /* JADX INFO: renamed from: vc */
    public static final int f1397vc = 80;

    /* JADX INFO: renamed from: vd */
    public static final int f1398vd = 80;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DateTimeFormatter f1399a = DateTimeFormatter.ofPattern("HH:mm:ss");

    /* JADX INFO: renamed from: ve */
    private static final int f1400ve = 5;

    /* JADX INFO: renamed from: X */
    @NotNull
    protected final UUID f1401X;

    /* JADX INFO: renamed from: T */
    private static final long f1405T = 15;

    /* JADX INFO: renamed from: Y */
    @Nullable
    private UUID f1408Y;

    /* JADX INFO: renamed from: W */
    private long f1409W;

    /* JADX INFO: renamed from: pg */
    public float f1414pg;

    /* JADX INFO: renamed from: pi */
    public float f1416pi;

    /* JADX INFO: renamed from: m */
    @Nullable
    private C0881pt f1421m;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2FloatMap<UUID> f1402a = new Object2FloatOpenHashMap();

    /* JADX INFO: renamed from: S */
    private long f1403S = Long.MIN_VALUE;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final IntSet f1404g = new IntOpenHashSet();

    /* JADX INFO: renamed from: U */
    private long f1406U = Long.MIN_VALUE;

    /* JADX INFO: renamed from: V */
    private long f1407V = Long.MIN_VALUE;

    /* JADX INFO: renamed from: aj */
    @NotNull
    private final ObjectList<String> f1410aj = new ObjectArrayList();

    /* JADX INFO: renamed from: vf */
    public int f1411vf = 0;

    /* JADX INFO: renamed from: vg */
    public int f1412vg = 0;

    /* JADX INFO: renamed from: vh */
    public int f1413vh = 0;

    /* JADX INFO: renamed from: ph */
    public float f1415ph = 0.0f;

    /* JADX INFO: renamed from: pj */
    public float f1417pj = 0.0f;

    /* JADX INFO: renamed from: il */
    protected boolean f1418il = false;

    /* JADX INFO: renamed from: X */
    private long f1419X = 0;

    /* JADX INFO: renamed from: jI */
    protected boolean f1420jI = false;

    /* JADX INFO: renamed from: jJ */
    private boolean f1422jJ = false;

    /* JADX INFO: renamed from: vi */
    private int f1423vi = 0;

    /* JADX INFO: renamed from: jK */
    private transient boolean f1424jK = false;

    /* JADX INFO: renamed from: Z */
    @Nullable
    private UUID f1425Z = null;

    /* JADX INFO: renamed from: n */
    @Nullable
    private C0881pt f1426n = null;

    /* JADX INFO: renamed from: vj */
    private int f1427vj = 0;

    /* JADX INFO: renamed from: vk */
    private int f1428vk = 0;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0187f f1429c = new C0187f();

    /* JADX INFO: renamed from: dT */
    @Nullable
    private String f1430dT = null;

    /* JADX INFO: renamed from: Y */
    private long f1431Y = 0;

    /* JADX INFO: renamed from: jL */
    private boolean f1432jL = true;

    /* JADX INFO: renamed from: vl */
    private int f1433vl = 0;

    /* JADX INFO: renamed from: jM */
    private boolean f1434jM = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private PlayerDataType f1436a = PlayerDataType.PLAYER;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final B f1435a = (B) mo1095a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract B mo1095a();

    public AbstractC0183b(@NotNull UUID uuid) {
        this.f1401X = uuid;
    }

    /* JADX INFO: renamed from: a */
    public void m1092a(@NotNull PlayerDataType playerDataType) {
        this.f1436a = playerDataType;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerDataType m1093a() {
        return this.f1436a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public B m1094b() {
        return this.f1435a;
    }

    /* JADX INFO: renamed from: a */
    public void mo1096a(@NotNull M m, @NotNull L l, @NotNull P p, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        m1098a(m, l, false);
        if (this.f1411vf > 0) {
            this.f1411vf--;
        }
        if (this.f1422jJ) {
            p.setSprinting(false);
            p.setPos(((Player) p).xOld, ((Player) p).yOld, ((Player) p).zOld);
        }
        if (p.isSprinting() && p.isCrouching()) {
            p.setSprinting(false);
        }
        if (p instanceof ServerPlayer) {
            m1097a(l, (ServerPlayer) p);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1097a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (this.f1421m != null && (serverPlayer.getX() != this.f1421m.f4827c.x || serverPlayer.getZ() != this.f1421m.f4827c.z)) {
            serverPlayer.teleportTo(this.f1421m.f4827c.x, serverPlayer.getY(), this.f1421m.f4827c.z);
            serverPlayer.setDeltaMovement(0.0d, 0.0d, 0.0d);
        }
        if (this.f1420jI && serverPlayer.getHealth() > 0.0f) {
            if (this.f1421m == null) {
                m1109e(new C0881pt((Player) serverPlayer));
                C1169vO.m6643a(new C1176vV(this.f1421m), serverPlayer);
            }
        } else if (this.f1421m != null) {
            m1109e((C0881pt) null);
            C1169vO.m6643a(new C1176vV(this.f1421m), serverPlayer);
        }
        this.f1435a.m1086a(level, serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1098a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Level level, boolean z) {
        if (level.isClientSide()) {
            return;
        }
        this.f1433vl++;
        if (z || this.f1432jL || this.f1433vl >= 40) {
            this.f1432jL = false;
            this.f1433vl = 0;
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jN.mo2354a(this.f1401X);
            if (abstractC0863pbMo2354a != null) {
                C1169vO.m6646a(new C1237wd((AbstractC0183b<?, ?, ?, ?>) this), abstractC0863pbMo2354a);
                return;
            }
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    ServerPlayer serverPlayer2 = serverPlayer;
                    C1169vO.m6643a(new C1237wd((AbstractC0183b<?, ?, ?, ?>) this), serverPlayer2);
                    if (serverPlayer2.getUUID().equals(this.f1401X)) {
                        serverPlayer2.refreshDimensions();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1099b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1435a.m1090b(friendlyByteBuf);
        friendlyByteBuf.writeBoolean(this.f1420jI);
        friendlyByteBuf.writeBoolean(this.f1422jJ);
        friendlyByteBuf.writeInt(this.f1423vi);
        friendlyByteBuf.writeBoolean(this.f1418il);
        friendlyByteBuf.writeBoolean(this.f1434jM);
        friendlyByteBuf.writeBoolean(this.f1425Z != null);
        if (this.f1425Z != null) {
            friendlyByteBuf.writeUUID(this.f1425Z);
        }
        friendlyByteBuf.writeVarInt(this.f1427vj);
        friendlyByteBuf.writeVarInt(this.f1428vk);
    }

    /* JADX INFO: renamed from: e */
    public void m1100e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1435a.m1091e(friendlyByteBuf);
        this.f1420jI = friendlyByteBuf.readBoolean();
        this.f1422jJ = friendlyByteBuf.readBoolean();
        this.f1423vi = friendlyByteBuf.readInt();
        this.f1418il = friendlyByteBuf.readBoolean();
        this.f1434jM = friendlyByteBuf.readBoolean();
        this.f1425Z = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUUID() : null;
        this.f1427vj = friendlyByteBuf.readVarInt();
        this.f1428vk = friendlyByteBuf.readVarInt();
    }

    /* JADX INFO: renamed from: dH */
    public void m1101dH() {
        this.f1432jL = true;
    }

    /* JADX INFO: renamed from: j */
    public long m1102j() {
        return this.f1419X;
    }

    /* JADX INFO: renamed from: e */
    public void m1103e(long j) {
        this.f1419X = j;
    }

    /* JADX INFO: renamed from: dt */
    public boolean m1104dt() {
        return this.f1422jJ;
    }

    /* JADX INFO: renamed from: Y */
    public void m1105Y(boolean z) {
        if (this.f1422jJ != z) {
            this.f1422jJ = z;
            m1101dH();
        }
    }

    /* JADX INFO: renamed from: du */
    public boolean m1106du() {
        return this.f1424jK;
    }

    /* JADX INFO: renamed from: Z */
    public void m1107Z(boolean z) {
        this.f1424jK = z;
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public C0881pt m1108l() {
        return this.f1421m;
    }

    /* JADX INFO: renamed from: e */
    public void m1109e(@Nullable C0881pt c0881pt) {
        this.f1421m = c0881pt;
    }

    /* JADX INFO: renamed from: dv */
    public boolean m1110dv() {
        return this.f1420jI;
    }

    /* JADX INFO: renamed from: aa */
    public void m1111aa(boolean z) {
        if (this.f1420jI != z) {
            this.f1420jI = z;
            m1101dH();
        }
    }

    /* JADX INFO: renamed from: cI */
    public int m1112cI() {
        return this.f1423vi;
    }

    /* JADX INFO: renamed from: J */
    public void m1113J(int i) {
        if (this.f1423vi != i) {
            this.f1423vi = i;
            m1101dH();
        }
    }

    /* JADX INFO: renamed from: K */
    public void m1114K(int i) {
        if (this.f1423vi <= 0) {
            return;
        }
        this.f1423vi -= i;
        if (this.f1423vi % 5 == 0) {
            m1101dH();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0187f m1115b() {
        return this.f1429c;
    }

    @Nullable
    /* JADX INFO: renamed from: r */
    public UUID m1116r() {
        return this.f1425Z;
    }

    /* JADX INFO: renamed from: p */
    public void m1117p(@Nullable UUID uuid) {
        if (!Objects.equals(this.f1425Z, uuid)) {
            this.f1425Z = uuid;
            m1101dH();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public C0881pt m1118m() {
        return this.f1426n;
    }

    /* JADX INFO: renamed from: f */
    public void m1119f(@Nullable C0881pt c0881pt) {
        this.f1426n = c0881pt;
    }

    /* JADX INFO: renamed from: cJ */
    public int m1120cJ() {
        return this.f1427vj;
    }

    /* JADX INFO: renamed from: cK */
    public int m1121cK() {
        return this.f1428vk;
    }

    /* JADX INFO: renamed from: b */
    public void m1122b(int i, int i2) {
        if (this.f1427vj != i || this.f1428vk != i2) {
            this.f1427vj = i;
            this.f1428vk = i2;
            m1101dH();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: aL */
    public String m1123aL() {
        return this.f1430dT;
    }

    /* JADX INFO: renamed from: F */
    public void m1124F(@NotNull String str) {
        if (this.f1430dT == null || !this.f1430dT.equals(str)) {
            this.f1430dT = str;
            this.f1410aj.add(LocalTime.now().format(f1399a) + ": \"" + str + "\"");
            if (this.f1410aj.size() > 5) {
                this.f1410aj.removeFirst();
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public ObjectList<String> m1125k() {
        return ObjectLists.unmodifiable(this.f1410aj);
    }

    /* JADX INFO: renamed from: k */
    public long m1126k() {
        return this.f1431Y;
    }

    /* JADX INFO: renamed from: f */
    public void m1127f(long j) {
        this.f1431Y = j;
    }

    /* JADX INFO: renamed from: aR */
    public boolean m1128aR() {
        return this.f1418il;
    }

    /* JADX INFO: renamed from: ab */
    public void m1129ab(boolean z) {
        if (this.f1418il != z) {
            this.f1418il = z;
            m1101dH();
        }
    }

    /* JADX INFO: renamed from: dw */
    public boolean m1130dw() {
        return this.f1434jM;
    }

    /* JADX INFO: renamed from: ac */
    public void m1131ac(boolean z) {
        this.f1434jM = z;
    }

    /* JADX INFO: renamed from: a */
    public void m1132a(@NotNull UUID uuid, float f) {
        if (!this.f1402a.containsKey(uuid)) {
            this.f1402a.put(uuid, f);
        } else {
            this.f1402a.put(uuid, this.f1402a.getFloat(uuid) + f);
        }
    }

    /* JADX INFO: renamed from: dI */
    public void m1133dI() {
        this.f1402a.clear();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1134a(int i, long j) {
        if (j != this.f1403S) {
            this.f1403S = j;
            this.f1404g.clear();
        }
        return this.f1404g.add(i);
    }

    /* JADX INFO: renamed from: e */
    public boolean m1135e(long j) {
        if (j < this.f1406U) {
            return false;
        }
        this.f1406U = j + f1405T;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1136a(long j, long j2) {
        if (j < this.f1407V) {
            return false;
        }
        this.f1407V = j + j2;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m1137a(@NotNull UUID uuid, long j) {
        if (uuid.equals(this.f1401X)) {
            return;
        }
        this.f1408Y = uuid;
        this.f1409W = j;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public UUID m1138a(long j) {
        if (this.f1408Y == null) {
            return null;
        }
        if (j >= this.f1409W) {
            this.f1408Y = null;
            return null;
        }
        return this.f1408Y;
    }

    /* JADX INFO: renamed from: dJ */
    public void m1139dJ() {
        this.f1408Y = null;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public Map<UUID, Float> m1140t() {
        return Collections.unmodifiableMap(this.f1402a);
    }

    public UUID getUUID() {
        return this.f1401X;
    }
}
