package foundry.veil.impl.client.editor;

import foundry.veil.Veil;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.post.PostProcessingManager;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import imgui.ImGui;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/PostInspector.class */
@ApiStatus.Internal
public class PostInspector extends SingleWindowInspector {
    public static final Component TITLE = Component.translatable("inspector.veil.post.title");
    private static final Component INACTIVE = Component.translatable("inspector.veil.post.inactive");
    private static final Component ACTIVE = Component.translatable("inspector.veil.post.active");
    private final Set<ResourceLocation> removedPipelines = new HashSet(1);

    public static boolean isInternal(ResourceLocation id) {
        return Veil.MODID.equals(id.getNamespace()) && id.getPath().startsWith("core/");
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void render() {
        ImGui.setNextWindowSize(600.0f, 0.0f);
        super.render();
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    public void renderComponents() {
        this.removedPipelines.clear();
        PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
        float availableWidth = ImGui.getContentRegionAvailX();
        ImGui.setNextItemWidth(availableWidth / 2.0f);
        ImGui.beginGroup();
        VeilImGuiUtil.component(INACTIVE);
        if (ImGui.beginListBox("##available_pipelines", availableWidth / 2.0f, 0.0f)) {
            for (ResourceLocation entry : postProcessingManager.getPipelines()) {
                if (!postProcessingManager.isActive(entry) && !isInternal(entry)) {
                    VeilImGuiUtil.resourceLocation(entry);
                    if (ImGui.beginDragDropSource(8)) {
                        ImGui.setDragDropPayload("INACTIVE_POST_PIPELINE", entry, 2);
                        VeilImGuiUtil.resourceLocation(entry);
                        ImGui.endDragDropSource();
                    }
                }
            }
            ImGui.endListBox();
        }
        if (ImGui.beginDragDropTarget()) {
            ResourceLocation payload = (ResourceLocation) ImGui.acceptDragDropPayload("ACTIVE_POST_PIPELINE");
            if (payload != null) {
                this.removedPipelines.add(payload);
            }
            ImGui.endDragDropTarget();
        }
        ImGui.endGroup();
        ImGui.sameLine();
        ImGui.setNextItemWidth(availableWidth / 2.0f);
        ImGui.beginGroup();
        VeilImGuiUtil.component(ACTIVE);
        if (ImGui.beginListBox("##shaders", availableWidth / 2.0f, 0.0f)) {
            List<PostProcessingManager.ProfileEntry> pipelines = postProcessingManager.getActivePipelines();
            ResourceLocation[] names = new ResourceLocation[pipelines.size()];
            int i = 0;
            ListIterator<PostProcessingManager.ProfileEntry> iterator = pipelines.listIterator(pipelines.size());
            while (iterator.hasPrevious()) {
                int i2 = i;
                i++;
                names[i2] = iterator.previous().getPipeline();
            }
            for (int j = 0; j < names.length; j++) {
                ResourceLocation id = names[j];
                ImGui.pushID(id.toString());
                VeilImGuiUtil.resourceLocation(id);
                if (ImGui.beginDragDropSource(8)) {
                    ImGui.setDragDropPayload("ACTIVE_POST_PIPELINE", id, 2);
                    VeilImGuiUtil.resourceLocation(id);
                    ImGui.endDragDropSource();
                }
                if (ImGui.beginDragDropTarget()) {
                    ResourceLocation payload2 = (ResourceLocation) ImGui.acceptDragDropPayload("ACTIVE_POST_PIPELINE");
                    if (payload2 != null) {
                        int oldIndex = 0;
                        while (oldIndex < names.length && !names[oldIndex].equals(payload2)) {
                            oldIndex++;
                        }
                        for (int k = 0; k < names.length; k++) {
                            if (k == j) {
                                postProcessingManager.add(1001 + k, payload2);
                            } else if (k == oldIndex) {
                                postProcessingManager.add(1001 + k, id);
                            } else {
                                postProcessingManager.add(1001 + k, names[k]);
                            }
                        }
                    }
                    ImGui.endDragDropTarget();
                }
                ImGui.popID();
            }
            ImGui.endListBox();
        }
        if (ImGui.beginDragDropTarget()) {
            ResourceLocation payload3 = (ResourceLocation) ImGui.acceptDragDropPayload("INACTIVE_POST_PIPELINE");
            if (payload3 != null) {
                postProcessingManager.add(ShaderInjectionDefinition.DEFAULT_PRIORITY, payload3);
            }
            ImGui.endDragDropTarget();
        }
        ImGui.endGroup();
        Iterator<ResourceLocation> it = this.removedPipelines.iterator();
        while (it.hasNext()) {
            postProcessingManager.remove(it.next());
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return RENDERER_GROUP;
    }
}
