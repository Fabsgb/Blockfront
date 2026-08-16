package foundry.veil.impl.resource;

import foundry.imgui.api.ImGuiMC;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.impl.resource.action.OverrideAction;
import imgui.ImGui;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.nio.file.Path;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/VeilResourceRenderer.class */
@ApiStatus.Internal
public class VeilResourceRenderer {
    private static final Component COPY_PATH = Component.translatable("resource.veil.action.copy_path");
    private static final Component OPEN_FOLDER = Component.translatable("resource.veil.action.open_folder");

    public static void renderFilename(VeilResource<?> resource, boolean fullName) {
        ImGui.pushID(resource.hashCode());
        ImGui.beginGroup();
        resource.render(false, fullName);
        if (ImGui.beginDragDropSource(8)) {
            ImGui.setDragDropPayload("VEIL_RESOURCE", resource, 2);
            resource.render(true, fullName);
            ImGui.endDragDropSource();
        }
        ImGui.endGroup();
        ImGui.popID();
        VeilResourceInfo info = resource.resourceInfo();
        if (ImGui.beginPopupContextItem(String.valueOf(info.location()))) {
            ImGui.pushStyleVar(14, 2.0f, 2.0f);
            ObjectArrayList<VeilResourceAction<?>> actions = new ObjectArrayList<>(resource.getActions());
            actions.addFirst(new OverrideAction());
            if (ImGui.selectable("##copy_path")) {
                ImGui.setClipboardText(info.location().toString());
            }
            ImGui.pushStyleVar(14, 0.0f, 0.0f);
            ImGui.setNextItemAllowOverlap();
            ImGui.sameLine();
            VeilImGuiUtil.icon(60305);
            ImGui.sameLine();
            ImGui.popStyleVar();
            ImGuiMC.component(COPY_PATH);
            ImGui.beginDisabled(info.isStatic());
            if (ImGui.selectable("##open_folder")) {
                Path file = info.modResourcePath() != null ? info.modResourcePath() : info.filePath();
                if (file.getParent() != null) {
                    Util.getPlatform().openFile(file.getParent().toFile());
                }
            }
            ImGui.pushStyleVar(14, 0.0f, 0.0f);
            ImGui.setNextItemAllowOverlap();
            ImGui.sameLine();
            VeilImGuiUtil.icon(60591);
            ImGui.sameLine();
            ImGui.popStyleVar();
            ImGuiMC.component(OPEN_FOLDER);
            ImGui.endDisabled();
            for (int i = 0; i < actions.size(); i++) {
                VeilResourceAction action = (VeilResourceAction) actions.get(i);
                if (ImGui.selectable("##action" + i)) {
                    action.perform(VeilRenderSystem.renderer().getEditorManager(), resource);
                }
                ImGui.pushStyleVar(14, 0.0f, 0.0f);
                ImGui.setNextItemAllowOverlap();
                ImGui.sameLine();
                action.getIcon().ifPresent(icon -> {
                    VeilImGuiUtil.icon(icon);
                    ImGui.sameLine();
                });
                ImGui.popStyleVar();
                ImGuiMC.component(action.getName());
            }
            ImGui.popStyleVar();
            ImGui.endPopup();
        }
    }
}
