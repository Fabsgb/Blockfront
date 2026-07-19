package foundry.veil.api.resource.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexSorting;
import foundry.veil.Veil;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.BlockModelResource;
import imgui.ImGui;
import imgui.type.ImBoolean;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.Reader;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/BlockModelInspector.class */
@ApiStatus.Internal
public class BlockModelInspector implements ResourceFileEditor<BlockModelResource> {
    private static final Component TITLE = Component.translatable("inspector.veil.block_model.title");
    private static final FaceBakery FACE_BAKERY = new FaceBakery();
    private static final PoseStack.Pose POSE = new PoseStack().last();
    private final ImBoolean open = new ImBoolean(true);
    private final VeilResourceManager resourceManager;
    private final BlockModelResource resource;
    private ObjectArrayList<BakedQuad> quads;

    public BlockModelInspector(VeilEditorEnvironment environment, BlockModelResource resource) {
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
        if (ImGui.begin(TITLE.getString() + "###model_editor_" + resourceInfo.fileName(), this.open, Token.ELLIPSIS)) {
            VeilImGuiUtil.resourceLocation(resourceInfo.location());
            int desiredWidth = (((int) ImGui.getContentRegionAvailX()) - 2) * 2;
            int desiredHeight = (((int) ImGui.getContentRegionAvailY()) - 2) * 2;
            if (desiredWidth <= 0 || desiredHeight <= 0) {
                ImGui.end();
                return;
            }
            int texture = VeilImGuiUtil.renderArea(desiredWidth, desiredHeight, fbo -> {
                double time = ImGui.getTime();
                double yaw = Math.toRadians(time * 45.0d);
                double pitch = Math.toRadians(30.0d);
                Quaterniond cameraOrientation = new Quaterniond().rotateX(pitch).rotateY(yaw);
                Vector3d cameraPos = cameraOrientation.transformInverse(new Vector3d(0.0d, 0.0d, 2.8d)).add(0.5d, 0.5d, 0.5d);
                Matrix4f viewMatrix = new Matrix4f().rotate(new Quaternionf(cameraOrientation)).translate((float) (-cameraPos.x), (float) (-cameraPos.y), (float) (-cameraPos.z));
                float aspect = desiredWidth / desiredHeight;
                Matrix4f projMat = new Matrix4f().perspective((float) Math.toRadians(40.0d), aspect, 0.3f, 1000.0f);
                Matrix4f modelView = new Matrix4f().mul(viewMatrix);
                BufferBuilder builder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLOCK);
                ObjectListIterator it = this.quads.iterator();
                while (it.hasNext()) {
                    BakedQuad quad = (BakedQuad) it.next();
                    builder.putBulkData(POSE, quad, 1.0f, 1.0f, 1.0f, 1.0f, 15728880, OverlayTexture.NO_OVERLAY);
                }
                MeshData data = builder.build();
                if (data != null) {
                    RenderType renderType = RenderType.translucent();
                    Matrix4fStack stack = RenderSystem.getModelViewStack();
                    stack.pushMatrix();
                    stack.set(modelView);
                    RenderSystem.applyModelViewMatrix();
                    RenderSystem.backupProjectionMatrix();
                    RenderSystem.setProjectionMatrix(projMat, VertexSorting.ORTHOGRAPHIC_Z);
                    renderType.draw(data);
                    stack.popMatrix();
                    RenderSystem.restoreProjectionMatrix();
                    RenderSystem.applyModelViewMatrix();
                    renderType.clearRenderState();
                }
            });
            if (ImGui.beginChild("3D View", (desiredWidth / 2.0f) + 2.0f, (desiredHeight / 2.0f) + 2.0f, false, 8)) {
                ImGui.image(texture, desiredWidth / 2.0f, desiredHeight / 2.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.1f);
            }
            ImGui.endChild();
        }
        ImGui.end();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return !this.open.get();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public BlockModelResource getResource() {
        return this.resource;
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
        Minecraft client = Minecraft.getInstance();
        this.quads = new ObjectArrayList<>();
        try {
            Reader reader = this.resource.resourceInfo().openAsReader(this.resourceManager);
            try {
                BlockModel unbaked = BlockModel.fromStream(reader);
                unbaked.resolveParents(location -> {
                    try {
                        Reader parentReader = client.getResourceManager().openAsReader(ModelBakery.MODEL_LISTER.idToFile(location));
                        try {
                            BlockModel blockModelFromStream = BlockModel.fromStream(parentReader);
                            if (parentReader != null) {
                                parentReader.close();
                            }
                            return blockModelFromStream;
                        } finally {
                        }
                    } catch (Exception e) {
                        Veil.LOGGER.error("Failed to load block model", e);
                        return BlockModel.fromString(ModelBakery.MISSING_MODEL_MESH);
                    }
                });
                List<BlockElement> elements = unbaked.getElements();
                for (BlockElement blockelement : elements) {
                    for (Direction direction : blockelement.faces.keySet()) {
                        BlockElementFace blockelementface = (BlockElementFace) blockelement.faces.get(direction);
                        Material material = unbaked.getMaterial(blockelementface.texture());
                        TextureAtlasSprite sprite = (TextureAtlasSprite) client.getTextureAtlas(material.atlasLocation()).apply(material.texture());
                        this.quads.add(FACE_BAKERY.bakeQuad(blockelement.from, blockelement.to, blockelementface, sprite, direction, BlockModelRotation.X0_Y0, blockelement.rotation, blockelement.shade));
                    }
                }
                if (reader != null) {
                    reader.close();
                }
            } finally {
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to load block model", e);
        }
    }
}
