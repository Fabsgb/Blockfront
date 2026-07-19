package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/ModelProperties.class */
public final class ModelProperties extends Record {

    @Nullable
    private final Boolean animationArmsDown;

    @Nullable
    private final Boolean animationArmsOutFront;

    @Nullable
    private final Boolean animationDontShowArmor;

    @Nullable
    private final Boolean animationInvertedCrouch;

    @Nullable
    private final Boolean animationNoHeadBob;

    @Nullable
    private final Boolean animationSingleArmAnimation;

    @Nullable
    private final Boolean animationSingleLegAnimation;

    @Nullable
    private final Boolean animationStationaryLegs;

    @Nullable
    private final Boolean animationStatueOfLibertyArms;

    @Nullable
    private final Boolean animationUpsideDown;

    @Nullable
    private final String identifier;

    @Nullable
    private final Boolean preserveModelPose;
    private final double textureHeight;
    private final double textureWidth;

    @Nullable
    private final Double visibleBoundsHeight;
    private final double[] visibleBoundsOffset;

    @Nullable
    private final Double visibleBoundsWidth;

    public ModelProperties(@Nullable Boolean animationArmsDown, @Nullable Boolean animationArmsOutFront, @Nullable Boolean animationDontShowArmor, @Nullable Boolean animationInvertedCrouch, @Nullable Boolean animationNoHeadBob, @Nullable Boolean animationSingleArmAnimation, @Nullable Boolean animationSingleLegAnimation, @Nullable Boolean animationStationaryLegs, @Nullable Boolean animationStatueOfLibertyArms, @Nullable Boolean animationUpsideDown, @Nullable String identifier, @Nullable Boolean preserveModelPose, double textureHeight, double textureWidth, @Nullable Double visibleBoundsHeight, double[] visibleBoundsOffset, @Nullable Double visibleBoundsWidth) {
        this.animationArmsDown = animationArmsDown;
        this.animationArmsOutFront = animationArmsOutFront;
        this.animationDontShowArmor = animationDontShowArmor;
        this.animationInvertedCrouch = animationInvertedCrouch;
        this.animationNoHeadBob = animationNoHeadBob;
        this.animationSingleArmAnimation = animationSingleArmAnimation;
        this.animationSingleLegAnimation = animationSingleLegAnimation;
        this.animationStationaryLegs = animationStationaryLegs;
        this.animationStatueOfLibertyArms = animationStatueOfLibertyArms;
        this.animationUpsideDown = animationUpsideDown;
        this.identifier = identifier;
        this.preserveModelPose = preserveModelPose;
        this.textureHeight = textureHeight;
        this.textureWidth = textureWidth;
        this.visibleBoundsHeight = visibleBoundsHeight;
        this.visibleBoundsOffset = visibleBoundsOffset;
        this.visibleBoundsWidth = visibleBoundsWidth;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ModelProperties.class), ModelProperties.class, "animationArmsDown;animationArmsOutFront;animationDontShowArmor;animationInvertedCrouch;animationNoHeadBob;animationSingleArmAnimation;animationSingleLegAnimation;animationStationaryLegs;animationStatueOfLibertyArms;animationUpsideDown;identifier;preserveModelPose;textureHeight;textureWidth;visibleBoundsHeight;visibleBoundsOffset;visibleBoundsWidth", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsOutFront:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationDontShowArmor:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationInvertedCrouch:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationNoHeadBob:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleArmAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleLegAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStationaryLegs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStatueOfLibertyArms:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationUpsideDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->identifier:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->preserveModelPose:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureHeight:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureWidth:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsHeight:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsOffset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsWidth:Ljava/lang/Double;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ModelProperties.class), ModelProperties.class, "animationArmsDown;animationArmsOutFront;animationDontShowArmor;animationInvertedCrouch;animationNoHeadBob;animationSingleArmAnimation;animationSingleLegAnimation;animationStationaryLegs;animationStatueOfLibertyArms;animationUpsideDown;identifier;preserveModelPose;textureHeight;textureWidth;visibleBoundsHeight;visibleBoundsOffset;visibleBoundsWidth", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsOutFront:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationDontShowArmor:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationInvertedCrouch:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationNoHeadBob:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleArmAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleLegAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStationaryLegs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStatueOfLibertyArms:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationUpsideDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->identifier:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->preserveModelPose:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureHeight:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureWidth:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsHeight:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsOffset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsWidth:Ljava/lang/Double;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ModelProperties.class, Object.class), ModelProperties.class, "animationArmsDown;animationArmsOutFront;animationDontShowArmor;animationInvertedCrouch;animationNoHeadBob;animationSingleArmAnimation;animationSingleLegAnimation;animationStationaryLegs;animationStatueOfLibertyArms;animationUpsideDown;identifier;preserveModelPose;textureHeight;textureWidth;visibleBoundsHeight;visibleBoundsOffset;visibleBoundsWidth", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationArmsOutFront:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationDontShowArmor:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationInvertedCrouch:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationNoHeadBob:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleArmAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationSingleLegAnimation:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStationaryLegs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationStatueOfLibertyArms:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->animationUpsideDown:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->identifier:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->preserveModelPose:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureHeight:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->textureWidth:D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsHeight:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsOffset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;->visibleBoundsWidth:Ljava/lang/Double;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public Boolean animationArmsDown() {
        return this.animationArmsDown;
    }

    @Nullable
    public Boolean animationArmsOutFront() {
        return this.animationArmsOutFront;
    }

    @Nullable
    public Boolean animationDontShowArmor() {
        return this.animationDontShowArmor;
    }

    @Nullable
    public Boolean animationInvertedCrouch() {
        return this.animationInvertedCrouch;
    }

    @Nullable
    public Boolean animationNoHeadBob() {
        return this.animationNoHeadBob;
    }

    @Nullable
    public Boolean animationSingleArmAnimation() {
        return this.animationSingleArmAnimation;
    }

    @Nullable
    public Boolean animationSingleLegAnimation() {
        return this.animationSingleLegAnimation;
    }

    @Nullable
    public Boolean animationStationaryLegs() {
        return this.animationStationaryLegs;
    }

    @Nullable
    public Boolean animationStatueOfLibertyArms() {
        return this.animationStatueOfLibertyArms;
    }

    @Nullable
    public Boolean animationUpsideDown() {
        return this.animationUpsideDown;
    }

    @Nullable
    public String identifier() {
        return this.identifier;
    }

    @Nullable
    public Boolean preserveModelPose() {
        return this.preserveModelPose;
    }

    public double textureHeight() {
        return this.textureHeight;
    }

    public double textureWidth() {
        return this.textureWidth;
    }

    @Nullable
    public Double visibleBoundsHeight() {
        return this.visibleBoundsHeight;
    }

    public double[] visibleBoundsOffset() {
        return this.visibleBoundsOffset;
    }

    @Nullable
    public Double visibleBoundsWidth() {
        return this.visibleBoundsWidth;
    }

    public static JsonDeserializer<ModelProperties> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            Boolean animationArmsDown = JsonUtil.getOptionalBoolean(obj, "animationArmsDown");
            Boolean animationArmsOutFront = JsonUtil.getOptionalBoolean(obj, "animationArmsOutFront");
            Boolean animationDontShowArmor = JsonUtil.getOptionalBoolean(obj, "animationDontShowArmor");
            Boolean animationInvertedCrouch = JsonUtil.getOptionalBoolean(obj, "animationInvertedCrouch");
            Boolean animationNoHeadBob = JsonUtil.getOptionalBoolean(obj, "animationNoHeadBob");
            Boolean animationSingleArmAnimation = JsonUtil.getOptionalBoolean(obj, "animationSingleArmAnimation");
            Boolean animationSingleLegAnimation = JsonUtil.getOptionalBoolean(obj, "animationSingleLegAnimation");
            Boolean animationStationaryLegs = JsonUtil.getOptionalBoolean(obj, "animationStationaryLegs");
            Boolean animationStatueOfLibertyArms = JsonUtil.getOptionalBoolean(obj, "animationStatueOfLibertyArms");
            Boolean animationUpsideDown = JsonUtil.getOptionalBoolean(obj, "animationUpsideDown");
            String identifier = GsonHelper.getAsString(obj, "identifier", (String) null);
            Boolean preserveModelPose = JsonUtil.getOptionalBoolean(obj, "preserve_model_pose");
            double textureHeight = GsonHelper.getAsDouble(obj, "texture_height");
            double textureWidth = GsonHelper.getAsDouble(obj, "texture_width");
            Double visibleBoundsHeight = JsonUtil.getOptionalDouble(obj, "visible_bounds_height");
            double[] visibleBoundsOffset = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "visible_bounds_offset", (JsonArray) null));
            Double visibleBoundsWidth = JsonUtil.getOptionalDouble(obj, "visible_bounds_width");
            return new ModelProperties(animationArmsDown, animationArmsOutFront, animationDontShowArmor, animationInvertedCrouch, animationNoHeadBob, animationSingleArmAnimation, animationSingleLegAnimation, animationStationaryLegs, animationStatueOfLibertyArms, animationUpsideDown, identifier, preserveModelPose, textureHeight, textureWidth, visibleBoundsHeight, visibleBoundsOffset, visibleBoundsWidth);
        };
    }
}
