package foundry.veil.impl.client.render.pipeline;

import net.minecraft.client.renderer.RenderStateShard;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL11C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/FlagShards.class */
@ApiStatus.Internal
public class FlagShards extends RenderStateShard {
    public static final FlagShards DEPTH_CLAMP = new FlagShards("depth_clamp", 34383);
    public static final FlagShards DITHER = new FlagShards("dither", 3024);
    public static final FlagShards LINE_SMOOTH = new FlagShards("line_smooth", 2848);
    public static final FlagShards MULTISAMPLE = new FlagShards("multisample", 32925);
    public static final FlagShards TEXTURE_CUBE_MAP_SEAMLESS = new FlagShards("cube_map_seamless", 34895);

    private FlagShards(String name, int flag) {
        super("veil:" + name, () -> {
            GL11C.glEnable(flag);
        }, () -> {
            GL11C.glDisable(flag);
        });
    }
}
