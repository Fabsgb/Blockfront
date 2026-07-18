package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Arrays;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.core.Direction;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/client/PipelineShaderInstanceMixin.class */
@Mixin({ShaderInstance.class})
public abstract class PipelineShaderInstanceMixin {

    @Unique
    private static final Direction[] veil$DIRECTIONS = Direction.values();

    @Unique
    private static final String[] veil$FACE_BRIGHTNESS_UNIFORM_NAMES = (String[]) Arrays.stream(veil$DIRECTIONS).map(direction -> {
        return "VeilBlockFaceBrightness[" + direction.get3DDataValue() + "]";
    }).toArray(x$0 -> {
        return new String[x$0];
    });

    @Unique
    private static final Matrix3f veil$NORMAL_MATRIX = new Matrix3f();

    @Shadow
    @Nullable
    public abstract Uniform getUniform(String str);

    @Inject(method = {"setDefaultUniforms"}, at = {@At("TAIL")})
    public void setDefaultUniforms(VertexFormat.Mode mode, Matrix4f projectionMatrix, Matrix4f frustrumMatrix, Window window, CallbackInfo ci) {
        Uniform renderTime = getUniform("VeilRenderTime");
        if (renderTime != null) {
            renderTime.set((System.currentTimeMillis() % 3600000) / 1000.0f);
        }
        Uniform normalMat = getUniform("NormalMat");
        if (normalMat != null) {
            normalMat.set(projectionMatrix.normal(veil$NORMAL_MATRIX));
        }
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            for (Direction value : veil$DIRECTIONS) {
                Uniform uniform = getUniform(veil$FACE_BRIGHTNESS_UNIFORM_NAMES[value.ordinal()]);
                if (uniform != null) {
                    uniform.set(level.getShade(value, true));
                }
            }
        }
    }
}
