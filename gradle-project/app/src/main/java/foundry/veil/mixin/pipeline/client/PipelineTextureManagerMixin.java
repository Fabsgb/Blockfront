package foundry.veil.mixin.pipeline.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.texture.SimpleArrayTexture;
import foundry.veil.api.client.render.texture.SimpleCubemapTexture;
import foundry.veil.api.client.render.texture.TextureTypeMetadataSection;
import foundry.veil.api.client.render.texture.VeilPreloadedTexture;
import foundry.veil.ext.TextureManagerExtension;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineTextureManagerMixin.class */
@Mixin({TextureManager.class})
public abstract class PipelineTextureManagerMixin implements TextureManagerExtension {

    @Shadow
    @Final
    private Map<ResourceLocation, AbstractTexture> byPath;

    @Shadow
    @Final
    private ResourceManager resourceManager;

    @Shadow
    public abstract void register(ResourceLocation resourceLocation, AbstractTexture abstractTexture);

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @ModifyArg(method = {"getTexture(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/texture/AbstractTexture;"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;register(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/texture/AbstractTexture;)V"), index = 1)
    public AbstractTexture wrap(AbstractTexture texture, @Local(argsOnly = true) ResourceLocation path) throws MatchException {
        Optional<Resource> optionalResource = this.resourceManager.getResource(path);
        if (optionalResource.isPresent()) {
            try {
                Optional<TextureTypeMetadataSection> section = optionalResource.get().metadata().getSection(TextureTypeMetadataSection.SERIALIZER);
                if (section.isPresent()) {
                    switch (section.get().type()) {
                        case TEXTURE_2D:
                            return texture;
                        case TEXTURE_2D_ARRAY:
                            return new SimpleArrayTexture(path);
                        case TEXTURE_CUBE_MAP:
                            return new SimpleCubemapTexture(path);
                        default:
                            throw new MatchException((String) null, (Throwable) null);
                    }
                }
            } catch (IOException e) {
            }
        }
        return texture;
    }

    @Override // foundry.veil.ext.TextureManagerExtension
    public <T extends AbstractTexture & VeilPreloadedTexture> CompletableFuture<?> veil$registerPreloadedTexture(ResourceLocation path, T texture, Executor executor) {
        if (!this.byPath.containsKey(path)) {
            this.byPath.put(path, texture);
            return texture.preload(this.resourceManager, executor).thenRunAsync(() -> {
                register(path, texture);
            }, command -> {
                Minecraft.getInstance().execute(() -> {
                    Objects.requireNonNull(command);
                    RenderSystem.recordRenderCall(command::run);
                });
            });
        }
        return CompletableFuture.completedFuture(null);
    }
}
