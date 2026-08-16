package foundry.veil.api.quasar.data.module.init;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.molang.MolangExpressionCodec;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/init/InitSizeParticleModuleData.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated
public final class InitSizeParticleModuleData extends Record implements ParticleModuleData {
    private final MolangExpression size;
    public static final MapCodec<InitSizeParticleModuleData> CODEC = MolangExpressionCodec.CODEC.fieldOf("size").xmap(InitSizeParticleModuleData::new, (v0) -> {
        return v0.size();
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, InitSizeParticleModuleData.class), InitSizeParticleModuleData.class, "size", "FIELD:Lfoundry/veil/api/quasar/data/module/init/InitSizeParticleModuleData;->size:Lgg/moonflower/molangcompiler/api/MolangExpression;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, InitSizeParticleModuleData.class), InitSizeParticleModuleData.class, "size", "FIELD:Lfoundry/veil/api/quasar/data/module/init/InitSizeParticleModuleData;->size:Lgg/moonflower/molangcompiler/api/MolangExpression;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, InitSizeParticleModuleData.class, Object.class), InitSizeParticleModuleData.class, "size", "FIELD:Lfoundry/veil/api/quasar/data/module/init/InitSizeParticleModuleData;->size:Lgg/moonflower/molangcompiler/api/MolangExpression;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangExpression size() {
        return this.size;
    }

    public InitSizeParticleModuleData(MolangExpression size) {
        this.size = size;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(particle -> {
            try {
                particle.setRadius(particle.getEnvironment().resolve(this.size));
            } catch (MolangRuntimeException e) {
                e.printStackTrace();
                particle.setRadius(1.0f);
            }
        });
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.INIT_SIZE;
    }
}
