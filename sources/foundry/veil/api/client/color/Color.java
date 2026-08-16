package foundry.veil.api.client.color;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import org.joml.Vector3fc;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/color/Color.class */
public class Color implements Colorc {
    public static final Codec<Integer> RGB_INT_CODEC = new ColorCodec(false);
    public static final Codec<Integer> ARGB_INT_CODEC = new ColorCodec(true);
    public static final Codec<Colorc> RGB_CODEC = RGB_INT_CODEC.xmap((v1) -> {
        return new Color(v1);
    }, (v0) -> {
        return v0.argb();
    });
    public static final Codec<Colorc> ARGB_CODEC = ARGB_INT_CODEC.xmap((v1) -> {
        return new Color(v1);
    }, (v0) -> {
        return v0.argb();
    });
    public static final Colorc WHITE = new Color(-1);
    public static final Colorc BLACK = new Color(-16777216);
    public static final Colorc RED = new Color(-65536);
    public static final Colorc GREEN = new Color(-16711936);
    public static final Colorc BLUE = new Color(-16776961);
    public static final Colorc TRANSPARENT = new Color(0);
    public static final Colorc VANILLA_TOOLTIP_BACKGROUND = new Color(-267386864);
    public static final Colorc VANILLA_TOOLTIP_BORDER_TOP = new Color(1347420415);
    public static final Colorc VANILLA_TOOLTIP_BORDER_BOTTOM = new Color(1344798847);
    private float red;
    private float green;
    private float blue;
    private float alpha;

    public Color() {
        this.red = 0.0f;
        this.green = 0.0f;
        this.blue = 0.0f;
        this.alpha = 1.0f;
    }

    public Color(int rgb) {
        this(rgb, false);
    }

    public Color(int color, boolean alpha) {
        if (alpha) {
            setARGB(color);
        } else {
            setARGB((-16777216) | color);
        }
    }

    public Color(float red, float green, float blue) {
        this(red, green, blue, 1.0f);
    }

    public Color(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Color(Colorc copy) {
        this.red = copy.red();
        this.green = copy.green();
        this.blue = copy.blue();
        this.alpha = copy.alpha();
    }

    public Color(Vector3fc copy) {
        this.red = copy.x();
        this.green = copy.y();
        this.blue = copy.z();
        this.alpha = 1.0f;
    }

    public Color(Vector4fc copy) {
        this.red = copy.x();
        this.green = copy.y();
        this.blue = copy.z();
        this.alpha = copy.w();
    }

    public Color red(float red) {
        this.red = red;
        return this;
    }

    public Color green(float green) {
        this.green = green;
        return this;
    }

    public Color blue(float blue) {
        this.blue = blue;
        return this;
    }

    public Color alpha(float alpha) {
        this.alpha = alpha;
        return this;
    }

    public Color redInt(int red) {
        return red(red / 255.0f);
    }

    public Color greenInt(int green) {
        return green(green / 255.0f);
    }

    public Color blueInt(int blue) {
        return blue(blue / 255.0f);
    }

    public Color alphaInt(int alpha) {
        return alpha(alpha / 255.0f);
    }

    public Color set(Colorc color) {
        this.red = color.red();
        this.green = color.green();
        this.blue = color.blue();
        this.alpha = color.alpha();
        return this;
    }

    public Color set(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        return this;
    }

    public Color set(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        return this;
    }

    public Color setInt(int red, int green, int blue) {
        return set(red / 255.0f, green / 255.0f, blue / 255.0f);
    }

    public Color setInt(int red, int green, int blue, int alpha) {
        return set(red / 255.0f, green / 255.0f, blue / 255.0f, alpha / 255.0f);
    }

    public Color setRGB(int rgb) {
        return setInt((rgb >> 16) & 255, (rgb >> 8) & 255, rgb & 255);
    }

    public Color setARGB(int argb) {
        return setInt((argb >> 16) & 255, (argb >> 8) & 255, argb & 255, (argb >> 24) & 255);
    }

    @Override // foundry.veil.api.client.color.Colorc
    public float red() {
        return this.red;
    }

    @Override // foundry.veil.api.client.color.Colorc
    public float green() {
        return this.green;
    }

    @Override // foundry.veil.api.client.color.Colorc
    public float blue() {
        return this.blue;
    }

    @Override // foundry.veil.api.client.color.Colorc
    public float alpha() {
        return this.alpha;
    }

    public Color lerp(Colorc other, float delta) {
        return set(red() + ((red() - other.red()) * delta), green() + ((green() - other.green()) * delta), blue() + ((blue() - other.blue()) * delta), alpha() + ((alpha() - other.alpha()) * delta));
    }

    public Color mix(Colorc color, float amount) {
        return set((red() * (1.0f - amount)) + (color.red() * amount), (green() * (1.0f - amount)) + (color.green() * amount), (blue() * (1.0f - amount)) + (color.blue() * amount), (alpha() * (1.0f - amount)) + (color.alpha() * amount));
    }

    public Color lighten(float amount) {
        return mix(WHITE, amount, this);
    }

    public Color darken(float amount) {
        return mix(BLACK, amount, this);
    }

    public Color invert() {
        return invert(this);
    }

    public Color grayscale() {
        return grayscale(this);
    }

    public Color sepia() {
        return sepia(this);
    }

    public Color setHue(float hue) {
        return setHSV(hue, saturation(), luminance(), this);
    }

    public Color setSaturation(float saturation) {
        return setHSV(hue(), saturation, luminance(), this);
    }

    public Color setLuminance(float luminance) {
        return setHSV(hue(), saturation(), luminance, this);
    }

    public Color setHSV(float hue, float saturation, float luminance) {
        return setHSV(hue, saturation, luminance, this);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Colorc)) {
            return false;
        }
        Colorc color = (Colorc) o;
        return Float.compare(this.red, color.red()) == 0 && Float.compare(this.green, color.green()) == 0 && Float.compare(this.blue, color.blue()) == 0 && Float.compare(this.alpha, color.alpha()) == 0;
    }

    public int hashCode() {
        int result = Float.hashCode(this.red);
        return (31 * ((31 * ((31 * result) + Float.hashCode(this.green))) + Float.hashCode(this.blue))) + Float.hashCode(this.alpha);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/color/Color$ColorCodec.class */
    private static final class ColorCodec extends Record implements Codec<Integer> {
        private final boolean alpha;

        private ColorCodec(boolean alpha) {
            this.alpha = alpha;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ColorCodec.class), ColorCodec.class, "alpha", "FIELD:Lfoundry/veil/api/client/color/Color$ColorCodec;->alpha:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ColorCodec.class), ColorCodec.class, "alpha", "FIELD:Lfoundry/veil/api/client/color/Color$ColorCodec;->alpha:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ColorCodec.class, Object.class), ColorCodec.class, "alpha", "FIELD:Lfoundry/veil/api/client/color/Color$ColorCodec;->alpha:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public boolean alpha() {
            return this.alpha;
        }

        public /* bridge */ /* synthetic */ DataResult encode(Object obj, DynamicOps dynamicOps, Object obj2) {
            return encode((Integer) obj, (DynamicOps<Object>) dynamicOps, obj2);
        }

        private <T> DataResult<Integer> decodeElement(DynamicOps<T> ops, T input) {
            Optional<Number> numberValue = ops.getNumberValue(input).result();
            if (numberValue.isPresent()) {
                int color = numberValue.get().intValue();
                return DataResult.success(Integer.valueOf(this.alpha ? color : 16777215 & color));
            }
            Optional<String> stringValue = ops.getStringValue(input).result();
            if (stringValue.isPresent()) {
                String colorString = stringValue.get();
                if (colorString.startsWith("#")) {
                    try {
                        int color2 = Integer.parseUnsignedInt(colorString.substring(1), 16);
                        return DataResult.success(Integer.valueOf(this.alpha ? color2 : 16777215 & color2));
                    } catch (NumberFormatException e) {
                        return DataResult.error(() -> {
                            return "Invalid color hex: " + colorString + ". " + e.getMessage();
                        });
                    }
                }
                if (colorString.startsWith("0x") || colorString.startsWith("0X")) {
                    try {
                        int color3 = Integer.parseUnsignedInt(colorString.substring(2), 16);
                        return DataResult.success(Integer.valueOf(this.alpha ? color3 : 16777215 & color3));
                    } catch (NumberFormatException e2) {
                        return DataResult.error(() -> {
                            return "Invalid color hex: " + colorString + ". " + e2.getMessage();
                        });
                    }
                }
                try {
                    int color4 = Integer.parseUnsignedInt(colorString);
                    return DataResult.success(Integer.valueOf(this.alpha ? color4 : 16777215 & color4));
                } catch (NumberFormatException e3) {
                    return DataResult.error(() -> {
                        return "Invalid color int: " + colorString + ". " + e3.getMessage();
                    });
                }
            }
            return DataResult.error(() -> {
                return "Not a color int, hex, or string";
            });
        }

        public <T> DataResult<Pair<Integer, T>> decode(DynamicOps<T> ops, T input) {
            DataResult<Integer> numberElement = decodeElement(ops, input);
            if (numberElement.isSuccess()) {
                return numberElement.map(col -> {
                    return Pair.of(col, input);
                });
            }
            Optional<Consumer<Consumer<T>>> listValue = ops.getList(input).result();
            if (listValue.isPresent()) {
                List<T> values = new ArrayList<>(4);
                Consumer<Consumer<T>> consumer = listValue.get();
                Objects.requireNonNull(values);
                consumer.accept(values::add);
                if (values.size() < 3 || values.size() > 4) {
                    return DataResult.error(() -> {
                        return "Expected RGB and optionally A components";
                    });
                }
                int result = 0;
                for (int i = 0; i < 3; i++) {
                    DataResult<Integer> colorElement = decodeElement(ops, values.get(i));
                    if (!colorElement.isSuccess()) {
                        int index = i;
                        return colorElement.map(col2 -> {
                            return Pair.of(col2, input);
                        }).mapError(s -> {
                            return s + " at index " + index;
                        });
                    }
                    result |= (((Integer) colorElement.getOrThrow()).intValue() & 255) << (16 - (i * 8));
                }
                if (this.alpha) {
                    if (values.size() == 4) {
                        DataResult<Integer> colorElement2 = decodeElement(ops, values.get(3));
                        if (!colorElement2.isSuccess()) {
                            return colorElement2.map(col3 -> {
                                return Pair.of(col3, input);
                            }).mapError(s2 -> {
                                return s2 + " at index 3";
                            });
                        }
                        result |= (((Integer) colorElement2.getOrThrow()).intValue() & 255) << 24;
                    } else {
                        result |= -16777216;
                    }
                }
                return DataResult.success(Pair.of(Integer.valueOf(result), input));
            }
            return DataResult.error(() -> {
                return "Not a color int, hex, string, or list of values";
            });
        }

        public <T> DataResult<T> encode(Integer input, DynamicOps<T> ops, T prefix) {
            return DataResult.success(ops.createInt(this.alpha ? input.intValue() : 16777215 & input.intValue()));
        }
    }
}
