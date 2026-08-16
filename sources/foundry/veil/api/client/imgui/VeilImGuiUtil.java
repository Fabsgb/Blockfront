package foundry.veil.api.client.imgui;

import com.boehmod.bflib.common.ColorReferences;
import foundry.imgui.api.ImGuiMC;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.EditorManager;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.impl.client.imgui.AdvancedFboImGuiAreaImpl;
import imgui.ImFont;
import imgui.ImGui;
import imgui.ImVec4;
import java.util.function.Consumer;
import net.minecraft.client.StringSplitter;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/imgui/VeilImGuiUtil.class */
public class VeilImGuiUtil {
    public static final ResourceLocation ICON_FONT = Veil.veilPath("remixicon");

    public static void tooltip(String text) {
        ImGui.textColored(ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_TOP, "(?)");
        if (ImGui.isItemHovered()) {
            ImGui.beginTooltip();
            ImGui.pushTextWrapPos(ImGui.getFontSize() * 35.0f);
            ImGui.textColored(-1, text);
            ImGui.popTextWrapPos();
            ImGui.endTooltip();
        }
    }

    public static void setTooltip(FormattedText text) {
        ImGui.beginTooltip();
        ImGuiMC.component(text);
        ImGui.endTooltip();
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static void component(FormattedText text) {
        ImGuiMC.component(text);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static void component(FormattedText text, float wrapWidth) {
        ImGuiMC.component(text, wrapWidth);
    }

    public static void icon(int code) {
        ImGui.pushFont(ImGuiMC.getFont(ICON_FONT, false, false), 0.0f);
        ImGui.text(((char) code));
        ImGui.popFont();
    }

    public static void icon(int code, int color) {
        ImGui.pushFont(ImGuiMC.getFont(ICON_FONT, false, false), 0.0f);
        ImGui.textColored(color, ((char) code));
        ImGui.popFont();
    }

    public static void textCentered(String text, float width) {
        ImGui.setCursorPosX(ImGui.getCursorPosX() + ((width - ImGui.getFont().calcTextSizeAX(ImGui.getFontSize(), Float.MAX_VALUE, 0.0f, text)) / 2.0f));
        ImGui.text(text);
    }

    public static void resourceLocation(ResourceLocation loc) {
        ImGui.beginGroup();
        ImGui.textColored(colorOf(loc.getNamespace()), loc.getNamespace() + ":");
        ImGui.pushStyleVar(14, 0.0f, 0.0f);
        ImGui.sameLine();
        ImGui.text(loc.getPath());
        ImGui.popStyleVar();
        ImGui.endGroup();
        if (ImGui.beginPopupContextItem(String.valueOf(loc))) {
            if (ImGui.selectable("##copy_location")) {
                ImGui.setClipboardText(loc.toString());
            }
            ImGui.pushStyleVar(14, 0.0f, 0.0f);
            ImGui.setNextItemAllowOverlap();
            ImGui.sameLine();
            icon(60305);
            ImGui.sameLine();
            ImGui.popStyleVar();
            ImGui.text("Copy Location");
            ImGui.endPopup();
        }
    }

    public static int renderArea(int width, int height, Consumer<AdvancedFbo> renderer) {
        ImVec4 colors = ImGui.getStyle().getColors()[7];
        AdvancedFbo fbo = AdvancedFboImGuiAreaImpl.allocate(width, height);
        fbo.bind(true);
        fbo.clear(colors.x, colors.y, colors.z, colors.w, fbo.getClearMask());
        renderer.accept(fbo);
        AdvancedFbo.unbind();
        return fbo.getColorTextureAttachment(0).getId();
    }

    public static int colorOf(String modid) {
        int color = (modid.hashCode() & 11184810) + 4473924;
        int r = (int) (((color & 255) * 0.65f) + 53.0f);
        int g = (int) ((((color >> 8) & 255) * 0.65f) + 53.0f);
        int b = (int) ((((color >> 16) & 255) * 0.65f) + 53.0f);
        return (-16777216) | (r << 16) | (g << 8) | b;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static ImFont getStyleFont(Style style) {
        return ImGuiMC.getFont(Style.DEFAULT_FONT.equals(style.getFont()) ? EditorManager.DEFAULT_FONT : style.getFont(), style.isBold(), style.isItalic());
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static int getColor(int color) {
        ImVec4 colors = ImGui.getStyle().getColors()[color];
        return (((int) (colors.w * 255.0f)) << 24) | (((int) (colors.x * 255.0f)) << 16) | (((int) (colors.y * 255.0f)) << 8) | ((int) (colors.z * 255.0f));
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static StringSplitter getStringSplitter() {
        return ImGuiMC.getStringSplitter();
    }
}
