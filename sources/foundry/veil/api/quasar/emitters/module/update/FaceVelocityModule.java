package foundry.veil.api.quasar.emitters.module.update;

import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import net.minecraft.util.Mth;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/update/FaceVelocityModule.class */
public class FaceVelocityModule implements UpdateParticleModule {
    private final Vector3d temp = new Vector3d();

    @Override // foundry.veil.api.quasar.emitters.module.UpdateParticleModule
    public void update(QuasarParticle particle) {
        Vector3d normalizedMotion = particle.getVelocity().normalize(this.temp);
        Vector3f rotation = particle.getRotation();
        rotation.x = (float) Mth.atan2(normalizedMotion.y, Math.sqrt((normalizedMotion.x * normalizedMotion.x) + (normalizedMotion.z * normalizedMotion.z)));
        rotation.y = (float) Mth.atan2(normalizedMotion.x, normalizedMotion.z);
        if (particle.getData().renderStyle() == RenderStyleRegistry.BILLBOARD.get()) {
            rotation.y += 1.5707964f;
        }
    }
}
