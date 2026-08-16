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

/* JADX INFO: renamed from: com.boehmod.blockfront.gc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gc.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0387gc {

    /* JADX INFO: renamed from: ac */
    public static final String f2535ac = "instanced_particle";

    /* JADX INFO: renamed from: cy */
    public static final ResourceLocation f2536cy = C0532jO.m2378d(f2535ac);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ShaderInstance f2537a;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ShaderInstance m1835a() {
        return f2537a;
    }

    /* JADX INFO: renamed from: a */
    public static void m1836a(@NotNull ShaderInstance shaderInstance) {
        f2537a = shaderInstance;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m1837b(@NotNull RegisterShadersEvent registerShadersEvent) {
        try {
            registerShadersEvent.registerShader(new ShaderInstance(registerShadersEvent.getResourceProvider(), f2536cy, DefaultVertexFormat.NEW_ENTITY), C0387gc::m1836a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
