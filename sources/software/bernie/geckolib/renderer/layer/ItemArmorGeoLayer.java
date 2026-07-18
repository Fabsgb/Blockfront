package software.bernie.geckolib.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.SkullBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.util.Color;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/layer/ItemArmorGeoLayer.class */
public class ItemArmorGeoLayer<T extends LivingEntity & GeoAnimatable> extends GeoRenderLayer<T> {
    protected static final HumanoidModel<LivingEntity> INNER_ARMOR_MODEL = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
    protected static final HumanoidModel<LivingEntity> OUTER_ARMOR_MODEL = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

    @Nullable
    protected ItemStack mainHandStack;

    @Nullable
    protected ItemStack offhandStack;

    @Nullable
    protected ItemStack helmetStack;

    @Nullable
    protected ItemStack chestplateStack;

    @Nullable
    protected ItemStack leggingsStack;

    @Nullable
    protected ItemStack bootsStack;

    public ItemArmorGeoLayer(GeoRenderer<T> geoRenderer) {
        super(geoRenderer);
    }

    @NotNull
    protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, T animatable) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && stack == animatable.getItemBySlot(slot)) {
                return slot;
            }
        }
        return EquipmentSlot.CHEST;
    }

    @NotNull
    protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, T animatable, HumanoidModel<?> baseModel) {
        return baseModel.body;
    }

    @Nullable
    protected ItemStack getArmorItemForBone(GeoBone bone, T animatable) {
        return null;
    }

    @Override // software.bernie.geckolib.renderer.layer.GeoRenderLayer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        this.mainHandStack = animatable.getItemBySlot(EquipmentSlot.MAINHAND);
        this.offhandStack = animatable.getItemBySlot(EquipmentSlot.OFFHAND);
        this.helmetStack = animatable.getItemBySlot(EquipmentSlot.HEAD);
        this.chestplateStack = animatable.getItemBySlot(EquipmentSlot.CHEST);
        this.leggingsStack = animatable.getItemBySlot(EquipmentSlot.LEGS);
        this.bootsStack = animatable.getItemBySlot(EquipmentSlot.FEET);
    }

    @Override // software.bernie.geckolib.renderer.layer.GeoRenderLayer
    public void renderForBone(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ItemStack armorStack = getArmorItemForBone(bone, animatable);
        if (armorStack == null) {
            return;
        }
        BlockItem item = armorStack.getItem();
        if (item instanceof BlockItem) {
            BlockItem blockItem = item;
            AbstractSkullBlock block = blockItem.getBlock();
            if (block instanceof AbstractSkullBlock) {
                AbstractSkullBlock skullBlock = block;
                renderSkullAsArmor(poseStack, bone, armorStack, skullBlock, bufferSource, packedLight);
                return;
            }
        }
        EquipmentSlot slot = getEquipmentSlotForBone(bone, armorStack, animatable);
        HumanoidModel<?> model = getModelForItem(bone, slot, armorStack, animatable);
        ModelPart modelPart = getModelPartForBone(bone, slot, armorStack, animatable, model);
        if (!modelPart.cubes.isEmpty()) {
            poseStack.pushPose();
            poseStack.scale(-1.0f, -1.0f, 1.0f);
            if (model instanceof GeoArmorRenderer) {
                GeoArmorRenderer<?> geoArmorRenderer = (GeoArmorRenderer) model;
                prepModelPartForRender(poseStack, bone, modelPart);
                geoArmorRenderer.prepForRender(animatable, armorStack, slot, model);
                geoArmorRenderer.applyBoneVisibilityByPart(slot, modelPart, model);
                geoArmorRenderer.renderToBuffer(poseStack, null, packedLight, packedOverlay, Color.WHITE.argbInt());
            } else if (armorStack.getItem() instanceof ArmorItem) {
                prepModelPartForRender(poseStack, bone, modelPart);
                renderVanillaArmorPiece(poseStack, animatable, bone, slot, armorStack, modelPart, bufferSource, partialTick, packedLight, packedOverlay);
            }
            poseStack.popPose();
        }
    }

    protected <I extends Item & GeoItem> void renderVanillaArmorPiece(PoseStack poseStack, T animatable, GeoBone bone, EquipmentSlot slot, ItemStack armorStack, ModelPart modelPart, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
        Holder<ArmorMaterial> material = armorStack.getItem().getMaterial();
        for (ArmorMaterial.Layer layer : ((ArmorMaterial) material.value()).layers()) {
            int color = armorStack.is(ItemTags.DYEABLE) ? DyedItemColor.getOrDefault(armorStack, -6265536) : -1;
            VertexConsumer buffer = getVanillaArmorBuffer(bufferSource, animatable, armorStack, slot, bone, layer, packedLight, packedOverlay, false);
            modelPart.render(poseStack, buffer, packedLight, packedOverlay, color);
        }
        ArmorTrim trim = (ArmorTrim) armorStack.get(DataComponents.TRIM);
        if (trim != null) {
            TextureAtlasSprite sprite = Minecraft.getInstance().getModelManager().getAtlas(Sheets.ARMOR_TRIMS_SHEET).getSprite(slot == EquipmentSlot.LEGS ? trim.innerTexture(material) : trim.outerTexture(material));
            VertexConsumer buffer2 = sprite.wrap(bufferSource.getBuffer(Sheets.armorTrimsSheet(((TrimPattern) trim.pattern().value()).decal())));
            modelPart.render(poseStack, buffer2, packedLight, packedOverlay);
        }
        if (armorStack.hasFoil()) {
            modelPart.render(poseStack, getVanillaArmorBuffer(bufferSource, animatable, armorStack, slot, bone, null, packedLight, packedOverlay, true), packedLight, packedOverlay, Color.WHITE.argbInt());
        }
    }

    protected VertexConsumer getVanillaArmorBuffer(MultiBufferSource bufferSource, T animatable, ItemStack stack, EquipmentSlot slot, GeoBone bone, @Nullable ArmorMaterial.Layer layer, int packedLight, int packedOverlay, boolean forGlint) {
        if (forGlint) {
            return bufferSource.getBuffer(RenderType.armorEntityGlint());
        }
        return bufferSource.getBuffer(RenderType.armorCutoutNoCull(layer.texture(slot == EquipmentSlot.LEGS)));
    }

    @NotNull
    protected HumanoidModel<?> getModelForItem(GeoBone bone, EquipmentSlot slot, ItemStack stack, T animatable) {
        HumanoidModel<LivingEntity> defaultModel = slot == EquipmentSlot.LEGS ? INNER_ARMOR_MODEL : OUTER_ARMOR_MODEL;
        return GeckoLibServices.Client.ITEM_RENDERING.getArmorModelForItem(animatable, stack, slot, defaultModel);
    }

    protected void renderSkullAsArmor(PoseStack poseStack, GeoBone bone, ItemStack stack, AbstractSkullBlock skullBlock, MultiBufferSource bufferSource, int packedLight) {
        SkullBlock.Type type = skullBlock.getType();
        SkullModelBase model = (SkullModelBase) SkullBlockRenderer.createSkullRenderers(Minecraft.getInstance().getEntityModels()).get(type);
        RenderType renderType = SkullBlockRenderer.getRenderType(type, (ResolvableProfile) stack.get(DataComponents.PROFILE));
        poseStack.pushPose();
        RenderUtil.translateAndRotateMatrixForBone(poseStack, bone);
        poseStack.scale(1.1875f, 1.1875f, 1.1875f);
        poseStack.translate(-0.5f, 0.0f, -0.5f);
        SkullBlockRenderer.renderSkull((Direction) null, 0.0f, 0.0f, poseStack, bufferSource, packedLight, model, renderType);
        poseStack.popPose();
    }

    protected void prepModelPartForRender(PoseStack poseStack, GeoBone bone, ModelPart sourcePart) {
        GeoCube firstCube = (GeoCube) bone.getCubes().getFirst();
        ModelPart.Cube armorCube = getReferenceCubeForModel(bone, sourcePart);
        double armorBoneSizeX = firstCube.size().x();
        double armorBoneSizeY = firstCube.size().y();
        double armorBoneSizeZ = firstCube.size().z();
        double actualArmorSizeX = Math.abs(armorCube.maxX - armorCube.minX);
        double actualArmorSizeY = Math.abs(armorCube.maxY - armorCube.minY);
        double actualArmorSizeZ = Math.abs(armorCube.maxZ - armorCube.minZ);
        float scaleX = (float) (armorBoneSizeX / actualArmorSizeX);
        float scaleY = (float) (armorBoneSizeY / actualArmorSizeY);
        float scaleZ = (float) (armorBoneSizeZ / actualArmorSizeZ);
        sourcePart.setPos(-(bone.getPivotX() - (((bone.getPivotX() * scaleX) - bone.getPivotX()) / scaleX)), -(bone.getPivotY() - (((bone.getPivotY() * scaleY) - bone.getPivotY()) / scaleY)), bone.getPivotZ() - (((bone.getPivotZ() * scaleZ) - bone.getPivotZ()) / scaleZ));
        sourcePart.xRot = -bone.getRotX();
        sourcePart.yRot = -bone.getRotY();
        sourcePart.zRot = bone.getRotZ();
        poseStack.scale(scaleX, scaleY, scaleZ);
    }

    protected ModelPart.Cube getReferenceCubeForModel(GeoBone bone, ModelPart sourcePart) {
        return (ModelPart.Cube) sourcePart.cubes.getFirst();
    }
}
