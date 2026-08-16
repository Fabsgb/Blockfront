package foundry.veil.mixin.necromancer.client;

import foundry.veil.api.client.necromancer.render.NecromancerEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/necromancer/client/NecromancerClientLevelMixin.class */
@Mixin({ClientLevel.class})
public class NecromancerClientLevelMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = {"addEntity"}, at = {@At("TAIL")})
    private void addEntity(Entity entity, CallbackInfo ci) {
        EntityRenderer renderer = this.minecraft.getEntityRenderDispatcher().getRenderer(entity);
        if (renderer instanceof NecromancerEntityRenderer) {
            NecromancerEntityRenderer renderer2 = (NecromancerEntityRenderer) renderer;
            renderer2.setupEntity(entity);
        }
    }
}
