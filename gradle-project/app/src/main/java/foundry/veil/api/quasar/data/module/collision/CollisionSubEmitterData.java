package foundry.veil.api.quasar.data.module.collision;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.data.ParticleEmitterData;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import imgui.ImGui;
import imgui.type.ImString;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/collision/CollisionSubEmitterData.class */
public final class CollisionSubEmitterData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<CollisionSubEmitterData> CODEC = ResourceLocation.CODEC.fieldOf("subemitter").xmap(CollisionSubEmitterData::new, (v0) -> {
        return v0.subEmitter();
    });
    private ResourceLocation subEmitter;

    public CollisionSubEmitterData(ResourceLocation subEmitter) {
        this.subEmitter = subEmitter;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(particle -> {
            ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
            ParticleEmitter instance = particleManager.createEmitter(this.subEmitter);
            if (instance == null) {
                return;
            }
            instance.setPosition((Vector3dc) particle.getPosition());
            particleManager.getScheduler().execute(() -> {
                particleManager.addParticleSystem(instance);
            });
        });
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.SUB_EMITTER_COLLISION;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        ImString textInput = new ImString(this.subEmitter.toString());
        if (ImGui.inputTextWithHint("subemitter", "namespace:path", textInput)) {
            try {
                ResourceLocation location = ResourceLocation.parse(textInput.get());
                QuasarParticles.registryAccess().registry(QuasarParticles.EMITTER).map(registry -> {
                    return (ParticleEmitterData) registry.get(location);
                }).ifPresent(data -> {
                    this.subEmitter = location;
                });
            } catch (Exception e) {
            }
        }
    }

    public ResourceLocation subEmitter() {
        return this.subEmitter;
    }
}
