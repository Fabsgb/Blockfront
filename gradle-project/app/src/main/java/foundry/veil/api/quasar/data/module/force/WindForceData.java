package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.ConstantForceModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/force/WindForceData.class */
public final class WindForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<WindForceData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3DC_CODEC.fieldOf("wind_direction").forGetter((v0) -> {
            return v0.windDirection();
        }), Codec.FLOAT.fieldOf("wind_speed").forGetter((v0) -> {
            return v0.windSpeed();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2, v3) -> {
            return new WindForceData(v1, v2, v3);
        });
    });
    private Vector3dc windDirection;
    private float windSpeed;
    private float strength;

    public WindForceData(Vector3dc windDirection, float windSpeed, float strength) {
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new ConstantForceModule(this.windDirection.normalize(this.windSpeed, new Vector3d())));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.WIND;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editDirection = {(float) this.windDirection.x(), (float) this.windDirection.y(), (float) this.windDirection.z()};
        if (ImGui.dragFloat3("wind_direction", editDirection, 0.01f)) {
            this.windDirection = new Vector3d(editDirection[0], editDirection[1], editDirection[2]);
        }
        float[] editRange = {this.windSpeed};
        if (ImGui.dragScalar("wind_speed", editRange, 0.01f)) {
            this.windSpeed = editRange[0];
        }
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }

    public Vector3dc windDirection() {
        return this.windDirection;
    }

    public float windSpeed() {
        return this.windSpeed;
    }

    public float strength() {
        return this.strength;
    }
}
