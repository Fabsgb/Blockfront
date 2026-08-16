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

/* JADX INFO: renamed from: com.boehmod.blockfront.gz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gz.class */
public class C0410gz<T extends Entity> extends EntityRenderer<T> {

    /* JADX INFO: renamed from: fC */
    private static final float f2657fC = 1.5f;

    /* JADX INFO: renamed from: fD */
    private static final float f2658fD = 0.5f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ItemRenderer f2659a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final ItemStack f2660c;

    public C0410gz(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer, @NotNull DeferredHolder<Item, ? extends Item> deferredHolder) {
        super(context);
        this.f2659a = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
        this.f2660c = new ItemStack((ItemLike) deferredHolder.get());
    }

    public void render(@NotNull T t, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        super.render(t, f, f2, poseStack, multiBufferSource, i);
        BakedModel model = this.f2659a.getModel(this.f2660c, t.level(), (LivingEntity) null, t.getId());
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-t.getViewYRot(f2)));
        poseStack.mulPose(Axis.XP.rotationDegrees(t.getViewXRot(f2)));
        float fMo1782E = mo1782E();
        poseStack.scale(fMo1782E, fMo1782E, fMo1782E);
        Vec3 vec3M1952f = m1952f();
        poseStack.translate(vec3M1952f.x(), vec3M1952f.y(), vec3M1952f.z());
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.5f, 0.0f);
        this.f2659a.render(this.f2660c, ItemDisplayContext.NONE, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        poseStack.popPose();
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T t) {
        return InventoryMenu.BLOCK_ATLAS;
    }

    /* JADX INFO: renamed from: E */
    public float mo1782E() {
        return 1.5f;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public Vec3 m1952f() {
        return Vec3.ZERO;
    }
}
