package foundry.veil.api.resource.editor;

import com.google.gson.JsonElement;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import foundry.veil.Veil;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/ResourceFileEditor.class */
public interface ResourceFileEditor<T extends VeilResource<?>> extends Closeable {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/ResourceFileEditor$Factory.class */
    @FunctionalInterface
    public interface Factory<T extends VeilResource<?>> {
        @Nullable
        ResourceFileEditor<T> open(VeilEditorEnvironment veilEditorEnvironment, T t);
    }

    void render();

    void loadFromDisk();

    boolean isClosed();

    T getResource();

    @Override // java.io.Closeable, java.lang.AutoCloseable, foundry.veil.api.flare.EffectHost
    default void close() {
    }

    default CompletableFuture<?> save(JsonElement element, VeilResourceManager resourceManager, VeilResource<?> resource) throws IOException {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        jsonWriter.setLenient(true);
        jsonWriter.setIndent("  ");
        Streams.write(element, jsonWriter);
        return save(stringWriter.toString().getBytes(StandardCharsets.UTF_8), resourceManager, resource);
    }

    default CompletableFuture<?> save(byte[] data, VeilResourceManager resourceManager, VeilResource<?> resource) {
        VeilResourceInfo info = resource.resourceInfo();
        return CompletableFuture.runAsync(() -> {
            try {
                if (info.isStatic()) {
                    throw new IOException("Read-only resource");
                }
                Path path = info.filePath();
                OutputStream os = Files.newOutputStream(path, new OpenOption[0]);
                try {
                    os.write(data);
                    if (os != null) {
                        os.close();
                    }
                    Path modPath = info.modResourcePath();
                    if (modPath == null) {
                        return;
                    }
                    InputStream is = Files.newInputStream(path, new OpenOption[0]);
                    try {
                        OutputStream os2 = Files.newOutputStream(modPath, StandardOpenOption.TRUNCATE_EXISTING);
                        try {
                            IOUtils.copyLarge(is, os2);
                            if (os2 != null) {
                                os2.close();
                            }
                            if (is != null) {
                                is.close();
                            }
                        } catch (Throwable th) {
                            if (os2 != null) {
                                try {
                                    os2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                Veil.LOGGER.error("Failed to write resource: {}", info.location(), e);
            }
        }, Util.ioPool()).thenRunAsync(() -> {
            try {
                resource.hotReload(resourceManager);
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        }, (Executor) Minecraft.getInstance()).exceptionally(e -> {
            while (e instanceof CompletionException) {
                e = e.getCause();
            }
            Veil.LOGGER.error("Failed to hot-swap resource: {}", info.location(), e);
            return null;
        });
    }
}
