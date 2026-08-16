package foundry.veil.api.resource.editor;

import foundry.imgui.api.ImGuiMC;
import foundry.veil.Veil;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.ext.PackResourcesExtension;
import imgui.ImGui;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/editor/ResourceOverrideEditor.class */
@ApiStatus.Internal
public class ResourceOverrideEditor implements ResourceFileEditor<VeilResource<?>> {
    private static final Component NAME = Component.translatable("resource.veil.action.override");
    private final VeilEditorEnvironment environment;
    private final VeilResource<?> veilResource;
    private final List<Path> options = new ObjectArrayList();
    private boolean closed = false;
    private boolean opened = false;

    public ResourceOverrideEditor(VeilEditorEnvironment environment, VeilResource<?> veilResource) {
        this.environment = environment;
        this.veilResource = veilResource;
        VeilResourceManager resourceManager = this.environment.getResourceManager();
        for (PackResourcesExtension packResourcesExtension : resourceManager.clientResources().listPacks().toList()) {
            if (packResourcesExtension instanceof PackResourcesExtension) {
                PackResourcesExtension ext = packResourcesExtension;
                if (!ext.veil$isStatic()) {
                    List<Path> packRoots = ext.veil$getRawResourceRoots();
                    if (!packRoots.isEmpty()) {
                        ResourceLocation location = this.veilResource.resourceInfo().location();
                        for (Path devRoot : packRoots) {
                            this.options.add(devRoot.resolve(PackType.CLIENT_RESOURCES.getDirectory()).resolve(location.getNamespace()).resolve(location.getPath()));
                        }
                    }
                }
            }
        }
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() {
        if (!this.opened) {
            this.opened = true;
            ImGui.openPopup("##asset_override");
        }
        if (!ImGui.beginPopup("##asset_override")) {
            this.closed = true;
            return;
        }
        ImGuiMC.component(NAME);
        VeilResourceManager resourceManager = this.environment.getResourceManager();
        for (Path writePath : this.options) {
            if (ImGui.selectable(writePath.toString(), false, 16)) {
                Veil.LOGGER.info("Writing to {}", writePath);
                VeilResourceInfo info = this.veilResource.resourceInfo();
                try {
                    InputStream stream = info.open(resourceManager);
                    try {
                        Files.copy(stream, writePath, StandardCopyOption.REPLACE_EXISTING);
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (Throwable th) {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    Veil.LOGGER.error("Failed to copy file: {}", info.location(), e);
                }
            }
            ImGui.setNextItemAllowOverlap();
            ImGui.sameLine();
            ImGui.text(writePath.toString());
            ImGui.setNextItemAllowOverlap();
        }
        if (this.options.isEmpty()) {
            ImGui.textDisabled("No valid packs");
        }
        ImGui.endPopup();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return this.closed;
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public VeilResource<?> getResource() {
        return this.veilResource;
    }
}
