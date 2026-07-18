package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0562jt;
import com.boehmod.blockfront.InterfaceC0019Q;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/RustCorpsePhysics.class */
public class RustCorpsePhysics {

    /* JADX INFO: renamed from: w */
    private static final String f1440w = "corpse_physics";

    /* JADX INFO: renamed from: x */
    private static final String f1441x = "corpse_physics_natives";

    /* JADX INFO: renamed from: H */
    private static final boolean f1442H = System.getProperty("os.name").toLowerCase().contains("win");

    /* JADX INFO: renamed from: I */
    private static final boolean f1443I = System.getProperty("os.name").toLowerCase().contains("mac");

    /* JADX INFO: renamed from: J */
    public static boolean f1444J = false;

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
        m1038s();
    }

    /* JADX INFO: renamed from: j */
    private static String m1037j() {
        Object obj;
        if (System.getProperty("os.arch").equals("arm") || System.getProperty("os.arch").startsWith("aarch64")) {
            obj = "aarch64";
        } else {
            obj = "x86_64";
        }
        if (f1442H) {
            return "corpse_physics_" + obj + "_windows.dll";
        }
        if (f1443I) {
            return "corpse_physics_" + obj + "_macos.dylib";
        }
        return "corpse_physics_" + obj + "_linux.so";
    }

    /* JADX INFO: renamed from: s */
    private static void m1038s() {
        String strM1037j = m1037j();
        try {
            InputStream resourceAsStream = RustCorpsePhysics.class.getResourceAsStream("/natives/" + strM1037j);
            try {
                if (resourceAsStream == null) {
                    throw new FileNotFoundException(f1440w);
                }
                Path pathCreateTempFile = Files.createTempFile(f1441x, null, new FileAttribute[0]);
                Files.copy(resourceAsStream, pathCreateTempFile, StandardCopyOption.REPLACE_EXISTING);
                System.load(pathCreateTempFile.toAbsolutePath().toString());
                f1444J = true;
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } finally {
            }
        } catch (Exception e) {
            f1444J = false;
            C0562jt.m2516a("Failed to load `%s` native library", e, strM1037j);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0177d m1039a(int i, InterfaceC0019Q interfaceC0019Q, Vector3dc vector3dc, double d) {
        Vector3dc vector3dcMo124d = interfaceC0019Q.mo124d();
        Quaterniondc quaterniondcMo123a = interfaceC0019Q.mo123a();
        createObject(i, new double[]{vector3dcMo124d.x(), vector3dcMo124d.y(), vector3dcMo124d.z(), quaterniondcMo123a.x(), quaterniondcMo123a.y(), quaterniondcMo123a.z(), quaterniondcMo123a.w()}, vector3dc.x(), vector3dc.y(), vector3dc.z(), d);
        return new C0177d(i);
    }

    /* JADX INFO: renamed from: a */
    public static C0174a m1040a() {
        return new C0174a(uploadBlock());
    }
}
