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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH.class */
public class tH extends Item {
    public static final double aI = 64.0d;
    public static final double aJ = 1.0d;
    public static final double aK = 1.0d;
    public static final double aL = 0.25d;
    public static final int rD = 10;
    public static final float mu = 0.0f;
    public static final float mv = 64.0f;

    public tH(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!player.isCreative()) {
            return InteractionResultHolder.pass(itemInHand);
        }
        if (level.isClientSide()) {
            b.e(player);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        if (level.isClientSide() && z && (entity instanceof Player)) {
            Player player = (Player) entity;
            if (player.isCreative()) {
                b.f(player);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH$b.class */
    @OnlyIn(Dist.CLIENT)
    public static final class b {

        @Nullable
        private static UUID E = null;
        private static double aM = 0.0d;

        @Nullable
        private static Vec3 ag = null;

        @Nullable
        private static Vec3 ah = null;

        @Nullable
        private static Vec3 ai = null;

        @Nullable
        private static Vec3 aj = null;

        @NotNull
        private static a a = a.NORMAL;
        private static int rE = 0;

        private b() {
        }

        @Nullable
        public static UUID j() {
            return E;
        }

        @Nullable
        public static Vec3 v() {
            return ag;
        }

        @NotNull
        public static a a() {
            return (a) hN.f158a.a();
        }

        @Nullable
        public static Vec3 w() {
            return aj;
        }

        @NotNull
        public static a b() {
            return a;
        }

        public static float C(float f) {
            if (rE <= 0) {
                return 0.0f;
            }
            return Math.max(0.0f, Math.min(1.0f, (rE - f) / 10.0f));
        }

        public static void dk() {
            if (E == null) {
                return;
            }
            hN.f158a.a(a().next());
            dl();
            a(SoundEvents.NOTE_BLOCK_CHIME, 0.8f + (0.3f * r0.ordinal()));
        }

        private static void dl() {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (abstractC0264juM166a instanceof C0297l) {
                hQ.d((C0297l) abstractC0264juM166a);
            }
        }

        public static void e(@NotNull Player player) {
            pA pAVarB;
            pA pAVarA;
            UUID uuid;
            if (Screen.hasControlDown()) {
                if (E != null) {
                    uuid = E;
                } else {
                    pA pAVarB2 = b(player);
                    if (pAVarB2 == null) {
                        return;
                    } else {
                        uuid = pAVarB2.y;
                    }
                }
                C0582vo.c(new C0575vh(uuid));
                a(SoundEvents.NOTE_BLOCK_BIT, 1.5f);
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            if (Screen.hasShiftDown()) {
                if (E != null) {
                    sY sYVarM1140b = m1140b();
                    pAVarB = sYVarM1140b != null ? sYVarM1140b.a(E) : null;
                    dj();
                } else {
                    pAVarB = b(player);
                }
                if (pAVarB == null) {
                    return;
                }
                UUID uuid2 = pAVarB.y;
                if (C0378o.b(uuid2)) {
                    String strA = C0378o.a(uuid2);
                    if (strA != null && (pAVarA = C0378o.a(strA)) != null) {
                        minecraft.setScreen(new cL(null, pAVarB, pAVarA, strA));
                    }
                } else {
                    minecraft.setScreen(new cK(null, pAVarB));
                }
                a(SoundEvents.NOTE_BLOCK_HARP, 1.2f);
                return;
            }
            if (E != null) {
                if (ai != null) {
                    C0582vo.c(new vD(E, ai));
                }
                dj();
                a(SoundEvents.NOTE_BLOCK_BELL, 1.0f);
                return;
            }
            pA pAVarB3 = b(player);
            if (pAVarB3 == null) {
                return;
            }
            E = pAVarB3.y;
            aM = pAVarB3.c.distanceTo(player.getEyePosition(1.0f));
            ag = pAVarB3.c;
            a(SoundEvents.NOTE_BLOCK_PLING, 1.5f);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public static void f(@NotNull Player player) throws MatchException {
            sY sYVarM1140b;
            Vec3 vec3A;
            if (rE > 0) {
                rE--;
            }
            if (E == null || (sYVarM1140b = m1140b()) == null) {
                return;
            }
            pA pAVarA = sYVarM1140b.a(E);
            if (pAVarA == null) {
                dj();
                return;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(aM));
            switch (a()) {
                case NORMAL:
                    vec3A = vec3Add;
                    break;
                case SNAP:
                    vec3A = a(vec3Add);
                    break;
                case COLLIDE:
                    vec3A = a(player, eyePosition, vec3Add);
                    break;
                case SNAP_COLLIDE:
                    vec3A = a(a(player, eyePosition, vec3Add));
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            Vec3 vec3 = vec3A;
            ah = ai != null ? ai : vec3;
            ai = vec3;
            pAVarA.c = vec3;
        }

        public static void p(float f) {
            sY sYVarM1140b;
            pA pAVarA;
            if (E == null || ah == null || ai == null || (sYVarM1140b = m1140b()) == null || (pAVarA = sYVarM1140b.a(E)) == null) {
                return;
            }
            pAVarA.c = ah.lerp(ai, f);
        }

        @NotNull
        private static Vec3 a(@NotNull Vec3 vec3) {
            return new Vec3(Math.round(vec3.x / 0.25d) * 0.25d, Math.round(vec3.y / 0.25d) * 0.25d, Math.round(vec3.z / 0.25d) * 0.25d);
        }

        @NotNull
        private static Vec3 a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
            BlockHitResult blockHitResultClip = player.level().clip(new ClipContext(vec3, vec32, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
            return blockHitResultClip.getType() == HitResult.Type.MISS ? vec32 : blockHitResultClip.getLocation();
        }

        public static void b(double d) {
            if (E == null) {
                return;
            }
            aM = Math.max(1.0d, Math.min(64.0d, aM + d));
            a(SoundEvents.UI_BUTTON_CLICK, 2.0f - ((float) ((aM - 1.0d) / 63.0d)));
        }

        public static void dm() {
            if (E == null) {
                return;
            }
            C0582vo.c(new C0581vn(E));
            dj();
            a(SoundEvents.NOTE_BLOCK_BASS, 0.5f);
        }

        public static void dn() {
            pA pAVarA;
            if (E == null || ag == null) {
                return;
            }
            sY sYVarM1140b = m1140b();
            if (sYVarM1140b != null && (pAVarA = sYVarM1140b.a(E)) != null) {
                pAVarA.c = ag;
            }
            dj();
            a(SoundEvents.NOTE_BLOCK_BASS, 0.7f);
        }

        private static void dj() {
            if (ai != null) {
                aj = ai;
                a = a();
                rE = 10;
            }
            E = null;
            ag = null;
            aM = 0.0d;
            ah = null;
            ai = null;
        }

        @Nullable
        private static pA b(@NotNull Player player) {
            sY sYVarM1140b = m1140b();
            if (sYVarM1140b == null) {
                return null;
            }
            Vec3 eyePosition = player.getEyePosition(1.0f);
            Vec3 vec3Add = eyePosition.add(player.getViewVector(1.0f).scale(64.0d));
            pA pAVar = null;
            double d = Double.MAX_VALUE;
            for (pA pAVar2 : sYVarM1140b.ax()) {
                Optional optionalClip = pAVar2.i().clip(eyePosition, vec3Add);
                if (!optionalClip.isEmpty()) {
                    double dDistanceToSqr = ((Vec3) optionalClip.get()).distanceToSqr(eyePosition);
                    if (dDistanceToSqr < d) {
                        d = dDistanceToSqr;
                        pAVar = pAVar2;
                    }
                }
            }
            return pAVar;
        }

        private static void a(@NotNull Holder<SoundEvent> holder, float f) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(holder, f));
        }

        @Nullable
        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        private static sY m1140b() {
            oF<?, ?, ?> oFVarM591a;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof C0297l) || (oFVarM591a = ((C0297l) abstractC0264juM166a).m591a()) == null) {
                return null;
            }
            return oFVarM591a.m767a();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tH$a.class */
    public enum a implements hL {
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

        @Override // com.boehmod.blockfront.hL
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
