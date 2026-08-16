package foundry.veil.mixin.debug.client;

import foundry.veil.Veil;
import foundry.veil.platform.VeilPlatform;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.Util;
import net.minecraft.client.main.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/client/DebugMainMixin.class */
@Mixin({Main.class})
public class DebugMainMixin {

    @Unique
    private static final int ENABLE_TIME = 4000;

    @Inject(method = {"main"}, at = {@At("HEAD")}, remap = false)
    private static void preMain(CallbackInfo ci) {
        VeilPlatform platform = Veil.platform();
        if (!platform.isDevelopmentEnvironment() || !platform.canAttachRenderdoc() || platform.isModLoaded("tracky") || Util.getPlatform() != Util.OS.WINDOWS) {
            return;
        }
        String path = System.getProperty("java.library.path");
        String name = System.mapLibraryName("renderdoc");
        boolean detected = false;
        for (String folder : path.split(";")) {
            if (Files.exists(Path.of(folder + "/" + name, new String[0]), new LinkOption[0])) {
                detected = true;
                break;
            }
        }
        if (!detected) {
            return;
        }
        AtomicBoolean enable = new AtomicBoolean();
        Thread td = new Thread(() -> {
            Veil.LOGGER.warn("Renderdoc detected, would you like to load it? y/N");
            long start = System.currentTimeMillis();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (System.currentTimeMillis() - start <= 4000) {
                try {
                    if (reader.ready()) {
                        String ln = reader.readLine().trim().toLowerCase(Locale.ROOT);
                        if (ln.startsWith("y")) {
                            enable.set(true);
                            return;
                        } else if (ln.startsWith("n")) {
                            return;
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                }
            }
        }, "Veil-RenderDocker");
        td.setDaemon(true);
        td.start();
        try {
            td.join();
            if (enable.get()) {
                System.loadLibrary("renderdoc");
                Veil.RENDERDOC = true;
                Veil.LOGGER.info("Renderdoc Loaded");
            }
        } catch (Throwable e) {
            Veil.LOGGER.info("Failed to load Renderdoc", e);
        }
    }
}
