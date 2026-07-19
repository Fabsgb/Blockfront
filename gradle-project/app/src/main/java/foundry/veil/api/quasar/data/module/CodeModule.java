package foundry.veil.api.quasar.data.module;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/CodeModule.class */
public interface CodeModule extends ParticleModuleData {
    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    default ModuleType<?> getType() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " is not serializazble");
    }
}
