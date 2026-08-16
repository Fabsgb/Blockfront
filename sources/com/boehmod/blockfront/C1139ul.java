package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.C0187f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ul */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ul.class */
public class C1139ul extends Item {

    /* JADX INFO: renamed from: ba */
    public static final double f6239ba = 64.0d;

    /* JADX INFO: renamed from: bb */
    public static final double f6240bb = 0.2d;

    public C1139ul(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            a.m6537e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ul$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ul$a.class */
    @OnlyIn(Dist.CLIENT)
    public static final class a {

        /* JADX INFO: renamed from: bc */
        private static final double f6241bc = 1.0E-4d;

        /* JADX INFO: renamed from: a */
        @Nullable
        private static b f6242a = null;

        private a() {
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        public static C0187f m6535a(@NotNull Player player) {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (abstractC0531jNM179a instanceof C0623l) {
                return ((C0394gj) ((C0396gl) ((C0623l) abstractC0531jNM179a).m2855a()).m1150a(player)).m1881b();
            }
            return null;
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        public static b m6536a() {
            return f6242a;
        }

        /* JADX INFO: renamed from: e */
        public static void m6537e(@NotNull Player player) {
            C0187f c0187fM6535a = m6535a(player);
            if (c0187fM6535a == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (f6242a != null) {
                    m6545dA();
                    return;
                }
                if (c0187fM6535a.m1165a() == C0187f.a.AABB && c0187fM6535a.m1180j() != null) {
                    b bVarM6548b = m6548b(player, c0187fM6535a);
                    if (bVarM6548b != null) {
                        f6242a = bVarM6548b;
                        m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 0.8f);
                        return;
                    }
                    return;
                }
                m6540a(player, c0187fM6535a);
                return;
            }
            if (f6242a != null) {
                m6542b(player, c0187fM6535a);
                return;
            }
            if (c0187fM6535a.m1165a() == C0187f.a.AABB) {
                c0187fM6535a.m1171q(m6551b(player));
                m6552a(c0187fM6535a);
                m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.5f);
            } else {
                b bVarM6546a = m6546a(player, c0187fM6535a);
                if (bVarM6546a != null) {
                    f6242a = bVarM6546a;
                    m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
                }
            }
        }

        /* JADX INFO: renamed from: g */
        public static void m6538g(@NotNull Player player) {
            C0187f c0187fM6535a = m6535a(player);
            if (c0187fM6535a == null) {
                return;
            }
            if (Screen.hasShiftDown()) {
                if (f6242a != null) {
                    m6545dA();
                    return;
                } else {
                    m6540a(player, c0187fM6535a);
                    return;
                }
            }
            if (f6242a != null) {
                m6542b(player, c0187fM6535a);
                return;
            }
            if (c0187fM6535a.m1165a() != C0187f.a.AABB) {
                if (c0187fM6535a.m1173a(m6551b(player))) {
                    m6552a(c0187fM6535a);
                    m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_HARP, 1.0f + Math.min(1.0f, c0187fM6535a.m1172l().size() / 12.0f));
                    return;
                }
                return;
            }
            b bVarM6546a = m6546a(player, c0187fM6535a);
            if (bVarM6546a != null) {
                f6242a = bVarM6546a;
                m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BIT, 1.2f);
            } else {
                c0187fM6535a.m1170p(m6551b(player));
                m6552a(c0187fM6535a);
                m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_PLING, 1.2f);
            }
        }

        /* JADX INFO: renamed from: h */
        public static void m6539h(@NotNull Player player) {
            C0187f c0187fM6535a = m6535a(player);
            if (c0187fM6535a == null) {
                return;
            }
            C0187f.a next = c0187fM6535a.m1165a().next();
            f6242a = null;
            c0187fM6535a.m1166a(next);
            m6552a(c0187fM6535a);
            m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * next.ordinal()));
        }

        /* JADX INFO: renamed from: a */
        public static void m6540a(@NotNull Player player, @NotNull C0187f c0187f) {
            f6242a = null;
            if (c0187f.m1179bE()) {
                return;
            }
            c0187f.m1178dL();
            m6552a(c0187f);
            m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: a */
        public static void m6541a(@NotNull Player player, boolean z) {
            if (z && player.isCreative()) {
                return;
            }
            f6242a = null;
            C0187f c0187fM6535a = m6535a(player);
            if (c0187fM6535a == null || c0187fM6535a.m1179bE()) {
                return;
            }
            c0187fM6535a.m1178dL();
            m6552a(c0187fM6535a);
        }

        /* JADX INFO: renamed from: b */
        private static void m6542b(@NotNull Player player, @NotNull C0187f c0187f) {
            b bVar = f6242a;
            f6242a = null;
            if (bVar == null || !bVar.m6557a(c0187f, m6543a(player, bVar))) {
                return;
            }
            m6552a(c0187f);
            m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BELL, 1.0f);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static Vec3 m6543a(@NotNull Player player, @NotNull b bVar) {
            Direction directionM6560a = bVar.m6560a();
            Vec3 vec3M6561z = bVar.m6561z();
            if (bVar.m6558a() != b.EnumC1508a.FACE || directionM6560a == null || vec3M6561z == null) {
                return m6551b(player);
            }
            return m6544a(player, directionM6560a, vec3M6561z);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m6544a(@NotNull Player player, @NotNull Direction direction, @NotNull Vec3 vec3) {
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

        /* JADX INFO: renamed from: dA */
        private static void m6545dA() {
            f6242a = null;
            m6553a((Holder<SoundEvent>) SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static b m6546a(@NotNull Player player, @NotNull C0187f c0187f) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            double dDistanceToSqr = eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + f6241bc;
            b bVar = null;
            if (c0187f.m1165a() == C0187f.a.AABB) {
                Vec3 vec3M1168G = c0187f.m1168G();
                Vec3 vec3M1169H = c0187f.m1169H();
                if (vec3M1168G != null) {
                    double dM6547a = m6547a(eyePosition, vec3Add, vec3M1168G);
                    if (dM6547a <= dDistanceToSqr) {
                        dDistanceToSqr = dM6547a;
                        bVar = new b(b.EnumC1508a.POINT_A, 0);
                    }
                }
                if (vec3M1169H != null && m6547a(eyePosition, vec3Add, vec3M1169H) <= dDistanceToSqr) {
                    bVar = new b(b.EnumC1508a.POINT_B, 0);
                }
                return bVar;
            }
            ObjectList<Vec3> objectListM1172l = c0187f.m1172l();
            for (int i = 0; i < objectListM1172l.size(); i++) {
                double dM6547a2 = m6547a(eyePosition, vec3Add, (Vec3) objectListM1172l.get(i));
                if (dM6547a2 <= dDistanceToSqr) {
                    dDistanceToSqr = dM6547a2;
                    bVar = new b(b.EnumC1508a.BOUNDARY, i);
                }
            }
            return bVar;
        }

        /* JADX INFO: renamed from: a */
        private static double m6547a(@NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5) {
            Optional optionalClip = new AABB(vec5.x - 0.2d, vec5.y - 0.2d, vec5.z - 0.2d, vec5.x + 0.2d, vec5.y + 0.2d, vec5.z + 0.2d).clip(vec3, vec4);
            Objects.requireNonNull(vec3);
            return ((Double) optionalClip.map(vec3::distanceToSqr).orElse(Double.valueOf(Double.MAX_VALUE))).doubleValue();
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public static b m6548b(@NotNull Player player, @NotNull C0187f c0187f) {
            Vec3 vec3;
            Direction directionM6550a;
            AABB aabbM1180j = c0187f.m1180j();
            if (aabbM1180j == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            if (aabbM1180j.contains(eyePosition)) {
                C1507a c1507aM6549a = m6549a(aabbM1180j, eyePosition, vec3Add);
                if (c1507aM6549a == null) {
                    return null;
                }
                vec3 = c1507aM6549a.f6244am;
                directionM6550a = c1507aM6549a.f6243a;
            } else {
                Optional optionalClip = aabbM1180j.clip(eyePosition, vec3Add);
                if (optionalClip.isEmpty()) {
                    return null;
                }
                vec3 = (Vec3) optionalClip.get();
                directionM6550a = m6550a(aabbM1180j, vec3);
            }
            if (directionM6550a == null) {
                return null;
            }
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            if (eyePosition.distanceToSqr(vec3) > eyePosition.distanceToSqr(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation()) + f6241bc) {
                return null;
            }
            return new b(b.EnumC1508a.FACE, 0, directionM6550a, vec3);
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.ul$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ul$a$a.class */
        private static final class C1507a extends Record {

            /* JADX INFO: renamed from: a */
            @NotNull
            private final Direction f6243a;

            /* JADX INFO: renamed from: am */
            @NotNull
            private final Vec3 f6244am;

            private C1507a(@NotNull Direction direction, @NotNull Vec3 vec3) {
                this.f6243a = direction;
                this.f6244am = vec3;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1507a.class), C1507a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1507a.class), C1507a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1507a.class, Object.class), C1507a.class, "face;position", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->a:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$a;->am:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @NotNull
            /* JADX INFO: renamed from: a */
            public Direction m6554a() {
                return this.f6243a;
            }

            @NotNull
            /* JADX INFO: renamed from: h */
            public Vec3 m6555h() {
                return this.f6244am;
            }
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static C1507a m6549a(@NotNull AABB aabb, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
            Vec3 vec3Subtract = vec4.subtract(vec3);
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
            return new C1507a(direction, vec3.add(vec3Subtract.scale(d)));
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        private static Direction m6550a(@NotNull AABB aabb, @NotNull Vec3 vec3) {
            if (Math.abs(vec3.x - aabb.minX) < f6241bc) {
                return Direction.WEST;
            }
            if (Math.abs(vec3.x - aabb.maxX) < f6241bc) {
                return Direction.EAST;
            }
            if (Math.abs(vec3.y - aabb.minY) < f6241bc) {
                return Direction.DOWN;
            }
            if (Math.abs(vec3.y - aabb.maxY) < f6241bc) {
                return Direction.UP;
            }
            if (Math.abs(vec3.z - aabb.minZ) < f6241bc) {
                return Direction.NORTH;
            }
            if (Math.abs(vec3.z - aabb.maxZ) < f6241bc) {
                return Direction.SOUTH;
            }
            return null;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public static Vec3 m6551b(@NotNull Player player) {
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(eyePosition, vec3Add, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return C0187f.m1181b(blockHitResultClip.getType() == HitResult.Type.MISS ? vec3Add : blockHitResultClip.getLocation());
        }

        /* JADX INFO: renamed from: a */
        private static void m6552a(@NotNull C0187f c0187f) {
            C0187f c0187f2 = new C0187f();
            c0187f2.m1184b(c0187f);
            C1169vO.m6648c(new C1243wj(c0187f2));
        }

        /* JADX INFO: renamed from: a */
        private static void m6553a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.ul$a$b */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ul$a$b.class */
        public static final class b extends Record {

            /* JADX INFO: renamed from: a */
            @NotNull
            private final EnumC1508a f6245a;

            /* JADX INFO: renamed from: tL */
            private final int f6246tL;

            /* JADX INFO: renamed from: b */
            @Nullable
            private final Direction f6247b;

            /* JADX INFO: renamed from: an */
            @Nullable
            private final Vec3 f6248an;

            /* JADX INFO: renamed from: com.boehmod.blockfront.ul$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ul$a$b$a.class */
            public enum EnumC1508a {
                POINT_A,
                POINT_B,
                BOUNDARY,
                FACE
            }

            public b(@NotNull EnumC1508a enumC1508a, int i, @Nullable Direction direction, @Nullable Vec3 vec3) {
                this.f6245a = enumC1508a;
                this.f6246tL = i;
                this.f6247b = direction;
                this.f6248an = vec3;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->a:Lcom/boehmod/blockfront/ul$a$b$a;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->tL:I", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->an:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->a:Lcom/boehmod/blockfront/ul$a$b$a;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->tL:I", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->an:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object obj) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "kind;index;face;anchor", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->a:Lcom/boehmod/blockfront/ul$a$b$a;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->tL:I", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->b:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/ul$a$b;->an:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
            }

            @NotNull
            /* JADX INFO: renamed from: a */
            public EnumC1508a m6558a() {
                return this.f6245a;
            }

            /* JADX INFO: renamed from: bO */
            public int m6559bO() {
                return this.f6246tL;
            }

            @Nullable
            /* JADX INFO: renamed from: a */
            public Direction m6560a() {
                return this.f6247b;
            }

            @Nullable
            /* JADX INFO: renamed from: z */
            public Vec3 m6561z() {
                return this.f6248an;
            }

            b(@NotNull EnumC1508a enumC1508a, int i) {
                this(enumC1508a, i, null, null);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
            @Nullable
            /* JADX INFO: renamed from: a */
            public Vec3 m6556a(@NotNull C0187f c0187f) throws MatchException {
                switch (this.f6245a) {
                    case POINT_A:
                        return c0187f.m1168G();
                    case POINT_B:
                        return c0187f.m1169H();
                    case BOUNDARY:
                        if (this.f6246tL < c0187f.m1172l().size()) {
                            return (Vec3) c0187f.m1172l().get(this.f6246tL);
                        }
                        return null;
                    case FACE:
                        return null;
                    default:
                        throw new MatchException((String) null, (Throwable) null);
                }
            }

            /* JADX INFO: renamed from: a */
            public boolean m6557a(@NotNull C0187f c0187f, @NotNull Vec3 vec3) {
                switch (this.f6245a) {
                    case POINT_A:
                        c0187f.m1170p(vec3);
                        return true;
                    case POINT_B:
                        c0187f.m1171q(vec3);
                        return true;
                    case BOUNDARY:
                        if (this.f6246tL >= c0187f.m1172l().size()) {
                            return false;
                        }
                        c0187f.m1174b(this.f6246tL, vec3);
                        return true;
                    case FACE:
                        return this.f6247b != null && c0187f.m1175a(this.f6247b, vec3);
                    default:
                        return true;
                }
            }
        }
    }
}
