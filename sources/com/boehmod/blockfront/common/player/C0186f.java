package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0806oY;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/f.class */
public final class C0186f {

    /* JADX INFO: renamed from: aV */
    public static final double f1524aV = 0.25d;

    /* JADX INFO: renamed from: ti */
    public static final int f1525ti = 3;

    /* JADX INFO: renamed from: aJ */
    @Nullable
    private Vec3 f1527aJ;

    /* JADX INFO: renamed from: aK */
    @Nullable
    private Vec3 f1528aK;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f1526a = a.AABB;

    /* JADX INFO: renamed from: ab */
    @NotNull
    private final ObjectList<Vec3> f1529ab = new ObjectArrayList();

    /* JADX INFO: renamed from: tj */
    private int f1530tj = 0;

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m1148a() {
        return this.f1526a;
    }

    /* JADX INFO: renamed from: a */
    public void m1149a(@NotNull a aVar) {
        this.f1526a = aVar;
        m1161dB();
    }

    /* JADX INFO: renamed from: cx */
    public int m1150cx() {
        return this.f1530tj;
    }

    @Nullable
    /* JADX INFO: renamed from: F */
    public Vec3 m1151F() {
        return this.f1527aJ;
    }

    @Nullable
    /* JADX INFO: renamed from: G */
    public Vec3 m1152G() {
        return this.f1528aK;
    }

    /* JADX INFO: renamed from: p */
    public void m1153p(@NotNull Vec3 vec3) {
        this.f1527aJ = m1164b(vec3);
        this.f1530tj++;
    }

    /* JADX INFO: renamed from: q */
    public void m1154q(@NotNull Vec3 vec3) {
        this.f1528aK = m1164b(vec3);
        this.f1530tj++;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public ObjectList<Vec3> m1155h() {
        return ObjectLists.unmodifiable(this.f1529ab);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1156a(@NotNull Vec3 vec3) {
        Vec3 vec3M1164b = m1164b(vec3);
        if (!this.f1529ab.isEmpty() && ((Vec3) this.f1529ab.getLast()).equals(vec3M1164b)) {
            return false;
        }
        this.f1529ab.add(vec3M1164b);
        this.f1530tj++;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void m1157b(int i, @NotNull Vec3 vec3) {
        this.f1529ab.set(i, m1164b(vec3));
        this.f1530tj++;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1158a(@NotNull Direction direction, @NotNull Vec3 vec3) {
        if (this.f1527aJ == null || this.f1528aK == null) {
            return false;
        }
        Direction.Axis axis = direction.getAxis();
        double dM1165b = m1165b(axis.choose(vec3.x, vec3.y, vec3.z));
        double dChoose = axis.choose(this.f1527aJ.x, this.f1527aJ.y, this.f1527aJ.z);
        double dChoose2 = axis.choose(this.f1528aK.x, this.f1528aK.y, this.f1528aK.z);
        if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE ? dChoose >= dChoose2 : dChoose <= dChoose2) {
            m1153p(m1159a(this.f1527aJ, axis, dM1165b));
            return true;
        }
        m1154q(m1159a(this.f1528aK, axis, dM1165b));
        return true;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/f$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: z */
        static final /* synthetic */ int[] f1531z = new int[Direction.Axis.values().length];

        static {
            try {
                f1531z[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1531z[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1531z[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static Vec3 m1159a(@NotNull Vec3 vec3, @NotNull Direction.Axis axis, double d) throws MatchException {
        switch (AnonymousClass1.f1531z[axis.ordinal()]) {
            case 1:
                return new Vec3(d, vec3.y, vec3.z);
            case 2:
                return new Vec3(vec3.x, d, vec3.z);
            case 3:
                return new Vec3(vec3.x, vec3.y, d);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: H */
    public Vec3 m1160H() {
        if (this.f1529ab.isEmpty()) {
            return null;
        }
        return (Vec3) this.f1529ab.getLast();
    }

    /* JADX INFO: renamed from: dB */
    public void m1161dB() {
        this.f1527aJ = null;
        this.f1528aK = null;
        this.f1529ab.clear();
        this.f1530tj++;
    }

    /* JADX INFO: renamed from: bu */
    public boolean m1162bu() {
        return this.f1527aJ == null && this.f1528aK == null && this.f1529ab.isEmpty();
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public AABB m1163j() {
        if (this.f1527aJ == null || this.f1528aK == null) {
            return null;
        }
        return new AABB(this.f1527aJ, this.f1528aK);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Vec3 m1164b(@NotNull Vec3 vec3) {
        return new Vec3(m1165b(vec3.x), m1165b(vec3.y), m1165b(vec3.z));
    }

    /* JADX INFO: renamed from: b */
    public static double m1165b(double d) {
        return Math.round(d / 0.25d) * 0.25d;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0806oY m1166c() {
        if (this.f1526a == a.BOUNDARY) {
            if (this.f1529ab.size() < 3) {
                return null;
            }
            C0806oY c0806oY = new C0806oY();
            ObjectListIterator it = this.f1529ab.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                c0806oY.m4165a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            return c0806oY;
        }
        AABB aabbM1163j = m1163j();
        if (aabbM1163j == null) {
            return null;
        }
        C0806oY c0806oY2 = new C0806oY();
        c0806oY2.m4165a(new Vec2((float) aabbM1163j.minX, (float) aabbM1163j.minZ));
        c0806oY2.m4165a(new Vec2((float) aabbM1163j.maxX, (float) aabbM1163j.minZ));
        c0806oY2.m4165a(new Vec2((float) aabbM1163j.maxX, (float) aabbM1163j.maxZ));
        c0806oY2.m4165a(new Vec2((float) aabbM1163j.minX, (float) aabbM1163j.maxZ));
        return c0806oY2;
    }

    /* JADX INFO: renamed from: b */
    public void m1167b(@NotNull C0186f c0186f) {
        this.f1526a = c0186f.f1526a;
        this.f1527aJ = c0186f.f1527aJ;
        this.f1528aK = c0186f.f1528aK;
        this.f1529ab.clear();
        this.f1529ab.addAll(c0186f.f1529ab);
        this.f1530tj++;
    }

    /* JADX INFO: renamed from: d */
    public void m1168d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f1526a);
        friendlyByteBuf.writeBoolean(this.f1527aJ != null);
        if (this.f1527aJ != null) {
            friendlyByteBuf.writeVec3(this.f1527aJ);
        }
        friendlyByteBuf.writeBoolean(this.f1528aK != null);
        if (this.f1528aK != null) {
            friendlyByteBuf.writeVec3(this.f1528aK);
        }
        friendlyByteBuf.writeVarInt(this.f1529ab.size());
        ObjectListIterator it = this.f1529ab.iterator();
        while (it.hasNext()) {
            friendlyByteBuf.writeVec3((Vec3) it.next());
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1169f(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1526a = (a) friendlyByteBuf.readEnum(a.class);
        this.f1527aJ = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.f1528aK = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.f1529ab.clear();
        int varInt = friendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            this.f1529ab.add(friendlyByteBuf.readVec3());
        }
        this.f1530tj++;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/f$a.class */
    public enum a {
        AABB("AABB", -12529409),
        BOUNDARY("Boundary", -12224);


        @NotNull
        private final String displayName;
        private final int displayColor;

        a(@NotNull String str, int i) {
            this.displayName = str;
            this.displayColor = i;
        }

        @NotNull
        public String displayName() {
            return this.displayName;
        }

        public int displayColor() {
            return this.displayColor;
        }

        @NotNull
        public a next() {
            a[] aVarArrValues = values();
            return aVarArrValues[(ordinal() + 1) % aVarArrValues.length];
        }
    }
}
