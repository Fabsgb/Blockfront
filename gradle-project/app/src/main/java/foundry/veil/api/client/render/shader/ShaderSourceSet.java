package foundry.veil.api.client.render.shader;

import java.util.Map;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderSourceSet.class */
public final class ShaderSourceSet {
    private static final Map<String, Integer> EXTENSION_TYPES = Map.of(".vsh", 35633, ".tcsh", 36488, ".tesh", 36487, ".gsh", 36313, ".fsh", 35632, ".comp", 37305);
    private final String folder;
    private final FileToIdConverter shaderDefinitionLister;
    private final FileToIdConverter glslConverter;
    private final Map<Integer, FileToIdConverter> typeConverters;

    public ShaderSourceSet(String folder) {
        this.folder = folder;
        this.shaderDefinitionLister = FileToIdConverter.json(folder);
        this.glslConverter = new FileToIdConverter(folder, ".glsl");
        this.typeConverters = Map.of(35633, new FileToIdConverter(folder, ".vsh"), 36488, new FileToIdConverter(folder, ".tcsh"), 36487, new FileToIdConverter(folder, ".tesh"), 36313, new FileToIdConverter(folder, ".gsh"), 35632, new FileToIdConverter(folder, ".fsh"), 37305, new FileToIdConverter(folder, ".comp"));
    }

    public String getFolder() {
        return this.folder;
    }

    public FileToIdConverter getShaderDefinitionLister() {
        return this.shaderDefinitionLister;
    }

    public FileToIdConverter getGlslConverter() {
        return this.glslConverter;
    }

    public FileToIdConverter getTypeConverter(int type) {
        return this.typeConverters.getOrDefault(Integer.valueOf(type), this.glslConverter);
    }

    public static int getShaderType(ResourceLocation location) {
        for (Map.Entry<String, Integer> entry : EXTENSION_TYPES.entrySet()) {
            if (location.getPath().endsWith(entry.getKey())) {
                return entry.getValue().intValue();
            }
        }
        return -1;
    }
}
