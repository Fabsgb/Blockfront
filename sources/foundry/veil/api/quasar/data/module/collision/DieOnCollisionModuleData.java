package foundry.veil.api.quasar.data.module.collision;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/collision/DieOnCollisionModuleData.class */
public class DieOnCollisionModuleData implements ParticleModuleData {
    public static final MapCodec<DieOnCollisionModuleData> CODEC = MapCodec.unit(new DieOnCollisionModuleData());

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule((v0) -> {
            v0.remove();
        });
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.DIE_ON_COLLISION;
    }
}
