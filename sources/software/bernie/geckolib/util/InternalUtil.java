package software.bernie.geckolib.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.function.BiConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/util/InternalUtil.class */
@ApiStatus.Internal
public class InternalUtil {
    public static <T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> boolean tryRenderGeoArmorPiece(PoseStack poseStack, MultiBufferSource bufferSource, T entity, ItemStack stack, EquipmentSlot equipmentSlot, M parentModel, A baseModel, float partialTick, int packedLight, float limbSwing, float limbSwingAmount, float lerpedTickCount, float netHeadYaw, float headPitch, BiConsumer<A, EquipmentSlot> partVisibilitySetter) {
        HumanoidModel<?> geckolibModel;
        Equipable item = stack.getItem();
        if (!(item instanceof Equipable)) {
            return false;
        }
        Equipable equipable = item;
        if (equipable.getEquipmentSlot() != equipmentSlot || (geckolibModel = GeoRenderProvider.m8007of((Item) item).getGeoArmorRenderer(entity, stack, equipmentSlot, baseModel)) == null) {
            return false;
        }
        parentModel.copyPropertiesTo(baseModel);
        partVisibilitySetter.accept(baseModel, equipmentSlot);
        if (geckolibModel instanceof GeoArmorRenderer) {
            GeoArmorRenderer<?> geoArmorRenderer = (GeoArmorRenderer) geckolibModel;
            geoArmorRenderer.prepForRender(entity, stack, equipmentSlot, baseModel, bufferSource, partialTick, limbSwing, limbSwingAmount, netHeadYaw, headPitch);
        }
        baseModel.copyPropertiesTo(geckolibModel);
        geckolibModel.renderToBuffer(poseStack, (VertexConsumer) null, packedLight, OverlayTexture.NO_OVERLAY, Color.WHITE.argbInt());
        return true;
    }
}
