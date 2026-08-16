package foundry.veil.api.quasar.data.module.init;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import imgui.ImGui;
import net.minecraft.client.renderer.LightTexture;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/init/LightmapParticleModuleData.class */
public final class LightmapParticleModuleData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<LightmapParticleModuleData> CODEC = Codec.mapEither(Codec.BOOL.optionalFieldOf("fullbright", false).xmap(bright -> {
        return Integer.valueOf(bright.booleanValue() ? 15728880 : -1);
    }, packedLight -> {
        return Boolean.valueOf(packedLight.intValue() == 15728880);
    }), RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.intRange(0, 15).fieldOf("block").forGetter((v0) -> {
            return LightTexture.block(v0);
        }), Codec.intRange(0, 15).fieldOf("sky").forGetter((v0) -> {
            return LightTexture.sky(v0);
        })).apply(instance, (v0, v1) -> {
            return LightTexture.pack(v0, v1);
        });
    })).xmap(either -> {
        return (LightmapParticleModuleData) either.map((v1) -> {
            return new LightmapParticleModuleData(v1);
        }, (v1) -> {
            return new LightmapParticleModuleData(v1);
        });
    }, module -> {
        int packedLight2 = module.packedLight();
        if (packedLight2 == -1 || packedLight2 == 15728880) {
            return Either.left(Integer.valueOf(packedLight2));
        }
        return Either.right(Integer.valueOf(packedLight2));
    });
    private int packedLight;

    public LightmapParticleModuleData(int packedLight) {
        this.packedLight = packedLight;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        if (this.packedLight != -1) {
            builder.addModule(particle -> {
                particle.getRenderData().setFixedPackedLight(this.packedLight);
            });
        }
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.LIGHTMAP;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        int[] editBlockLight = {LightTexture.block(this.packedLight)};
        int[] editSkyLight = {LightTexture.sky(this.packedLight)};
        boolean blockLightDirty = ImGui.dragScalar("block", editBlockLight, 0.01f, 0, 15);
        boolean skyLightDirty = ImGui.dragScalar("sky", editSkyLight, 0.01f, 0, 15);
        if (blockLightDirty || skyLightDirty) {
            this.packedLight = LightTexture.pack(editBlockLight[0], editSkyLight[0]);
        }
    }

    public int packedLight() {
        return this.packedLight;
    }
}
