package foundry.veil.api.quasar.data.module.update;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleEmitterData;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.update.TickSubEmitterModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;
import imgui.type.ImString;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/update/TickSubEmitterModuleData.class */
public final class TickSubEmitterModuleData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<TickSubEmitterModuleData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("subemitter").forGetter((v0) -> {
            return v0.subEmitter();
        }), Codec.INT.fieldOf("frequency").forGetter((v0) -> {
            return v0.frequency();
        })).apply(instance, (v1, v2) -> {
            return new TickSubEmitterModuleData(v1, v2);
        });
    });
    private ResourceLocation subEmitter;
    private int frequency;

    public TickSubEmitterModuleData(ResourceLocation subEmitter, int frequency) {
        this.subEmitter = subEmitter;
        this.frequency = frequency;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new TickSubEmitterModule(this));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.TICK_SUB_EMITTER;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        ImString textInput = new ImString(this.subEmitter.toString(), 256);
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
        int[] editFrequency = {this.frequency};
        if (ImGui.dragInt("frequency", editFrequency, 0.01f, 1, Integer.MAX_VALUE)) {
            this.frequency = Math.max(editFrequency[0], 1);
        }
    }

    public ResourceLocation subEmitter() {
        return this.subEmitter;
    }

    public int frequency() {
        return this.frequency;
    }
}
