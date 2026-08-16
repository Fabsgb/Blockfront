package foundry.veil.mixin.shader_recompile.accessor;

import com.mojang.blaze3d.shaders.Program;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/shader_recompile/accessor/ShaderRecompileProgramAccessor.class */
@Mixin({Program.class})
public interface ShaderRecompileProgramAccessor {
    @Accessor
    int getId();

    @Accessor
    void setId(int i);
}
