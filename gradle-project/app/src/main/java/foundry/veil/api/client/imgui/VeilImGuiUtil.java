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
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.StringSplitter;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.FormattedCharSink;
import net.minecraft.util.StringUtil;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/imgui/VeilImGuiUtil.class */
public class VeilImGuiUtil {
    private static final ImGuiCharSink IM_GUI_CHAR_SINK = new ImGuiCharSink();
    private static final StringSplitter IM_GUI_SPLITTER = new StringSplitter((charId, style) -> {
        return getStyleFont(style).getCharAdvance(charId);
    });
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
        component(text);
        ImGui.endTooltip();
    }

    public static void component(FormattedText text) {
        component(text, Float.POSITIVE_INFINITY);
    }

    public static void component(FormattedText text, float wrapWidth) {
        IM_GUI_CHAR_SINK.reset();
        for (FormattedCharSequence part : Language.getInstance().getVisualOrder(IM_GUI_SPLITTER.splitLines(text, (int) wrapWidth, Style.EMPTY))) {
            part.accept(IM_GUI_CHAR_SINK);
            IM_GUI_CHAR_SINK.finish();
            ImGui.newLine();
        }
    }

    public static void icon(int code) {
        ImGui.pushFont(ImGuiMC.getFont(ICON_FONT, false, false));
        ImGui.text(((char) code));
        ImGui.popFont();
    }

    public static void icon(int code, int color) {
        ImGui.pushFont(ImGuiMC.getFont(ICON_FONT, false, false));
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

    public static ImFont getStyleFont(Style style) {
        return ImGuiMC.getFont(Style.DEFAULT_FONT.equals(style.getFont()) ? EditorManager.DEFAULT_FONT : style.getFont(), style.isBold(), style.isItalic());
    }

    public static int getColor(int color) {
        ImVec4 colors = ImGui.getStyle().getColors()[color];
        return (((int) (colors.w * 255.0f)) << 24) | (((int) (colors.x * 255.0f)) << 16) | (((int) (colors.y * 255.0f)) << 8) | ((int) (colors.z * 255.0f));
    }

    public static StringSplitter getStringSplitter() {
        return IM_GUI_SPLITTER;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/imgui/VeilImGuiUtil$ImGuiCharSink.class */
    @ApiStatus.Internal
    private static class ImGuiCharSink implements FormattedCharSink {
        private ImFont font;
        private int textColor;
        private HoverEvent hoverEvent;
        private ClickEvent clickEvent;
        private final StringBuilder buffer = new StringBuilder();

        private ImGuiCharSink() {
            reset();
        }

        public void reset() {
            this.font = ImGui.getFont();
            this.textColor = VeilImGuiUtil.getColor(0);
            this.buffer.setLength(0);
            this.hoverEvent = null;
            this.clickEvent = null;
        }

        public boolean accept(int positionInCurrentSequence, Style style, int codePoint) {
            ImFont font = VeilImGuiUtil.getStyleFont(style);
            int styleColor = style.getColor() != null ? style.getColor().getValue() : this.textColor;
            if (font != this.font || styleColor != this.textColor || style.getHoverEvent() != this.hoverEvent || style.getClickEvent() != this.clickEvent) {
                if (!this.buffer.isEmpty()) {
                    finish();
                }
                this.font = VeilImGuiUtil.getStyleFont(style);
                this.textColor = styleColor;
                this.hoverEvent = style.getHoverEvent();
                this.clickEvent = style.getClickEvent();
            }
            this.buffer.appendCodePoint(codePoint);
            return true;
        }

        public void finish() {
            if (!this.buffer.isEmpty()) {
                ImGui.pushStyleVar(14, 0.0f, 0.0f);
                ImGui.pushFont(this.font);
                ImGui.textColored((-16777216) | ((this.textColor & 16711680) >> 16) | (this.textColor & 65280) | ((this.textColor & 255) << 16), this.buffer.toString());
                if (ImGui.isItemClicked() && this.clickEvent != null) {
                    handleClick();
                }
                if (ImGui.isItemHovered() && this.hoverEvent != null) {
                    handleHover();
                }
                ImGui.sameLine();
                ImGui.popFont();
                ImGui.popStyleVar();
                this.buffer.setLength(0);
            }
        }

        private void handleClick() {
            Minecraft minecraft = Minecraft.getInstance();
            String value = this.clickEvent.getValue();
            if (this.clickEvent.getAction() == ClickEvent.Action.OPEN_URL) {
                try {
                    URI uri = new URI(value);
                    String scheme = uri.getScheme();
                    if (scheme == null) {
                        throw new URISyntaxException(value, "Missing protocol");
                    }
                    if (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https")) {
                        throw new URISyntaxException(value, "Unsupported protocol: " + scheme.toLowerCase(Locale.ROOT));
                    }
                    Util.getPlatform().openUri(uri);
                    return;
                } catch (URISyntaxException e) {
                    Veil.LOGGER.error("Can't open url for {}", this.clickEvent, e);
                    return;
                }
            }
            if (this.clickEvent.getAction() == ClickEvent.Action.OPEN_FILE) {
                Util.getPlatform().openUri(new File(value).toURI());
                return;
            }
            if (this.clickEvent.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
                return;
            }
            if (this.clickEvent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                String s = StringUtil.filterText(this.clickEvent.getValue());
                if (s.startsWith("/")) {
                    LocalPlayer player = Minecraft.getInstance().player;
                    if (player != null && !player.connection.sendUnsignedCommand(s.substring(1))) {
                        Veil.LOGGER.error("Not allowed to run command with signed argument from click event: '{}'", s);
                        return;
                    }
                    return;
                }
                Veil.LOGGER.error("Failed to run command without '/' prefix from click event: '{}'", s);
                return;
            }
            if (this.clickEvent.getAction() == ClickEvent.Action.COPY_TO_CLIPBOARD) {
                minecraft.keyboardHandler.setClipboard(value);
            } else {
                Veil.LOGGER.error("Don't know how to handle {}", this.clickEvent);
            }
        }

        private void handleHover() {
            Minecraft minecraft = Minecraft.getInstance();
            HoverEvent.ItemStackInfo stack = (HoverEvent.ItemStackInfo) this.hoverEvent.getValue(HoverEvent.Action.SHOW_ITEM);
            if (stack != null) {
                ImGui.beginTooltip();
                List<Component> tooltip = Screen.getTooltipFromItem(minecraft, stack.getItemStack());
                for (Component line : tooltip) {
                    VeilImGuiUtil.component(line, ImGui.getFontSize() * 35.0f);
                }
                ImGui.endTooltip();
                return;
            }
            HoverEvent.EntityTooltipInfo entity = (HoverEvent.EntityTooltipInfo) this.hoverEvent.getValue(HoverEvent.Action.SHOW_ENTITY);
            if (entity != null) {
                if (minecraft.options.advancedItemTooltips) {
                    ImGui.beginTooltip();
                    List<Component> tooltip2 = entity.getTooltipLines();
                    for (Component line2 : tooltip2) {
                        VeilImGuiUtil.component(line2, ImGui.getFontSize() * 35.0f);
                    }
                    ImGui.endTooltip();
                    return;
                }
                return;
            }
            Component showText = (Component) this.hoverEvent.getValue(HoverEvent.Action.SHOW_TEXT);
            if (showText != null) {
                ImGui.beginTooltip();
                VeilImGuiUtil.component(showText, ImGui.getFontSize() * 35.0f);
                ImGui.endTooltip();
            }
        }
    }
}
