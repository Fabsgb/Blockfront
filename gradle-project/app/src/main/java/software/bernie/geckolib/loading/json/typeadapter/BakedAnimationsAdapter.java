package software.bernie.geckolib.loading.json.typeadapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/typeadapter/BakedAnimationsAdapter.class */
public class BakedAnimationsAdapter implements JsonDeserializer<BakedAnimations> {
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public BakedAnimations m2124deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws RuntimeException {
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
            KeyframeStack<Keyframe<MathValue>> scaleFrames = buildKeyframeStack(getTripletObj(entryObj.get("scale")), false);
            KeyframeStack<Keyframe<MathValue>> positionFrames = buildKeyframeStack(getTripletObj(entryObj.get("position")), false);
            KeyframeStack<Keyframe<MathValue>> rotationFrames = buildKeyframeStack(getTripletObj(entryObj.get("rotation")), true);
            animations[index] = new BoneAnimation(entry.getKey(), rotationFrames, positionFrames, scaleFrames);
            index++;
        }
        return animations;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private static List<Pair<String, JsonElement>> getTripletObj(JsonElement element) throws JsonParseException {
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
            return ObjectArrayList.of(new Pair[]{Pair.of("0", array)});
        }
        if (element instanceof JsonObject) {
            JsonObject obj = (JsonObject) element;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                JsonElement value = entry.getValue();
                if (value instanceof JsonObject) {
                    JsonObject entryObj = (JsonObject) value;
                    if (!entryObj.has("vector")) {
                        objectArrayList.add(getTripletObjBedrock(entry.getKey(), entryObj));
                    }
                }
                objectArrayList.add(Pair.of(entry.getKey(), entry.getValue()));
            }
            return objectArrayList;
        }
        throw new JsonParseException("Invalid object type provided to getTripletObj, got: " + String.valueOf(element));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    private static Pair<String, JsonElement> getTripletObjBedrock(String timestamp, JsonObject keyframe) throws JsonParseException {
        JsonArray keyframeValues = null;
        if (keyframe.has("pre")) {
            JsonElement pre = keyframe.get("pre");
            keyframeValues = pre.isJsonArray() ? pre.getAsJsonArray() : GsonHelper.getAsJsonArray(pre.getAsJsonObject(), "vector");
        } else if (keyframe.has("post")) {
            JsonElement post = keyframe.get("post");
            keyframeValues = post.isJsonArray() ? post.getAsJsonArray() : GsonHelper.getAsJsonArray(post.getAsJsonObject(), "vector");
        }
        if (keyframeValues != null) {
            return Pair.of(NumberUtils.isCreatable(timestamp) ? timestamp : "0", keyframeValues);
        }
        throw new JsonParseException("Invalid keyframe data - expected array, found " + String.valueOf(keyframe));
    }

    private KeyframeStack<Keyframe<MathValue>> buildKeyframeStack(List<Pair<String, JsonElement>> entries, boolean isForRotation) throws CompoundException {
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
        Pair<String, JsonElement> prevEntry = null;
        for (Pair<String, JsonElement> entry : entries) {
            String key = (String) entry.getFirst();
            JsonObject jsonObject2 = (JsonElement) entry.getSecond();
            if (!key.equals("easing") && !key.equals("easingArgs") && !key.equals("lerp_mode")) {
                double prevTime = prevEntry != null ? Double.parseDouble((String) prevEntry.getFirst()) : 0.0d;
                double curTime = NumberUtils.isCreatable(key) ? Double.parseDouble((String) entry.getFirst()) : 0.0d;
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
                MathValue xValue = (isForRotation && (rawXValue instanceof Constant)) ? new Constant(Math.toRadians(-rawXValue.get())) : rawXValue;
                MathValue yValue = (isForRotation && (rawYValue instanceof Constant)) ? new Constant(Math.toRadians(-rawYValue.get())) : rawYValue;
                MathValue zValue = (isForRotation && (rawZValue instanceof Constant)) ? new Constant(Math.toRadians(rawZValue.get())) : rawZValue;
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
                objectArrayList2.add(new Keyframe(timeDelta * 20.0d, prevEntry == null ? xValue : xPrev, xValue, easingType, easingArgs));
                objectArrayList3.add(new Keyframe(timeDelta * 20.0d, prevEntry == null ? yValue : yPrev, yValue, easingType, easingArgs));
                objectArrayList4.add(new Keyframe(timeDelta * 20.0d, prevEntry == null ? zValue : zPrev, zValue, easingType, easingArgs));
                xPrev = xValue;
                yPrev = yValue;
                zPrev = zValue;
                prevEntry = entry;
            }
        }
        return new KeyframeStack<>(objectArrayList2, objectArrayList3, objectArrayList4);
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
}
