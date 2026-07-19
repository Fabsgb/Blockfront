package com.boehmod.blockfront.common.player;

import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0582vo;
import com.boehmod.blockfront.C0590vw;
import com.boehmod.blockfront.common.player.a;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oX;
import com.boehmod.blockfront.vE;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/b.class */
public abstract class b<M extends AbstractC0264ju<?, ?, ?>, L extends Level, P extends Player, B extends a<?>> {
    public static final int sY = 80;
    public static final int sZ = 80;

    @NotNull
    private static final DateTimeFormatter a = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final int ta = 5;

    @NotNull
    protected final UUID V;
    private static final long y = 15;

    @Nullable
    private UUID W;
    private long B;
    public float oi;
    public float ok;

    @Nullable
    private oX m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Object2FloatMap<UUID> f103a = new Object2FloatOpenHashMap();
    private long x = Long.MIN_VALUE;

    @NotNull
    private final IntSet e = new IntOpenHashSet();
    private long z = Long.MIN_VALUE;
    private long A = Long.MIN_VALUE;

    @NotNull
    private final ObjectList<String> aa = new ObjectArrayList();
    public int tb = 0;
    public int tc = 0;
    public int td = 0;
    public float oj = 0.0f;
    public float ol = 0.0f;
    protected boolean hR = false;
    private long C = 0;
    protected boolean js = false;
    private boolean jt = false;
    private int te = 0;
    private transient boolean ju = false;

    @Nullable
    private UUID X = null;

    @Nullable
    private oX n = null;
    private int tf = 0;
    private int tg = 0;

    @NotNull
    private final f c = new f();

    @Nullable
    private String dI = null;
    private long D = 0;
    private boolean jv = true;
    private int th = 0;
    private boolean jw = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private PlayerDataType f105a = PlayerDataType.PLAYER;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final B f104a = (B) mo300a();

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract B mo300a();

    public b(@NotNull UUID uuid) {
        this.V = uuid;
    }

    public void a(@NotNull PlayerDataType playerDataType) {
        this.f105a = playerDataType;
    }

    @NotNull
    public PlayerDataType a() {
        return this.f105a;
    }

    @NotNull
    public B b() {
        return this.f104a;
    }

    public void a(@NotNull M m, @NotNull L l, @NotNull P p, @Nullable oF<?, ?, ?> oFVar) {
        a(m, l, false);
        if (this.tb > 0) {
            this.tb--;
        }
        if (this.jt) {
            p.setSprinting(false);
            p.setPos(((Player) p).xOld, ((Player) p).yOld, ((Player) p).zOld);
        }
        if (p.isSprinting() && p.isCrouching()) {
            p.setSprinting(false);
        }
        if (p instanceof ServerPlayer) {
            a(l, (ServerPlayer) p);
        }
    }

    public void a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (this.m != null && (serverPlayer.getX() != this.m.c.x || serverPlayer.getZ() != this.m.c.z)) {
            serverPlayer.teleportTo(this.m.c.x, serverPlayer.getY(), this.m.c.z);
            serverPlayer.setDeltaMovement(0.0d, 0.0d, 0.0d);
        }
        if (this.js && serverPlayer.getHealth() > 0.0f) {
            if (this.m == null) {
                e(new oX((Player) serverPlayer));
                C0582vo.a(new C0590vw(this.m), serverPlayer);
            }
        } else if (this.m != null) {
            e((oX) null);
            C0582vo.a(new C0590vw(this.m), serverPlayer);
        }
        this.f104a.a(level, serverPlayer);
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, boolean z) {
        if (level.isClientSide()) {
            return;
        }
        this.th++;
        if (z || this.jv || this.th >= 40) {
            this.jv = false;
            this.th = 0;
            oF<?, ?, ?> oFVarMo604a = abstractC0264ju.mo604a(this.V);
            if (oFVarMo604a != null) {
                C0582vo.a(new vE((b<?, ?, ?, ?>) this), oFVarMo604a);
                return;
            }
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    ServerPlayer serverPlayer2 = serverPlayer;
                    C0582vo.a(new vE((b<?, ?, ?, ?>) this), serverPlayer2);
                    if (serverPlayer2.getUUID().equals(this.V)) {
                        serverPlayer2.refreshDimensions();
                    }
                }
            }
        }
    }

    public void b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f104a.b(friendlyByteBuf);
        friendlyByteBuf.writeBoolean(this.js);
        friendlyByteBuf.writeBoolean(this.jt);
        friendlyByteBuf.writeInt(this.te);
        friendlyByteBuf.writeBoolean(this.hR);
        friendlyByteBuf.writeBoolean(this.jw);
        friendlyByteBuf.writeBoolean(this.X != null);
        if (this.X != null) {
            friendlyByteBuf.writeUUID(this.X);
        }
        friendlyByteBuf.writeVarInt(this.tf);
        friendlyByteBuf.writeVarInt(this.tg);
    }

    public void e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f104a.e(friendlyByteBuf);
        this.js = friendlyByteBuf.readBoolean();
        this.jt = friendlyByteBuf.readBoolean();
        this.te = friendlyByteBuf.readInt();
        this.hR = friendlyByteBuf.readBoolean();
        this.jw = friendlyByteBuf.readBoolean();
        this.X = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readUUID() : null;
        this.tf = friendlyByteBuf.readVarInt();
        this.tg = friendlyByteBuf.readVarInt();
    }

    public void dx() {
        this.jv = true;
    }

    public long i() {
        return this.C;
    }

    public void d(long j) {
        this.C = j;
    }

    public boolean dk() {
        return this.jt;
    }

    public void X(boolean z) {
        if (this.jt != z) {
            this.jt = z;
            dx();
        }
    }

    public boolean dl() {
        return this.ju;
    }

    public void Y(boolean z) {
        this.ju = z;
    }

    @Nullable
    public oX l() {
        return this.m;
    }

    public void e(@Nullable oX oXVar) {
        this.m = oXVar;
    }

    public boolean dm() {
        return this.js;
    }

    public void Z(boolean z) {
        if (this.js != z) {
            this.js = z;
            dx();
        }
    }

    public int cs() {
        return this.te;
    }

    public void I(int i) {
        if (this.te != i) {
            this.te = i;
            dx();
        }
    }

    public void J(int i) {
        if (this.te <= 0) {
            return;
        }
        this.te -= i;
        if (this.te % 5 == 0) {
            dx();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public f m301b() {
        return this.c;
    }

    @Nullable
    public UUID q() {
        return this.X;
    }

    public void p(@Nullable UUID uuid) {
        if (!Objects.equals(this.X, uuid)) {
            this.X = uuid;
            dx();
        }
    }

    @Nullable
    public oX m() {
        return this.n;
    }

    public void f(@Nullable oX oXVar) {
        this.n = oXVar;
    }

    public int ct() {
        return this.tf;
    }

    public int cu() {
        return this.tg;
    }

    public void b(int i, int i2) {
        if (this.tf != i || this.tg != i2) {
            this.tf = i;
            this.tg = i2;
            dx();
        }
    }

    @Nullable
    public String aE() {
        return this.dI;
    }

    public void F(@NotNull String str) {
        if (this.dI == null || !this.dI.equals(str)) {
            this.dI = str;
            this.aa.add(LocalTime.now().format(a) + ": \"" + str + "\"");
            if (this.aa.size() > 5) {
                this.aa.removeFirst();
            }
        }
    }

    @NotNull
    public ObjectList<String> g() {
        return ObjectLists.unmodifiable(this.aa);
    }

    public long j() {
        return this.D;
    }

    public void e(long j) {
        this.D = j;
    }

    public boolean aG() {
        return this.hR;
    }

    public void aa(boolean z) {
        if (this.hR != z) {
            this.hR = z;
            dx();
        }
    }

    public boolean dn() {
        return this.jw;
    }

    public void ab(boolean z) {
        this.jw = z;
    }

    public void a(@NotNull UUID uuid, float f) {
        if (!this.f103a.containsKey(uuid)) {
            this.f103a.put(uuid, f);
        } else {
            this.f103a.put(uuid, this.f103a.getFloat(uuid) + f);
        }
    }

    public void dy() {
        this.f103a.clear();
    }

    public boolean a(int i, long j) {
        if (j != this.x) {
            this.x = j;
            this.e.clear();
        }
        return this.e.add(i);
    }

    public boolean a(long j) {
        if (j < this.z) {
            return false;
        }
        this.z = j + y;
        return true;
    }

    public boolean a(long j, long j2) {
        if (j < this.A) {
            return false;
        }
        this.A = j + j2;
        return true;
    }

    public void a(@NotNull UUID uuid, long j) {
        if (uuid.equals(this.V)) {
            return;
        }
        this.W = uuid;
        this.B = j;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public UUID m302a(long j) {
        if (this.W == null) {
            return null;
        }
        if (j >= this.B) {
            this.W = null;
            return null;
        }
        return this.W;
    }

    public void dz() {
        this.W = null;
    }

    @NotNull
    public Map<UUID, Float> t() {
        return Collections.unmodifiableMap(this.f103a);
    }

    public UUID getUUID() {
        return this.V;
    }
}
