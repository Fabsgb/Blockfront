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

/* JADX INFO: renamed from: com.boehmod.blockfront.dE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dE.class */
public final class C0203dE extends AbstractC0205dG {

    /* JADX INFO: renamed from: fE */
    private static final Component f1634fE = Component.translatable("bf.message.profile.base.showcase");

    /* JADX INFO: renamed from: fF */
    private static final Component f1635fF = Component.translatable("bf.profile.showcase.empty").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: gJ */
    public static final int f1636gJ = 5;

    /* JADX INFO: renamed from: gK */
    public static final int f1637gK = 40;

    /* JADX INFO: renamed from: gL */
    public static final int f1638gL = 40;

    /* JADX INFO: renamed from: gM */
    public static final int f1639gM = 4;

    /* JADX INFO: renamed from: gN */
    public static final int f1640gN = 133;

    /* JADX INFO: renamed from: y */
    @NotNull
    private final List<C0129bu> f1641y;

    public C0203dE(@NotNull Screen screen, C0482iS c0482iS) {
        super(screen, c0482iS, Component.translatable("bf.screen.profile.main", new Object[]{c0482iS.getUsername()}));
        this.f1641y = new ObjectArrayList();
    }

    public C0203dE(@NotNull Screen screen) {
        this(screen, ((C0326fV) C0622l.m2667b().m2670a()).m1676a(Minecraft.getInstance()));
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        C0477iN inventory = this.playerCloudData.getInventory();
        int i = this.width / 2;
        List list = inventory.getShowcasedItems().stream().limit(5L).toList();
        int size = (i - ((44 * list.size()) / 2)) + 2;
        this.f1641y.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Optional<CloudItemStack> stackFromUUID = inventory.getStackFromUUID((UUID) it.next());
            if (stackFromUUID.isPresent()) {
                this.f1641y.add(new C0129bu(this, stackFromUUID.get(), size, f1640gN, 40, 40, false, true).m672a(true));
                size += 44;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        Iterator<C0129bu> it = this.f1641y.iterator();
        while (it.hasNext()) {
            it.next().m673a(this.f1587b, cloudRegistryA);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = i3 - 100;
        C0477iN inventory = this.playerCloudData.getInventory();
        C0119bk.m415a(guiGraphics, i4, 72, 40, 40, ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m415a(guiGraphics, i4 + 1, 73, 38, 38, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, this.playerCloudData.m2195a(), i4 + 2, 74.0f, 36);
        CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.COIN);
        if (cloudItemStackM2160a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a, poseStackPose, this.f1587b, guiGraphics, i4, 72.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        int i5 = i4 + 40 + 5;
        int prestigeLevel = this.playerCloudData.getPrestigeLevel();
        MutableComponent mutableComponentWithColor = Component.literal(this.playerCloudData.getRank().getTitle()).withColor(this.playerCloudData.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        MutableComponent mutableComponentWithColor2 = Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        MutableComponent mutableComponentAppend = C0475iL.m2150a(this.playerCloudData).append(this.playerCloudData.m2188b());
        MutableComponent mutableComponentWithStyle = this.playerCloudData.m2190k().copy().withStyle(this.playerCloudData.getStatus().getOnlineStatus().isOnline() ? ChatFormatting.GREEN : ChatFormatting.RED);
        C0119bk.m370a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.username", new Object[]{mutableComponentAppend}), i5, 73);
        C0119bk.m370a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.rank", new Object[]{mutableComponentWithColor2.append(mutableComponentWithColor)}), i5, 83);
        C0119bk.m370a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.status", new Object[]{mutableComponentWithStyle}), i5, 93);
        C0119bk.m383c(this.font, guiGraphics, f1634fE, i3, C0357g.f2439g);
        if (this.f1641y.isEmpty()) {
            C0119bk.m383c(this.font, guiGraphics, f1635fF, i3, 150);
            return;
        }
        for (C0129bu c0129bu : this.f1641y) {
            c0129bu.f928cL = c0129bu.f927bm;
            c0129bu.m674a(this.f1587b, guiGraphics, this.font, i, i2, f);
        }
    }
}
