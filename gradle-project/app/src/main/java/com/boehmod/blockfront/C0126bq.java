package com.boehmod.blockfront;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexSorting;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

/* JADX INFO: renamed from: com.boehmod.blockfront.bq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bq.class */
public final class C0126bq {

    /* JADX INFO: renamed from: ci */
    private static final int f834ci = 512;

    /* JADX INFO: renamed from: cj */
    private static final int f835cj = 64;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final List<Supplier<? extends DataComponentType<?>>> f836n = List.of(C1305xs.f7522C, C1305xs.f7519z, C1305xs.f7520A, C1305xs.f7521B, C1305xs.f7525F, C1305xs.f7526G, C1305xs.f7535P, C1305xs.f7524E);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Int2ObjectOpenHashMap<TextureTarget> f837a = new Int2ObjectOpenHashMap<>();

    private C0126bq() {
    }

    /* JADX INFO: renamed from: a */
    public static void m441a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f, float f2, float f3) {
        if (itemStack.isEmpty()) {
            return;
        }
        ItemStack itemStackM444a = m444a(itemStack);
        int iM443a = m443a(f3);
        int iM442b = m442b(itemStackM444a, iM443a);
        TextureTarget textureTargetM446a = (TextureTarget) f837a.get(iM442b);
        if (textureTargetM446a == null) {
            if (f837a.size() >= 64) {
                m447e();
            }
            guiGraphics.flush();
            textureTargetM446a = m446a(itemStackM444a, iM443a);
            f837a.put(iM442b, textureTargetM446a);
        }
        float f4 = 8.0f * f3;
        float f5 = f - f4;
        float f6 = f2 - f4;
        float f7 = f + f4;
        float f8 = f2 + f4;
        Matrix4f matrix4fPose = poseStack.last().pose();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, textureTargetM446a.getColorTextureId());
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, f5, f6, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f5, f8, 0.0f).setUv(0.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f8, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f7, f6, 0.0f).setUv(1.0f, 1.0f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: b */
    private static int m442b(@NotNull ItemStack itemStack, int i) {
        return (31 * ((31 * ItemStack.hashItemAndComponents(itemStack)) + (C0495ie.f3037q.m2230U() ? 1 : 0))) + i;
    }

    /* JADX INFO: renamed from: a */
    private static int m443a(float f) {
        return Mth.clamp(Mth.smallestEncompassingPowerOfTwo(Mth.ceil(16.0f * f * ((float) Minecraft.getInstance().getWindow().getGuiScale()))), 32, 512);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ItemStack m444a(@NotNull ItemStack itemStack) {
        ItemStack itemStack2 = new ItemStack(itemStack.getItem());
        Iterator<Supplier<? extends DataComponentType<?>>> it = f836n.iterator();
        while (it.hasNext()) {
            m445a(itemStack, itemStack2, it.next().get());
        }
        if (((Boolean) itemStack.getOrDefault(C1305xs.f7541V, false)).booleanValue()) {
            m445a(itemStack, itemStack2, C1305xs.f7541V.get());
            m445a(itemStack, itemStack2, C1305xs.f7544Y.get());
            m445a(itemStack, itemStack2, C1305xs.f7540U.get());
            m445a(itemStack, itemStack2, C1305xs.f7542W.get());
            m445a(itemStack, itemStack2, C1305xs.f7543X.get());
        }
        return itemStack2;
    }

    /* JADX INFO: renamed from: a */
    private static <T> void m445a(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, @NotNull DataComponentType<T> dataComponentType) {
        Object obj = itemStack.get(dataComponentType);
        if (obj != null) {
            itemStack2.set(dataComponentType, obj);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static TextureTarget m446a(@NotNull ItemStack itemStack, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderTarget mainRenderTarget = minecraft.getMainRenderTarget();
        TextureTarget textureTarget = new TextureTarget(i, i, true, Minecraft.ON_OSX);
        textureTarget.setClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        textureTarget.clear(Minecraft.ON_OSX);
        textureTarget.setFilterMode(9729);
        textureTarget.bindWrite(true);
        Matrix4f matrix4f = new Matrix4f(RenderSystem.getProjectionMatrix());
        VertexSorting vertexSorting = RenderSystem.getVertexSorting();
        RenderSystem.setProjectionMatrix(new Matrix4f().setOrtho(0.0f, 16.0f, 16.0f, 0.0f, 1000.0f, 21000.0f), VertexSorting.ORTHOGRAPHIC_Z);
        Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.pushMatrix();
        modelViewStack.identity();
        modelViewStack.translate(0.0f, 0.0f, -11000.0f);
        RenderSystem.applyModelViewMatrix();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        C0129bt.m601b(guiGraphics.pose(), guiGraphics, itemStack, 8.0f, 8.0f, 1.0f);
        guiGraphics.flush();
        modelViewStack.popMatrix();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.setProjectionMatrix(matrix4f, vertexSorting);
        mainRenderTarget.bindWrite(true);
        return textureTarget;
    }

    /* JADX INFO: renamed from: e */
    public static void m447e() {
        f837a.values().forEach((v0) -> {
            v0.destroyBuffers();
        });
        f837a.clear();
    }
}
