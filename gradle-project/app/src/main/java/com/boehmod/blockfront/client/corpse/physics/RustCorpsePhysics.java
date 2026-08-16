package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0530jM;
import com.boehmod.blockfront.InterfaceC0026W;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/RustCorpsePhysics.class */
public class RustCorpsePhysics {

    /* JADX INFO: renamed from: B */
    private static final String f1359B = "corpse_physics";

    /* JADX INFO: renamed from: C */
    private static final String f1360C = "corpse_physics_natives";

    /* JADX INFO: renamed from: M */
    private static final boolean f1361M = System.getProperty("os.name").toLowerCase().contains("win");

    /* JADX INFO: renamed from: N */
    private static final boolean f1362N = System.getProperty("os.name").toLowerCase().contains("mac");

    /* JADX INFO: renamed from: O */
    public static boolean f1363O = false;

    public static native void initialize(double d, double d2, double d3);

    public static native void tick(double d);

    protected static native void createObject(int i, double[] dArr, double d, double d2, double d3, double d4);

    protected static native void removeObject(int i);

    protected static native double[] getPose(int i);

    protected static native void getPoseInto(int i, double[] dArr);

    protected static native void addLinearAngularVelocities(int i, double d, double d2, double d3, double d4, double d5, double d6);

    protected static native void multiplyVelocities(int i, double d);

    protected static native void addRagdollConstraint(int i, int i2, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18);

    public static native void addChunk(int i, int i2, int i3, int[] iArr);

    public static native void removeChunk(int i, int i2, int i3);

    public static native void changeBlock(int i, int i2, int i3, int i4);

    protected static native int uploadBlock();

    protected static native void addBox(int i, double[] dArr);

    public static native void clearLevel();

    static {
        m1062v();
    }

    /* JADX INFO: renamed from: n */
    private static String m1061n() {
        Object obj;
        if (System.getProperty("os.arch").equals("arm") || System.getProperty("os.arch").startsWith("aarch64")) {
            obj = "aarch64";
        } else {
            obj = "x86_64";
        }
        if (f1361M) {
            return "corpse_physics_" + obj + "_windows.dll";
        }
        if (f1362N) {
            return "corpse_physics_" + obj + "_macos.dylib";
        }
        return "corpse_physics_" + obj + "_linux.so";
    }

    /* JADX INFO: renamed from: v */
    private static void m1062v() {
        String strM1061n = m1061n();
        try {
            InputStream resourceAsStream = RustCorpsePhysics.class.getResourceAsStream("/natives/" + strM1061n);
            try {
                if (resourceAsStream == null) {
                    throw new FileNotFoundException(f1359B);
                }
                Path pathCreateTempFile = Files.createTempFile(f1360C, null, new FileAttribute[0]);
                Files.copy(resourceAsStream, pathCreateTempFile, StandardCopyOption.REPLACE_EXISTING);
                System.load(pathCreateTempFile.toAbsolutePath().toString());
                f1363O = true;
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            f1363O = false;
            C0530jM.m2338a("Failed to load `%s` native library", e, strM1061n);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0178d m1063a(int i, InterfaceC0026W interfaceC0026W, Vector3dc vector3dc, double d) {
        Vector3dc vector3dcMo157d = interfaceC0026W.mo157d();
        Quaterniondc quaterniondcMo156a = interfaceC0026W.mo156a();
        createObject(i, new double[]{vector3dcMo157d.x(), vector3dcMo157d.y(), vector3dcMo157d.z(), quaterniondcMo156a.x(), quaterniondcMo156a.y(), quaterniondcMo156a.z(), quaterniondcMo156a.w()}, vector3dc.x(), vector3dc.y(), vector3dc.z(), d);
        return new C0178d(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0175a m1064a() {
        return new C0175a(uploadBlock());
    }
}
