package foundry.veil.api.quasar.data.module.force;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.force.PointForceModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/force/PointForceData.class */
public final class PointForceData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<PointForceData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3DC_CODEC.optionalFieldOf("point", new Vector3d(0.0d, 0.0d, 0.0d)).forGetter((v0) -> {
            return v0.point();
        }), Codec.BOOL.optionalFieldOf("localPoint", false).forGetter((v0) -> {
            return v0.localPoint();
        }), Codec.FLOAT.fieldOf("range").forGetter((v0) -> {
            return v0.range();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new PointForceData(v1, v2, v3, v4);
        });
    });
    private Vector3dc point;
    private boolean localPoint;
    private float range;
    private float strength;

    public PointForceData(Vector3dc point, boolean localPoint, float range, float strength) {
        this.point = point;
        this.localPoint = localPoint;
        this.range = range;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(new PointForceModule(this));
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.POINT;
    }

    public Vector3dc point() {
        return this.point;
    }

    public boolean localPoint() {
        return this.localPoint;
    }

    public float range() {
        return this.range;
    }

    public float strength() {
        return this.strength;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editPos = {(float) this.point.x(), (float) this.point.y(), (float) this.point.z()};
        if (ImGui.dragFloat3("point", editPos, 0.01f)) {
            this.point = new Vector3d(editPos[0], editPos[1], editPos[2]);
        }
        if (ImGui.checkbox("local_point", this.localPoint)) {
            this.localPoint = !this.localPoint;
        }
        float[] editRange = {this.range};
        if (ImGui.dragScalar("range", editRange, 0.01f)) {
            this.range = editRange[0];
        }
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }
}
