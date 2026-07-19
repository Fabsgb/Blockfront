package foundry.veil.mixin.pipeline.accessor;

import java.util.List;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/accessor/PipelineReloadableResourceManagerAccessor.class */
@Mixin({ReloadableResourceManager.class})
public interface PipelineReloadableResourceManagerAccessor {
    @Accessor
    List<PreparableReloadListener> getListeners();
}
