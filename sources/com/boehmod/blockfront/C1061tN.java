package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.C0186f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN.class */
public class C1061tN extends Item {

    /* JADX INFO: renamed from: aN */
    public static final double f5600aN = 64.0d;

    /* JADX INFO: renamed from: aO */
    public static final double f5601aO = 0.2d;

    public C1061tN(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.m5902e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {

        /* JADX INFO: renamed from: aP */
        private static final double f5602aP = 1.0E-4d;

        /* JADX INFO: renamed from: a */
        @Nullable
        private static b f5603a = null;

        private a() {
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        public static C0186f m5900a(@NotNull Player player) {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (abstractC0563juM168a instanceof C0622l) {
                return ((C0324fT) ((C0326fV) ((C0622l) abstractC0563juM168a).m2670a()).m1133a(player)).m1671b();
            }
            return null;
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        public static b m5901a() {
            return f5603a;
        }

        /* JADX INFO: renamed from: e */
        public static void m5902e(@NotNull Player player) {
            C0186f c0186fM5900a = m5900a(player);
            if (c0186fM5900a == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (f5603a != null) {
                    m5910do();
                    return;
                }
                if (c0186fM5900a.m1148a() == C0186f.a.AABB && c0186fM5900a.m1163j() != null) {
                    b bVarM5913b = m5913b(player, c0186fM5900a);
                    if (bVarM5913b != null) {
                        f5603a = bVarM5913b;
                        m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 0.8f);
                        return;
                    }
                    return;
                }
                m5905a(player, c0186fM5900a);
                return;
            }
            if (f5603a != null) {
                m5907b(player, c0186fM5900a);
                return;
            }
            if (c0186fM5900a.m1148a() == C0186f.a.AABB) {
                c0186fM5900a.m1154q(m5916b(player));
                m5917a(c0186fM5900a);
                m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.5f);
            } else {
                b bVarM5911a = m5911a(player, c0186fM5900a);
                if (bVarM5911a != null) {
                    f5603a = bVarM5911a;
                    m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
                }
            }
        }

        /* JADX INFO: renamed from: g */
        public static void m5903g(@NotNull Player player) {
            C0186f c0186fM5900a = m5900a(player);
            if (c0186fM5900a == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (f5603a != null) {
                    m5910do();
                    return;
                } else {
                    m5905a(player, c0186fM5900a);
                    return;
                }
            }
            if (f5603a != null) {
                m5907b(player, c0186fM5900a);
                return;
            }
            if (c0186fM5900a.m1148a() != C0186f.a.AABB) {
                if (c0186fM5900a.m1156a(m5916b(player))) {
                    m5917a(c0186fM5900a);
                    m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_HARP, 1.0f + Math.min(1.0f, c0186fM5900a.m1155h().size() / 12.0f));
                    return;
                }
                return;
            }
            b bVarM5911a = m5911a(player, c0186fM5900a);
            if (bVarM5911a != null) {
                f5603a = bVarM5911a;
                m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
            } else {
                c0186fM5900a.m1153p(m5916b(player));
                m5917a(c0186fM5900a);
                m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.2f);
            }
        }

        /* JADX INFO: renamed from: h */
        public static void m5904h(@NotNull Player player) {
            C0186f c0186fM5900a = m5900a(player);
            if (c0186fM5900a == null) {
                return;
            }
            C0186f.a next = c0186fM5900a.m1148a().next();
            f5603a = null;
            c0186fM5900a.m1149a(next);
            m5917a(c0186fM5900a);
            m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * next.ordinal()));
        }

        /* JADX INFO: renamed from: a */
        public static void m5905a(@NotNull Player player, @NotNull C0186f c0186f) {
            f5603a = null;
            if (c0186f.m1162bu()) {
                return;
            }
            c0186f.m1161dB();
            m5917a(c0186f);
            m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: a */
        public static void m5906a(@NotNull Player player, boolean z) {
            if (z && player.isCreative()) {
                return;
            }
            f5603a = null;
            C0186f c0186fM5900a = m5900a(player);
            if (c0186fM5900a == null || c0186fM5900a.m1162bu()) {
                return;
            }
            c0186fM5900a.m1161dB();
            m5917a(c0186fM5900a);
        }

        /* JADX INFO: renamed from: b */
        private static void m5907b(@NotNull Player player, @NotNull C0186f c0186f) {
            b bVar = f5603a;
            f5603a = null;
            if (bVar == null || !bVar.m5922a(c0186f, m5908a(player, bVar))) {
                return;
            }
            m5917a(c0186f);
            m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BELL, 1.0f);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static Vec3 m5908a(@NotNull Player player, @NotNull b bVar) {
            Direction directionM5925a = bVar.m5925a();
            Vec3 vec3M5926y = bVar.m5926y();
            if (bVar.m5923a() != b.EnumC1480a.FACE || directionM5925a == null || vec3M5926y == null) {
                return m5916b(player);
            }
            return m5909a(player, directionM5925a, vec3M5926y);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m5909a(@NotNull Player player, @NotNull Direction direction, @NotNull Vec3 vec3) {
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

        /* JADX INFO: renamed from: do */
        private static void m5910do() {
            f5603a = null;
            m5918a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static b m5911a(@NotNull Player player, @NotNull C0186f c0186f) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            double dDistanceToSqr = eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + f5602aP;
            b bVar = null;
            if (c0186f.m1148a() == C0186f.a.AABB) {
                Vec3 vec3M1151F = c0186f.m1151F();
                Vec3 vec3M1152G = c0186f.m1152G();
                if (vec3M1151F != null) {
                    double dM5912a = m5912a(eyePosition, vec3Add, vec3M1151F);
                    if (dM5912a <= dDistanceToSqr) {
                        dDistanceToSqr = dM5912a;
                        bVar = new b(b.EnumC1480a.POINT_A, 0);
                    }
                }
                if (vec3M1152G != null && m5912a(eyePosition, vec3Add, vec3M1152G) <= dDistanceToSqr) {
                    bVar = new b(b.EnumC1480a.POINT_B, 0);
                }
                return bVar;
            }
            ObjectList<Vec3> objectListM1155h = c0186f.m1155h();
            for (int i = 0; i < objectListM1155h.size(); i++) {
                double dM5912a2 = m5912a(eyePosition, vec3Add, (Vec3) objectListM1155h.get(i));
                if (dM5912a2 <= dDistanceToSqr) {
                    dDistanceToSqr = dM5912a2;
                    bVar = new b(b.EnumC1480a.BOUNDARY, i);
                }
            }
            return bVar;
        }

        /* JADX INFO: renamed from: a */
        private static double m5912a(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33) {
            Optional optionalClip = new AABB(vec33.x - 0.2d, vec33.y - 0.2d, vec33.z - 0.2d, vec33.x + 0.2d, vec33.y + 0.2d, vec33.z + 0.2d).clip(vec3, vec32);
            Objects.requireNonNull(vec3);
            return ((Double) optionalClip.map(vec3::distanceToSqr).orElse(Double.valueOf(Double.MAX_VALUE))).doubleValue();
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public static b m5913b(@NotNull Player player, @NotNull C0186f c0186f) {
            Vec3 vec3;
            Direction directionM5915a;
            AABB aabbM1163j = c0186f.m1163j();
            if (aabbM1163j == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            if (aabbM1163j.contains(eyePosition)) {
                C1479a c1479aM5914a = m5914a(aabbM1163j, eyePosition, vec3Add);
                if (c1479aM5914a == null) {
                    return null;
                }
                vec3 = c1479aM5914a.f5605al;
                directionM5915a = c1479aM5914a.f5604a;
            } else {
                Optional optionalClip = aabbM1163j.clip(eyePosition, vec3Add);
                if (optionalClip.isEmpty()) {
                    return null;
                }
                vec3 = (Vec3) optionalClip.get();
                directionM5915a = m5915a(aabbM1163j, vec3);
            }
            if (directionM5915a == null) {
                return null;
            }
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            if (eyePosition.distanceToSqr(vec3) > eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + f5602aP) {
                return null;
            }
            return new b(b.EnumC1480a.FACE, 0, directionM5915a, vec3);
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$a.class */
        private static final class C1479a extends Record {

            /* JADX INFO: renamed from: a */
            @NotNull
            private final Direction f5604a;

            /* JADX INFO: renamed from: al */
            @NotNull
            private final Vec3 f5605al;

            private C1479a(@NotNull Direction direction, @NotNull Vec3 vec3) {
                this.f5604a = direction;
                this.f5605al = vec3;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1479a.class), C1479a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1479a.class), C1479a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1479a.class, Object.class), C1479a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/tN$a$a;->al:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @NotNull
            /* JADX INFO: renamed from: a */
            public Direction m5919a() {
                return this.f5604a;
            }

            @NotNull
            /* JADX INFO: renamed from: h */
            public Vec3 m5920h() {
                return this.f5605al;
            }
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static C1479a m5914a(@NotNull AABB aabb, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
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
            return new C1479a(direction, vec3.add(vec3Subtract.scale(d)));
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static Direction m5915a(@NotNull AABB aabb, @NotNull Vec3 vec3) {
            if (Math.abs(vec3.x - aabb.minX) < f5602aP) {
                return Direction.WEST;
            }
            if (Math.abs(vec3.x - aabb.maxX) < f5602aP) {
                return Direction.EAST;
            }
            if (Math.abs(vec3.y - aabb.minY) < f5602aP) {
                return Direction.DOWN;
            }
            if (Math.abs(vec3.y - aabb.maxY) < f5602aP) {
                return Direction.UP;
            }
            if (Math.abs(vec3.z - aabb.minZ) < f5602aP) {
                return Direction.NORTH;
            }
            if (Math.abs(vec3.z - aabb.maxZ) < f5602aP) {
                return Direction.SOUTH;
            }
            return null;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public static Vec3 m5916b(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return C0186f.m1164b(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation());
        }

        /* JADX INFO: renamed from: a */
        private static void m5917a(@NotNull C0186f c0186f) {
            C0186f c0186f2 = new C0186f();
            c0186f2.m1167b(c0186f);
            C1194vo.m6653c(new C1164vK(c0186f2));
        }

        /* JADX INFO: renamed from: a */
        private static void m5918a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a$b */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$b.class */
        public static final class b extends Record {

            /* JADX INFO: renamed from: a */
            @NotNull
            private final EnumC1480a f5606a;

            /* JADX INFO: renamed from: rI */
            private final int f5607rI;

            /* JADX INFO: renamed from: b */
            @Nullable
            private final Direction f5608b;

            /* JADX INFO: renamed from: am */
            @Nullable
            private final Vec3 f5609am;

            /* JADX INFO: renamed from: com.boehmod.blockfront.tN$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tN$a$b$a.class */
            public enum EnumC1480a {
                POINT_A,
                POINT_B,
                BOUNDARY,
                FACE
            }

            public b(@NotNull EnumC1480a enumC1480a, int i, @Nullable Direction direction, @Nullable Vec3 vec3) {
                this.f5606a = enumC1480a;
                this.f5607rI = i;
                this.f5608b = direction;
                this.f5609am = vec3;
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
            /* JADX INFO: renamed from: a */
            public EnumC1480a m5923a() {
                return this.f5606a;
            }

            /* JADX INFO: renamed from: bz */
            public int m5924bz() {
                return this.f5607rI;
            }

            @Nullable
            /* JADX INFO: renamed from: a */
            public Direction m5925a() {
                return this.f5608b;
            }

            @Nullable
            /* JADX INFO: renamed from: y */
            public Vec3 m5926y() {
                return this.f5609am;
            }

            b(@NotNull EnumC1480a enumC1480a, int i) {
                this(enumC1480a, i, null, null);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
            @Nullable
            /* JADX INFO: renamed from: a */
            public Vec3 m5921a(@NotNull C0186f c0186f) throws MatchException {
                switch (this.f5606a) {
                    case POINT_A:
                        return c0186f.m1151F();
                    case POINT_B:
                        return c0186f.m1152G();
                    case BOUNDARY:
                        if (this.f5607rI < c0186f.m1155h().size()) {
                            return (Vec3) c0186f.m1155h().get(this.f5607rI);
                        }
                        return null;
                    case FACE:
                        return null;
                    default:
                        throw new MatchException((String) null, (Throwable) null);
                }
            }

            /* JADX INFO: renamed from: a */
            public boolean m5922a(@NotNull C0186f c0186f, @NotNull Vec3 vec3) {
                switch (this.f5606a) {
                    case POINT_A:
                        c0186f.m1153p(vec3);
                        return true;
                    case POINT_B:
                        c0186f.m1154q(vec3);
                        return true;
                    case BOUNDARY:
                        if (this.f5607rI >= c0186f.m1155h().size()) {
                            return false;
                        }
                        c0186f.m1157b(this.f5607rI, vec3);
                        return true;
                    case FACE:
                        return this.f5608b != null && c0186f.m1158a(this.f5608b, vec3);
                    default:
                        return true;
                }
            }
        }
    }
}
