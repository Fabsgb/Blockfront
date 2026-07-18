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

/* JADX INFO: renamed from: com.boehmod.blockfront.hC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hC.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0413hC extends RenderType {

    /* JADX INFO: renamed from: ak */
    public static final String f2624ak = "corpse";

    /* JADX INFO: renamed from: e */
    private static ShaderInstance f2626e;

    /* JADX INFO: renamed from: dc */
    public static final ResourceLocation f2625dc = C0564jv.m2555d("rendertype_corpse");

    /* JADX INFO: renamed from: a */
    private static final RenderStateShard.ShaderStateShard f2627a = new RenderStateShard.ShaderStateShard(() -> {
        return f2626e;
    });

    /* JADX INFO: renamed from: d */
    public static Function<ResourceLocation, RenderType> f2628d = Util.memoize(C0413hC::m1949a);

    public C0413hC(String str, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        super(str, vertexFormat, mode, i, z, z2, runnable, runnable2);
    }

    /* JADX INFO: renamed from: a */
    private static RenderType m1949a(@NotNull ResourceLocation resourceLocation) {
        return create(f2624ak, DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, RenderType.CompositeState.builder().setShaderState(f2627a).setTextureState(new RenderStateShard.TextureStateShard(resourceLocation, false, false)).setTransparencyState(NO_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true));
    }

    /* JADX INFO: renamed from: d */
    public static void m1950d(@NotNull ShaderInstance shaderInstance) {
        f2626e = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1951b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2625dc, DefaultVertexFormat.NEW_ENTITY), C0413hC::m1950d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
