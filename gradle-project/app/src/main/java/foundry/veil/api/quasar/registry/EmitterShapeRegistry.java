package foundry.veil.api.quasar.registry;

import foundry.veil.Veil;
import foundry.veil.api.quasar.emitters.shape.Cube;
import foundry.veil.api.quasar.emitters.shape.Cylinder;
import foundry.veil.api.quasar.emitters.shape.Disc;
import foundry.veil.api.quasar.emitters.shape.EmitterShape;
import foundry.veil.api.quasar.emitters.shape.Hemisphere;
import foundry.veil.api.quasar.emitters.shape.Plane;
import foundry.veil.api.quasar.emitters.shape.Point;
import foundry.veil.api.quasar.emitters.shape.Sphere;
import foundry.veil.api.quasar.emitters.shape.Torus;
import foundry.veil.platform.registry.RegistrationProvider;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/registry/EmitterShapeRegistry.class */
public class EmitterShapeRegistry {
    public static final ResourceKey<Registry<EmitterShape>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("quasar/emitter_shape"));
    private static final RegistrationProvider<EmitterShape> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<EmitterShape> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<Point> POINT = register("point", new Point());
    public static final Supplier<Hemisphere> HEMISPHERE = register("hemisphere", new Hemisphere());
    public static final Supplier<Cylinder> CYLINDER = register("cylinder", new Cylinder());
    public static final Supplier<Sphere> SPHERE = register("sphere", new Sphere());
    public static final Supplier<Cube> CUBE = register("cube", new Cube());
    public static final Supplier<Torus> TORUS = register("torus", new Torus());
    public static final Supplier<Disc> DISC = register("disc", new Disc());
    public static final Supplier<Plane> PLANE = register("plane", new Plane());

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends EmitterShape> Supplier<T> register(String str, T t) {
        return PROVIDER.register(str, () -> {
            return t;
        });
    }
}
