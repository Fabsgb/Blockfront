package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.blockfront.AbstractC1062tO;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tO.class */
public abstract class AbstractC1062tO<T extends AbstractC1062tO<T>> extends C1058tK implements GeoItem {

    /* JADX INFO: renamed from: rJ */
    public static final int f5610rJ = 1200;

    /* JADX INFO: renamed from: rK */
    public static final int f5611rK = 16;

    /* JADX INFO: renamed from: my */
    private float f5612my;

    /* JADX INFO: renamed from: mz */
    public float f5613mz;

    /* JADX INFO: renamed from: mA */
    public float f5614mA;

    /* JADX INFO: renamed from: dg */
    @NotNull
    private final String f5615dg;

    /* JADX INFO: renamed from: gd */
    @NotNull
    private final ResourceLocation f5616gd;

    /* JADX INFO: renamed from: ge */
    @NotNull
    private final ResourceLocation f5617ge;

    /* JADX INFO: renamed from: gf */
    @NotNull
    private final ResourceLocation f5618gf;

    /* JADX INFO: renamed from: gg */
    @NotNull
    private ResourceLocation f5619gg;

    /* JADX INFO: renamed from: mB */
    private float f5620mB;

    /* JADX INFO: renamed from: hC */
    static final /* synthetic */ boolean f5621hC;

    @NotNull
    /* JADX INFO: renamed from: x */
    public abstract Vec3 mo5893x();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected abstract PlayState mo5943a(@NotNull AnimationState<T> animationState);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected abstract void mo5944a(@NotNull SoundKeyframeEvent<T> soundKeyframeEvent);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected abstract void mo5945b(@NotNull CustomInstructionKeyframeEvent<T> customInstructionKeyframeEvent);

    static {
        f5621hC = !AbstractC1062tO.class.desiredAssertionStatus();
    }

    public AbstractC1062tO(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f5612my = 1.0f;
        this.f5613mz = 0.0f;
        this.f5614mA = 0.0f;
        this.f5619gg = C1052tE.f5556fP;
        this.f5620mB = 0.3f;
        this.f5615dg = str;
        this.f5616gd = C0564jv.m2555d("textures/item/" + this.f5615dg + ".png");
        this.f5617ge = C0564jv.m2555d("animations/item/" + this.f5615dg + ".animation.json");
        this.f5618gf = C0564jv.m2555d("geo/item/" + this.f5615dg + ".geo.json");
        if (C0561js.m2512ab()) {
            ItemProperties.register(this, ResourceLocation.withDefaultNamespace("skin"), (itemStack, clientLevel, livingEntity, i) -> {
                return m5932b(itemStack);
            });
        }
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider(this) { // from class: com.boehmod.blockfront.tO.1

            /* JADX INFO: renamed from: a */
            private C0380gW<?> f5622a;

            @Override // software.bernie.geckolib.animatable.client.GeoRenderProvider
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.f5622a == null) {
                    this.f5622a = new C0380gW<>();
                }
                return this.f5622a;
            }
        });
    }

    /* JADX INFO: renamed from: ci */
    public boolean mo5927ci() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m5928a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1228wV.f6960D, str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m5929a(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1228wV.f6960D, "");
    }

    /* JADX INFO: renamed from: a */
    public static void m5930a(@NotNull ItemStack itemStack, float f) {
        itemStack.set(C1228wV.f6959C, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: a */
    public static void m5931a(@NotNull ItemStack itemStack, int i, int i2) {
        switch (i) {
            case 0:
                itemStack.set(C1228wV.f6956z, Integer.valueOf(i2));
                break;
            case 1:
                itemStack.set(C1228wV.f6957A, Integer.valueOf(i2));
                break;
            case 2:
                itemStack.set(C1228wV.f6958B, Integer.valueOf(i2));
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public static float m5932b(@NotNull ItemStack itemStack) {
        return ((Float) itemStack.getOrDefault(C1228wV.f6959C, Float.valueOf(0.0f))).floatValue();
    }

    /* JADX INFO: renamed from: b */
    public static int m5933b(@NotNull ItemStack itemStack, int i) {
        switch (i) {
            case 0:
                return ((Integer) itemStack.getOrDefault(C1228wV.f6956z, -1)).intValue();
            case 1:
                return ((Integer) itemStack.getOrDefault(C1228wV.f6957A, -1)).intValue();
            case 2:
                return ((Integer) itemStack.getOrDefault(C1228wV.f6958B, -1)).intValue();
            default:
                return -1;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public T mo5934a(@NotNull ResourceLocation resourceLocation) {
        this.f5619gg = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1051tD m5935a() {
        return C1051tD.m5836a(this.f5619gg);
    }

    /* JADX INFO: renamed from: a */
    protected void mo5936a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        itemStack.set(C1228wV.f6955y.get(), true);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f5621hC && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            CloudRegistry cloudRegistryM2550a = abstractC0563juM168a.m2550a();
            C0477iN inventory = abstractC0563juM168a.m2528a().m1133a(player).getInventory();
            m5928a(itemStack, player.getScoreboardName());
            CloudItemStack cloudItemStackM2162a = inventory.m2162a(cloudRegistryM2550a, C0564jv.m2557a(BuiltInRegistries.ITEM.getKey(itemStack.getItem())));
            if (cloudItemStackM2162a != null) {
                CloudItem<?> cloudItem = cloudItemStackM2162a.getCloudItem(cloudRegistryM2550a);
                if (cloudItem != null) {
                    C0483iT.m2204a(cloudItem, itemStack);
                }
                C0483iT.m2205a(cloudItemStackM2162a, itemStack);
            }
        }
    }

    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        if (!((Boolean) itemStack.getOrDefault(C1228wV.f6955y.get(), false)).booleanValue()) {
            mo5936a(itemStack, entity);
        }
        if (level.isClientSide()) {
            if (z) {
                this.f5614mA = this.f5613mz;
                this.f5613mz = Mth.lerp(0.1f, this.f5613mz, 0.0f);
                float fAbs = Mth.abs(entity.getYHeadRot() - entity.yRotO);
                if (fAbs < 0.0f) {
                    fAbs = -fAbs;
                }
                while (fAbs > 340.0f) {
                    fAbs -= 340.0f;
                }
                if (fAbs > 0.0f) {
                    this.f5613mz += fAbs / 400.0f;
                    return;
                }
                return;
            }
            return;
        }
        if (entity.isInWaterOrRain() && level.random.nextInt(40) == 0) {
            m5937a(itemStack, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5937a(@NotNull ItemStack itemStack, int i) {
        int iIntValue = ((Integer) itemStack.getOrDefault(C1228wV.f6973Q, 0)).intValue();
        if (iIntValue > 0) {
            itemStack.set(C1228wV.f6973Q, Integer.valueOf(Math.max(iIntValue - i, 0)));
        }
        int iIntValue2 = ((Integer) itemStack.getOrDefault(C1228wV.f6974R, 0)).intValue();
        if (iIntValue2 > 0) {
            itemStack.set(C1228wV.f6974R, Integer.valueOf(Math.max(iIntValue2 - i, 0)));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m5938a(@NotNull ItemStack itemStack) {
        C0622l c0622lM2667b;
        Item item = itemStack.getItem();
        MutableComponent mutableComponentLiteral = Component.literal(item.getDescription().getString());
        float fM5932b = m5932b(itemStack);
        if (fM5932b > 0.0f && (c0622lM2667b = C0622l.m2667b()) != null) {
            CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0622lM2667b.m2670a(), C0564jv.m2557a(BuiltInRegistries.ITEM.getKey(item)), fM5932b);
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
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f5621hC && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        Item item = itemStack.getItem();
        if (minecraft.level == null) {
            return super.getName(itemStack);
        }
        MutableComponent mutableComponentLiteral = Component.literal(super.getName(itemStack).getString());
        String strM5929a = m5929a(itemStack);
        if (strM5929a.isEmpty()) {
            return mutableComponentLiteral;
        }
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.item.gun.name", new Object[]{strM5929a, mutableComponentLiteral});
        float fM5932b = m5932b(itemStack);
        if (fM5932b > 0.0f && (itemFromSkinId = CloudItem.getItemFromSkinId(c0622lM2667b.m2670a(), C0564jv.m2557a(BuiltInRegistries.ITEM.getKey(item)), fM5932b)) != null) {
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
    /* JADX INFO: renamed from: O */
    public ResourceLocation m5939O() {
        return this.f5616gd;
    }

    @NotNull
    /* JADX INFO: renamed from: P */
    public ResourceLocation m5940P() {
        return this.f5617ge;
    }

    @NotNull
    /* JADX INFO: renamed from: Q */
    public ResourceLocation m5941Q() {
        return this.f5618gf;
    }

    @NotNull
    /* JADX INFO: renamed from: at */
    public String m5942at() {
        return this.f5615dg;
    }

    /* JADX INFO: renamed from: bs */
    public float m5946bs() {
        return this.f5612my;
    }

    /* JADX INFO: renamed from: a */
    public T mo5947a(float f) {
        this.f5612my = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public T mo5948b(float f) {
        this.f5620mB = f;
        return this;
    }

    /* JADX INFO: renamed from: bt */
    public float m5949bt() {
        return this.f5620mB;
    }
}
