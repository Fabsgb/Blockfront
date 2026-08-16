package foundry.veil.forge.mixinhelper;

import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import foundry.veil.forge.ext.RenderRegionExtension;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Queue;
import net.caffeinemc.mods.sodium.client.render.chunk.ChunkUpdateTypes;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.TaskQueueType;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.ChunkRenderList;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SectionCollector;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixinhelper/PerspectiveChunkCollector.class */
public class PerspectiveChunkCollector extends SectionCollector {
    private final TaskQueueType importantRebuildQueueType;
    private final TaskQueueType importantSortQueueType;
    private final ObjectArrayList<ChunkRenderList> renderLists;
    private boolean needsRevisitForPendingUpdates;

    public PerspectiveChunkCollector(TaskQueueType importantRebuildQueueType, TaskQueueType importantSortQueueType) {
        super(0, importantRebuildQueueType, importantSortQueueType);
        this.importantRebuildQueueType = importantRebuildQueueType;
        this.importantSortQueueType = importantSortQueueType;
        this.renderLists = new ObjectArrayList<>();
        this.needsRevisitForPendingUpdates = false;
    }

    public void visit(RenderSection section) {
        int flags = section.getFlags();
        if (flags != 0) {
            RenderRegionExtension ext = section.getRegion();
            ChunkRenderList renderList = ext.veil$getPerspectiveRenderList();
            if (renderList.getLastVisibleFrame() != VeilLevelPerspectiveRenderer.getID()) {
                renderList.reset(VeilLevelPerspectiveRenderer.getID(), orderIsSorted());
                this.renderLists.add(renderList);
            }
            renderList.add(section.getSectionIndex(), flags);
        }
        int pendingUpdate = section.getPendingUpdate();
        if (pendingUpdate != 0) {
            if (section.getRunningJob() != null) {
                this.needsRevisitForPendingUpdates = true;
                return;
            }
            TaskQueueType queueType = ChunkUpdateTypes.getQueueType(pendingUpdate, this.importantRebuildQueueType, this.importantSortQueueType);
            Queue<RenderSection> queue = (Queue) getTaskLists().get(queueType);
            if (queue.size() < queueType.queueSizeLimit()) {
                queue.add(section);
            }
        }
    }

    public ObjectArrayList<ChunkRenderList> getUnsortedRenderLists() {
        return this.renderLists;
    }

    public boolean needsRevisitForPendingUpdates() {
        return this.needsRevisitForPendingUpdates;
    }

    public boolean orderIsSorted() {
        return false;
    }
}
