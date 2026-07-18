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

/* JADX INFO: renamed from: com.boehmod.blockfront.sR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sR.class */
public final class C1011sR {

    /* JADX INFO: renamed from: rf */
    public static final int f5290rf = 37;

    /* JADX INFO: renamed from: rg */
    public static final int f5291rg = 200;

    /* JADX INFO: renamed from: rh */
    public static final int f5292rh = 43;

    /* JADX INFO: renamed from: A */
    @NotNull
    private final UUID f5293A;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final ItemStack f5294p;

    /* JADX INFO: renamed from: lT */
    private final float f5295lT;

    /* JADX INFO: renamed from: aD */
    private float f5297aD;

    /* JADX INFO: renamed from: Z */
    private int f5296Z = 100;

    /* JADX INFO: renamed from: aE */
    private float f5298aE = 0.0f;

    public C1011sR(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.f5293A = uuid;
        this.f5294p = itemStack;
        this.f5295lT = f;
    }

    public void onUpdate() {
        if (this.f5296Z > 0) {
            this.f5296Z--;
        }
        this.f5298aE = this.f5297aD;
        this.f5297aD = Mth.clamp(Mth.lerp(0.2f, this.f5297aD, this.f5296Z <= 0 ? 0.0f : 1.0f), 0.0f, 1.0f);
        if (this.f5297aD <= 0.05d) {
            this.f5297aD = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5478a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.f5297aD <= 0.0f) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        CloudRegistry cloudRegistryA = c0622l.m2670a();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, i2 - (93.0f * C1290xm.m7843e(this.f5297aD, this.f5298aE, f)), 0.0f);
        int i3 = (i / 2) - 100;
        C0482iS c0482iSA = c0326fV.mo1137a(this.f5293A);
        C0324fT c0324fTB = c0326fV.m1135b(this.f5293A);
        C0477iN inventory = c0482iSA.getInventory();
        ResourceLocation resourceLocationM2555d = C0119bk.f734F;
        CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.CARD);
        if (cloudItemStackM2160a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof CloudItemCallingCard) {
                resourceLocationM2555d = C0564jv.m2555d("textures/gui/callingcard/" + ((CloudItemCallingCard) cloudItem).getSuffixForDisplay() + ".png");
            }
        }
        C0119bk.m415a(guiGraphics, i3, 0, 200, 43, C0119bk.m365p());
        C0119bk.m435a(poseStackPose, guiGraphics, resourceLocationM2555d, i3 + 1, 1, 198, 41, 0.0f, 0.4f);
        C0119bk.m415a(guiGraphics, i3 + 1, 5, 158, 33, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, (i3 + 200) - 41, 2, 39, 39, C0119bk.m365p());
        float f2 = (i3 + 200) - 40;
        C0119bk.m485a(minecraft, c0622l, poseStackPose, guiGraphics, c0482iSA.m2195a(), f2, 3.0f, 37);
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622l.m2692a();
        if (abstractC0788oGM2692a != null) {
            abstractC0788oGM2692a.m3702a(poseStackPose, guiGraphics, c0324fTB, f2, 3.0f, 37);
        }
        int i4 = i3 + 3;
        MutableComponent mutableComponentM2188b = c0482iSA.m2188b();
        MutableComponent mutableComponentWithStyle = Component.literal(String.format("%.2f", Float.valueOf(this.f5295lT))).withStyle(ChatFormatting.GREEN);
        C0119bk.m379b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.by", new Object[]{mutableComponentM2188b}), i4, 8);
        C0119bk.m379b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.hp", new Object[]{mutableComponentWithStyle}), i4, 19);
        C0119bk.m379b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.using", new Object[]{this.f5294p.getItem().getName(this.f5294p)}), i4, 29);
        CloudItemStack cloudItemStackM2160a2 = inventory.m2160a(CloudItemType.COIN);
        if (cloudItemStackM2160a2 != null) {
            CloudItem<?> cloudItem2 = cloudItemStackM2160a2.getCloudItem(cloudRegistryA);
            if (cloudItem2 instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a2, poseStackPose, minecraft, guiGraphics, i3, 0.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        poseStackPose.popPose();
    }

    @NotNull
    public UUID getUUID() {
        return this.f5293A;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public ItemStack m5479k() {
        return this.f5294p;
    }

    /* JADX INFO: renamed from: aU */
    public float m5480aU() {
        return this.f5295lT;
    }
}
