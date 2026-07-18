package foundry.veil.api.flare.data.effect;

import com.mojang.serialization.Codec;
import foundry.veil.Veil;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.FlareEffectManager;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/effect/FlareSubModule.class */
public final class FlareSubModule extends Record {
    private final ResourceLocation[] templates;
    public static final Codec<FlareSubModule> CODEC = CodecUtil.singleOrList(ResourceLocation.CODEC).xmap((v1) -> {
        return new FlareSubModule(v1);
    }, module -> {
        return List.of((Object[]) module.templates);
    });

    public FlareSubModule(ResourceLocation[] templates) {
        this.templates = templates;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FlareSubModule.class), FlareSubModule.class, "templates", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareSubModule;->templates:[Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FlareSubModule.class), FlareSubModule.class, "templates", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareSubModule;->templates:[Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FlareSubModule.class, Object.class), FlareSubModule.class, "templates", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareSubModule;->templates:[Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ResourceLocation[] templates() {
        return this.templates;
    }

    public FlareSubModule(Collection<ResourceLocation> templates) {
        this((ResourceLocation[]) templates.toArray(x$0 -> {
            return new ResourceLocation[x$0];
        }));
    }

    public void render(EffectHost host, MatrixStack matrixStack, float partialTick) {
        render(host, matrixStack, partialTick, null);
    }

    public void render(EffectHost host, MatrixStack matrixStack, float partialTick, @Nullable Map<ResourceLocation, BakedShell> shellOverrides) {
        for (ResourceLocation templateLocation : this.templates) {
            FlareEffectTemplate template = FlareEffectManager.getTemplate(templateLocation);
            if (template == null) {
                Veil.LOGGER.error("Template {} could not be found!", templateLocation);
            } else {
                template.render(host, matrixStack, partialTick, shellOverrides);
            }
        }
    }
}
