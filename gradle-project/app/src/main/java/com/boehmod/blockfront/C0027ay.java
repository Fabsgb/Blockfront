package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.ay, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0027ay {
    private static final Vector3f a;
    public static final ResourceLocation r;
    public static final float ad = 1.2f;
    public static final float ae = 5.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Vec2 f53a;
    public static Vec2 b;
    public static Vec2 c;
    public static float af;
    public static float ag;
    public static float ah;
    public static float ai;
    public static float aj;
    public static float ak;
    public static float al;
    public static float am;
    public static float an;
    public static float ao;
    public static float ap;
    private static float aq;
    private static float ar;
    private static float as;
    private static float at;
    private static float au;
    private static float av;
    static final /* synthetic */ boolean V;

    static {
        V = !C0027ay.class.desiredAssertionStatus();
        a = new Vector3f();
        r = C0265jv.d("textures/misc/muzzleflash/scopeflare.png");
        f53a = Vec2.ZERO;
        b = Vec2.ZERO;
        c = Vec2.ZERO;
        af = 0.0f;
        ag = 0.0f;
        ah = 0.0f;
        aj = 0.0f;
        al = 0.0f;
        an = 0.0f;
        ap = 0.0f;
        as = 0.0f;
        av = 0.0f;
    }

    @SubscribeEvent
    public static void a(@NotNull RenderHandEvent renderHandEvent) {
        nD nDVarA;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        boolean z = renderHandEvent.getHand() == InteractionHand.MAIN_HAND;
        C0297l c0297lB = C0297l.b();
        if (!V && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        float fG = C0040bk.g();
        if (entity == null || !(minecraft.getEntityRenderDispatcher().getRenderer(entity) instanceof gN)) {
            return;
        }
        if (oR.a((Player) entity, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fVVar.a(minecraft))) {
            renderHandEvent.setCanceled(true);
            return;
        }
        float partialTick = renderHandEvent.getPartialTick();
        PoseStack poseStack = renderHandEvent.getPoseStack();
        renderHandEvent.getMultiBufferSource();
        renderHandEvent.getPackedLight();
        if (c0297lB.m602a().ay()) {
            renderHandEvent.setCanceled(true);
            return;
        }
        if (entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C0534tu)) {
            renderHandEvent.setCanceled(true);
            return;
        }
        Entity vehicle = entity.getVehicle();
        if ((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a(entity)) != null && nDVarA.fs) {
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
        if (itemStack.getItem() instanceof tI) {
            poseStack.translate(0.0f, 0.4f, 0.0f);
        }
        if (itemStack.getItem() instanceof C0543uc) {
            poseStack.translate(0.0f, 0.6f, 0.0f);
        }
        Item item = itemStack.getItem();
        if (item instanceof tO) {
            tO tOVar = (tO) item;
            if (tOVar instanceof C0558ur) {
                poseStack.translate(0.0f, 0.6f, 0.0f);
            }
            float fE = C0634xm.e(f53a.x, b.x, partialTick);
            float fE2 = C0634xm.e(f53a.y, b.y, partialTick);
            float f = 0.0f;
            if (hN.K.T()) {
                float fN = hN.f156d.N();
                fZ.a.a(fG, C0558ur.hR ? 80.0f : 20.0f, a);
                poseStack.mulPose(Axis.XP.rotationDegrees(a.x * fN));
                poseStack.mulPose(Axis.YP.rotationDegrees(a.y * fN));
                poseStack.mulPose(Axis.ZP.rotationDegrees(a.z * fN));
            }
            if (!C0558ur.hR) {
                float fE3 = C0634xm.e(aX.bQ, aX.bR, partialTick);
                fZ.c.a(fG, 1.0f, a);
                fE += a.x * fE3;
                fE2 += a.y * fE3;
                f = 0.0f + (a.z * fE3);
            }
            float fE4 = C0634xm.e(aX.br, aX.bs, partialTick);
            if (fE4 > 0.0f) {
                fZ.b.a(fG, 1.0f, a).mul(4.0f);
                fE += a.x * fE4;
                fE2 += a.y * fE4;
                f += a.z * fE4;
            }
            oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
            if (oFVarM591a != null) {
                List<pG> listAy = oFVarM591a.m767a().ay();
                if (!listAy.isEmpty()) {
                    float fO = c0297lB.m587a().O();
                    Iterator<pG> it = listAy.iterator();
                    while (it.hasNext()) {
                        Vector3f vector3fA = it.next().a(fG, fO);
                        fE += vector3fA.x;
                        fE2 += vector3fA.y;
                        f += vector3fA.z;
                    }
                }
            }
            float fE5 = C0634xm.e(ai, aj, partialTick);
            float fE6 = C0634xm.e(ak, al, partialTick);
            float fE7 = C0634xm.e(am, an, partialTick);
            float f2 = fE - (fE5 * 3.0f);
            float f3 = fE2 - (fE6 * 3.0f);
            float f4 = f - (fE7 * 3.0f);
            Vector3f vector3fMul = hE.a(partialTick).mul(C0558ur.hR ? 1.0f : 1.75f);
            float f5 = f2 + vector3fMul.x;
            float f6 = f3 + vector3fMul.y;
            float f7 = f4 + vector3fMul.z;
            float fE8 = C0634xm.e(((LocalPlayer) entity).walkDist, ((LocalPlayer) entity).walkDistO, partialTick) * 16.0f;
            float f8 = C0558ur.hR ? 0.1f : 1.0f;
            float fSin = Mth.sin(fE8 / 2.5f) * f8;
            float fSin2 = Mth.sin(fE8 / 3.0f) * f8;
            float fSin3 = Mth.sin(fE8 / 3.3f) * f8;
            float fSin4 = Mth.sin(fE8 / 5.0f);
            float fSin5 = Mth.sin(fE8 / 2.5f);
            float fE9 = C0634xm.e(C0025aw.U, C0025aw.V, partialTick);
            float fE10 = C0634xm.e(C0025aw.S, C0025aw.T, partialTick);
            float f9 = 0.0f + (2.5f * fSin * fE10);
            float f10 = 0.0f + (2.75f * fSin2 * fE10);
            float f11 = 0.0f + (0.7f * fSin3 * fE10);
            poseStack.translate((-0.04f) * fSin4 * fE9, 0.0f, 0.0f);
            float f12 = f9 + (5.0f * fSin5 * fE9);
            float f13 = f11 + (2.0f * fSin4 * fE9);
            float f14 = f5 + f12;
            float f15 = f6 + f13;
            float f16 = f7 + f10;
            Vec3 vec3Scale = tOVar.x().scale(C0634xm.e(ao, ap, partialTick));
            poseStack.mulPose(Axis.XP.rotationDegrees((float) vec3Scale.x));
            poseStack.mulPose(Axis.YP.rotationDegrees((float) vec3Scale.y));
            poseStack.mulPose(Axis.ZP.rotationDegrees((float) vec3Scale.z));
            float fE11 = C0634xm.e(C0025aw.W, C0025aw.X, partialTick);
            poseStack.translate(0.0f, (-0.5f) * fE11, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees((-10.0f) * fE11));
            poseStack.mulPose(Axis.YP.rotationDegrees(60.0f * fE11));
            poseStack.mulPose(Axis.ZP.rotationDegrees(5.0f * fE11));
            float fE12 = C0634xm.e(aU.bp, aU.bq, partialTick);
            Vector3f vector3fMul2 = new Vector3f(125.0f, 150.0f, -45.0f).mul(fE12).mul(1.0f, z ? 1.0f : -1.0f, z ? 1.0f : -1.0f);
            float f17 = f14 + vector3fMul2.x;
            float f18 = f15 + vector3fMul2.y;
            float f19 = f16 + vector3fMul2.z;
            poseStack.translate((-0.5f) * fE12, (-0.1f) * fE12, 0.5f * fE12);
            if (aU.bx > 0.0f && aU.by > 0.0f) {
                float fE13 = C0634xm.e(aU.bx, aU.by, partialTick);
                float fSin6 = Mth.sin(fG / 50.0f) * (1.0f - ((0.2f * Mth.sin(fG / 30.0f)) * Mth.sin(fG / 40.0f)));
                f17 += 45.0f * fE13;
                f18 += 110.0f * fE13;
                f19 += ((-25.0f) + (45.0f * fSin6)) * fE13;
                poseStack.translate((-0.2f) * fE13, 0.1f * fE13, 0.15f * fE13);
                poseStack.translate((-0.1f) * fSin6 * fE13, 0.0f, 0.1f * fSin6 * fE13);
            }
            float f20 = z ? aq : at;
            float f21 = z ? ar : au;
            float f22 = z ? as : av;
            float fLerp = Mth.lerp(0.2f, f20, f17);
            float fLerp2 = Mth.lerp(0.2f, f21, f18);
            float fLerp3 = Mth.lerp(0.2f, f22, f19);
            poseStack.translate(0.35f, -0.5f, -0.8f);
            poseStack.mulPose(Axis.XP.rotationDegrees(fLerp / 2.0f));
            poseStack.mulPose(Axis.YP.rotationDegrees(fLerp2 / 2.0f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(fLerp3 / 2.0f));
            poseStack.translate(-0.35f, -(-0.5f), -(-0.8f));
            if (z) {
                aq = fLerp;
                ar = fLerp2;
                as = fLerp3;
            } else {
                at = fLerp;
                au = fLerp2;
                av = fLerp3;
            }
        }
    }

    public static void a(@Nullable LocalPlayer localPlayer) {
        b = new Vec2(f53a.x, f53a.y);
        f53a = new Vec2(Mth.lerp(0.4f, f53a.x, 0.0f), Mth.lerp(0.4f, f53a.y, 0.0f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$d.class */
    public static final class d extends Record {
        private final double x;
        private final double y;
        private final double z;
        private final float aF;
        private final float aG;
        private final float aH;
        private final float aI;

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

        public double i() {
            return this.x;
        }

        public double j() {
            return this.y;
        }

        public double k() {
            return this.z;
        }

        public float c() {
            return this.aF;
        }

        public float d() {
            return this.aG;
        }

        public float e() {
            return this.aH;
        }

        public float f() {
            return this.aI;
        }

        public d(double d, double d2, double d3, float f, float f2, float f3) {
            this(d, d2, d3, f, f2, f3, 1.0f);
        }

        public d(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            this.x = d;
            this.y = d2;
            this.z = d3;
            this.aF = f;
            this.aG = f2;
            this.aH = f3;
            this.aI = f4;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$a.class */
    public static abstract class a {
        protected int aS;
        protected int aT;

        public abstract void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4);

        public a(int i, @NotNull Random random) {
            this.aT = i;
            this.aS = i;
        }

        public boolean l() {
            int i = this.aS;
            this.aS = i - 1;
            this.aT = i;
            return i <= 0;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$b.class */
    public static class b extends a {

        @Nonnull
        private final ResourceLocation s;

        public b(int i, @NotNull Random random) {
            super(i, random);
            this.s = C0265jv.d("textures/misc/muzzleflash/firepuff" + ThreadLocalRandom.current().nextInt(0, 4) + ".png");
        }

        @Override // com.boehmod.blockfront.C0027ay.a
        public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            float fE = C0634xm.e(this.aS, this.aT, f2) * f;
            float f5 = (20.0f / fE) * f4;
            float fSin = Mth.sin(f3 * 2.0f);
            poseStack.pushPose();
            poseStack.translate(0.0f, 0.0f, 1.4f + (4.0f / fE));
            C0040bk.b(poseStack, guiGraphics, this.s, 0.0f, 0.0f, f5, f5, 40.0f * fSin, 0.1f * fE);
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ay$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ay$c.class */
    public static class c extends a {
        private static final int aU = 8;
        private static final float aw = 0.12f;
        private static final float ax = 3.0f;
        private static final float ay = 3.0f;
        private static final float az = 0.5f;
        private static final float aA = 0.45f;
        private final ResourceLocation t;
        private final boolean W;
        private float aB;
        private float aC;
        private float aD;
        private float aE;

        public c(@NotNull Random random, int i) {
            super(i, random);
            this.W = Math.random() < 0.5d;
            this.aB = 0.5f;
            this.aC = 0.5f;
            this.aD = aA;
            this.aE = aA;
            this.t = C0265jv.d("textures/misc/muzzleflash/smokepuff" + random.nextInt(0, 8) + ".png");
            l();
        }

        @Override // com.boehmod.blockfront.C0027ay.a
        public boolean l() {
            this.aC = this.aB;
            this.aB = C0634xm.d(this.aB, 1.0f, aw);
            this.aE = this.aD;
            this.aD = C0634xm.d(this.aD, 0.0f, aw);
            return this.aD + this.aE <= 0.0f;
        }

        @Override // com.boehmod.blockfront.C0027ay.a
        public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4) {
            C0634xm.e(this.aS, this.aT, f2);
            float fE = C0634xm.e(this.aB, this.aC, f2);
            float fE2 = C0634xm.e(this.aD, this.aE, f2) * f;
            float f5 = 3.0f * fE * f4;
            poseStack.pushPose();
            C0040bk.b(poseStack, guiGraphics, this.t, 0.0f, 0.0f, f5, f5, 0.0f, fE2);
            poseStack.popPose();
        }
    }
}
