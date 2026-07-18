package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.boehmod.blockfront.AbstractC1062tO;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hl.class */
public class C0448hl<T extends AbstractC1062tO<T>> extends AbstractC0447hk<T> {

    /* JADX INFO: renamed from: cU */
    @NotNull
    private static final ResourceLocation f2833cU;

    /* JADX INFO: renamed from: cV */
    @NotNull
    private static final ResourceLocation f2834cV;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Int2ObjectMap<ResourceLocation> f2835a;

    /* JADX INFO: renamed from: cA */
    static final /* synthetic */ boolean f2836cA;

    static {
        f2836cA = !C0448hl.class.desiredAssertionStatus();
        f2833cU = C0564jv.m2555d("textures/stickers/debug.png");
        f2834cV = C0564jv.m2555d("textures/stickers/debug_clear.png");
        f2835a = new Int2ObjectOpenHashMap();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2055a(@NotNull CloudItemSticker cloudItemSticker) {
        return (ResourceLocation) f2835a.computeIfAbsent(cloudItemSticker.getId(), i -> {
            return C0564jv.m2555d("textures/stickers/" + i + ".png");
        });
    }

    public C0448hl(C0380gW<T> c0380gW) {
        super(c0380gW);
    }

    /* JADX INFO: renamed from: a */
    private static void m2056a(PoseStack poseStack, ResourceLocation resourceLocation, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, int i, int i2, int i3) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_LIGHTMAP_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f.x, vector3f.y, vector3f.z).setUv(1.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f2.x, vector3f2.y, vector3f2.z).setUv(0.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f3.x, vector3f3.y, vector3f3.z).setUv(0.0f, 1.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f4.x, vector3f4.y, vector3f4.z).setUv(1.0f, 1.0f).setUv2(i, i2).setColor(i3);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        C0119bk.m539y();
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public void mo1838a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1839a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return ((InterfaceC1294xq.m7919a(geoBone) & InterfaceC1294xq.f8661tW) == 0 || z) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1840a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (((Boolean) itemStack.getOrDefault(C1228wV.f6980X, false)).booleanValue() || itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC1294xq.m7919a(geoBone) & InterfaceC1294xq.f8661tW) == 0 || z) {
            return false;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2836cA && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
        ResourceLocation resourceLocationM2055a = null;
        ResourceLocation resourceLocation2 = null;
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            resourceLocation2 = f2833cU;
        }
        int i4 = Integer.parseInt(geoBone.getName().replace("sticker", ""));
        Screen screen = minecraft.screen;
        if (screen instanceof C0240dp) {
            C0240dp c0240dp = (C0240dp) screen;
            if (i4 == c0240dp.f1994gv) {
                CloudItemStack cloudItemStackM1398b = c0240dp.m1398b();
                resourceLocation2 = f2833cU;
                int sticker = cloudItemStackM1398b.getSticker(i4);
                if (sticker != -1) {
                    CloudItem<?> item = cloudRegistryA.getItem(sticker);
                    if (item instanceof CloudItemSticker) {
                        resourceLocationM2055a = m2055a((CloudItemSticker) item);
                    }
                }
            }
        } else {
            Screen screen2 = minecraft.screen;
            if (screen2 instanceof C0239do) {
                int sticker2 = ((C0239do) screen2).m1394b().getSticker(i4);
                if (sticker2 != -1) {
                    CloudItem<?> item2 = cloudRegistryA.getItem(sticker2);
                    if (item2 instanceof CloudItemSticker) {
                        resourceLocationM2055a = m2055a((CloudItemSticker) item2);
                    }
                }
            } else {
                int iM5933b = AbstractC1062tO.m5933b(itemStack, i4);
                if (iM5933b != -1) {
                    CloudItem<?> item3 = cloudRegistryA.getItem(iM5933b);
                    if (item3 instanceof CloudItemSticker) {
                        resourceLocationM2055a = m2055a((CloudItemSticker) item3);
                    }
                }
            }
        }
        if (resourceLocationM2055a != null && resourceLocation2 != null) {
            resourceLocation2 = f2834cV;
        }
        RenderSystem.enableDepthTest();
        poseStack.pushPose();
        GeoQuad geoQuad = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0];
        Vector3f vector3fPosition = geoQuad.vertices()[0].position();
        Vector3f vector3fPosition2 = geoQuad.vertices()[1].position();
        Vector3f vector3fPosition3 = geoQuad.vertices()[2].position();
        Vector3f vector3fPosition4 = geoQuad.vertices()[3].position();
        Vector3f vector3fM7839a = C1290xm.m7839a(vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4);
        poseStack.translate(vector3fM7839a.x, vector3fM7839a.y, vector3fM7839a.z);
        RenderUtil.rotateMatrixAroundBone(poseStack, geoBone);
        poseStack.translate(-vector3fM7839a.x, -vector3fM7839a.y, -vector3fM7839a.z);
        if (resourceLocation2 != null) {
            m2056a(poseStack, resourceLocation2, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        if (resourceLocationM2055a != null) {
            m2056a(poseStack, resourceLocationM2055a, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        RenderSystem.disableDepthTest();
        poseStack.popPose();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1841a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1108uH c1108uH, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0324fT c0324fT) {
        return false;
    }
}
