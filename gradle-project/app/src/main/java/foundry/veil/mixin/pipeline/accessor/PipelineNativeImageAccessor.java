package foundry.veil.mixin.pipeline.accessor;

import com.mojang.blaze3d.platform.NativeImage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/accessor/PipelineNativeImageAccessor.class */
@Mixin({NativeImage.class})
public interface PipelineNativeImageAccessor {
    @Invoker
    void invokeCheckAllocated();

    @Accessor
    long getPixels();
}
