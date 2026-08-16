package foundry.veil.api.resource;

import foundry.veil.Veil;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.resource.VeilResource;
import imgui.ImGui;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/VeilResource.class */
public interface VeilResource<T extends VeilResource<?>> {
    VeilResourceInfo resourceInfo();

    List<VeilResourceAction<T>> getActions();

    boolean canHotReload();

    void hotReload(VeilResourceManager veilResourceManager) throws IOException;

    int getIconCode();

    default void render(boolean dragging, boolean fullName) {
        VeilImGuiUtil.icon(getIconCode());
        ImGui.sameLine();
        VeilResourceInfo resourceInfo = resourceInfo();
        ImGui.pushStyleColor(0, resourceInfo.isStatic() ? -5592406 : -1);
        if (dragging || fullName) {
            VeilImGuiUtil.resourceLocation(resourceInfo.location());
        } else {
            ImGui.text(resourceInfo.fileName());
        }
        ImGui.popStyleColor();
    }

    default CompletableFuture<?> onFileSystemChange(VeilResourceManager resourceManager, WatchEvent<Path> event) {
        if (canHotReload() && (event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY)) {
            Veil.LOGGER.info("Hot swapping {} after file system change", resourceInfo().location());
            return CompletableFuture.runAsync(() -> {
                try {
                    copyToResources();
                } catch (IOException e) {
                    throw new CompletionException(e);
                }
            }, task -> {
                Minecraft.getInstance().tell(() -> {
                    Util.ioPool().execute(task);
                });
            }).thenRunAsync(() -> {
                try {
                    hotReload(resourceManager);
                } catch (IOException e) {
                    throw new CompletionException(e);
                }
            }, (Executor) Minecraft.getInstance()).exceptionally(e -> {
                while (e instanceof CompletionException) {
                    e = e.getCause();
                }
                Veil.LOGGER.error("Failed to hot swap file system change", e);
                return null;
            });
        }
        return CompletableFuture.completedFuture(null);
    }

    default void copyToResources() throws IOException {
        Path modPath;
        VeilResourceInfo info = resourceInfo();
        Path filePath = info.filePath();
        if (filePath == null || (modPath = info.modResourcePath()) == null) {
            return;
        }
        InputStream is = Files.newInputStream(modPath, new OpenOption[0]);
        try {
            OutputStream os = Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING);
            try {
                IOUtils.copyLarge(is, os);
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (Throwable th) {
                if (os != null) {
                    try {
                        os.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }
}
