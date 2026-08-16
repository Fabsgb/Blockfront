package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.aF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aF.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0036aF {

    /* JADX INFO: renamed from: a */
    private static final Vector3f f310a;

    /* JADX INFO: renamed from: r */
    public static final ResourceLocation f311r;

    /* JADX INFO: renamed from: ai */
    public static final float f312ai = 1.2f;

    /* JADX INFO: renamed from: aj */
    public static final float f313aj = 5.0f;

    /* JADX INFO: renamed from: a */
    public static Vec2 f314a;

    /* JADX INFO: renamed from: b */
    public static Vec2 f315b;

    /* JADX INFO: renamed from: c */
    public static Vec2 f316c;

    /* JADX INFO: renamed from: ak */
    public static float f317ak;

    /* JADX INFO: renamed from: al */
    public static float f318al;

    /* JADX INFO: renamed from: am */
    public static float f319am;

    /* JADX INFO: renamed from: an */
    public static float f320an;

    /* JADX INFO: renamed from: ao */
    public static float f321ao;

    /* JADX INFO: renamed from: ap */
    public static float f322ap;

    /* JADX INFO: renamed from: aq */
    public static float f323aq;

    /* JADX INFO: renamed from: ar */
    public static float f324ar;

    /* JADX INFO: renamed from: as */
    public static float f325as;

    /* JADX INFO: renamed from: at */
    public static float f326at;

    /* JADX INFO: renamed from: au */
    public static float f327au;

    /* JADX INFO: renamed from: av */
    private static float f328av;

    /* JADX INFO: renamed from: aw */
    private static float f329aw;

    /* JADX INFO: renamed from: ax */
    private static float f330ax;

    /* JADX INFO: renamed from: ay */
    private static float f331ay;

    /* JADX INFO: renamed from: az */
    private static float f332az;

    /* JADX INFO: renamed from: aA */
    private static float f333aA;

    /* JADX INFO: renamed from: aa */
    static final /* synthetic */ boolean f334aa;

    static {
        f334aa = !C0036aF.class.desiredAssertionStatus();
        f310a = new Vector3f();
        f311r = C0532jO.m2378d("textures/misc/muzzleflash/scopeflare.png");
        f314a = Vec2.ZERO;
        f315b = Vec2.ZERO;
        f316c = Vec2.ZERO;
        f317ak = 0.0f;
        f318al = 0.0f;
        f319am = 0.0f;
        f321ao = 0.0f;
        f323aq = 0.0f;
        f325as = 0.0f;
        f327au = 0.0f;
        f330ax = 0.0f;
        f333aA = 0.0f;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m201a(@NotNull RenderHandEvent renderHandEvent) {
        C0755nZ c0755nZM3472a;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        boolean z = renderHandEvent.getHand() == InteractionHand.MAIN_HAND;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f334aa && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        float fM466g = C0129bt.m466g();
        if (entity == null || !(minecraft.getEntityRenderDispatcher().getRenderer(entity) instanceof C0441hd)) {
            return;
        }
        if (C0875pn.m4488a((Player) entity, (AbstractC0183b<?, ?, ?, ?>) c0396gl.m1885a(minecraft))) {
            renderHandEvent.setCanceled(true);
            return;
        }
        float partialTick = renderHandEvent.getPartialTick();
        PoseStack poseStack = renderHandEvent.getPoseStack();
        renderHandEvent.getMultiBufferSource();
        renderHandEvent.getPackedLight();
        if (c0623lM2852b.m2895a().m3074aJ()) {
            renderHandEvent.setCanceled(true);
            return;
        }
        if (entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C1067tS)) {
            renderHandEvent.setCanceled(true);
            return;
        }
        Entity vehicle = entity.getVehicle();
        if ((vehicle instanceof AbstractC0750nU) && (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a(entity)) != null && c0755nZM3472a.f4187fM) {
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
        if (itemStack.getItem() instanceof C1134ug) {
            poseStack.translate(0.0f, 0.4f, 0.0f);
        }
        if (itemStack.getItem() instanceof C1102uA) {
            poseStack.translate(0.0f, 0.6f, 0.0f);
        }
        Item item = itemStack.getItem();
        if (item instanceof AbstractC1140um) {
            AbstractC1140um abstractC1140um = (AbstractC1140um) item;
            if (abstractC1140um instanceof C1117uP) {
                poseStack.translate(0.0f, 0.6f, 0.0f);
            }
            float fM7170f = C1270xJ.m7170f(f314a.x, f315b.x, partialTick);
            float fM7170f2 = C1270xJ.m7170f(f314a.y, f315b.y, partialTick);
            float f = 0.0f;
            if (C0495ie.f3057K.m2230U()) {
                float fM2223N = C0495ie.f3058d.m2223N();
                C0400gp.f2590a.m1904a(fM466g, C1117uP.f6063il ? 80.0f : 20.0f, f310a);
                poseStack.mulPose(Axis.XP.rotationDegrees(f310a.x * fM2223N));
                poseStack.mulPose(Axis.YP.rotationDegrees(f310a.y * fM2223N));
                poseStack.mulPose(Axis.ZP.rotationDegrees(f310a.z * fM2223N));
            }
            if (!C1117uP.f6063il) {
                float fM7170f3 = C1270xJ.m7170f(C0115bf.f782bW, C0115bf.f783bX, partialTick);
                C0400gp.f2592c.m1904a(fM466g, 1.0f, f310a);
                fM7170f += f310a.x * fM7170f3;
                fM7170f2 += f310a.y * fM7170f3;
                f = 0.0f + (f310a.z * fM7170f3);
            }
            float fM7170f4 = C1270xJ.m7170f(C0115bf.f778bx, C0115bf.f779by, partialTick);
            if (fM7170f4 > 0.0f) {
                C0400gp.f2591b.m1904a(fM466g, 1.0f, f310a).mul(4.0f);
                fM7170f += f310a.x * fM7170f4;
                fM7170f2 += f310a.y * fM7170f4;
                f += f310a.z * fM7170f4;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
            if (abstractC0863pbM2874a != null) {
                List<InterfaceC0917qc> listM6083aA = abstractC0863pbM2874a.m4089a().m6083aA();
                if (!listM6083aA.isEmpty()) {
                    float fM2289O = c0623lM2852b.m2869a().m2289O();
                    Iterator<InterfaceC0917qc> it = listM6083aA.iterator();
                    while (it.hasNext()) {
                        Vector3f vector3fMo5069a = it.next().mo5069a(fM466g, fM2289O);
                        fM7170f += vector3fMo5069a.x;
                        fM7170f2 += vector3fMo5069a.y;
                        f += vector3fMo5069a.z;
                    }
                }
            }
            float fM7170f5 = C1270xJ.m7170f(f320an, f321ao, partialTick);
            float fM7170f6 = C1270xJ.m7170f(f322ap, f323aq, partialTick);
            float fM7170f7 = C1270xJ.m7170f(f324ar, f325as, partialTick);
            float f2 = fM7170f - (fM7170f5 * 3.0f);
            float f3 = fM7170f2 - (fM7170f6 * 3.0f);
            float f4 = f - (fM7170f7 * 3.0f);
            Vector3f vector3fMul = C0432hU.m1991a(partialTick).mul(C1117uP.f6063il ? 1.0f : 1.75f);
            float f5 = f2 + vector3fMul.x;
            float f6 = f3 + vector3fMul.y;
            float f7 = f4 + vector3fMul.z;
            float fM7170f8 = C1270xJ.m7170f(((LocalPlayer) entity).walkDist, ((LocalPlayer) entity).walkDistO, partialTick) * 16.0f;
            float f8 = C1117uP.f6063il ? 0.1f : 1.0f;
            float fSin = Mth.sin(fM7170f8 / 2.5f) * f8;
            float fSin2 = Mth.sin(fM7170f8 / 3.0f) * f8;
            float fSin3 = Mth.sin(fM7170f8 / 3.3f) * f8;
            float fSin4 = Mth.sin(fM7170f8 / 5.0f);
            float fSin5 = Mth.sin(fM7170f8 / 2.5f);
            float fM7170f9 = C1270xJ.m7170f(C0034aD.f298Z, C0034aD.f299aa, partialTick);
            float fM7170f10 = C1270xJ.m7170f(C0034aD.f296X, C0034aD.f297Y, partialTick);
            float f9 = 0.0f + (2.5f * fSin * fM7170f10);
            float f10 = 0.0f + (2.75f * fSin2 * fM7170f10);
            float f11 = 0.0f + (0.7f * fSin3 * fM7170f10);
            poseStack.translate((-0.04f) * fSin4 * fM7170f9, 0.0f, 0.0f);
            float f12 = f9 + (5.0f * fSin5 * fM7170f9);
            float f13 = f11 + (2.0f * fSin4 * fM7170f9);
            float f14 = f5 + f12;
            float f15 = f6 + f13;
            float f16 = f7 + f10;
            Vec3 vec3Scale = abstractC1140um.mo6195y().scale(C1270xJ.m7170f(f326at, f327au, partialTick));
            poseStack.mulPose(Axis.XP.rotationDegrees((float) vec3Scale.x));
            poseStack.mulPose(Axis.YP.rotationDegrees((float) vec3Scale.y));
            poseStack.mulPose(Axis.ZP.rotationDegrees((float) vec3Scale.z));
            float fM7170f11 = C1270xJ.m7170f(C0034aD.f300ab, C0034aD.f301ac, partialTick);
            poseStack.translate(0.0f, (-0.5f) * fM7170f11, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees((-10.0f) * fM7170f11));
            poseStack.mulPose(Axis.YP.rotationDegrees(60.0f * fM7170f11));
            poseStack.mulPose(Axis.ZP.rotationDegrees(5.0f * fM7170f11));
            float fM7170f12 = C1270xJ.m7170f(C0112bc.f737bv, C0112bc.f738bw, partialTick);
            Vector3f vector3fMul2 = new Vector3f(125.0f, 150.0f, -45.0f).mul(fM7170f12).mul(1.0f, z ? 1.0f : -1.0f, z ? 1.0f : -1.0f);
            float f17 = f14 + vector3fMul2.x;
            float f18 = f15 + vector3fMul2.y;
            float f19 = f16 + vector3fMul2.z;
            poseStack.translate((-0.5f) * fM7170f12, (-0.1f) * fM7170f12, 0.5f * fM7170f12);
            if (C0112bc.f746bD > 0.0f && C0112bc.f747bE > 0.0f) {
                float fM7170f13 = C1270xJ.m7170f(C0112bc.f746bD, C0112bc.f747bE, partialTick);
                float fSin6 = Mth.sin(fM466g / 50.0f) * (1.0f - ((0.2f * Mth.sin(fM466g / 30.0f)) * Mth.sin(fM466g / 40.0f)));
                f17 += 45.0f * fM7170f13;
                f18 += 110.0f * fM7170f13;
                f19 += ((-25.0f) + (45.0f * fSin6)) * fM7170f13;
                poseStack.translate((-0.2f) * fM7170f13, 0.1f * fM7170f13, 0.15f * fM7170f13);
                poseStack.translate((-0.1f) * fSin6 * fM7170f13, 0.0f, 0.1f * fSin6 * fM7170f13);
            }
            float f20 = z ? f328av : f331ay;
            float f21 = z ? f329aw : f332az;
            float f22 = z ? f330ax : f333aA;
            float fLerp = Mth.lerp(0.2f, f20, f17);
            float fLerp2 = Mth.lerp(0.2f, f21, f18);
            float fLerp3 = Mth.lerp(0.2f, f22, f19);
            poseStack.translate(0.35f, -0.5f, -0.8f);
            poseStack.mulPose(Axis.XP.rotationDegrees(fLerp / 2.0f));
            poseStack.mulPose(Axis.YP.rotationDegrees(fLerp2 / 2.0f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(fLerp3 / 2.0f));
            poseStack.translate(-0.35f, -(-0.5f), -(-0.8f));
            if (z) {
                f328av = fLerp;
                f329aw = fLerp2;
                f330ax = fLerp3;
            } else {
                f331ay = fLerp;
                f332az = fLerp2;
                f333aA = fLerp3;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m202a(@Nullable LocalPlayer localPlayer) {
        f315b = new Vec2(f314a.x, f314a.y);
        f314a = new Vec2(Mth.lerp(0.4f, f314a.x, 0.0f), Mth.lerp(0.4f, f314a.y, 0.0f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.aF$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aF$d.class */
    public static final class d extends Record {

        /* JADX INFO: renamed from: E */
        private final double f350E;

        /* JADX INFO: renamed from: F */
        private final double f351F;

        /* JADX INFO: renamed from: G */
        private final double f352G;

        /* JADX INFO: renamed from: aK */
        private final float f353aK;

        /* JADX INFO: renamed from: aL */
        private final float f354aL;

        /* JADX INFO: renamed from: aM */
        private final float f355aM;

        /* JADX INFO: renamed from: aN */
        private final float f356aN;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/aF$d;->E:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->F:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->G:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->aK:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aL:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aM:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/aF$d;->E:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->F:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->G:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->aK:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aL:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aM:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "posX;posY;posZ;rotX;rotY;rotZ;scale", "FIELD:Lcom/boehmod/blockfront/aF$d;->E:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->F:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->G:D", "FIELD:Lcom/boehmod/blockfront/aF$d;->aK:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aL:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aM:F", "FIELD:Lcom/boehmod/blockfront/aF$d;->aN:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: k */
        public double m205k() {
            return this.f350E;
        }

        /* JADX INFO: renamed from: l */
        public double m206l() {
            return this.f351F;
        }

        /* JADX INFO: renamed from: m */
        public double m207m() {
            return this.f352G;
        }

        /* JADX INFO: renamed from: c */
        public float m208c() {
            return this.f353aK;
        }

        /* JADX INFO: renamed from: d */
        public float m209d() {
            return this.f354aL;
        }

        /* JADX INFO: renamed from: e */
        public float m210e() {
            return this.f355aM;
        }

        /* JADX INFO: renamed from: f */
        public float m211f() {
            return this.f356aN;
        }

        public d(double d, double d2, double d3, float f, float f2, float f3) {
            this(d, d2, d3, f, f2, f3, 1.0f);
        }

        public d(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            this.f350E = d;
            this.f351F = d2;
            this.f352G = d3;
            this.f353aK = f;
            this.f354aL = f2;
            this.f355aM = f3;
            this.f356aN = f4;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.aF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aF$a.class */
    public static abstract class a {

        /* JADX INFO: renamed from: bG */
        protected int f335bG;

        /* JADX INFO: renamed from: bH */
        protected int f336bH;

        /* JADX INFO: renamed from: a */
        public abstract void mo204a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4);

        public a(int i, @NotNull Random random) {
            this.f336bH = i;
            this.f335bG = i;
        }

        /* JADX INFO: renamed from: m */
        public boolean mo203m() {
            int i = this.f335bG;
            this.f335bG = i - 1;
            this.f336bH = i;
            return i <= 0;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.aF$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aF$b.class */
    public static class b extends a {

        /* JADX INFO: renamed from: s */
        @Nonnull
        private final ResourceLocation f337s;

        public b(int i, @NotNull Random random) {
            super(i, random);
            this.f337s = C0532jO.m2378d("textures/misc/muzzleflash/firepuff" + ThreadLocalRandom.current().nextInt(0, 4) + ".png");
        }

        @Override // com.boehmod.blockfront.C0036aF.a
        /* JADX INFO: renamed from: a */
        public void mo204a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            float fM7170f = C1270xJ.m7170f(this.f335bG, this.f336bH, f2) * f;
            float f5 = (20.0f / fM7170f) * f4;
            float fSin = Mth.sin(f3 * 2.0f);
            poseStack.pushPose();
            poseStack.translate(0.0f, 0.0f, 1.4f + (4.0f / fM7170f));
            C0129bt.m544b(poseStack, guiGraphics, this.f337s, 0.0f, 0.0f, f5, f5, 40.0f * fSin, 0.1f * fM7170f);
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.aF$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aF$c.class */
    public static class c extends a {

        /* JADX INFO: renamed from: bI */
        private static final int f338bI = 8;

        /* JADX INFO: renamed from: aB */
        private static final float f339aB = 0.12f;

        /* JADX INFO: renamed from: aC */
        private static final float f340aC = 3.0f;

        /* JADX INFO: renamed from: aD */
        private static final float f341aD = 3.0f;

        /* JADX INFO: renamed from: aE */
        private static final float f342aE = 0.5f;

        /* JADX INFO: renamed from: aF */
        private static final float f343aF = 0.45f;

        /* JADX INFO: renamed from: t */
        private final ResourceLocation f344t;

        /* JADX INFO: renamed from: ab */
        private final boolean f345ab;

        /* JADX INFO: renamed from: aG */
        private float f346aG;

        /* JADX INFO: renamed from: aH */
        private float f347aH;

        /* JADX INFO: renamed from: aI */
        private float f348aI;

        /* JADX INFO: renamed from: aJ */
        private float f349aJ;

        public c(@NotNull Random random, int i) {
            super(i, random);
            this.f345ab = Math.random() < 0.5d;
            this.f346aG = 0.5f;
            this.f347aH = 0.5f;
            this.f348aI = f343aF;
            this.f349aJ = f343aF;
            this.f344t = C0532jO.m2378d("textures/misc/muzzleflash/smokepuff" + random.nextInt(0, 8) + ".png");
            mo203m();
        }

        @Override // com.boehmod.blockfront.C0036aF.a
        /* JADX INFO: renamed from: m */
        public boolean mo203m() {
            this.f347aH = this.f346aG;
            this.f346aG = C1270xJ.m7161d(this.f346aG, 1.0f, f339aB);
            this.f349aJ = this.f348aI;
            this.f348aI = C1270xJ.m7161d(this.f348aI, 0.0f, f339aB);
            return this.f348aI + this.f349aJ <= 0.0f;
        }

        @Override // com.boehmod.blockfront.C0036aF.a
        /* JADX INFO: renamed from: a */
        public void mo204a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            C1270xJ.m7170f(this.f335bG, this.f336bH, f2);
            float fM7170f = C1270xJ.m7170f(this.f346aG, this.f347aH, f2);
            float fM7170f2 = C1270xJ.m7170f(this.f348aI, this.f349aJ, f2) * f;
            float f5 = 3.0f * fM7170f * f4;
            poseStack.pushPose();
            C0129bt.m544b(poseStack, guiGraphics, this.f344t, 0.0f, 0.0f, f5, f5, 0.0f, fM7170f2);
            poseStack.popPose();
        }
    }
}
