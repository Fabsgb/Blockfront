package software.bernie.geckolib.animatable.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/client/GeoRenderProvider.class */
public interface GeoRenderProvider {
    public static final GeoRenderProvider DEFAULT = new GeoRenderProvider() { // from class: software.bernie.geckolib.animatable.client.GeoRenderProvider.1
    };

    /* JADX INFO: renamed from: of */
    static GeoRenderProvider m8357of(ItemStack itemStack) {
        return m8358of(itemStack.getItem());
    }

    /* JADX INFO: renamed from: of */
    static GeoRenderProvider m8358of(Item item) {
        if (item instanceof GeoItem) {
            GeoItem geoItem = (GeoItem) item;
            return (GeoRenderProvider) geoItem.getRenderProvider();
        }
        return DEFAULT;
    }

    @Nullable
    default BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
        return null;
    }

    @Nullable
    default <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
        return null;
    }
}
