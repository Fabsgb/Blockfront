package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.VectorFieldForceModule;
import foundry.veil.api.quasar.emitters.module.update.VectorField;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/force/VectorFieldForceData.class */
public final class VectorFieldForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<VectorFieldForceData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(VectorField.CODEC.fieldOf("vector_field").forGetter((v0) -> {
            return v0.vectorField();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2) -> {
            return new VectorFieldForceData(v1, v2);
        });
    });
    private final VectorField vectorField;
    private float strength;

    public VectorFieldForceData(VectorField vectorField, float strength) {
        this.vectorField = vectorField;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new VectorFieldForceModule(this));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.VECTOR_FIELD;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        this.vectorField.renderImGuiAttributes();
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }

    public VectorField vectorField() {
        return this.vectorField;
    }

    public float strength() {
        return this.strength;
    }
}
