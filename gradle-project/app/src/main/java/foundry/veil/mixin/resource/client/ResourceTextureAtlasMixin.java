package foundry.veil.mixin.resource.client;

import foundry.veil.ext.TextureAtlasExtension;
import java.util.Map;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/resource/client/ResourceTextureAtlasMixin.class */
@Mixin({TextureAtlas.class})
public class ResourceTextureAtlasMixin implements TextureAtlasExtension {

    @Shadow
    private Map<ResourceLocation, TextureAtlasSprite> texturesByName;

    @Override // foundry.veil.ext.TextureAtlasExtension
    public boolean veil$hasTexture(ResourceLocation location) {
        return this.texturesByName.containsKey(location);
    }
}
