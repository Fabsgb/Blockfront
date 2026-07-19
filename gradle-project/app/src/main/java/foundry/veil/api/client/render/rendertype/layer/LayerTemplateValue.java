package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.function.Function;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/LayerTemplateValue.class */
public interface LayerTemplateValue<T> {
    public static final Codec<LayerTemplateValue<String>> STRING_CODEC = Codec.STRING.xmap(name -> {
        if (name.contains("%")) {
            return new FormattedValue(name, formatted -> {
                return formatted;
            });
        }
        return new RawValue(name, name);
    }, (v0) -> {
        return v0.rawValue();
    });
    public static final Codec<LayerTemplateValue<ResourceLocation>> LOCATION_CODEC = Codec.STRING.flatXmap(name -> {
        if (name.contains("%")) {
            return DataResult.success(new FormattedValue(name, ResourceLocation::parse));
        }
        return ResourceLocation.read(name).map(loc -> {
            return new RawValue(loc.toString(), loc);
        });
    }, value -> {
        return DataResult.success(value.rawValue());
    });

    String rawValue();

    T parse(Object... objArr) throws IllegalFormatException, ResourceLocationException;

    static <T extends Enum<T>> Codec<LayerTemplateValue<T>> enumCodec(Class<T> cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        String[] strArr = (String[]) Arrays.stream(enumArr).map(value -> {
            return value.name().toLowerCase();
        }).toArray(x$0 -> {
            return new String[x$0];
        });
        String simpleName = cls.getSimpleName();
        String str = ". Valid options: " + String.join(", ", strArr);
        return Codec.STRING.xmap(value2 -> {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equalsIgnoreCase(value2)) {
                    return new RawValue(value2, enumArr[i]);
                }
            }
            return new FormattedValue(value2, formattedValue -> {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (strArr[i2].equalsIgnoreCase(formattedValue)) {
                        return enumArr[i2];
                    }
                }
                throw new IllegalStateException("Unknown " + simpleName + ": " + value2 + str);
            });
        }, (v0) -> {
            return v0.rawValue();
        });
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;>(TT;)Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue<TT;>; */
    static RawValue raw(Enum r5) {
        return new RawValue(r5.name().toLowerCase(Locale.ROOT), r5);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue.class */
    public static final class RawValue<T> extends Record implements LayerTemplateValue<T> {
        private final String rawValue;
        private final T value;

        public RawValue(String rawValue, T value) {
            this.rawValue = rawValue;
            this.value = value;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, RawValue.class), RawValue.class, "rawValue;value", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->value:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, RawValue.class), RawValue.class, "rawValue;value", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->value:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, RawValue.class, Object.class), RawValue.class, "rawValue;value", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$RawValue;->value:Ljava/lang/Object;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.rendertype.layer.LayerTemplateValue
        public String rawValue() {
            return this.rawValue;
        }

        public T value() {
            return this.value;
        }

        @Override // foundry.veil.api.client.render.rendertype.layer.LayerTemplateValue
        public T parse(Object... params) {
            return this.value;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue.class */
    public static final class FormattedValue<T> extends Record implements LayerTemplateValue<T> {
        private final String rawValue;
        private final Function<String, T> decoder;

        public FormattedValue(String rawValue, Function<String, T> decoder) {
            this.rawValue = rawValue;
            this.decoder = decoder;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FormattedValue.class), FormattedValue.class, "rawValue;decoder", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->decoder:Ljava/util/function/Function;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FormattedValue.class), FormattedValue.class, "rawValue;decoder", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->decoder:Ljava/util/function/Function;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FormattedValue.class, Object.class), FormattedValue.class, "rawValue;decoder", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->rawValue:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue$FormattedValue;->decoder:Ljava/util/function/Function;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.rendertype.layer.LayerTemplateValue
        public String rawValue() {
            return this.rawValue;
        }

        public Function<String, T> decoder() {
            return this.decoder;
        }

        @Override // foundry.veil.api.client.render.rendertype.layer.LayerTemplateValue
        public T parse(Object... params) {
            return this.decoder.apply(String.format(this.rawValue, params));
        }
    }
}
