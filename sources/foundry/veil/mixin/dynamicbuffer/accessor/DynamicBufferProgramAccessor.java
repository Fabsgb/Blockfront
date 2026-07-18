package foundry.veil.mixin.dynamicbuffer.accessor;

import com.mojang.blaze3d.shaders.Program;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/dynamicbuffer/accessor/DynamicBufferProgramAccessor.class */
@Mixin({Program.class})
public interface DynamicBufferProgramAccessor {
    @Accessor
    int getId();

    @Accessor
    void setId(int i);
}
