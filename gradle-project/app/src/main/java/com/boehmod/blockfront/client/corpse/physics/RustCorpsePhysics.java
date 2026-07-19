package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.C0263jt;
import com.boehmod.blockfront.Q;
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
    private static final String w = "corpse_physics";
    private static final String x = "corpse_physics_natives";
    private static final boolean H = System.getProperty("os.name").toLowerCase().contains("win");
    private static final boolean I = System.getProperty("os.name").toLowerCase().contains("mac");
    public static boolean J = false;

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
        s();
    }

    private static String j() {
        Object obj;
        if (System.getProperty("os.arch").equals("arm") || System.getProperty("os.arch").startsWith("aarch64")) {
            obj = "aarch64";
        } else {
            obj = "x86_64";
        }
        if (H) {
            return "corpse_physics_" + obj + "_windows.dll";
        }
        if (I) {
            return "corpse_physics_" + obj + "_macos.dylib";
        }
        return "corpse_physics_" + obj + "_linux.so";
    }

    private static void s() {
        String strJ = j();
        try {
            InputStream resourceAsStream = RustCorpsePhysics.class.getResourceAsStream("/natives/" + strJ);
            try {
                if (resourceAsStream == null) {
                    throw new FileNotFoundException(w);
                }
                Path pathCreateTempFile = Files.createTempFile(x, null, new FileAttribute[0]);
                Files.copy(resourceAsStream, pathCreateTempFile, StandardCopyOption.REPLACE_EXISTING);
                System.load(pathCreateTempFile.toAbsolutePath().toString());
                J = true;
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } finally {
            }
        } catch (Exception e) {
            J = false;
            C0263jt.a("Failed to load `%s` native library", e, strJ);
        }
    }

    @NotNull
    public static d a(int i, Q q, Vector3dc vector3dc, double d) {
        Vector3dc vector3dcD = q.d();
        Quaterniondc quaterniondcMo158a = q.mo158a();
        createObject(i, new double[]{vector3dcD.x(), vector3dcD.y(), vector3dcD.z(), quaterniondcMo158a.x(), quaterniondcMo158a.y(), quaterniondcMo158a.z(), quaterniondcMo158a.w()}, vector3dc.x(), vector3dc.y(), vector3dc.z(), d);
        return new d(i);
    }

    public static a a() {
        return new a(uploadBlock());
    }
}
