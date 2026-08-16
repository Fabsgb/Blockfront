package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.iV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iV.class */
public final class C0486iV {

    /* JADX INFO: renamed from: lb */
    private static final int f2957lb = 20;

    /* JADX INFO: renamed from: lc */
    private static final int f2958lc = 60;

    /* JADX INFO: renamed from: lj */
    private static final int f2969lj = 20;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntArrayList f2959a = new IntArrayList();

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final IntArrayList f2960b = new IntArrayList();

    /* JADX INFO: renamed from: ld */
    private static int f2961ld = -1;

    /* JADX INFO: renamed from: dl */
    private static boolean f2962dl = false;

    /* JADX INFO: renamed from: le */
    private static int f2963le = 0;

    /* JADX INFO: renamed from: lf */
    private static int f2964lf = 0;

    /* JADX INFO: renamed from: hm */
    private static float f2965hm = 0.0f;

    /* JADX INFO: renamed from: lg */
    private static int f2966lg = -1;

    /* JADX INFO: renamed from: lh */
    private static int f2967lh = -1;

    /* JADX INFO: renamed from: li */
    private static int f2968li = 0;

    /* JADX INFO: renamed from: lk */
    private static int f2970lk = -1;

    /* JADX INFO: renamed from: ll */
    private static int f2971ll = 0;

    private C0486iV() {
    }

    /* JADX INFO: renamed from: a */
    public static void m2175a(@NotNull ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (!(item instanceof C1117uP)) {
            m2176bd();
            return;
        }
        C1117uP c1117uP = (C1117uP) item;
        m2187b(itemStack);
        for (int i = 0; i < f2960b.size(); i++) {
            f2960b.set(i, f2960b.getInt(i) + 1);
        }
        while (!f2960b.isEmpty() && f2960b.getInt(0) > 20) {
            f2960b.removeInt(0);
            f2959a.removeInt(0);
        }
        f2965hm = f2964lf;
        if (f2962dl) {
            int i2 = f2964lf - 1;
            f2964lf = i2;
            if (i2 <= 0) {
                m2188a(c1117uP, itemStack);
            }
        }
        if (f2966lg >= 0) {
            int i3 = f2968li + 1;
            f2968li = i3;
            if (i3 > 60) {
                m2192be();
            }
        }
        if (f2970lk >= 0) {
            int i4 = f2971ll + 1;
            f2971ll = i4;
            if (i4 > 20) {
                f2970lk = -1;
            }
        }
    }

    /* JADX INFO: renamed from: bd */
    public static void m2176bd() {
        f2959a.clear();
        f2960b.clear();
        f2961ld = -1;
        f2962dl = false;
        f2963le = 0;
        f2964lf = 0;
        f2965hm = 0.0f;
        f2970lk = -1;
        f2971ll = 0;
        m2192be();
    }

    /* JADX INFO: renamed from: a */
    public static void m2177a(@NotNull C1117uP c1117uP) {
        f2959a.add(c1117uP.m6350cn());
        f2960b.add(0);
    }

    /* JADX INFO: renamed from: v */
    public static void m2178v(@NotNull Minecraft minecraft) {
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || minecraft.screen != null || localPlayer.getHealth() <= 0.0f) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            if (f2962dl) {
                return;
            }
            m2187b(mainHandItem);
            int iM2189a = m2189a(mainHandItem);
            int iM2190b = m2190b(mainHandItem);
            if (iM2190b <= 0 || iM2189a >= c1117uP.m6283a(mainHandItem).m6402cq()) {
                return;
            }
            f2962dl = true;
            f2963le = Math.max(1, c1117uP.m6285a(mainHandItem, iM2189a, iM2190b));
            f2964lf = f2963le;
            f2965hm = f2963le;
            c1117uP.m6340a(minecraft, mainHandItem, iM2189a, iM2190b);
            C1169vO.m6648c(new C1233wZ(localPlayer.level().getGameTime()));
        }
    }

    /* JADX INFO: renamed from: aw */
    public static int m2179aw() {
        ItemStack itemStackM2193a = m2193a();
        if (itemStackM2193a == null) {
            return 0;
        }
        m2187b(itemStackM2193a);
        return m2189a(itemStackM2193a);
    }

    /* JADX INFO: renamed from: Z */
    public static boolean m2180Z() {
        return m2179aw() > 0;
    }

    /* JADX INFO: renamed from: ax */
    public static int m2181ax() {
        ItemStack itemStackM2193a = m2193a();
        if (itemStackM2193a == null) {
            return 0;
        }
        m2187b(itemStackM2193a);
        return m2190b(itemStackM2193a);
    }

    /* JADX INFO: renamed from: aa */
    public static boolean m2182aa() {
        return f2962dl;
    }

    /* JADX INFO: renamed from: ay */
    public static int m2183ay() {
        ItemStack itemStackM2193a = m2193a();
        if (itemStackM2193a == null) {
            return 0;
        }
        int iM6319g = C1117uP.m6319g(itemStackM2193a);
        if (f2970lk >= 0 && iM6319g == f2970lk) {
            f2970lk = -1;
        }
        return f2970lk >= 0 ? f2970lk : iM6319g;
    }

    /* JADX INFO: renamed from: b */
    public static void m2184b(@NotNull C1117uP c1117uP) {
        f2970lk = (m2183ay() + 1) % c1117uP.m6365a().length;
        f2971ll = 0;
        C1169vO.m6648c(new C1289xc());
    }

    /* JADX INFO: renamed from: Y */
    public static float m2185Y() {
        return f2963le;
    }

    /* JADX INFO: renamed from: o */
    public static float m2186o(float f) {
        return C1270xJ.m7170f(f2964lf, f2965hm, f);
    }

    /* JADX INFO: renamed from: b */
    private static void m2187b(@NotNull ItemStack itemStack) {
        int iM6265c = C1117uP.m6265c(itemStack);
        if (f2961ld == -1) {
            f2961ld = iM6265c;
        }
        if (iM6265c < f2961ld) {
            int iRemoveInt = f2961ld - iM6265c;
            while (iRemoveInt > 0 && !f2959a.isEmpty()) {
                iRemoveInt -= f2959a.removeInt(0);
                f2960b.removeInt(0);
            }
        } else if (iM6265c > f2961ld) {
            if (f2966lg >= 0) {
                int iRemoveInt2 = f2966lg - iM6265c;
                while (iRemoveInt2 > 0 && !f2959a.isEmpty()) {
                    iRemoveInt2 -= f2959a.removeInt(0);
                    f2960b.removeInt(0);
                }
            }
            m2192be();
        }
        f2961ld = iM6265c;
    }

    /* JADX INFO: renamed from: a */
    private static void m2188a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack) {
        f2962dl = false;
        f2964lf = 0;
        int iM2189a = m2189a(itemStack);
        int iM2190b = m2190b(itemStack);
        if (iM2190b <= 0) {
            return;
        }
        int iM6402cq = c1117uP.m6283a(itemStack).m6402cq();
        int i = iM2189a + iM2190b;
        f2966lg = Math.min(i, iM6402cq);
        f2967lh = Math.max(0, i - iM6402cq);
        f2968li = 0;
    }

    /* JADX INFO: renamed from: a */
    private static int m2189a(@NotNull ItemStack itemStack) {
        return Math.max(0, (f2966lg >= 0 ? f2966lg : C1117uP.m6265c(itemStack)) - m2191az());
    }

    /* JADX INFO: renamed from: b */
    private static int m2190b(@NotNull ItemStack itemStack) {
        return f2967lh >= 0 ? f2967lh : C1117uP.m6268d(itemStack);
    }

    /* JADX INFO: renamed from: az */
    private static int m2191az() {
        int i = 0;
        for (int i2 = 0; i2 < f2959a.size(); i2++) {
            i += f2959a.getInt(i2);
        }
        return i;
    }

    /* JADX INFO: renamed from: be */
    private static void m2192be() {
        f2966lg = -1;
        f2967lh = -1;
        f2968li = 0;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static ItemStack m2193a() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return null;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.getItem() instanceof C1117uP) {
            return mainHandItem;
        }
        return null;
    }
}
