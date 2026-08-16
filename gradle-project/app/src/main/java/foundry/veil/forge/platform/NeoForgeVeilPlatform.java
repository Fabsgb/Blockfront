package foundry.veil.forge.platform;

import foundry.veil.platform.VeilPlatform;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.fml.ModLoader;
import net.neoforged.fml.loading.FMLConfig;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/platform/NeoForgeVeilPlatform.class */
@ApiStatus.Internal
public class NeoForgeVeilPlatform implements VeilPlatform {
    @Override // foundry.veil.platform.VeilPlatform
    public VeilPlatform.PlatformType getPlatformType() {
        return VeilPlatform.PlatformType.NEOFORGE;
    }

    @Override // foundry.veil.platform.VeilPlatform
    public boolean isModLoaded(String modId) {
        return FMLLoader.getLoadingModList().getModFileById(modId) != null;
    }

    @Override // foundry.veil.platform.VeilPlatform
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override // foundry.veil.platform.VeilPlatform
    public boolean canAttachRenderdoc() {
        String windowControl;
        return !FMLConfig.getBoolConfigValue(FMLConfig.ConfigValue.EARLY_WINDOW_CONTROL) || (windowControl = FMLConfig.getConfigValue(FMLConfig.ConfigValue.EARLY_WINDOW_PROVIDER)) == null || "dummyprovider".equals(windowControl);
    }

    @Override // foundry.veil.platform.VeilPlatform
    public boolean hasErrors() {
        return ModLoader.hasErrors();
    }

    @Override // foundry.veil.platform.VeilPlatform
    public boolean hasChannel(PacketListener listener, CustomPacketPayload.Type<?> type) {
        if (listener instanceof ICommonPacketListener) {
            ICommonPacketListener impl = (ICommonPacketListener) listener;
            if (impl.hasChannel(type)) {
                return true;
            }
        }
        return false;
    }
}
