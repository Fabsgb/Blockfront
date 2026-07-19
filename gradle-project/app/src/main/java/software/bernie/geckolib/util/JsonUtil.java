package software.bernie.geckolib.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/util/JsonUtil.class */
public final class JsonUtil {
    private JsonUtil() {
    }

    public static double[] jsonArrayToDoubleArray(@Nullable JsonArray array) throws JsonParseException {
        if (array == null) {
            return new double[3];
        }
        double[] output = new double[array.size()];
        for (int i = 0; i < array.size(); i++) {
            output[i] = array.get(i).getAsDouble();
        }
        return output;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] jsonArrayToObjectArray(JsonArray jsonArray, JsonDeserializationContext jsonDeserializationContext, Class<T> cls) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, jsonArray.size()));
        for (int i = 0; i < jsonArray.size(); i++) {
            tArr[i] = jsonDeserializationContext.deserialize(jsonArray.get(i), cls);
        }
        return tArr;
    }

    public static <T> List<T> jsonArrayToList(@Nullable JsonArray array, Function<JsonElement, T> elementTransformer) {
        if (array == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(array.size());
        Iterator it = array.iterator();
        while (it.hasNext()) {
            JsonElement element = (JsonElement) it.next();
            objectArrayList.add(elementTransformer.apply(element));
        }
        return objectArrayList;
    }

    public static <T> Map<String, T> jsonObjToMap(JsonObject obj, JsonDeserializationContext context, Class<T> objectType) {
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(obj.size());
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            object2ObjectOpenHashMap.put(entry.getKey(), context.deserialize(entry.getValue(), objectType));
        }
        return object2ObjectOpenHashMap;
    }

    @Nullable
    public static Long getOptionalLong(JsonObject obj, String elementName) {
        if (obj.has(elementName)) {
            return Long.valueOf(GsonHelper.getAsLong(obj, elementName));
        }
        return null;
    }

    @Nullable
    public static Boolean getOptionalBoolean(JsonObject obj, String elementName) {
        if (obj.has(elementName)) {
            return Boolean.valueOf(GsonHelper.getAsBoolean(obj, elementName));
        }
        return null;
    }

    @Nullable
    public static Float getOptionalFloat(JsonObject obj, String elementName) {
        if (obj.has(elementName)) {
            return Float.valueOf(GsonHelper.getAsFloat(obj, elementName));
        }
        return null;
    }

    @Nullable
    public static Double getOptionalDouble(JsonObject obj, String elementName) {
        if (obj.has(elementName)) {
            return Double.valueOf(GsonHelper.getAsDouble(obj, elementName));
        }
        return null;
    }

    @Nullable
    public static Integer getOptionalInteger(JsonObject obj, String elementName) {
        if (obj.has(elementName)) {
            return Integer.valueOf(GsonHelper.getAsInt(obj, elementName));
        }
        return null;
    }
}
