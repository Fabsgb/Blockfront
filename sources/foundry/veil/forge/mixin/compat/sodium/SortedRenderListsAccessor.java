package foundry.veil.forge.mixin.compat.sodium;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.ChunkRenderList;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/SortedRenderListsAccessor.class */
@Mixin({SortedRenderLists.class})
public interface SortedRenderListsAccessor {
    @Invoker("<init>")
    static SortedRenderLists init(ObjectArrayList<ChunkRenderList> lists) {
        throw new AssertionError();
    }
}
