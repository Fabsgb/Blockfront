package foundry.veil.api.quasar.emitters.module.render;

import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import foundry.veil.api.quasar.data.module.init.LightModuleData;
import foundry.veil.api.quasar.emitters.module.RenderParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/render/StaticLightModule.class */
public class StaticLightModule implements RenderParticleModule {
    private final PointLightData light;
    private LightRenderHandle<PointLightData> lightHandle;

    public StaticLightModule(LightModuleData data) {
        this(data.color().getColor(0.0f), data.brightness().getConstant(), data.radius().getConstant());
    }

    public StaticLightModule(Colorc color, float brightness, float radius) {
        this.light = new PointLightData().setColor(color).setBrightness(brightness).setRadius(radius);
    }

    public boolean isVisible() {
        return ((double) (this.light.getColor().luminance() * this.light.getBrightness())) >= 0.1d;
    }

    @Override // foundry.veil.api.quasar.emitters.module.RenderParticleModule
    public void render(QuasarParticle particle, float partialTicks) {
        if (this.lightHandle == null) {
            this.lightHandle = VeilRenderSystem.renderer().getLightRenderer().addLight(this.light);
        }
        this.light.setPosition(particle.getRenderData().getRenderPosition());
    }

    @Override // foundry.veil.api.quasar.emitters.module.ParticleModule
    public void onRemove() {
        if (this.lightHandle != null) {
            this.lightHandle.free();
            this.lightHandle = null;
        }
    }
}
