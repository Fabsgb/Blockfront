package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCallingCard;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.to */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/to.class */
public final class C1089to {

    /* JADX INFO: renamed from: tg */
    public static final int f5854tg = 37;

    /* JADX INFO: renamed from: th */
    public static final int f5855th = 200;

    /* JADX INFO: renamed from: ti */
    public static final int f5856ti = 43;

    /* JADX INFO: renamed from: A */
    @NotNull
    private final UUID f5857A;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final ItemStack f5858r;

    /* JADX INFO: renamed from: mS */
    private final float f5859mS;

    /* JADX INFO: renamed from: aI */
    private float f5861aI;

    /* JADX INFO: renamed from: aN */
    private int f5860aN = 100;

    /* JADX INFO: renamed from: aJ */
    private float f5862aJ = 0.0f;

    public C1089to(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.f5857A = uuid;
        this.f5858r = itemStack;
        this.f5859mS = f;
    }

    public void onUpdate() {
        if (this.f5860aN > 0) {
            this.f5860aN--;
        }
        this.f5862aJ = this.f5861aI;
        this.f5861aI = Mth.clamp(Mth.lerp(0.2f, this.f5861aI, this.f5860aN <= 0 ? 0.0f : 1.0f), 0.0f, 1.0f);
        if (this.f5861aI <= 0.05d) {
            this.f5861aI = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5966a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.f5861aI <= 0.0f) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        CloudRegistry cloudRegistryA = c0623l.m2855a();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, i2 - (93.0f * C1270xJ.m7170f(this.f5861aI, this.f5862aJ, f)), 0.0f);
        int i3 = (i / 2) - 100;
        C0555jl c0555jlA = c0396gl.mo1154a(this.f5857A);
        C0394gj c0394gjB = c0396gl.m1152b(this.f5857A);
        C0550jg inventory = c0555jlA.getInventory();
        ResourceLocation resourceLocationM2378d = C0129bt.f869F;
        CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.CARD);
        if (cloudItemStackM2487a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof CloudItemCallingCard) {
                resourceLocationM2378d = C0532jO.m2378d("textures/gui/callingcard/" + ((CloudItemCallingCard) cloudItem).getSuffixForDisplay() + ".png");
            }
        }
        C0129bt.m515a(guiGraphics, i3, 0, 200, 43, C0129bt.m465t());
        C0129bt.m535a(poseStackPose, guiGraphics, resourceLocationM2378d, i3 + 1, 1, 198, 41, 0.0f, 0.4f);
        C0129bt.m515a(guiGraphics, i3 + 1, 5, 158, 33, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, (i3 + 200) - 41, 2, 39, 39, C0129bt.m465t());
        float f2 = (i3 + 200) - 40;
        C0129bt.m585a(minecraft, c0623l, poseStackPose, guiGraphics, c0555jlA.m2522a(), f2, 3.0f, 37);
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623l.m2878a();
        if (abstractC0864pcM2878a != null) {
            abstractC0864pcM2878a.m4138a(poseStackPose, guiGraphics, c0394gjB, f2, 3.0f, 37);
        }
        int i4 = i3 + 3;
        MutableComponent mutableComponentM2515b = c0555jlA.m2515b();
        MutableComponent mutableComponentWithStyle = Component.literal(String.format("%.2f", Float.valueOf(this.f5859mS))).withStyle(ChatFormatting.GREEN);
        C0129bt.m479b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.by", new Object[]{mutableComponentM2515b}), i4, 8);
        C0129bt.m479b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.hp", new Object[]{mutableComponentWithStyle}), i4, 19);
        C0129bt.m479b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.using", new Object[]{this.f5858r.getItem().getName(this.f5858r)}), i4, 29);
        CloudItemStack cloudItemStackM2487a2 = inventory.m2487a(CloudItemType.COIN);
        if (cloudItemStackM2487a2 != null) {
            CloudItem<?> cloudItem2 = cloudItemStackM2487a2.getCloudItem(cloudRegistryA);
            if (cloudItem2 instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a2, poseStackPose, minecraft, guiGraphics, i3, 0.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        poseStackPose.popPose();
    }

    @NotNull
    public UUID getUUID() {
        return this.f5857A;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public ItemStack m5967m() {
        return this.f5858r;
    }

    /* JADX INFO: renamed from: ba */
    public float m5968ba() {
        return this.f5859mS;
    }
}
