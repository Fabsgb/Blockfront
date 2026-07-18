package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.List;
import javax.annotation.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/client/DebugVertexFormatMixin.class */
@Mixin({VertexFormat.class})
public class DebugVertexFormatMixin {

    @Shadow
    @Final
    private int vertexSize;

    @Shadow
    @Final
    private List<String> names;

    @Shadow
    @Nullable
    private VertexBuffer immediateDrawVertexBuffer;

    @Inject(method = {"getImmediateDrawVertexBuffer"}, at = {@At(value = "FIELD", target = "Lcom/mojang/blaze3d/vertex/VertexFormat;immediateDrawVertexBuffer:Lcom/mojang/blaze3d/vertex/VertexBuffer;", opcode = 181, shift = At.Shift.AFTER)})
    public void nameImmediateDrawVertexBuffer(CallbackInfoReturnable<VertexBuffer> cir) {
        this.immediateDrawVertexBuffer.veil$setName("Vertex Format (" + this.vertexSize + " bytes): " + String.join(" ", this.names));
    }
}
