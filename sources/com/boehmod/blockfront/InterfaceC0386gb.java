package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gb.class */
public interface InterfaceC0386gb {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC0386gb f2530a = new InterfaceC0386gb() { // from class: com.boehmod.blockfront.gb.1
        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: s */
        public void mo1833s(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.disableBlend();
            RenderSystem.setShader(C0387gc::m1835a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: t */
        public void mo1834t(@NotNull Minecraft minecraft) {
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: b */
    public static final InterfaceC0386gb f2531b = new InterfaceC0386gb() { // from class: com.boehmod.blockfront.gb.2
        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: s */
        public void mo1833s(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0387gc::m1835a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: t */
        public void mo1834t(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: c */
    public static final InterfaceC0386gb f2532c = new InterfaceC0386gb() { // from class: com.boehmod.blockfront.gb.3
        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: s */
        public void mo1833s(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 1);
            RenderSystem.setShader(C0387gc::m1835a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: t */
        public void mo1834t(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: d */
    public static final InterfaceC0386gb f2533d = new InterfaceC0386gb() { // from class: com.boehmod.blockfront.gb.4
        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: s */
        public void mo1833s(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0391gg::m1847a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: t */
        public void mo1834t(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: e */
    public static final InterfaceC0386gb f2534e = new InterfaceC0386gb() { // from class: com.boehmod.blockfront.gb.5
        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: s */
        public void mo1833s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.setShader(C0393gi::m1853c);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.getShader().setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0386gb
        /* JADX INFO: renamed from: t */
        public void mo1834t(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: s */
    void mo1833s(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: t */
    void mo1834t(@NotNull Minecraft minecraft);
}
