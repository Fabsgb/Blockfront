package software.bernie.geckolib.resource;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.blaze3d.platform.NativeImage;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.util.FastColor;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/resource/GeoGlowingTextureMeta.class */
public class GeoGlowingTextureMeta {
    public static final MetadataSectionSerializer<GeoGlowingTextureMeta> DESERIALIZER = new MetadataSectionSerializer<GeoGlowingTextureMeta>() { // from class: software.bernie.geckolib.resource.GeoGlowingTextureMeta.1
        C14771() {
        }

        public String getMetadataSectionName() {
            return "glowsections";
        }

        /* JADX INFO: renamed from: fromJson */
        public GeoGlowingTextureMeta m9326fromJson(JsonObject json) throws JsonParseException {
            List<Pixel> pixels = fromSections(GsonHelper.getAsJsonArray(json, "sections", (JsonArray) null));
            if (pixels.isEmpty()) {
                throw new JsonParseException("Empty glowlayer sections file. Must have at least one glow section!");
            }
            return new GeoGlowingTextureMeta(pixels);
        }

        private List<Pixel> fromSections(@Nullable JsonArray sectionsArray) throws JsonParseException {
            if (sectionsArray == null) {
                return List.of();
            }
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator it = sectionsArray.iterator();
            while (it.hasNext()) {
                JsonObject jsonObject = (JsonElement) it.next();
                if (!(jsonObject instanceof JsonObject)) {
                    throw new JsonParseException("Invalid glowsections json format, expected a JsonObject, found: " + String.valueOf(jsonObject.getClass()));
                }
                JsonObject obj = jsonObject;
                int x1 = GsonHelper.getAsInt(obj, "x1", GsonHelper.getAsInt(obj, "x", 0));
                int y1 = GsonHelper.getAsInt(obj, "y1", GsonHelper.getAsInt(obj, "y", 0));
                int x2 = GsonHelper.getAsInt(obj, "x2", GsonHelper.getAsInt(obj, "w", 0) + x1);
                int y2 = GsonHelper.getAsInt(obj, "y2", GsonHelper.getAsInt(obj, "h", 0) + y1);
                int alpha = GsonHelper.getAsInt(obj, "alpha", GsonHelper.getAsInt(obj, "a", 0));
                if (x1 + y1 + x2 + y2 == 0) {
                    throw new IllegalArgumentException("Invalid glowsections section object, section must be at least one pixel in size");
                }
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        objectArrayList.add(new Pixel(x, y, alpha));
                    }
                }
            }
            return objectArrayList;
        }
    };
    private final List<Pixel> pixels;

    /* JADX INFO: renamed from: software.bernie.geckolib.resource.GeoGlowingTextureMeta$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/resource/GeoGlowingTextureMeta$1.class */
    class C14771 implements MetadataSectionSerializer<GeoGlowingTextureMeta> {
        C14771() {
        }

        public String getMetadataSectionName() {
            return "glowsections";
        }

        /* JADX INFO: renamed from: fromJson */
        public GeoGlowingTextureMeta m9326fromJson(JsonObject json) throws JsonParseException {
            List<Pixel> pixels = fromSections(GsonHelper.getAsJsonArray(json, "sections", (JsonArray) null));
            if (pixels.isEmpty()) {
                throw new JsonParseException("Empty glowlayer sections file. Must have at least one glow section!");
            }
            return new GeoGlowingTextureMeta(pixels);
        }

        private List<Pixel> fromSections(@Nullable JsonArray sectionsArray) throws JsonParseException {
            if (sectionsArray == null) {
                return List.of();
            }
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator it = sectionsArray.iterator();
            while (it.hasNext()) {
                JsonObject jsonObject = (JsonElement) it.next();
                if (!(jsonObject instanceof JsonObject)) {
                    throw new JsonParseException("Invalid glowsections json format, expected a JsonObject, found: " + String.valueOf(jsonObject.getClass()));
                }
                JsonObject obj = jsonObject;
                int x1 = GsonHelper.getAsInt(obj, "x1", GsonHelper.getAsInt(obj, "x", 0));
                int y1 = GsonHelper.getAsInt(obj, "y1", GsonHelper.getAsInt(obj, "y", 0));
                int x2 = GsonHelper.getAsInt(obj, "x2", GsonHelper.getAsInt(obj, "w", 0) + x1);
                int y2 = GsonHelper.getAsInt(obj, "y2", GsonHelper.getAsInt(obj, "h", 0) + y1);
                int alpha = GsonHelper.getAsInt(obj, "alpha", GsonHelper.getAsInt(obj, "a", 0));
                if (x1 + y1 + x2 + y2 == 0) {
                    throw new IllegalArgumentException("Invalid glowsections section object, section must be at least one pixel in size");
                }
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        objectArrayList.add(new Pixel(x, y, alpha));
                    }
                }
            }
            return objectArrayList;
        }
    }

    public GeoGlowingTextureMeta(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    public static GeoGlowingTextureMeta fromExistingImage(NativeImage glowLayer) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int x = 0; x < glowLayer.getWidth(); x++) {
            for (int y = 0; y < glowLayer.getHeight(); y++) {
                int color = glowLayer.getPixelRGBA(x, y);
                if (color != 0) {
                    objectArrayList.add(new Pixel(x, y, FastColor.ABGR32.alpha(color)));
                }
            }
        }
        if (objectArrayList.isEmpty()) {
            throw new IllegalStateException("Invalid glow layer texture provided, must have at least one pixel!");
        }
        return new GeoGlowingTextureMeta(objectArrayList);
    }

    public void createImageMask(NativeImage originalImage, NativeImage newImage) {
        for (Pixel pixel : this.pixels) {
            int color = originalImage.getPixelRGBA(pixel.f8819x, pixel.f8820y);
            if (pixel.alpha > 0) {
                color = FastColor.ABGR32.color(pixel.alpha, FastColor.ABGR32.blue(color), FastColor.ABGR32.green(color), FastColor.ABGR32.red(color));
            }
            newImage.setPixelRGBA(pixel.f8819x, pixel.f8820y, color);
            originalImage.setPixelRGBA(pixel.f8819x, pixel.f8820y, 0);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel.class */
    private static final class Pixel extends Record {

        /* JADX INFO: renamed from: x */
        private final int f8819x;

        /* JADX INFO: renamed from: y */
        private final int f8820y;
        private final int alpha;

        private Pixel(int x, int y, int alpha) {
            this.f8819x = x;
            this.f8820y = y;
            this.alpha = alpha;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Pixel.class), Pixel.class, "x;y;alpha", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->x:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->y:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->alpha:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Pixel.class), Pixel.class, "x;y;alpha", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->x:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->y:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->alpha:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Pixel.class, Object.class), Pixel.class, "x;y;alpha", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->x:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->y:I", "FIELD:Lsoftware/bernie/geckolib/resource/GeoGlowingTextureMeta$Pixel;->alpha:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: x */
        public int m8013x() {
            return this.f8819x;
        }

        /* JADX INFO: renamed from: y */
        public int m8014y() {
            return this.f8820y;
        }

        public int alpha() {
            return this.alpha;
        }
    }
}
