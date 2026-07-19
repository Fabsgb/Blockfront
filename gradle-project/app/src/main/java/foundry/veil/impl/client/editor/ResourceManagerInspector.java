package foundry.veil.impl.client.editor;

import com.boehmod.bflib.common.ColorReferences;
import foundry.imgui.api.ImGuiMC;
import foundry.veil.VeilClient;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.impl.resource.VeilPackResources;
import foundry.veil.impl.resource.VeilResourceManagerImpl;
import foundry.veil.impl.resource.VeilResourceRenderer;
import foundry.veil.impl.resource.tree.VeilResourceFolder;
import imgui.ImGui;
import imgui.ImGuiListClipper;
import imgui.ImVec2;
import imgui.callback.ImListClipperCallback;
import imgui.type.ImString;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/ResourceManagerInspector.class */
@ApiStatus.Internal
public class ResourceManagerInspector extends SingleWindowInspector {
    public static final float ITEM_VERTICAL_PADDING = 3.0f;
    public static final Component TITLE = Component.translatable("inspector.veil.resource.title");
    public static final Component SEARCH = Component.translatable("inspector.veil.resource.hint.search");
    public static final Component ADD_TOOLTIP = Component.translatable("inspector.veil.resource.button.add_pack");
    public static final Component RELOAD_TOOLTIP = Component.translatable("inspector.veil.resource.button.reload");
    private CompletableFuture<?> reloadFuture;
    private final ImString searchText = new ImString();

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    public void renderComponents() {
        ImGui.setNextItemWidth(ImGui.getContentRegionAvailX() - 100.0f);
        ImGui.inputTextWithHint("##search", SEARCH.getString(), this.searchText);
        ImGui.sameLine();
        ImGui.pushFont(ImGuiMC.getFont(VeilImGuiUtil.ICON_FONT, false, false));
        ImGui.beginDisabled();
        ImGui.setNextItemWidth(44.0f);
        if (ImGui.button("\ued59")) {
        }
        ImGui.endDisabled();
        if (ImGui.isItemHovered()) {
            VeilImGuiUtil.setTooltip(ADD_TOOLTIP);
        }
        ImGui.sameLine();
        ImGui.setNextItemWidth(44.0f);
        ImGui.beginDisabled((this.reloadFuture == null || this.reloadFuture.isDone()) ? false : true);
        if (ImGui.button("\uf33f")) {
            this.reloadFuture = Minecraft.getInstance().reloadResourcePacks();
        }
        ImGui.endDisabled();
        if (ImGui.isItemHovered()) {
            VeilImGuiUtil.setTooltip(RELOAD_TOOLTIP);
        }
        ImGui.popFont();
        VeilResourceManagerImpl resourceManager = VeilClient.resourceManager();
        ImGui.pushStyleVar(11, 1.0f, 3.0f);
        ImGui.pushStyleVar(14, 3.0f, 0.0f);
        if (ImGui.beginListBox("##file_tree", ImGui.getContentRegionAvailX(), ImGui.getContentRegionAvailY())) {
            if (this.searchText.get().isBlank()) {
                List<VeilPackResources> packs = resourceManager.getAllPacks();
                for (int i = packs.size() - 1; i >= 0; i--) {
                    VeilPackResources pack = packs.get(i);
                    String modid = pack.getName();
                    int color = VeilImGuiUtil.colorOf(modid);
                    boolean open = ImGui.treeNodeEx("##" + modid, 3072);
                    ImGui.pushStyleColor(0, color);
                    ImGui.sameLine();
                    int icon = pack.getTexture();
                    if (icon != 0) {
                        float size = ImGui.getTextLineHeight();
                        ImVec2 cursorScreenPos = ImGui.getCursorScreenPos();
                        float minX = cursorScreenPos.x;
                        float minY = cursorScreenPos.y + 3.0f + 1.0f;
                        ImGui.getWindowDrawList().addImage(icon, minX, minY, minX + size, minY + size);
                        ImGui.setCursorScreenPos(minX + size + 3.0f + 1.0f, cursorScreenPos.y);
                    } else {
                        VeilImGuiUtil.icon(62755, color);
                        ImGui.sameLine();
                    }
                    ImGui.text(modid);
                    ImGui.popStyleColor();
                    if (open) {
                        renderFolderContents(pack.getRoot());
                        ImGui.treePop();
                    }
                }
            } else {
                Queue<VeilResourceFolder> folders = new ArrayDeque<>();
                final ObjectArrayList<VeilResource<?>> resources = new ObjectArrayList<>();
                Iterator<VeilPackResources> it = resourceManager.getAllPacks().iterator();
                while (it.hasNext()) {
                    folders.add(it.next().getRoot());
                }
                while (!folders.isEmpty()) {
                    VeilResourceFolder folder = folders.poll();
                    for (VeilResource<?> resource : folder.getResources()) {
                        VeilResourceInfo info = resource.resourceInfo();
                        if (!info.hidden() && info.location().toString().contains(this.searchText.get())) {
                            resources.add(resource);
                        }
                    }
                    folders.addAll(folder.getSubFolders());
                }
                ImGui.pushStyleVar(11, 4.0f, 4.0f);
                ImGuiListClipper.forEach(resources.size(), 22, new ImListClipperCallback(this) { // from class: foundry.veil.impl.client.editor.ResourceManagerInspector.1
                    public void accept(int index) {
                        VeilResource<?> resource2 = (VeilResource) resources.get(index);
                        float startX = ImGui.getCursorScreenPosX();
                        ImGui.selectable("##" + String.valueOf(resource2.resourceInfo().location()), false, 16, ImGui.getContentRegionAvailX(), 22.0f);
                        ImGui.setNextItemAllowOverlap();
                        ImGui.sameLine();
                        ImGui.setCursorScreenPos(startX, ImGui.getCursorScreenPosY());
                        VeilResourceRenderer.renderFilename(resource2, true);
                    }
                });
                ImGui.popStyleVar();
            }
            ImGui.endListBox();
        }
        ImGui.popStyleVar();
        ImGui.popStyleVar();
    }

    private int renderFolder(VeilResourceFolder folder) {
        boolean open = ImGui.treeNodeEx("##" + folder.getName(), 3072);
        ImGui.sameLine();
        ImGui.beginDisabled();
        ImGui.text("/");
        ImGui.endDisabled();
        ImGui.sameLine();
        ImGui.text(folder.getName());
        int count = 1;
        if (open) {
            count = 1 + renderFolderContents(folder);
            ImGui.treePop();
        }
        return count;
    }

    private int renderFolderContents(VeilResourceFolder folder) {
        int count = 0;
        ImVec2 cursorScreenPos = ImGui.getCursorScreenPos();
        for (VeilResourceFolder subFolder : folder.getSubFolders()) {
            count += renderFolder(subFolder);
        }
        ImGui.indent();
        final float cellHeight = ImGui.getTextLineHeight() + 6.0f;
        final List<VeilResource<?>> resources = new ArrayList<>(folder.getRenderResources());
        ImGuiListClipper.forEach(resources.size(), new ImListClipperCallback(this) { // from class: foundry.veil.impl.client.editor.ResourceManagerInspector.2
            public void accept(int index) {
                VeilResource<?> resource = (VeilResource) resources.get(index);
                float startX = ImGui.getCursorScreenPosX();
                ImGui.selectable("##" + String.valueOf(resource.resourceInfo().location()), false, 16, ImGui.getContentRegionAvailX(), cellHeight);
                ImGui.setNextItemAllowOverlap();
                ImGui.sameLine();
                ImVec2 selectableCursorScreenPos = ImGui.getCursorScreenPos();
                float shift = (cellHeight - ImGui.getTextLineHeight()) / 2.0f;
                ImGui.setCursorScreenPos(startX, selectableCursorScreenPos.y + shift);
                VeilResourceRenderer.renderFilename(resource, false);
                ImGui.setCursorScreenPos(startX, ImGui.getCursorScreenPosY() - shift);
            }
        });
        int count2 = count + resources.size();
        float lineX = cursorScreenPos.x - 4.0f;
        ImGui.getWindowDrawList().addRectFilled(lineX, cursorScreenPos.y, lineX + 1.5f, cursorScreenPos.y + (count2 * cellHeight), ColorReferences.COLOR_TOOL_TIP_BORDER_END);
        ImGui.unindent();
        return count2;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return RESOURCE_GROUP;
    }
}
