package foundry.veil.forge.mixin.client.perspective.sodium;

import foundry.veil.forge.ext.SodiumWorldRendererExtension;
import java.util.ArrayDeque;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
import net.caffeinemc.mods.sodium.client.render.chunk.TaskQueueType;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/sodium/SodiumWorldRendererMixin.class */
@Mixin({SodiumWorldRenderer.class})
public class SodiumWorldRendererMixin implements SodiumWorldRendererExtension {

    @Shadow(remap = false)
    private RenderSectionManager renderSectionManager;

    @Override // foundry.veil.forge.ext.SodiumWorldRendererExtension
    public SortedRenderLists veil$getSortedRenderLists() {
        return this.renderSectionManager.getRenderLists();
    }

    @Override // foundry.veil.forge.ext.SodiumWorldRendererExtension
    public Map<TaskQueueType, ArrayDeque<RenderSection>> veil$getTaskLists() {
        return this.renderSectionManager.getTaskLists();
    }

    @Override // foundry.veil.forge.ext.SodiumWorldRendererExtension
    public void veil$setSortedRenderLists(SortedRenderLists sortedRenderLists) {
        this.renderSectionManager.setRenderLists(sortedRenderLists);
    }

    @Override // foundry.veil.forge.ext.SodiumWorldRendererExtension
    public void veil$setTaskLists(Map<TaskQueueType, ArrayDeque<RenderSection>> taskLists) {
        this.renderSectionManager.setTaskLists(taskLists);
    }
}
