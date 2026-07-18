package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.io.IOException;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xb.class */
public class C1279xb {

    /* JADX INFO: renamed from: g */
    public static ShaderInstance f7495g;

    /* JADX INFO: renamed from: gH */
    public static final ResourceLocation f7496gH = C0564jv.m2555d("rendertype_vehicle_block");

    /* JADX INFO: renamed from: c */
    public static void m7796c(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), C0323fS.f2352cA, DefaultVertexFormat.PARTICLE), C0323fS::m1640b);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), C0323fS.f2353cB, DefaultVertexFormat.PARTICLE), C0323fS::m1641c);
        registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f7496gH, DefaultVertexFormat.NEW_ENTITY), shaderInstance -> {
            f7495g = shaderInstance;
        });
    }
}
