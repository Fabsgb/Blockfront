package foundry.veil.api.client.render.shader.compiler;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/compiler/ShaderException.class */
public class ShaderException extends Exception {
    private final String glError;

    public ShaderException(String error) {
        this(error, null);
    }

    public ShaderException(String error, @Nullable String glError) {
        super(error);
        this.glError = glError;
    }

    @Nullable
    public String getGlError() {
        return this.glError;
    }
}
