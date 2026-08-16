package foundry.veil.api.quasar.data.module.update;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.molang.MolangExpressionCodec;
import foundry.veil.api.molang.VeilMolang;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import imgui.ImGui;
import imgui.type.ImString;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/update/TickSizeParticleModuleData.class */
public final class TickSizeParticleModuleData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<TickSizeParticleModuleData> CODEC = MolangExpressionCodec.CODEC.fieldOf("size").xmap(TickSizeParticleModuleData::new, (v0) -> {
        return v0.size();
    });
    private MolangExpression size;

    public TickSizeParticleModuleData(MolangExpression size) {
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
        if (!this.size.isConstant()) {
            builder.addModule(particle2 -> {
                try {
                    particle2.setRadius(particle2.getEnvironment().resolve(this.size));
                } catch (MolangRuntimeException e) {
                    e.printStackTrace();
                    particle2.setRadius(1.0f);
                }
            });
        }
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.TICK_SIZE;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        ImString textInput = new ImString();
        String sizeText = this.size.toString();
        if (sizeText.startsWith("return (")) {
            textInput.set(this.size.toString().substring(8, this.size.toString().length() - 1));
        } else {
            textInput.set(this.size.toString());
        }
        if (ImGui.inputText("size", textInput)) {
            try {
                this.size = VeilMolang.get().compile(textInput.get());
            } catch (Exception e) {
            }
        }
    }

    public MolangExpression size() {
        return this.size;
    }
}
