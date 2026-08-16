package foundry.veil.api.resource.editor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexSorting;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.data.effect.FlareEffectTemplate;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.FlareResource;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.type.ImBoolean;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.Reader;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/editor/EffectInspector.class */
public class EffectInspector implements ResourceFileEditor<FlareResource>, EffectHost {
    private static final Component TITLE = Component.translatable("inspector.veil.effect.title");
    private static final PoseStack POSE_STACK = new PoseStack();
    private final VeilResourceManager resourceManager;
    private final FlareResource resource;
    private String selectedValue;

    @Nullable
    private FlareEffectTemplate template;
    private final ImBoolean open = new ImBoolean(true);
    private final ImVec2 mouseDragDelta = new ImVec2();
    private final Object2FloatMap<String> values = new Object2FloatArrayMap();
    private double offsetXRot = Math.toRadians(45.0d);
    private double offsetYRot = Math.toRadians(30.0d);
    private float cameraDistance = 10.0f;

    public EffectInspector(VeilEditorEnvironment environment, FlareResource resource) {
        this.resourceManager = environment.getResourceManager();
        this.resource = resource;
        loadFromDisk();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() {
        if (this.resource == null || !this.open.get()) {
            return;
        }
        VeilResourceInfo resourceInfo = this.resource.resourceInfo();
        ImGui.setNextWindowSizeConstraints(256.0f, 256.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        ImGui.setNextWindowSize(256.0f, 256.0f, 2);
        if (ImGui.begin(TITLE.getString() + "###shell_editor_" + resourceInfo.fileName(), this.open, Token.ELLIPSIS)) {
            VeilImGuiUtil.resourceLocation(resourceInfo.location());
            if (this.selectedValue == null && !this.values.isEmpty()) {
                this.selectedValue = (String) ((Object2FloatMap.Entry) this.values.object2FloatEntrySet().iterator().next()).getKey();
            }
            if (this.selectedValue != null) {
                float[] value = {getValue(this.selectedValue)};
                if (ImGui.beginCombo("##values", this.selectedValue + " = " + value[0])) {
                    ObjectIterator it = this.values.keySet().iterator();
                    while (it.hasNext()) {
                        String name = (String) it.next();
                        if (ImGui.selectable(name)) {
                            this.selectedValue = name;
                        }
                    }
                    ImGui.endCombo();
                }
                if (ImGui.dragFloat("##value", value, 0.05f)) {
                    this.values.put(this.selectedValue, value[0]);
                }
            }
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
                if (this.template == null) {
                    return;
                }
                Matrix4fStack stack = RenderSystem.getModelViewStack();
                stack.pushMatrix();
                stack.set(modelView);
                RenderSystem.applyModelViewMatrix();
                RenderSystem.backupProjectionMatrix();
                RenderSystem.setProjectionMatrix(projMat, VertexSorting.ORTHOGRAPHIC_Z);
                this.template.render(this, (MatrixStack) POSE_STACK, 0.0f, null);
                stack.popMatrix();
                RenderSystem.restoreProjectionMatrix();
                RenderSystem.applyModelViewMatrix();
            });
            if (ImGui.beginChild("3D View", (desiredWidth / 2.0f) + 2.0f, (desiredHeight / 2.0f) + 2.0f, false, 12)) {
                if (ImGui.isWindowHovered()) {
                    applyCameraChanges();
                }
                ImGui.imageWithBg(texture, desiredWidth / 2.0f, desiredHeight / 2.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.1f, 1.0f, 1.0f, 1.0f, 1.0f);
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
    public FlareResource getResource() {
        return this.resource;
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor, java.io.Closeable, java.lang.AutoCloseable, foundry.veil.api.flare.EffectHost
    public void close() {
        super.close();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
        try {
            Reader reader = this.resource.resourceInfo().openAsReader(this.resourceManager);
            try {
                JsonElement element = JsonParser.parseReader(reader);
                DataResult<FlareEffectTemplate> result = FlareEffectTemplate.CODEC.parse(JsonOps.INSTANCE, element);
                if (result.error().isPresent()) {
                    throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
                }
                this.template = (FlareEffectTemplate) result.getOrThrow();
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
            Veil.LOGGER.error("Failed to load template", e);
        }
    }

    @Override // foundry.veil.api.flare.EffectHost
    public float getValue(String name) {
        return this.values.computeIfAbsent(name, n -> {
            return 0.0f;
        });
    }

    @Override // foundry.veil.api.flare.EffectHost
    public String getName() {
        return "inspector";
    }

    @Override // foundry.veil.api.flare.EffectHost
    public void update(float partialTick) {
    }
}
