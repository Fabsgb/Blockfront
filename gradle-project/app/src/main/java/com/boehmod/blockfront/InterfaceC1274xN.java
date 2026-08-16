package com.boehmod.blockfront;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.xN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xN.class */
public interface InterfaceC1274xN {

    /* JADX INFO: renamed from: vK */
    public static final int f6842vK = -1;

    /* JADX INFO: renamed from: vL */
    public static final int f6843vL = 1;

    /* JADX INFO: renamed from: vM */
    public static final int f6844vM = 2;

    /* JADX INFO: renamed from: vN */
    public static final int f6845vN = 4;

    /* JADX INFO: renamed from: vO */
    public static final int f6846vO = 8;

    /* JADX INFO: renamed from: vP */
    public static final int f6847vP = 16;

    /* JADX INFO: renamed from: vQ */
    public static final int f6848vQ = 32;

    /* JADX INFO: renamed from: vR */
    public static final int f6849vR = 64;

    /* JADX INFO: renamed from: vS */
    public static final int f6850vS = 128;

    /* JADX INFO: renamed from: vT */
    public static final int f6851vT = 256;

    /* JADX INFO: renamed from: vU */
    public static final int f6852vU = 512;

    /* JADX INFO: renamed from: vV */
    public static final int f6853vV = 1024;

    /* JADX INFO: renamed from: vW */
    public static final int f6854vW = 2048;

    /* JADX INFO: renamed from: vX */
    public static final int f6855vX = 4096;

    /* JADX INFO: renamed from: vY */
    public static final int f6856vY = 8192;

    /* JADX INFO: renamed from: vZ */
    public static final int f6857vZ = 16384;

    /* JADX INFO: renamed from: wa */
    public static final int f6858wa = 32768;

    /* JADX INFO: renamed from: wb */
    public static final int f6859wb = 65536;

    /* JADX INFO: renamed from: wc */
    public static final int f6860wc = 131072;

    /* JADX INFO: renamed from: wd */
    public static final int f6861wd = 262144;

    /* JADX INFO: renamed from: we */
    public static final int f6862we = 524288;

    /* JADX INFO: renamed from: wf */
    public static final int f6863wf = 1048576;

    /* JADX INFO: renamed from: wg */
    public static final int f6864wg = 2097152;

    /* JADX INFO: renamed from: wh */
    public static final int f6865wh = 4194304;

    /* JADX INFO: renamed from: wi */
    public static final int f6866wi = 8388608;

    /* JADX INFO: renamed from: wj */
    public static final int f6867wj = 16777216;

    /* JADX INFO: renamed from: wk */
    public static final int f6868wk = 33554432;

    /* JADX INFO: renamed from: wl */
    public static final int f6869wl = 67108864;

    /* JADX INFO: renamed from: f */
    public static final Pattern f6870f = Pattern.compile("^part_turret(\\d*)$");

    int bf$getFlags();

    void bf$setFlags(int i);

    /* JADX INFO: renamed from: d */
    static int m7245d(@NotNull String str) {
        int i = 0;
        if (str.contains("wobble")) {
            i = 0 | 1;
            if (str.contains("bipod")) {
                i |= 2;
            }
        }
        if (str.startsWith("aimpos")) {
            i |= 4;
        }
        if (str.equalsIgnoreCase("arms")) {
            i |= 8;
        }
        if (str.startsWith("barrel_type")) {
            i |= 16;
        }
        if (str.equals("eject")) {
            i |= 32;
        }
        if (str.equalsIgnoreCase("mag")) {
            i |= 64;
        }
        if (str.startsWith("bullet")) {
            i |= 128;
        }
        if (str.startsWith("mag_rot")) {
            i |= 256;
        }
        if (str.startsWith("mag_type")) {
            i |= f6852vU;
        }
        if (str.startsWith("main")) {
            i |= 1024;
            if (str.length() == 4) {
                i |= f6854vW;
            }
        }
        if (str.equals("muzzleflash")) {
            i |= 4096;
        }
        if (str.contains("overheat")) {
            i |= f6856vY;
        }
        if (str.equalsIgnoreCase("scope")) {
            i |= f6857vZ;
        }
        if (str.startsWith("sticker")) {
            i |= f6858wa;
        }
        if (str.endsWith("_barrel_main")) {
            i |= f6859wb;
        }
        if (str.endsWith("_muzzleflash")) {
            i |= f6860wc;
        }
        if (str.equals("body")) {
            i |= f6861wd;
        }
        if (str.equals("head")) {
            i |= f6862we;
        }
        if (f6870f.matcher(str).matches()) {
            i |= 1048576;
        }
        if (str.startsWith("wheel_")) {
            i |= f6864wg;
        }
        if (str.contains("front")) {
            i |= f6865wh;
        }
        if (str.contains("left")) {
            i |= f6866wi;
        }
        if (str.contains("right")) {
            i |= f6867wj;
        }
        if (str.startsWith("barrel")) {
            i |= f6868wk;
        }
        if (str.startsWith("glow")) {
            i |= f6869wl;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    static int m7246a(@NotNull GeoBone geoBone) {
        InterfaceC1274xN interfaceC1274xN = (InterfaceC1274xN) geoBone;
        int iBf$getFlags = interfaceC1274xN.bf$getFlags();
        if (iBf$getFlags == -1) {
            iBf$getFlags = m7245d(geoBone.getName());
            interfaceC1274xN.bf$setFlags(iBf$getFlags);
        }
        return iBf$getFlags;
    }
}
