package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL.class */
public interface InterfaceC0316fL {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC0316fL f2335a = new InterfaceC0316fL() { // from class: com.boehmod.blockfront.fL.1
        AnonymousClass1() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.disableBlend();
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: b */
    public static final InterfaceC0316fL f2336b = new InterfaceC0316fL() { // from class: com.boehmod.blockfront.fL.2
        AnonymousClass2() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: c */
    public static final InterfaceC0316fL f2337c = new InterfaceC0316fL() { // from class: com.boehmod.blockfront.fL.3
        AnonymousClass3() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 1);
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: d */
    public static final InterfaceC0316fL f2338d = new InterfaceC0316fL() { // from class: com.boehmod.blockfront.fL.4
        AnonymousClass4() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0321fQ::m1637a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: e */
    public static final InterfaceC0316fL f2339e = new InterfaceC0316fL() { // from class: com.boehmod.blockfront.fL.5
        AnonymousClass5() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.setShader(C0323fS::m1643c);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.getShader().setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    };

    /* JADX INFO: renamed from: r */
    void mo1623r(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: s */
    void mo1624s(@NotNull Minecraft minecraft);

    /* JADX INFO: renamed from: com.boehmod.blockfront.fL$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL$1.class */
    class AnonymousClass1 implements InterfaceC0316fL {
        AnonymousClass1() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.disableBlend();
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.enableCull();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fL$2 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL$2.class */
    class AnonymousClass2 implements InterfaceC0316fL {
        AnonymousClass2() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fL$3 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL$3.class */
    class AnonymousClass3 implements InterfaceC0316fL {
        AnonymousClass3() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 1);
            RenderSystem.setShader(C0317fM::m1625a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fL$4 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL$4.class */
    class AnonymousClass4 implements InterfaceC0316fL {
        AnonymousClass4() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(770, 771, 1, 771);
            RenderSystem.setShader(C0321fQ::m1637a);
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fL$5 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fL$5.class */
    class AnonymousClass5 implements InterfaceC0316fL {
        AnonymousClass5() {
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: r */
        public void mo1623r(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.setShader(C0323fS::m1643c);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.getShader().setSampler("DiffuseDepthSampler", Integer.valueOf(minecraft.getMainRenderTarget().getDepthTextureId()));
            RenderSystem.disableCull();
        }

        @Override // com.boehmod.blockfront.InterfaceC0316fL
        /* JADX INFO: renamed from: s */
        public void mo1624s(@NotNull Minecraft minecraft) {
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
        }
    }
}
