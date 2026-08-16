package foundry.veil.mixin.resource.accessor;

import net.minecraft.client.resources.model.AtlasSet;
import net.minecraft.client.resources.model.ModelManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/resource/accessor/ResourceModelManagerAccessor.class */
@Mixin({ModelManager.class})
public interface ResourceModelManagerAccessor {
    @Accessor
    int getMaxMipmapLevels();

    @Accessor
    AtlasSet getAtlases();
}
