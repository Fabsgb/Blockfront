package foundry.veil.api.client.render.light.data;

import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.light.DDALightData;
import foundry.veil.api.client.render.light.IndirectLightData;
import foundry.veil.api.client.render.light.LightGuideProvider;
import imgui.ImGui;
import java.nio.ByteBuffer;
import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/data/PointLightData.class */
public class PointLightData extends LightData implements IndirectLightData, DDALightData, EditorAttributeProvider, LightGuideProvider {
    protected final Vector3d position = new Vector3d();
    protected float radius = 1.0f;
    protected boolean occlusionEnabled = false;
    protected float inscattering = 0.0f;

    @Override // foundry.veil.api.client.render.light.IndirectLightData
    public float getRadius() {
        return this.radius;
    }

    @Override // foundry.veil.api.client.render.light.IndirectLightData
    public Vector3dc getPosition() {
        return this.position;
    }

    public Vector3d getPositionMutable() {
        markDirty();
        return this.position;
    }

    @Override // foundry.veil.api.client.render.light.DDALightData
    public boolean isOcclusionEnabled() {
        return this.occlusionEnabled;
    }

    public float getInscatteringStrength() {
        return this.inscattering;
    }

    public PointLightData setPosition(Vector3dc pos) {
        this.position.set(pos);
        markDirty();
        return this;
    }

    public PointLightData setPosition(double x, double y, double z) {
        this.position.set(x, y, z);
        markDirty();
        return this;
    }

    public PointLightData setRadius(float radius) {
        this.radius = radius;
        markDirty();
        return this;
    }

    public PointLightData setOcclusionEnabled(boolean occlusionEnabled) {
        this.occlusionEnabled = occlusionEnabled;
        markDirty();
        return this;
    }

    public PointLightData setInscatteringStrength(float inscattering) {
        this.inscattering = inscattering;
        markDirty();
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setColor(Vector3fc color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setColor(Colorc color) {
        setColor(color.red(), color.green(), color.blue());
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setColor(float red, float green, float blue) {
        super.setColor(red, green, blue);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setColor(int color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setBrightness(float brightness) {
        super.setBrightness(brightness);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public boolean isVisible(CullFrustum frustum) {
        return frustum.testSphere((Vector3dc) this.position, this.radius * 1.4f);
    }

    @Override // foundry.veil.api.client.render.light.InstancedLightData
    public void store(ByteBuffer buffer) {
        this.position.getf(buffer.position(), buffer);
        buffer.position(buffer.position() + 12);
        buffer.putFloat(this.color.red() * this.brightness);
        buffer.putFloat(this.color.green() * this.brightness);
        buffer.putFloat(this.color.blue() * this.brightness);
        buffer.putFloat(this.radius);
        buffer.putFloat(this.occlusionEnabled ? 1.0f : 0.0f);
        buffer.putFloat(this.inscattering);
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public PointLightData setTo(Camera camera) {
        Vec3 pos = camera.getPosition();
        this.position.set(pos.x, pos.y, pos.z);
        markDirty();
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public LightTypeRegistry.LightType<?> getType() {
        return LightTypeRegistry.POINT.get();
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        double[] editX = {this.position.x()};
        double[] editY = {this.position.y()};
        double[] editZ = {this.position.z()};
        float[] editRadius = {this.radius};
        float[] editInscattering = {this.inscattering};
        float totalWidth = ImGui.calcItemWidth();
        ImGui.pushItemWidth((totalWidth / 3.0f) - (ImGui.getStyle().getItemInnerSpacingX() * 0.58f));
        if (ImGui.dragScalar("##x", editX, 0.02f)) {
            this.position.x = editX[0];
            markDirty();
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.dragScalar("##y", editY, 0.02f)) {
            this.position.y = editY[0];
            markDirty();
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.dragScalar("##z", editZ, 0.02f)) {
            this.position.z = editZ[0];
            markDirty();
        }
        ImGui.popItemWidth();
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.text("position");
        if (ImGui.dragScalar("radius", editRadius, 0.02f, 0.0f)) {
            setRadius(editRadius[0]);
        }
        if (ImGui.checkbox("Occluded", this.occlusionEnabled)) {
            setOcclusionEnabled(!this.occlusionEnabled);
        }
        if (ImGui.dragScalar("In-scattering", editInscattering, 0.01f, 0.0f)) {
            setInscatteringStrength(editInscattering[0]);
        }
    }

    @Override // foundry.veil.api.client.render.light.LightGuideProvider
    public void renderLightGuide(MatrixStack stack, VertexConsumer consumer) {
        stack.matrixPush();
        stack.translate(this.position.x, this.position.y, this.position.z);
        Matrix4f pose = stack.position();
        for (int i = -8; i < 25; i++) {
            consumer.addVertex(pose, ((float) Math.sin((i / 32.0f) * 6.2831855f)) * this.radius, 0.0f, ((float) Math.cos((i / 32.0f) * 6.2831855f)) * this.radius).setColor(this.color.red(), this.color.green(), this.color.blue(), this.color.alpha());
        }
        for (int i2 = -8; i2 < 25; i2++) {
            consumer.addVertex(pose, ((float) Math.sin((i2 / 32.0f) * 6.2831855f)) * this.radius, ((float) Math.cos((i2 / 32.0f) * 6.2831855f)) * this.radius, 0.0f).setColor(this.color.red(), this.color.green(), this.color.blue(), this.color.alpha());
        }
        for (int i3 = 25; i3 >= 16; i3--) {
            consumer.addVertex(pose, ((float) Math.sin((i3 / 32.0f) * 6.2831855f)) * this.radius, ((float) Math.cos((i3 / 32.0f) * 6.2831855f)) * this.radius, 0.0f).setColor(this.color.red(), this.color.green(), this.color.blue(), this.color.alpha());
        }
        for (int i4 = -8; i4 < 25; i4++) {
            consumer.addVertex(pose, 0.0f, ((float) Math.sin((i4 / 32.0f) * 6.2831855f)) * this.radius, ((float) Math.cos((i4 / 32.0f) * 6.2831855f)) * this.radius).setColor(this.color.red(), this.color.green(), this.color.blue(), this.color.alpha());
        }
        stack.matrixPop();
    }
}
