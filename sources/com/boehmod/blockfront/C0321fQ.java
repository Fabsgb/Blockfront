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

/* JADX INFO: renamed from: com.boehmod.blockfront.fQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fQ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0321fQ {

    /* JADX INFO: renamed from: W */
    public static final String f2348W = "instanced_rotating_particle";

    /* JADX INFO: renamed from: cz */
    public static final ResourceLocation f2349cz = C0564jv.m2555d(f2348W);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2350a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1637a() {
        return f2350a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1638a(@NotNull ShaderInstance shaderInstance) {
        f2350a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1639b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2349cz, DefaultVertexFormat.NEW_ENTITY), C0321fQ::m1638a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
