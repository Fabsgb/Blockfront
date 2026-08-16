package foundry.veil.api.client.render.light.data;

import foundry.veil.api.client.color.Color;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.CullFrustum;
import net.minecraft.client.Camera;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/data/LightData.class */
public abstract class LightData {
    protected final Color color = new Color(Color.WHITE);
    protected float brightness = 1.0f;
    private long revision;

    public abstract boolean isVisible(CullFrustum cullFrustum);

    public abstract LightTypeRegistry.LightType<?> getType();

    @Deprecated
    public void markDirty() {
        this.revision++;
    }

    public long getRevision() {
        return this.revision;
    }

    public Color getColor() {
        return this.color;
    }

    public Color getColorMutable() {
        markDirty();
        return this.color;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public LightData setColor(Vector3fc color) {
        return setColor(color.x(), color.y(), color.z());
    }

    public LightData setColor(Colorc color) {
        return setColor(color.red(), color.green(), color.blue());
    }

    public LightData setColor(float red, float green, float blue) {
        this.color.set(red, green, blue);
        markDirty();
        return this;
    }

    public LightData setColor(int color) {
        this.color.setRGB(color);
        markDirty();
        return this;
    }

    public LightData setBrightness(float brightness) {
        this.brightness = brightness;
        markDirty();
        return this;
    }

    public LightData setTo(Camera camera) {
        return this;
    }
}
