package foundry.veil.impl.client.render.shader;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.util.function.Consumer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/VeilVanillaShaders.class */
@ApiStatus.Internal
public final class VeilVanillaShaders {
    private static ShaderInstance worldborder;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/VeilVanillaShaders$Context.class */
    @FunctionalInterface
    public interface Context {
        void register(ResourceLocation resourceLocation, VertexFormat vertexFormat, Consumer<ShaderInstance> consumer) throws IOException;
    }

    public static void registerShaders(Context context) throws IOException {
        context.register(ResourceLocation.withDefaultNamespace("worldborder"), DefaultVertexFormat.POSITION_TEX, value -> {
            worldborder = value;
        });
    }

    @Nullable
    public static ShaderInstance getWorldborder() {
        return worldborder;
    }

    public static void free() {
        if (worldborder != null) {
            worldborder.close();
            worldborder = null;
        }
    }
}
