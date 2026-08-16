package com.boehmod.blockfront;

import java.util.Optional;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uf.class */
public class C1133uf extends Item {

    /* JADX INFO: renamed from: aV */
    public static final double f6212aV = 64.0d;

    /* JADX INFO: renamed from: aW */
    public static final double f6213aW = 1.0d;

    /* JADX INFO: renamed from: aX */
    public static final double f6214aX = 1.0d;

    /* JADX INFO: renamed from: aY */
    public static final double f6215aY = 0.25d;

    /* JADX INFO: renamed from: tG */
    public static final int f6216tG = 10;

    /* JADX INFO: renamed from: nt */
    public static final float f6217nt = 0.0f;

    /* JADX INFO: renamed from: nu */
    public static final float f6218nu = 64.0f;

    public C1133uf(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.m6511e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        if (level.isClientSide() && z && (entity instanceof Player)) {
            Player player = (Player) entity;
            if (player.isCreative()) {
                b.m6512f(player);
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uf$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uf$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {

        /* JADX INFO: renamed from: F */
        @Nullable
        private static UUID f6219F = null;

        /* JADX INFO: renamed from: aZ */
        private static double f6220aZ = 0.0d;

        /* JADX INFO: renamed from: ah */
        @Nullable
        private static Vec3 f6221ah = null;

        /* JADX INFO: renamed from: ai */
        @Nullable
        private static Vec3 f6222ai = null;

        /* JADX INFO: renamed from: aj */
        @Nullable
        private static Vec3 f6223aj = null;

        /* JADX INFO: renamed from: ak */
        @Nullable
        private static Vec3 f6224ak = null;

        /* JADX INFO: renamed from: a */
        @NotNull
        private static a f6225a = a.NORMAL;

        /* JADX INFO: renamed from: tH */
        private static int f6226tH = 0;

        private b() {
        }

        @Nullable
        /* JADX INFO: renamed from: j */
        public static UUID m6503j() {
            return f6219F;
        }

        @Nullable
        /* JADX INFO: renamed from: w */
        public static Vec3 m6504w() {
            return f6221ah;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static a m6505a() {
            return (a) C0495ie.f3070a.m2018a();
        }

        @Nullable
        /* JADX INFO: renamed from: x */
        public static Vec3 m6506x() {
            return f6224ak;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public static a m6507b() {
            return f6225a;
        }

        /* JADX INFO: renamed from: F */
        public static float m6508F(float f) {
            if (f6226tH <= 0) {
                return 0.0f;
            }
            return Math.max(0.0f, Math.min(1.0f, (f6226tH - f) / 10.0f));
        }

        /* JADX INFO: renamed from: dw */
        public static void m6509dw() {
            if (f6219F == null) {
                return;
            }
            a next = m6505a().next();
            C0495ie.f3070a.m2019a(next);
            m6510dx();
            m6521a(SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * next.ordinal()));
        }

        /* JADX INFO: renamed from: dx */
        private static void m6510dx() {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (abstractC0531jNM179a instanceof C0623l) {
                C0498ih.m2238e((C0623l) abstractC0531jNM179a);
            }
        }

        /* JADX INFO: renamed from: e */
        public static void m6511e(@NotNull Player player) {
            AbstractC0858pW abstractC0858pWM6520b;
            AbstractC0858pW abstractC0858pWM3662a;
            UUID uuid;
            if (Screen.hasControlDown()) {
                if (f6219F != null) {
                    uuid = f6219F;
                } else {
                    AbstractC0858pW abstractC0858pWM6520b2 = m6520b(player);
                    if (abstractC0858pWM6520b2 == null) {
                        return;
                    } else {
                        uuid = abstractC0858pWM6520b2.f4592y;
                    }
                }
                C1169vO.m6648c(new C1162vH(uuid));
                m6521a(SoundEvents.NOTE_BLOCK_BIT, 1.5f);
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            if (Screen.hasShiftDown()) {
                if (f6219F != null) {
                    C1096tv c1096tvM6522b = m6522b();
                    abstractC0858pWM6520b = c1096tvM6522b != null ? c1096tvM6522b.m6096a(f6219F) : null;
                    m6519dv();
                } else {
                    abstractC0858pWM6520b = m6520b(player);
                }
                if (abstractC0858pWM6520b == null) {
                    return;
                }
                UUID uuid2 = abstractC0858pWM6520b.f4592y;
                if (C0782o.m3660b(uuid2)) {
                    String strM3661a = C0782o.m3661a(uuid2);
                    if (strM3661a != null && (abstractC0858pWM3662a = C0782o.m3662a(strM3661a)) != null) {
                        minecraft.setScreen(new C0157cU(null, abstractC0858pWM6520b, abstractC0858pWM3662a, strM3661a));
                    }
                } else {
                    minecraft.setScreen(new C0156cT(null, abstractC0858pWM6520b));
                }
                m6521a(SoundEvents.NOTE_BLOCK_HARP, 1.2f);
                return;
            }
            if (f6219F != null) {
                if (f6223aj != null) {
                    C1169vO.m6648c(new C1236wc(f6219F, f6223aj));
                }
                m6519dv();
                m6521a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            AbstractC0858pW abstractC0858pWM6520b3 = m6520b(player);
            if (abstractC0858pWM6520b3 == null) {
                return;
            }
            f6219F = abstractC0858pWM6520b3.f4592y;
            f6220aZ = abstractC0858pWM6520b3.f4593c.distanceTo(player.getEyePosition(1.0f));
            f6221ah = abstractC0858pWM6520b3.f4593c;
            m6521a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        /* JADX INFO: renamed from: f */
        public static void m6512f(@NotNull Player player) throws MatchException {
            C1096tv c1096tvM6522b;
            Vec3 vec3M6514a;
            if (f6226tH > 0) {
                f6226tH--;
            }
            if (f6219F == null || (c1096tvM6522b = m6522b()) == null) {
                return;
            }
            AbstractC0858pW abstractC0858pWM6096a = c1096tvM6522b.m6096a(f6219F);
            if (abstractC0858pWM6096a == null) {
                m6519dv();
                return;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(f6220aZ));
            switch (m6505a()) {
                case NORMAL:
                    vec3M6514a = vec3Add;
                    break;
                case SNAP:
                    vec3M6514a = m6514a(vec3Add);
                    break;
                case COLLIDE:
                    vec3M6514a = m6515a(player, eyePosition, vec3Add);
                    break;
                case SNAP_COLLIDE:
                    vec3M6514a = m6514a(m6515a(player, eyePosition, vec3Add));
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec3 = vec3M6514a;
            f6222ai = f6223aj != null ? f6223aj : vec3;
            f6223aj = vec3;
            abstractC0858pWM6096a.f4593c = vec3;
        }

        /* JADX INFO: renamed from: o */
        public static void m6513o(float f) {
            C1096tv c1096tvM6522b;
            AbstractC0858pW abstractC0858pWM6096a;
            if (f6219F == null || f6222ai == null || f6223aj == null || (c1096tvM6522b = m6522b()) == null || (abstractC0858pWM6096a = c1096tvM6522b.m6096a(f6219F)) == null) {
                return;
            }
            abstractC0858pWM6096a.f4593c = f6222ai.lerp(f6223aj, f);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m6514a(@NotNull Vec3 vec3) {
            return new Vec3(Math.round(vec3.x / 0.25d) * 0.25d, Math.round(vec3.y / 0.25d) * 0.25d, Math.round(vec3.z / 0.25d) * 0.25d);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m6515a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(vec3, vec4, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec4 : blockHitResultClip.getLocation();
        }

        /* JADX INFO: renamed from: b */
        public static void m6516b(double d) {
            if (f6219F == null) {
                return;
            }
            f6220aZ = Math.max(1.0d, Math.min(64.0d, f6220aZ + d));
            m6521a(SoundEvents.UI_BUTTON_CLICK, 2.0f - ((float) ((f6220aZ - 1.0d) / 63.0d)));
        }

        /* JADX INFO: renamed from: dy */
        public static void m6517dy() {
            if (f6219F == null) {
                return;
            }
            C1169vO.m6648c(new C1168vN(f6219F));
            m6519dv();
            m6521a(SoundEvents.NOTE_BLOCK_BASS, 0.5f);
        }

        /* JADX INFO: renamed from: dz */
        public static void m6518dz() {
            AbstractC0858pW abstractC0858pWM6096a;
            if (f6219F == null || f6221ah == null) {
                return;
            }
            C1096tv c1096tvM6522b = m6522b();
            if (c1096tvM6522b != null && (abstractC0858pWM6096a = c1096tvM6522b.m6096a(f6219F)) != null) {
                abstractC0858pWM6096a.f4593c = f6221ah;
            }
            m6519dv();
            m6521a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: dv */
        private static void m6519dv() {
            if (f6223aj != null) {
                f6224ak = f6223aj;
                f6225a = m6505a();
                f6226tH = 10;
            }
            f6219F = null;
            f6221ah = null;
            f6220aZ = 0.0d;
            f6222ai = null;
            f6223aj = null;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static AbstractC0858pW m6520b(@NotNull Player player) {
            C1096tv c1096tvM6522b = m6522b();
            if (c1096tvM6522b == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            AbstractC0858pW abstractC0858pW = null;
            double d = Double.MAX_VALUE;
            for (AbstractC0858pW abstractC0858pW2 : c1096tvM6522b.m6107az()) {
                Optional optionalClip = abstractC0858pW2.m3950i().clip(eyePosition, vec3Add);
                if (!optionalClip.isEmpty()) {
                    double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                    if (dDistanceToSqr < d) {
                        d = dDistanceToSqr;
                        abstractC0858pW = abstractC0858pW2;
                    }
                }
            }
            return abstractC0858pW;
        }

        /* JADX INFO: renamed from: a */
        private static void m6521a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static C1096tv m6522b() {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C0623l) || (abstractC0863pbM2874a = ((C0623l) abstractC0531jNM179a).m2874a()) == null) {
                return null;
            }
            return abstractC0863pbM2874a.m4089a();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uf$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uf$a.class */
    public enum a implements InterfaceC0492ib {
        NORMAL("Normal", -1, "normal"),
        SNAP("Snap (0.25)", -12224, "snap"),
        COLLIDE("Collide", -12529409, "collide"),
        SNAP_COLLIDE("Snap + Collide", -8323200, "snap_collide");


        @NotNull
        private final String displayName;
        private final int displayColor;

        @NotNull
        private final String settingsKey;

        a(@NotNull String str, int i, String str2) {
            this.displayName = str;
            this.displayColor = i;
            this.settingsKey = str2;
        }

        @NotNull
        public String displayName() {
            return this.displayName;
        }

        public int displayColor() {
            return this.displayColor;
        }

        @Override // com.boehmod.blockfront.InterfaceC0492ib
        @NotNull
        public String getSettingsKey() {
            return this.settingsKey;
        }

        @NotNull
        public a next() {
            a[] aVarArrValues = values();
            return aVarArrValues[(ordinal() + 1) % aVarArrValues.length];
        }
    }
}
