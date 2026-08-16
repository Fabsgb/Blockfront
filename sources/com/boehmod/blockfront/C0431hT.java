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

/* JADX INFO: renamed from: com.boehmod.blockfront.hT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hT.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0431hT extends RenderType {

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final String f2707as = "weapon_overlay";

    /* JADX INFO: renamed from: f */
    private static ShaderInstance f2709f;

    /* JADX INFO: renamed from: dd */
    @NotNull
    public static final ResourceLocation f2708dd = C0532jO.m2378d("rendertype_weapon_overlay");

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final RenderStateShard.ShaderStateShard f2710b = new RenderStateShard.ShaderStateShard(() -> {
        return f2709f;
    });

    /* JADX INFO: renamed from: e */
    @NotNull
    public static Function<ResourceLocation, RenderType> f2711e = Util.memoize(C0431hT::m1979b);

    public C0431hT(String str, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean z, boolean z2, Runnable runnable, Runnable runnable2) {
        super(str, vertexFormat, mode, i, z, z2, runnable, runnable2);
    }

    /* JADX INFO: renamed from: b */
    private static RenderType m1979b(@NotNull ResourceLocation resourceLocation) {
        return create(f2707as, DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, RenderType.CompositeState.builder().setShaderState(f2710b).setTextureState(new RenderStateShard.TextureStateShard(resourceLocation, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(true));
    }

    /* JADX INFO: renamed from: d */
    public static void m1980d(@NotNull ShaderInstance shaderInstance) {
        f2709f = shaderInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1981a() {
        return f2709f;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1982b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2708dd, DefaultVertexFormat.NEW_ENTITY), C0431hT::m1980d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
