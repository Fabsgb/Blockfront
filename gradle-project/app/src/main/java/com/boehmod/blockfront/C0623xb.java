package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.io.IOException;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xb.class */
public class C0623xb {
    public static ShaderInstance g;
    public static final ResourceLocation gH = C0265jv.d("rendertype_vehicle_block");

    public static void c(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), fS.cA, DefaultVertexFormat.PARTICLE), fS::b);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), fS.cB, DefaultVertexFormat.PARTICLE), fS::c);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), gH, DefaultVertexFormat.NEW_ENTITY), shaderInstance -> {
            g = shaderInstance;
        });
    }
}
