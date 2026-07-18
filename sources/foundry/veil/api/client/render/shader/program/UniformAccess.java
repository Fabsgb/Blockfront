package foundry.veil.api.client.render.shader.program;

import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/program/UniformAccess.class */
@ApiStatus.NonExtendable
public interface UniformAccess {
    int getUniformLocation(CharSequence charSequence);

    boolean hasUniform(CharSequence charSequence);

    @Nullable
    ShaderUniformAccess getUniform(CharSequence charSequence);

    ShaderUniformAccess getUniformSafe(CharSequence charSequence);

    int getUniformBlock(CharSequence charSequence);

    boolean hasUniformBlock(CharSequence charSequence);

    int getStorageBlock(CharSequence charSequence);

    boolean hasStorageBlock(CharSequence charSequence);

    void setUniformBlock(CharSequence charSequence, int i);

    void setStorageBlock(CharSequence charSequence, int i);
}
