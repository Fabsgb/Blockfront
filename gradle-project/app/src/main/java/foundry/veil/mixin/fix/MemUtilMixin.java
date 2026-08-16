package foundry.veil.mixin.fix;

import org.joml.Matrix3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/fix/MemUtilMixin.class */
@Mixin(targets = {"org.joml.MemUtil$MemUtilUnsafe"}, remap = false)
public class MemUtilMixin {

    @Shadow
    @Final
    public static Unsafe UNSAFE;

    @Shadow
    @Final
    public static long Matrix3f_m00;

    @Overwrite
    public static void put3x4(Matrix3f m, long destAddr) {
        for (int i = 0; i < 3; i++) {
            UNSAFE.putLong((Object) null, destAddr + ((long) (i << 4)), UNSAFE.getLong(m, Matrix3f_m00 + ((long) (12 * i))));
            UNSAFE.putFloat((Object) null, destAddr + ((long) (i << 4)) + 8, UNSAFE.getFloat(m, Matrix3f_m00 + 8 + ((long) (12 * i))));
            UNSAFE.putFloat((Object) null, destAddr + ((long) (i << 4)) + 12, 0.0f);
        }
    }
}
