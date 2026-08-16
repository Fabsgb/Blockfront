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

/* JADX INFO: renamed from: com.boehmod.blockfront.hS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hS.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0430hS extends RenderType {

    /* JADX INFO: renamed from: ar */
    public static final String f2702ar = "corpse";

    /* JADX INFO: renamed from: e */
    private static ShaderInstance f2704e;

    /* JADX INFO: renamed from: dc */
    public static final ResourceLocation f2703dc = C0532jO.m2378d("rendertype_corpse");

    /* JADX INFO: renamed from: a */
    private static final RenderStateShard.ShaderStateShard f2705a = new RenderStateShard.ShaderStateShard(() -> {
        return f2704e;
    });

    /* JADX INFO: renamed from: d */
    public static Function<ResourceLocation, RenderType> f2706d = Util.memoize(C0430hS::m1975a);

    public C0430hS(String str, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        super(str, vertexFormat, mode, i, z, z2, runnable, runnable2);
    }

    /* JADX INFO: renamed from: a */
    private static RenderType m1975a(@NotNull ResourceLocation resourceLocation) {
        return create(f2702ar, DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, RenderType.CompositeState.builder().setShaderState(f2705a).setTextureState(new RenderStateShard.TextureStateShard(resourceLocation, false, false)).setTransparencyState(NO_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true));
    }

    /* JADX INFO: renamed from: d */
    public static void m1976d(@NotNull ShaderInstance shaderInstance) {
        f2704e = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1977b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2703dc, DefaultVertexFormat.NEW_ENTITY), C0430hS::m1976d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
