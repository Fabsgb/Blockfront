package foundry.veil.impl.client.render.pipeline;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.shader.program.TextureUniformAccess;
import foundry.veil.impl.client.render.shader.program.ShaderTextureCache;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/PostPipelineContext.class */
@ApiStatus.Internal
public class PostPipelineContext implements PostPipeline.Context {
    private final Object2LongMap<CharSequence> textures = new Object2LongArrayMap();
    private final Object2IntMap<CharSequence> samplers = new Object2IntArrayMap();
    private final Map<ResourceLocation, AdvancedFbo> framebuffers = new HashMap();

    public void begin() {
        VeilRenderSystem.renderer().getFramebufferManager().getFramebuffers().forEach(this::setFramebuffer);
    }

    public void end() {
        this.textures.clear();
        this.samplers.clear();
        this.framebuffers.clear();
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline.Context
    public void setTexture(CharSequence name, int target, int textureId, int samplerId) {
        this.textures.put(name, ShaderTextureCache.packTexture(target, textureId));
        this.samplers.put(name, samplerId);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline.Context
    public void setFramebuffer(ResourceLocation name, AdvancedFbo framebuffer) {
        this.framebuffers.put(name, framebuffer);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline.Context
    public void applySamplers(TextureUniformAccess shader) {
        ObjectIterator it = this.textures.object2LongEntrySet().iterator();
        while (it.hasNext()) {
            Object2LongMap.Entry<CharSequence> samplerEntry = (Object2LongMap.Entry) it.next();
            CharSequence key = (CharSequence) samplerEntry.getKey();
            long packed = samplerEntry.getLongValue();
            int target = ShaderTextureCache.getTarget(packed);
            int textureId = ShaderTextureCache.getTextureId(packed);
            shader.setTexture(key, target, textureId, this.samplers.getOrDefault(key, 0));
        }
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline.Context
    public void clearSamplers(TextureUniformAccess shader) {
        ObjectIterator it = this.textures.keySet().iterator();
        while (it.hasNext()) {
            CharSequence name = (CharSequence) it.next();
            shader.removeTexture(name);
        }
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource.Context
    @Nullable
    public AdvancedFbo getFramebuffer(ResourceLocation name) {
        return this.framebuffers.get(name);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline.Context
    public AdvancedFbo getDrawFramebuffer() {
        return this.framebuffers.getOrDefault(VeilFramebuffers.POST, AdvancedFbo.getMainFramebuffer());
    }
}
