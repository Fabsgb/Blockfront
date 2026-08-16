package foundry.veil.forge.mixin.compat.sodium;

import it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/RenderSectionManagerAccessor.class */
@Mixin({RenderSectionManager.class})
public interface RenderSectionManagerAccessor {
    @Accessor
    ChunkRenderer getChunkRenderer();

    @Accessor
    Long2ReferenceMap<RenderSection> getSectionByPosition();
}
