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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fS.class */
public class fS implements ParticleRenderType {

    @NotNull
    public static final fS a = new fS();

    @NotNull
    public static final ResourceLocation cA = C0265jv.d("soft_particle");

    @NotNull
    public static final ResourceLocation cB = C0265jv.d("instanced_soft_particle");
    private static ShaderInstance b;
    private static ShaderInstance c;

    private fS() {
    }

    @ApiStatus.Internal
    public static void b(@NotNull ShaderInstance shaderInstance) {
        b = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    @ApiStatus.Internal
    public static void c(@NotNull ShaderInstance shaderInstance) {
        c = (ShaderInstance) Objects.requireNonNull(shaderInstance);
    }

    public static ShaderInstance b() {
        return b;
    }

    public static ShaderInstance c() {
        return c;
    }

    @Nullable
    public BufferBuilder begin(Tesselator tesselator, @NotNull TextureManager textureManager) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.setShader(fS::b);
        RenderSystem.depthMask(false);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        b.setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
        return tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
    }
}
