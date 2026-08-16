package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.io.IOException;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xy.class */
public class C1311xy {

    /* JADX INFO: renamed from: g */
    public static ShaderInstance f7907g;

    /* JADX INFO: renamed from: gH */
    public static final ResourceLocation f7908gH = C0532jO.m2378d("rendertype_vehicle_block");

    /* JADX INFO: renamed from: c */
    public static void m8228c(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), C0393gi.f2547cA, DefaultVertexFormat.PARTICLE), C0393gi::m1850b);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), C0393gi.f2548cB, DefaultVertexFormat.PARTICLE), C0393gi::m1851c);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f7908gH, DefaultVertexFormat.NEW_ENTITY), shaderInstance -> {
            f7907g = shaderInstance;
        });
    }
}
