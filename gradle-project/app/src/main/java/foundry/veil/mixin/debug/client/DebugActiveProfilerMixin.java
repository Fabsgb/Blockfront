package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import net.minecraft.util.profiling.ActiveProfiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/client/DebugActiveProfilerMixin.class */
@Mixin({ActiveProfiler.class})
public class DebugActiveProfilerMixin {
    @Inject(method = {"push(Ljava/lang/String;)V"}, at = {@At("HEAD")})
    public void push(String name, CallbackInfo ci) {
        if (RenderSystem.isOnRenderThread()) {
            VeilDebug.get().pushDebugGroup(name);
        }
    }

    @Inject(method = {"pop()V"}, at = {@At("HEAD")})
    public void pop(CallbackInfo ci) {
        if (RenderSystem.isOnRenderThread()) {
            VeilDebug.get().popDebugGroup();
        }
    }
}
