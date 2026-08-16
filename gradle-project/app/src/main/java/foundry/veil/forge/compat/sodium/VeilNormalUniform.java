package foundry.veil.forge.compat.sodium;

import java.nio.FloatBuffer;
import net.caffeinemc.mods.sodium.client.gl.shader.uniform.GlUniform;
import org.joml.Matrix3fc;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/compat/sodium/VeilNormalUniform.class */
public class VeilNormalUniform extends GlUniform<Matrix3fc> {
    public VeilNormalUniform(int index) {
        super(index);
    }

    public void set(Matrix3fc value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(9);
            value.get(buffer);
            GL20C.glUniformMatrix3fv(this.index, false, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
