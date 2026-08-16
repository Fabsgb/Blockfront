package software.bernie.geckolib;

import net.minecraft.core.registries.Registries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.DeferredRegister;
import software.bernie.geckolib.network.GeckoLibNetworkingNeoForge;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/GeckoLib.class */
@Mod(GeckoLibConstants.MODID)
public final class GeckoLib {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS_REGISTER = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, GeckoLibConstants.MODID);

    public GeckoLib(IEventBus modBus) {
        GeckoLibNetworkingNeoForge.init(modBus);
        DATA_COMPONENTS_REGISTER.register(modBus);
        GeckoLibConstants.init();
        if (FMLEnvironment.dist == Dist.CLIENT) {
            GeckoLibClient.init();
        }
    }
}
