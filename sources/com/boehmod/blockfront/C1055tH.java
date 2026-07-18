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

/* JADX INFO: renamed from: com.boehmod.blockfront.tH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH.class */
public class C1055tH extends Item {

    /* JADX INFO: renamed from: aI */
    public static final double f5573aI = 64.0d;

    /* JADX INFO: renamed from: aJ */
    public static final double f5574aJ = 1.0d;

    /* JADX INFO: renamed from: aK */
    public static final double f5575aK = 1.0d;

    /* JADX INFO: renamed from: aL */
    public static final double f5576aL = 0.25d;

    /* JADX INFO: renamed from: rD */
    public static final int f5577rD = 10;

    /* JADX INFO: renamed from: mu */
    public static final float f5578mu = 0.0f;

    /* JADX INFO: renamed from: mv */
    public static final float f5579mv = 64.0f;

    public C1055tH(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.m5875e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        if (level.isClientSide() && z && (entity instanceof Player)) {
            Player player = (Player) entity;
            if (player.isCreative()) {
                b.m5876f(player);
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tH$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {

        /* JADX INFO: renamed from: E */
        @Nullable
        private static UUID f5580E = null;

        /* JADX INFO: renamed from: aM */
        private static double f5581aM = 0.0d;

        /* JADX INFO: renamed from: ag */
        @Nullable
        private static Vec3 f5582ag = null;

        /* JADX INFO: renamed from: ah */
        @Nullable
        private static Vec3 f5583ah = null;

        /* JADX INFO: renamed from: ai */
        @Nullable
        private static Vec3 f5584ai = null;

        /* JADX INFO: renamed from: aj */
        @Nullable
        private static Vec3 f5585aj = null;

        /* JADX INFO: renamed from: a */
        @NotNull
        private static a f5586a = a.NORMAL;

        /* JADX INFO: renamed from: rE */
        private static int f5587rE = 0;

        private b() {
        }

        @Nullable
        /* JADX INFO: renamed from: j */
        public static UUID m5867j() {
            return f5580E;
        }

        @Nullable
        /* JADX INFO: renamed from: v */
        public static Vec3 m5868v() {
            return f5582ag;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static a m5869a() {
            return (a) C0424hN.f2769a.m1987a();
        }

        @Nullable
        /* JADX INFO: renamed from: w */
        public static Vec3 m5870w() {
            return f5585aj;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public static a m5871b() {
            return f5586a;
        }

        /* JADX INFO: renamed from: C */
        public static float m5872C(float f) {
            if (f5587rE <= 0) {
                return 0.0f;
            }
            return Math.max(0.0f, Math.min(1.0f, (f5587rE - f) / 10.0f));
        }

        /* JADX INFO: renamed from: dk */
        public static void m5873dk() {
            if (f5580E == null) {
                return;
            }
            C0424hN.f2769a.m1988a(m5869a().next());
            m5874dl();
            m5885a(SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * r0.ordinal()));
        }

        /* JADX INFO: renamed from: dl */
        private static void m5874dl() {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (abstractC0563juM168a instanceof C0622l) {
                C0427hQ.m2004d((C0622l) abstractC0563juM168a);
            }
        }

        /* JADX INFO: renamed from: e */
        public static void m5875e(@NotNull Player player) {
            AbstractC0835pA abstractC0835pAM5884b;
            AbstractC0835pA abstractC0835pAM3546a;
            UUID uuid;
            if (Screen.hasControlDown()) {
                if (f5580E != null) {
                    uuid = f5580E;
                } else {
                    AbstractC0835pA abstractC0835pAM5884b2 = m5884b(player);
                    if (abstractC0835pAM5884b2 == null) {
                        return;
                    } else {
                        uuid = abstractC0835pAM5884b2.f4463y;
                    }
                }
                C1194vo.m6653c(new C1187vh(uuid));
                m5885a(SoundEvents.NOTE_BLOCK_BIT, 1.5f);
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            if (Screen.hasShiftDown()) {
                if (f5580E != null) {
                    C1018sY c1018sYM5886b = m5886b();
                    abstractC0835pAM5884b = c1018sYM5886b != null ? c1018sYM5886b.m5608a(f5580E) : null;
                    m5883dj();
                } else {
                    abstractC0835pAM5884b = m5884b(player);
                }
                if (abstractC0835pAM5884b == null) {
                    return;
                }
                UUID uuid2 = abstractC0835pAM5884b.f4463y;
                if (C0781o.m3544b(uuid2)) {
                    String strM3545a = C0781o.m3545a(uuid2);
                    if (strM3545a != null && (abstractC0835pAM3546a = C0781o.m3546a(strM3545a)) != null) {
                        minecraft.setScreen(new C0147cL(null, abstractC0835pAM5884b, abstractC0835pAM3546a, strM3545a));
                    }
                } else {
                    minecraft.setScreen(new C0146cK(null, abstractC0835pAM5884b));
                }
                m5885a(SoundEvents.NOTE_BLOCK_HARP, 1.2f);
                return;
            }
            if (f5580E != null) {
                if (f5584ai != null) {
                    C1194vo.m6653c(new C1157vD(f5580E, f5584ai));
                }
                m5883dj();
                m5885a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            AbstractC0835pA abstractC0835pAM5884b3 = m5884b(player);
            if (abstractC0835pAM5884b3 == null) {
                return;
            }
            f5580E = abstractC0835pAM5884b3.f4463y;
            f5581aM = abstractC0835pAM5884b3.f4464c.distanceTo(player.getEyePosition(1.0f));
            f5582ag = abstractC0835pAM5884b3.f4464c;
            m5885a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        /* JADX INFO: renamed from: f */
        public static void m5876f(@NotNull Player player) throws MatchException {
            C1018sY c1018sYM5886b;
            Vec3 vec3M5878a;
            if (f5587rE > 0) {
                f5587rE--;
            }
            if (f5580E == null || (c1018sYM5886b = m5886b()) == null) {
                return;
            }
            AbstractC0835pA abstractC0835pAM5608a = c1018sYM5886b.m5608a(f5580E);
            if (abstractC0835pAM5608a == null) {
                m5883dj();
                return;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(f5581aM));
            switch (m5869a()) {
                case NORMAL:
                    vec3M5878a = vec3Add;
                    break;
                case SNAP:
                    vec3M5878a = m5878a(vec3Add);
                    break;
                case COLLIDE:
                    vec3M5878a = m5879a(player, eyePosition, vec3Add);
                    break;
                case SNAP_COLLIDE:
                    vec3M5878a = m5878a(m5879a(player, eyePosition, vec3Add));
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec3 = vec3M5878a;
            f5583ah = f5584ai != null ? f5584ai : vec3;
            f5584ai = vec3;
            abstractC0835pAM5608a.f4464c = vec3;
        }

        /* JADX INFO: renamed from: p */
        public static void m5877p(float f) {
            C1018sY c1018sYM5886b;
            AbstractC0835pA abstractC0835pAM5608a;
            if (f5580E == null || f5583ah == null || f5584ai == null || (c1018sYM5886b = m5886b()) == null || (abstractC0835pAM5608a = c1018sYM5886b.m5608a(f5580E)) == null) {
                return;
            }
            abstractC0835pAM5608a.f4464c = f5583ah.lerp(f5584ai, f);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m5878a(@NotNull Vec3 vec3) {
            return new Vec3(Math.round(vec3.x / 0.25d) * 0.25d, Math.round(vec3.y / 0.25d) * 0.25d, Math.round(vec3.z / 0.25d) * 0.25d);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        private static Vec3 m5879a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(vec3, vec32, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec32 : blockHitResultClip.getLocation();
        }

        /* JADX INFO: renamed from: b */
        public static void m5880b(double d) {
            if (f5580E == null) {
                return;
            }
            f5581aM = Math.max(1.0d, Math.min(64.0d, f5581aM + d));
            m5885a(SoundEvents.UI_BUTTON_CLICK, 2.0f - ((float) ((f5581aM - 1.0d) / 63.0d)));
        }

        /* JADX INFO: renamed from: dm */
        public static void m5881dm() {
            if (f5580E == null) {
                return;
            }
            C1194vo.m6653c(new C1193vn(f5580E));
            m5883dj();
            m5885a(SoundEvents.NOTE_BLOCK_BASS, 0.5f);
        }

        /* JADX INFO: renamed from: dn */
        public static void m5882dn() {
            AbstractC0835pA abstractC0835pAM5608a;
            if (f5580E == null || f5582ag == null) {
                return;
            }
            C1018sY c1018sYM5886b = m5886b();
            if (c1018sYM5886b != null && (abstractC0835pAM5608a = c1018sYM5886b.m5608a(f5580E)) != null) {
                abstractC0835pAM5608a.f4464c = f5582ag;
            }
            m5883dj();
            m5885a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        /* JADX INFO: renamed from: dj */
        private static void m5883dj() {
            if (f5584ai != null) {
                f5585aj = f5584ai;
                f5586a = m5869a();
                f5587rE = 10;
            }
            f5580E = null;
            f5582ag = null;
            f5581aM = 0.0d;
            f5583ah = null;
            f5584ai = null;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static AbstractC0835pA m5884b(@NotNull Player player) {
            C1018sY c1018sYM5886b = m5886b();
            if (c1018sYM5886b == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            AbstractC0835pA abstractC0835pA = null;
            double d = Double.MAX_VALUE;
            for (AbstractC0835pA abstractC0835pA2 : c1018sYM5886b.m5619ax()) {
                Optional optionalClip = abstractC0835pA2.m4215i().clip(eyePosition, vec3Add);
                if (!optionalClip.isEmpty()) {
                    double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                    if (dDistanceToSqr < d) {
                        d = dDistanceToSqr;
                        abstractC0835pA = abstractC0835pA2;
                    }
                }
            }
            return abstractC0835pA;
        }

        /* JADX INFO: renamed from: a */
        private static void m5885a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        private static C1018sY m5886b() {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C0622l) || (abstractC0787oFM2688a = ((C0622l) abstractC0563juM168a).m2688a()) == null) {
                return null;
            }
            return abstractC0787oFM2688a.m3653a();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tH$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH$a.class */
    public enum a implements InterfaceC0422hL {
        NORMAL("Normal", -1, "normal"),
        SNAP("Snap (0.25)", -12224, "snap"),
        COLLIDE("Collide", -12529409, "collide"),
        SNAP_COLLIDE("Snap + Collide", -8323200, "snap_collide");


        @NotNull
        private final String displayName;
        private final int displayColor;

        @NotNull
        private final String settingsKey;

        a(@NotNull String str, int i, @NotNull String str2) {
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

        @Override // com.boehmod.blockfront.InterfaceC0422hL
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
