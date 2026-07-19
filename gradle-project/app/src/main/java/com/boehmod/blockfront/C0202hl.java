package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.boehmod.blockfront.tO;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hl.class */
public class C0202hl<T extends tO<T>> extends AbstractC0201hk<T> {

    @NotNull
    private static final ResourceLocation cU;

    @NotNull
    private static final ResourceLocation cV;

    @NotNull
    private static final Int2ObjectMap<ResourceLocation> a;
    static final /* synthetic */ boolean cA;

    static {
        cA = !C0202hl.class.desiredAssertionStatus();
        cU = C0265jv.d("textures/stickers/debug.png");
        cV = C0265jv.d("textures/stickers/debug_clear.png");
        a = new Int2ObjectOpenHashMap();
    }

    @NotNull
    private static ResourceLocation a(@NotNull CloudItemSticker cloudItemSticker) {
        return (ResourceLocation) a.computeIfAbsent(cloudItemSticker.getId(), i -> {
            return C0265jv.d("textures/stickers/" + i + ".png");
        });
    }

    public C0202hl(gW<T> gWVar) {
        super(gWVar);
    }

    private static void a(PoseStack poseStack, ResourceLocation resourceLocation, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, int i, int i2, int i3) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_LIGHTMAP_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f.x, vector3f.y, vector3f.z).setUv(1.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f2.x, vector3f2.y, vector3f2.z).setUv(0.0f, 0.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f3.x, vector3f3.y, vector3f3.z).setUv(0.0f, 1.0f).setUv2(i, i2).setColor(i3);
        bufferBuilderBegin.addVertex(matrix4fPose, vector3f4.x, vector3f4.y, vector3f4.z).setUv(1.0f, 1.0f).setUv2(i, i2).setColor(i3);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        C0040bk.y();
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return ((InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.tW) == 0 || z) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (((Boolean) itemStack.getOrDefault(wV.X, false)).booleanValue() || itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.tW) == 0 || z) {
            return false;
        }
        C0297l c0297lB = C0297l.b();
        if (!cA && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0297lB.a();
        ResourceLocation resourceLocationA = null;
        ResourceLocation resourceLocation2 = null;
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            resourceLocation2 = cU;
        }
        int i4 = Integer.parseInt(geoBone.getName().replace("sticker", ""));
        Screen screen = minecraft.screen;
        if (screen instanceof C0098dp) {
            C0098dp c0098dp = (C0098dp) screen;
            if (i4 == c0098dp.gv) {
                CloudItemStack cloudItemStackB = c0098dp.b();
                resourceLocation2 = cU;
                int sticker = cloudItemStackB.getSticker(i4);
                if (sticker != -1) {
                    CloudItem<?> item = cloudRegistryA.getItem(sticker);
                    if (item instanceof CloudItemSticker) {
                        resourceLocationA = a((CloudItemSticker) item);
                    }
                }
            }
        } else {
            Screen screen2 = minecraft.screen;
            if (screen2 instanceof Cdo) {
                int sticker2 = ((Cdo) screen2).b().getSticker(i4);
                if (sticker2 != -1) {
                    CloudItem<?> item2 = cloudRegistryA.getItem(sticker2);
                    if (item2 instanceof CloudItemSticker) {
                        resourceLocationA = a((CloudItemSticker) item2);
                    }
                }
            } else {
                int iB = tO.b(itemStack, i4);
                if (iB != -1) {
                    CloudItem<?> item3 = cloudRegistryA.getItem(iB);
                    if (item3 instanceof CloudItemSticker) {
                        resourceLocationA = a((CloudItemSticker) item3);
                    }
                }
            }
        }
        if (resourceLocationA != null && resourceLocation2 != null) {
            resourceLocation2 = cV;
        }
        RenderSystem.enableDepthTest();
        poseStack.pushPose();
        GeoQuad geoQuad = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0];
        Vector3f vector3fPosition = geoQuad.vertices()[0].position();
        Vector3f vector3fPosition2 = geoQuad.vertices()[1].position();
        Vector3f vector3fPosition3 = geoQuad.vertices()[2].position();
        Vector3f vector3fPosition4 = geoQuad.vertices()[3].position();
        Vector3f vector3fA = C0634xm.a(vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4);
        poseStack.translate(vector3fA.x, vector3fA.y, vector3fA.z);
        RenderUtil.rotateMatrixAroundBone(poseStack, geoBone);
        poseStack.translate(-vector3fA.x, -vector3fA.y, -vector3fA.z);
        if (resourceLocation2 != null) {
            a(poseStack, resourceLocation2, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        if (resourceLocationA != null) {
            a(poseStack, resourceLocationA, vector3fPosition, vector3fPosition2, vector3fPosition3, vector3fPosition4, i, i2, i3);
        }
        RenderSystem.disableDepthTest();
        poseStack.popPose();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable uH uHVar, @NotNull ItemDisplayContext itemDisplayContext, @NotNull fT fTVar) {
        return false;
    }
}
