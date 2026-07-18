package foundry.veil;

import foundry.veil.api.molang.VeilMolang;
import foundry.veil.impl.network.VeilPacketSender;
import foundry.veil.platform.VeilPlatform;
import gg.moonflower.molangcompiler.api.MolangCompiler;
import java.util.ServiceLoader;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/Veil.class */
public class Veil {
    public static final String MODID = "veil";
    public static final boolean DEBUG;
    public static final boolean VERBOSE_SHADER_ERRORS;
    public static boolean RENDERDOC;
    public static final Logger LOGGER = LoggerFactory.getLogger("Veil");
    private static final VeilPlatform PLATFORM = (VeilPlatform) ServiceLoader.load(VeilPlatform.class).findFirst().orElseThrow(() -> {
        return new RuntimeException("Veil expected platform implementation");
    });
    public static final boolean SODIUM = PLATFORM.isModLoaded("sodium");
    public static final boolean IRIS = PLATFORM.isModLoaded("iris");
    public static final boolean IMGUIMC = PLATFORM.isModLoaded("imguimc");

    static {
        DEBUG = System.getProperty("veil.debug") != null;
        VERBOSE_SHADER_ERRORS = System.getProperty("veil.verboseShaderErrors") != null;
    }

    @ApiStatus.Internal
    public static void init() {
        LOGGER.info("Veil is initializing.");
        if (DEBUG) {
            LOGGER.info("Veil Debug Enabled");
        }
        VeilMolang.set(MolangCompiler.create(1, Veil.class.getClassLoader()));
        VeilPacketSender.init();
    }

    public static ResourceLocation veilPath(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static VeilPlatform platform() {
        return PLATFORM;
    }
}
