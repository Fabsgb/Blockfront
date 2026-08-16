package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0882pu;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/f.class */
public final class C0187f {

    /* JADX INFO: renamed from: bj */
    public static final double f1446bj = 0.25d;

    /* JADX INFO: renamed from: vm */
    public static final int f1447vm = 3;

    /* JADX INFO: renamed from: aK */
    @Nullable
    private Vec3 f1449aK;

    /* JADX INFO: renamed from: aL */
    @Nullable
    private Vec3 f1450aL;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f1448a = a.AABB;

    /* JADX INFO: renamed from: ak */
    @NotNull
    private final ObjectList<Vec3> f1451ak = new ObjectArrayList();

    /* JADX INFO: renamed from: vn */
    private int f1452vn = 0;

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m1165a() {
        return this.f1448a;
    }

    /* JADX INFO: renamed from: a */
    public void m1166a(@NotNull a aVar) {
        this.f1448a = aVar;
        m1178dL();
    }

    /* JADX INFO: renamed from: cN */
    public int m1167cN() {
        return this.f1452vn;
    }

    @Nullable
    /* JADX INFO: renamed from: G */
    public Vec3 m1168G() {
        return this.f1449aK;
    }

    @Nullable
    /* JADX INFO: renamed from: H */
    public Vec3 m1169H() {
        return this.f1450aL;
    }

    /* JADX INFO: renamed from: p */
    public void m1170p(@NotNull Vec3 vec3) {
        this.f1449aK = m1181b(vec3);
        this.f1452vn++;
    }

    /* JADX INFO: renamed from: q */
    public void m1171q(@NotNull Vec3 vec3) {
        this.f1450aL = m1181b(vec3);
        this.f1452vn++;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public ObjectList<Vec3> m1172l() {
        return ObjectLists.unmodifiable(this.f1451ak);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1173a(@NotNull Vec3 vec3) {
        Vec3 vec3M1181b = m1181b(vec3);
        if (!this.f1451ak.isEmpty() && ((Vec3) this.f1451ak.getLast()).equals(vec3M1181b)) {
            return false;
        }
        this.f1451ak.add(vec3M1181b);
        this.f1452vn++;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void m1174b(int i, @NotNull Vec3 vec3) {
        this.f1451ak.set(i, m1181b(vec3));
        this.f1452vn++;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1175a(@NotNull Direction direction, @NotNull Vec3 vec3) {
        boolean z;
        if (this.f1449aK == null || this.f1450aL == null) {
            return false;
        }
        Direction.Axis axis = direction.getAxis();
        double dM1182b = m1182b(axis.choose(vec3.x, vec3.y, vec3.z));
        double dChoose = axis.choose(this.f1449aK.x, this.f1449aK.y, this.f1449aK.z);
        double dChoose2 = axis.choose(this.f1450aL.x, this.f1450aL.y, this.f1450aL.z);
        if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
            z = dChoose >= dChoose2;
        } else {
            z = dChoose <= dChoose2;
        }
        if (z) {
            m1170p(m1176a(this.f1449aK, axis, dM1182b));
            return true;
        }
        m1171q(m1176a(this.f1450aL, axis, dM1182b));
        return true;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/f$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f1453B = new int[Direction.Axis.values().length];

        static {
            try {
                f1453B[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1453B[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1453B[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static Vec3 m1176a(@NotNull Vec3 vec3, @NotNull Direction.Axis axis, double d) throws MatchException {
        switch (AnonymousClass1.f1453B[axis.ordinal()]) {
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
    /* JADX INFO: renamed from: I */
    public Vec3 m1177I() {
        if (this.f1451ak.isEmpty()) {
            return null;
        }
        return (Vec3) this.f1451ak.getLast();
    }

    /* JADX INFO: renamed from: dL */
    public void m1178dL() {
        this.f1449aK = null;
        this.f1450aL = null;
        this.f1451ak.clear();
        this.f1452vn++;
    }

    /* JADX INFO: renamed from: bE */
    public boolean m1179bE() {
        return this.f1449aK == null && this.f1450aL == null && this.f1451ak.isEmpty();
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public AABB m1180j() {
        if (this.f1449aK == null || this.f1450aL == null) {
            return null;
        }
        return new AABB(this.f1449aK, this.f1450aL);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Vec3 m1181b(@NotNull Vec3 vec3) {
        return new Vec3(m1182b(vec3.x), m1182b(vec3.y), m1182b(vec3.z));
    }

    /* JADX INFO: renamed from: b */
    public static double m1182b(double d) {
        return Math.round(d / 0.25d) * 0.25d;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0882pu m1183c() {
        if (this.f1448a == a.BOUNDARY) {
            if (this.f1451ak.size() < 3) {
                return null;
            }
            C0882pu c0882pu = new C0882pu();
            ObjectListIterator it = this.f1451ak.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                c0882pu.m4602a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            return c0882pu;
        }
        AABB aabbM1180j = m1180j();
        if (aabbM1180j == null) {
            return null;
        }
        C0882pu c0882pu2 = new C0882pu();
        c0882pu2.m4602a(new Vec2((float) aabbM1180j.minX, (float) aabbM1180j.minZ));
        c0882pu2.m4602a(new Vec2((float) aabbM1180j.maxX, (float) aabbM1180j.minZ));
        c0882pu2.m4602a(new Vec2((float) aabbM1180j.maxX, (float) aabbM1180j.maxZ));
        c0882pu2.m4602a(new Vec2((float) aabbM1180j.minX, (float) aabbM1180j.maxZ));
        return c0882pu2;
    }

    /* JADX INFO: renamed from: b */
    public void m1184b(@NotNull C0187f c0187f) {
        this.f1448a = c0187f.f1448a;
        this.f1449aK = c0187f.f1449aK;
        this.f1450aL = c0187f.f1450aL;
        this.f1451ak.clear();
        this.f1451ak.addAll(c0187f.f1451ak);
        this.f1452vn++;
    }

    /* JADX INFO: renamed from: d */
    public void m1185d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.f1448a);
        friendlyByteBuf.writeBoolean(this.f1449aK != null);
        if (this.f1449aK != null) {
            friendlyByteBuf.writeVec3(this.f1449aK);
        }
        friendlyByteBuf.writeBoolean(this.f1450aL != null);
        if (this.f1450aL != null) {
            friendlyByteBuf.writeVec3(this.f1450aL);
        }
        friendlyByteBuf.writeVarInt(this.f1451ak.size());
        ObjectListIterator it = this.f1451ak.iterator();
        while (it.hasNext()) {
            friendlyByteBuf.writeVec3((Vec3) it.next());
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1186f(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1448a = (a) friendlyByteBuf.readEnum(a.class);
        this.f1449aK = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.f1450aL = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.f1451ak.clear();
        int varInt = friendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            this.f1451ak.add(friendlyByteBuf.readVec3());
        }
        this.f1452vn++;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/f$a.class */
    public enum a {
        AABB("AABB", -12529409),
        BOUNDARY("Boundary", -12224);


        @NotNull
        private final String displayName;
        private final int displayColor;

        a(String str, int i) {
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
