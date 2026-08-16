package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.ScaleForceModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/force/DragForceData.class */
public final class DragForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<DragForceData> CODEC = Codec.DOUBLE.fieldOf("strength").xmap((v1) -> {
        return new DragForceData(v1);
    }, (v0) -> {
        return v0.strength();
    });
    private double strength;

    public DragForceData(double strength) {
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new ScaleForceModule(this.strength));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.DRAG;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        double[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }

    public double strength() {
        return this.strength;
    }
}
