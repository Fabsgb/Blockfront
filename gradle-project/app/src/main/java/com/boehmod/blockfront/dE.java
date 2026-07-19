package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dE.class */
public final class dE extends dG {
    private static final Component fE = Component.translatable("bf.message.profile.base.showcase");
    private static final Component fF = Component.translatable("bf.profile.showcase.empty").withStyle(ChatFormatting.GRAY);
    public static final int gJ = 5;
    public static final int gK = 40;
    public static final int gL = 40;
    public static final int gM = 4;
    public static final int gN = 133;

    @NotNull
    private final List<C0050bu> y;

    public dE(@NotNull Screen screen, iS iSVar) {
        super(screen, iSVar, Component.translatable("bf.screen.profile.main", new Object[]{iSVar.getUsername()}));
        this.y = new ObjectArrayList();
    }

    public dE(@NotNull Screen screen) {
        this(screen, ((fV) C0297l.b().a()).m404a(Minecraft.getInstance()));
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        iN inventory = this.playerCloudData.getInventory();
        int i = this.width / 2;
        List list = inventory.getShowcasedItems().stream().limit(5L).toList();
        int size = (i - ((44 * list.size()) / 2)) + 2;
        this.y.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Optional<CloudItemStack> stackFromUUID = inventory.getStackFromUUID((UUID) it.next());
            if (stackFromUUID.isPresent()) {
                this.y.add(new C0050bu(this, stackFromUUID.get(), size, gN, 40, 40, false, true).a(true));
                size += 44;
            }
        }
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.e.a();
        Iterator<C0050bu> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, cloudRegistryA);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.e.a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = i3 - 100;
        iN inventory = this.playerCloudData.getInventory();
        C0040bk.a(guiGraphics, i4, 72, 40, 40, ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.a(guiGraphics, i4 + 1, 73, 38, 38, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, this.playerCloudData.m491a(), i4 + 2, 74.0f, 36);
        CloudItemStack cloudItemStackA = inventory.a(CloudItemType.COIN);
        if (cloudItemStackA != null) {
            CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA, poseStackPose, this.b, guiGraphics, i4, 72.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        int i5 = i4 + 40 + 5;
        int prestigeLevel = this.playerCloudData.getPrestigeLevel();
        MutableComponent mutableComponentWithColor = Component.literal(this.playerCloudData.getRank().getTitle()).withColor(this.playerCloudData.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        MutableComponent mutableComponentWithColor2 = Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        MutableComponent mutableComponentAppend = iL.a(this.playerCloudData).append(this.playerCloudData.b());
        MutableComponent mutableComponentWithStyle = this.playerCloudData.k().copy().withStyle(this.playerCloudData.getStatus().getOnlineStatus().isOnline() ? ChatFormatting.GREEN : ChatFormatting.RED);
        C0040bk.a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.username", new Object[]{mutableComponentAppend}), i5, 73);
        C0040bk.a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.rank", new Object[]{mutableComponentWithColor2.append(mutableComponentWithColor)}), i5, 83);
        C0040bk.a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.status", new Object[]{mutableComponentWithStyle}), i5, 93);
        C0040bk.c(this.font, guiGraphics, fE, i3, C0163g.g);
        if (this.y.isEmpty()) {
            C0040bk.c(this.font, guiGraphics, fF, i3, 150);
            return;
        }
        for (C0050bu c0050bu : this.y) {
            c0050bu.cL = c0050bu.bm;
            c0050bu.a(this.b, guiGraphics, this.font, i, i2, f);
        }
    }
}
