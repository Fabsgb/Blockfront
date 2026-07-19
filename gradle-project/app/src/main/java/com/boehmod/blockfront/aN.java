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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aN.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aN {
    private static final Vector3f b;
    private static final float aL = -0.15f;
    private static final float aM = 20.0f;
    private static final float aN = 80.0f;
    private static final float aO = 7.0f;
    private static final float aP = 11.0f;
    private static final float aQ = 5.5f;
    static final /* synthetic */ boolean ae;

    static {
        ae = !aN.class.desiredAssertionStatus();
        b = new Vector3f();
    }

    @SubscribeEvent
    public static void a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || localPlayer.isSpectator()) {
            return;
        }
        float partialTick = (float) computeCameraAngles.getPartialTick();
        C0297l c0297lB = C0297l.b();
        if (!ae && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0333mi c0333miM602a = c0297lB.m602a();
        if (c0333miM602a.ay()) {
            computeCameraAngles.setRoll(computeCameraAngles.getRoll() + c0333miM602a.o(partialTick));
            return;
        }
        Entity cameraEntity = minecraft.getCameraEntity();
        if (cameraEntity instanceof mZ) {
            mZ mZVar = (mZ) cameraEntity;
            if (mZVar.a() == EnumC0352na.RAGDOLL) {
                Vector3d eulerAnglesYXZ = new Quaterniond().rotateX(3.141592653589793d).premul(mZVar.b).getEulerAnglesYXZ(new Vector3d());
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
        float fG = C0040bk.g();
        a(computeCameraAngles, vector3f, partialTick, fG);
        b(computeCameraAngles, vector3f, fG, partialTick);
        vector3f.add(hE.a(partialTick).mul(C0558ur.hR ? 0.5f : 1.0f));
        vector3f.add(C0634xm.e(C0027ay.ai, C0027ay.aj, partialTick), C0634xm.e(C0027ay.ak, C0027ay.al, partialTick), C0634xm.e(C0027ay.am, C0027ay.an, partialTick));
        float f = C0558ur.hR ? aN : 20.0f;
        if (hN.K.T()) {
            vector3f.add(fZ.a.a(fG, f, b).mul(hN.f156d.N()));
        }
        vector3f.add(fZ.c.a(fG, f, b).mul(C0634xm.e(aX.bQ, aX.bR, partialTick)));
        vector3f.add(fZ.b.a(fG, 1.0f, b).mul(C0634xm.e(aX.br, aX.bs, partialTick)));
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            List<pG> listAy = oFVarM591a.m767a().ay();
            if (!listAy.isEmpty()) {
                float fO = c0297lB.m587a().O();
                Iterator<pG> it = listAy.iterator();
                while (it.hasNext()) {
                    vector3f.add(it.next().a(fG, fO));
                }
            }
        }
        float fE = C0634xm.e(aU.bx, aU.by, partialTick);
        float fSin = Mth.sin(fG / 50.0f);
        vector3f.add((8.0f + (1.5f * Mth.sin(fG / 25.0f))) * fE, (-4.0f) * fSin * fE, (-2.0f) * fSin * fE);
        float f2 = 7.0f;
        if (localPlayer.isShiftKeyDown()) {
            f2 = 11.0f;
        } else if (localPlayer.isSprinting()) {
            f2 = 5.5f;
        }
        if (hN.J.T()) {
            float fE2 = C0634xm.e(C0025aw.U, C0025aw.V, partialTick);
            vector3f.add(Mth.sin(fG / (f2 / 2.0f)) * fE2 * 0.2f, 0.0f, Mth.sin(fG / f2) * fE2 * 0.2f);
            float fE3 = C0634xm.e(C0025aw.S, C0025aw.T, partialTick);
            vector3f.add(Mth.sin(fG / (f2 / 2.0f)) * fE3, 0.0f, Mth.sin(fG / f2) * fE3);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0376ny) {
            AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
            if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON) {
                FloatFloatPair floatFloatPairB = abstractC0376ny.m742a().b(partialTick);
                vector3f.add(new Vec3(8.0f * floatFloatPairB.firstFloat(), 0.0d, (-8.0f) * floatFloatPairB.secondFloat()).yRot((float) Math.toRadians(localPlayer.getYHeadRot() - abstractC0376ny.getYRot())).toVector3f());
            }
        }
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() + vector3f.x);
        computeCameraAngles.setYaw(computeCameraAngles.getYaw() + vector3f.y);
        computeCameraAngles.setRoll(computeCameraAngles.getRoll() + vector3f.z);
    }

    @SubscribeEvent
    public static void a(@NotNull ComputeFovModifierEvent computeFovModifierEvent) {
        nD nDVarA;
        Minecraft minecraft = Minecraft.getInstance();
        Entity entity = minecraft.player;
        float fA = C0634xm.a(minecraft);
        float fovModifier = computeFovModifierEvent.getFovModifier();
        if (entity != null) {
            ItemStack mainHandItem = entity.getMainHandItem();
            if (!mainHandItem.isEmpty()) {
                Item item = mainHandItem.getItem();
                if (item instanceof C0558ur) {
                    uH uHVarM1208a = ((C0558ur) item).m1208a(mainHandItem);
                    float f = uHVarM1208a.nt;
                    fovModifier = (fovModifier - (uHVarM1208a.ns * C0634xm.e(aX.bO, aX.bP, fA))) - (0.1f * C0634xm.e(C0558ur.mY, C0558ur.mZ, fA));
                }
            }
            if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C0534tu)) {
                boolean z = entity.isUsingItem() && (entity.getUseItem().getItem() instanceof C0534tu);
                if (minecraft.options.getCameraType().isFirstPerson() && z) {
                    fovModifier -= 0.8f;
                }
            }
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0376ny) {
                AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
                nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
                fovModifier += nEVarM741b.jH * abstractC0376ny.ay() * (abstractC0376ny.aS() ? nEVarM741b.jD : nEVarM741b.jE);
                if (minecraft.options.getCameraType() == CameraType.FIRST_PERSON && (nDVarA = abstractC0376ny.a(entity)) != null && nA.fk) {
                    fovModifier -= nDVarA.aC();
                }
            }
        }
        computeFovModifierEvent.setNewFovModifier(fovModifier + (aL * C0634xm.e(aU.bv, aU.bw, fA)));
    }

    public static void a(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        computeCameraAngles.setPitch(computeCameraAngles.getPitch() - C0634xm.e(C0032bc.ch, C0032bc.ci, f));
    }

    public static void b(@NotNull ViewportEvent.ComputeCameraAngles computeCameraAngles, Vector3f vector3f, float f, float f2) {
        float fE = C0634xm.e(aU.bn, aU.bo, f2);
        Vector3f vector3f2 = new Vector3f(0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f), 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f), 0.3f * Mth.sin(f / 3.0f) * Mth.sin(f / 2.0f));
        vector3f.add(vector3f2.x * fE, vector3f2.y * fE, vector3f2.z * fE);
    }
}
