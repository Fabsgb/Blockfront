package foundry.veil.api.quasar.data.module.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/init/InitialVelocityModuleData.class */
public final class InitialVelocityModuleData implements ParticleModuleData, EditorAttributeProvider {
    public static final MapCodec<InitialVelocityModuleData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3DC_CODEC.fieldOf("direction").forGetter((v0) -> {
            return v0.velocityDirection();
        }), Codec.BOOL.fieldOf("take_parent_rotation").orElse(true).forGetter((v0) -> {
            return v0.takesParentRotation();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2, v3) -> {
            return new InitialVelocityModuleData(v1, v2, v3);
        });
    });
    private Vector3dc velocityDirection;
    private boolean takesParentRotation;
    private float strength;

    public InitialVelocityModuleData(Vector3dc velocityDirection, boolean takesParentRotation, float strength) {
        this.velocityDirection = velocityDirection;
        this.takesParentRotation = takesParentRotation;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(particle -> {
            particle.getVelocity().add(this.velocityDirection.normalize(this.strength, new Vector3d()));
        });
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.INITIAL_VELOCITY;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editDirection = {(float) this.velocityDirection.x(), (float) this.velocityDirection.y(), (float) this.velocityDirection.z()};
        if (ImGui.dragFloat3("direction", editDirection, 0.01f)) {
            this.velocityDirection = new Vector3d(editDirection[0], editDirection[1], editDirection[2]);
        }
        if (ImGui.checkbox("takes_parent_rotation", this.takesParentRotation)) {
            this.takesParentRotation = !this.takesParentRotation;
        }
        float[] editStrength = {this.strength};
        if (ImGui.dragScalar("strength", editStrength, 0.01f)) {
            this.strength = editStrength[0];
        }
    }

    public Vector3dc velocityDirection() {
        return this.velocityDirection;
    }

    public boolean takesParentRotation() {
        return this.takesParentRotation;
    }

    public float strength() {
        return this.strength;
    }
}
