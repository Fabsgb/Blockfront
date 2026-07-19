package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aX.class */
public final class aX extends aO {
    public static final float bL = 1.0f;
    private static final float bM = 0.0f;
    private static final double F = 0.6d;
    private static final float bN = 3.0f;
    public static final int bk = 10;
    public static float br;
    public static float bO;
    public static float bP;
    public static float bQ;
    public static float bR;
    private static float bS;

    @NotNull
    private static final ObjectList<hV> f = new ObjectArrayList();
    public static double G = 0.0d;
    public static boolean ah = false;
    public static float bs = 0.0f;

    @Nullable
    private static ItemStack a = null;
    private static int bl = -1;
    private static float bT = 0.0f;
    private static boolean ai = false;

    public static void a(@NotNull hV hVVar) {
        f.add(hVVar);
    }

    private static void a(@NotNull ItemStack itemStack, boolean z) {
        if (C0558ur.rU > 0) {
            C0558ur.rU--;
        }
        float f2 = (z && C0558ur.m1202f(itemStack)) ? 1.0f : 0.0f;
        bs = br;
        br = Mth.lerp(0.15f, br, f2);
    }

    private static void a(@NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        if (C0558ur.rW > 0) {
            C0558ur.rW--;
        }
        int i = C0558ur.rV;
        C0558ur.rV = i + 1;
        if (i >= 5) {
            C0558ur.rV = 0;
            if (bVar.aG() != (C0558ur.hR || C0558ur.rW > 0)) {
                C0582vo.c(new uZ(C0558ur.hR || C0558ur.rW > 0));
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f2) throws MatchException {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        f.removeIf(hVVar -> {
            return hVVar.a(soundManager);
        });
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        C0558ur c0558ur = item instanceof C0558ur ? (C0558ur) item : null;
        boolean z2 = c0558ur != null;
        boolean zA = oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar);
        if (zA || c0558ur == null) {
            C0558ur.hS = false;
            C0558ur.hT = false;
            C0558ur.hU = false;
            C0558ur.hV = false;
            C0558ur.hW = false;
        }
        if (ai && !zA && c0558ur != null) {
            c0558ur.dr();
        }
        ai = zA;
        if (c0558ur != null) {
            c0558ur.a(minecraft, c0297l, fVVar, localPlayer, clientLevel, mainHandItem, fTVar);
        }
        if (!z2) {
            C0027ay.af = Mth.lerp(0.5f, C0027ay.af, 0.0f);
            C0027ay.ag = Mth.lerp(0.5f, C0027ay.ag, 0.0f);
            C0027ay.ah = Mth.lerp(0.5f, C0027ay.ah, 0.0f);
        }
        C0164ga.aK();
        C0193hc.aO();
        a(fTVar);
        if (minecraft.screen != null) {
            C0558ur.hR = false;
        }
        ItemStack itemStack = a;
        int i = bl;
        a = mainHandItem;
        bl = localPlayer.getInventory().selected;
        boolean z3 = (i == -1 || i == bl) ? false : true;
        boolean z4 = (itemStack == null || itemStack.getItem() == a.getItem()) ? false : true;
        if (itemStack != null && (z3 || z4)) {
            Item item2 = itemStack.getItem();
            if (item2 instanceof C0558ur) {
                ((C0558ur) item2).dr();
            }
            Item item3 = a.getItem();
            if (item3 instanceof C0558ur) {
                ((C0558ur) item3).dr();
            }
            a(minecraft, a, a.getItem(), random);
            C0558ur.hR = false;
            return;
        }
        if (C0558ur.hR && c0558ur != null) {
            if (!ah) {
                ah = true;
                G = ((Double) minecraft.options.sensitivity().get()).doubleValue();
                minecraft.options.sensitivity().set(Double.valueOf(((Double) minecraft.options.sensitivity().get()).doubleValue() * ((double) (c0558ur.m1208a(mainHandItem).go != null ? hN.f155c.N() : hN.f154b.N()))));
            }
        } else if (ah) {
            ah = false;
            minecraft.options.sensitivity().set(Double.valueOf(G));
            minecraft.options.save();
        }
        bP = bO;
        if (c0558ur != null) {
            uH uHVarM1208a = c0558ur.m1208a(mainHandItem);
            bO = C0634xm.d(bO, C0558ur.hR ? 1.0f : 0.0f, uHVarM1208a.nt);
            double d = 1.0d - (F * ((double) (bO / uHVarM1208a.ns)));
            if (uHVarM1208a.iy && localPlayer.onGround()) {
                localPlayer.setDeltaMovement(localPlayer.getDeltaMovement().multiply(d, 1.0d, d));
            }
        } else {
            bO = 0.0f;
        }
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float F2 = C0634xm.F(bS - xRot);
        float F3 = C0634xm.F(bT - yRot);
        bS = xRot;
        bT = yRot;
        bR = bQ;
        if (!oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar)) {
            bQ += Mth.abs(F2 * 0.005f) + Mth.abs(F3 * 0.005f);
        }
        bQ = Mth.lerp(0.2f, bQ, 0.0f);
        C0558ur.mZ = C0558ur.mY;
        C0558ur.mY = Mth.lerp(0.4f, C0558ur.mY, (c0558ur == null || !localPlayer.isCrouching() || C0558ur.hR) ? 0.0f : 1.0f);
        if (fTVar.dk()) {
            minecraft.hitResult = localPlayer.pick(0.0d, 0.0f, false);
        }
        if (item instanceof InterfaceC0539tz) {
            a(localPlayer, mainHandItem, (InterfaceC0539tz) item);
        }
        if (localPlayer.isSprinting()) {
            C0558ur.hR = false;
        }
        a(mainHandItem, c0558ur != null);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack, @NotNull Item item, @NotNull Random random) {
        SoundEvent soundEventZ = null;
        hG hGVar = null;
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0558ur.class, C0543uc.class, tI.class, C0550uj.class, C0541ua.class, C0534tu.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                C0558ur c0558ur = (C0558ur) item;
                c0558ur.j(itemStack);
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderW = c0558ur.m1221a(itemStack).W();
                if (deferredHolderW != null) {
                    soundEventZ = (SoundEvent) deferredHolderW.get();
                }
                hGVar = hH.w;
                break;
            case 1:
                ((C0543uc) item).q("equip");
                soundEventZ = (SoundEvent) C0624xc.tB.get();
                hGVar = hH.B;
                break;
            case 2:
                soundEventZ = (SoundEvent) C0624xc.Cv.get();
                hGVar = hH.w;
                break;
            case 3:
                soundEventZ = ((C0550uj) item).z();
                hGVar = hH.x;
                break;
            case 4:
                soundEventZ = (SoundEvent) C0624xc.tv.get();
                hGVar = hH.z;
                break;
            case 5:
                soundEventZ = (SoundEvent) C0624xc.tx.get();
                hGVar = hH.C;
                break;
        }
        if (soundEventZ != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventZ, 0.9f + (0.2f * random.nextFloat()), 1.0f));
        }
        if (hGVar != null) {
            hE.a(hGVar);
        }
        C0025aw.W = 1.0f;
        C0025aw.X = 1.0f;
        C0558ur.rY = 10;
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack, @NotNull InterfaceC0539tz interfaceC0539tz) {
        float fMo1220a = interfaceC0539tz.mo1220a(itemStack);
        if (fMo1220a > 0.0f && interfaceC0539tz.b(localPlayer, itemStack)) {
            Vec3 deltaMovement = localPlayer.getDeltaMovement();
            if (localPlayer.onGround()) {
                float f2 = 1.0f - fMo1220a;
                localPlayer.setDeltaMovement(deltaMovement.multiply(f2, 1.0d, f2));
            } else {
                float f3 = 1.0f - (fMo1220a / 3.0f);
                localPlayer.setDeltaMovement(deltaMovement.multiply(f3, 1.0d, f3));
            }
        }
    }
}
