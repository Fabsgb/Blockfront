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

/* JADX INFO: renamed from: com.boehmod.blockfront.fS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fS.class */
public class C0323fS implements ParticleRenderType {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0323fS f2351a = new C0323fS();

    /* JADX INFO: renamed from: cA */
    @NotNull
    public static final ResourceLocation f2352cA = C0564jv.m2555d("soft_particle");

    /* JADX INFO: renamed from: cB */
    @NotNull
    public static final ResourceLocation f2353cB = C0564jv.m2555d("instanced_soft_particle");

    /* JADX INFO: renamed from: b */
    private static ShaderInstance f2354b;

    /* JADX INFO: renamed from: c */
    private static ShaderInstance f2355c;

    private C0323fS() {
    }

    @ApiStatus.Internal
    /* JADX INFO: renamed from: b */
    public static void m1640b(@NotNull ShaderInstance shaderInstance) {
        f2354b = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    @ApiStatus.Internal
    /* JADX INFO: renamed from: c */
    public static void m1641c(@NotNull ShaderInstance shaderInstance) {
        f2355c = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    /* JADX INFO: renamed from: b */
    public static ShaderInstance m1642b() {
        return f2354b;
    }

    /* JADX INFO: renamed from: c */
    public static ShaderInstance m1643c() {
        return f2355c;
    }

    @Nullable
    public BufferBuilder begin(Tesselator tesselator, @NotNull TextureManager textureManager) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.setShader(C0323fS::m1642b);
        RenderSystem.depthMask(false);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        f2354b.setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
        return tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
    }
}
