package foundry.veil.impl.client.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.api.client.util.TextureDownloader;
import foundry.veil.api.compat.IrisCompat;
import foundry.veil.ext.iris.IrisRenderTargetExtension;
import imgui.ImGui;
import imgui.type.ImBoolean;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/FramebufferInspector.class */
@ApiStatus.Internal
public class FramebufferInspector extends SingleWindowInspector {
    public static final Component TITLE = Component.translatable("inspector.veil.framebuffer.title");
    private static final Component SAVE = Component.translatable("gui.veil.save");
    private static final Component SHOW_ALT = Component.translatable("inspector.veil.framebuffer.iris.show_alt");
    private static final Component SHOW_ALT_TOOLTIP = Component.translatable("inspector.veil.framebuffer.iris.show_alt.desc");
    private final Set<ResourceLocation> framebuffers = new TreeSet();
    private final ImBoolean showAlt = new ImBoolean();
    private AdvancedFbo downloadFramebuffer;
    private IrisRenderTargetExtension downloadRenderTarget;

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return RENDERER_GROUP;
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    protected void renderComponents() {
        VeilRenderer renderer = VeilRenderSystem.renderer();
        if (ImGui.beginTabBar("##framebuffers")) {
            this.framebuffers.addAll(renderer.getFramebufferManager().getFramebuffers().keySet());
            Iterator<ResourceLocation> it = this.framebuffers.iterator();
            while (it.hasNext()) {
                drawBuffers(it.next(), fbo -> {
                    this.downloadFramebuffer = fbo;
                });
            }
            if (IrisCompat.INSTANCE != null) {
                Map<String, IrisRenderTargetExtension> renderTargets = IrisCompat.INSTANCE.getRenderTargets();
                this.framebuffers.clear();
                for (String name : renderTargets.keySet()) {
                    this.framebuffers.add(ResourceLocation.fromNamespaceAndPath("iris", name));
                }
                for (ResourceLocation id : this.framebuffers) {
                    drawRenderTarget(id, renderTargets.get(id.getPath()), renderTarget -> {
                        this.downloadRenderTarget = renderTarget;
                    });
                }
            }
            this.framebuffers.clear();
            ImGui.endTabBar();
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void renderLast() {
        super.renderLast();
        if (this.downloadFramebuffer != null) {
            try {
                Minecraft client = Minecraft.getInstance();
                Path outputFolder = Paths.get(client.gameDirectory.toURI()).resolve("debug-out").resolve("veil-framebuffer");
                if (!Files.exists(outputFolder, new LinkOption[0])) {
                    Files.createDirectories(outputFolder, new FileAttribute[0]);
                } else {
                    Files.walkFileTree(outputFolder, new SimpleFileVisitor<Path>(this) { // from class: foundry.veil.impl.client.editor.FramebufferInspector.1
                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
                List<CompletableFuture<?>> result = new LinkedList<>();
                for (int i = 0; i < this.downloadFramebuffer.getColorAttachments(); i++) {
                    if (this.downloadFramebuffer.isColorTextureAttachment(i)) {
                        AdvancedFboTextureAttachment attachment = this.downloadFramebuffer.getColorTextureAttachment(i);
                        String name = attachment.getName() != null ? attachment.getName() : "Attachment " + i;
                        result.add(TextureDownloader.save(name, outputFolder, attachment.getId(), true));
                    }
                }
                if (this.downloadFramebuffer.isDepthTextureAttachment()) {
                    AdvancedFboTextureAttachment attachment2 = this.downloadFramebuffer.getDepthTextureAttachment();
                    String name2 = attachment2.getName() != null ? attachment2.getName() : "Depth Attachment";
                    result.add(TextureDownloader.save(name2, outputFolder, attachment2.getId(), true));
                }
                CompletableFuture.allOf((CompletableFuture[]) result.toArray(new CompletableFuture[0])).thenRunAsync(() -> {
                    Util.getPlatform().openFile(outputFolder.toFile());
                }, (Executor) client);
            } catch (Exception e) {
                Veil.LOGGER.error("Failed to download framebuffer", e);
            }
            this.downloadFramebuffer = null;
        }
        if (this.downloadRenderTarget != null) {
            try {
                Minecraft client2 = Minecraft.getInstance();
                Path outputFolder2 = Paths.get(client2.gameDirectory.toURI()).resolve("debug-out").resolve("iris-rendertarget");
                if (!Files.exists(outputFolder2, new LinkOption[0])) {
                    Files.createDirectories(outputFolder2, new FileAttribute[0]);
                } else {
                    Files.walkFileTree(outputFolder2, new SimpleFileVisitor<Path>(this) { // from class: foundry.veil.impl.client.editor.FramebufferInspector.2
                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
                String name3 = this.downloadRenderTarget.veil$getName();
                CompletableFuture.allOf(TextureDownloader.save(name3 + " Main", outputFolder2, this.downloadRenderTarget.veil$getMainTexture(), true), TextureDownloader.save(name3 + " Alt", outputFolder2, this.downloadRenderTarget.veil$getAltTexture(), true)).thenRunAsync(() -> {
                    Util.getPlatform().openFile(outputFolder2.toFile());
                }, (Executor) client2);
            } catch (Exception e2) {
                Veil.LOGGER.error("Failed to download iris render target", e2);
            }
            this.downloadRenderTarget = null;
        }
    }

    private void drawBuffers(ResourceLocation id, @Nullable Consumer<AdvancedFbo> saveCallback) {
        AdvancedFbo buffer = VeilRenderSystem.renderer().getFramebufferManager().getFramebuffer(id);
        ImGui.beginDisabled(buffer == null);
        if (ImGui.beginTabItem(id.toString())) {
            if (buffer != null) {
                int columns = (int) Math.ceil(Math.sqrt(buffer.getColorAttachments() + (buffer.isDepthTextureAttachment() ? 1 : 0)));
                float width = (ImGui.getContentRegionAvailX() / columns) - ImGui.getStyle().getItemSpacingX();
                float height = (width * buffer.getHeight()) / buffer.getWidth();
                int i = 0;
                while (i < buffer.getColorAttachments()) {
                    if (buffer.isColorTextureAttachment(i)) {
                        if (i % columns != 0) {
                            ImGui.sameLine();
                        }
                        ImGui.beginGroup();
                        AdvancedFboTextureAttachment attachment = buffer.getColorTextureAttachment(i);
                        ImGui.text(getAttachmentName(i, attachment.getId(), attachment.getName()));
                        ImGui.image(attachment.getId(), width, height, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.5f);
                        ImGui.endGroup();
                    }
                    i++;
                }
                if (buffer.isDepthTextureAttachment()) {
                    if (i % columns != 0) {
                        ImGui.sameLine();
                    }
                    ImGui.beginGroup();
                    AdvancedFboTextureAttachment attachment2 = buffer.getDepthTextureAttachment();
                    ImGui.text(getAttachmentName(-1, attachment2.getId(), attachment2.getName()));
                    ImGui.image(attachment2.getId(), width, height, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.5f);
                    ImGui.endGroup();
                }
                if (saveCallback != null && ImGui.button(SAVE.getString(), ImGui.getContentRegionAvailX() - 4.0f, 0.0f)) {
                    saveCallback.accept(buffer);
                }
            }
            ImGui.endTabItem();
        }
        ImGui.endDisabled();
    }

    private void drawRenderTarget(ResourceLocation id, @Nullable IrisRenderTargetExtension renderTarget, @Nullable Consumer<IrisRenderTargetExtension> saveCallback) {
        ImGui.beginDisabled(renderTarget == null);
        if (ImGui.beginTabItem(id.toString())) {
            ImGui.checkbox(SHOW_ALT.getString(), this.showAlt);
            if (ImGui.isItemHovered()) {
                VeilImGuiUtil.setTooltip(SHOW_ALT_TOOLTIP);
            }
            if (renderTarget != null) {
                float width = ImGui.getContentRegionAvailX() - ImGui.getStyle().getItemSpacingX();
                float height = (width * renderTarget.veil$getHeight()) / renderTarget.veil$getWidth();
                int texture = this.showAlt.get() ? renderTarget.veil$getAltTexture() : renderTarget.veil$getMainTexture();
                ImGui.beginGroup();
                ImGui.text(getAttachmentName(0, texture, this.showAlt.get() ? "Alt" : "Main"));
                ImGui.image(texture, width, height, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.5f);
                ImGui.endGroup();
                if (saveCallback != null && ImGui.button(SAVE.getString(), ImGui.getContentRegionAvailX() - 4.0f, 0.0f)) {
                    saveCallback.accept(renderTarget);
                }
            }
            ImGui.endTabItem();
        }
        ImGui.endDisabled();
    }

    private static String getAttachmentName(int index, int id, @Nullable String name) {
        RenderSystem.bindTexture(id);
        StringBuilder attachmentName = new StringBuilder(name != null ? name : index == -1 ? I18n.get("inspector.veil.framebuffer.depth_attachment", new Object[0]) : I18n.get("inspector.veil.framebuffer.color_attachment", new Object[]{Integer.valueOf(index)}));
        int internalFormat = GL11C.glGetTexLevelParameteri(3553, 0, 4099);
        for (FramebufferAttachmentDefinition.Format format : FramebufferAttachmentDefinition.Format.values()) {
            if (internalFormat == format.getInternalFormat()) {
                attachmentName.append(" (").append(format.name()).append(")");
                return attachmentName.toString();
            }
        }
        attachmentName.append(" (0x%X)".formatted(Integer.valueOf(internalFormat)));
        return attachmentName.toString();
    }
}
