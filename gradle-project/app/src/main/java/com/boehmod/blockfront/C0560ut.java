package com.boehmod.blockfront;

import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.ut, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ut.class */
public final class C0560ut extends ArmorItem implements GeoItem {

    @NotNull
    private final String dp;
    private final boolean ip;

    @NotNull
    private final AnimatableInstanceCache e;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> aU;
    private boolean iq;

    public C0560ut(@NotNull String str, @NotNull Holder<ArmorMaterial> holder, @NotNull ArmorItem.Type type, @NotNull Item.Properties properties, boolean z) {
        super(holder, type, properties);
        this.e = GeckoLibUtil.createInstanceCache(this);
        this.iq = false;
        this.dp = str;
        this.ip = z;
    }

    @NotNull
    public C0560ut a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.aU = deferredHolder;
        this.iq = z;
        return this;
    }

    public boolean cC() {
        return this.iq;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> o() {
        return this.aU;
    }

    @NotNull
    public String getName() {
        return this.dp;
    }

    public boolean cD() {
        return this.ip;
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.ut.1
            private GeoArmorRenderer<?> a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T t, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> humanoidModel) {
                if (this.a == null) {
                    this.a = new GeoArmorRenderer<>(new DefaultedItemGeoModel(C0265jv.d("armor/" + itemStack.getItem().getName())));
                }
                return this.a;
            }
        });
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.e;
    }
}
