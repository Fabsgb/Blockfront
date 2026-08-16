package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gi.class */
public class C0393gi implements ParticleRenderType {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0393gi f2546a = new C0393gi();

    /* JADX INFO: renamed from: cA */
    @NotNull
    public static final ResourceLocation f2547cA = C0532jO.m2378d("soft_particle");

    /* JADX INFO: renamed from: cB */
    @NotNull
    public static final ResourceLocation f2548cB = C0532jO.m2378d("instanced_soft_particle");

    /* JADX INFO: renamed from: b */
    private static ShaderInstance f2549b;

    /* JADX INFO: renamed from: c */
    private static ShaderInstance f2550c;

    private C0393gi() {
    }

    @ApiStatus.Internal
    /* JADX INFO: renamed from: b */
    public static void m1850b(@NotNull ShaderInstance shaderInstance) {
        f2549b = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    @ApiStatus.Internal
    /* JADX INFO: renamed from: c */
    public static void m1851c(@NotNull ShaderInstance shaderInstance) {
        f2550c = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    /* JADX INFO: renamed from: b */
    public static ShaderInstance m1852b() {
        return f2549b;
    }

    /* JADX INFO: renamed from: c */
    public static ShaderInstance m1853c() {
        return f2550c;
    }

    @Nullable
    public BufferBuilder begin(Tesselator tesselator, @NotNull TextureManager textureManager) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.setShader(C0393gi::m1852b);
        RenderSystem.depthMask(false);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        f2549b.setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
        return tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
    }
}
