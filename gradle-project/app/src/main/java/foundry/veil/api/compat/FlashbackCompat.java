package foundry.veil.api.compat;

import foundry.veil.Veil;
import java.util.ServiceLoader;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/compat/FlashbackCompat.class */
public interface FlashbackCompat {
    public static final FlashbackCompat INSTANCE;

    void backup(Matrix4f matrix4f, Quaternionf quaternionf);

    void restore(Matrix4f matrix4f, Quaternionf quaternionf);

    static {
        INSTANCE = Veil.platform().isModLoaded("flashback") ? (FlashbackCompat) ServiceLoader.load(FlashbackCompat.class).findFirst().orElse(null) : null;
    }

    static boolean isLoaded() {
        return INSTANCE != null;
    }
}
