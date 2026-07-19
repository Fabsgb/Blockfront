package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gj.class */
public class C0173gj<T extends Entity> extends EntityRenderer<T> {
    private static final float fs = 1.5f;
    private static final float ft = 0.5f;

    @NotNull
    private final ItemRenderer a;

    @NotNull
    private final ItemStack c;

    public C0173gj(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer, @NotNull DeferredHolder<Item, ? extends Item> deferredHolder) {
        super(context);
        this.a = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
        this.c = new ItemStack((ItemLike) deferredHolder.get());
    }

    public void render(@NotNull T t, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        super.render(t, f, f2, poseStack, multiBufferSource, i);
        BakedModel model = this.a.getModel(this.c, t.level(), (LivingEntity) null, t.getId());
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-t.getViewYRot(f2)));
        poseStack.mulPose(Axis.XP.rotationDegrees(t.getViewXRot(f2)));
        float fE = E();
        poseStack.scale(fE, fE, fE);
        Vec3 vec3F = f();
        poseStack.translate(vec3F.x(), vec3F.y(), vec3F.z());
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.5f, 0.0f);
        this.a.render(this.c, ItemDisplayContext.NONE, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        poseStack.popPose();
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T t) {
        return InventoryMenu.BLOCK_ATLAS;
    }

    public float E() {
        return 1.5f;
    }

    @NotNull
    public Vec3 f() {
        return Vec3.ZERO;
    }
}
