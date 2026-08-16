package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bf.class */
public final class C0115bf extends AbstractC0053aW {

    /* JADX INFO: renamed from: bR */
    public static final float f771bR = 1.0f;

    /* JADX INFO: renamed from: bS */
    private static final float f772bS = 0.0f;

    /* JADX INFO: renamed from: M */
    private static final double f773M = 0.6d;

    /* JADX INFO: renamed from: bT */
    private static final float f774bT = 3.0f;

    /* JADX INFO: renamed from: ca */
    public static final int f775ca = 10;

    /* JADX INFO: renamed from: bx */
    public static float f778bx;

    /* JADX INFO: renamed from: bU */
    public static float f780bU;

    /* JADX INFO: renamed from: bV */
    public static float f781bV;

    /* JADX INFO: renamed from: bW */
    public static float f782bW;

    /* JADX INFO: renamed from: bX */
    public static float f783bX;

    /* JADX INFO: renamed from: bY */
    private static float f786bY;

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final ObjectList<C0503im> f770o = new ObjectArrayList();

    /* JADX INFO: renamed from: N */
    public static double f776N = 0.0d;

    /* JADX INFO: renamed from: am */
    public static boolean f777am = false;

    /* JADX INFO: renamed from: by */
    public static float f779by = 0.0f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ItemStack f784a = null;

    /* JADX INFO: renamed from: cb */
    private static int f785cb = -1;

    /* JADX INFO: renamed from: bZ */
    private static float f787bZ = 0.0f;

    /* JADX INFO: renamed from: an */
    private static boolean f788an = false;

    /* JADX INFO: renamed from: a */
    public static void m422a(@NotNull C0503im c0503im) {
        f770o.add(c0503im);
    }

    /* JADX INFO: renamed from: b */
    private static void m423b(boolean z) {
        if (C1117uP.f6058ua > 0) {
            C1117uP.f6058ua--;
        }
        float f = (z && C0486iV.m2182aa()) ? 1.0f : 0.0f;
        f779by = f778bx;
        f778bx = Mth.lerp(0.15f, f778bx, f);
    }

    /* JADX INFO: renamed from: a */
    private static void m424a(@NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        if (C1117uP.f6060uc > 0) {
            C1117uP.f6060uc--;
        }
        int i = C1117uP.f6059ub;
        C1117uP.f6059ub = i + 1;
        if (i >= 5) {
            C1117uP.f6059ub = 0;
            if (abstractC0183b.m1128aR() != (C1117uP.f6063il || C1117uP.f6060uc > 0)) {
                C1169vO.m6648c(new C1206vz(C1117uP.f6063il || C1117uP.f6060uc > 0));
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) throws MatchException {
        if (localPlayer == null || clientLevel == null) {
            C0486iV.m2176bd();
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        f770o.removeIf(c0503im -> {
            return c0503im.m2263a(soundManager);
        });
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        C1117uP c1117uP = item instanceof C1117uP ? (C1117uP) item : null;
        boolean z2 = c1117uP != null;
        boolean zM4488a = C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj);
        if (zM4488a || c1117uP == null) {
            C1117uP.f6072im = false;
            C1117uP.f6073in = false;
            C1117uP.f6074io = false;
            C1117uP.f6075ip = false;
            C1117uP.f6076iq = false;
        }
        if (f788an && !zM4488a && c1117uP != null) {
            c1117uP.m6334dC();
        }
        f788an = zM4488a;
        if (zM4488a) {
            C0486iV.m2176bd();
        } else {
            C0486iV.m2175a(mainHandItem);
        }
        if (c1117uP != null) {
            c1117uP.m6333a(minecraft, c0623l, c0396gl, localPlayer, clientLevel, mainHandItem, c0394gj);
        }
        if (!z2) {
            C0036aF.f317ak = Mth.lerp(0.5f, C0036aF.f317ak, 0.0f);
            C0036aF.f318al = Mth.lerp(0.5f, C0036aF.f318al, 0.0f);
            C0036aF.f319am = Mth.lerp(0.5f, C0036aF.f319am, 0.0f);
        }
        C0401gq.m1907aQ();
        C0456hs.m2094aU();
        m424a(c0394gj);
        if (minecraft.screen != null) {
            C1117uP.f6063il = false;
        }
        ItemStack itemStack = f784a;
        int i = f785cb;
        f784a = mainHandItem;
        f785cb = localPlayer.getInventory().selected;
        boolean z3 = (i == -1 || i == f785cb) ? false : true;
        boolean z4 = (itemStack == null || itemStack.getItem() == f784a.getItem()) ? false : true;
        if (itemStack != null && (z3 || z4)) {
            C0486iV.m2176bd();
            Item item2 = itemStack.getItem();
            if (item2 instanceof C1117uP) {
                ((C1117uP) item2).m6334dC();
            }
            Item item3 = f784a.getItem();
            if (item3 instanceof C1117uP) {
                ((C1117uP) item3).m6334dC();
            }
            m425a(minecraft, f784a, f784a.getItem(), random);
            C1117uP.f6063il = false;
            return;
        }
        if (C1117uP.f6063il && c1117uP != null) {
            if (!f777am) {
                f777am = true;
                f776N = ((Double) minecraft.options.sensitivity().get()).doubleValue();
                minecraft.options.sensitivity().set(Double.valueOf(((Double) minecraft.options.sensitivity().get()).doubleValue() * ((double) (c1117uP.m6296a(mainHandItem).f6462go != null ? C0495ie.f3027c.m2223N() : C0495ie.f3026b.m2223N()))));
            }
        } else if (f777am) {
            f777am = false;
            minecraft.options.sensitivity().set(Double.valueOf(f776N));
            minecraft.options.save();
        }
        f781bV = f780bU;
        if (c1117uP != null) {
            C1188vh c1188vhM6296a = c1117uP.m6296a(mainHandItem);
            f780bU = C1270xJ.m7161d(f780bU, C1117uP.f6063il ? 1.0f : 0.0f, c1188vhM6296a.f6460or);
            double d = 1.0d - (f773M * ((double) (f780bU / c1188vhM6296a.f6459oq)));
            if (c1188vhM6296a.f6458iS && localPlayer.onGround()) {
                localPlayer.setDeltaMovement(localPlayer.getDeltaMovement().multiply(d, 1.0d, d));
            }
        } else {
            f780bU = 0.0f;
        }
        float xRot = localPlayer.getXRot();
        float yRot = localPlayer.getYRot();
        float fM7185I = C1270xJ.m7185I(f786bY - xRot);
        float fM7185I2 = C1270xJ.m7185I(f787bZ - yRot);
        f786bY = xRot;
        f787bZ = yRot;
        f783bX = f782bW;
        if (!C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj)) {
            f782bW += Mth.abs(fM7185I * 0.005f) + Mth.abs(fM7185I2 * 0.005f);
        }
        f782bW = Mth.lerp(0.2f, f782bW, 0.0f);
        C1117uP.f6062nY = C1117uP.f6061nX;
        C1117uP.f6061nX = Mth.lerp(0.4f, C1117uP.f6061nX, (c1117uP == null || !localPlayer.isCrouching() || C1117uP.f6063il) ? 0.0f : 1.0f);
        if (c0394gj.m1104dt()) {
            minecraft.hitResult = localPlayer.pick(0.0d, 0.0f, false);
        }
        if (item instanceof InterfaceC1072tX) {
            m426a(localPlayer, mainHandItem, (InterfaceC1072tX) item);
        }
        if (localPlayer.isSprinting()) {
            C1117uP.f6063il = false;
        }
        m423b(c1117uP != null);
    }

    /* JADX INFO: renamed from: a */
    public void m425a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack, @NotNull Item item, @NotNull Random random) {
        SoundEvent soundEventMo6226z = null;
        C0434hW c0434hW = null;
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1117uP.class, C1102uA.class, C1134ug.class, C1109uH.class, C1152uy.class, C1067tS.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                C1117uP c1117uP = (C1117uP) item;
                c1117uP.m6386j(itemStack);
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6864W = c1117uP.m6384a(itemStack).m6864W();
                if (deferredHolderM6864W != null) {
                    soundEventMo6226z = (SoundEvent) deferredHolderM6864W.get();
                }
                c0434hW = C0435hX.f2773w;
                break;
            case 1:
                ((C1102uA) item).m6578q("equip");
                soundEventMo6226z = (SoundEvent) C1312xz.f8189tC.get();
                c0434hW = C0435hX.f2778B;
                break;
            case 2:
                soundEventMo6226z = (SoundEvent) C1312xz.f8653Cy.get();
                c0434hW = C0435hX.f2773w;
                break;
            case 3:
                soundEventMo6226z = ((C1109uH) item).mo6226z();
                c0434hW = C0435hX.f2774x;
                break;
            case 4:
                soundEventMo6226z = (SoundEvent) C1312xz.f8183tw.get();
                c0434hW = C0435hX.f2776z;
                break;
            case 5:
                soundEventMo6226z = (SoundEvent) C1312xz.f8185ty.get();
                c0434hW = C0435hX.f2779C;
                break;
        }
        if (soundEventMo6226z != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventMo6226z, 0.9f + (0.2f * random.nextFloat()), 1.0f));
        }
        if (c0434hW != null) {
            C0432hU.m1986a(c0434hW);
        }
        C0034aD.f300ab = 1.0f;
        C0034aD.f301ac = 1.0f;
        C1117uP.f6071ue = 10;
    }

    /* JADX INFO: renamed from: a */
    private void m426a(@NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack, @NotNull InterfaceC1072tX interfaceC1072tX) {
        float fMo5941a = interfaceC1072tX.mo5941a(itemStack);
        if (fMo5941a > 0.0f && interfaceC1072tX.mo5940b(localPlayer, itemStack)) {
            Vec3 deltaMovement = localPlayer.getDeltaMovement();
            if (localPlayer.onGround()) {
                float f = 1.0f - fMo5941a;
                localPlayer.setDeltaMovement(deltaMovement.multiply(f, 1.0d, f));
            } else {
                float f2 = 1.0f - (fMo5941a / 3.0f);
                localPlayer.setDeltaMovement(deltaMovement.multiply(f2, 1.0d, f2));
            }
        }
    }
}
