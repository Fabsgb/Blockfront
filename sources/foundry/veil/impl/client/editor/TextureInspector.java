package foundry.veil.impl.client.editor;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.TextureUtil;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import foundry.veil.api.client.util.TextureDownloader;
import imgui.ImGui;
import imgui.type.ImBoolean;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/TextureInspector.class */
@ApiStatus.Internal
public class TextureInspector extends SingleWindowInspector {
    public static final Component TITLE = Component.translatable("inspector.veil.texture.title");
    public static final Component DOWNLOAD = Component.translatable("inspector.veil.texture.button.download");
    public static final Component POP_OUT = Component.translatable("inspector.veil.texture.toggle.pop_out");
    public static final Component FLIP_X = Component.translatable("inspector.veil.texture.toggle.flip_x");
    public static final Component FLIP_Y = Component.translatable("inspector.veil.texture.toggle.flip_y");
    public static final Component NO_TEXTURE = Component.translatable("inspector.veil.texture.asset.missing");
    private static final ResourceLocation DEBUG_CUBEMAP_SHADER = Veil.veilPath("debug/cubemap");
    private static final ResourceLocation DEBUG_ARRAY_SHADER = Veil.veilPath("debug/array");
    private boolean downloadTextures;
    private final IntSet texturesSet = new IntArraySet();
    private final Int2ObjectMap<OpenTexture> openTextures = new Int2ObjectArrayMap();
    private final Int2ObjectMap<TextureStorage> textureStorage = new Int2ObjectArrayMap();
    private final ImBoolean flipX = new ImBoolean();
    private final ImBoolean flipY = new ImBoolean();
    private int[] textures = new int[0];
    private int selectedTexture = 0;
    private int selectedTarget = 0;
    private CompletableFuture<?> downloadFuture = null;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/TextureInspector$TextureStorage.class */
    private interface TextureStorage extends NativeResource {
    }

    private void scanTextures() {
        this.texturesSet.clear();
        for (int i = 0; i < 10000; i++) {
            if (GL20C.glIsTexture(i)) {
                this.texturesSet.add(i);
            }
        }
        if (this.textures.length != this.texturesSet.size()) {
            if (!this.texturesSet.contains(this.selectedTexture)) {
                this.selectedTexture = 0;
            }
            this.textures = this.texturesSet.toIntArray();
            this.openTextures.keySet().removeIf(a -> {
                return !this.texturesSet.contains(a);
            });
            ObjectIterator<Int2ObjectMap.Entry<TextureStorage>> iterator = this.textureStorage.int2ObjectEntrySet().iterator();
            while (iterator.hasNext()) {
                Int2ObjectMap.Entry<TextureStorage> entry = (Int2ObjectMap.Entry) iterator.next();
                if (!this.texturesSet.contains(entry.getIntKey())) {
                    ((TextureStorage) entry.getValue()).free();
                    iterator.remove();
                }
            }
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

    private int getSelectedTexture() {
        if (this.selectedTexture < 0 || this.selectedTexture >= this.textures.length) {
            return 0;
        }
        return this.textures[this.selectedTexture];
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    protected void renderComponents() {
        scanTextures();
        int selectedId = getSelectedTexture();
        int[] value = {this.selectedTexture};
        ImGui.beginDisabled(this.textures.length == 0);
        ImGui.setNextItemWidth(ImGui.getContentRegionAvailX() / 2.0f);
        if (ImGui.sliderInt("##textures", value, 0, this.textures.length - 1, selectedId == 0 ? NO_TEXTURE.getString() : Integer.toString(selectedId))) {
            this.selectedTexture = value[0];
            this.selectedTarget = 0;
        }
        ImGui.endDisabled();
        ImGui.sameLine();
        ImGui.pushButtonRepeat(true);
        ImGui.beginDisabled(this.selectedTexture <= 0);
        if (ImGui.arrowButton("##left", 0)) {
            this.selectedTexture--;
            this.selectedTarget = 0;
        }
        ImGui.endDisabled();
        ImGui.beginDisabled(this.selectedTexture >= this.textures.length - 1);
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.arrowButton("##right", 1)) {
            this.selectedTexture++;
            this.selectedTarget = 0;
        }
        ImGui.endDisabled();
        ImGui.popButtonRepeat();
        ImGui.beginDisabled((this.downloadFuture == null || this.downloadFuture.isDone()) ? false : true);
        ImGui.sameLine();
        if (ImGui.button(DOWNLOAD.getString())) {
            this.downloadTextures = true;
            this.downloadFuture = new CompletableFuture<>();
        }
        ImGui.endDisabled();
        int selectedId2 = getSelectedTexture();
        ImGui.beginDisabled(this.openTextures.containsKey(selectedId2) && ((OpenTexture) this.openTextures.get(selectedId2)).visible.get());
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.button(POP_OUT.getString())) {
            this.openTextures.put(selectedId2, new OpenTexture(this.flipX.get(), this.flipY.get()));
        }
        ImGui.endDisabled();
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.checkbox(FLIP_X.getString(), this.flipX);
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.checkbox(FLIP_Y.getString(), this.flipY);
        if (selectedId2 != 0) {
            addImage(selectedId2, this.flipX.get(), this.flipY.get());
        }
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void render() {
        super.render();
        ObjectIterator<Int2ObjectMap.Entry<OpenTexture>> iterator = this.openTextures.int2ObjectEntrySet().iterator();
        while (iterator.hasNext()) {
            Int2ObjectMap.Entry<OpenTexture> entry = (Int2ObjectMap.Entry) iterator.next();
            int id = entry.getIntKey();
            OpenTexture texture = (OpenTexture) entry.getValue();
            if (texture.visible.get()) {
                ImBoolean open = texture.open;
                if (!open.get()) {
                    open.set(true);
                    ImGui.setNextWindowSize(800.0f, 600.0f);
                }
                if (ImGui.begin(I18n.get("inspector.veil.texture.asset", new Object[]{Integer.valueOf(id)}), open, 256)) {
                    ImBoolean flipX = texture.flipX;
                    ImBoolean flipY = texture.flipY;
                    ImGui.checkbox(FLIP_X.getString(), flipX);
                    ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
                    ImGui.checkbox(FLIP_Y.getString(), flipY);
                    addImage(id, flipX.get(), flipY.get());
                }
                ImGui.end();
                if (!open.get()) {
                    iterator.remove();
                }
            }
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void renderLast() {
        super.renderLast();
        if (this.downloadTextures) {
            this.downloadTextures = false;
            try {
                Minecraft client = Minecraft.getInstance();
                Path outputFolder = Paths.get(client.gameDirectory.toURI()).resolve("debug-out");
                if (!Files.exists(outputFolder, new LinkOption[0])) {
                    Files.createDirectories(outputFolder, new FileAttribute[0]);
                } else {
                    Files.walkFileTree(outputFolder, new SimpleFileVisitor<Path>(this) { // from class: foundry.veil.impl.client.editor.TextureInspector.1
                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
                List<CompletableFuture<?>> result = new LinkedList<>();
                IntIterator it = this.texturesSet.iterator();
                while (it.hasNext()) {
                    int i = ((Integer) it.next()).intValue();
                    result.add(TextureDownloader.save(Integer.toString(i), outputFolder, i, false));
                }
                this.downloadFuture = CompletableFuture.allOf((CompletableFuture[]) result.toArray(new CompletableFuture[0])).thenRunAsync(() -> {
                    Util.getPlatform().openFile(outputFolder.toFile());
                }, (Executor) client);
            } catch (Exception e) {
                Veil.LOGGER.error("Failed to download textures", e);
            }
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void renderMenuBar() {
        ObjectIterator it = this.openTextures.int2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Int2ObjectMap.Entry<OpenTexture> entry = (Int2ObjectMap.Entry) it.next();
            ImGui.menuItem(I18n.get("inspector.veil.texture.asset", new Object[]{Integer.valueOf(entry.getIntKey())}), (String) null, ((OpenTexture) entry.getValue()).visible);
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public boolean isMenuBarEnabled() {
        return !this.openTextures.isEmpty();
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onHide() {
        super.onHide();
        this.texturesSet.clear();
        this.textureStorage.values().forEach((v0) -> {
            v0.free();
        });
        this.textureStorage.clear();
        this.textures = new int[0];
        this.selectedTexture = 0;
        this.selectedTarget = 0;
    }

    private int bindTexture(int texture) {
        if (this.selectedTarget == -1) {
            return 0;
        }
        if (this.selectedTarget == 0 && VeilRenderSystem.directStateAccessSupported()) {
            this.selectedTarget = GL45C.glGetTextureParameteri(texture, 4102);
        }
        if (this.selectedTarget != 0) {
            if (this.selectedTarget == 3553) {
                GlStateManager._bindTexture(texture);
            } else {
                GL11C.glBindTexture(this.selectedTarget, texture);
            }
            return this.selectedTarget;
        }
        while (GL11C.glGetError() != 0) {
        }
        int old = GL11C.glGetInteger(32873);
        GlStateManager._bindTexture(texture);
        if (GL11C.glGetError() == 0) {
            this.selectedTarget = 3553;
            return 3553;
        }
        GlStateManager._bindTexture(old);
        int old2 = GL11C.glGetInteger(35869);
        GL11C.glBindTexture(35866, texture);
        if (GL11C.glGetError() == 0) {
            this.selectedTarget = 35866;
            return 35866;
        }
        GL11C.glBindTexture(35866, old2);
        int old3 = GL11C.glGetInteger(34068);
        GL11C.glBindTexture(34067, texture);
        if (GL11C.glGetError() == 0) {
            this.selectedTarget = 34067;
            return 34067;
        }
        GL11C.glBindTexture(34067, old3);
        this.selectedTarget = -1;
        return 0;
    }

    private void addImage(int selectedId, boolean flipX, boolean flipY) {
        int target = bindTexture(selectedId);
        if (target == 0) {
            return;
        }
        if (target == 34067) {
            TextureStorage storage = (TextureStorage) this.textureStorage.get(selectedId);
            if (!(storage instanceof CubemapStorage) && storage != null) {
                this.textureStorage.remove(selectedId);
                storage.free();
            }
            CubemapStorage cubemapStorage = (CubemapStorage) this.textureStorage.computeIfAbsent(selectedId, unused -> {
                return new CubemapStorage();
            });
            float size = ImGui.getContentRegionAvailX();
            cubemapStorage.render((int) size, (int) (size / 2.0f));
            ImGui.image(cubemapStorage.renderedTextureId(), size, size / 2.0f, flipX ? 1.0f : 0.0f, flipY ? 1.0f : 0.0f, flipX ? 0.0f : 1.0f, flipY ? 0.0f : 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
            return;
        }
        if (target != 35866) {
            if (target == 3553) {
                TextureStorage storage2 = (TextureStorage) this.textureStorage.remove(selectedId);
                if (storage2 != null) {
                    storage2.free();
                }
                int width = GL11C.glGetTexLevelParameteri(3553, 0, 4096);
                int height = GL11C.glGetTexLevelParameteri(3553, 0, 4097);
                float size2 = ImGui.getContentRegionAvailX();
                ImGui.image(selectedId, size2, (size2 * height) / width, flipX ? 1.0f : 0.0f, flipY ? 1.0f : 0.0f, flipX ? 0.0f : 1.0f, flipY ? 0.0f : 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
                return;
            }
            return;
        }
        TextureStorage storage3 = (TextureStorage) this.textureStorage.get(selectedId);
        if (!(storage3 instanceof ArrayStorage) && storage3 != null) {
            this.textureStorage.remove(selectedId);
            storage3.free();
        }
        ArrayStorage arrayStorage = (ArrayStorage) this.textureStorage.computeIfAbsent(selectedId, unused2 -> {
            return new ArrayStorage();
        });
        int width2 = GL11C.glGetTexLevelParameteri(35866, 0, 4096);
        int height2 = GL11C.glGetTexLevelParameteri(35866, 0, 4097);
        int depth = GL11C.glGetTexLevelParameteri(35866, 0, 32881);
        float size3 = ImGui.getContentRegionAvailX();
        arrayStorage.render(selectedId, width2, height2, depth);
        for (int i = 0; i < depth; i++) {
            ImGui.image(arrayStorage.renderedTextureId(i), size3, (size3 * height2) / width2, flipX ? 1.0f : 0.0f, flipY ? 1.0f : 0.0f, flipX ? 0.0f : 1.0f, flipY ? 0.0f : 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/TextureInspector$OpenTexture.class */
    private static final class OpenTexture extends Record {
        private final ImBoolean open;
        private final ImBoolean visible;
        private final ImBoolean flipX;
        private final ImBoolean flipY;

        private OpenTexture(ImBoolean open, ImBoolean visible, ImBoolean flipX, ImBoolean flipY) {
            this.open = open;
            this.visible = visible;
            this.flipX = flipX;
            this.flipY = flipY;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, OpenTexture.class), OpenTexture.class, "open;visible;flipX;flipY", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->open:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->visible:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipX:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipY:Limgui/type/ImBoolean;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, OpenTexture.class), OpenTexture.class, "open;visible;flipX;flipY", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->open:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->visible:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipX:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipY:Limgui/type/ImBoolean;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, OpenTexture.class, Object.class), OpenTexture.class, "open;visible;flipX;flipY", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->open:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->visible:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipX:Limgui/type/ImBoolean;", "FIELD:Lfoundry/veil/impl/client/editor/TextureInspector$OpenTexture;->flipY:Limgui/type/ImBoolean;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public ImBoolean open() {
            return this.open;
        }

        public ImBoolean visible() {
            return this.visible;
        }

        public ImBoolean flipX() {
            return this.flipX;
        }

        public ImBoolean flipY() {
            return this.flipY;
        }

        private OpenTexture(boolean flipX, boolean flipY) {
            this(new ImBoolean(), new ImBoolean(true), new ImBoolean(flipX), new ImBoolean(flipY));
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/TextureInspector$CubemapStorage.class */
    private static final class CubemapStorage implements TextureStorage {
        private AdvancedFbo fbo;

        private CubemapStorage() {
        }

        public void render(int width, int height) {
            ShaderProgram shaderProgram = VeilRenderSystem.setShader(TextureInspector.DEBUG_CUBEMAP_SHADER);
            if (shaderProgram == null) {
                free();
                return;
            }
            if (this.fbo == null || this.fbo.getWidth() != width || this.fbo.getHeight() != height) {
                free();
                this.fbo = AdvancedFbo.withSize(width, height).addColorTextureBuffer().setDebugLabel("Texture Inspector Cubemap").build(true);
            }
            this.fbo.bind(true);
            this.fbo.clear();
            shaderProgram.bind();
            VeilRenderSystem.drawScreenQuad();
            AdvancedFbo.unbind();
        }

        public int renderedTextureId() {
            return this.fbo.getColorTextureAttachment(0).getId();
        }

        public void free() {
            if (this.fbo != null) {
                this.fbo.free();
                this.fbo = null;
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/TextureInspector$ArrayStorage.class */
    private static final class ArrayStorage implements TextureStorage {
        private AdvancedFbo fbo;
        private int[] textures;

        private ArrayStorage() {
        }

        public void render(int texture, int width, int height, int layers) {
            ShaderProgram shaderProgram = VeilRenderSystem.setShader(TextureInspector.DEBUG_ARRAY_SHADER);
            if (shaderProgram == null || layers == 0) {
                free();
                return;
            }
            if (this.textures == null || this.textures.length != layers) {
                if (this.textures != null) {
                    GL11C.glDeleteTextures(this.textures);
                }
                this.textures = new int[layers];
                VeilRenderSystem.createTextures(3553, this.textures);
                for (int tex : this.textures) {
                    GlStateManager._bindTexture(tex);
                    TextureUtil.prepareImage(tex, width, height);
                }
                GL11C.glBindTexture(35866, texture);
            }
            if (this.fbo == null || this.fbo.getWidth() != width || this.fbo.getHeight() != height) {
                if (this.fbo != null) {
                    this.fbo.free();
                    this.fbo = null;
                }
                this.fbo = AdvancedFbo.withSize(width, height).addColorTextureWrapper(this.textures[0]).setDebugLabel("Texture Inspector Array").build(true);
            }
            this.fbo.bind(true);
            shaderProgram.bind();
            ShaderUniform indexUniform = shaderProgram.getUniform((CharSequence) "Index");
            for (int i = 0; i < layers; i++) {
                this.fbo.setColorAttachmentTexture(0, this.textures[i]);
                this.fbo.clear();
                if (indexUniform != null) {
                    indexUniform.setInt(i);
                }
                VeilRenderSystem.drawScreenQuad();
            }
            AdvancedFbo.unbind();
        }

        public int renderedTextureId(int index) {
            return (this.textures == null || index < 0 || index >= this.textures.length) ? MissingTextureAtlasSprite.getTexture().getId() : this.textures[index];
        }

        public void free() {
            if (this.fbo != null) {
                this.fbo.free();
                this.fbo = null;
            }
            if (this.textures != null) {
                GL11C.glDeleteTextures(this.textures);
                this.textures = null;
            }
        }
    }
}
