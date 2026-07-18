package foundry.veil;

import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.registry.RenderTypeShardRegistry;
import foundry.veil.api.client.registry.VeilResourceEditorRegistry;
import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.registry.EmitterShapeRegistry;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import foundry.veil.impl.client.imgui.VeilImGuiCompat;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferManager;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferShard;
import foundry.veil.impl.flare.FlareManager;
import foundry.veil.impl.quasar.QuasarParticleHandler;
import foundry.veil.impl.resource.VeilResourceManagerImpl;
import foundry.veil.platform.VeilClientPlatform;
import foundry.veil.platform.VeilEventPlatform;
import java.util.ServiceLoader;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/VeilClient.class */
@ApiStatus.Internal
public class VeilClient {
    private static final VeilClientPlatform PLATFORM = (VeilClientPlatform) ServiceLoader.load(VeilClientPlatform.class).findFirst().orElseThrow(() -> {
        return new RuntimeException("Veil expected client platform implementation");
    });
    private static final VeilResourceManagerImpl RESOURCE_MANAGER = new VeilResourceManagerImpl();

    public static void init() {
        VeilRenderSystem.bootstrap();
        QuasarParticleHandler.init();
        QuasarParticles.bootstrap();
        FlareManager.bootstrap();
        VeilEventPlatform.INSTANCE.onFreeNativeResources(() -> {
            VeilRenderSystem.close();
            RESOURCE_MANAGER.free();
        });
        VeilEventPlatform.INSTANCE.onVeilRendererAvailable(renderer -> {
            RESOURCE_MANAGER.addVeilLoaders(renderer);
        });
        if (Veil.IMGUIMC) {
            VeilImGuiCompat.load();
        }
        VeilEventPlatform.INSTANCE.onVeilRegisterFixedBuffers(registry -> {
            registry.registerFixedBuffer(VeilRenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS, RenderType.translucentMovingBlock());
        });
        RenderTypeShardRegistry.addGenericShard(renderType -> {
            return "main_target".equals(getOutputName(renderType));
        }, new DynamicBufferShard(DynamicBufferManager.MAIN_WRAPPER, (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().getMainRenderTarget();
        }));
        RenderTypeShardRegistry.addGenericShard(renderType2 -> {
            return "translucent_target".equals(getOutputName(renderType2));
        }, new DynamicBufferShard("translucent", (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().levelRenderer.getTranslucentTarget();
        }));
        RenderTypeShardRegistry.addGenericShard(renderType3 -> {
            return "particles_target".equals(getOutputName(renderType3));
        }, new DynamicBufferShard("particles", (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().levelRenderer.getParticlesTarget();
        }));
        RenderTypeShardRegistry.addGenericShard(renderType4 -> {
            return "weather_target".equals(getOutputName(renderType4));
        }, new DynamicBufferShard("weather", (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().levelRenderer.getWeatherTarget();
        }));
        RenderTypeShardRegistry.addGenericShard(renderType5 -> {
            return "clouds_target".equals(getOutputName(renderType5));
        }, new DynamicBufferShard("clouds", (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().levelRenderer.getCloudsTarget();
        }));
        RenderTypeShardRegistry.addGenericShard(renderType6 -> {
            return "item_entity_target".equals(getOutputName(renderType6));
        }, new DynamicBufferShard("item_entity", (Supplier<RenderTarget>) () -> {
            return Minecraft.getInstance().levelRenderer.getItemEntityTarget();
        }));
        PostPipelineStageRegistry.bootstrap();
        LightTypeRegistry.bootstrap();
        RenderTypeLayerRegistry.bootstrap();
        VeilShaderBufferRegistry.bootstrap();
        VeilResourceEditorRegistry.bootstrap();
        EmitterShapeRegistry.bootstrap();
        RenderStyleRegistry.bootstrap();
        ParticleModuleTypeRegistry.bootstrap();
        PropertyRegistry.bootstrap();
        PropertyModifierRegistry.bootstrap();
    }

    private static String getOutputName(RenderType.CompositeRenderType renderType) {
        return VeilRenderType.getName(VeilRenderType.getShards(renderType).outputState());
    }

    public static VeilClientPlatform clientPlatform() {
        return PLATFORM;
    }

    public static VeilResourceManagerImpl resourceManager() {
        return RESOURCE_MANAGER;
    }
}
