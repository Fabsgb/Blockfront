package com.boehmod.blockfront;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.xq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xq.class */
public interface InterfaceC0638xq {
    public static final int tG = -1;
    public static final int tH = 1;
    public static final int tI = 2;
    public static final int tJ = 4;
    public static final int tK = 8;
    public static final int tL = 16;
    public static final int tM = 32;
    public static final int tN = 64;
    public static final int tO = 128;
    public static final int tP = 256;
    public static final int tQ = 512;
    public static final int tR = 1024;
    public static final int tS = 2048;
    public static final int tT = 4096;
    public static final int tU = 8192;
    public static final int tV = 16384;
    public static final int tW = 32768;
    public static final int tX = 65536;
    public static final int tY = 131072;
    public static final int tZ = 262144;
    public static final int ua = 524288;
    public static final int ub = 1048576;
    public static final int uc = 2097152;
    public static final int ud = 4194304;
    public static final int ue = 8388608;
    public static final int uf = 16777216;
    public static final int ug = 33554432;
    public static final int uh = 67108864;
    public static final Pattern e = Pattern.compile("^part_turret(\\d*)$");

    int bf$getFlags();

    void bf$setFlags(int i);

    static int d(@NotNull String str) {
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
            i |= tQ;
        }
        if (str.startsWith("main")) {
            i |= tR;
            if (str.length() == 4) {
                i |= tS;
            }
        }
        if (str.equals("muzzleflash")) {
            i |= 4096;
        }
        if (str.contains("overheat")) {
            i |= tU;
        }
        if (str.equalsIgnoreCase("scope")) {
            i |= tV;
        }
        if (str.startsWith("sticker")) {
            i |= tW;
        }
        if (str.endsWith("_barrel_main")) {
            i |= tX;
        }
        if (str.endsWith("_muzzleflash")) {
            i |= tY;
        }
        if (str.equals("body")) {
            i |= tZ;
        }
        if (str.equals("head")) {
            i |= ua;
        }
        if (e.matcher(str).matches()) {
            i |= 1048576;
        }
        if (str.startsWith("wheel_")) {
            i |= uc;
        }
        if (str.contains("front")) {
            i |= ud;
        }
        if (str.contains("left")) {
            i |= ue;
        }
        if (str.contains("right")) {
            i |= uf;
        }
        if (str.startsWith("barrel")) {
            i |= ug;
        }
        if (str.startsWith("glow")) {
            i |= uh;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int a(@NotNull GeoBone geoBone) {
        InterfaceC0638xq interfaceC0638xq = (InterfaceC0638xq) geoBone;
        int iBf$getFlags = interfaceC0638xq.bf$getFlags();
        if (iBf$getFlags == -1) {
            iBf$getFlags = d(geoBone.getName());
            interfaceC0638xq.bf$setFlags(iBf$getFlags);
        }
        return iBf$getFlags;
    }
}
