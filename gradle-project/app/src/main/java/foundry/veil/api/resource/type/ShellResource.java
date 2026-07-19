package foundry.veil.api.resource.type;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.ShellInspectAction;
import foundry.veil.impl.resource.action.TextEditAction;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.profiling.InactiveProfiler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/ShellResource.class */
public final class ShellResource extends Record implements VeilTextResource<ShellResource> {
    private final VeilResourceInfo resourceInfo;

    public ShellResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShellResource.class), ShellResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/ShellResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShellResource.class), ShellResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/ShellResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShellResource.class, Object.class), ShellResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/ShellResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<ShellResource>> getActions() {
        return List.of(new TextEditAction(), new ShellInspectAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        VeilRenderSystem.renderer().getEffectManager().getShellManager().reload(CompletableFuture::completedFuture, resourceManager.resources(this.resourceInfo), InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), Minecraft.getInstance());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60895;
    }
}
