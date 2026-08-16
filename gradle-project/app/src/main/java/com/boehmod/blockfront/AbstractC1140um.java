package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.blockfront.AbstractC1140um;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.um */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/um.class */
public abstract class AbstractC1140um<T extends AbstractC1140um<T>> extends C1136ui implements GeoItem {

    /* JADX INFO: renamed from: tM */
    public static final int f6249tM = 1200;

    /* JADX INFO: renamed from: tN */
    public static final int f6250tN = 16;

    /* JADX INFO: renamed from: nx */
    private float f6251nx;

    /* JADX INFO: renamed from: ny */
    public float f6252ny;

    /* JADX INFO: renamed from: nz */
    public float f6253nz;

    /* JADX INFO: renamed from: dr */
    @NotNull
    private final String f6254dr;

    /* JADX INFO: renamed from: gc */
    @NotNull
    private final ResourceLocation f6255gc;

    /* JADX INFO: renamed from: gd */
    @NotNull
    private final ResourceLocation f6256gd;

    /* JADX INFO: renamed from: ge */
    @NotNull
    private final ResourceLocation f6257ge;

    /* JADX INFO: renamed from: gf */
    @NotNull
    private ResourceLocation f6258gf;

    /* JADX INFO: renamed from: nA */
    private float f6259nA;

    /* JADX INFO: renamed from: hW */
    static final /* synthetic */ boolean f6260hW;

    @NotNull
    /* JADX INFO: renamed from: y */
    public abstract Vec3 mo6195y();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected abstract PlayState mo6383a(@NotNull AnimationState<T> animationState);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected abstract void mo6387a(@NotNull SoundKeyframeEvent<T> soundKeyframeEvent);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected abstract void mo6388b(@NotNull CustomInstructionKeyframeEvent<T> customInstructionKeyframeEvent);

    static {
        f6260hW = !AbstractC1140um.class.desiredAssertionStatus();
    }

    public AbstractC1140um(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f6251nx = 1.0f;
        this.f6252ny = 0.0f;
        this.f6253nz = 0.0f;
        this.f6258gf = C1130uc.f6195fO;
        this.f6259nA = 0.3f;
        this.f6254dr = str;
        this.f6255gc = C0532jO.m2378d("textures/item/" + this.f6254dr + ".png");
        this.f6256gd = C0532jO.m2378d("animations/item/" + this.f6254dr + ".animation.json");
        this.f6257ge = C0532jO.m2378d("geo/item/" + this.f6254dr + ".geo.json");
        if (C0529jL.m2332ae()) {
            ItemProperties.register(this, ResourceLocation.withDefaultNamespace("skin"), (itemStack, clientLevel, livingEntity, i) -> {
                return m6566b(itemStack);
            });
        }
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.um.1

            /* JADX INFO: renamed from: a */
            private C0450hm<?> f6261a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.f6261a == null) {
                    this.f6261a = new C0450hm<>();
                }
                return this.f6261a;
            }
        });
    }

    /* JADX INFO: renamed from: cs */
    public boolean mo6194cs() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m6562a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1305xs.f7523D, str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m6563a(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1305xs.f7523D, "");
    }

    /* JADX INFO: renamed from: a */
    public static void m6564a(@NotNull ItemStack itemStack, float f) {
        itemStack.set(C1305xs.f7522C, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: a */
    public static void m6565a(@NotNull ItemStack itemStack, int i, int i2) {
        switch (i) {
            case 0:
                itemStack.set(C1305xs.f7519z, Integer.valueOf(i2));
                break;
            case 1:
                itemStack.set(C1305xs.f7520A, Integer.valueOf(i2));
                break;
            case 2:
                itemStack.set(C1305xs.f7521B, Integer.valueOf(i2));
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public static float m6566b(@NotNull ItemStack itemStack) {
        return ((Float) itemStack.getOrDefault(C1305xs.f7522C, Float.valueOf(0.0f))).floatValue();
    }

    /* JADX INFO: renamed from: c */
    public static int m6567c(@NotNull ItemStack itemStack, int i) {
        switch (i) {
            case 0:
                return ((Integer) itemStack.getOrDefault(C1305xs.f7519z, -1)).intValue();
            case 1:
                return ((Integer) itemStack.getOrDefault(C1305xs.f7520A, -1)).intValue();
            case 2:
                return ((Integer) itemStack.getOrDefault(C1305xs.f7521B, -1)).intValue();
            default:
                return -1;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public T mo6311a(@NotNull ResourceLocation resourceLocation) {
        this.f6258gf = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1129ub m6568a() {
        return C1129ub.m6472a(this.f6258gf);
    }

    /* JADX INFO: renamed from: a */
    protected void mo6381a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        itemStack.set(C1305xs.f7518y.get(), true);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6260hW && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            CloudRegistry cloudRegistryM2373a = abstractC0531jNM179a.m2373a();
            C0550jg inventory = abstractC0531jNM179a.m2351a().m1150a(player).getInventory();
            m6562a(itemStack, player.getScoreboardName());
            CloudItemStack cloudItemStackM2489a = inventory.m2489a(cloudRegistryM2373a, C0532jO.m2380a(BuiltInRegistries.ITEM.getKey(itemStack.getItem())));
            if (cloudItemStackM2489a != null) {
                CloudItem<?> cloudItem = cloudItemStackM2489a.getCloudItem(cloudRegistryM2373a);
                if (cloudItem != null) {
                    C0556jm.m2531a(cloudItem, itemStack);
                }
                C0556jm.m2532a(cloudItemStackM2489a, itemStack);
            }
        }
    }

    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        if (!((Boolean) itemStack.getOrDefault(C1305xs.f7518y.get(), false)).booleanValue()) {
            mo6381a(itemStack, entity);
        }
        if (level.isClientSide()) {
            if (z) {
                this.f6253nz = this.f6252ny;
                this.f6252ny = Mth.lerp(0.1f, this.f6252ny, 0.0f);
                float fAbs = Mth.abs(entity.getYHeadRot() - entity.yRotO);
                if (fAbs < 0.0f) {
                    fAbs = -fAbs;
                }
                while (fAbs > 340.0f) {
                    fAbs -= 340.0f;
                }
                if (fAbs > 0.0f) {
                    this.f6252ny += fAbs / 400.0f;
                    return;
                }
                return;
            }
            return;
        }
        if (entity.isInWaterOrRain() && level.random.nextInt(40) == 0) {
            m6569a(itemStack, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6569a(@NotNull ItemStack itemStack, int i) {
        int iIntValue = ((Integer) itemStack.getOrDefault(C1305xs.f7538S, 0)).intValue();
        if (iIntValue > 0) {
            itemStack.set(C1305xs.f7538S, Integer.valueOf(Math.max(iIntValue - i, 0)));
        }
        int iIntValue2 = ((Integer) itemStack.getOrDefault(C1305xs.f7539T, 0)).intValue();
        if (iIntValue2 > 0) {
            itemStack.set(C1305xs.f7539T, Integer.valueOf(Math.max(iIntValue2 - i, 0)));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m6570a(@NotNull ItemStack itemStack) {
        C0623l c0623lM2852b;
        Item item = itemStack.getItem();
        MutableComponent mutableComponentLiteral = Component.literal(item.getDescription().getString());
        float fM6566b = m6566b(itemStack);
        if (fM6566b > 0.0f && (c0623lM2852b = C0623l.m2852b()) != null) {
            CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0623lM2852b.m2855a(), C0532jO.m2380a(BuiltInRegistries.ITEM.getKey(item)), fM6566b);
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
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f6260hW && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        Item item = itemStack.getItem();
        if (minecraft.level == null) {
            return super.getName(itemStack);
        }
        MutableComponent mutableComponentLiteral = Component.literal(super.getName(itemStack).getString());
        String strM6563a = m6563a(itemStack);
        if (strM6563a.isEmpty()) {
            return mutableComponentLiteral;
        }
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.item.gun.name", new Object[]{strM6563a, mutableComponentLiteral});
        float fM6566b = m6566b(itemStack);
        if (fM6566b > 0.0f && (itemFromSkinId = CloudItem.getItemFromSkinId(c0623lM2852b.m2855a(), C0532jO.m2380a(BuiltInRegistries.ITEM.getKey(item)), fM6566b)) != null) {
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
    /* JADX INFO: renamed from: P */
    public ResourceLocation m6571P() {
        return this.f6255gc;
    }

    @NotNull
    /* JADX INFO: renamed from: Q */
    public ResourceLocation m6572Q() {
        return this.f6256gd;
    }

    @NotNull
    /* JADX INFO: renamed from: R */
    public ResourceLocation m6573R() {
        return this.f6257ge;
    }

    @NotNull
    /* JADX INFO: renamed from: aA */
    public String m6574aA() {
        return this.f6254dr;
    }

    /* JADX INFO: renamed from: by */
    public float m6575by() {
        return this.f6251nx;
    }

    /* JADX INFO: renamed from: a */
    public T mo6290a(float f) {
        this.f6251nx = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public T mo6331b(float f) {
        this.f6259nA = f;
        return this;
    }

    /* JADX INFO: renamed from: bz */
    public float m6576bz() {
        return this.f6259nA;
    }
}
