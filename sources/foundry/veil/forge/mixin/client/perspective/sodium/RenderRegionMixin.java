package foundry.veil.forge.mixin.client.perspective.sodium;

import foundry.veil.forge.ext.RenderRegionExtension;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.ChunkRenderList;
import net.caffeinemc.mods.sodium.client.render.chunk.region.RenderRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/sodium/RenderRegionMixin.class */
@Mixin({RenderRegion.class})
public class RenderRegionMixin implements RenderRegionExtension {

    @Unique
    private ChunkRenderList veil$perspectiveList;

    @Override // foundry.veil.forge.ext.RenderRegionExtension
    public ChunkRenderList veil$getPerspectiveRenderList() {
        if (this.veil$perspectiveList == null) {
            this.veil$perspectiveList = new ChunkRenderList((RenderRegion) this);
        }
        return this.veil$perspectiveList;
    }
}
