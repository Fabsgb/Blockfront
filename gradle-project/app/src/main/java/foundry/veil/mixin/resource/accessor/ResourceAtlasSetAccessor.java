package foundry.veil.mixin.resource.accessor;

import java.util.Map;
import net.minecraft.client.resources.model.AtlasSet;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/resource/accessor/ResourceAtlasSetAccessor.class */
@Mixin({AtlasSet.class})
public interface ResourceAtlasSetAccessor {
    @Accessor
    Map<ResourceLocation, AtlasSet.AtlasEntry> getAtlases();
}
