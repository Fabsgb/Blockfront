package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hD.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class hD extends RenderType {

    @NotNull
    public static final String al = "weapon_overlay";
    private static ShaderInstance f;

    @NotNull
    public static final ResourceLocation dd = C0265jv.d("rendertype_weapon_overlay");

    @NotNull
    private static final RenderStateShard.ShaderStateShard b = new RenderStateShard.ShaderStateShard(() -> {
        return f;
    });

    @NotNull
    public static Function<ResourceLocation, RenderType> e = Util.memoize(hD::b);

    public hD(String str, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        super(str, vertexFormat, mode, i, z, z2, runnable, runnable2);
    }

    private static RenderType b(@NotNull ResourceLocation resourceLocation) {
        return create(al, DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, RenderType.CompositeState.builder().setShaderState(b).setTextureState(new RenderStateShard.TextureStateShard(resourceLocation, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true));
    }

    public static void d(@NotNull ShaderInstance shaderInstance) {
        f = shaderInstance;
    }

    @Nullable
    public static ShaderInstance a() {
        return f;
    }

    @SubscribeEvent
    public static void b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), dd, DefaultVertexFormat.NEW_ENTITY), hD::d);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
