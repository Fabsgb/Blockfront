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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fM.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class fM {
    public static final String V = "instanced_particle";
    public static final ResourceLocation cy = C0265jv.d(V);

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
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), cy, DefaultVertexFormat.NEW_ENTITY), fM::a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
