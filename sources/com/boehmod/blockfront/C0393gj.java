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

/* JADX INFO: renamed from: com.boehmod.blockfront.gj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gj.class */
public class C0393gj<T extends Entity> extends EntityRenderer<T> {

    /* JADX INFO: renamed from: fs */
    private static final float f2598fs = 1.5f;

    /* JADX INFO: renamed from: ft */
    private static final float f2599ft = 0.5f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ItemRenderer f2600a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final ItemStack f2601c;

    public C0393gj(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer, @NotNull DeferredHolder<Item, ? extends Item> deferredHolder) {
        super(context);
        this.f2600a = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
        this.f2601c = new ItemStack((ItemLike) deferredHolder.get());
    }

    public void render(@NotNull T t, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        super.render(t, f, f2, poseStack, multiBufferSource, i);
        BakedModel model = this.f2600a.getModel(this.f2601c, t.level(), (LivingEntity) null, t.getId());
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-t.getViewYRot(f2)));
        poseStack.mulPose(Axis.XP.rotationDegrees(t.getViewXRot(f2)));
        float fMo1887E = mo1887E();
        poseStack.scale(fMo1887E, fMo1887E, fMo1887E);
        Vec3 vec3M1888f = m1888f();
        poseStack.translate(vec3M1888f.x(), vec3M1888f.y(), vec3M1888f.z());
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.5f, 0.0f);
        this.f2600a.render(this.f2601c, ItemDisplayContext.NONE, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        poseStack.popPose();
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T t) {
        return InventoryMenu.BLOCK_ATLAS;
    }

    /* JADX INFO: renamed from: E */
    public float mo1887E() {
        return 1.5f;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public Vec3 m1888f() {
        return Vec3.ZERO;
    }
}
