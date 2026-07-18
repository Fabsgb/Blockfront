package foundry.veil.forge.mixin.client.perspective.sodium;

import java.util.ArrayDeque;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
import net.caffeinemc.mods.sodium.client.render.chunk.TaskQueueType;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/client/perspective/sodium/RenderSectionManagerAccessor.class */
@Mixin({RenderSectionManager.class})
public interface RenderSectionManagerAccessor {
    @Accessor(remap = false)
    Map<TaskQueueType, ArrayDeque<RenderSection>> getTaskLists();

    @Accessor(remap = false)
    void setRenderLists(SortedRenderLists sortedRenderLists);

    @Accessor(remap = false)
    void setTaskLists(Map<TaskQueueType, ArrayDeque<RenderSection>> map);
}
