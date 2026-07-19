package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.util.function.Function;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hC.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class hC extends RenderType {
    public static final String ak = "corpse";
    private static ShaderInstance e;
    public static final ResourceLocation dc = C0265jv.d("rendertype_corpse");
    private static final RenderStateShard.ShaderStateShard a = new RenderStateShard.ShaderStateShard(() -> {
        return e;
    });
    public static Function<ResourceLocation, RenderType> d = Util.memoize(hC::a);

    public hC(String str, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        super(str, vertexFormat, mode, i, z, z2, runnable, runnable2);
    }

    private static RenderType a(@NotNull ResourceLocation resourceLocation) {
        return create(ak, DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, RenderType.CompositeState.builder().setShaderState(a).setTextureState(new RenderStateShard.TextureStateShard(resourceLocation, false, false)).setTransparencyState(NO_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true));
    }

    public static void d(@NotNull ShaderInstance shaderInstance) {
        e = shaderInstance;
    }

    @SubscribeEvent
    public static void b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), dc, DefaultVertexFormat.NEW_ENTITY), hC::d);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
