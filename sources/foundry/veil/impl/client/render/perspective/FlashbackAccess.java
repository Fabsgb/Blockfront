package foundry.veil.impl.client.render.perspective;

import foundry.veil.api.compat.FlashbackCompat;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/FlashbackAccess.class */
public class FlashbackAccess {
    public static void backup(Matrix4f lastProjectionMatrix, Quaternionf lastViewQuaternion) {
        if (FlashbackCompat.isLoaded()) {
            FlashbackCompat.INSTANCE.backup(lastProjectionMatrix, lastViewQuaternion);
        }
    }

    public static void restore(Matrix4f lastProjectionMatrix, Quaternionf lastViewQuaternion) {
        if (FlashbackCompat.isLoaded()) {
            FlashbackCompat.INSTANCE.restore(lastProjectionMatrix, lastViewQuaternion);
        }
    }
}
