package software.bernie.geckolib.loading.json.typeadapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import it.unimi.dsi.fastutil.doubles.DoubleObjectPair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import net.minecraft.util.GsonHelper;
import org.apache.commons.lang3.math.NumberUtils;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.EasingType;
import software.bernie.geckolib.animation.keyframe.BoneAnimation;
import software.bernie.geckolib.animation.keyframe.Keyframe;
import software.bernie.geckolib.animation.keyframe.KeyframeStack;
import software.bernie.geckolib.loading.math.MathParser;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.value.Constant;
import software.bernie.geckolib.loading.object.BakedAnimations;
import software.bernie.geckolib.util.CompoundException;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/typeadapter/BakedAnimationsAdapter.class */
public class BakedAnimationsAdapter implements JsonDeserializer<BakedAnimations> {
    public static ConcurrentMap<Double, Constant> COMPRESSION_CACHE = null;

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public BakedAnimations m9686deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws RuntimeException {
        JsonObject obj = json.getAsJsonObject();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(obj.size());
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            try {
                object2ObjectOpenHashMap.put(entry.getKey(), bakeAnimation(entry.getKey(), entry.getValue().getAsJsonObject(), context));
            } catch (Exception ex) {
                if (ex instanceof CompoundException) {
                    CompoundException compoundEx = (CompoundException) ex;
                    GeckoLibConstants.LOGGER.error(compoundEx.withMessage("Unable to parse animation: " + entry.getKey()).getLocalizedMessage());
                } else {
                    GeckoLibConstants.LOGGER.error("Unable to parse animation: " + entry.getKey());
                }
                ex.printStackTrace();
            }
        }
        return new BakedAnimations(object2ObjectOpenHashMap);
    }

    private Animation bakeAnimation(String name, JsonObject animationObj, JsonDeserializationContext context) throws CompoundException {
        double length = animationObj.has("animation_length") ? GsonHelper.getAsDouble(animationObj, "animation_length") * 20.0d : -1.0d;
        Animation.LoopType loopType = Animation.LoopType.fromJson(animationObj.get("loop"));
        BoneAnimation[] boneAnimations = bakeBoneAnimations(GsonHelper.getAsJsonObject(animationObj, "bones", new JsonObject()));
        Animation.Keyframes keyframes = (Animation.Keyframes) context.deserialize(animationObj, Animation.Keyframes.class);
        if (length == -1.0d) {
            length = calculateAnimationLength(boneAnimations);
        }
        return new Animation(name, length, loopType, boneAnimations, keyframes);
    }

    private BoneAnimation[] bakeBoneAnimations(JsonObject bonesObj) throws CompoundException {
        BoneAnimation[] animations = new BoneAnimation[bonesObj.size()];
        int index = 0;
        for (Map.Entry<String, JsonElement> entry : bonesObj.entrySet()) {
            JsonObject entryObj = entry.getValue().getAsJsonObject();
            KeyframeStack<Keyframe<MathValue>> scaleFrames = buildKeyframeStack(getKeyframes(entryObj.get("scale")), false);
            KeyframeStack<Keyframe<MathValue>> positionFrames = buildKeyframeStack(getKeyframes(entryObj.get("position")), false);
            KeyframeStack<Keyframe<MathValue>> rotationFrames = buildKeyframeStack(getKeyframes(entryObj.get("rotation")), true);
            animations[index] = new BoneAnimation(entry.getKey(), rotationFrames, positionFrames, scaleFrames);
            index++;
        }
        return animations;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private static List<DoubleObjectPair<JsonElement>> getKeyframes(JsonElement element) throws JsonParseException {
        if (element == null) {
            return List.of();
        }
        if (element instanceof JsonPrimitive) {
            JsonPrimitive primitive = (JsonPrimitive) element;
            JsonElement jsonArray = new JsonArray(3);
            jsonArray.add(primitive);
            jsonArray.add(primitive);
            jsonArray.add(primitive);
            element = jsonArray;
        }
        if (element instanceof JsonArray) {
            JsonArray array = (JsonArray) element;
            return ObjectArrayList.of(new DoubleObjectPair[]{DoubleObjectPair.of(0.0d, array)});
        }
        if (element instanceof JsonObject) {
            JsonObject obj = (JsonObject) element;
            if (obj.has("vector")) {
                return ObjectArrayList.of(new DoubleObjectPair[]{DoubleObjectPair.of(0.0d, obj)});
            }
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                double timestamp = readTimestamp(entry.getKey());
                if (timestamp == 0.0d && !objectArrayList.isEmpty()) {
                    throw new JsonParseException("Invalid keyframe data - multiple starting keyframes?" + entry.getKey());
                }
                JsonElement value = entry.getValue();
                if (value instanceof JsonObject) {
                    JsonObject entryObj = (JsonObject) value;
                    if (!entryObj.has("vector")) {
                        addBedrockKeyframes(timestamp, entryObj, objectArrayList);
                    }
                }
                objectArrayList.add(DoubleObjectPair.of(timestamp, entry.getValue()));
            }
            return objectArrayList;
        }
        throw new JsonParseException("Invalid object type provided to getTripletObj, got: " + String.valueOf(element));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private static JsonArray extractBedrockKeyframe(JsonElement keyframe) throws JsonParseException {
        if (keyframe.isJsonArray()) {
            return keyframe.getAsJsonArray();
        }
        if (!keyframe.isJsonObject()) {
            throw new JsonParseException("Invalid keyframe data - expected array or object, found " + String.valueOf(keyframe));
        }
        JsonObject keyframeObj = keyframe.getAsJsonObject();
        if (keyframeObj.has("vector")) {
            return keyframeObj.get("vector").getAsJsonArray();
        }
        if (keyframeObj.has("pre")) {
            return keyframeObj.get("pre").getAsJsonArray();
        }
        return keyframeObj.get("post").getAsJsonArray();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private static void addBedrockKeyframes(double timestamp, JsonObject keyframe, List<DoubleObjectPair<JsonElement>> keyframes) throws JsonParseException {
        boolean addedFrame = false;
        if (keyframe.has("pre")) {
            addedFrame = true;
            keyframes.add(DoubleObjectPair.of(timestamp == 0.0d ? timestamp : timestamp - 0.001d, extractBedrockKeyframe(keyframe.get("pre"))));
        }
        if (keyframe.has("post")) {
            JsonArray values = extractBedrockKeyframe(keyframe.get("post"));
            if (keyframe.has("lerp_mode")) {
                JsonObject keyframeObj = new JsonObject();
                keyframeObj.add("vector", values);
                keyframeObj.add("easing", keyframe.get("lerp_mode"));
                keyframes.add(DoubleObjectPair.of(timestamp, keyframeObj));
                return;
            }
            keyframes.add(DoubleObjectPair.of(timestamp, values));
            return;
        }
        if (!addedFrame) {
            throw new JsonParseException("Invalid keyframe data - expected array, found " + String.valueOf(keyframe));
        }
    }

    private KeyframeStack<Keyframe<MathValue>> buildKeyframeStack(List<DoubleObjectPair<JsonElement>> entries, boolean isForRotation) throws CompoundException {
        JsonArray asJsonArray;
        JsonObject jsonObject;
        List<MathValue> objectArrayList;
        if (entries.isEmpty()) {
            return new KeyframeStack<>();
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        ObjectArrayList objectArrayList4 = new ObjectArrayList();
        MathValue xPrev = null;
        MathValue yPrev = null;
        MathValue zPrev = null;
        DoubleObjectPair<JsonElement> prevEntry = null;
        for (DoubleObjectPair<JsonElement> entry : entries) {
            JsonObject jsonObject2 = (JsonElement) entry.right();
            double prevTime = prevEntry != null ? prevEntry.leftDouble() : 0.0d;
            double curTime = entry.leftDouble();
            double timeDelta = curTime - prevTime;
            if (jsonObject2 instanceof JsonArray) {
                JsonArray array = (JsonArray) jsonObject2;
                asJsonArray = array;
            } else {
                asJsonArray = GsonHelper.getAsJsonArray(jsonObject2.getAsJsonObject(), "vector");
            }
            JsonArray keyFrameVector = asJsonArray;
            MathValue rawXValue = MathParser.parseJson(keyFrameVector.get(0));
            MathValue rawYValue = MathParser.parseJson(keyFrameVector.get(1));
            MathValue rawZValue = MathParser.parseJson(keyFrameVector.get(2));
            MathValue xValue = compressMathValue((isForRotation && (rawXValue instanceof Constant)) ? new Constant(Math.toRadians(-rawXValue.get())) : rawXValue);
            MathValue yValue = compressMathValue((isForRotation && (rawYValue instanceof Constant)) ? new Constant(Math.toRadians(-rawYValue.get())) : rawYValue);
            MathValue zValue = compressMathValue((isForRotation && (rawZValue instanceof Constant)) ? new Constant(Math.toRadians(rawZValue.get())) : rawZValue);
            if (jsonObject2 instanceof JsonObject) {
                JsonObject obj = jsonObject2;
                jsonObject = obj;
            } else {
                jsonObject = null;
            }
            JsonObject entryObj = jsonObject;
            EasingType easingType = (entryObj == null || !entryObj.has("easing")) ? EasingType.LINEAR : EasingType.fromJson(entryObj.get("easing"));
            if (entryObj != null && entryObj.has("easingArgs")) {
                objectArrayList = JsonUtil.jsonArrayToList(GsonHelper.getAsJsonArray(entryObj, "easingArgs"), ele -> {
                    return new Constant(ele.getAsDouble());
                });
            } else {
                objectArrayList = new ObjectArrayList<>();
            }
            List<MathValue> easingArgs = objectArrayList;
            objectArrayList2.add(new Keyframe<>(timeDelta * 20.0d, prevEntry == null ? xValue : xPrev, xValue, easingType, easingArgs));
            objectArrayList3.add(new Keyframe<>(timeDelta * 20.0d, prevEntry == null ? yValue : yPrev, yValue, easingType, easingArgs));
            objectArrayList4.add(new Keyframe<>(timeDelta * 20.0d, prevEntry == null ? zValue : zPrev, zValue, easingType, easingArgs));
            xPrev = xValue;
            yPrev = yValue;
            zPrev = zValue;
            prevEntry = entry;
        }
        return new KeyframeStack<>(addSplineArgs(objectArrayList2), addSplineArgs(objectArrayList3), addSplineArgs(objectArrayList4));
    }

    private List<Keyframe<MathValue>> addSplineArgs(List<Keyframe<MathValue>> frames) {
        if (frames.size() == 1) {
            Keyframe<MathValue> frame = (Keyframe) frames.getFirst();
            if (frame.easingType() != EasingType.LINEAR) {
                frames.set(0, new Keyframe<>(frame.length(), frame.startValue(), frame.endValue()));
                return frames;
            }
        }
        int i = 0;
        while (i < frames.size()) {
            Keyframe<MathValue> frame2 = frames.get(i);
            if (frame2.easingType() == EasingType.CATMULLROM) {
                int i2 = i;
                double length = frame2.length();
                MathValue mathValueStartValue = frame2.startValue();
                MathValue mathValueEndValue = frame2.endValue();
                EasingType easingType = frame2.easingType();
                MathValue[] mathValueArr = new MathValue[2];
                mathValueArr[0] = i == 0 ? frame2.startValue() : frames.get(i - 1).endValue();
                mathValueArr[1] = i + 1 >= frames.size() ? frame2.endValue() : frames.get(i + 1).endValue();
                frames.set(i2, new Keyframe<>(length, mathValueStartValue, mathValueEndValue, easingType, ObjectArrayList.of(mathValueArr)));
            }
            i++;
        }
        return frames;
    }

    private MathValue compressMathValue(MathValue input) {
        if (COMPRESSION_CACHE == null || input.isMutable()) {
            return input;
        }
        return COMPRESSION_CACHE.computeIfAbsent(Double.valueOf(input.get()), (v1) -> {
            return new Constant(v1);
        });
    }

    private static double calculateAnimationLength(BoneAnimation[] boneAnimations) {
        double length = 0.0d;
        for (BoneAnimation animation : boneAnimations) {
            length = Math.max(Math.max(Math.max(length, animation.rotationKeyFrames().getLastKeyframeTime()), animation.positionKeyFrames().getLastKeyframeTime()), animation.scaleKeyFrames().getLastKeyframeTime());
        }
        if (length == 0.0d) {
            return Double.MAX_VALUE;
        }
        return length;
    }

    private static double readTimestamp(String timestamp) {
        if (NumberUtils.isCreatable(timestamp)) {
            return Double.parseDouble(timestamp);
        }
        return 0.0d;
    }
}
