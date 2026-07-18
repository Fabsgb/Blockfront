package foundry.veil.api.client.render.light.data;

import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.light.DDALightData;
import foundry.veil.api.client.render.light.InstancedLightData;
import imgui.ImGui;
import java.nio.ByteBuffer;
import net.minecraft.client.Camera;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4d;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/data/AreaLightData.class */
public class AreaLightData extends LightData implements InstancedLightData, DDALightData, EditorAttributeProvider {
    private static final float MAX_ANGLE_SIZE = 10430.219f;
    private final Matrix4d matrix = new Matrix4d();
    protected final Vector3d position = new Vector3d();
    protected final Quaternionf orientation = new Quaternionf();
    protected final Vector2f size = new Vector2f(1.0f, 1.0f);
    protected float angle = (float) Math.toRadians(45.0d);
    protected float distance = 1.0f;
    protected boolean occlusionEnabled = false;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    protected void updateMatrix() {
        this.matrix.rotation(getOrientation()).translate(this.position);
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public LightTypeRegistry.LightType<?> getType() {
        return LightTypeRegistry.AREA.get();
    }

    public Vector3d getPosition() {
        return this.position;
    }

    public Vector3d getPositionMutable() {
        markDirty();
        return this.position;
    }

    public Quaternionf getOrientation() {
        return this.orientation;
    }

    public Quaternionf getOrientationMutable() {
        return this.orientation;
    }

    public Vector2f getSize() {
        return this.size;
    }

    public Vector2f getSizeMutable() {
        return this.size;
    }

    public float getAngle() {
        return this.angle;
    }

    public float getDistance() {
        return this.distance;
    }

    @Override // foundry.veil.api.client.render.light.DDALightData
    public boolean isOcclusionEnabled() {
        return this.occlusionEnabled;
    }

    public AreaLightData setSize(double x, double y) {
        this.size.set(x, y);
        markDirty();
        return this;
    }

    public AreaLightData setAngle(float angle) {
        this.angle = angle;
        markDirty();
        return this;
    }

    public AreaLightData setDistance(float distance) {
        this.distance = distance;
        markDirty();
        return this;
    }

    public AreaLightData setOcclusionEnabled(boolean occlusionEnabled) {
        this.occlusionEnabled = occlusionEnabled;
        markDirty();
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public AreaLightData setColor(Vector3fc color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public AreaLightData setColor(Colorc color) {
        setColor(color.red(), color.green(), color.blue());
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public AreaLightData setColor(float red, float green, float blue) {
        super.setColor(red, green, blue);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public AreaLightData setColor(int color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public AreaLightData setBrightness(float brightness) {
        super.setBrightness(brightness);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.InstancedLightData
    public void store(ByteBuffer buffer) {
        this.matrix.identity().rotation(this.orientation).translate(this.position).getFloats(buffer.position(), buffer);
        buffer.position(buffer.position() + 64);
        buffer.putFloat(this.color.red() * this.brightness);
        buffer.putFloat(this.color.green() * this.brightness);
        buffer.putFloat(this.color.blue() * this.brightness);
        this.size.get(buffer.position(), buffer);
        buffer.position(buffer.position() + 8);
        buffer.putShort((short) Mth.clamp((int) (this.angle * MAX_ANGLE_SIZE), 0, 65535));
        buffer.putFloat(this.distance);
        buffer.putFloat(this.occlusionEnabled ? 1.0f : 0.0f);
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public boolean isVisible(CullFrustum frustum) {
        float radius = Math.max(this.size.x, this.size.y) + this.distance;
        return frustum.testAab(this.position.x - ((double) radius), this.position.y - ((double) radius), this.position.z - ((double) radius), this.position.x + ((double) radius), this.position.y + ((double) radius), this.position.z + ((double) radius));
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public LightData setTo(Camera camera) {
        Vec3 pos = camera.getPosition();
        this.position.set(pos.x, pos.y, pos.z);
        this.orientation.identity().lookAlong(camera.getLookVector().mul(-1.0f), camera.getUpVector());
        markDirty();
        return this;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        Vector3f orientationAngles = this.orientation.normalize().getEulerAnglesXYZ(new Vector3f());
        float[] editSize = {this.size.x(), this.size.y()};
        double[] editX = {this.position.x()};
        double[] editY = {this.position.y()};
        double[] editZ = {this.position.z()};
        float[] editXRot = {orientationAngles.x()};
        float[] editYRot = {orientationAngles.y()};
        float[] editZRot = {orientationAngles.z()};
        float[] editAngle = {this.angle};
        float[] editDistance = {this.distance};
        if (ImGui.dragFloat2("size", editSize, 0.02f, 1.0E-4f)) {
            setSize(editSize[0], editSize[1]);
        }
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
        ImGui.pushItemWidth((totalWidth / 3.0f) - (ImGui.getStyle().getItemInnerSpacingX() * 0.58f));
        if (ImGui.sliderAngle("##xrot", editXRot)) {
            this.orientation.identity().rotationXYZ(editXRot[0], orientationAngles.y(), orientationAngles.z());
            markDirty();
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.sliderAngle("##yrot", editYRot)) {
            this.orientation.identity().rotationXYZ(orientationAngles.x(), editYRot[0], orientationAngles.z());
            markDirty();
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.sliderAngle("##zrot", editZRot)) {
            this.orientation.identity().rotationXYZ(orientationAngles.x(), orientationAngles.y(), editZRot[0]);
            markDirty();
        }
        ImGui.popItemWidth();
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.text("orientation");
        if (ImGui.sliderAngle("##angle", editAngle, 0.1f, 180.0f, "%.1f")) {
            setAngle(editAngle[0]);
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.text("angle");
        if (ImGui.dragScalar("distance", editDistance, 0.02f, 0.0f)) {
            setDistance(editDistance[0]);
        }
        if (ImGui.checkbox("Occluded", this.occlusionEnabled)) {
            this.occlusionEnabled = !this.occlusionEnabled;
            markDirty();
        }
    }
}
