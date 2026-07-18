package foundry.veil.api.resource.type;

import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.FramebufferDefinition;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.FramebufferEditAction;
import foundry.veil.impl.resource.action.TextEditAction;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/FramebufferResource.class */
@ApiStatus.Internal
public final class FramebufferResource extends Record implements VeilTextResource<FramebufferResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FramebufferResource.class), FramebufferResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FramebufferResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FramebufferResource.class), FramebufferResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FramebufferResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FramebufferResource.class, Object.class), FramebufferResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FramebufferResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public FramebufferResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<FramebufferResource>> getActions() {
        return List.of(new TextEditAction(), FramebufferEditAction.INSTANCE);
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        BufferedReader reader = this.resourceInfo.openAsReader(resourceManager);
        try {
            DataResult<FramebufferDefinition> result = FramebufferDefinition.CODEC.parse(JsonOps.INSTANCE, JsonParser.parseReader(reader));
            if (result.error().isPresent()) {
                throw new JsonParseException(((DataResult.Error) result.error().get()).message());
            }
            VeilRenderSystem.renderer().getFramebufferManager().setDefinition(FramebufferManager.FRAMEBUFFER_LISTER.fileToId(this.resourceInfo.location()), (FramebufferDefinition) result.getOrThrow());
            if (reader != null) {
                reader.close();
            }
        } catch (Throwable th) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60687;
    }
}
