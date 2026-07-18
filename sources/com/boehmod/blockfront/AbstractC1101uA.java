package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uA.class */
public abstract class AbstractC1101uA<L extends Level, E extends LivingEntity, H extends AbstractC0183c<?>, M extends AbstractC0563ju<H, ?, ?>> {

    /* JADX INFO: renamed from: sk */
    public static final int f5783sk = 200;

    /* JADX INFO: renamed from: sl */
    private static final int f5784sl = 8;

    /* JADX INFO: renamed from: aS */
    private static final double f5785aS = 1.0E-6d;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected C1109uI f5789c;

    /* JADX INFO: renamed from: e */
    protected final H f5795e;

    /* JADX INFO: renamed from: cd */
    @NotNull
    protected final List<C1141uo> f5786cd = new ObjectArrayList();

    /* JADX INFO: renamed from: d */
    @NotNull
    protected final IntSet f5787d = new IntOpenHashSet();

    /* JADX INFO: renamed from: ce */
    @NotNull
    protected final List<C1142up> f5788ce = new ObjectArrayList();

    /* JADX INFO: renamed from: mS */
    protected float f5790mS = 0.0f;

    /* JADX INFO: renamed from: at */
    @Nullable
    protected Vec3 f5791at = null;

    /* JADX INFO: renamed from: f */
    @Nullable
    private BlockPos f5792f = null;

    /* JADX INFO: renamed from: e */
    @Nullable
    private Direction f5793e = null;

    /* JADX INFO: renamed from: aT */
    protected double f5794aT = 0.0d;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract Vec3 mo6064a(@NotNull E e, @NotNull C1144ur c1144ur);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6065a(@NotNull E e, @NotNull C1144ur c1144ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6066a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C1142up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6067a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull List<C1141uo> list);

    /* JADX INFO: renamed from: a */
    protected abstract Vec3 mo6068a(@NotNull E e, @NotNull RandomSource randomSource, @NotNull C1119uS c1119uS, int i, long j);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6083a(@NotNull C0023U c0023u);

    /* JADX INFO: renamed from: a */
    protected abstract void mo6084a(@NotNull C0022T c0022t);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract InterfaceC1281xd mo6085a(@NotNull M m, @NotNull L l);

    public AbstractC1101uA(@NotNull H h, @NotNull C1109uI c1109uI) {
        this.f5795e = h;
        this.f5789c = c1109uI;
    }

    /* JADX INFO: renamed from: bf */
    public void m6059bf() {
        this.f5786cd.clear();
        this.f5787d.clear();
        this.f5788ce.clear();
        this.f5790mS = 0.0f;
        this.f5791at = null;
        this.f5792f = null;
        this.f5793e = null;
        this.f5794aT = 0.0d;
    }

    /* JADX INFO: renamed from: a */
    public void m6060a(@NotNull C1109uI c1109uI) {
        this.f5789c = c1109uI;
    }

    /* JADX INFO: renamed from: b */
    public void m6061b(@NotNull C1109uI c1109uI) {
        m6059bf();
        m6060a(c1109uI);
    }

    /* JADX INFO: renamed from: a */
    public void mo6062a(@NotNull M m, @NotNull L l, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull E e, @NotNull C1144ur c1144ur, long j, long j2, int i) {
        Vec3 vec3Mo6068a = mo6068a(e, randomSource, c1144ur.m6347a(), i, j2);
        Vec3 vec3Mo6063a = mo6063a(e);
        m6072a(m, l, e, new ClipContext(vec3Mo6063a, vec3Mo6063a.add(vec3Mo6068a.scale(c1144ur.m6392bZ())), ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, e), vec3Mo6068a);
        mo6067a(m, l, e, this.f5786cd);
        mo6066a(m, l, e, this.f5788ce, randomSource, random, j, j2, i);
        if (this.f5791at != null) {
            mo6065a(e, c1144ur, randomSource, e.getEyePosition().add(mo6064a(e, c1144ur)), this.f5791at);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Vec3 mo6063a(@NotNull E e) {
        return e.getEyePosition();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected static Vec3 m6069a(@NotNull Vec2 vec2, @NotNull C1122uV c1122uV, int i, long j, float f, float f2) {
        Vec2 vec2M6229a = c1122uV.m6229a(i, j);
        return C1290xm.m7853a(m6071a(vec2, f2), vec2M6229a.y * f, vec2M6229a.x * f);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected static Vec3 m6070a(@NotNull Vec2 vec2, @NotNull RandomSource randomSource, float f, float f2) {
        float fNextGaussian = (float) (((double) f) * randomSource.nextGaussian());
        return C1290xm.m7853a(m6071a(vec2, f2), (float) (((double) f) * randomSource.nextGaussian()), fNextGaussian);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Vec2 m6071a(@NotNull Vec2 vec2, float f) {
        return new Vec2(vec2.x - f, vec2.y);
    }

    /* JADX INFO: renamed from: a */
    private void m6072a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull ClipContext clipContext, @NotNull Vec3 vec3) {
        Vec3 to = clipContext.getTo();
        Vec3 from = clipContext.getFrom();
        double dDistanceTo = to.distanceTo(from);
        BlockGetter.traverseBlocks(from, to, clipContext, (clipContext2, blockPos) -> {
            return m6074a(m, l, e, vec3, from, to, dDistanceTo);
        }, AbstractC1101uA::m6073b);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static BlockHitResult m6073b(@NotNull ClipContext clipContext) {
        Vec3 to = clipContext.getTo();
        Vec3 vec3Subtract = clipContext.getFrom().subtract(to);
        return BlockHitResult.miss(to, Direction.getNearest(vec3Subtract.x, vec3Subtract.y, vec3Subtract.z), BlockPos.containing(to));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private BlockHitResult m6074a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, double d) {
        C1152uz c1152uzM6439a;
        Vec3 vec3Normalize = vec33.subtract(vec32).normalize();
        Vec3 vec3Add = vec32.add(vec3Normalize.scale(this.f5794aT));
        if (this.f5792f != null && this.f5793e != null) {
            BlockPos blockPosRelative = this.f5792f.relative(this.f5793e, 1);
            BlockState blockState = l.getBlockState(blockPosRelative);
            VoxelShape collisionShape = blockState.getCollisionShape(l, blockPosRelative);
            boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
            if (blockState.isAir() || blockState.liquid() || z) {
                this.f5786cd.add(new C1141uo(this.f5792f, this.f5793e, vec3Add));
            }
            this.f5792f = null;
            this.f5793e = null;
        }
        BlockHitResult blockHitResultM5897a = C1060tM.m5897a(l, new ClipContext(vec3Add, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.WATER, CollisionContext.empty()));
        BlockPos blockPos = blockHitResultM5897a.getBlockPos();
        BlockState blockState2 = l.getBlockState(blockPos);
        Vec3 location = blockHitResultM5897a.getLocation();
        Direction direction = blockHitResultM5897a.getDirection();
        float fLeftFloat = this.f5789c.m6115c((float) location.distanceTo(e.position())).leftFloat();
        this.f5791at = location;
        mo6083a(new C0023U(vec3Add, location, 200, true, C1290xm.m7851a(65280, 16711680, Mth.clamp(this.f5790mS / fLeftFloat, 0.0f, 1.0f))));
        m6080a((AbstractC0563ju) m, (Level) l, (LivingEntity) e, vec3, vec3Add, location, d);
        if (this.f5794aT < d && this.f5790mS < fLeftFloat && this.f5786cd.size() < 8 && (c1152uzM6439a = C1215wI.m6740a(l, blockState2, blockPos).m6439a()) != null && !blockState2.isAir() && c1152uzM6439a.m6480by() != -1.0f) {
            m6075a(m, l, e, vec3, d, c1152uzM6439a, location, direction, vec3Normalize, blockPos, vec3Add, blockState2, blockHitResultM5897a);
            return null;
        }
        mo6083a(new C0023U(vec3Add.subtract(0.0d, 0.5d, 0.0d), vec3Add.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        mo6083a(new C0023U(location.subtract(0.0d, 0.5d, 0.0d), location.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        m6079a(l, blockState2, blockPos, direction, blockHitResultM5897a);
        return blockHitResultM5897a;
    }

    /* JADX INFO: renamed from: a */
    private void m6075a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, double d, @NotNull C1152uz c1152uz, @NotNull Vec3 vec32, @NotNull Direction direction, @NotNull Vec3 vec33, @NotNull BlockPos blockPos, @NotNull Vec3 vec34, @NotNull BlockState blockState, @NotNull BlockHitResult blockHitResult) {
        this.f5790mS += c1152uz.m6480by();
        m6080a((AbstractC0563ju) m, (Level) l, (LivingEntity) e, vec3, vec34, vec32, d);
        Vec3 vec3M6077a = m6077a(l, vec32, vec33, blockState, blockPos);
        mo6083a(new C0023U(vec34.subtract(0.0d, 0.5d, 0.0d), vec34.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        mo6083a(new C0023U(vec3M6077a.subtract(0.0d, 0.5d, 0.0d), vec3M6077a.add(0.0d, 0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        this.f5794aT += vec34.distanceTo(vec32) + vec32.distanceTo(vec3M6077a);
        m6079a(l, blockState, blockPos, direction, blockHitResult);
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        this.f5792f = blockPos;
        this.f5793e = m6076a(vec3M6077a, blockPos, collisionShape);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Direction m6076a(@NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull VoxelShape voxelShape) {
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
            if (dAbs < d - f5785aS) {
                d = dAbs;
                direction = Direction.WEST;
            }
            if (dAbs2 < d - f5785aS) {
                d = dAbs2;
                direction = Direction.EAST;
            }
            if (dAbs3 < d - f5785aS) {
                d = dAbs3;
                direction = Direction.DOWN;
            }
            if (dAbs4 < d - f5785aS) {
                d = dAbs4;
                direction = Direction.UP;
            }
            if (dAbs5 < d - f5785aS) {
                d = dAbs5;
                direction = Direction.NORTH;
            }
            if (dAbs6 < d - f5785aS) {
                d = dAbs6;
                direction = Direction.SOUTH;
            }
        }
        return direction;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Vec3 m6077a(@NotNull L l, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull BlockState blockState, @NotNull BlockPos blockPos) {
        VoxelShape collisionShape = blockState.getCollisionShape(l, blockPos);
        if (collisionShape.isEmpty()) {
            collisionShape = Shapes.block();
        }
        return m6078a(vec3.add(vec32.normalize().scale(0.001d)), vec32, collisionShape, blockPos).orElse(vec3);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Optional<Vec3> m6078a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull VoxelShape voxelShape, @NotNull BlockPos blockPos) {
        double d = Double.POSITIVE_INFINITY;
        Vec3 vec33 = null;
        Iterator it = voxelShape.toAabbs().iterator();
        while (it.hasNext()) {
            Optional<Vec3> optionalM7855a = C1290xm.m7855a(vec3, vec32, ((AABB) it.next()).move(blockPos));
            if (optionalM7855a.isPresent()) {
                Vec3 vec34 = optionalM7855a.get();
                double dDistanceToSqr = vec3.distanceToSqr(vec34);
                if (dDistanceToSqr < d) {
                    d = dDistanceToSqr;
                    vec33 = vec34;
                }
            }
        }
        return Optional.ofNullable(vec33);
    }

    /* JADX INFO: renamed from: a */
    private void m6079a(@NotNull L l, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull BlockHitResult blockHitResult) {
        if (blockState.isAir()) {
            return;
        }
        BlockState blockState2 = l.getBlockState(blockPos.relative(direction, 1));
        VoxelShape collisionShape = blockState2.getCollisionShape(l, blockPos);
        boolean z = collisionShape.isEmpty() || collisionShape != Shapes.block();
        if (blockState2.isAir() || blockState2.liquid() || z) {
            this.f5786cd.add(new C1141uo(blockPos, direction, blockHitResult.getLocation()));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6080a(@NotNull M m, @NotNull L l, @NotNull E e, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, double d) {
        AABB aabbExpandTowards = e.getBoundingBox().expandTowards(vec3.scale(d));
        mo6083a(new C0023U(vec32.add(0.0d, 0.10000000149011612d, 0.0d), vec33.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, 2237183));
        ObjectArrayList objectArrayList = new ObjectArrayList();
        try {
            for (C0523jG c0523jG : mo6085a(m, l).mo7802a((AbstractC0563ju<?, ?, ?>) m, aabbExpandTowards, e)) {
                if (c0523jG.m2305af()) {
                    Vec3 vec34 = (Vec3) c0523jG.m2301g().clip(vec32, vec33).orElse(null);
                    if (vec34 != null) {
                        objectArrayList.add(new C1104uD(c0523jG, vec34, vec32.distanceToSqr(vec34)));
                    }
                }
            }
        } catch (ConcurrentModificationException e2) {
            C0562jt.log("Concurrent modification exception while processing potential entity hits", new Object[0]);
        }
        objectArrayList.sort(Comparator.comparingDouble((v0) -> {
            return v0.m6096u();
        }));
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            m6081a(vec32, vec33, e, ((C1104uD) it.next()).m6094a());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6081a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull E e, @NotNull C0523jG c0523jG) {
        m6082b(vec3, vec32, e, c0523jG);
    }

    /* JADX INFO: renamed from: b */
    private void m6082b(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull E e, @NotNull C0523jG c0523jG) {
        int iM2299al = c0523jG.m2299al();
        Vec3 vec33 = (Vec3) c0523jG.m2301g().clip(vec3, vec32).orElse(null);
        mo6084a(new C0022T(c0523jG.m2301g(), 200, true, 65535));
        ItemStack mainHandItem = e.getMainHandItem();
        boolean z = false;
        if ((mainHandItem.getItem() instanceof C1144ur) && (e instanceof Player) && C1144ur.m6297d(mainHandItem) && !C1144ur.f5994hR) {
            z = true;
        }
        if (vec33 != null && !this.f5787d.contains(iM2299al)) {
            AABB aabbM2295e = c0523jG.m2295e();
            AABB aabbM2296f = c0523jG.m2296f();
            boolean z2 = aabbM2295e != null && aabbM2295e.contains(vec33);
            boolean z3 = aabbM2296f != null && aabbM2296f.contains(vec33);
            if (z2) {
                mo6084a(new C0022T(aabbM2295e, 200, true, 16711680));
            }
            if (z3) {
                mo6084a(new C0022T(aabbM2296f, 200, true, 65280));
            }
            C1142up c1142up = new C1142up(iM2299al, this.f5790mS, z2, !this.f5788ce.isEmpty(), z, z3, e.getDirection(), vec33);
            this.f5787d.add(iM2299al);
            this.f5788ce.add(c1142up);
        }
    }
}
