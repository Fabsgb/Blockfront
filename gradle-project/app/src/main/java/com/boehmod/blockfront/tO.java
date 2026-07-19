package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.blockfront.tO;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.SoundKeyframeEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tO.class */
public abstract class tO<T extends tO<T>> extends tK implements GeoItem {
    public static final int rJ = 1200;
    public static final int rK = 16;
    private float my;
    public float mz;
    public float mA;

    @NotNull
    private final String dg;

    @NotNull
    private final ResourceLocation gd;

    @NotNull
    private final ResourceLocation ge;

    @NotNull
    private final ResourceLocation gf;

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    @NotNull
    private ResourceLocation f420gg;
    private float mB;
    static final /* synthetic */ boolean hC;

    @NotNull
    public abstract Vec3 x();

    @OnlyIn(Dist.CLIENT)
    protected abstract PlayState a(@NotNull AnimationState<T> animationState);

    @OnlyIn(Dist.CLIENT)
    protected abstract void a(@NotNull SoundKeyframeEvent<T> soundKeyframeEvent);

    @OnlyIn(Dist.CLIENT)
    protected abstract void b(@NotNull CustomInstructionKeyframeEvent<T> customInstructionKeyframeEvent);

    static {
        hC = !tO.class.desiredAssertionStatus();
    }

    public tO(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.my = 1.0f;
        this.mz = 0.0f;
        this.mA = 0.0f;
        this.f420gg = tE.fP;
        this.mB = 0.3f;
        this.dg = str;
        this.gd = C0265jv.d("textures/item/" + this.dg + ".png");
        this.ge = C0265jv.d("animations/item/" + this.dg + ".animation.json");
        this.gf = C0265jv.d("geo/item/" + this.dg + ".geo.json");
        if (C0262js.ab()) {
            ItemProperties.register(this, ResourceLocation.withDefaultNamespace("skin"), (itemStack, clientLevel, livingEntity, i) -> {
                return b(itemStack);
            });
        }
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.tO.1
            private gW<?> a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.a == null) {
                    this.a = new gW<>();
                }
                return this.a;
            }
        });
    }

    public boolean ci() {
        return true;
    }

    public static void a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(wV.D, str);
    }

    @NotNull
    public static String a(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(wV.D, "");
    }

    public static void a(@NotNull ItemStack itemStack, float f) {
        itemStack.set(wV.C, Float.valueOf(f));
    }

    public static void a(@NotNull ItemStack itemStack, int i, int i2) {
        switch (i) {
            case 0:
                itemStack.set(wV.z, Integer.valueOf(i2));
                break;
            case 1:
                itemStack.set(wV.A, Integer.valueOf(i2));
                break;
            case 2:
                itemStack.set(wV.B, Integer.valueOf(i2));
                break;
        }
    }

    public static float b(@NotNull ItemStack itemStack) {
        return ((Float) itemStack.getOrDefault(wV.C, Float.valueOf(0.0f))).floatValue();
    }

    public static int b(@NotNull ItemStack itemStack, int i) {
        switch (i) {
            case 0:
                return ((Integer) itemStack.getOrDefault(wV.z, -1)).intValue();
            case 1:
                return ((Integer) itemStack.getOrDefault(wV.A, -1)).intValue();
            case 2:
                return ((Integer) itemStack.getOrDefault(wV.B, -1)).intValue();
            default:
                return -1;
        }
    }

    @NotNull
    public T a(@NotNull ResourceLocation resourceLocation) {
        this.f420gg = resourceLocation;
        return this;
    }

    @NotNull
    public tD a() {
        return tD.a(this.f420gg);
    }

    protected void a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        itemStack.set(wV.y.get(), true);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!hC && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            CloudRegistry cloudRegistryM537a = abstractC0264juM166a.m537a();
            iN inventory = abstractC0264juM166a.m531a().a(player).getInventory();
            a(itemStack, player.getScoreboardName());
            CloudItemStack cloudItemStackA = inventory.a(cloudRegistryM537a, C0265jv.a(BuiltInRegistries.ITEM.getKey(itemStack.getItem())));
            if (cloudItemStackA != null) {
                CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryM537a);
                if (cloudItem != null) {
                    iT.a(cloudItem, itemStack);
                }
                iT.a(cloudItemStackA, itemStack);
            }
        }
    }

    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        if (!((Boolean) itemStack.getOrDefault(wV.y.get(), false)).booleanValue()) {
            a(itemStack, entity);
        }
        if (level.isClientSide()) {
            if (z) {
                this.mA = this.mz;
                this.mz = Mth.lerp(0.1f, this.mz, 0.0f);
                float fAbs = Mth.abs(entity.getYHeadRot() - entity.yRotO);
                if (fAbs < 0.0f) {
                    fAbs = -fAbs;
                }
                while (fAbs > 340.0f) {
                    fAbs -= 340.0f;
                }
                if (fAbs > 0.0f) {
                    this.mz += fAbs / 400.0f;
                    return;
                }
                return;
            }
            return;
        }
        if (entity.isInWaterOrRain() && level.random.nextInt(40) == 0) {
            a(itemStack, 1);
        }
    }

    private void a(@NotNull ItemStack itemStack, int i) {
        int iIntValue = ((Integer) itemStack.getOrDefault(wV.Q, 0)).intValue();
        if (iIntValue > 0) {
            itemStack.set(wV.Q, Integer.valueOf(Math.max(iIntValue - i, 0)));
        }
        int iIntValue2 = ((Integer) itemStack.getOrDefault(wV.R, 0)).intValue();
        if (iIntValue2 > 0) {
            itemStack.set(wV.R, Integer.valueOf(Math.max(iIntValue2 - i, 0)));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Component m1151a(@NotNull ItemStack itemStack) {
        C0297l c0297lB;
        Item item = itemStack.getItem();
        MutableComponent mutableComponentLiteral = Component.literal(item.getDescription().getString());
        float fB = b(itemStack);
        if (fB > 0.0f && (c0297lB = C0297l.b()) != null) {
            CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0297lB.a(), C0265jv.a(BuiltInRegistries.ITEM.getKey(item)), fB);
            if (itemFromSkinId != null) {
                mutableComponentLiteral.append(Component.literal(" " + itemFromSkinId.getSuffix()));
                mutableComponentLiteral.withColor(itemFromSkinId.getRarity().getColor());
            }
        }
        return mutableComponentLiteral;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public Component getName(ItemStack itemStack) {
        CloudItem<?> itemFromSkinId;
        C0297l c0297lB = C0297l.b();
        if (!hC && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        Item item = itemStack.getItem();
        if (minecraft.level == null) {
            return super.getName(itemStack);
        }
        MutableComponent mutableComponentLiteral = Component.literal(super.getName(itemStack).getString());
        String strA = a(itemStack);
        if (strA.isEmpty()) {
            return mutableComponentLiteral;
        }
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.item.gun.name", new Object[]{strA, mutableComponentLiteral});
        float fB = b(itemStack);
        if (fB > 0.0f && (itemFromSkinId = CloudItem.getItemFromSkinId(c0297lB.a(), C0265jv.a(BuiltInRegistries.ITEM.getKey(item)), fB)) != null) {
            mutableComponentTranslatable.append(Component.literal(" " + itemFromSkinId.getSuffix()));
            mutableComponentTranslatable.withColor(itemFromSkinId.getRarity().getColor());
        }
        return mutableComponentTranslatable;
    }

    @Override // software.bernie.geckolib.animatable.GeoItem
    public boolean isPerspectiveAware() {
        return true;
    }

    @NotNull
    public ResourceLocation O() {
        return this.gd;
    }

    @NotNull
    public ResourceLocation P() {
        return this.ge;
    }

    @NotNull
    public ResourceLocation Q() {
        return this.gf;
    }

    @NotNull
    public String at() {
        return this.dg;
    }

    public float bs() {
        return this.my;
    }

    public T a(float f) {
        this.my = f;
        return this;
    }

    public T b(float f) {
        this.mB = f;
        return this;
    }

    public float bt() {
        return this.mB;
    }
}
