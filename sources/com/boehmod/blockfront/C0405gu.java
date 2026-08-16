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

/* JADX INFO: renamed from: com.boehmod.blockfront.gu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gu.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0405gu {

    /* JADX INFO: renamed from: ai */
    public static final String f2635ai = "instanced_bullet_tracer";

    /* JADX INFO: renamed from: cF */
    public static final ResourceLocation f2636cF = C0532jO.m2378d(f2635ai);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2637a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1932a() {
        return f2637a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1933a(@NotNull ShaderInstance shaderInstance) {
        f2637a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1934b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2636cF, DefaultVertexFormat.POSITION), C0405gu::m1933a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
