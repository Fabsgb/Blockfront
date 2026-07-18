package com.boehmod.blockfront;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.xq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xq.class */
public interface InterfaceC1294xq {

    /* JADX INFO: renamed from: tG */
    public static final int f8645tG = -1;

    /* JADX INFO: renamed from: tH */
    public static final int f8646tH = 1;

    /* JADX INFO: renamed from: tI */
    public static final int f8647tI = 2;

    /* JADX INFO: renamed from: tJ */
    public static final int f8648tJ = 4;

    /* JADX INFO: renamed from: tK */
    public static final int f8649tK = 8;

    /* JADX INFO: renamed from: tL */
    public static final int f8650tL = 16;

    /* JADX INFO: renamed from: tM */
    public static final int f8651tM = 32;

    /* JADX INFO: renamed from: tN */
    public static final int f8652tN = 64;

    /* JADX INFO: renamed from: tO */
    public static final int f8653tO = 128;

    /* JADX INFO: renamed from: tP */
    public static final int f8654tP = 256;

    /* JADX INFO: renamed from: tQ */
    public static final int f8655tQ = 512;

    /* JADX INFO: renamed from: tR */
    public static final int f8656tR = 1024;

    /* JADX INFO: renamed from: tS */
    public static final int f8657tS = 2048;

    /* JADX INFO: renamed from: tT */
    public static final int f8658tT = 4096;

    /* JADX INFO: renamed from: tU */
    public static final int f8659tU = 8192;

    /* JADX INFO: renamed from: tV */
    public static final int f8660tV = 16384;

    /* JADX INFO: renamed from: tW */
    public static final int f8661tW = 32768;

    /* JADX INFO: renamed from: tX */
    public static final int f8662tX = 65536;

    /* JADX INFO: renamed from: tY */
    public static final int f8663tY = 131072;

    /* JADX INFO: renamed from: tZ */
    public static final int f8664tZ = 262144;

    /* JADX INFO: renamed from: ua */
    public static final int f8665ua = 524288;

    /* JADX INFO: renamed from: ub */
    public static final int f8666ub = 1048576;

    /* JADX INFO: renamed from: uc */
    public static final int f8667uc = 2097152;

    /* JADX INFO: renamed from: ud */
    public static final int f8668ud = 4194304;

    /* JADX INFO: renamed from: ue */
    public static final int f8669ue = 8388608;

    /* JADX INFO: renamed from: uf */
    public static final int f8670uf = 16777216;

    /* JADX INFO: renamed from: ug */
    public static final int f8671ug = 33554432;

    /* JADX INFO: renamed from: uh */
    public static final int f8672uh = 67108864;

    /* JADX INFO: renamed from: e */
    public static final Pattern f8673e = Pattern.compile("^part_turret(\\d*)$");

    int bf$getFlags();

    void bf$setFlags(int i);

    /* JADX INFO: renamed from: d */
    static int m7918d(@NotNull String str) {
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
            i |= f8655tQ;
        }
        if (str.startsWith("main")) {
            i |= f8656tR;
            if (str.length() == 4) {
                i |= f8657tS;
            }
        }
        if (str.equals("muzzleflash")) {
            i |= 4096;
        }
        if (str.contains("overheat")) {
            i |= f8659tU;
        }
        if (str.equalsIgnoreCase("scope")) {
            i |= f8660tV;
        }
        if (str.startsWith("sticker")) {
            i |= f8661tW;
        }
        if (str.endsWith("_barrel_main")) {
            i |= f8662tX;
        }
        if (str.endsWith("_muzzleflash")) {
            i |= f8663tY;
        }
        if (str.equals("body")) {
            i |= f8664tZ;
        }
        if (str.equals("head")) {
            i |= f8665ua;
        }
        if (f8673e.matcher(str).matches()) {
            i |= 1048576;
        }
        if (str.startsWith("wheel_")) {
            i |= f8667uc;
        }
        if (str.contains("front")) {
            i |= f8668ud;
        }
        if (str.contains("left")) {
            i |= f8669ue;
        }
        if (str.contains("right")) {
            i |= f8670uf;
        }
        if (str.startsWith("barrel")) {
            i |= f8671ug;
        }
        if (str.startsWith("glow")) {
            i |= f8672uh;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    static int m7919a(@NotNull GeoBone geoBone) {
        InterfaceC1294xq interfaceC1294xq = (InterfaceC1294xq) geoBone;
        int iBf$getFlags = interfaceC1294xq.bf$getFlags();
        if (iBf$getFlags == -1) {
            iBf$getFlags = m7918d(geoBone.getName());
            interfaceC1294xq.bf$setFlags(iBf$getFlags);
        }
        return iBf$getFlags;
    }
}
