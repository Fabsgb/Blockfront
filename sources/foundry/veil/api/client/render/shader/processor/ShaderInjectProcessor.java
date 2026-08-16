package foundry.veil.api.client.render.shader.processor;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.render.shader.injection.ShaderInjectionManager;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjection;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/processor/ShaderInjectProcessor.class */
public class ShaderInjectProcessor implements ShaderPreProcessor {
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
            applyModifiers(include, tree, applyVersion);
        }
        applyModifiers(name, tree, applyVersion);
    }

    private void applyModifiers(ResourceLocation shaderId, GlslTree tree, boolean applyVersion) {
        List<ShaderInjection> modifiers = this.shaderInjectionManager.getModifiers(shaderId);
        if (modifiers.isEmpty()) {
            return;
        }
        try {
            for (ShaderInjection modifier : modifiers) {
                modifier.inject(tree, applyVersion);
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to transform shader: {}", shaderId, e);
        }
    }
}
