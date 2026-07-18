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

/* JADX INFO: renamed from: com.boehmod.blockfront.ut */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ut.class */
public final class C1146ut extends ArmorItem implements GeoItem {

    /* JADX INFO: renamed from: dp */
    @NotNull
    private final String f6070dp;

    /* JADX INFO: renamed from: ip */
    private final boolean f6071ip;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AnimatableInstanceCache f6072e;

    /* JADX INFO: renamed from: aU */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6073aU;

    /* JADX INFO: renamed from: iq */
    private boolean f6074iq;

    public C1146ut(@NotNull String str, @NotNull Holder<ArmorMaterial> holder, @NotNull ArmorItem.Type type, @NotNull Item.Properties properties, boolean z) {
        super(holder, type, properties);
        this.f6072e = GeckoLibUtil.createInstanceCache(this);
        this.f6074iq = false;
        this.f6070dp = str;
        this.f6071ip = z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1146ut m6426a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.f6073aU = deferredHolder;
        this.f6074iq = z;
        return this;
    }

    /* JADX INFO: renamed from: cC */
    public boolean m6427cC() {
        return this.f6074iq;
    }

    @Nullable
    /* JADX INFO: renamed from: o */
    public DeferredHolder<SoundEvent, SoundEvent> m6428o() {
        return this.f6073aU;
    }

    @NotNull
    public String getName() {
        return this.f6070dp;
    }

    /* JADX INFO: renamed from: cD */
    public boolean m6429cD() {
        return this.f6071ip;
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.ut.1

            /* JADX INFO: renamed from: a */
            private GeoArmorRenderer<?> f6075a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T t, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> humanoidModel) {
                if (this.f6075a == null) {
                    this.f6075a = new GeoArmorRenderer<>(new DefaultedItemGeoModel(C0564jv.m2555d("armor/" + itemStack.getItem().getName())));
                }
                return this.f6075a;
            }
        });
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f6072e;
    }
}
