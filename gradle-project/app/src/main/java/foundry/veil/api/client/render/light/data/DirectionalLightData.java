package foundry.veil.api.client.render.light.data;

import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.CullFrustum;
import imgui.ImGui;
import net.minecraft.client.Camera;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/data/DirectionalLightData.class */
public class DirectionalLightData extends LightData implements EditorAttributeProvider {
    protected final Vector3f direction = new Vector3f(0.0f, -1.0f, 0.0f);

    public Vector3f getDirection() {
        return this.direction;
    }

    public Vector3f getDirectionMutable() {
        return this.direction;
    }

    public DirectionalLightData setDirection(Vector3fc direction) {
        this.direction.set(direction);
        return this;
    }

    public DirectionalLightData setDirection(float x, float y, float z) {
        this.direction.set(x, y, z);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setColor(Vector3fc color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setColor(Colorc color) {
        setColor(color.red(), color.green(), color.blue());
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setColor(float red, float green, float blue) {
        super.setColor(red, green, blue);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setColor(int color) {
        super.setColor(color);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setBrightness(float brightness) {
        super.setBrightness(brightness);
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public boolean isVisible(CullFrustum frustum) {
        return true;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public DirectionalLightData setTo(Camera camera) {
        this.direction.set(camera.getLookVector());
        return this;
    }

    @Override // foundry.veil.api.client.render.light.data.LightData
    public LightTypeRegistry.LightType<?> getType() {
        return LightTypeRegistry.DIRECTIONAL.get();
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editDirection = {this.direction.x(), this.direction.y(), this.direction.z()};
        if (ImGui.sliderFloat3("##direction", editDirection, -1.0f, 1.0f)) {
            this.direction.set(editDirection);
        }
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        ImGui.text("direction");
    }
}
