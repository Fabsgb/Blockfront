package foundry.veil.api.quasar.emitters.module.render;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.quasar.p002fx.Trail;
import foundry.veil.api.util.CodecUtil;
import imgui.ImGui;
import imgui.type.ImBoolean;
import imgui.type.ImFloat;
import imgui.type.ImInt;
import imgui.type.ImString;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/render/TrailSettings.class */
public class TrailSettings implements EditorAttributeProvider {
    public static final Codec<TrailSettings> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.optionalFieldOf("trailFrequency", 1).forGetter(settings -> {
            return Integer.valueOf(settings.trailFrequency);
        }), Codec.INT.optionalFieldOf("trailLength", 20).forGetter(settings2 -> {
            return Integer.valueOf(settings2.trailLength);
        }), CodecUtil.VECTOR4FC_CODEC.optionalFieldOf("trailColor", new Vector4f(1.0f)).forGetter(settings3 -> {
            return settings3.trailColor;
        }), Codec.FLOAT.fieldOf("trailWidthModifier").forGetter(settings4 -> {
            return Float.valueOf(settings4.trailWidthModifierFloat);
        }), ResourceLocation.CODEC.optionalFieldOf("trailTexture").forGetter(settings5 -> {
            return Optional.ofNullable(settings5.trailTexture);
        }), Codec.FLOAT.fieldOf("trailPointModifier").forGetter(settings6 -> {
            return Float.valueOf(1.0f);
        }), Trail.TilingMode.CODEC.optionalFieldOf("tilingMode", Trail.TilingMode.STRETCH).forGetter(settings7 -> {
            return settings7.tilingMode;
        }), Codec.BOOL.optionalFieldOf("billboard", true).forGetter(settings8 -> {
            return Boolean.valueOf(settings8.billboard);
        }), Codec.BOOL.optionalFieldOf("additive", false).forGetter(settings9 -> {
            return Boolean.valueOf(settings9.additive);
        }), Codec.BOOL.optionalFieldOf("parentRotation", false).forGetter(settings10 -> {
            return Boolean.valueOf(settings10.parentRotation);
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10) -> {
            return new TrailSettings(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
        });
    });
    private int trailFrequency;
    private int trailLength;
    private Vector4f trailColor;
    private TrailWidthModifier trailWidthModifier;
    private TrailPointModifier trailPointModifier;
    private ResourceLocation trailTexture;
    private Trail.TilingMode tilingMode;
    private boolean billboard;
    private boolean additive;
    private boolean parentRotation;
    private float trailWidthModifierFloat;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/render/TrailSettings$TrailPointModifier.class */
    @FunctionalInterface
    public interface TrailPointModifier {
        Vector4f modify(Vector4f vector4f, Integer num, Vec3 vec3);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/render/TrailSettings$TrailWidthModifier.class */
    @FunctionalInterface
    public interface TrailWidthModifier {
        float modify(float f, double d);
    }

    @Deprecated
    public TrailSettings(int trailFrequency, int trailLength, Vector4fc trailColor, TrailWidthModifier trailWidthModifier, @Nullable ResourceLocation trailTexture, TrailPointModifier trailPointModifier, Trail.TilingMode tilingMode, boolean billboard, boolean parentRotation) {
        this(trailFrequency, trailLength, trailColor, trailWidthModifier, trailTexture, trailPointModifier, tilingMode, billboard, false, parentRotation);
    }

    public TrailSettings(int trailFrequency, int trailLength, Vector4fc trailColor, TrailWidthModifier trailWidthModifier, @Nullable ResourceLocation trailTexture, TrailPointModifier trailPointModifier, Trail.TilingMode tilingMode, boolean billboard, boolean additive, boolean parentRotation) {
        this.trailWidthModifierFloat = 1.0f;
        this.trailFrequency = trailFrequency;
        this.trailLength = trailLength;
        this.trailColor = new Vector4f(trailColor);
        this.trailWidthModifier = trailWidthModifier;
        this.trailTexture = trailTexture;
        this.trailPointModifier = trailPointModifier;
        this.tilingMode = tilingMode;
        this.billboard = billboard;
        this.additive = additive;
        this.parentRotation = parentRotation;
    }

    private TrailSettings(int trailFrequency, int trailLength, Vector4fc trailColor, float trailWidthModifier, Optional<ResourceLocation> trailTexture, float trailPointModifier, Trail.TilingMode tilingMode, boolean billboard, boolean additive, boolean parentRotation) {
        this.trailWidthModifierFloat = 1.0f;
        this.trailFrequency = trailFrequency;
        this.trailLength = trailLength;
        this.trailColor = new Vector4f(trailColor);
        this.trailWidthModifier = (width, ageScale) -> {
            return (((float) Math.sin(((double) width) * 3.15d)) / 2.0f) * trailWidthModifier * this.trailWidthModifierFloat;
        };
        this.trailTexture = trailTexture.orElse(null);
        this.trailPointModifier = (point, index, velocity) -> {
            return point;
        };
        this.tilingMode = tilingMode;
        this.billboard = billboard;
        this.additive = additive;
        this.parentRotation = parentRotation;
    }

    public TrailSettings() {
        this(1, 20, (Vector4fc) new Vector4f(1.0f), 1.0f, (Optional<ResourceLocation>) Optional.empty(), 1.0f, Trail.TilingMode.STRETCH, true, false, false);
    }

    public void setParentRotation(boolean parentRotation) {
        this.parentRotation = parentRotation;
    }

    public boolean getParentRotation() {
        return this.parentRotation;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public void setBillboard(boolean billboard) {
        this.billboard = billboard;
    }

    public boolean getBillboard() {
        return this.billboard;
    }

    public void setTilingMode(Trail.TilingMode tilingMode) {
        this.tilingMode = tilingMode;
    }

    public Trail.TilingMode getTilingMode() {
        return this.tilingMode;
    }

    public void setTrailPointModifier(TrailPointModifier trailPointModifier) {
        this.trailPointModifier = trailPointModifier;
    }

    public TrailPointModifier getTrailPointModifier() {
        return this.trailPointModifier;
    }

    public void setTrailFrequency(int trailFrequency) {
        this.trailFrequency = trailFrequency;
    }

    public void setTrailLength(int trailLength) {
        this.trailLength = trailLength;
    }

    public void setTrailColor(Vector4f trailColor) {
        this.trailColor = trailColor;
    }

    public void setTrailWidthModifier(TrailWidthModifier trailWidthModifier) {
        this.trailWidthModifier = trailWidthModifier;
    }

    public void setTrailTexture(@Nullable ResourceLocation trailTexture) {
        this.trailTexture = trailTexture;
    }

    public int getTrailFrequency() {
        return this.trailFrequency;
    }

    public int getTrailLength() {
        return this.trailLength;
    }

    public Vector4f getTrailColor() {
        return this.trailColor;
    }

    public TrailWidthModifier getTrailWidthModifier() {
        return this.trailWidthModifier;
    }

    @Nullable
    public ResourceLocation getTrailTexture() {
        return this.trailTexture;
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        ImString trailTextureString = new ImString(this.trailTexture == null ? "" : this.trailTexture.toString(), 999);
        if (ImGui.inputTextWithHint("Trail Texture", "namespace:path", trailTextureString)) {
            if (trailTextureString.isEmpty()) {
                this.trailTexture = null;
            }
            try {
                this.trailTexture = ResourceLocation.parse(trailTextureString.get());
            } catch (Exception e) {
            }
        }
        ImInt trailFrequencyInt = new ImInt(this.trailFrequency);
        ImGui.inputInt("Trail Frequency", trailFrequencyInt);
        this.trailFrequency = trailFrequencyInt.get();
        ImInt trailLengthInt = new ImInt(this.trailLength);
        ImGui.inputInt("Trail Length", trailLengthInt);
        this.trailLength = trailLengthInt.get();
        float[] trailColorVector4f = {this.trailColor.x(), this.trailColor.y(), this.trailColor.z(), this.trailColor.w()};
        ImGui.colorEdit4("Trail Color", trailColorVector4f, 196608);
        this.trailColor = new Vector4f(trailColorVector4f[0], trailColorVector4f[1], trailColorVector4f[2], trailColorVector4f[3]);
        if (ImGui.beginCombo("Tiling Mode", this.tilingMode.name())) {
            ImGui.pushItemWidth(-1.0f);
            Trail.TilingMode[] tilingModes = Trail.TilingMode.values();
            for (Trail.TilingMode tilingMode : tilingModes) {
                if (ImGui.selectable(tilingMode.name())) {
                    this.tilingMode = tilingMode;
                }
            }
            ImGui.popItemWidth();
            ImGui.endCombo();
        }
        ImBoolean billboardBoolean = new ImBoolean(this.billboard);
        ImGui.checkbox("Billboard", billboardBoolean);
        this.billboard = billboardBoolean.get();
        ImBoolean additiveBoolean = new ImBoolean(this.additive);
        ImGui.checkbox("Additive", additiveBoolean);
        this.additive = additiveBoolean.get();
        ImBoolean parentRotationBoolean = new ImBoolean(this.parentRotation);
        ImGui.checkbox("Parent Rotation", parentRotationBoolean);
        this.parentRotation = parentRotationBoolean.get();
        ImFloat trailWidthModifierFloat = new ImFloat(this.trailWidthModifierFloat);
        ImGui.inputFloat("Trail Width Modifier", trailWidthModifierFloat);
        this.trailWidthModifierFloat = trailWidthModifierFloat.get();
    }
}
