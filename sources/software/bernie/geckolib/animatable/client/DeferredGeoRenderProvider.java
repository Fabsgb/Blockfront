package software.bernie.geckolib.animatable.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/client/DeferredGeoRenderProvider.class */
public interface DeferredGeoRenderProvider extends GeoRenderProvider {
    MutableObject<GeoRenderProvider> getRenderProvider();

    @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
    @Nullable
    default BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
        return ((GeoRenderProvider) getRenderProvider().getValue()).getGeoItemRenderer();
    }

    @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
    @Nullable
    default <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
        return ((GeoRenderProvider) getRenderProvider().getValue()).getGeoArmorRenderer(livingEntity, itemStack, equipmentSlot, original);
    }
}
