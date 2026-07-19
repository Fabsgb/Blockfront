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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sR.class */
public final class sR {
    public static final int rf = 37;
    public static final int rg = 200;
    public static final int rh = 43;

    @NotNull
    private final UUID A;

    @NotNull
    private final ItemStack p;
    private final float lT;
    private float aD;
    private int Z = 100;
    private float aE = 0.0f;

    public sR(@NotNull UUID uuid, @NotNull ItemStack itemStack, float f) {
        this.A = uuid;
        this.p = itemStack;
        this.lT = f;
    }

    public void onUpdate() {
        if (this.Z > 0) {
            this.Z--;
        }
        this.aE = this.aD;
        this.aD = Mth.clamp(Mth.lerp(0.2f, this.aD, this.Z <= 0 ? 0.0f : 1.0f), 0.0f, 1.0f);
        if (this.aD <= 0.05d) {
            this.aD = 0.0f;
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.aD <= 0.0f) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        CloudRegistry cloudRegistryA = c0297l.a();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, i2 - (93.0f * C0634xm.e(this.aD, this.aE, f)), 0.0f);
        int i3 = (i / 2) - 100;
        iS iSVarA = fVVar.mo306a(this.A);
        fT fTVarB = fVVar.b(this.A);
        iN inventory = iSVarA.getInventory();
        ResourceLocation resourceLocationD = C0040bk.F;
        CloudItemStack cloudItemStackA = inventory.a(CloudItemType.CARD);
        if (cloudItemStackA != null) {
            CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof CloudItemCallingCard) {
                resourceLocationD = C0265jv.d("textures/gui/callingcard/" + ((CloudItemCallingCard) cloudItem).getSuffixForDisplay() + ".png");
            }
        }
        C0040bk.a(guiGraphics, i3, 0, 200, 43, C0040bk.p());
        C0040bk.a(poseStackPose, guiGraphics, resourceLocationD, i3 + 1, 1, 198, 41, 0.0f, 0.4f);
        C0040bk.a(guiGraphics, i3 + 1, 5, 158, 33, C0040bk.p());
        C0040bk.a(guiGraphics, (i3 + 200) - 41, 2, 39, 39, C0040bk.p());
        float f2 = (i3 + 200) - 40;
        C0040bk.a(minecraft, c0297l, poseStackPose, guiGraphics, iSVarA.m491a(), f2, 3.0f, 37);
        oG<?, ?> oGVarM593a = c0297l.m593a();
        if (oGVarM593a != null) {
            oGVarM593a.a(poseStackPose, guiGraphics, fTVarB, f2, 3.0f, 37);
        }
        int i4 = i3 + 3;
        MutableComponent mutableComponentB = iSVarA.b();
        MutableComponent mutableComponentWithStyle = Component.literal(String.format("%.2f", Float.valueOf(this.lT))).withStyle(ChatFormatting.GREEN);
        C0040bk.b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.by", new Object[]{mutableComponentB}), i4, 8);
        C0040bk.b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.hp", new Object[]{mutableComponentWithStyle}), i4, 19);
        C0040bk.b(font, guiGraphics, (Component) Component.translatable("bf.killmessage.using", new Object[]{this.p.getItem().getName(this.p)}), i4, 29);
        CloudItemStack cloudItemStackA2 = inventory.a(CloudItemType.COIN);
        if (cloudItemStackA2 != null) {
            CloudItem<?> cloudItem2 = cloudItemStackA2.getCloudItem(cloudRegistryA);
            if (cloudItem2 instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA2, poseStackPose, minecraft, guiGraphics, i3, 0.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        poseStackPose.popPose();
    }

    @NotNull
    public UUID getUUID() {
        return this.A;
    }

    @NotNull
    public ItemStack k() {
        return this.p;
    }

    public float aU() {
        return this.lT;
    }
}
