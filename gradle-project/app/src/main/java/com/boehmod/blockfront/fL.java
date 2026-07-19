package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL.class */
public interface fL {
    public static final fL a = new fL() { // from class: com.boehmod.blockfront.fL.1
        @Override // com.boehmod.blockfront.fL
        public void r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.disableBlend();
            RenderSystem.setShader(fM::a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.fL
        public void s(@NotNull Minecraft minecraft) {
            RenderSystem.enableCull();
        }
    };
    public static final fL b = new fL() { // from class: com.boehmod.blockfront.fL.2
        @Override // com.boehmod.blockfront.fL
        public void r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(fM::a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.fL
        public void s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };
    public static final fL c = new fL() { // from class: com.boehmod.blockfront.fL.3
        @Override // com.boehmod.blockfront.fL
        public void r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 1);
            RenderSystem.setShader(fM::a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.fL
        public void s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };
    public static final fL d = new fL() { // from class: com.boehmod.blockfront.fL.4
        @Override // com.boehmod.blockfront.fL
        public void r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(fQ::a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.fL
        public void s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };
    public static final fL e = new fL() { // from class: com.boehmod.blockfront.fL.5
        @Override // com.boehmod.blockfront.fL
        public void r(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.setShader(fS::c);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.getShader().setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.fL
        public void s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    void r(@NotNull Minecraft minecraft);

    void s(@NotNull Minecraft minecraft);
}
