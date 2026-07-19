package software.bernie.geckolib.mixin.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import software.bernie.geckolib.cache.texture.AnimatableTexture;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/mixin/client/TextureManagerMixin.class */
@Mixin(value = {TextureManager.class}, priority = 2000)
public abstract class TextureManagerMixin {
    @Shadow
    public abstract void register(ResourceLocation resourceLocation, AbstractTexture abstractTexture);

    @WrapOperation(method = {"getTexture(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/texture/AbstractTexture;"}, at = {@At(value = "NEW", target = "(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/texture/SimpleTexture;")}, require = 0)
    private SimpleTexture geckolib$replaceAnimatableTexture(ResourceLocation location, Operation<SimpleTexture> original) {
        AnimatableTexture animatableTexture = new AnimatableTexture(location);
        register(location, animatableTexture);
        return animatableTexture.isAnimated() ? animatableTexture : new SimpleTexture(location);
    }

    @WrapWithCondition(method = {"getTexture(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/texture/AbstractTexture;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;register(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/texture/AbstractTexture;)V")}, require = 0)
    private boolean geckolib$skipAnimatableTextureRegistration(TextureManager textureManager, ResourceLocation location, AbstractTexture texture) {
        return !(texture instanceof AnimatableTexture);
    }
}
