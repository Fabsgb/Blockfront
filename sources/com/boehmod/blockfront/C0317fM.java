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

/* JADX INFO: renamed from: com.boehmod.blockfront.fM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fM.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0317fM {

    /* JADX INFO: renamed from: V */
    public static final String f2340V = "instanced_particle";

    /* JADX INFO: renamed from: cy */
    public static final ResourceLocation f2341cy = C0564jv.m2555d(f2340V);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2342a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1625a() {
        return f2342a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1626a(@NotNull ShaderInstance shaderInstance) {
        f2342a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1627b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2341cy, DefaultVertexFormat.NEW_ENTITY), C0317fM::m1626a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
