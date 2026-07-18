package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.aX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aX.class */
public final class C0053aX extends AbstractC0044aO {

    /* JADX INFO: renamed from: bL */
    public static final float f357bL = 1.0f;

    /* JADX INFO: renamed from: bM */
    private static final float f358bM = 0.0f;

    /* JADX INFO: renamed from: F */
    private static final double f359F = 0.6d;

    /* JADX INFO: renamed from: bN */
    private static final float f360bN = 3.0f;

    /* JADX INFO: renamed from: bk */
    public static final int f361bk = 10;

    /* JADX INFO: renamed from: br */
    public static float f364br;

    /* JADX INFO: renamed from: bO */
    public static float f366bO;

    /* JADX INFO: renamed from: bP */
    public static float f367bP;

    /* JADX INFO: renamed from: bQ */
    public static float f368bQ;

    /* JADX INFO: renamed from: bR */
    public static float f369bR;

    /* JADX INFO: renamed from: bS */
    private static float f372bS;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final ObjectList<C0432hV> f356f = new ObjectArrayList();

    /* JADX INFO: renamed from: G */
    public static double f362G = 0.0d;

    /* JADX INFO: renamed from: ah */
    public static boolean f363ah = false;

    /* JADX INFO: renamed from: bs */
    public static float f365bs = 0.0f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ItemStack f370a = null;

    /* JADX INFO: renamed from: bl */
    private static int f371bl = -1;

    /* JADX INFO: renamed from: bT */
    private static float f373bT = 0.0f;

    /* JADX INFO: renamed from: ai */
    private static boolean f374ai = false;

    /* JADX INFO: renamed from: a */
    public static void m219a(@NotNull C0432hV c0432hV) {
        f356f.add(c0432hV);
    }

    /* JADX INFO: renamed from: a */
    private static void m220a(@NotNull ItemStack itemStack, boolean z) {
        if (C1144ur.f5989rU > 0) {
            C1144ur.f5989rU--;
        }
        float f = (z && C1144ur.m6311f(itemStack)) ? 1.0f : 0.0f;
        f365bs = f364br;
        f364br = Mth.lerp(0.15f, f364br, f);
    }

    /* JADX INFO: renamed from: a */
    private static void m221a(@NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        if (C1144ur.f5991rW > 0) {
            C1144ur.f5991rW--;
        }
        int i = C1144ur.f5990rV;
        C1144ur.f5990rV = i + 1;
        if (i >= 5) {
            C1144ur.f5990rV = 0;
            if (abstractC0182b.m1111aG() != (C1144ur.f5994hR || C1144ur.f5991rW > 0)) {
                C1194vo.m6653c(new C1126uZ(C1144ur.f5994hR || C1144ur.f5991rW > 0));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) throws MatchException {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        f356f.removeIf(c0432hV -> {
            return c0432hV.m2029a(soundManager);
        });
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        C1144ur c1144ur = item instanceof C1144ur ? (C1144ur) item : null;
        boolean z2 = c1144ur != null;
        boolean zM4052a = C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT);
        if (zM4052a || c1144ur == null) {
            C1144ur.f6003hS = false;
            C1144ur.f6004hT = false;
            C1144ur.f6005hU = false;
            C1144ur.f6006hV = false;
            C1144ur.f6007hW = false;
        }
        if (f374ai && !zM4052a && c1144ur != null) {
            c1144ur.m6360dr();
        }
        f374ai = zM4052a;
        if (c1144ur != null) {
            c1144ur.m6359a(minecraft, c0622l, c0326fV, localPlayer, clientLevel, mainHandItem, c0324fT);
        }
        if (!z2) {
            C0080ay.f495af = Mth.lerp(0.5f, C0080ay.f495af, 0.0f);
            C0080ay.f496ag = Mth.lerp(0.5f, C0080ay.f496ag, 0.0f);
            C0080ay.f497ah = Mth.lerp(0.5f, C0080ay.f497ah, 0.0f);
        }
        C0384ga.m1843aK();
        C0439hc.m2052aO();
        m221a(c0324fT);
        if (minecraft.screen != null) {
            C1144ur.f5994hR = false;
        }
        ItemStack itemStack = f370a;
        int i = f371bl;
        f370a = mainHandItem;
        f371bl = localPlayer.getInventory().selected;
        boolean z3 = (i == -1 || i == f371bl) ? false : true;
        boolean z4 = (itemStack == null || itemStack.getItem() == f370a.getItem()) ? false : true;
        if (itemStack != null && (z3 || z4)) {
            Item item2 = itemStack.getItem();
            if (item2 instanceof C1144ur) {
                ((C1144ur) item2).m6360dr();
            }
            Item item3 = f370a.getItem();
            if (item3 instanceof C1144ur) {
                ((C1144ur) item3).m6360dr();
            }
            m222a(minecraft, f370a, f370a.getItem(), random);
            C1144ur.f5994hR = false;
            return;
        }
        if (C1144ur.f5994hR && c1144ur != null) {
            if (!f363ah) {
                f363ah = true;
                f362G = ((Double) minecraft.options.sensitivity().get()).doubleValue();
                minecraft.options.sensitivity().set(Double.valueOf(((Double) minecraft.options.sensitivity().get()).doubleValue() * ((double) (c1144ur.m6329a(mainHandItem).f5823go != null ? C0424hN.f2726c.m1992N() : C0424hN.f2725b.m1992N()))));
            }
        } else if (f363ah) {
            f363ah = false;
            minecraft.options.sensitivity().set(Double.valueOf(f362G));
            minecraft.options.save();
        }
        f367bP = f366bO;
        if (c1144ur != null) {
            C1108uH c1108uHM6329a = c1144ur.m6329a(mainHandItem);
            f366bO = C1290xm.m7835d(f366bO, C1144ur.f5994hR ? 1.0f : 0.0f, c1108uHM6329a.f5821nt);
            double d = 1.0d - (f359F * ((double) (f366bO / c1108uHM6329a.f5820ns)));
            if (c1108uHM6329a.f5819iy && localPlayer.onGround()) {
                localPlayer.setDeltaMovement(localPlayer.getDeltaMovement().multiply(d, 1.0d, d));
            }
        } else {
            f366bO = 0.0f;
        }
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float fM7858F = C1290xm.m7858F(f372bS - xRot);
        float fM7858F2 = C1290xm.m7858F(f373bT - yRot);
        f372bS = xRot;
        f373bT = yRot;
        f369bR = f368bQ;
        if (!C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT)) {
            f368bQ += Mth.abs(fM7858F * 0.005f) + Mth.abs(fM7858F2 * 0.005f);
        }
        f368bQ = Mth.lerp(0.2f, f368bQ, 0.0f);
        C1144ur.f5993mZ = C1144ur.f5992mY;
        C1144ur.f5992mY = Mth.lerp(0.4f, C1144ur.f5992mY, (c1144ur == null || !localPlayer.isCrouching() || C1144ur.f5994hR) ? 0.0f : 1.0f);
        if (c0324fT.m1087dk()) {
            minecraft.hitResult = localPlayer.pick(0.0d, 0.0f, false);
        }
        if (item instanceof InterfaceC1099tz) {
            m223a(localPlayer, mainHandItem, (InterfaceC1099tz) item);
        }
        if (localPlayer.isSprinting()) {
            C1144ur.f5994hR = false;
        }
        m220a(mainHandItem, c1144ur != null);
    }

    /* JADX INFO: renamed from: a */
    public void m222a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack, @NotNull Item item, @NotNull Random random) {
        SoundEvent soundEventMo6264z = null;
        C0417hG c0417hG = null;
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1144ur.class, C1129uc.class, C1056tI.class, C1136uj.class, C1127ua.class, C1094tu.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                C1144ur c1144ur = (C1144ur) item;
                c1144ur.m6410j(itemStack);
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6211W = c1144ur.m6408a(itemStack).m6211W();
                if (deferredHolderM6211W != null) {
                    soundEventMo6264z = (SoundEvent) deferredHolderM6211W.get();
                }
                c0417hG = C0418hH.f2680w;
                break;
            case 1:
                ((C1129uc) item).m5961q("equip");
                soundEventMo6264z = (SoundEvent) C1280xc.f7778tB.get();
                c0417hG = C0418hH.f2685B;
                break;
            case 2:
                soundEventMo6264z = (SoundEvent) C1280xc.f8240Cv.get();
                c0417hG = C0418hH.f2680w;
                break;
            case 3:
                soundEventMo6264z = ((C1136uj) item).mo6264z();
                c0417hG = C0418hH.f2681x;
                break;
            case 4:
                soundEventMo6264z = (SoundEvent) C1280xc.f7772tv.get();
                c0417hG = C0418hH.f2683z;
                break;
            case 5:
                soundEventMo6264z = (SoundEvent) C1280xc.f7774tx.get();
                c0417hG = C0418hH.f2686C;
                break;
        }
        if (soundEventMo6264z != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventMo6264z, 0.9f + (0.2f * random.nextFloat()), 1.0f));
        }
        if (c0417hG != null) {
            C0415hE.m1960a(c0417hG);
        }
        C0078aw.f478W = 1.0f;
        C0078aw.f479X = 1.0f;
        C1144ur.f6002rY = 10;
    }

    /* JADX INFO: renamed from: a */
    private void m223a(@NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack, @NotNull InterfaceC1099tz interfaceC1099tz) {
        float fMo6055a = interfaceC1099tz.mo6055a(itemStack);
        if (fMo6055a > 0.0f && interfaceC1099tz.mo6054b(localPlayer, itemStack)) {
            Vec3 deltaMovement = localPlayer.getDeltaMovement();
            if (localPlayer.onGround()) {
                float f = 1.0f - fMo6055a;
                localPlayer.setDeltaMovement(deltaMovement.multiply(f, 1.0d, f));
            } else {
                float f2 = 1.0f - (fMo6055a / 3.0f);
                localPlayer.setDeltaMovement(deltaMovement.multiply(f2, 1.0d, f2));
            }
        }
    }
}
