package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.PointAttractorForceModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/force/PointAttractorForceData.class */
public final class PointAttractorForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<PointAttractorForceData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3DC_CODEC.fieldOf("position").forGetter((v0) -> {
            return v0.position();
        }), Codec.BOOL.optionalFieldOf("localPosition", false).forGetter((v0) -> {
            return v0.invertDistanceModifier();
        }), Codec.FLOAT.fieldOf("range").forGetter((v0) -> {
            return v0.range();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        }), Codec.BOOL.fieldOf("strengthByDistance").forGetter((v0) -> {
            return v0.strengthByDistance();
        }), Codec.BOOL.optionalFieldOf("invertDistanceModifier", false).forGetter((v0) -> {
            return v0.invertDistanceModifier();
        })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
            return new PointAttractorForceData(v1, v2, v3, v4, v5, v6);
        });
    });
    private Vector3dc position;
    private boolean localPosition;
    private float range;
    private float strength;
    private boolean strengthByDistance;
    private boolean invertDistanceModifier;

    public PointAttractorForceData(Vector3dc position, boolean localPosition, float range, float strength, boolean strengthByDistance, boolean invertDistanceModifier) {
        this.position = position;
        this.localPosition = localPosition;
        this.range = range;
        this.strength = strength;
        this.strengthByDistance = strengthByDistance;
        this.invertDistanceModifier = invertDistanceModifier;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new PointAttractorForceModule(this));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.POINT_ATTRACTOR;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editPos = {(float) this.position.x(), (float) this.position.y(), (float) this.position.z()};
        if (ImGui.dragFloat3("position", editPos, 0.01f)) {
            this.position = new Vector3d(editPos[0], editPos[1], editPos[2]);
        }
        if (ImGui.checkbox("local_position", this.localPosition)) {
            this.localPosition = !this.localPosition;
        }
        float[] editRange = {this.range};
        if (ImGui.dragScalar("range", editRange, 0.01f)) {
            this.range = editRange[0];
        }
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
        if (ImGui.checkbox("strength_by_distance", this.strengthByDistance)) {
            this.strengthByDistance = !this.strengthByDistance;
        }
        if (ImGui.checkbox("invert_distance_modifier", this.invertDistanceModifier)) {
            this.invertDistanceModifier = !this.invertDistanceModifier;
        }
    }

    public Vector3dc position() {
        return this.position;
    }

    public boolean localPosition() {
        return this.localPosition;
    }

    public float range() {
        return this.range;
    }

    public float strength() {
        return this.strength;
    }

    public boolean strengthByDistance() {
        return this.strengthByDistance;
    }

    public boolean invertDistanceModifier() {
        return this.invertDistanceModifier;
    }
}
