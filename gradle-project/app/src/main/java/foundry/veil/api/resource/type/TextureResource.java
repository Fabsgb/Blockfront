package foundry.veil.api.resource.type;

import foundry.imgui.api.ImGuiMC;
import foundry.imgui.api.ImGuiTextureProvider;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.util.CompositeReloadListener;
import foundry.veil.ext.TextureAtlasExtension;
import foundry.veil.mixin.resource.accessor.ResourceAtlasSetAccessor;
import foundry.veil.mixin.resource.accessor.ResourceModelManagerAccessor;
import foundry.veil.mixin.resource.accessor.ResourceTextureAtlasAccessor;
import imgui.ImGui;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.resources.model.AtlasSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.InactiveProfiler;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/TextureResource.class */
@ApiStatus.Internal
public final class TextureResource extends Record implements VeilResource<TextureResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextureResource.class), TextureResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/TextureResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextureResource.class), TextureResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/TextureResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextureResource.class, Object.class), TextureResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/TextureResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public TextureResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void render(boolean dragging, boolean fullName) {
        float size = ImGui.getTextLineHeight();
        ImGuiTextureProvider texture = ImGuiMC.getTexture(Minecraft.getInstance().getTextureManager().getTexture(this.resourceInfo.location()));
        ImGui.pushStyleColor(0, this.resourceInfo.isStatic() ? -5592406 : -1);
        if (dragging) {
            ImGuiMC.image(texture, size * 8.0f, size * 8.0f);
            VeilImGuiUtil.resourceLocation(resourceInfo().location());
        } else {
            ImGui.pushStyleVar(14, 0.0f, 0.0f);
            ImGui.setNextItemAllowOverlap();
            ImGuiMC.image(texture, size, size);
            ImGui.sameLine();
            ImGui.popStyleVar();
            if (ImGui.isItemHovered()) {
                ImGui.beginTooltip();
                ImGuiMC.image(texture, size * 16.0f, size * 16.0f);
                ImGui.endTooltip();
            }
            ImGui.sameLine();
            if (fullName) {
                VeilImGuiUtil.resourceLocation(this.resourceInfo.location());
            } else {
                ImGui.text(this.resourceInfo.fileName());
            }
        }
        ImGui.popStyleColor();
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<TextureResource>> getActions() {
        return List.of();
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        ResourceLocation location = this.resourceInfo.location();
        ResourceManager resources = resourceManager.resources(this.resourceInfo);
        Minecraft client = Minecraft.getInstance();
        TextureManager textureManager = client.getTextureManager();
        AbstractTexture texture = textureManager.getTexture(location, (AbstractTexture) null);
        if (texture != null) {
            texture.reset(textureManager, resources, location, client);
        }
        PreparableReloadListener modelManager = client.getModelManager();
        ResourceAtlasSetAccessor atlases = ((ResourceModelManagerAccessor) modelManager).getAtlases();
        ResourceLocation id = SpriteSource.TEXTURE_ID_CONVERTER.fileToId(location);
        boolean reloadRequired = client.getGuiSprites().veil$hasTexture(id);
        if (!reloadRequired) {
            Iterator<Map.Entry<ResourceLocation, AtlasSet.AtlasEntry>> it = atlases.getAtlases().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getValue().atlas().veil$hasTexture(id)) {
                        reloadRequired = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!reloadRequired) {
            return;
        }
        if (SodiumCompat.INSTANCE != null) {
            CompositeReloadListener.of(modelManager, client.getBlockRenderer(), client.getItemRenderer(), client.getGuiSprites()).reload(CompletableFuture::completedFuture, resources, InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), client).thenRunAsync(VeilRenderSystem::rebuildChunks, VeilRenderSystem.renderThreadExecutor());
            return;
        }
        for (Map.Entry<ResourceLocation, AtlasSet.AtlasEntry> entry : atlases.getAtlases().entrySet()) {
            TextureAtlasExtension textureAtlasExtensionAtlas = entry.getValue().atlas();
            if (textureAtlasExtensionAtlas.veil$hasTexture(id)) {
                int mipLevel = ((ResourceTextureAtlasAccessor) textureAtlasExtensionAtlas).getMipLevel();
                SpriteLoader.create(textureAtlasExtensionAtlas).loadAndStitch(resources, entry.getValue().atlasInfoLocation(), mipLevel, Util.backgroundExecutor()).thenCompose((v0) -> {
                    return v0.waitForUpload();
                }).thenAcceptAsync(preparations -> {
                    textureAtlasExtensionAtlas.upload(preparations);
                    VeilRenderSystem.rebuildChunks();
                }, VeilRenderSystem.renderThreadExecutor());
            }
        }
        if (client.getGuiSprites().veil$hasTexture(id)) {
            client.getGuiSprites().reload(CompletableFuture::completedFuture, resources, InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), client);
        }
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 62405;
    }
}
