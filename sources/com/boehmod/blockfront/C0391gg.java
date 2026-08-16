package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.io.IOException;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gg.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0391gg {

    /* JADX INFO: renamed from: ad */
    public static final String f2543ad = "instanced_rotating_particle";

    /* JADX INFO: renamed from: cz */
    public static final ResourceLocation f2544cz = C0532jO.m2378d(f2543ad);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2545a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1847a() {
        return f2545a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1848a(@NotNull ShaderInstance shaderInstance) {
        f2545a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1849b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2544cz, DefaultVertexFormat.NEW_ENTITY), C0391gg::m1848a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
