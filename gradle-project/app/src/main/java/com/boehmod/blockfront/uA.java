package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.common.player.c;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uA.class */
public abstract class uA<L extends Level, E extends LivingEntity, H extends com.boehmod.blockfront.common.player.c<?>, M extends AbstractC0264ju<H, ?, ?>> {
    public static final int sk = 200;
    private static final int sl = 8;
    private static final double aS = 1.0E-6d;

    @NotNull
    protected uI c;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    protected final H f304e;

    @NotNull
    protected final List<C0555uo> cd = new ObjectArrayList();

    @NotNull
    protected final IntSet d = new IntOpenHashSet();

    @NotNull
    protected final List<C0556up> ce = new ObjectArrayList();
    protected float mS = 0.0f;

    @Nullable
    protected Vec3 at = null;

    @Nullable
    private BlockPos f = null;

    @Nullable
    private Direction e = null;
    protected double aT = 0.0d;

    @NotNull
    protected abstract Vec3 a(@NotNull E e, @NotNull C0558ur c0558ur);

    protected abstract void a(@NotNull E e, @NotNull C0558ur c0558ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32);

    protected abstract void a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C0556up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i);

    protected abstract void a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C0555uo> list);

    protected abstract Vec3 a(@NotNull E e, @NotNull RandomSource randomSource, @NotNull uS uSVar, int i, long j);

    protected abstract void a(@NotNull U u);

    protected abstract void a(@NotNull T t);

    @NotNull
    protected abstract InterfaceC0625xd a(@NotNull M m, @NotNull L l);

    public uA(@NotNull H h, @NotNull uI uIVar) {
        this.f304e = h;
        this.c = uIVar;
    }

    public void bf() {
        this.cd.clear();
        this.d.clear();
        this.ce.clear();
        this.mS = 0.0f;
        this.at = null;
        this.f = null;
        this.e = null;
        this.aT = 0.0d;
    }

    public void a(@NotNull uI uIVar) {
        this.c = uIVar;
    }

    public void b(@NotNull uI uIVar) {
        bf();
        a(uIVar);
    }

    public void a(@NotNull M m, @NotNull L l, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull E e, @NotNull C0558ur c0558ur, long j, long j2, int i) {
        Vec3 vec3A = a(e, randomSource, c0558ur.m1210a(), i, j2);
        Vec3 vec3A2 = a(e);
        a(m, l, e, new ClipContext(vec3A2, vec3A2.add(vec3A.scale(c0558ur.bZ())), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, e), vec3A);
        a(m, l, e, this.cd);
        a(m, l, e, this.ce, randomSource, random, j, j2, i);
        if (this.at != null) {
            a(e, c0558ur, randomSource, e.getEyePosition().add(a(e, c0558ur)), this.at);
        }
    }

    @NotNull
    protected Vec3 a(@NotNull E e) {
        return e.getEyePosition();
    }

    @NotNull
    protected static Vec3 a(@NotNull Vec2 vec2, @NotNull uV uVVar, int i, long j, float f, float f2) {
        Vec2 vec2A = uVVar.a(i, j);
        return C0634xm.a(a(vec2, f2), vec2A.y * f, vec2A.x * f);
    }

    @NotNull
    protected static Vec3 a(@NotNull Vec2 vec2, @NotNull RandomSource randomSource, float f, float f2) {
        float fNextGaussian = (float) (((double) f) * randomSource.nextGaussian());
        return C0634xm.a(a(vec2, f2), (float) (((double) f) * randomSource.nextGaussian()), fNextGaussian);
    }

    @NotNull
    private static Vec2 a(@NotNull Vec2 vec2, float f) {
        return new Vec2(vec2.x - f, vec2.y);
    }

    private void a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull ClipContext clipContext, @NotNull Vec3 vec3) {
        Vec3 to = clipContext.getTo();
        Vec3 from = clipContext.getFrom();
        double dDistanceTo = to.distanceTo(from);
        BlockGetter.traverseBlocks(from, to, clipContext, (clipContext2, blockPos) -> {
            return a(m, l, e, vec3, from, to, dDistanceTo);
        }, uA::b);
    }

    @NotNull
    private static BlockHitResult b(@NotNull ClipContext clipContext) {
        Vec3 to = clipContext.getTo();
        Vec3 vec3Subtract = clipContext.getFrom().subtract(to);
        return BlockHitResult.miss(to, Direction.getNearest(vec3Subtract.x, vec3Subtract.y, vec3Subtract.z), BlockPos.containing(to));
    }

    @Nullable
    private BlockHitResult a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, double d) {
        C0566uz c0566uzA;
        Vec3 vec3Normalize = vec33.subtract(vec32).normalize();
        Vec3 vec3Add = vec32.add(vec3Normalize.scale(this.aT));
        if (this.f != null && this.e != null) {
            BlockPos blockPosRelative = this.f.relative(this.e, 1);
            BlockState blockState = l.getBlockState(blockPosRelative);
            VoxelShape collisionShape = blockState.getCollisionShape(l, blockPosRelative);
            boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
            if (blockState.isAir() || blockState.liquid() || z) {
                this.cd.add(new C0555uo(this.f, this.e, vec3Add));
            }
            this.f = null;
            this.e = null;
        }
        BlockHitResult blockHitResultA = tM.a(l, new ClipContext(vec3Add, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty()));
        BlockPos blockPos = blockHitResultA.getBlockPos();
        BlockState blockState2 = l.getBlockState(blockPos);
        Vec3 location = blockHitResultA.getLocation();
        Direction direction = blockHitResultA.getDirection();
        float fLeftFloat = this.c.c((float) location.distanceTo(e.position())).leftFloat();
        this.at = location;
        a(new U(vec3Add, location, 200, true, C0634xm.a(65280, 16711680, Mth.clamp(this.mS / fLeftFloat, 0.0f, 1.0f))));
        m1166a((AbstractC0264ju) m, (Level) l, (LivingEntity) e, vec3, vec3Add, location, d);
        if (this.aT < d && this.mS < fLeftFloat && this.cd.size() < 8 && (c0566uzA = wI.a(l, blockState2, blockPos).a()) != null && !blockState2.isAir() && c0566uzA.by() != -1.0f) {
            a(m, l, e, vec3, d, c0566uzA, location, direction, vec3Normalize, blockPos, vec3Add, blockState2, blockHitResultA);
            return null;
        }
        a(new U(vec3Add.subtract(0.0d, 0.5d, 0.0d), vec3Add.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        a(new U(location.subtract(0.0d, 0.5d, 0.0d), location.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        a(l, blockState2, blockPos, direction, blockHitResultA);
        return blockHitResultA;
    }

    private void a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, double d, @NotNull C0566uz c0566uz, @NotNull Vec3 vec32, @NotNull Direction direction, @NotNull Vec3 vec33, @NotNull BlockPos blockPos, @NotNull Vec3 vec34, @NotNull BlockState blockState, @NotNull BlockHitResult blockHitResult) {
        this.mS += c0566uz.by();
        m1166a((AbstractC0264ju) m, (Level) l, (LivingEntity) e, vec3, vec34, vec32, d);
        Vec3 vec3A = a(l, vec32, vec33, blockState, blockPos);
        a(new U(vec34.subtract(0.0d, 0.5d, 0.0d), vec34.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        a(new U(vec3A.subtract(0.0d, 0.5d, 0.0d), vec3A.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        this.aT += vec34.distanceTo(vec32) + vec32.distanceTo(vec3A);
        a(l, blockState, blockPos, direction, blockHitResult);
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        this.f = blockPos;
        this.e = a(vec3A, blockPos, collisionShape);
    }

    @NotNull
    private static Direction a(@NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull VoxelShape voxelShape) {
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
            if (dAbs < d - aS) {
                d = dAbs;
                direction = Direction.WEST;
            }
            if (dAbs2 < d - aS) {
                d = dAbs2;
                direction = Direction.EAST;
            }
            if (dAbs3 < d - aS) {
                d = dAbs3;
                direction = Direction.DOWN;
            }
            if (dAbs4 < d - aS) {
                d = dAbs4;
                direction = Direction.UP;
            }
            if (dAbs5 < d - aS) {
                d = dAbs5;
                direction = Direction.NORTH;
            }
            if (dAbs6 < d - aS) {
                d = dAbs6;
                direction = Direction.SOUTH;
            }
        }
        return direction;
    }

    @NotNull
    private Vec3 a(@NotNull L l, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        return a(vec3.add(vec32.normalize().scale(0.001d)), vec32, collisionShape, blockPos).orElse(vec3);
    }

    @NotNull
    private Optional<Vec3> a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull VoxelShape voxelShape, @NotNull BlockPos blockPos) {
        double d = Double.POSITIVE_INFINITY;
        Vec3 vec33 = null;
        Iterator it = voxelShape.toAabbs().iterator();
        while (it.hasNext()) {
            Optional<Vec3> optionalA = C0634xm.a(vec3, vec32, ((AABB) it.next()).move(blockPos));
            if (optionalA.isPresent()) {
                Vec3 vec34 = optionalA.get();
                double dDistanceToSqr = vec3.distanceToSqr(vec34);
                if (dDistanceToSqr < d) {
                    d = dDistanceToSqr;
                    vec33 = vec34;
                }
            }
        }
        return Optional.ofNullable(vec33);
    }

    private void a(@NotNull L l, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull BlockHitResult blockHitResult) {
        if (blockState.isAir()) {
            return;
        }
        BlockState blockState2 = l.getBlockState(blockPos.relative(direction, 1));
        VoxelShape collisionShape = blockState2.getCollisionShape(l, blockPos);
        boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
        if (blockState2.isAir() || blockState2.liquid() || z) {
            this.cd.add(new C0555uo(blockPos, direction, blockHitResult.getLocation()));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m1166a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, double d) {
        AABB aabbExpandTowards = e.getBoundingBox().expandTowards(vec3.scale(d));
        a(new U(vec32.add(0.0d, 0.10000000149011612d, 0.0d), vec33.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, 2237183));
        ObjectArrayList objectArrayList = new ObjectArrayList();
        try {
            for (jG jGVar : a(m, l).a((AbstractC0264ju<?, ?, ?>) m, aabbExpandTowards, e)) {
                if (jGVar.af()) {
                    Vec3 vec34 = (Vec3) jGVar.m513g().clip(vec32, vec33).orElse(null);
                    if (vec34 != null) {
                        objectArrayList.add(new uD(jGVar, vec34, vec32.distanceToSqr(vec34)));
                    }
                }
            }
        } catch (ConcurrentModificationException e2) {
            C0263jt.log("Concurrent modification exception while processing potential entity hits", new Object[0]);
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.u();
        }));
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            a(vec32, vec33, e, ((uD) it.next()).a());
        }
    }

    private void a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull E e, @NotNull jG jGVar) {
        b(vec3, vec32, e, jGVar);
    }

    private void b(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull E e, @NotNull jG jGVar) {
        int iAl = jGVar.al();
        Vec3 vec33 = (Vec3) jGVar.m513g().clip(vec3, vec32).orElse(null);
        a(new T(jGVar.m513g(), 200, true, 65535));
        ItemStack mainHandItem = e.getMainHandItem();
        boolean z = false;
        if ((mainHandItem.getItem() instanceof C0558ur) && (e instanceof Player) && C0558ur.d(mainHandItem) && !C0558ur.hR) {
            z = true;
        }
        if (vec33 != null && !this.d.contains(iAl)) {
            AABB aabbE = jGVar.e();
            AABB aabbF = jGVar.f();
            boolean z2 = aabbE != null && aabbE.contains(vec33);
            boolean z3 = aabbF != null && aabbF.contains(vec33);
            if (z2) {
                a(new T(aabbE, 200, true, 16711680));
            }
            if (z3) {
                a(new T(aabbF, 200, true, 65280));
            }
            C0556up c0556up = new C0556up(iAl, this.mS, z2, !this.ce.isEmpty(), z, z3, e.getDirection(), vec33);
            this.d.add(iAl);
            this.ce.add(c0556up);
        }
    }
}
