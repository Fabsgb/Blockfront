package foundry.veil.api.client.render.texture;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/TextureTypeMetadataSection.class */
public final class TextureTypeMetadataSection extends Record {
    private final TextureType type;
    public static final Serializer SERIALIZER = new Serializer();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/TextureTypeMetadataSection$TextureType.class */
    public enum TextureType {
        TEXTURE_2D,
        TEXTURE_2D_ARRAY,
        TEXTURE_CUBE_MAP;

        private static final TextureType[] VALUES = values();
    }

    public TextureTypeMetadataSection(TextureType type) {
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextureTypeMetadataSection.class), TextureTypeMetadataSection.class, "type", "FIELD:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection;->type:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection$TextureType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextureTypeMetadataSection.class), TextureTypeMetadataSection.class, "type", "FIELD:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection;->type:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection$TextureType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextureTypeMetadataSection.class, Object.class), TextureTypeMetadataSection.class, "type", "FIELD:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection;->type:Lfoundry/veil/api/client/render/texture/TextureTypeMetadataSection$TextureType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public TextureType type() {
        return this.type;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/TextureTypeMetadataSection$Serializer.class */
    public static class Serializer implements MetadataSectionSerializer<TextureTypeMetadataSection> {
        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
        /* JADX INFO: renamed from: fromJson, reason: merged with bridge method [inline-methods] */
        public TextureTypeMetadataSection m9026fromJson(@NotNull JsonObject json) throws JsonSyntaxException {
            String type = GsonHelper.getAsString(json, "type", "2d");
            for (TextureType value : TextureType.VALUES) {
                if (value.name().substring(8).equalsIgnoreCase(type)) {
                    return new TextureTypeMetadataSection(value);
                }
            }
            throw new JsonSyntaxException("Unknown texture type: " + type + ". Expected one of " + ((String) Arrays.stream(TextureType.VALUES).map(textureType -> {
                return textureType.name().toLowerCase(Locale.ROOT);
            }).collect(Collectors.joining(", "))));
        }

        @NotNull
        public String getMetadataSectionName() {
            return "veil:texture_type";
        }
    }
}
