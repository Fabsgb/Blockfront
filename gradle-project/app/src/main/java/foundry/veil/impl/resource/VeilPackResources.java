package foundry.veil.impl.resource;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.impl.resource.tree.VeilResourceFolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/VeilPackResources.class */
@ApiStatus.Internal
public class VeilPackResources implements NativeResource {
    private final String name;
    private final VeilResourceFolder root;
    private int texture;

    public VeilPackResources(String name) {
        this.name = name;
        this.root = new VeilResourceFolder(name);
    }

    public void add(@Nullable PackType packType, ResourceLocation loc, VeilResource<?> resource) {
        if (packType != null) {
            this.root.addResource(packType.getDirectory() + "/" + loc.getNamespace() + "/" + loc.getPath(), resource);
        } else {
            this.root.addResource(loc.getPath(), resource);
        }
    }

    @Nullable
    public VeilResource<?> getVeilResource(String namespace, String path) {
        VeilResourceFolder namespaceFolder;
        VeilResource<?> rootResource;
        VeilResource<?> resource;
        VeilResourceFolder rootFolder = this.root.getFolder(namespace);
        if (rootFolder != null && (resource = rootFolder.getResource(path)) != null) {
            return resource;
        }
        for (PackType value : PackType.values()) {
            VeilResourceFolder packFolder = this.root.getFolder(value.getDirectory());
            if (packFolder != null && (namespaceFolder = packFolder.getFolder(namespace)) != null && (rootResource = namespaceFolder.getResource(path)) != null) {
                return rootResource;
            }
        }
        return null;
    }

    public void loadIcon(NativeImage image, boolean blur) {
        if (this.texture == 0) {
            this.texture = GL11C.glGenTextures();
        }
        TextureUtil.prepareImage(this.texture, image.getWidth(), image.getHeight());
        GL11C.glTexParameteri(3553, 10241, blur ? 9729 : 9728);
        GL11C.glTexParameteri(3553, 10240, blur ? 9729 : 9728);
        image.upload(0, 0, 0, false);
    }

    public String getName() {
        return this.name;
    }

    public VeilResourceFolder getRoot() {
        return this.root;
    }

    public int getTexture() {
        return this.texture;
    }

    public void free() {
        if (this.texture != 0) {
            GL11C.glDeleteTextures(this.texture);
            this.texture = 0;
        }
    }
}
