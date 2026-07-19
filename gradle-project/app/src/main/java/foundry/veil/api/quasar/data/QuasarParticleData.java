package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.RenderStyle;
import foundry.veil.api.quasar.particle.SpriteData;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/QuasarParticleData.class */
public final class QuasarParticleData {
    public static final Codec<QuasarParticleData> DIRECT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("should_collide", true).forGetter((v0) -> {
            return v0.shouldCollide();
        }), Codec.BOOL.optionalFieldOf("face_velocity", false).forGetter((v0) -> {
            return v0.faceVelocity();
        }), Codec.FLOAT.optionalFieldOf("velocity_stretch_factor", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.velocityStretchFactor();
        }), ParticleModuleData.CODEC.listOf().optionalFieldOf("modules", Collections.emptyList()).forGetter((v0) -> {
            return v0.modules();
        }), SpriteData.CODEC.optionalFieldOf("sprite_data").forGetter(data -> {
            return Optional.ofNullable(data.spriteData());
        }), Codec.BOOL.optionalFieldOf("additive", false).forGetter((v0) -> {
            return v0.additive();
        }), RenderStyle.CODEC.optionalFieldOf("render_style").forGetter(particleData -> {
            return Optional.of(particleData.renderStyle());
        })).apply(instance, (shouldCollide, faceVelocity, velocityStretchFactor, modules, spriteData, additive, renderStyle) -> {
            return new QuasarParticleData(shouldCollide.booleanValue(), faceVelocity.booleanValue(), velocityStretchFactor.floatValue(), modules, (SpriteData) spriteData.orElse(null), additive.booleanValue(), (RenderStyle) renderStyle.orElseGet(RenderStyleRegistry.BILLBOARD));
        });
    });
    public static final Codec<Holder<QuasarParticleData>> CODEC = RegistryFileCodec.create(QuasarParticles.PARTICLE_DATA, DIRECT_CODEC);
    private boolean shouldCollide;
    private boolean faceVelocity;
    private float velocityStretchFactor;
    private final List<Holder<ParticleModuleData>> modules;
    private final List<Holder<ParticleModuleData>> modulesView;

    @Nullable
    private SpriteData spriteData;
    private boolean additive;
    private RenderStyle renderStyle;

    public QuasarParticleData(boolean shouldCollide, boolean faceVelocity, float velocityStretchFactor, List<Holder<ParticleModuleData>> modules, @Nullable SpriteData spriteData, boolean additive, RenderStyle renderStyle) {
        this.shouldCollide = shouldCollide;
        this.faceVelocity = faceVelocity;
        this.velocityStretchFactor = velocityStretchFactor;
        this.modules = new ArrayList(modules);
        this.modulesView = Collections.unmodifiableList(modules);
        this.spriteData = spriteData;
        this.additive = additive;
        this.renderStyle = renderStyle;
    }

    @Nullable
    public ResourceLocation getRegistryId() {
        return (ResourceLocation) QuasarParticles.registryAccess().registry(QuasarParticles.PARTICLE_DATA).map(registry -> {
            return registry.getKey(this);
        }).orElse(null);
    }

    public boolean shouldCollide() {
        return this.shouldCollide;
    }

    public void setShouldCollide(boolean shouldCollide) {
        this.shouldCollide = shouldCollide;
    }

    public boolean faceVelocity() {
        return this.faceVelocity;
    }

    public void setFaceVelocity(boolean faceVelocity) {
        this.faceVelocity = faceVelocity;
    }

    public float velocityStretchFactor() {
        return this.velocityStretchFactor;
    }

    public void setVelocityStretchFactor(float velocityStretchFactor) {
        this.velocityStretchFactor = velocityStretchFactor;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public List<Holder<ParticleModuleData>> getAllModules() {
        return new ArrayList(this.modules);
    }

    public List<Holder<ParticleModuleData>> modules() {
        return this.modulesView;
    }

    @Nullable
    public SpriteData spriteData() {
        return this.spriteData;
    }

    public void setSpriteData(@Nullable SpriteData data) {
        this.spriteData = data;
    }

    public boolean additive() {
        return this.additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public RenderStyle renderStyle() {
        return this.renderStyle;
    }

    public void setRenderStyle(RenderStyle renderStyle) {
        this.renderStyle = renderStyle;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        QuasarParticleData that = (QuasarParticleData) obj;
        return this.shouldCollide == that.shouldCollide && this.faceVelocity == that.faceVelocity && Float.floatToIntBits(this.velocityStretchFactor) == Float.floatToIntBits(that.velocityStretchFactor) && Objects.equals(this.modules, that.modules) && Objects.equals(this.spriteData, that.spriteData) && this.additive == that.additive && Objects.equals(this.renderStyle, that.renderStyle);
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.shouldCollide);
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * result) + Boolean.hashCode(this.faceVelocity))) + Float.hashCode(this.velocityStretchFactor))) + this.modules.hashCode())) + this.modulesView.hashCode())) + Objects.hashCode(this.spriteData))) + Boolean.hashCode(this.additive))) + this.renderStyle.hashCode();
    }

    public String toString() {
        return "QuasarParticleData[shouldCollide=" + this.shouldCollide + ", faceVelocity=" + this.faceVelocity + ", velocityStretchFactor=" + this.velocityStretchFactor + ", modules=" + String.valueOf(this.modules) + ", spriteData=" + String.valueOf(this.spriteData) + ", additive=" + this.additive + ", renderStyle=" + String.valueOf(this.renderStyle) + "]";
    }
}
