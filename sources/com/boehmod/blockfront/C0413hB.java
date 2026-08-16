package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.boehmod.blockfront.AbstractC1140um;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.cache.object.GeoQuad;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.hB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hB.class */
public class C0413hB<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {

    /* JADX INFO: renamed from: cU */
    @NotNull
    private static final ResourceLocation f2662cU;

    /* JADX INFO: renamed from: cV */
    @NotNull
    private static final ResourceLocation f2663cV;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Int2ObjectMap<ResourceLocation> f2664b;

    /* JADX INFO: renamed from: cJ */
    static final /* synthetic */ boolean f2665cJ;

    static {
        f2665cJ = !C0413hB.class.desiredAssertionStatus();
        f2662cU = C0532jO.m2378d("textures/stickers/debug.png");
        f2663cV = C0532jO.m2378d("textures/stickers/debug_clear.png");
        f2664b = new Int2ObjectOpenHashMap();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m1957a(@NotNull CloudItemSticker cloudItemSticker) {
        return (ResourceLocation) f2664b.computeIfAbsent(cloudItemSticker.getId(), i -> {
            return C0532jO.m2378d("textures/stickers/" + i + ".png");
        });
    }

    public C0413hB(C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    /* JADX INFO: renamed from: a */
    private static void m1958a(PoseStack poseStack, ResourceLocation resourceLocation, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, int i, int i2, int i3) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_LIGHTMAP_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f.x, vector3f.y, vector3f.z).setUv(1.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f2.x, vector3f2.y, vector3f2.z).setUv(0.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f3.x, vector3f3.y, vector3f3.z).setUv(0.0f, 1.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f4.x, vector3f4.y, vector3f4.z).setUv(1.0f, 1.0f).setUv2(i, i2).setColor(i3);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        C0129bt.m642B();
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return ((InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6858wa) == 0 || z) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1955a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (((Boolean) itemStack.getOrDefault(C1305xs.f7545Z, false)).booleanValue() || itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6858wa) == 0 || z) {
            return false;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2665cJ && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
        ResourceLocation resourceLocationM1957a = null;
        ResourceLocation resourceLocation2 = null;
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            resourceLocation2 = f2662cU;
        }
        int i4 = Integer.parseInt(geoBone.getName().replace("sticker", ""));
        Screen screen = minecraft.screen;
        if (screen instanceof C0250dy) {
            C0250dy c0250dy = (C0250dy) screen;
            if (i4 == c0250dy.f2058hA) {
                CloudItemStack cloudItemStackM1427b = c0250dy.m1427b();
                resourceLocation2 = f2662cU;
                int sticker = cloudItemStackM1427b.getSticker(i4);
                if (sticker != -1) {
                    CloudItem<?> item = cloudRegistryA.getItem(sticker);
                    if (item instanceof CloudItemSticker) {
                        resourceLocationM1957a = m1957a((CloudItemSticker) item);
                    }
                }
            }
        } else {
            Screen screen2 = minecraft.screen;
            if (screen2 instanceof C0249dx) {
                int sticker2 = ((C0249dx) screen2).m1423b().getSticker(i4);
                if (sticker2 != -1) {
                    CloudItem<?> item2 = cloudRegistryA.getItem(sticker2);
                    if (item2 instanceof CloudItemSticker) {
                        resourceLocationM1957a = m1957a((CloudItemSticker) item2);
                    }
                }
            } else {
                int iM6567c = AbstractC1140um.m6567c(itemStack, i4);
                if (iM6567c != -1) {
                    CloudItem<?> item3 = cloudRegistryA.getItem(iM6567c);
                    if (item3 instanceof CloudItemSticker) {
                        resourceLocationM1957a = m1957a((CloudItemSticker) item3);
                    }
                }
            }
        }
        if (resourceLocationM1957a != null && resourceLocation2 != null) {
            resourceLocation2 = f2663cV;
        }
        RenderSystem.enableDepthTest();
        poseStack.pushPose();
        GeoQuad geoQuad = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0];
        Vector3f vector3fPosition = geoQuad.vertices()[0].position();
        Vector3f vector3fPosition2 = geoQuad.vertices()[1].position();
        Vector3f vector3fPosition3 = geoQuad.vertices()[2].position();
        Vector3f vector3fPosition4 = geoQuad.vertices()[3].position();
        Vector3f vector3fM7165a = C1270xJ.m7165a(vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4);
        poseStack.translate(vector3fM7165a.x, vector3fM7165a.y, vector3fM7165a.z);
        RenderUtil.rotateMatrixAroundBone(poseStack, geoBone);
        poseStack.translate(-vector3fM7165a.x, -vector3fM7165a.y, -vector3fM7165a.z);
        if (resourceLocation2 != null) {
            m1958a(poseStack, resourceLocation2, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        if (resourceLocationM1957a != null) {
            m1958a(poseStack, resourceLocationM1957a, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        RenderSystem.disableDepthTest();
        poseStack.popPose();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1956a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1188vh c1188vh, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0394gj c0394gj) {
        return false;
    }
}
