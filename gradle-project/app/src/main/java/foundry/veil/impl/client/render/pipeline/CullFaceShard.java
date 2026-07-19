package foundry.veil.impl.client.render.pipeline;

import java.util.Locale;
import net.minecraft.client.renderer.RenderStateShard;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL11C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/CullFaceShard.class */
@ApiStatus.Internal
public class CullFaceShard extends RenderStateShard {
    private final String modeName;

    public CullFaceShard(int mode) {
        String str;
        super("veil:cull_face", () -> {
            GL11C.glCullFace(mode);
        }, () -> {
            GL11C.glCullFace(1029);
        });
        switch (mode) {
            case 1028:
                str = "front";
                break;
            case 1029:
                str = "back";
                break;
            case 1030:
            case 1031:
            default:
                str = "0x" + Integer.toHexString(mode).toLowerCase(Locale.ROOT);
                break;
            case 1032:
                str = "front_and_back";
                break;
        }
        this.modeName = str;
    }

    public String toString() {
        return this.name + "[" + this.modeName + "]";
    }
}
