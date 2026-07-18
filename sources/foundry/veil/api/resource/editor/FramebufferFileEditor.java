package foundry.veil.api.resource.editor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.api.client.render.framebuffer.FramebufferDefinition;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.texture.TextureFilter;
import foundry.veil.api.molang.VeilMolang;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.FramebufferResource;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import imgui.ImDrawList;
import imgui.ImFont;
import imgui.ImFontGlyph;
import imgui.ImGui;
import imgui.ImGuiStyle;
import imgui.ImVec4;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import imgui.type.ImString;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/FramebufferFileEditor.class */
@ApiStatus.Internal
public class FramebufferFileEditor implements ResourceFileEditor<FramebufferResource> {
    private static final StringBuilder BUILDER = new StringBuilder();
    private static final MolangRuntime RUNTIME = MolangRuntime.runtime().setQuery("screen_width", MolangExpression.m8000of((Supplier<Float>) () -> {
        return Float.valueOf(Minecraft.getInstance().getWindow().getWidth());
    })).setQuery("screen_height", MolangExpression.m8000of((Supplier<Float>) () -> {
        return Float.valueOf(Minecraft.getInstance().getWindow().getHeight());
    })).create();
    private final VeilResourceManager resourceManager;
    private final FramebufferResource resource;
    private FramebufferDefinitionBuilder builder;
    private boolean useDepth;
    private int colorBuffers;
    private int attachmentIndex;
    private FramebufferAttachmentDefinition.Type type;
    private FramebufferAttachmentDefinition.Format format;
    private TextureFilter.Wrap wrapS;
    private TextureFilter.Wrap wrapT;
    private int levels;
    private final ImString widthInput = new ImString();
    private final ImString heightInput = new ImString();
    private final ImString formatInput = new ImString();
    private final ImBoolean linear = new ImBoolean();
    private final ImInt levelsInput = new ImInt();
    private final ImString name = new ImString();
    private final ImBoolean open = new ImBoolean(true);

    public FramebufferFileEditor(VeilEditorEnvironment environment, FramebufferResource resource) {
        this.resourceManager = environment.getResourceManager();
        this.resource = resource;
        loadFromDisk();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() throws JsonSyntaxException {
        float boxHeight;
        float boxWidth;
        ImGui.setWindowSize(800.0f, 600.0f, 8);
        if (ImGui.begin("Framebuffer Editor: " + this.resource.resourceInfo().fileName(), this.open, 256)) {
            float definitionWidth = 1.0f;
            float definitionHeight = 1.0f;
            try {
                definitionWidth = RUNTIME.resolve(this.builder.getWidth());
                definitionHeight = RUNTIME.resolve(this.builder.getHeight());
            } catch (MolangRuntimeException e) {
            }
            float lineHeight = ImGui.getTextLineHeightWithSpacing();
            if (definitionWidth >= definitionHeight) {
                boxWidth = ImGui.getContentRegionAvailX() / 2.0f;
                boxHeight = (boxWidth * definitionHeight) / definitionWidth;
                if (boxHeight > ImGui.getContentRegionAvailY() - 225.0f) {
                    boxHeight = ImGui.getContentRegionAvailY() - 225.0f;
                    boxWidth = Math.max(1.0f, (boxHeight * definitionWidth) / definitionHeight);
                }
            } else {
                boxHeight = ImGui.getContentRegionAvailY() / 2.0f;
                boxWidth = Math.max(1.0f, (boxHeight * definitionWidth) / definitionHeight);
            }
            ImGui.pushStyleVar(2, 0.0f, 0.0f);
            if (ImGui.beginChild("##size", boxWidth, boxHeight, true)) {
                FramebufferManager framebufferManager = VeilRenderSystem.renderer().getFramebufferManager();
                ResourceLocation id = FramebufferManager.FRAMEBUFFER_LISTER.fileToId(this.resource.resourceInfo().location());
                AdvancedFbo fbo = framebufferManager.getFramebuffer(id);
                if (fbo != null) {
                    int textureId = 0;
                    if (this.attachmentIndex == 0) {
                        if (fbo.isDepthTextureAttachment()) {
                            textureId = fbo.getDepthTextureAttachment().getId();
                        }
                    } else if (fbo.isColorTextureAttachment(this.attachmentIndex - 1)) {
                        textureId = fbo.getColorTextureAttachment(this.attachmentIndex - 1).getId();
                    }
                    if (textureId > 0) {
                        ImGui.image(textureId, boxWidth, boxHeight, 0.0f, 1.0f, 1.0f, 0.0f);
                    }
                }
            }
            ImGui.endChild();
            ImGui.popStyleVar();
            VeilImGuiUtil.textCentered(Integer.toString((int) definitionWidth), boxWidth);
            if (ImGui.beginChild("##panel", ImGui.getContentRegionAvailX() / 2.0f, ImGui.getContentRegionAvailY())) {
                ImGui.text("Framebuffer Settings:");
                renderFramebufferSettings();
                ImGui.newLine();
                ImGui.text("Attachment Settings:");
                renderAttachmentSettings();
            }
            ImGui.endChild();
            String heightString = Integer.toString((int) definitionHeight);
            ImFont font = ImGui.getFont();
            float width = font.calcTextSizeAX(ImGui.getFontSize(), Float.MAX_VALUE, 0.0f, heightString);
            ImGui.setCursorPos(ImGui.getCursorStartPosX() + boxWidth, ImGui.getCursorStartPosY() + (boxHeight / 2.0f) + (width / 2.0f));
            drawVerticalText(heightString);
            ImGui.setCursorPos(ImGui.getCursorStartPosX() + (ImGui.getContentRegionMaxX() / 2.0f) + lineHeight, ImGui.getCursorStartPosY());
            ImGui.beginGroup();
            if (ImGui.beginListBox("##buffers", ImGui.getContentRegionAvailX(), (ImGui.getContentRegionAvailY() - ImGui.getFrameHeight()) - (ImGui.getStyle().getFramePaddingY() * 2.0f))) {
                float itemWidth = ImGui.getContentRegionAvailX();
                if (this.useDepth) {
                    if (ImGui.invisibleButton("##depth", itemWidth, lineHeight * 4.0f)) {
                        setAttachment(0);
                    }
                    drawBuffer("Depth Buffer", this.builder.getOrCreateDepthBuffer(), itemWidth, this.attachmentIndex == 0);
                }
                for (int i = 0; i < this.colorBuffers; i++) {
                    if (ImGui.invisibleButton("##color" + i, itemWidth, lineHeight * 4.0f)) {
                        setAttachment(i + 1);
                    }
                    drawBuffer("Color Buffer " + i, this.builder.getOrCreateColorBuffer(i), itemWidth, this.attachmentIndex == i + 1);
                }
                ImGui.endListBox();
            }
            if (ImGui.checkbox("Use Depth", this.useDepth)) {
                this.useDepth = !this.useDepth;
                if (this.attachmentIndex == 0 && !this.useDepth) {
                    setAttachment(1);
                }
                save();
            }
            ImGui.sameLine();
            if (ImGui.checkbox("Auto Clear", this.builder.isAutoClear())) {
                this.builder.setAutoClear(!this.builder.isAutoClear());
                save();
            }
            ImGui.sameLine();
            ImGui.beginDisabled(this.colorBuffers >= this.builder.colorBuffers.length);
            if (ImGui.button("+") && this.colorBuffers < this.builder.colorBuffers.length) {
                this.colorBuffers++;
                setAttachment(this.colorBuffers);
                save();
            }
            ImGui.endDisabled();
            ImGui.sameLine();
            ImGui.beginDisabled(this.colorBuffers <= 1);
            if (ImGui.button("-") && this.colorBuffers > 1) {
                this.colorBuffers--;
                this.builder.setColorBuffer(this.attachmentIndex - 1, null);
                setAttachment(Math.min(this.attachmentIndex, this.colorBuffers));
                save();
            }
            ImGui.endDisabled();
            ImGui.endGroup();
        }
        ImGui.end();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
        BufferedReader reader;
        DataResult<FramebufferDefinition> result;
        try {
            reader = this.resource.resourceInfo().openAsReader(this.resourceManager);
            try {
                result = FramebufferDefinition.CODEC.parse(JsonOps.INSTANCE, JsonParser.parseReader(reader));
            } finally {
            }
        } catch (IOException e) {
            Veil.LOGGER.error("Failed to open resource: {}", this.resource.resourceInfo().location(), e);
            this.builder = new FramebufferDefinitionBuilder();
        }
        if (result.error().isPresent()) {
            throw new JsonParseException(((DataResult.Error) result.error().get()).message());
        }
        this.builder = new FramebufferDefinitionBuilder((FramebufferDefinition) result.result().orElseThrow());
        if (reader != null) {
            reader.close();
        }
        if (this.attachmentIndex == 0 && this.builder.getDepthBuffer() == null) {
            this.attachmentIndex++;
        }
        FramebufferAttachmentDefinition[] colorBuffers = this.builder.getColorBuffers();
        this.useDepth = this.builder.getDepthBuffer() != null;
        this.colorBuffers = 0;
        for (FramebufferAttachmentDefinition colorBuffer : colorBuffers) {
            if (colorBuffer != null) {
                this.colorBuffers++;
            }
        }
        updateSize();
        setAttachment(Math.min(this.attachmentIndex, (this.useDepth ? 1 : 0) + this.colorBuffers));
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return !this.open.get();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public FramebufferResource getResource() {
        return this.resource;
    }

    private static void drawBuffer(String name, FramebufferAttachmentDefinition attachment, float width, boolean selected) {
        ImGuiStyle style = ImGui.getStyle();
        float lineHeight = ImGui.getTextLineHeightWithSpacing();
        boolean hovered = ImGui.isItemHovered();
        boolean active = selected || ImGui.isItemActive();
        ImGui.sameLine();
        ImGui.setCursorPosX(ImGui.getCursorStartPosX());
        ImVec4 col = new ImVec4();
        style.getColor(active ? 23 : hovered ? 22 : 21, col);
        int colorU32 = ImGui.getColorU32(col.x, col.y, col.z, col.w);
        float x = ImGui.getCursorScreenPosX();
        float y = ImGui.getCursorScreenPosY();
        ImGui.getWindowDrawList().addRectFilled(x, y, x + width, y + (lineHeight * 4.0f), colorU32);
        ImGui.setCursorPosX(ImGui.getCursorPosX() + style.getFramePaddingX());
        ImGui.beginGroup();
        boolean texture = attachment.type() == FramebufferAttachmentDefinition.Type.TEXTURE;
        text(builder -> {
            builder.append(name);
            if (attachment.name() != null) {
                builder.append(" (").append(attachment.name()).append(")");
            }
        });
        text(builder2 -> {
            builder2.append(attachment.type().getDisplayName());
            if (texture) {
                builder2.append(attachment.filter().blur() ? " Linear" : " Nearest");
            }
        });
        text(builder3 -> {
            builder3.append(attachment.format().name());
        });
        text(builder4 -> {
            builder4.append(attachment.levels()).append(texture ? " Mipmaps" : " Samples");
        });
        ImGui.endGroup();
    }

    private static void text(Consumer<StringBuilder> text) {
        text.accept(BUILDER);
        ImGui.text(BUILDER.toString());
        BUILDER.setLength(0);
    }

    private static void drawVerticalText(String next) {
        ImFont font = ImGui.getFont();
        float pad = ImGui.getStyle().getFramePaddingX();
        float posX = ImGui.getCursorScreenPosX() + pad;
        float posY = ImGui.getCursorScreenPosY() + pad;
        ImDrawList drawList = ImGui.getWindowDrawList();
        int length = next.length();
        drawList.primReserve(6 * length, 4 * length);
        for (int i = 0; i < length; i++) {
            int codePoint = next.codePointAt(i);
            ImFontGlyph glyph = font.findGlyph(codePoint);
            posY -= font.getCharAdvance(codePoint);
            drawList.primQuadUV((int) (posX + glyph.getY1()), (int) (posY + glyph.getX0()), (int) (posX + glyph.getY1()), (int) (posY + glyph.getX1()), (int) (posX + glyph.getY0()), (int) (posY + glyph.getX1()), (int) (posX + glyph.getY0()), (int) (posY + glyph.getX0()), glyph.getU1(), glyph.getV1(), glyph.getU0(), glyph.getV1(), glyph.getU0(), glyph.getV0(), glyph.getU1(), glyph.getV0(), -1);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    private void renderFramebufferSettings() throws JsonSyntaxException {
        if (ImGui.inputText("Width", this.widthInput, 64)) {
            try {
                this.builder.setWidth(VeilMolang.get().compile(this.widthInput.get()));
            } catch (MolangSyntaxException e) {
            }
            updateSize();
            save();
        }
        if (ImGui.inputText("Height", this.heightInput, 64)) {
            try {
                this.builder.setHeight(VeilMolang.get().compile(this.heightInput.get()));
            } catch (MolangSyntaxException e2) {
            }
            updateSize();
            save();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    private void renderAttachmentSettings() throws JsonSyntaxException {
        if (ImGui.beginCombo("Type", this.type.getDisplayName())) {
            for (FramebufferAttachmentDefinition.Type type : FramebufferAttachmentDefinition.Type.values()) {
                if (ImGui.selectable(type.getDisplayName())) {
                    this.type = type;
                    saveAttachment();
                }
            }
            ImGui.endCombo();
        }
        if (ImGui.inputText("Format", this.formatInput, 64)) {
            try {
                this.format = FramebufferAttachmentDefinition.Format.valueOf(this.formatInput.get().toUpperCase(Locale.ROOT));
                saveAttachment();
            } catch (IllegalArgumentException e) {
            }
            this.formatInput.set(this.format.name());
        }
        ImGui.beginDisabled(this.type == FramebufferAttachmentDefinition.Type.RENDER_BUFFER);
        if (ImGui.checkbox("Linear", this.linear)) {
            saveAttachment();
        }
        if (ImGui.beginCombo("Wrap X", this.wrapS.name())) {
            for (TextureFilter.Wrap wrap : TextureFilter.Wrap.values()) {
                if (ImGui.selectable(wrap.name())) {
                    this.wrapS = wrap;
                    saveAttachment();
                }
            }
            ImGui.endCombo();
        }
        if (ImGui.beginCombo("Wrap Y", this.wrapT.name())) {
            for (TextureFilter.Wrap wrap2 : TextureFilter.Wrap.values()) {
                if (ImGui.selectable(wrap2.name())) {
                    this.wrapT = wrap2;
                    saveAttachment();
                }
            }
            ImGui.endCombo();
        }
        ImGui.endDisabled();
        if (ImGui.sliderInt(this.type == FramebufferAttachmentDefinition.Type.RENDER_BUFFER ? "Samples" : "Mipmaps", this.levelsInput.getData(), 1, VeilRenderSystem.maxSamples())) {
            this.levels = this.levelsInput.get();
            saveAttachment();
        }
        if (ImGui.inputText("Name", this.name, 64)) {
            saveAttachment();
        }
    }

    private void updateSize() {
        String width = this.builder.getWidth().toString();
        if (width.startsWith("return")) {
            this.widthInput.set(width.substring(7));
        } else {
            this.widthInput.set(width);
        }
        String height = this.builder.getHeight().toString();
        if (height.startsWith("return")) {
            this.heightInput.set(height.substring(7));
        } else {
            this.heightInput.set(height);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    private void saveAttachment() throws JsonSyntaxException {
        TextureFilter filter = new TextureFilter(this.linear.get(), false, 1.0f, null, this.wrapS, this.wrapT, TextureFilter.Wrap.CLAMP_TO_BORDER, -16777216, TextureFilter.EdgeType.FLOAT, false);
        String name = this.name.get().isBlank() ? null : this.name.get();
        if (this.attachmentIndex == 0) {
            this.builder.setDepthBuffer(new FramebufferAttachmentDefinition(this.type, this.format, true, filter, this.levels, name));
        } else {
            this.builder.setColorBuffer(this.attachmentIndex - 1, new FramebufferAttachmentDefinition(this.type, this.format, false, filter, this.levels, name));
        }
        save();
    }

    private void setAttachment(int attachmentIndex) {
        FramebufferAttachmentDefinition buffer;
        this.attachmentIndex = attachmentIndex;
        if (this.attachmentIndex == 0) {
            buffer = this.builder.getOrCreateDepthBuffer();
        } else {
            FramebufferAttachmentDefinition[] colorBuffers = this.builder.getColorBuffers();
            if (attachmentIndex < 1 || attachmentIndex >= colorBuffers.length + 1) {
                return;
            } else {
                buffer = this.builder.getOrCreateColorBuffer(attachmentIndex - 1);
            }
        }
        this.type = buffer.type();
        this.format = buffer.format();
        this.formatInput.set(this.format.name());
        TextureFilter filter = buffer.filter();
        this.linear.set(filter.blur());
        this.wrapS = filter.wrapX();
        this.wrapT = filter.wrapY();
        this.levels = buffer.levels();
        this.levelsInput.set(this.levels);
        if (buffer.name() != null) {
            this.name.set(buffer.name());
        } else {
            this.name.clear();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
    private void save() throws JsonSyntaxException {
        try {
            FramebufferDefinition definition = this.builder.create(this.useDepth, this.colorBuffers);
            DataResult<JsonElement> result = FramebufferDefinition.CODEC.encodeStart(JsonOps.INSTANCE, definition);
            if (result.error().isPresent()) {
                throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
            }
            save((JsonElement) result.getOrThrow(), this.resourceManager, this.resource);
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to save resource: {}", this.resource.resourceInfo().location(), e);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/FramebufferFileEditor$FramebufferDefinitionBuilder.class */
    private static class FramebufferDefinitionBuilder {
        private MolangExpression width;
        private MolangExpression height;
        private final FramebufferAttachmentDefinition[] colorBuffers;

        @Nullable
        private FramebufferAttachmentDefinition depthBuffer;
        private boolean autoClear;

        public FramebufferDefinitionBuilder() {
            this.width = FramebufferDefinition.DEFAULT_WIDTH;
            this.height = FramebufferDefinition.DEFAULT_HEIGHT;
            this.colorBuffers = new FramebufferAttachmentDefinition[VeilRenderSystem.maxColorAttachments()];
            this.depthBuffer = null;
            this.autoClear = true;
        }

        public FramebufferDefinitionBuilder(FramebufferDefinition definition) {
            this.width = definition.width();
            this.height = definition.height();
            this.colorBuffers = (FramebufferAttachmentDefinition[]) Arrays.copyOf(definition.colorBuffers(), VeilRenderSystem.maxColorAttachments());
            this.depthBuffer = definition.depthBuffer();
            this.autoClear = definition.autoClear();
        }

        public void setWidth(MolangExpression width) {
            this.width = width;
        }

        public void setHeight(MolangExpression height) {
            this.height = height;
        }

        public void setColorBuffer(int index, @Nullable FramebufferAttachmentDefinition colorBuffer) {
            this.colorBuffers[index] = colorBuffer;
            if (colorBuffer == null && index < this.colorBuffers.length - 1) {
                System.arraycopy(this.colorBuffers, index + 1, this.colorBuffers, index, (this.colorBuffers.length - index) - 1);
            }
        }

        public void setDepthBuffer(@Nullable FramebufferAttachmentDefinition depthBuffer) {
            this.depthBuffer = depthBuffer;
        }

        public void setAutoClear(boolean autoClear) {
            this.autoClear = autoClear;
        }

        public MolangExpression getWidth() {
            return this.width;
        }

        public MolangExpression getHeight() {
            return this.height;
        }

        public FramebufferAttachmentDefinition getOrCreateColorBuffer(int i) {
            FramebufferAttachmentDefinition buffer = this.colorBuffers[i];
            if (buffer != null) {
                return buffer;
            }
            FramebufferAttachmentDefinition[] framebufferAttachmentDefinitionArr = this.colorBuffers;
            FramebufferAttachmentDefinition framebufferAttachmentDefinition = new FramebufferAttachmentDefinition(FramebufferAttachmentDefinition.Type.TEXTURE, FramebufferAttachmentDefinition.Format.RGBA8, false, TextureFilter.CLAMP, 1, null);
            framebufferAttachmentDefinitionArr[i] = framebufferAttachmentDefinition;
            return framebufferAttachmentDefinition;
        }

        public FramebufferAttachmentDefinition getOrCreateDepthBuffer() {
            return (FramebufferAttachmentDefinition) Objects.requireNonNullElseGet(this.depthBuffer, () -> {
                FramebufferAttachmentDefinition framebufferAttachmentDefinition = new FramebufferAttachmentDefinition(FramebufferAttachmentDefinition.Type.TEXTURE, FramebufferAttachmentDefinition.Format.DEPTH_COMPONENT, true, TextureFilter.CLAMP, 1, null);
                this.depthBuffer = framebufferAttachmentDefinition;
                return framebufferAttachmentDefinition;
            });
        }

        public FramebufferAttachmentDefinition[] getColorBuffers() {
            return this.colorBuffers;
        }

        @Nullable
        public FramebufferAttachmentDefinition getDepthBuffer() {
            return this.depthBuffer;
        }

        public boolean isAutoClear() {
            return this.autoClear;
        }

        public FramebufferDefinition create(boolean useDepth, int buffers) {
            FramebufferAttachmentDefinition[] colorBuffers = (FramebufferAttachmentDefinition[]) IntStream.range(0, buffers).mapToObj(this::getOrCreateColorBuffer).toArray(x$0 -> {
                return new FramebufferAttachmentDefinition[x$0];
            });
            return new FramebufferDefinition(this.width, this.height, colorBuffers, useDepth ? getOrCreateDepthBuffer() : null, this.autoClear);
        }
    }
}
