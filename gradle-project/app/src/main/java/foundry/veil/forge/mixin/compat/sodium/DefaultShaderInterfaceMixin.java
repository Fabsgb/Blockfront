package foundry.veil.forge.mixin.compat.sodium;

import foundry.veil.forge.compat.sodium.VeilNormalUniform;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.DefaultShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ShaderBindingContext;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/compat/sodium/DefaultShaderInterfaceMixin.class */
@Mixin({DefaultShaderInterface.class})
public class DefaultShaderInterfaceMixin {

    @Unique
    private VeilNormalUniform veil$uniformNormalMatrix;

    @Inject(method = {"<init>"}, at = {@At("TAIL")})
    private void init(ShaderBindingContext context, ChunkShaderOptions options, CallbackInfo ci) {
        this.veil$uniformNormalMatrix = (VeilNormalUniform) context.bindUniformOptional("VeilNormalMatrix", VeilNormalUniform::new);
    }

    @Inject(method = {"setModelViewMatrix"}, at = {@At("TAIL")}, remap = false)
    public void setModelViewMatrix(Matrix4fc matrix, CallbackInfo ci) {
        if (this.veil$uniformNormalMatrix != null) {
            this.veil$uniformNormalMatrix.set((Matrix3fc) matrix.normal(new Matrix3f()));
        }
    }
}
