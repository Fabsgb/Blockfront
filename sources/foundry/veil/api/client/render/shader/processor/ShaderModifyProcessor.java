package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.impl.client.render.shader.injection.ShaderInjectionManager;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderModifyProcessor.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated(forRemoval = true)
public class ShaderModifyProcessor implements ShaderPreProcessor {
    private final ShaderInjectionManager shaderInjectionManager = VeilRenderSystem.renderer().getShaderInjectionManager();
    private final Set<ResourceLocation> appliedModifications = new HashSet();

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void prepare() {
        this.appliedModifications.clear();
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        ResourceLocation name = ctx.name();
        if (name == null || !this.appliedModifications.add(name)) {
            return;
        }
        boolean applyVersion = ctx.isSourceFile();
        for (ResourceLocation include : ctx.shaderImporter().addedImports()) {
            this.shaderInjectionManager.applyModifiers(include, tree, applyVersion);
        }
        this.shaderInjectionManager.applyModifiers(name, tree, applyVersion);
    }
}
