package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.oY;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/f.class */
public final class f {
    public static final double aV = 0.25d;
    public static final int ti = 3;

    @Nullable
    private Vec3 aJ;

    @Nullable
    private Vec3 aK;

    @NotNull
    private a a = a.AABB;

    @NotNull
    private final ObjectList<Vec3> ab = new ObjectArrayList();
    private int tj = 0;

    @NotNull
    public a a() {
        return this.a;
    }

    public void a(@NotNull a aVar) {
        this.a = aVar;
        dB();
    }

    public int cx() {
        return this.tj;
    }

    @Nullable
    public Vec3 F() {
        return this.aJ;
    }

    @Nullable
    public Vec3 G() {
        return this.aK;
    }

    public void p(@NotNull Vec3 vec3) {
        this.aJ = b(vec3);
        this.tj++;
    }

    public void q(@NotNull Vec3 vec3) {
        this.aK = b(vec3);
        this.tj++;
    }

    @NotNull
    public ObjectList<Vec3> h() {
        return ObjectLists.unmodifiable(this.ab);
    }

    public boolean a(@NotNull Vec3 vec3) {
        Vec3 vec3B = b(vec3);
        if (!this.ab.isEmpty() && ((Vec3) this.ab.getLast()).equals(vec3B)) {
            return false;
        }
        this.ab.add(vec3B);
        this.tj++;
        return true;
    }

    public void b(int i, @NotNull Vec3 vec3) {
        this.ab.set(i, b(vec3));
        this.tj++;
    }

    public boolean a(@NotNull Direction direction, @NotNull Vec3 vec3) {
        if (this.aJ == null || this.aK == null) {
            return false;
        }
        Direction.Axis axis = direction.getAxis();
        double dB = b(axis.choose(vec3.x, vec3.y, vec3.z));
        double dChoose = axis.choose(this.aJ.x, this.aJ.y, this.aJ.z);
        double dChoose2 = axis.choose(this.aK.x, this.aK.y, this.aK.z);
        if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE ? dChoose >= dChoose2 : dChoose <= dChoose2) {
            p(a(this.aJ, axis, dB));
            return true;
        }
        q(a(this.aK, axis, dB));
        return true;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.common.player.f$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/f$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z = new int[Direction.Axis.values().length];

        static {
            try {
                z[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                z[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                z[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    private static Vec3 a(@NotNull Vec3 vec3, @NotNull Direction.Axis axis, double d) throws MatchException {
        switch (AnonymousClass1.z[axis.ordinal()]) {
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
    public Vec3 H() {
        if (this.ab.isEmpty()) {
            return null;
        }
        return (Vec3) this.ab.getLast();
    }

    public void dB() {
        this.aJ = null;
        this.aK = null;
        this.ab.clear();
        this.tj++;
    }

    public boolean bu() {
        return this.aJ == null && this.aK == null && this.ab.isEmpty();
    }

    @Nullable
    public AABB j() {
        if (this.aJ == null || this.aK == null) {
            return null;
        }
        return new AABB(this.aJ, this.aK);
    }

    @NotNull
    public static Vec3 b(@NotNull Vec3 vec3) {
        return new Vec3(b(vec3.x), b(vec3.y), b(vec3.z));
    }

    public static double b(double d) {
        return Math.round(d / 0.25d) * 0.25d;
    }

    @Nullable
    public oY c() {
        if (this.a == a.BOUNDARY) {
            if (this.ab.size() < 3) {
                return null;
            }
            oY oYVar = new oY();
            ObjectListIterator it = this.ab.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                oYVar.a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            return oYVar;
        }
        AABB aabbJ = j();
        if (aabbJ == null) {
            return null;
        }
        oY oYVar2 = new oY();
        oYVar2.a(new Vec2((float) aabbJ.minX, (float) aabbJ.minZ));
        oYVar2.a(new Vec2((float) aabbJ.maxX, (float) aabbJ.minZ));
        oYVar2.a(new Vec2((float) aabbJ.maxX, (float) aabbJ.maxZ));
        oYVar2.a(new Vec2((float) aabbJ.minX, (float) aabbJ.maxZ));
        return oYVar2;
    }

    public void b(@NotNull f fVar) {
        this.a = fVar.a;
        this.aJ = fVar.aJ;
        this.aK = fVar.aK;
        this.ab.clear();
        this.ab.addAll(fVar.ab);
        this.tj++;
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeEnum(this.a);
        friendlyByteBuf.writeBoolean(this.aJ != null);
        if (this.aJ != null) {
            friendlyByteBuf.writeVec3(this.aJ);
        }
        friendlyByteBuf.writeBoolean(this.aK != null);
        if (this.aK != null) {
            friendlyByteBuf.writeVec3(this.aK);
        }
        friendlyByteBuf.writeVarInt(this.ab.size());
        ObjectListIterator it = this.ab.iterator();
        while (it.hasNext()) {
            friendlyByteBuf.writeVec3((Vec3) it.next());
        }
    }

    public void f(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.a = (a) friendlyByteBuf.readEnum(a.class);
        this.aJ = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.aK = friendlyByteBuf.readBoolean() ? friendlyByteBuf.readVec3() : null;
        this.ab.clear();
        int varInt = friendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            this.ab.add(friendlyByteBuf.readVec3());
        }
        this.tj++;
    }

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
