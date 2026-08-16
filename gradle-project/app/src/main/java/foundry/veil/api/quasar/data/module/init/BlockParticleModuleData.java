package foundry.veil.api.quasar.data.module.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/init/BlockParticleModuleData.class */
public final class BlockParticleModuleData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<BlockParticleModuleData> CODEC = Codec.BOOL.optionalFieldOf("dynamic", true).xmap((v1) -> {
        return new BlockParticleModuleData(v1);
    }, (v0) -> {
        return v0.dynamic();
    });
    private boolean dynamic;

    public BlockParticleModuleData(boolean dynamic) {
        this.dynamic = dynamic;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(particle -> {
            BlockState state = particle.getBlockStateInOrUnder();
            if (!state.isAir()) {
                particle.getRenderData().setAtlasSprite(Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getParticleIcon(state));
            }
        });
        if (this.dynamic) {
            builder.addModule(particle2 -> {
                BlockState state = particle2.getBlockStateInOrUnder();
                if (!state.isAir()) {
                    particle2.getRenderData().setAtlasSprite(Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getParticleIcon(state));
                }
            });
        }
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.BLOCK_PARTICLE;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        if (ImGui.checkbox("dynamic", this.dynamic)) {
            this.dynamic = !this.dynamic;
        }
    }

    public boolean dynamic() {
        return this.dynamic;
    }
}
