package foundry.veil.forge.ext;

import java.util.ArrayDeque;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.TaskQueueType;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SortedRenderLists;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/ext/SodiumWorldRendererExtension.class */
public interface SodiumWorldRendererExtension {
    SortedRenderLists veil$getSortedRenderLists();

    Map<TaskQueueType, ArrayDeque<RenderSection>> veil$getTaskLists();

    void veil$setSortedRenderLists(SortedRenderLists sortedRenderLists);

    void veil$setTaskLists(Map<TaskQueueType, ArrayDeque<RenderSection>> map);
}
