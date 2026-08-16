package software.bernie.geckolib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/util/ClientUtil.class */
public final class ClientUtil {
    public static Player getClientPlayer() {
        return Minecraft.getInstance().player;
    }

    public static Level getLevel() {
        return Minecraft.getInstance().level;
    }
}
