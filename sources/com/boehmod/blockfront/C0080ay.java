package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.ay */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0080ay {

    /* JADX INFO: renamed from: a */
    private static final Vector3f f488a;

    /* JADX INFO: renamed from: r */
    public static final ResourceLocation f489r;

    /* JADX INFO: renamed from: ad */
    public static final float f490ad = 1.2f;

    /* JADX INFO: renamed from: ae */
    public static final float f491ae = 5.0f;

    /* JADX INFO: renamed from: a */
    public static Vec2 f492a;

    /* JADX INFO: renamed from: b */
    public static Vec2 f493b;

    /* JADX INFO: renamed from: c */
    public static Vec2 f494c;

    /* JADX INFO: renamed from: af */
    public static float f495af;

    /* JADX INFO: renamed from: ag */
    public static float f496ag;

    /* JADX INFO: renamed from: ah */
    public static float f497ah;

    /* JADX INFO: renamed from: ai */
    public static float f498ai;

    /* JADX INFO: renamed from: aj */
    public static float f499aj;

    /* JADX INFO: renamed from: ak */
    public static float f500ak;

    /* JADX INFO: renamed from: al */
    public static float f501al;

    /* JADX INFO: renamed from: am */
    public static float f502am;

    /* JADX INFO: renamed from: an */
    public static float f503an;

    /* JADX INFO: renamed from: ao */
    public static float f504ao;

    /* JADX INFO: renamed from: ap */
    public static float f505ap;

    /* JADX INFO: renamed from: aq */
    private static float f506aq;

    /* JADX INFO: renamed from: ar */
    private static float f507ar;

    /* JADX INFO: renamed from: as */
    private static float f508as;

    /* JADX INFO: renamed from: at */
    private static float f509at;

    /* JADX INFO: renamed from: au */
    private static float f510au;

    /* JADX INFO: renamed from: av */
    private static float f511av;

    /* JADX INFO: renamed from: V */
    static final /* synthetic */ boolean f512V;

    static {
        f512V = !C0080ay.class.desiredAssertionStatus();
        f488a = new Vector3f();
        f489r = C0564jv.m2555d("textures/misc/muzzleflash/scopeflare.png");
        f492a = Vec2.ZERO;
        f493b = Vec2.ZERO;
        f494c = Vec2.ZERO;
        f495af = 0.0f;
        f496ag = 0.0f;
        f497ah = 0.0f;
        f499aj = 0.0f;
        f501al = 0.0f;
        f503an = 0.0f;
        f505ap = 0.0f;
        f508as = 0.0f;
        f511av = 0.0f;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m274a(@NotNull RenderHandEvent renderHandEvent) {
        C0732nD c0732nDM3535a;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        boolean z = renderHandEvent.getHand() == InteractionHand.MAIN_HAND;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f512V && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        float fM366g = C0119bk.m366g();
        if (entity == null || !(minecraft.getEntityRenderDispatcher().getRenderer(entity) instanceof C0371gN)) {
            return;
        }
        if (C0799oR.m4052a((Player) entity, (AbstractC0182b<?, ?, ?, ?>) c0326fV.m1675a(minecraft))) {
            renderHandEvent.setCanceled(true);
            return;
        }
        float partialTick = renderHandEvent.getPartialTick();
        PoseStack poseStack = renderHandEvent.getPoseStack();
        renderHandEvent.getMultiBufferSource();
        renderHandEvent.getPackedLight();
        if (c0622lM2667b.m2709a().m3241ay()) {
            renderHandEvent.setCanceled(true);
            return;
        }
        if (entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C1094tu)) {
            renderHandEvent.setCanceled(true);
            return;
        }
        Entity vehicle = entity.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a(entity)) != null && c0732nDM3535a.f3939fs) {
            renderHandEvent.setCanceled(true);
            return;
        }
        ItemStack offhandItem = entity.getOffhandItem();
        InteractionHand hand = renderHandEvent.getHand();
        if (hand.equals(InteractionHand.MAIN_HAND) && !offhandItem.isEmpty()) {
            poseStack.pushPose();
        } else if (hand.equals(InteractionHand.OFF_HAND) && !offhandItem.isEmpty()) {
            poseStack.popPose();
        }
        ItemStack itemStack = renderHandEvent.getItemStack();
        if (itemStack.getItem() instanceof C1056tI) {
            poseStack.translate(0.0f, 0.4f, 0.0f);
        }
        if (itemStack.getItem() instanceof C1129uc) {
            poseStack.translate(0.0f, 0.6f, 0.0f);
        }
        Item item = itemStack.getItem();
        if (item instanceof AbstractC1062tO) {
            AbstractC1062tO abstractC1062tO = (AbstractC1062tO) item;
            if (abstractC1062tO instanceof C1144ur) {
                poseStack.translate(0.0f, 0.6f, 0.0f);
            }
            float fM7843e = C1290xm.m7843e(f492a.x, f493b.x, partialTick);
            float fM7843e2 = C1290xm.m7843e(f492a.y, f493b.y, partialTick);
            float f = 0.0f;
            if (C0424hN.f2756K.m1996T()) {
                float fM1992N = C0424hN.f2757d.m1992N();
                C0330fZ.f2395a.m1694a(fM366g, C1144ur.f5994hR ? 80.0f : 20.0f, f488a);
                poseStack.mulPose(Axis.XP.rotationDegrees(f488a.x * fM1992N));
                poseStack.mulPose(Axis.YP.rotationDegrees(f488a.y * fM1992N));
                poseStack.mulPose(Axis.ZP.rotationDegrees(f488a.z * fM1992N));
            }
            if (!C1144ur.f5994hR) {
                float fM7843e3 = C1290xm.m7843e(C0053aX.f368bQ, C0053aX.f369bR, partialTick);
                C0330fZ.f2397c.m1694a(fM366g, 1.0f, f488a);
                fM7843e += f488a.x * fM7843e3;
                fM7843e2 += f488a.y * fM7843e3;
                f = 0.0f + (f488a.z * fM7843e3);
            }
            float fM7843e4 = C1290xm.m7843e(C0053aX.f364br, C0053aX.f365bs, partialTick);
            if (fM7843e4 > 0.0f) {
                C0330fZ.f2396b.m1694a(fM366g, 1.0f, f488a).mul(4.0f);
                fM7843e += f488a.x * fM7843e4;
                fM7843e2 += f488a.y * fM7843e4;
                f += f488a.z * fM7843e4;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
            if (abstractC0787oFM2688a != null) {
                List<InterfaceC0841pG> listM5595ay = abstractC0787oFM2688a.m3653a().m5595ay();
                if (!listM5595ay.isEmpty()) {
                    float fM2234O = c0622lM2667b.m2683a().m2234O();
                    Iterator<InterfaceC0841pG> it = listM5595ay.iterator();
                    while (it.hasNext()) {
                        Vector3f vector3fMo4267a = it.next().mo4267a(fM366g, fM2234O);
                        fM7843e += vector3fMo4267a.x;
                        fM7843e2 += vector3fMo4267a.y;
                        f += vector3fMo4267a.z;
                    }
                }
            }
            float fM7843e5 = C1290xm.m7843e(f498ai, f499aj, partialTick);
            float fM7843e6 = C1290xm.m7843e(f500ak, f501al, partialTick);
            float fM7843e7 = C1290xm.m7843e(f502am, f503an, partialTick);
            float f2 = fM7843e - (fM7843e5 * 3.0f);
            float f3 = fM7843e2 - (fM7843e6 * 3.0f);
            float f4 = f - (fM7843e7 * 3.0f);
            Vector3f vector3fMul = C0415hE.m1964a(partialTick).mul(C1144ur.f5994hR ? 1.0f : 1.75f);
            float f5 = f2 + vector3fMul.x;
            float f6 = f3 + vector3fMul.y;
            float f7 = f4 + vector3fMul.z;
            float fM7843e8 = C1290xm.m7843e(((LocalPlayer) entity).walkDist, ((LocalPlayer) entity).walkDistO, partialTick) * 16.0f;
            float f8 = C1144ur.f5994hR ? 0.1f : 1.0f;
            float fSin = Mth.sin(fM7843e8 / 2.5f) * f8;
            float fSin2 = Mth.sin(fM7843e8 / 3.0f) * f8;
            float fSin3 = Mth.sin(fM7843e8 / 3.3f) * f8;
            float fSin4 = Mth.sin(fM7843e8 / 5.0f);
            float fSin5 = Mth.sin(fM7843e8 / 2.5f);
            float fM7843e9 = C1290xm.m7843e(C0078aw.f476U, C0078aw.f477V, partialTick);
            float fM7843e10 = C1290xm.m7843e(C0078aw.f474S, C0078aw.f475T, partialTick);
            float f9 = 0.0f + (2.5f * fSin * fM7843e10);
            float f10 = 0.0f + (2.75f * fSin2 * fM7843e10);
            float f11 = 0.0f + (0.7f * fSin3 * fM7843e10);
            poseStack.translate((-0.04f) * fSin4 * fM7843e9, 0.0f, 0.0f);
            float f12 = f9 + (5.0f * fSin5 * fM7843e9);
            float f13 = f11 + (2.0f * fSin4 * fM7843e9);
            float f14 = f5 + f12;
            float f15 = f6 + f13;
            float f16 = f7 + f10;
            Vec3 vec3Scale = abstractC1062tO.mo5893x().scale(C1290xm.m7843e(f504ao, f505ap, partialTick));
            poseStack.mulPose(Axis.XP.rotationDegrees((float) vec3Scale.x));
            poseStack.mulPose(Axis.YP.rotationDegrees((float) vec3Scale.y));
            poseStack.mulPose(Axis.ZP.rotationDegrees((float) vec3Scale.z));
            float fM7843e11 = C1290xm.m7843e(C0078aw.f478W, C0078aw.f479X, partialTick);
            poseStack.translate(0.0f, (-0.5f) * fM7843e11, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees((-10.0f) * fM7843e11));
            poseStack.mulPose(Axis.YP.rotationDegrees(60.0f * fM7843e11));
            poseStack.mulPose(Axis.ZP.rotationDegrees(5.0f * fM7843e11));
            float fM7843e12 = C1290xm.m7843e(C0050aU.f323bp, C0050aU.f324bq, partialTick);
            Vector3f vector3fMul2 = new Vector3f(125.0f, 150.0f, -45.0f).mul(fM7843e12).mul(1.0f, z ? 1.0f : -1.0f, z ? 1.0f : -1.0f);
            float f17 = f14 + vector3fMul2.x;
            float f18 = f15 + vector3fMul2.y;
            float f19 = f16 + vector3fMul2.z;
            poseStack.translate((-0.5f) * fM7843e12, (-0.1f) * fM7843e12, 0.5f * fM7843e12);
            if (C0050aU.f332bx > 0.0f && C0050aU.f333by > 0.0f) {
                float fM7843e13 = C1290xm.m7843e(C0050aU.f332bx, C0050aU.f333by, partialTick);
                float fSin6 = Mth.sin(fM366g / 50.0f) * (1.0f - ((0.2f * Mth.sin(fM366g / 30.0f)) * Mth.sin(fM366g / 40.0f)));
                f17 += 45.0f * fM7843e13;
                f18 += 110.0f * fM7843e13;
                f19 += ((-25.0f) + (45.0f * fSin6)) * fM7843e13;
                poseStack.translate((-0.2f) * fM7843e13, 0.1f * fM7843e13, 0.15f * fM7843e13);
                poseStack.translate((-0.1f) * fSin6 * fM7843e13, 0.0f, 0.1f * fSin6 * fM7843e13);
            }
            float f20 = z ? f506aq : f509at;
            float f21 = z ? f507ar : f510au;
            float f22 = z ? f508as : f511av;
            float fLerp = Mth.lerp(0.2f, f20, f17);
            float fLerp2 = Mth.lerp(0.2f, f21, f18);
            float fLerp3 = Mth.lerp(0.2f, f22, f19);
            poseStack.translate(0.35f, -0.5f, -0.8f);
            poseStack.mulPose(Axis.XP.rotationDegrees(fLerp / 2.0f));
            poseStack.mulPose(Axis.YP.rotationDegrees(fLerp2 / 2.0f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(fLerp3 / 2.0f));
            poseStack.translate(-0.35f, -(-0.5f), -(-0.8f));
            if (z) {
                f506aq = fLerp;
                f507ar = fLerp2;
                f508as = fLerp3;
            } else {
                f509at = fLerp;
                f510au = fLerp2;
                f511av = fLerp3;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m275a(@Nullable LocalPlayer localPlayer) {
        f493b = new Vec2(f492a.x, f492a.y);
        f492a = new Vec2(Mth.lerp(0.4f, f492a.x, 0.0f), Mth.lerp(0.4f, f492a.y, 0.0f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$d.class */
    public static final class d extends Record {

        /* JADX INFO: renamed from: x */
        private final double f528x;

        /* JADX INFO: renamed from: y */
        private final double f529y;

        /* JADX INFO: renamed from: z */
        private final double f530z;

        /* JADX INFO: renamed from: aF */
        private final float f531aF;

        /* JADX INFO: renamed from: aG */
        private final float f532aG;

        /* JADX INFO: renamed from: aH */
        private final float f533aH;

        /* JADX INFO: renamed from: aI */
        private final float f534aI;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/ay$d;->x:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->y:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->z:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->aF:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aG:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aH:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aI:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/ay$d;->x:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->y:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->z:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->aF:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aG:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aH:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aI:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/ay$d;->x:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->y:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->z:D", "FIELD:Lcom/boehmod/blockfront/ay$d;->aF:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aG:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aH:F", "FIELD:Lcom/boehmod/blockfront/ay$d;->aI:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: i */
        public double m278i() {
            return this.f528x;
        }

        /* JADX INFO: renamed from: j */
        public double m279j() {
            return this.f529y;
        }

        /* JADX INFO: renamed from: k */
        public double m280k() {
            return this.f530z;
        }

        /* JADX INFO: renamed from: c */
        public float m281c() {
            return this.f531aF;
        }

        /* JADX INFO: renamed from: d */
        public float m282d() {
            return this.f532aG;
        }

        /* JADX INFO: renamed from: e */
        public float m283e() {
            return this.f533aH;
        }

        /* JADX INFO: renamed from: f */
        public float m284f() {
            return this.f534aI;
        }

        public d(double d, double d2, double d3, float f, float f2, float f3) {
            this(d, d2, d3, f, f2, f3, 1.0f);
        }

        public d(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            this.f528x = d;
            this.f529y = d2;
            this.f530z = d3;
            this.f531aF = f;
            this.f532aG = f2;
            this.f533aH = f3;
            this.f534aI = f4;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$a.class */
    public static abstract class a {

        /* JADX INFO: renamed from: aS */
        protected int f513aS;

        /* JADX INFO: renamed from: aT */
        protected int f514aT;

        /* JADX INFO: renamed from: a */
        public abstract void mo277a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4);

        public a(int i, @NotNull Random random) {
            this.f514aT = i;
            this.f513aS = i;
        }

        /* JADX INFO: renamed from: l */
        public boolean mo276l() {
            int i = this.f513aS;
            this.f513aS = i - 1;
            this.f514aT = i;
            return i <= 0;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$b.class */
    public static class b extends a {

        /* JADX INFO: renamed from: s */
        @Nonnull
        private final ResourceLocation f515s;

        public b(int i, @NotNull Random random) {
            super(i, random);
            this.f515s = C0564jv.m2555d("textures/misc/muzzleflash/firepuff" + ThreadLocalRandom.current().nextInt(0, 4) + ".png");
        }

        @Override // com.boehmod.blockfront.C0080ay.a
        /* JADX INFO: renamed from: a */
        public void mo277a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            float fM7843e = C1290xm.m7843e(this.f513aS, this.f514aT, f2) * f;
            float f5 = (20.0f / fM7843e) * f4;
            float fSin = Mth.sin(f3 * 2.0f);
            poseStack.pushPose();
            poseStack.translate(0.0f, 0.0f, 1.4f + (4.0f / fM7843e));
            C0119bk.m444b(poseStack, guiGraphics, this.f515s, 0.0f, 0.0f, f5, f5, 40.0f * fSin, 0.1f * fM7843e);
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$c.class */
    public static class c extends a {

        /* JADX INFO: renamed from: aU */
        private static final int f516aU = 8;

        /* JADX INFO: renamed from: aw */
        private static final float f517aw = 0.12f;

        /* JADX INFO: renamed from: ax */
        private static final float f518ax = 3.0f;

        /* JADX INFO: renamed from: ay */
        private static final float f519ay = 3.0f;

        /* JADX INFO: renamed from: az */
        private static final float f520az = 0.5f;

        /* JADX INFO: renamed from: aA */
        private static final float f521aA = 0.45f;

        /* JADX INFO: renamed from: t */
        private final ResourceLocation f522t;

        /* JADX INFO: renamed from: W */
        private final boolean f523W;

        /* JADX INFO: renamed from: aB */
        private float f524aB;

        /* JADX INFO: renamed from: aC */
        private float f525aC;

        /* JADX INFO: renamed from: aD */
        private float f526aD;

        /* JADX INFO: renamed from: aE */
        private float f527aE;

        public c(@NotNull Random random, int i) {
            super(i, random);
            this.f523W = Math.random() < 0.5d;
            this.f524aB = 0.5f;
            this.f525aC = 0.5f;
            this.f526aD = f521aA;
            this.f527aE = f521aA;
            this.f522t = C0564jv.m2555d("textures/misc/muzzleflash/smokepuff" + random.nextInt(0, 8) + ".png");
            mo276l();
        }

        @Override // com.boehmod.blockfront.C0080ay.a
        /* JADX INFO: renamed from: l */
        public boolean mo276l() {
            this.f525aC = this.f524aB;
            this.f524aB = C1290xm.m7835d(this.f524aB, 1.0f, f517aw);
            this.f527aE = this.f526aD;
            this.f526aD = C1290xm.m7835d(this.f526aD, 0.0f, f517aw);
            return this.f526aD + this.f527aE <= 0.0f;
        }

        @Override // com.boehmod.blockfront.C0080ay.a
        /* JADX INFO: renamed from: a */
        public void mo277a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            C1290xm.m7843e(this.f513aS, this.f514aT, f2);
            float fM7843e = C1290xm.m7843e(this.f524aB, this.f525aC, f2);
            float fM7843e2 = C1290xm.m7843e(this.f526aD, this.f527aE, f2) * f;
            float f5 = 3.0f * fM7843e * f4;
            poseStack.pushPose();
            C0119bk.m444b(poseStack, guiGraphics, this.f522t, 0.0f, 0.0f, f5, f5, 0.0f, fM7843e2);
            poseStack.popPose();
        }
    }
}
