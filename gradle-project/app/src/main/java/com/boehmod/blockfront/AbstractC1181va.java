package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.va */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/va.class */
public abstract class AbstractC1181va<L extends Level, E extends LivingEntity, H extends AbstractC0184c<?>, M extends AbstractC0531jN<H, ?, ?>> {

    /* JADX INFO: renamed from: uq */
    public static final int f6423uq = 200;

    /* JADX INFO: renamed from: ur */
    private static final int f6424ur = 8;

    /* JADX INFO: renamed from: bf */
    private static final double f6425bf = 1.0E-6d;

    /* JADX INFO: renamed from: bg */
    private static final double f6426bg = 1.0E-4d;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected C1189vi f6430c;

    /* JADX INFO: renamed from: e */
    protected final H f6436e;

    /* JADX INFO: renamed from: cm */
    @NotNull
    protected final List<C1114uM> f6427cm = new ObjectArrayList();

    /* JADX INFO: renamed from: f */
    @NotNull
    protected final IntSet f6428f = new IntOpenHashSet();

    /* JADX INFO: renamed from: cn */
    @NotNull
    protected final List<C1115uN> f6429cn = new ObjectArrayList();

    /* JADX INFO: renamed from: nR */
    protected float f6431nR = 0.0f;

    /* JADX INFO: renamed from: au */
    @Nullable
    protected Vec3 f6432au = null;

    /* JADX INFO: renamed from: f */
    @Nullable
    private BlockPos f6433f = null;

    /* JADX INFO: renamed from: e */
    @Nullable
    private Direction f6434e = null;

    /* JADX INFO: renamed from: bh */
    protected double f6435bh = 0.0d;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract Vec3 mo6715a(@NotNull E e, @NotNull C1117uP c1117uP);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6716a(@NotNull E e, @NotNull C1117uP c1117uP, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec4);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6717a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C1115uN> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6718a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C1114uM> list);

    /* JADX INFO: renamed from: a */
    protected abstract Vec3 mo6719a(@NotNull E e, @NotNull RandomSource randomSource, @NotNull C1199vs c1199vs, int i, long j);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6735a(@NotNull C0057aa c0057aa);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6736a(@NotNull C0029Z c0029z);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract InterfaceC1261xA mo6737a(@NotNull M m, @NotNull L l);

    public AbstractC1181va(@NotNull H h, @NotNull C1189vi c1189vi) {
        this.f6436e = h;
        this.f6430c = c1189vi;
    }

    /* JADX INFO: renamed from: bd */
    public void m6708bd() {
        this.f6427cm.clear();
        this.f6428f.clear();
        this.f6429cn.clear();
        this.f6431nR = 0.0f;
        this.f6432au = null;
        this.f6433f = null;
        this.f6434e = null;
        this.f6435bh = 0.0d;
    }

    @NotNull
    /* JADX INFO: renamed from: aN */
    public List<C1114uM> m6709aN() {
        return this.f6427cm;
    }

    @NotNull
    /* JADX INFO: renamed from: aO */
    public List<C1115uN> m6710aO() {
        return this.f6429cn;
    }

    /* JADX INFO: renamed from: a */
    public void m6711a(@NotNull C1189vi c1189vi) {
        this.f6430c = c1189vi;
    }

    /* JADX INFO: renamed from: b */
    public void m6712b(@NotNull C1189vi c1189vi) {
        m6708bd();
        m6711a(c1189vi);
    }

    /* JADX INFO: renamed from: a */
    public void mo6713a(@NotNull M m, @NotNull L l, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull E e, @NotNull C1117uP c1117uP, @NotNull C1199vs c1199vs, long j, long j2, int i) {
        Vec3 vec3Mo6719a = mo6719a(e, randomSource, c1199vs, i, j2);
        Vec3 vec3Mo6714a = mo6714a(e);
        m6723a(m, l, e, new ClipContext(vec3Mo6714a, vec3Mo6714a.add(vec3Mo6719a.scale(c1117uP.m6367co())), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, e), vec3Mo6719a);
        mo6718a(m, l, e, this.f6427cm);
        mo6717a(m, l, e, this.f6429cn, randomSource, random, j, j2, i);
        if (this.f6432au != null) {
            mo6716a(e, c1117uP, randomSource, e.getEyePosition().add(mo6715a(e, c1117uP)), this.f6432au);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Vec3 mo6714a(@NotNull E e) {
        return e.getEyePosition();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected static Vec3 m6720a(@NotNull Vec2 vec2, @NotNull C1202vv c1202vv, int i, long j, float f, float f2) {
        Vec2 vec2M6882a = c1202vv.m6882a(i, j);
        return C1270xJ.m7180a(m6722a(vec2, f2), vec2M6882a.y * f, vec2M6882a.x * f);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected static Vec3 m6721a(@NotNull Vec2 vec2, @NotNull RandomSource randomSource, float f, float f2) {
        float fNextGaussian = (float) (((double) f) * randomSource.nextGaussian());
        return C1270xJ.m7180a(m6722a(vec2, f2), (float) (((double) f) * randomSource.nextGaussian()), fNextGaussian);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Vec2 m6722a(@NotNull Vec2 vec2, float f) {
        return new Vec2(vec2.x - f, vec2.y);
    }

    /* JADX INFO: renamed from: a */
    private void m6723a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull ClipContext clipContext, @NotNull Vec3 vec3) {
        Vec3 to = clipContext.getTo();
        Vec3 from = clipContext.getFrom();
        double dDistanceTo = to.distanceTo(from);
        BlockGetter.traverseBlocks(from, to, clipContext, (clipContext2, blockPos) -> {
            return m6725a(m, l, e, vec3, from, to, dDistanceTo);
        }, AbstractC1181va::m6724b);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static BlockHitResult m6724b(@NotNull ClipContext clipContext) {
        Vec3 to = clipContext.getTo();
        Vec3 vec3Subtract = clipContext.getFrom().subtract(to);
        return BlockHitResult.miss(to, Direction.getNearest(vec3Subtract.x, vec3Subtract.y, vec3Subtract.z), BlockPos.containing(to));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private BlockHitResult m6725a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5, double d) {
        C1127uZ c1127uZM6425a;
        Vec3 vec3Normalize = vec5.subtract(vec4).normalize();
        Vec3 vec3Add = vec4.add(vec3Normalize.scale(this.f6435bh));
        if (this.f6433f != null && this.f6434e != null) {
            BlockPos blockPosRelative = this.f6433f.relative(this.f6434e, 1);
            BlockState blockState = l.getBlockState(blockPosRelative);
            VoxelShape collisionShape = blockState.getCollisionShape(l, blockPosRelative);
            boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
            if (blockState.isAir() || blockState.liquid() || z) {
                this.f6427cm.add(new C1114uM(this.f6433f, this.f6434e, vec3Add));
            }
            this.f6433f = null;
            this.f6434e = null;
        }
        BlockHitResult blockHitResultM6532a = C1138uk.m6532a(l, new ClipContext(vec3Add, vec5, ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty()));
        BlockPos blockPos = blockHitResultM6532a.getBlockPos();
        BlockState blockState2 = l.getBlockState(blockPos);
        Vec3 location = blockHitResultM6532a.getLocation();
        Direction direction = blockHitResultM6532a.getDirection();
        float fLeftFloat = this.f6430c.m6768c((float) location.distanceTo(e.position())).leftFloat();
        this.f6432au = location;
        mo6735a(new C0057aa(vec3Add, location, 200, true, C1270xJ.m7178a(65280, 16711680, Mth.clamp(this.f6431nR / fLeftFloat, 0.0f, 1.0f))));
        m6731a((AbstractC0531jN) m, (Level) l, (LivingEntity) e, vec3, vec3Add, location, d);
        if (this.f6435bh < d && this.f6431nR < fLeftFloat && this.f6427cm.size() < 8 && (c1127uZM6425a = C1292xf.m7328a(l, blockState2, blockPos).m6425a()) != null && !blockState2.isAir() && c1127uZM6425a.m6469bE() != -1.0f) {
            m6726a(m, l, e, vec3, d, c1127uZM6425a, location, direction, vec3Normalize, blockPos, vec3Add, blockState2, blockHitResultM6532a);
            return null;
        }
        mo6735a(new C0057aa(vec3Add.subtract(0.0d, 0.5d, 0.0d), vec3Add.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        mo6735a(new C0057aa(location.subtract(0.0d, 0.5d, 0.0d), location.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        m6730a(l, blockState2, blockPos, direction, blockHitResultM6532a);
        return blockHitResultM6532a;
    }

    /* JADX INFO: renamed from: a */
    private void m6726a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, double d, @NotNull C1127uZ c1127uZ, @NotNull Vec3 vec4, @NotNull Direction direction, @NotNull Vec3 vec5, @NotNull BlockPos blockPos, @NotNull Vec3 vec6, @NotNull BlockState blockState, @NotNull BlockHitResult blockHitResult) {
        this.f6431nR += c1127uZ.m6469bE();
        m6731a((AbstractC0531jN) m, (Level) l, (LivingEntity) e, vec3, vec6, vec4, d);
        Vec3 vec3M6728a = m6728a(l, vec4, vec5, blockState, blockPos);
        mo6735a(new C0057aa(vec6.subtract(0.0d, 0.5d, 0.0d), vec6.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        mo6735a(new C0057aa(vec3M6728a.subtract(0.0d, 0.5d, 0.0d), vec3M6728a.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        this.f6435bh += vec6.distanceTo(vec4) + vec4.distanceTo(vec3M6728a);
        m6730a(l, blockState, blockPos, direction, blockHitResult);
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        this.f6433f = blockPos;
        this.f6434e = m6727a(vec3M6728a, blockPos, collisionShape);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Direction m6727a(@NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull VoxelShape voxelShape) {
        double d = Double.MAX_VALUE;
        Direction direction = Direction.NORTH;
        Iterator it = voxelShape.toAabbs().iterator();
        while (it.hasNext()) {
            AABB aabbMove = ((AABB) it.next()).move(blockPos);
            double dAbs = Math.abs(vec3.x - aabbMove.minX);
            double dAbs2 = Math.abs(vec3.x - aabbMove.maxX);
            double dAbs3 = Math.abs(vec3.y - aabbMove.minY);
            double dAbs4 = Math.abs(vec3.y - aabbMove.maxY);
            double dAbs5 = Math.abs(vec3.z - aabbMove.minZ);
            double dAbs6 = Math.abs(vec3.z - aabbMove.maxZ);
            if (dAbs < d - f6425bf) {
                d = dAbs;
                direction = Direction.WEST;
            }
            if (dAbs2 < d - f6425bf) {
                d = dAbs2;
                direction = Direction.EAST;
            }
            if (dAbs3 < d - f6425bf) {
                d = dAbs3;
                direction = Direction.DOWN;
            }
            if (dAbs4 < d - f6425bf) {
                d = dAbs4;
                direction = Direction.UP;
            }
            if (dAbs5 < d - f6425bf) {
                d = dAbs5;
                direction = Direction.NORTH;
            }
            if (dAbs6 < d - f6425bf) {
                d = dAbs6;
                direction = Direction.SOUTH;
            }
        }
        return direction;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Vec3 m6728a(@NotNull L l, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        return m6729a(vec3.add(vec4.normalize().scale(0.001d)), vec4, collisionShape, blockPos).orElse(vec3);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Optional<Vec3> m6729a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull VoxelShape voxelShape, @NotNull BlockPos blockPos) {
        double d = Double.POSITIVE_INFINITY;
        Vec3 vec5 = null;
        Iterator it = voxelShape.toAabbs().iterator();
        while (it.hasNext()) {
            Optional<Vec3> optionalM7182a = C1270xJ.m7182a(vec3, vec4, ((AABB) it.next()).move(blockPos));
            if (optionalM7182a.isPresent()) {
                Vec3 vec6 = optionalM7182a.get();
                double dDistanceToSqr = vec3.distanceToSqr(vec6);
                if (dDistanceToSqr < d) {
                    d = dDistanceToSqr;
                    vec5 = vec6;
                }
            }
        }
        return Optional.ofNullable(vec5);
    }

    /* JADX INFO: renamed from: a */
    private void m6730a(@NotNull L l, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull BlockHitResult blockHitResult) {
        if (blockState.isAir()) {
            return;
        }
        BlockState blockState2 = l.getBlockState(blockPos.relative(direction, 1));
        VoxelShape collisionShape = blockState2.getCollisionShape(l, blockPos);
        boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
        if (blockState2.isAir() || blockState2.liquid() || z) {
            this.f6427cm.add(new C1114uM(blockPos, direction, blockHitResult.getLocation()));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6731a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5, double d) {
        AABB aabbExpandTowards = e.getBoundingBox().expandTowards(vec3.scale(d));
        mo6735a(new C0057aa(vec4.add(0.0d, 0.10000000149011612d, 0.0d), vec5.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, 2237183));
        ObjectArrayList objectArrayList = new ObjectArrayList();
        try {
            for (C0543jZ c0543jZ : mo6737a(m, l).mo7124a((AbstractC0531jN<?, ?, ?>) m, aabbExpandTowards, e)) {
                if (c0543jZ.m2451aj()) {
                    Vec3 vec3OrElse = m6732a(c0543jZ.m2447g(), vec4, vec5).orElse(null);
                    if (vec3OrElse != null) {
                        objectArrayList.add(new C1184vd(c0543jZ, vec3OrElse, vec4.distanceToSqr(vec3OrElse)));
                    }
                }
            }
        } catch (ConcurrentModificationException e2) {
            C0530jM.log("Concurrent modification exception while processing potential entity hits", new Object[0]);
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6748w();
        }));
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            m6733a(vec4, vec5, e, ((C1184vd) it.next()).m6746b());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Optional<Vec3> m6732a(@NotNull AABB aabb, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        Optional<Vec3> optionalClip = aabb.clip(vec3, vec4);
        if (optionalClip.isPresent()) {
            return optionalClip;
        }
        if (aabb.inflate(f6426bg).contains(vec3)) {
            return Optional.of(vec3);
        }
        return Optional.empty();
    }

    /* JADX INFO: renamed from: a */
    private void m6733a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull E e, @NotNull C0543jZ c0543jZ) {
        m6734b(vec3, vec4, e, c0543jZ);
    }

    /* JADX INFO: renamed from: b */
    private void m6734b(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull E e, @NotNull C0543jZ c0543jZ) {
        int iM2445aB = c0543jZ.m2445aB();
        Vec3 vec3OrElse = m6732a(c0543jZ.m2447g(), vec3, vec4).orElse(null);
        mo6736a(new C0029Z(c0543jZ.m2447g(), 200, true, 65535));
        ItemStack mainHandItem = e.getMainHandItem();
        boolean z = false;
        if ((mainHandItem.getItem() instanceof C1117uP) && (e instanceof Player) && C1117uP.m6261d(mainHandItem) && !C1117uP.f6063il) {
            z = true;
        }
        if (vec3OrElse != null && !this.f6428f.contains(iM2445aB)) {
            AABB aabbM2441e = c0543jZ.m2441e();
            AABB aabbM2442f = c0543jZ.m2442f();
            boolean z2 = aabbM2441e != null && aabbM2441e.contains(vec3OrElse);
            boolean z3 = aabbM2442f != null && aabbM2442f.contains(vec3OrElse);
            if (z2) {
                mo6736a(new C0029Z(aabbM2441e, 200, true, 16711680));
            }
            if (z3) {
                mo6736a(new C0029Z(aabbM2442f, 200, true, 65280));
            }
            C1115uN c1115uN = new C1115uN(iM2445aB, this.f6431nR, z2, !this.f6429cn.isEmpty(), z, z3, e.getDirection(), vec3OrElse);
            this.f6428f.add(iM2445aB);
            this.f6429cn.add(c1115uN);
        }
    }
}
