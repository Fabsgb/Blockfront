package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C0805oX;
import com.boehmod.blockfront.C1158vE;
import com.boehmod.blockfront.C1194vo;
import com.boehmod.blockfront.C1202vw;
import com.boehmod.blockfront.common.player.AbstractC0181a;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/b.class */
public abstract class AbstractC0182b<M extends AbstractC0563ju<?, ?, ?>, L extends Level, P extends Player, B extends AbstractC0181a<?>> {

    /* JADX INFO: renamed from: sY */
    public static final int f1475sY = 80;

    /* JADX INFO: renamed from: sZ */
    public static final int f1476sZ = 80;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DateTimeFormatter f1477a = DateTimeFormatter.ofPattern("HH:mm:ss");

    /* JADX INFO: renamed from: ta */
    private static final int f1478ta = 5;

    /* JADX INFO: renamed from: V */
    @NotNull
    protected final UUID f1479V;

    /* JADX INFO: renamed from: y */
    private static final long f1483y = 15;

    /* JADX INFO: renamed from: W */
    @Nullable
    private UUID f1486W;

    /* JADX INFO: renamed from: B */
    private long f1487B;

    /* JADX INFO: renamed from: oi */
    public float f1492oi;

    /* JADX INFO: renamed from: ok */
    public float f1494ok;

    /* JADX INFO: renamed from: m */
    @Nullable
    private C0805oX f1499m;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2FloatMap<UUID> f1480a = new Object2FloatOpenHashMap();

    /* JADX INFO: renamed from: x */
    private long f1481x = Long.MIN_VALUE;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final IntSet f1482e = new IntOpenHashSet();

    /* JADX INFO: renamed from: z */
    private long f1484z = Long.MIN_VALUE;

    /* JADX INFO: renamed from: A */
    private long f1485A = Long.MIN_VALUE;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private final ObjectList<String> f1488aa = new ObjectArrayList();

    /* JADX INFO: renamed from: tb */
    public int f1489tb = 0;

    /* JADX INFO: renamed from: tc */
    public int f1490tc = 0;

    /* JADX INFO: renamed from: td */
    public int f1491td = 0;

    /* JADX INFO: renamed from: oj */
    public float f1493oj = 0.0f;

    /* JADX INFO: renamed from: ol */
    public float f1495ol = 0.0f;

    /* JADX INFO: renamed from: hR */
    protected boolean f1496hR = false;

    /* JADX INFO: renamed from: C */
    private long f1497C = 0;

    /* JADX INFO: renamed from: js */
    protected boolean f1498js = false;

    /* JADX INFO: renamed from: jt */
    private boolean f1500jt = false;

    /* JADX INFO: renamed from: te */
    private int f1501te = 0;

    /* JADX INFO: renamed from: ju */
    private transient boolean f1502ju = false;

    /* JADX INFO: renamed from: X */
    @Nullable
    private UUID f1503X = null;

    /* JADX INFO: renamed from: n */
    @Nullable
    private C0805oX f1504n = null;

    /* JADX INFO: renamed from: tf */
    private int f1505tf = 0;

    /* JADX INFO: renamed from: tg */
    private int f1506tg = 0;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0186f f1507c = new C0186f();

    /* JADX INFO: renamed from: dI */
    @Nullable
    private String f1508dI = null;

    /* JADX INFO: renamed from: D */
    private long f1509D = 0;

    /* JADX INFO: renamed from: jv */
    private boolean f1510jv = true;

    /* JADX INFO: renamed from: th */
    private int f1511th = 0;

    /* JADX INFO: renamed from: jw */
    private boolean f1512jw = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private PlayerDataType f1514a = PlayerDataType.PLAYER;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final B f1513a = (B) mo1078a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract B mo1078a();

    public AbstractC0182b(@NotNull UUID uuid) {
        this.f1479V = uuid;
    }

    /* JADX INFO: renamed from: a */
    public void m1075a(@NotNull PlayerDataType playerDataType) {
        this.f1514a = playerDataType;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerDataType m1076a() {
        return this.f1514a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public B m1077b() {
        return this.f1513a;
    }

    /* JADX INFO: renamed from: a */
    public void mo1079a(@NotNull M m, @NotNull L l, @NotNull P p, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        m1081a(m, l, false);
        if (this.f1489tb > 0) {
            this.f1489tb--;
        }
        if (this.f1500jt) {
            p.setSprinting(false);
            p.setPos(((Player) p).xOld, ((Player) p).yOld, ((Player) p).zOld);
        }
        if (p.isSprinting() && p.isCrouching()) {
            p.setSprinting(false);
        }
        if (p instanceof ServerPlayer) {
            m1080a(l, (ServerPlayer) p);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1080a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (this.f1499m != null && (serverPlayer.getX() != this.f1499m.f4424c.x || serverPlayer.getZ() != this.f1499m.f4424c.z)) {
            serverPlayer.teleportTo(this.f1499m.f4424c.x, serverPlayer.getY(), this.f1499m.f4424c.z);
            serverPlayer.setDeltaMovement(0.0d, 0.0d, 0.0d);
        }
        if (this.f1498js && serverPlayer.getHealth() > 0.0f) {
            if (this.f1499m == null) {
                m1092e(new C0805oX((Player) serverPlayer));
                C1194vo.m6648a(new C1202vw(this.f1499m), serverPlayer);
            }
        } else if (this.f1499m != null) {
            m1092e((C0805oX) null);
            C1194vo.m6648a(new C1202vw(this.f1499m), serverPlayer);
        }
        this.f1513a.m1069a(level, serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1081a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Level level, boolean z) {
        if (level.isClientSide()) {
            return;
        }
        this.f1511th++;
        if (z || this.f1510jv || this.f1511th >= 40) {
            this.f1510jv = false;
            this.f1511th = 0;
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563ju.mo2531a(this.f1479V);
            if (abstractC0787oFMo2531a != null) {
                C1194vo.m6651a(new C1158vE((AbstractC0182b<?, ?, ?, ?>) this), abstractC0787oFMo2531a);
                return;
            }
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    ServerPlayer serverPlayer2 = serverPlayer;
                    C1194vo.m6648a(new C1158vE((AbstractC0182b<?, ?, ?, ?>) this), serverPlayer2);
                    if (serverPlayer2.getUUID().equals(this.f1479V)) {
                        serverPlayer2.refreshDimensions();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1082b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1513a.m1073b(friendlyByteBuf);
        friendlyByteBuf.writeBoolean(this.f1498js);
        friendlyByteBuf.writeBoolean(this.f1500jt);
        friendlyByteBuf.writeInt(this.f1501te);
        friendlyByteBuf.writeBoolean(this.f1496hR);
        friendlyByteBuf.writeBoolean(this.f1512jw);
        friendlyByteBuf.writeBoolean(this.f1503X != null);
        if (this.f1503X != null) {
            friendlyByteBuf.writeUUID(this.f1503X);
        }
        friendlyByteBuf.writeVarInt(this.f1505tf);
        friendlyByteBuf.writeVarInt(this.f1506tg);
    }

    /* JADX INFO: renamed from: e */
    public void m1083e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1513a.m1074e(friendlyByteBuf);
        this.f1498js = friendlyByteBuf.readBoolean();
        this.f1500jt = friendlyByteBuf.readBoolean();
        this.f1501te = friendlyByteBuf.readInt();
        this.f1496hR = friendlyByteBuf.readBoolean();
        this.f1512jw = friendlyByteBuf.readBoolean();
        this.f1503X = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUUID() : null;
        this.f1505tf = friendlyByteBuf.readVarInt();
        this.f1506tg = friendlyByteBuf.readVarInt();
    }

    /* JADX INFO: renamed from: dx */
    public void m1084dx() {
        this.f1510jv = true;
    }

    /* JADX INFO: renamed from: i */
    public long m1085i() {
        return this.f1497C;
    }

    /* JADX INFO: renamed from: d */
    public void m1086d(long j) {
        this.f1497C = j;
    }

    /* JADX INFO: renamed from: dk */
    public boolean m1087dk() {
        return this.f1500jt;
    }

    /* JADX INFO: renamed from: X */
    public void m1088X(boolean z) {
        if (this.f1500jt != z) {
            this.f1500jt = z;
            m1084dx();
        }
    }

    /* JADX INFO: renamed from: dl */
    public boolean m1089dl() {
        return this.f1502ju;
    }

    /* JADX INFO: renamed from: Y */
    public void m1090Y(boolean z) {
        this.f1502ju = z;
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public C0805oX m1091l() {
        return this.f1499m;
    }

    /* JADX INFO: renamed from: e */
    public void m1092e(@Nullable C0805oX c0805oX) {
        this.f1499m = c0805oX;
    }

    /* JADX INFO: renamed from: dm */
    public boolean m1093dm() {
        return this.f1498js;
    }

    /* JADX INFO: renamed from: Z */
    public void m1094Z(boolean z) {
        if (this.f1498js != z) {
            this.f1498js = z;
            m1084dx();
        }
    }

    /* JADX INFO: renamed from: cs */
    public int m1095cs() {
        return this.f1501te;
    }

    /* JADX INFO: renamed from: I */
    public void m1096I(int i) {
        if (this.f1501te != i) {
            this.f1501te = i;
            m1084dx();
        }
    }

    /* JADX INFO: renamed from: J */
    public void m1097J(int i) {
        if (this.f1501te <= 0) {
            return;
        }
        this.f1501te -= i;
        if (this.f1501te % 5 == 0) {
            m1084dx();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0186f m1098b() {
        return this.f1507c;
    }

    @Nullable
    /* JADX INFO: renamed from: q */
    public UUID m1099q() {
        return this.f1503X;
    }

    /* JADX INFO: renamed from: p */
    public void m1100p(@Nullable UUID uuid) {
        if (!Objects.equals(this.f1503X, uuid)) {
            this.f1503X = uuid;
            m1084dx();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public C0805oX m1101m() {
        return this.f1504n;
    }

    /* JADX INFO: renamed from: f */
    public void m1102f(@Nullable C0805oX c0805oX) {
        this.f1504n = c0805oX;
    }

    /* JADX INFO: renamed from: ct */
    public int m1103ct() {
        return this.f1505tf;
    }

    /* JADX INFO: renamed from: cu */
    public int m1104cu() {
        return this.f1506tg;
    }

    /* JADX INFO: renamed from: b */
    public void m1105b(int i, int i2) {
        if (this.f1505tf != i || this.f1506tg != i2) {
            this.f1505tf = i;
            this.f1506tg = i2;
            m1084dx();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: aE */
    public String m1106aE() {
        return this.f1508dI;
    }

    /* JADX INFO: renamed from: F */
    public void m1107F(@NotNull String str) {
        if (this.f1508dI == null || !this.f1508dI.equals(str)) {
            this.f1508dI = str;
            this.f1488aa.add(LocalTime.now().format(f1477a) + ": \"" + str + "\"");
            if (this.f1488aa.size() > 5) {
                this.f1488aa.removeFirst();
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public ObjectList<String> m1108g() {
        return ObjectLists.unmodifiable(this.f1488aa);
    }

    /* JADX INFO: renamed from: j */
    public long m1109j() {
        return this.f1509D;
    }

    /* JADX INFO: renamed from: e */
    public void m1110e(long j) {
        this.f1509D = j;
    }

    /* JADX INFO: renamed from: aG */
    public boolean m1111aG() {
        return this.f1496hR;
    }

    /* JADX INFO: renamed from: aa */
    public void m1112aa(boolean z) {
        if (this.f1496hR != z) {
            this.f1496hR = z;
            m1084dx();
        }
    }

    /* JADX INFO: renamed from: dn */
    public boolean m1113dn() {
        return this.f1512jw;
    }

    /* JADX INFO: renamed from: ab */
    public void m1114ab(boolean z) {
        this.f1512jw = z;
    }

    /* JADX INFO: renamed from: a */
    public void m1115a(@NotNull UUID uuid, float f) {
        if (!this.f1480a.containsKey(uuid)) {
            this.f1480a.put(uuid, f);
        } else {
            this.f1480a.put(uuid, this.f1480a.getFloat(uuid) + f);
        }
    }

    /* JADX INFO: renamed from: dy */
    public void m1116dy() {
        this.f1480a.clear();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1117a(int i, long j) {
        if (j != this.f1481x) {
            this.f1481x = j;
            this.f1482e.clear();
        }
        return this.f1482e.add(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1118a(long j) {
        if (j < this.f1484z) {
            return false;
        }
        this.f1484z = j + f1483y;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1119a(long j, long j2) {
        if (j < this.f1485A) {
            return false;
        }
        this.f1485A = j + j2;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m1120a(@NotNull UUID uuid, long j) {
        if (uuid.equals(this.f1479V)) {
            return;
        }
        this.f1486W = uuid;
        this.f1487B = j;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public UUID m1121a(long j) {
        if (this.f1486W == null) {
            return null;
        }
        if (j >= this.f1487B) {
            this.f1486W = null;
            return null;
        }
        return this.f1486W;
    }

    /* JADX INFO: renamed from: dz */
    public void m1122dz() {
        this.f1486W = null;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public Map<UUID, Float> m1123t() {
        return Collections.unmodifiableMap(this.f1480a);
    }

    public UUID getUUID() {
        return this.f1479V;
    }
}
