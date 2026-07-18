package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.VortexForceModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/force/VortexForceData.class */
public final class VortexForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<VortexForceData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3DC_CODEC.fieldOf("vortex_axis").forGetter((v0) -> {
            return v0.vortexAxis();
        }), CodecUtil.VECTOR3DC_CODEC.fieldOf("vortex_center").forGetter((v0) -> {
            return v0.vortexCenter();
        }), Codec.BOOL.optionalFieldOf("local_position", false).forGetter((v0) -> {
            return v0.localPosition();
        }), Codec.DOUBLE.fieldOf("range").forGetter((v0) -> {
            return v0.range();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new VortexForceData(v1, v2, v3, v4, v5);
        });
    });
    private Vector3dc vortexAxis;
    private Vector3dc vortexCenter;
    private boolean localPosition;
    private double range;
    private float strength;

    public VortexForceData(Vector3dc vortexAxis, Vector3dc vortexCenter, boolean localPosition, double range, float strength) {
        this.vortexAxis = vortexAxis;
        this.vortexCenter = vortexCenter;
        this.localPosition = localPosition;
        this.range = range;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new VortexForceModule(this));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.VORTEX;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editAxis = {(float) this.vortexAxis.x(), (float) this.vortexAxis.y(), (float) this.vortexAxis.z()};
        if (ImGui.dragFloat3("vortex_axis", editAxis, 0.01f)) {
            this.vortexAxis = new Vector3d(editAxis[0], editAxis[1], editAxis[2]);
        }
        float[] editPos = {(float) this.vortexCenter.x(), (float) this.vortexCenter.y(), (float) this.vortexCenter.z()};
        if (ImGui.dragFloat3("vortex_center", editPos, 0.01f)) {
            this.vortexCenter = new Vector3d(editPos[0], editPos[1], editPos[2]);
        }
        if (ImGui.checkbox("local_position", this.localPosition)) {
            this.localPosition = !this.localPosition;
        }
        double[] editRange = {this.range};
        if (ImGui.dragScalar("range", editRange, 0.01f)) {
            this.range = editRange[0];
        }
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }

    public Vector3dc vortexAxis() {
        return this.vortexAxis;
    }

    public Vector3dc vortexCenter() {
        return this.vortexCenter;
    }

    public boolean localPosition() {
        return this.localPosition;
    }

    public double range() {
        return this.range;
    }

    public float strength() {
        return this.strength;
    }
}
