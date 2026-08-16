package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.ext.AutoStorageIndexBufferExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineAutoStorageIndexBufferMixin.class */
@Mixin({RenderSystem.AutoStorageIndexBuffer.class})
public abstract class PipelineAutoStorageIndexBufferMixin implements AutoStorageIndexBufferExtension {

    @Shadow
    private int name;

    @Shadow
    public abstract boolean hasStorage(int i);

    @Shadow
    public abstract void bind(int i);

    @Override // foundry.veil.ext.AutoStorageIndexBufferExtension
    public void veil$ensureStorage(int neededIndexCount) {
        if (this.name == 0 || !hasStorage(neededIndexCount)) {
            bind(neededIndexCount);
        }
    }

    @Override // foundry.veil.ext.AutoStorageIndexBufferExtension
    public int veil$getBuffer() {
        return this.name;
    }
}
