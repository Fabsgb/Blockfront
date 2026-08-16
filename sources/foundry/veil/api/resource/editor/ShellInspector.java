package foundry.veil.api.resource.editor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexSorting;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.flare.data.model.FlareShell;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.ShellResource;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.type.ImBoolean;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import java.io.Reader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/editor/ShellInspector.class */
public class ShellInspector implements ResourceFileEditor<ShellResource> {
    private static final Component TITLE = Component.translatable("inspector.veil.shell.title");
    public static final ResourceLocation RENDER_TYPE = Veil.veilPath("debug/shell");
    private final VeilResourceManager resourceManager;
    private final ShellResource resource;
    private BakedShell shell;
    private final ImBoolean open = new ImBoolean(true);
    private final ImVec2 mouseDragDelta = new ImVec2();
    private double offsetXRot = Math.toRadians(45.0d);
    private double offsetYRot = Math.toRadians(30.0d);
    private float cameraDistance = 10.0f;

    public ShellInspector(VeilEditorEnvironment environment, ShellResource resource) {
        this.resourceManager = environment.getResourceManager();
        this.resource = resource;
        loadFromDisk();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() {
        if (this.resource == null || !this.open.get() || this.shell == null) {
            return;
        }
        VeilResourceInfo resourceInfo = this.resource.resourceInfo();
        ImGui.setNextWindowSizeConstraints(256.0f, 256.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        ImGui.setNextWindowSize(256.0f, 256.0f, 2);
        if (ImGui.begin(TITLE.getString() + "###shell_editor_" + resourceInfo.fileName(), this.open, Token.ELLIPSIS)) {
            VeilImGuiUtil.resourceLocation(resourceInfo.location());
            int desiredWidth = (((int) ImGui.getContentRegionAvailX()) - 2) * 2;
            int desiredHeight = (((int) ImGui.getContentRegionAvailY()) - 2) * 2;
            if (desiredWidth <= 0 || desiredHeight <= 0) {
                ImGui.end();
                return;
            }
            int texture = VeilImGuiUtil.renderArea(desiredWidth, desiredHeight, fbo -> {
                Quaterniond cameraOrientation = new Quaterniond().rotateX(this.offsetXRot).rotateY(this.offsetYRot);
                Vector3d cameraPos = cameraOrientation.transformInverse(new Vector3d(0.0d, 0.0d, this.cameraDistance)).add(0.0d, 0.0d, 0.0d);
                Matrix4f viewMatrix = new Matrix4f().rotate(new Quaternionf(cameraOrientation)).translate((float) (-cameraPos.x), (float) (-cameraPos.y), (float) (-cameraPos.z));
                float aspect = desiredWidth / desiredHeight;
                Matrix4f projMat = new Matrix4f().perspective((float) Math.toRadians(40.0d), aspect, 0.3f, 1000.0f);
                Matrix4f modelView = new Matrix4f().mul(viewMatrix);
                RenderType renderType = VeilRenderType.get(RENDER_TYPE, new Object[0]);
                if (renderType == null) {
                    return;
                }
                Matrix4fStack stack = RenderSystem.getModelViewStack();
                stack.pushMatrix();
                stack.set(modelView);
                RenderSystem.applyModelViewMatrix();
                RenderSystem.backupProjectionMatrix();
                RenderSystem.setProjectionMatrix(projMat, VertexSorting.ORTHOGRAPHIC_Z);
                this.shell.getVertexArray().bind();
                this.shell.getVertexArray().drawWithRenderType(renderType);
                VertexArray.unbind();
                stack.popMatrix();
                RenderSystem.restoreProjectionMatrix();
                RenderSystem.applyModelViewMatrix();
            });
            if (ImGui.beginChild("3D View", (desiredWidth / 2.0f) + 2.0f, (desiredHeight / 2.0f) + 2.0f, false, 12)) {
                if (ImGui.isWindowHovered()) {
                    applyCameraChanges();
                }
                ImGui.imageWithBg(texture, desiredWidth / 2.0f, desiredHeight / 2.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.1f);
            }
            ImGui.endChild();
        }
        ImGui.end();
    }

    private void applyCameraChanges() {
        if (ImGui.isMouseDragging(0)) {
            ImGui.getMouseDragDelta(this.mouseDragDelta);
            ImGui.resetMouseDragDelta();
            this.offsetXRot += (double) (this.mouseDragDelta.y * 0.01f);
            this.offsetYRot += (double) (this.mouseDragDelta.x * 0.01f);
        }
        this.cameraDistance -= ImGui.getIO().getMouseWheel();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return !this.open.get();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public ShellResource getResource() {
        return this.resource;
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
        if (this.shell != null) {
            this.shell.free();
            this.shell = null;
        }
        try {
            Reader reader = this.resource.resourceInfo().openAsReader(this.resourceManager);
            try {
                JsonElement element = JsonParser.parseReader(reader);
                DataResult<FlareShell> result = FlareShell.CODEC.parse(JsonOps.INSTANCE, element);
                if (result.error().isPresent()) {
                    throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
                }
                this.shell = ((FlareShell) result.getOrThrow()).bake();
                if (reader != null) {
                    reader.close();
                }
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to load shell", e);
        }
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor, java.io.Closeable, java.lang.AutoCloseable, foundry.veil.api.flare.EffectHost
    public void close() {
        super.close();
        if (this.shell != null) {
            this.shell.free();
            this.shell = null;
        }
    }
}
