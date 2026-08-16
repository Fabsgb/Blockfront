package foundry.veil.forge.event;

import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilShaderCompileEvent.class */
public class ForgeVeilShaderCompileEvent extends Event implements IModBusEvent {
    private final ShaderManager shaderManager;
    private final Map<ResourceLocation, ShaderProgram> updatedPrograms;

    public ForgeVeilShaderCompileEvent(ShaderManager shaderManager, Map<ResourceLocation, ShaderProgram> updatedPrograms) {
        this.shaderManager = shaderManager;
        this.updatedPrograms = updatedPrograms;
    }

    public ShaderManager getShaderManager() {
        return this.shaderManager;
    }

    public Map<ResourceLocation, ShaderProgram> getUpdatedPrograms() {
        return this.updatedPrograms;
    }
}
