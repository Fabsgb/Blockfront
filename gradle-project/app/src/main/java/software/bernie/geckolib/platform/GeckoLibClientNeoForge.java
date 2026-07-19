package software.bernie.geckolib.platform;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.service.GeckoLibClient;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/platform/GeckoLibClientNeoForge.class */
public class GeckoLibClientNeoForge implements GeckoLibClient {
    @Override // software.bernie.geckolib.service.GeckoLibClient
    @NotNull
    public <T extends LivingEntity & GeoAnimatable> HumanoidModel<?> getArmorModelForItem(T animatable, ItemStack stack, EquipmentSlot slot, HumanoidModel<LivingEntity> defaultModel) {
        Item item = stack.getItem();
        HumanoidModel<?> model = IClientItemExtensions.of(item).getHumanoidArmorModel(animatable, stack, slot, defaultModel);
        if (model == defaultModel) {
            HumanoidModel<?> geoArmorRenderer = GeoRenderProvider.of(item).getGeoArmorRenderer(animatable, stack, slot, defaultModel);
            if (geoArmorRenderer instanceof GeoArmorRenderer) {
                GeoArmorRenderer<?> geoArmorRenderer2 = (GeoArmorRenderer) geoArmorRenderer;
                return geoArmorRenderer2;
            }
        }
        return model;
    }

    @Override // software.bernie.geckolib.service.GeckoLibClient
    @Nullable
    public GeoModel<?> getGeoModelForItem(ItemStack item) {
        GeoRenderer<?> customRenderer = IClientItemExtensions.of(item).getCustomRenderer();
        if (customRenderer instanceof GeoRenderer) {
            GeoRenderer<?> geoRenderer = customRenderer;
            return geoRenderer.getGeoModel();
        }
        GeoRenderer<?> geoItemRenderer = GeoRenderProvider.of(item).getGeoItemRenderer();
        if (geoItemRenderer instanceof GeoRenderer) {
            GeoRenderer<?> geoRenderer2 = geoItemRenderer;
            return geoRenderer2.getGeoModel();
        }
        return null;
    }

    @Override // software.bernie.geckolib.service.GeckoLibClient
    @Nullable
    public GeoModel<?> getGeoModelForArmor(ItemStack armour) {
        HumanoidModel humanoidArmorModel = IClientItemExtensions.of(armour).getHumanoidArmorModel((LivingEntity) null, armour, (EquipmentSlot) null, (HumanoidModel) null);
        if (humanoidArmorModel instanceof GeoArmorRenderer) {
            GeoArmorRenderer<?> armorRenderer = (GeoArmorRenderer) humanoidArmorModel;
            return armorRenderer.getGeoModel();
        }
        HumanoidModel<?> geoArmorRenderer = GeoRenderProvider.of(armour).getGeoArmorRenderer(null, armour, null, null);
        if (geoArmorRenderer instanceof GeoArmorRenderer) {
            GeoArmorRenderer<?> armorRenderer2 = (GeoArmorRenderer) geoArmorRenderer;
            return armorRenderer2.getGeoModel();
        }
        return null;
    }
}
