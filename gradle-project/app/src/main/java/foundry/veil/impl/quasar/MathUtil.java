package foundry.veil.impl.quasar;

import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/quasar/MathUtil.class */
public class MathUtil {
    public static float angleCos(Vector3f v1, Vector3f v2) {
        float x = v1.x();
        float y = v1.y();
        float z = v1.z();
        float length1Squared = Math.fma(x, x, Math.fma(y, y, z * z));
        float length2Squared = Math.fma(v2.x(), v2.x(), Math.fma(v2.y(), v2.y(), v2.z() * v2.z()));
        float dot = Math.fma(x, v2.x(), Math.fma(y, v2.y(), z * v2.z()));
        return dot / ((float) Math.sqrt(length1Squared * length2Squared));
    }

    public static float angle(Vector3f v1, Vector3f v2) {
        float cos = angleCos(v1, v2);
        return (float) Math.acos((cos < 1.0f ? cos : 1.0f) > -1.0f ? r5 : -1.0f);
    }

    public static Vector4f vec4fFromVec3(Vec3 vec3, float w) {
        return new Vector4f((float) vec3.x, (float) vec3.y, (float) vec3.z, w);
    }

    public static Vector4f[] copyVector4fArray(Vector4f[] array) {
        Vector4f[] copy = new Vector4f[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = copyVector4f(array[i]);
        }
        return copy;
    }

    public static Vector4f copyVector4f(Vector4f vector) {
        return new Vector4f(vector.x(), vector.y(), vector.z(), vector.w());
    }

    public static int colorFromVec4f(Vector4f color) {
        float r = color.x();
        float g = color.y();
        float b = color.z();
        float a = color.w();
        return (((int) (r * 255.0f)) << 16) | (((int) (g * 255.0f)) << 8) | ((int) (b * 255.0f)) | (((int) (a * 255.0f)) << 24);
    }

    public static Vec3[] vec4fToVec3List(Vector4f[] vec4fList) {
        Vec3[] vec3List = new Vec3[vec4fList.length];
        for (int i = 0; i < vec4fList.length; i++) {
            vec3List[i] = new Vec3(vec4fList[i].x(), vec4fList[i].y(), vec4fList[i].z());
        }
        return vec3List;
    }
}
