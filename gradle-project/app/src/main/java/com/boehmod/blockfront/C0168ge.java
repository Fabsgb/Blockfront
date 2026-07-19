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

/* JADX INFO: renamed from: com.boehmod.blockfront.ge, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ge.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0168ge {
    public static final String ab = "instanced_bullet_tracer";
    public static final ResourceLocation cF = C0265jv.d(ab);

    @Nullable
    private static ShaderInstance a;

    @Nullable
    public static ShaderInstance a() {
        return a;
    }

    public static void a(@NotNull ShaderInstance shaderInstance) {
        a = shaderInstance;
    }

    @SubscribeEvent
    public static void b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), cF, DefaultVertexFormat.POSITION), C0168ge::a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
