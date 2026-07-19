package foundry.veil.api.client.render.texture;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.ext.AbstractTextureExtension;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.core.Direction;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL13C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/CubemapTexture.class */
public abstract class CubemapTexture extends AbstractTexture implements AbstractTextureExtension {

    /* JADX INFO: renamed from: foundry.veil.api.client.render.texture.CubemapTexture$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/CubemapTexture$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static int getGlFace(Direction direction) throws MatchException {
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                return 34072;
            case 2:
                return 34071;
            case 3:
                return 34074;
            case 4:
                return 34073;
            case 5:
                return 34070;
            case 6:
                return 34069;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public void setFilter(boolean blur, boolean mipmap) {
        int minFilter;
        int magFilter;
        RenderSystem.assertOnRenderThreadOrInit();
        this.blur = blur;
        this.mipmap = mipmap;
        if (blur) {
            minFilter = mipmap ? 9987 : 9729;
            magFilter = 9729;
        } else {
            minFilter = mipmap ? 9986 : 9728;
            magFilter = 9728;
        }
        if (VeilRenderSystem.directStateAccessSupported()) {
            int id = getId();
            ARBDirectStateAccess.glTextureParameteri(id, 10241, minFilter);
            ARBDirectStateAccess.glTextureParameteri(id, 10240, magFilter);
        } else {
            bind();
            GL13C.glTexParameteri(34067, 10241, minFilter);
            GL13C.glTexParameteri(34067, 10240, magFilter);
        }
    }

    public int getId() {
        RenderSystem.assertOnRenderThreadOrInit();
        if (this.id == -1) {
            this.id = VeilRenderSystem.createTextures(34067);
        }
        return this.id;
    }

    public void bind() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            GL13C.glBindTexture(34067, getId());
        });
    }

    @Override // foundry.veil.ext.AbstractTextureExtension
    public int getTextureTarget() {
        return 34067;
    }
}
