package foundry.veil.ext;

import foundry.veil.api.quasar.particle.ParticleEmitter;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/EntityExtension.class */
@ApiStatus.Internal
public interface EntityExtension {
    void veil$addEmitter(ParticleEmitter particleEmitter);

    List<ParticleEmitter> veil$getEmitters();
}
