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

/* JADX INFO: renamed from: com.boehmod.blockfront.uR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uR.class */
public final class C1119uR extends ArmorItem implements GeoItem {

    /* JADX INFO: renamed from: dA */
    @NotNull
    private final String f6136dA;

    /* JADX INFO: renamed from: iJ */
    private final boolean f6137iJ;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AnimatableInstanceCache f6138e;

    /* JADX INFO: renamed from: aU */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6139aU;

    /* JADX INFO: renamed from: iK */
    private boolean f6140iK;

    public C1119uR(@NotNull String str, @NotNull Holder<ArmorMaterial> holder, @NotNull ArmorItem.Type type, @NotNull Item.Properties properties, boolean z) {
        super(holder, type, properties);
        this.f6138e = GeckoLibUtil.createInstanceCache(this);
        this.f6140iK = false;
        this.f6136dA = str;
        this.f6137iJ = z;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1119uR m6404a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.f6139aU = deferredHolder;
        this.f6140iK = z;
        return this;
    }

    /* JADX INFO: renamed from: cL */
    public boolean m6405cL() {
        return this.f6140iK;
    }

    @Nullable
    /* JADX INFO: renamed from: o */
    public DeferredHolder<SoundEvent, SoundEvent> m6406o() {
        return this.f6139aU;
    }

    @NotNull
    public String getName() {
        return this.f6136dA;
    }

    /* JADX INFO: renamed from: cM */
    public boolean m6407cM() {
        return this.f6137iJ;
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.uR.1

            /* JADX INFO: renamed from: a */
            private GeoArmorRenderer<?> f6141a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T t, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> humanoidModel) {
                if (this.f6141a == null) {
                    this.f6141a = new GeoArmorRenderer<>(new DefaultedItemGeoModel(C0532jO.m2378d("armor/" + itemStack.getItem().getName())));
                }
                return this.f6141a;
            }
        });
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f6138e;
    }
}
