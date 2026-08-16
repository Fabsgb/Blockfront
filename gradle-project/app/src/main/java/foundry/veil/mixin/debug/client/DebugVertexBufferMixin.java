package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.vertex.VertexBuffer;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.ext.DebugVertexBufferExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/client/DebugVertexBufferMixin.class */
@Mixin({VertexBuffer.class})
public class DebugVertexBufferMixin implements DebugVertexBufferExt {

    @Shadow
    private int arrayObjectId;

    @Shadow
    private int vertexBufferId;

    @Shadow
    private int indexBufferId;

    @Override // foundry.veil.ext.DebugVertexBufferExt
    public void veil$setName(String name) {
        VeilDebug debug = VeilDebug.get();
        debug.objectLabel(32884, this.arrayObjectId, "Vertex Array " + name);
        debug.objectLabel(33504, this.vertexBufferId, "Vertex Buffer " + name);
        debug.objectLabel(33504, this.indexBufferId, "Element Array Buffer " + name);
    }
}
