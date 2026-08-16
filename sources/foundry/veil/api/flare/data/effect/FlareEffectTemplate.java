package foundry.veil.api.flare.data.effect;

import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/data/effect/FlareEffectTemplate.class */
public final class FlareEffectTemplate extends Record {
    private final FlareEffectLayer[] effectLayers;
    private final FlareEffectLayer[] activeEffectLayers;
    public static final Codec<FlareEffectTemplate> CODEC = CodecUtil.singleOrList(FlareEffectLayer.CODEC).fieldOf("layers").xmap((v1) -> {
        return new FlareEffectTemplate(v1);
    }, template -> {
        return List.of((Object[]) template.effectLayers);
    }).codec();

    public FlareEffectTemplate(FlareEffectLayer[] effectLayers, FlareEffectLayer[] activeEffectLayers) {
        this.effectLayers = effectLayers;
        this.activeEffectLayers = activeEffectLayers;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FlareEffectTemplate.class), FlareEffectTemplate.class, "effectLayers;activeEffectLayers", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->effectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->activeEffectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FlareEffectTemplate.class), FlareEffectTemplate.class, "effectLayers;activeEffectLayers", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->effectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->activeEffectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FlareEffectTemplate.class, Object.class), FlareEffectTemplate.class, "effectLayers;activeEffectLayers", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->effectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareEffectTemplate;->activeEffectLayers:[Lfoundry/veil/api/flare/data/effect/FlareEffectLayer;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public FlareEffectLayer[] effectLayers() {
        return this.effectLayers;
    }

    public FlareEffectLayer[] activeEffectLayers() {
        return this.activeEffectLayers;
    }

    public FlareEffectTemplate(FlareEffectLayer[] effectLayers) {
        this(effectLayers, getActiveLayers(List.of((Object[]) effectLayers)));
    }

    public FlareEffectTemplate(Collection<FlareEffectLayer> effectLayers) {
        this((FlareEffectLayer[]) effectLayers.toArray(x$0 -> {
            return new FlareEffectLayer[x$0];
        }), getActiveLayers(effectLayers));
    }

    private static FlareEffectLayer[] getActiveLayers(Collection<FlareEffectLayer> effectLayers) {
        ArrayList<FlareEffectLayer> enabledLayers = new ArrayList<>(effectLayers.size());
        for (FlareEffectLayer effectLayer : effectLayers) {
            if (!effectLayer.isDisabled()) {
                enabledLayers.add(effectLayer);
            }
        }
        return (FlareEffectLayer[]) enabledLayers.toArray(x$0 -> {
            return new FlareEffectLayer[x$0];
        });
    }

    public void render(EffectHost host, MatrixStack matrixStack, float partialTick) {
        render(host, matrixStack, partialTick, null);
    }

    public void render(EffectHost host, MatrixStack matrixStack, float partialTick, @Nullable Map<ResourceLocation, BakedShell> shellOverrides) {
        for (FlareEffectLayer effectLayer : this.activeEffectLayers) {
            effectLayer.render(host, matrixStack, partialTick, shellOverrides);
        }
    }
}
