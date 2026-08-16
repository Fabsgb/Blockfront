package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/client/DebugAutoStorageIndexBufferMixin.class */
@Mixin({RenderSystem.AutoStorageIndexBuffer.class})
public class DebugAutoStorageIndexBufferMixin {

    @Shadow
    private int name;

    @Shadow
    @Final
    private int vertexStride;

    @Inject(method = {"bind"}, at = {@At(value = "FIELD", target = "Lcom/mojang/blaze3d/systems/RenderSystem$AutoStorageIndexBuffer;name:I", opcode = 181, shift = At.Shift.AFTER)})
    public void nameBuffer(CallbackInfo ci) {
        VeilDebug.get().objectLabel(33504, this.name, "Element Array Buffer Shared " + this.vertexStride);
    }
}
