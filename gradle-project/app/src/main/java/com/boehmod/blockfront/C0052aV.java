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

/* JADX INFO: renamed from: com.boehmod.blockfront.aV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aV.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0052aV {

    /* JADX INFO: renamed from: b */
    private static final Vector3f f369b;

    /* JADX INFO: renamed from: aQ */
    private static final float f370aQ = -0.15f;

    /* JADX INFO: renamed from: aR */
    private static final float f371aR = 20.0f;

    /* JADX INFO: renamed from: aS */
    private static final float f372aS = 80.0f;

    /* JADX INFO: renamed from: aT */
    private static final float f373aT = 7.0f;

    /* JADX INFO: renamed from: aU */
    private static final float f374aU = 11.0f;

    /* JADX INFO: renamed from: aV */
    private static final float f375aV = 5.5f;

    /* JADX INFO: renamed from: aj */
    static final /* synthetic */ boolean f376aj;

    static {
        f376aj = !C0052aV.class.desiredAssertionStatus();
        f369b = new Vector3f();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m242a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || localPlayer.isSpectator()) {
            return;
        }
        float partialTick = (float) computeCameraAngles.getPartialTick();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f376aj && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0681mE c0681mEM2895a = c0623lM2852b.m2895a();
        if (c0681mEM2895a.m3074aJ()) {
            computeCameraAngles.setRoll(computeCameraAngles.getRoll() + c0681mEM2895a.m3072q(partialTick));
            return;
        }
        Entity cameraEntity = minecraft.getCameraEntity();
        if (cameraEntity instanceof C0777nv) {
            C0777nv c0777nv = (C0777nv) cameraEntity;
            if (c0777nv.m3656a() == EnumC0778nw.RAGDOLL) {
                Vector3d eulerAnglesYXZ = new Quaterniond().rotateX(3.141592653589793d).premul(c0777nv.f4323b).getEulerAnglesYXZ(new Vector3d());
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
        float fM466g = C0129bt.m466g();
        m244a(computeCameraAngles, vector3f, partialTick, fM466g);
        m245b(computeCameraAngles, vector3f, fM466g, partialTick);
        vector3f.add(C0432hU.m1991a(partialTick).mul(C1117uP.f6063il ? 0.5f : 1.0f));
        vector3f.add(C1270xJ.m7170f(C0036aF.f320an, C0036aF.f321ao, partialTick), C1270xJ.m7170f(C0036aF.f322ap, C0036aF.f323aq, partialTick), C1270xJ.m7170f(C0036aF.f324ar, C0036aF.f325as, partialTick));
        float f = C1117uP.f6063il ? f372aS : 20.0f;
        if (C0495ie.f3057K.m2230U()) {
            vector3f.add(C0400gp.f2590a.m1904a(fM466g, f, f369b).mul(C0495ie.f3058d.m2223N()));
        }
        vector3f.add(C0400gp.f2592c.m1904a(fM466g, f, f369b).mul(C1270xJ.m7170f(C0115bf.f782bW, C0115bf.f783bX, partialTick)));
        vector3f.add(C0400gp.f2591b.m1904a(fM466g, 1.0f, f369b).mul(C1270xJ.m7170f(C0115bf.f778bx, C0115bf.f779by, partialTick)));
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            List<InterfaceC0917qc> listM6083aA = abstractC0863pbM2874a.m4089a().m6083aA();
            if (!listM6083aA.isEmpty()) {
                float fM2289O = c0623lM2852b.m2869a().m2289O();
                Iterator<InterfaceC0917qc> it = listM6083aA.iterator();
                while (it.hasNext()) {
                    vector3f.add(it.next().mo5069a(fM466g, fM2289O));
                }
            }
        }
        float fM7170f = C1270xJ.m7170f(C0112bc.f746bD, C0112bc.f747bE, partialTick);
        float fSin = Mth.sin(fM466g / 50.0f);
        vector3f.add((8.0f + (1.5f * Mth.sin(fM466g / 25.0f))) * fM7170f, (-4.0f) * fSin * fM7170f, (-2.0f) * fSin * fM7170f);
        float f2 = 7.0f;
        if (localPlayer.isShiftKeyDown()) {
            f2 = 11.0f;
        } else if (localPlayer.isSprinting()) {
            f2 = 5.5f;
        }
        if (C0495ie.f3056J.m2230U()) {
            float fM7170f2 = C1270xJ.m7170f(C0034aD.f298Z, C0034aD.f299aa, partialTick);
            vector3f.add(Mth.sin(fM466g / (f2 / 2.0f)) * fM7170f2 * 0.2f, 0.0f, Mth.sin(fM466g / f2) * fM7170f2 * 0.2f);
            float fM7170f3 = C1270xJ.m7170f(C0034aD.f296X, C0034aD.f297Y, partialTick);
            vector3f.add(Mth.sin(fM466g / (f2 / 2.0f)) * fM7170f3, 0.0f, Mth.sin(fM466g / f2) * fM7170f3);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0750nU) {
            AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
            if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON) {
                FloatFloatPair floatFloatPairM3498b = abstractC0750nU.m3437a().m3498b(partialTick);
                vector3f.add(new Vec3(8.0f * floatFloatPairM3498b.firstFloat(), 0.0d, (-8.0f) * floatFloatPairM3498b.secondFloat()).yRot((float) Math.toRadians(localPlayer.getYHeadRot() - abstractC0750nU.getYRot())).toVector3f());
            }
        }
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() + vector3f.x);
        computeCameraAngles.setYaw(computeCameraAngles.getYaw() + vector3f.y);
        computeCameraAngles.setRoll(computeCameraAngles.getRoll() + vector3f.z);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m243a(@NotNull ComputeFovModifierEvent computeFovModifierEvent) {
        C0755nZ c0755nZM3472a;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        float fM7188a = C1270xJ.m7188a(minecraft);
        float fovModifier = computeFovModifierEvent.getFovModifier();
        if (entity != null) {
            ItemStack mainHandItem = entity.getMainHandItem();
            if (!mainHandItem.isEmpty()) {
                Item item = mainHandItem.getItem();
                if (item instanceof C1117uP) {
                    C1188vh c1188vhM6296a = ((C1117uP) item).m6296a(mainHandItem);
                    float f = c1188vhM6296a.f6460or;
                    fovModifier = (fovModifier - (c1188vhM6296a.f6459oq * C1270xJ.m7170f(C0115bf.f780bU, C0115bf.f781bV, fM7188a))) - (0.1f * C1270xJ.m7170f(C1117uP.f6061nX, C1117uP.f6062nY, fM7188a));
                }
            }
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1067tS)) {
                boolean z = entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C1067tS);
                if (minecraft.options.getCameraType().isFirstPerson() && z) {
                    fovModifier -= 0.8f;
                }
            }
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0750nU) {
                AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
                C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
                fovModifier += c0809oaM3436b.f4384kA * abstractC0750nU.m3442aE() * (abstractC0750nU.m3458bc() ? c0809oaM3436b.f4380kw : c0809oaM3436b.f4381kx);
                if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON && (c0755nZM3472a = abstractC0750nU.m3472a(entity)) != null && AbstractC0752nW.f4152fE) {
                    fovModifier -= c0755nZM3472a.m3515aI();
                }
            }
        }
        computeFovModifierEvent.setNewFovModifier(fovModifier + (f370aQ * C1270xJ.m7170f(C0112bc.f744bB, C0112bc.f745bC, fM7188a)));
    }

    /* JADX INFO: renamed from: a */
    public static void m244a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() - C1270xJ.m7170f(C0120bk.f806cn, C0120bk.f807co, f));
    }

    /* JADX INFO: renamed from: b */
    public static void m245b(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        float fM7170f = C1270xJ.m7170f(C0112bc.f735bt, C0112bc.f736bu, f2);
        Vector3f vector3f2 = new Vector3f(0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f), 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f), 0.3f * Mth.sin(f / 3.0f) * Mth.sin(f / 2.0f));
        vector3f.add(vector3f2.x * fM7170f, vector3f2.y * fM7170f, vector3f2.z * fM7170f);
    }
}
