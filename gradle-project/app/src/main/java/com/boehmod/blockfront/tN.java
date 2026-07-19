package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.f;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN.class */
public class tN extends Item {
    public static final double aN = 64.0d;
    public static final double aO = 0.2d;

    public tN(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {
        private static final double aP = 1.0E-4d;

        @Nullable
        private static b a = null;

        private a() {
        }

        @Nullable
        public static com.boehmod.blockfront.common.player.f a(@NotNull Player player) {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (abstractC0264juM166a instanceof C0297l) {
                return ((fT) ((fV) ((C0297l) abstractC0264juM166a).a()).a(player)).b();
            }
            return null;
        }

        @Nullable
        public static b a() {
            return a;
        }

        public static void e(@NotNull Player player) {
            com.boehmod.blockfront.common.player.f fVarA = a(player);
            if (fVarA == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (a != null) {
                    m1144do();
                    return;
                }
                if (fVarA.a() == f.a.AABB && fVarA.j() != null) {
                    b bVarM1147b = m1147b(player, fVarA);
                    if (bVarM1147b != null) {
                        a = bVarM1147b;
                        a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 0.8f);
                        return;
                    }
                    return;
                }
                a(player, fVarA);
                return;
            }
            if (a != null) {
                b(player, fVarA);
                return;
            }
            if (fVarA.a() == f.a.AABB) {
                fVarA.q(b(player));
                a(fVarA);
                a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.5f);
            } else {
                b bVarM1146a = m1146a(player, fVarA);
                if (bVarM1146a != null) {
                    a = bVarM1146a;
                    a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
                }
            }
        }

        public static void g(@NotNull Player player) {
            com.boehmod.blockfront.common.player.f fVarA = a(player);
            if (fVarA == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (a != null) {
                    m1144do();
                    return;
                } else {
                    a(player, fVarA);
                    return;
                }
            }
            if (a != null) {
                b(player, fVarA);
                return;
            }
            if (fVarA.a() != f.a.AABB) {
                if (fVarA.a(b(player))) {
                    a(fVarA);
                    a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_HARP, 1.0f + Math.min(1.0f, fVarA.h().size() / 12.0f));
                    return;
                }
                return;
            }
            b bVarM1146a = m1146a(player, fVarA);
            if (bVarM1146a != null) {
                a = bVarM1146a;
                a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
            } else {
                fVarA.p(b(player));
                a(fVarA);
                a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.2f);
            }
        }

        public static void h(@NotNull Player player) {
            com.boehmod.blockfront.common.player.f fVarA = a(player);
            if (fVarA == null) {
                return;
            }
            f.a next = fVarA.a().next();
            a = null;
            fVarA.a(next);
            a(fVarA);
            a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * next.ordinal()));
        }

        public static void a(@NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar) {
            a = null;
            if (fVar.bu()) {
                return;
            }
            fVar.dB();
            a(fVar);
            a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        public static void a(@NotNull Player player, boolean z) {
            if (z && player.isCreative()) {
                return;
            }
            a = null;
            com.boehmod.blockfront.common.player.f fVarA = a(player);
            if (fVarA == null || fVarA.bu()) {
                return;
            }
            fVarA.dB();
            a(fVarA);
        }

        private static void b(@NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar) {
            b bVar = a;
            a = null;
            if (bVar == null || !bVar.a(fVar, a(player, bVar))) {
                return;
            }
            a(fVar);
            a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BELL, 1.0f);
        }

        @NotNull
        public static Vec3 a(@NotNull Player player, @NotNull b bVar) {
            Direction directionM1148a = bVar.m1148a();
            Vec3 vec3Y = bVar.y();
            if (bVar.a() != b.EnumC0001a.FACE || directionM1148a == null || vec3Y == null) {
                return b(player);
            }
            return a(player, directionM1148a, vec3Y);
        }

        @NotNull
        private static Vec3 a(@NotNull Player player, @NotNull Direction direction, @NotNull Vec3 vec3) {
            Vec3 vec3AtLowerCornerOf = Vec3.atLowerCornerOf(direction.getNormal());
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 viewVector = player.getViewVector(1.0f);
            double dDot = vec3AtLowerCornerOf.dot(viewVector);
            double d = 1.0d - (dDot * dDot);
            if (Math.abs(d) < 1.0E-6d) {
                return vec3;
            }
            Vec3 vec3Subtract = vec3.subtract(eyePosition);
            return vec3.add(vec3AtLowerCornerOf.scale(Mth.clamp(((dDot * viewVector.dot(vec3Subtract)) - vec3AtLowerCornerOf.dot(vec3Subtract)) / d, -64.0d, 64.0d)));
        }

        /* JADX INFO: renamed from: do, reason: not valid java name */
        private static void m1144do() {
            a = null;
            a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        @Nullable
        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        private static b m1146a(@NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            double dDistanceToSqr = eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + aP;
            b bVar = null;
            if (fVar.a() == f.a.AABB) {
                Vec3 vec3F = fVar.F();
                Vec3 vec3G = fVar.G();
                if (vec3F != null) {
                    double dA = a(eyePosition, vec3Add, vec3F);
                    if (dA <= dDistanceToSqr) {
                        dDistanceToSqr = dA;
                        bVar = new b(b.EnumC0001a.POINT_A, 0);
                    }
                }
                if (vec3G != null && a(eyePosition, vec3Add, vec3G) <= dDistanceToSqr) {
                    bVar = new b(b.EnumC0001a.POINT_B, 0);
                }
                return bVar;
            }
            ObjectList<Vec3> objectListH = fVar.h();
            for (int i = 0; i < objectListH.size(); i++) {
                double dA2 = a(eyePosition, vec3Add, (Vec3) objectListH.get(i));
                if (dA2 <= dDistanceToSqr) {
                    dDistanceToSqr = dA2;
                    bVar = new b(b.EnumC0001a.BOUNDARY, i);
                }
            }
            return bVar;
        }

        private static double a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33) {
            Optional optionalClip = new AABB(vec33.x - 0.2d, vec33.y - 0.2d, vec33.z - 0.2d, vec33.x + 0.2d, vec33.y + 0.2d, vec33.z + 0.2d).clip(vec3, vec32);
            Objects.requireNonNull(vec3);
            return ((Double) optionalClip.map(vec3::distanceToSqr).orElse(Double.valueOf(Double.MAX_VALUE))).doubleValue();
        }

        @Nullable
        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public static b m1147b(@NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar) {
            Vec3 vec3;
            Direction directionA;
            AABB aabbJ = fVar.j();
            if (aabbJ == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            if (aabbJ.contains(eyePosition)) {
                C0000a c0000aA = a(aabbJ, eyePosition, vec3Add);
                if (c0000aA == null) {
                    return null;
                }
                vec3 = c0000aA.al;
                directionA = c0000aA.a;
            } else {
                Optional optionalClip = aabbJ.clip(eyePosition, vec3Add);
                if (optionalClip.isEmpty()) {
                    return null;
                }
                vec3 = (Vec3) optionalClip.get();
                directionA = a(aabbJ, vec3);
            }
            if (directionA == null) {
                return null;
            }
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            if (eyePosition.distanceToSqr(vec3) > eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + aP) {
                return null;
            }
            return new b(b.EnumC0001a.FACE, 0, directionA, vec3);
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$a.class */
        private static final class C0000a extends Record {

            @NotNull
            private final Direction a;

            @NotNull
            private final Vec3 al;

            private C0000a(@NotNull Direction direction, @NotNull Vec3 vec3) {
                this.a = direction;
                this.al = vec3;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0000a.class), C0000a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0000a.class), C0000a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0000a.class, Object.class), C0000a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @NotNull
            public Direction a() {
                return this.a;
            }

            @NotNull
            public Vec3 h() {
                return this.al;
            }
        }

        @Nullable
        private static C0000a a(@NotNull AABB aabb, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
            Vec3 vec3Subtract = vec32.subtract(vec3);
            double d = Double.MAX_VALUE;
            Direction direction = null;
            if (vec3Subtract.x > 1.0E-7d) {
                d = (aabb.maxX - vec3.x) / vec3Subtract.x;
                direction = Direction.EAST;
            } else if (vec3Subtract.x < -1.0E-7d) {
                d = (aabb.minX - vec3.x) / vec3Subtract.x;
                direction = Direction.WEST;
            }
            if (vec3Subtract.y > 1.0E-7d) {
                double d2 = (aabb.maxY - vec3.y) / vec3Subtract.y;
                if (d2 < d) {
                    d = d2;
                    direction = Direction.UP;
                }
            } else if (vec3Subtract.y < -1.0E-7d) {
                double d3 = (aabb.minY - vec3.y) / vec3Subtract.y;
                if (d3 < d) {
                    d = d3;
                    direction = Direction.DOWN;
                }
            }
            if (vec3Subtract.z > 1.0E-7d) {
                double d4 = (aabb.maxZ - vec3.z) / vec3Subtract.z;
                if (d4 < d) {
                    d = d4;
                    direction = Direction.SOUTH;
                }
            } else if (vec3Subtract.z < -1.0E-7d) {
                double d5 = (aabb.minZ - vec3.z) / vec3Subtract.z;
                if (d5 < d) {
                    d = d5;
                    direction = Direction.NORTH;
                }
            }
            if (direction == null || d > 1.0d) {
                return null;
            }
            return new C0000a(direction, vec3.add(vec3Subtract.scale(d)));
        }

        @Nullable
        private static Direction a(@NotNull AABB aabb, @NotNull Vec3 vec3) {
            if (Math.abs(vec3.x - aabb.minX) < aP) {
                return Direction.WEST;
            }
            if (Math.abs(vec3.x - aabb.maxX) < aP) {
                return Direction.EAST;
            }
            if (Math.abs(vec3.y - aabb.minY) < aP) {
                return Direction.DOWN;
            }
            if (Math.abs(vec3.y - aabb.maxY) < aP) {
                return Direction.UP;
            }
            if (Math.abs(vec3.z - aabb.minZ) < aP) {
                return Direction.NORTH;
            }
            if (Math.abs(vec3.z - aabb.maxZ) < aP) {
                return Direction.SOUTH;
            }
            return null;
        }

        @NotNull
        public static Vec3 b(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return com.boehmod.blockfront.common.player.f.b(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation());
        }

        private static void a(@NotNull com.boehmod.blockfront.common.player.f fVar) {
            com.boehmod.blockfront.common.player.f fVar2 = new com.boehmod.blockfront.common.player.f();
            fVar2.b(fVar);
            C0582vo.c(new vK(fVar2));
        }

        private static void a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$b.class */
        public static final class b extends Record {

            @NotNull
            private final EnumC0001a a;
            private final int rI;

            @Nullable
            private final Direction b;

            @Nullable
            private final Vec3 am;

            /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$b$a.class */
            public enum EnumC0001a {
                POINT_A,
                POINT_B,
                BOUNDARY,
                FACE
            }

            public b(@NotNull EnumC0001a enumC0001a, int i, @Nullable Direction direction, @Nullable Vec3 vec3) {
                this.a = enumC0001a;
                this.rI = i;
                this.b = direction;
                this.am = vec3;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->a:Lcom/boehmod/blockfront/tN$a$b$a;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->rI:I", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->a:Lcom/boehmod/blockfront/tN$a$b$a;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->rI:I", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->a:Lcom/boehmod/blockfront/tN$a$b$a;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->rI:I", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$b;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @NotNull
            public EnumC0001a a() {
                return this.a;
            }

            public int bz() {
                return this.rI;
            }

            @Nullable
            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public Direction m1148a() {
                return this.b;
            }

            @Nullable
            public Vec3 y() {
                return this.am;
            }

            b(@NotNull EnumC0001a enumC0001a, int i) {
                this(enumC0001a, i, null, null);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
            @Nullable
            public Vec3 a(@NotNull com.boehmod.blockfront.common.player.f fVar) throws MatchException {
                switch (this.a) {
                    case POINT_A:
                        return fVar.F();
                    case POINT_B:
                        return fVar.G();
                    case BOUNDARY:
                        if (this.rI < fVar.h().size()) {
                            return (Vec3) fVar.h().get(this.rI);
                        }
                        return null;
                    case FACE:
                        return null;
                    default:
                        throw new MatchException((String) null, (Throwable) null);
                }
            }

            public boolean a(@NotNull com.boehmod.blockfront.common.player.f fVar, @NotNull Vec3 vec3) {
                switch (this.a) {
                    case POINT_A:
                        fVar.p(vec3);
                        return true;
                    case POINT_B:
                        fVar.q(vec3);
                        return true;
                    case BOUNDARY:
                        if (this.rI >= fVar.h().size()) {
                            return false;
                        }
                        fVar.b(this.rI, vec3);
                        return true;
                    case FACE:
                        return this.b != null && fVar.a(this.b, vec3);
                    default:
                        return true;
                }
            }
        }
    }
}
