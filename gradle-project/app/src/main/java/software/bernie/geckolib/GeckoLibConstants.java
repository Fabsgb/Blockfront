package software.bernie.geckolib;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/GeckoLibConstants.class */
public final class GeckoLibConstants {
    public static final String MODID = "geckolib";
    public static final Logger LOGGER = LogManager.getLogger("GeckoLib");
    public static final Supplier<DataComponentType<Long>> STACK_ANIMATABLE_ID_COMPONENT = GeckoLibServices.PLATFORM.registerDataComponent("stack_animatable_id", builder -> {
        return builder.persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG);
    });

    public static void init() {
    }

    /* JADX INFO: renamed from: id */
    public static ResourceLocation m8356id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static RuntimeException exception(ResourceLocation resource, String message) {
        return new RuntimeException(String.valueOf(resource) + ": " + message);
    }

    public static RuntimeException exception(ResourceLocation resource, String message, Throwable exception) {
        return new RuntimeException(String.valueOf(resource) + ": " + message, exception);
    }
}
