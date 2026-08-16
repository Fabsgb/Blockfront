package foundry.veil.impl.client.render.perspective;

import foundry.veil.Veil;
import foundry.veil.api.compat.IrisCompat;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import net.minecraft.client.renderer.LevelRenderer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/IrisPipelineAccess.class */
@ApiStatus.Internal
public class IrisPipelineAccess {
    private static final MethodHandle GETTER;
    private static final MethodHandle SETTER;

    static {
        MethodHandle getter = null;
        MethodHandle setter = null;
        try {
            if (IrisCompat.INSTANCE != null) {
                Field[] fields = LevelRenderer.class.getDeclaredFields();
                for (Field field : fields) {
                    if (field.getType().equals(IrisCompat.INSTANCE.getPipelineClass())) {
                        MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(LevelRenderer.class, MethodHandles.lookup());
                        getter = lookup.findGetter(LevelRenderer.class, field.getName(), field.getType());
                        setter = lookup.findSetter(LevelRenderer.class, field.getName(), field.getType());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GETTER = getter;
        SETTER = setter;
    }

    @Nullable
    public static Object getPipeline(LevelRenderer levelRenderer) {
        try {
            if (GETTER != null) {
                return GETTER.invokeWithArguments(levelRenderer);
            }
            return null;
        } catch (Throwable e) {
            Veil.LOGGER.error("Error getting Iris pipeline", e);
            return null;
        }
    }

    public static void setPipeline(LevelRenderer levelRenderer, Object pipeline) {
        if (SETTER != null) {
            try {
                SETTER.invokeWithArguments(levelRenderer, pipeline);
            } catch (Throwable e) {
                Veil.LOGGER.error("Error setting Iris pipeline", e);
            }
        }
    }
}
