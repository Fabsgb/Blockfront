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

/* JADX INFO: renamed from: com.boehmod.blockfront.ge */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ge.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0388ge {

    /* JADX INFO: renamed from: ab */
    public static final String f2576ab = "instanced_bullet_tracer";

    /* JADX INFO: renamed from: cF */
    public static final ResourceLocation f2577cF = C0564jv.m2555d(f2576ab);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2578a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1867a() {
        return f2578a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1868a(@NotNull ShaderInstance shaderInstance) {
        f2578a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1869b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2577cF, DefaultVertexFormat.POSITION), C0388ge::m1868a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
