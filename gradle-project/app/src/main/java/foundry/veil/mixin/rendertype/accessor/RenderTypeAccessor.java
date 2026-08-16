package foundry.veil.mixin.rendertype.accessor;

import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/rendertype/accessor/RenderTypeAccessor.class */
@Mixin({RenderType.class})
public interface RenderTypeAccessor {
    @Accessor
    boolean isSortOnUpload();
}
