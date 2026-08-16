package foundry.veil.api.event;

import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilShaderCompileEvent.class */
@FunctionalInterface
public interface VeilShaderCompileEvent {
    void onVeilCompileShaders(ShaderManager shaderManager, Map<ResourceLocation, ShaderProgram> map);
}
