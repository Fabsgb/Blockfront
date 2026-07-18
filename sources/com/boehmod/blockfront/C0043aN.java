package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.aN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aN.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0043aN {

    /* JADX INFO: renamed from: b */
    private static final Vector3f f269b;

    /* JADX INFO: renamed from: aL */
    private static final float f270aL = -0.15f;

    /* JADX INFO: renamed from: aM */
    private static final float f271aM = 20.0f;

    /* JADX INFO: renamed from: aN */
    private static final float f272aN = 80.0f;

    /* JADX INFO: renamed from: aO */
    private static final float f273aO = 7.0f;

    /* JADX INFO: renamed from: aP */
    private static final float f274aP = 11.0f;

    /* JADX INFO: renamed from: aQ */
    private static final float f275aQ = 5.5f;

    /* JADX INFO: renamed from: ae */
    static final /* synthetic */ boolean f276ae;

    static {
        f276ae = !C0043aN.class.desiredAssertionStatus();
        f269b = new Vector3f();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m200a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || localPlayer.isSpectator()) {
            return;
        }
        float partialTick = (float) computeCameraAngles.getPartialTick();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f276ae && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0710mi c0710miM2709a = c0622lM2667b.m2709a();
        if (c0710miM2709a.m3241ay()) {
            computeCameraAngles.setRoll(computeCameraAngles.getRoll() + c0710miM2709a.m3240o(partialTick));
            return;
        }
        Entity cameraEntity = minecraft.getCameraEntity();
        if (cameraEntity instanceof C0701mZ) {
            C0701mZ c0701mZ = (C0701mZ) cameraEntity;
            if (c0701mZ.m3149a() == EnumC0755na.RAGDOLL) {
                Vector3d eulerAnglesYXZ = new Quaterniond().rotateX(3.141592653589793d).premul(c0701mZ.f3760b).getEulerAnglesYXZ(new Vector3d());
                float degrees = (float) Math.toDegrees(eulerAnglesYXZ.y);
                float degrees2 = (float) Math.toDegrees(eulerAnglesYXZ.x);
                float degrees3 = (float) Math.toDegrees(eulerAnglesYXZ.z);
                computeCameraAngles.setYaw(-degrees);
                computeCameraAngles.setPitch(degrees2);
                computeCameraAngles.setRoll(computeCameraAngles.getRoll() + degrees3);
                return;
            }
        }
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        float fM366g = C0119bk.m366g();
        m202a(computeCameraAngles, vector3f, partialTick, fM366g);
        m203b(computeCameraAngles, vector3f, fM366g, partialTick);
        vector3f.add(C0415hE.m1964a(partialTick).mul(C1144ur.f5994hR ? 0.5f : 1.0f));
        vector3f.add(C1290xm.m7843e(C0080ay.f498ai, C0080ay.f499aj, partialTick), C1290xm.m7843e(C0080ay.f500ak, C0080ay.f501al, partialTick), C1290xm.m7843e(C0080ay.f502am, C0080ay.f503an, partialTick));
        float f = C1144ur.f5994hR ? f272aN : 20.0f;
        if (C0424hN.f2756K.m1996T()) {
            vector3f.add(C0330fZ.f2395a.m1694a(fM366g, f, f269b).mul(C0424hN.f2757d.m1992N()));
        }
        vector3f.add(C0330fZ.f2397c.m1694a(fM366g, f, f269b).mul(C1290xm.m7843e(C0053aX.f368bQ, C0053aX.f369bR, partialTick)));
        vector3f.add(C0330fZ.f2396b.m1694a(fM366g, 1.0f, f269b).mul(C1290xm.m7843e(C0053aX.f364br, C0053aX.f365bs, partialTick)));
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            List<InterfaceC0841pG> listM5595ay = abstractC0787oFM2688a.m3653a().m5595ay();
            if (!listM5595ay.isEmpty()) {
                float fM2234O = c0622lM2667b.m2683a().m2234O();
                Iterator<InterfaceC0841pG> it = listM5595ay.iterator();
                while (it.hasNext()) {
                    vector3f.add(it.next().mo4267a(fM366g, fM2234O));
                }
            }
        }
        float fM7843e = C1290xm.m7843e(C0050aU.f332bx, C0050aU.f333by, partialTick);
        float fSin = Mth.sin(fM366g / 50.0f);
        vector3f.add((8.0f + (1.5f * Mth.sin(fM366g / 25.0f))) * fM7843e, (-4.0f) * fSin * fM7843e, (-2.0f) * fSin * fM7843e);
        float f2 = 7.0f;
        if (localPlayer.isShiftKeyDown()) {
            f2 = 11.0f;
        } else if (localPlayer.isSprinting()) {
            f2 = 5.5f;
        }
        if (C0424hN.f2755J.m1996T()) {
            float fM7843e2 = C1290xm.m7843e(C0078aw.f476U, C0078aw.f477V, partialTick);
            vector3f.add(Mth.sin(fM366g / (f2 / 2.0f)) * fM7843e2 * 0.2f, 0.0f, Mth.sin(fM366g / f2) * fM7843e2 * 0.2f);
            float fM7843e3 = C1290xm.m7843e(C0078aw.f474S, C0078aw.f475T, partialTick);
            vector3f.add(Mth.sin(fM366g / (f2 / 2.0f)) * fM7843e3, 0.0f, Mth.sin(fM366g / f2) * fM7843e3);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0779ny) {
            AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
            if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON) {
                FloatFloatPair floatFloatPairM3311b = abstractC0779ny.m3500a().m3311b(partialTick);
                vector3f.add(new Vec3(8.0f * floatFloatPairM3311b.firstFloat(), 0.0d, (-8.0f) * floatFloatPairM3311b.secondFloat()).yRot((float) Math.toRadians(localPlayer.getYHeadRot() - abstractC0779ny.getYRot())).toVector3f());
            }
        }
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() + vector3f.x);
        computeCameraAngles.setYaw(computeCameraAngles.getYaw() + vector3f.y);
        computeCameraAngles.setRoll(computeCameraAngles.getRoll() + vector3f.z);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m201a(@NotNull ComputeFovModifierEvent computeFovModifierEvent) {
        C0732nD c0732nDM3535a;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        float fM7861a = C1290xm.m7861a(minecraft);
        float fovModifier = computeFovModifierEvent.getFovModifier();
        if (entity != null) {
            ItemStack mainHandItem = entity.getMainHandItem();
            if (!mainHandItem.isEmpty()) {
                Item item = mainHandItem.getItem();
                if (item instanceof C1144ur) {
                    C1108uH c1108uHM6329a = ((C1144ur) item).m6329a(mainHandItem);
                    float f = c1108uHM6329a.f5821nt;
                    fovModifier = (fovModifier - (c1108uHM6329a.f5820ns * C1290xm.m7843e(C0053aX.f366bO, C0053aX.f367bP, fM7861a))) - (0.1f * C1290xm.m7843e(C1144ur.f5992mY, C1144ur.f5993mZ, fM7861a));
                }
            }
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1094tu)) {
                boolean z = entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C1094tu);
                if (minecraft.options.getCameraType().isFirstPerson() && z) {
                    fovModifier -= 0.8f;
                }
            }
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0779ny) {
                AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
                C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
                fovModifier += c0733nEM3499b.f3956jH * abstractC0779ny.m3505ay() * (abstractC0779ny.m3521aS() ? c0733nEM3499b.f3952jD : c0733nEM3499b.f3953jE);
                if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON && (c0732nDM3535a = abstractC0779ny.m3535a(entity)) != null && AbstractC0729nA.f3904fk) {
                    fovModifier -= c0732nDM3535a.m3328aC();
                }
            }
        }
        computeFovModifierEvent.setNewFovModifier(fovModifier + (f270aL * C1290xm.m7843e(C0050aU.f330bv, C0050aU.f331bw, fM7861a)));
    }

    /* JADX INFO: renamed from: a */
    public static void m202a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() - C1290xm.m7843e(C0111bc.f675ch, C0111bc.f676ci, f));
    }

    /* JADX INFO: renamed from: b */
    public static void m203b(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        float fM7843e = C1290xm.m7843e(C0050aU.f321bn, C0050aU.f322bo, f2);
        Vector3f vector3f2 = new Vector3f(0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f), 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f), 0.3f * Mth.sin(f / 3.0f) * Mth.sin(f / 2.0f));
        vector3f.add(vector3f2.x * fM7843e, vector3f2.y * fM7843e, vector3f2.z * fM7843e);
    }
}
