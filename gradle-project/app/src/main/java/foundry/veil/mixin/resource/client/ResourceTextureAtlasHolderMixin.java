package foundry.veil.mixin.resource.client;

import foundry.veil.ext.TextureAtlasExtension;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/resource/client/ResourceTextureAtlasHolderMixin.class */
@Mixin({TextureAtlasHolder.class})
public class ResourceTextureAtlasHolderMixin implements TextureAtlasExtension {

    @Shadow
    @Final
    private TextureAtlas textureAtlas;

    @Override // foundry.veil.ext.TextureAtlasExtension
    public boolean veil$hasTexture(ResourceLocation location) {
        return this.textureAtlas.veil$hasTexture(location);
    }
}
