package foundry.veil.api.quasar.emitters.module.render;

import foundry.veil.api.client.color.Color;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import foundry.veil.api.quasar.emitters.module.RenderParticleModule;
import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/render/CustomLightModule.class */
public class CustomLightModule implements UpdateParticleModule, RenderParticleModule {
    private float brightness;
    private final Color lastColor = new Color(Color.WHITE);
    private final Color color = new Color(Color.WHITE);
    private final Color renderColor = new Color(Color.WHITE);
    private final PointLightData light = new PointLightData();
    private LightRenderHandle<PointLightData> lightHandle = null;

    @Override // foundry.veil.api.quasar.emitters.module.UpdateParticleModule
    public void update(QuasarParticle particle) {
        this.lastColor.set(this.color);
        float brightness = this.brightness * this.color.alpha();
        if (this.color.luminance() < 0.1d && brightness < 0.1d) {
            onRemove();
            return;
        }
        this.light.setColor((Colorc) this.color).setBrightness(brightness);
        if (this.lightHandle == null) {
            this.lightHandle = VeilRenderSystem.renderer().getLightRenderer().addLight(this.light);
        }
    }

    @Override // foundry.veil.api.quasar.emitters.module.RenderParticleModule
    public void render(QuasarParticle particle, float partialTicks) {
        if (this.lightHandle == null) {
            return;
        }
        this.light.setPosition(particle.getRenderData().getRenderPosition());
        this.lastColor.lerp(this.color, partialTicks, this.renderColor);
        this.light.setColor((Colorc) this.renderColor);
        this.light.setBrightness(this.brightness * this.renderColor.alpha());
    }

    @Override // foundry.veil.api.quasar.emitters.module.ParticleModule
    public void onRemove() {
        if (this.lightHandle != null) {
            this.lightHandle.free();
            this.lightHandle = null;
        }
    }

    public Colorc getColor() {
        return this.color;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public float getRadius() {
        return this.light.getRadius();
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    public void setRadius(float radius) {
        this.light.setRadius(radius);
    }
}
