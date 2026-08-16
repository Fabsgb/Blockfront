package foundry.veil.platform;

import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/platform/VeilPlatform.class */
public interface VeilPlatform {
    PlatformType getPlatformType();

    boolean isModLoaded(String str);

    boolean isDevelopmentEnvironment();

    boolean canAttachRenderdoc();

    boolean hasErrors();

    boolean hasChannel(PacketListener packetListener, CustomPacketPayload.Type<?> type);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/platform/VeilPlatform$PlatformType.class */
    public enum PlatformType {
        NEOFORGE("NeoForge", "forge"),
        FABRIC("Fabric", "fabric");

        private final String platformName;
        private final String mixinPackageName;

        PlatformType(String platformName, String mixinPackageName) {
            this.platformName = platformName;
            this.mixinPackageName = mixinPackageName;
        }

        public String getPlatformName() {
            return this.platformName;
        }

        public String getMixinPackageName() {
            return this.mixinPackageName;
        }
    }
}
