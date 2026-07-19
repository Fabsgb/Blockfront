package software.bernie.geckolib.service;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/service/GeckoLibClient.class */
public interface GeckoLibClient {
    @NotNull
    <T extends LivingEntity & GeoAnimatable> HumanoidModel<?> getArmorModelForItem(T t, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> humanoidModel);

    @Nullable
    GeoModel<?> getGeoModelForItem(ItemStack itemStack);

    @Nullable
    GeoModel<?> getGeoModelForArmor(ItemStack itemStack);
}
