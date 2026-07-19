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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fQ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class fQ {
    public static final String W = "instanced_rotating_particle";
    public static final ResourceLocation cz = C0265jv.d(W);

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
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), cz, DefaultVertexFormat.NEW_ENTITY), fQ::a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
