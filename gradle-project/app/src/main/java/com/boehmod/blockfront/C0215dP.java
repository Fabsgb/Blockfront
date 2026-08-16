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

/* JADX INFO: renamed from: com.boehmod.blockfront.dP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dP.class */
public final class C0215dP extends AbstractC0217dR {

    /* JADX INFO: renamed from: fK */
    private static final Component f1663fK = Component.translatable("bf.message.profile.base.showcase");

    /* JADX INFO: renamed from: fL */
    private static final Component f1664fL = Component.translatable("bf.profile.showcase.empty").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: hT */
    public static final int f1665hT = 5;

    /* JADX INFO: renamed from: hU */
    public static final int f1666hU = 40;

    /* JADX INFO: renamed from: hV */
    public static final int f1667hV = 40;

    /* JADX INFO: renamed from: hW */
    public static final int f1668hW = 4;

    /* JADX INFO: renamed from: hX */
    public static final int f1669hX = 133;

    /* JADX INFO: renamed from: A */
    @NotNull
    private final List<C0087bD> f1670A;

    public C0215dP(@NotNull Screen screen, C0555jl c0555jl) {
        super(screen, c0555jl, Component.translatable("bf.screen.profile.main", new Object[]{c0555jl.getUsername()}));
        this.f1670A = new ObjectArrayList();
    }

    public C0215dP(@NotNull Screen screen) {
        this(screen, ((C0396gl) C0623l.m2852b().m2855a()).m1886a(Minecraft.getInstance()));
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        C0550jg inventory = this.playerCloudData.getInventory();
        int i = this.width / 2;
        List list = inventory.getShowcasedItems().stream().limit(5L).toList();
        int size = (i - ((44 * list.size()) / 2)) + 2;
        this.f1670A.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Optional<CloudItemStack> stackFromUUID = inventory.getStackFromUUID((UUID) it.next());
            if (stackFromUUID.isPresent()) {
                this.f1670A.add(new C0087bD(this, stackFromUUID.get(), size, f1669hX, 40, 40, false, true).m347a(true));
                size += 44;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        Iterator<C0087bD> it = this.f1670A.iterator();
        while (it.hasNext()) {
            it.next().m348a(this.f1058a, cloudRegistryA);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = i3 - 100;
        C0550jg inventory = this.playerCloudData.getInventory();
        C0129bt.m515a(guiGraphics, i4, 72, 40, 40, ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m515a(guiGraphics, i4 + 1, 73, 38, 38, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, this.playerCloudData.m2522a(), i4 + 2, 74.0f, 36);
        CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.COIN);
        if (cloudItemStackM2487a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a, poseStackPose, this.f1058a, guiGraphics, i4, 72.0f, 16.0f, 16.0f, 1.0f);
            }
        }
        int i5 = i4 + 40 + 5;
        int prestigeLevel = this.playerCloudData.getPrestigeLevel();
        MutableComponent mutableComponentWithColor = Component.literal(this.playerCloudData.getRank().getTitle()).withColor(this.playerCloudData.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        MutableComponent mutableComponentWithColor2 = Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);
        MutableComponent mutableComponentAppend = C0548je.m2477a(this.playerCloudData).append(this.playerCloudData.m2515b());
        MutableComponent mutableComponentWithStyle = this.playerCloudData.m2517k().copy().withStyle(this.playerCloudData.getStatus().getOnlineStatus().isOnline() ? ChatFormatting.GREEN : ChatFormatting.RED);
        C0129bt.m470a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.username", new Object[]{mutableComponentAppend}), i5, 73);
        C0129bt.m470a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.rank", new Object[]{mutableComponentWithColor2.append(mutableComponentWithColor)}), i5, 83);
        C0129bt.m470a(this.font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.status", new Object[]{mutableComponentWithStyle}), i5, 93);
        C0129bt.m483c(this.font, guiGraphics, f1663fK, i3, C0358g.f2490g);
        if (this.f1670A.isEmpty()) {
            C0129bt.m483c(this.font, guiGraphics, f1664fL, i3, 150);
            return;
        }
        for (C0087bD c0087bD : this.f1670A) {
            c0087bD.f567dD = c0087bD.f566cc;
            c0087bD.m349a(this.f1058a, guiGraphics, this.font, i, i2, f);
        }
    }
}
