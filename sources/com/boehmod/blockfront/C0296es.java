package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.es */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/es.class */
public final class C0296es extends AbstractC0288ek {

    /* JADX INFO: renamed from: hG */
    @NotNull
    private static final Component f2249hG = Component.translatable("bf.container.profile.popup.prestige").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);

    /* JADX INFO: renamed from: hH */
    @NotNull
    private static final Component f2250hH = Component.translatable("bf.menu.lobby.searching");

    /* JADX INFO: renamed from: id */
    private static final int f2251id = 16;

    /* JADX INFO: renamed from: bE */
    private boolean f2252bE;

    /* JADX INFO: renamed from: aD */
    private float f2253aD;

    /* JADX INFO: renamed from: aE */
    private float f2254aE;

    public C0296es(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2252bE = false;
        this.f2254aE = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private void m1565a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GameProfile gameProfile, @NotNull C0482iS c0482iS, @NotNull String str, float f) {
        CloudRegistry cloudRegistryA = c0622l.m2670a();
        String suffixForDisplay = "default";
        C0477iN inventory = c0482iS.getInventory();
        CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.CARD);
        if (cloudItemStackM2160a != null && cloudItemStackM2160a.getCloudItem(cloudRegistryA) != null) {
            suffixForDisplay = cloudItemStackM2160a.getCloudItem(cloudRegistryA).getSuffixForDisplay();
        }
        C0119bk.m435a(poseStack, guiGraphics, C0564jv.m2555d("textures/gui/callingcard/" + suffixForDisplay + ".png"), getX(), getY(), this.width, 25, 0.0f, 0.75f);
        C0119bk.m415a(guiGraphics, getX(), getY() + 26, this.width, 14, C0119bk.m365p());
        C0119bk.m417a(guiGraphics, getX(), getY() + 2, this.width, 21, 0, 0.5f);
        MutableComponent mutableComponentEmpty = Component.empty();
        Optional<PlayerGroup> group = c0482iS.getGroup();
        if (group.isPresent()) {
            mutableComponentEmpty.append(C0479iP.m2173a(group.get())).append(" ");
        }
        mutableComponentEmpty.append(Component.literal(str).withColor(ColorReferences.COLOR_WHITE));
        C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, gameProfile, getX() + 1, getY() + 3, 19);
        C0119bk.m379b(font, guiGraphics, (Component) mutableComponentEmpty, getX() + 22, getY() + 4);
        CloudItemStack cloudItemStackM2160a2 = inventory.m2160a(CloudItemType.COIN);
        if (cloudItemStackM2160a2 != null) {
            CloudItem<?> cloudItem = cloudItemStackM2160a2.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a2, poseStack, minecraft, guiGraphics, getX(), getY(), 16.0f, 16.0f, 1.0f);
            }
        }
        m1566a(guiGraphics, font, poseStack, c0482iS);
        m1567a(guiGraphics, c0482iS);
        m1568a(poseStack, guiGraphics, c0482iS, f);
        C0119bk.m379b(font, guiGraphics, (Component) Component.literal(C1293xp.m7912a(c0482iS.getTrophies())).withColor(ColorReferences.COLOR_STOPWATCH), getX() + 32, getY() + 13);
        C0119bk.m437a(poseStack, guiGraphics, C0195cx.f1574aR, getX() + 22, getY() + 13, 8, 8, 0.0f, 1.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    /* JADX INFO: renamed from: a */
    private void m1566a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull C0482iS c0482iS) {
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(c0482iS.getExp());
        boolean zCanPrestige = c0482iS.canPrestige();
        int prestigeLevel = c0482iS.getPrestigeLevel();
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d("textures/misc/ranks/" + rankFromEXP.getTexture() + ".png");
        C0119bk.m370a(font, guiGraphics, (Component) Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).append(Component.literal(rankFromEXP.getTitle()).withColor(zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID)), getX() + 17, getY() + 29);
        C0119bk.m431a(poseStack, guiGraphics, C0195cx.f1572aP, getX(), getY() + 26, 14, 14);
        C0119bk.m431a(poseStack, guiGraphics, resourceLocationM2555d, getX(), getY() + 26, 14, 14);
    }

    /* JADX INFO: renamed from: a */
    private void m1567a(@NotNull GuiGraphics guiGraphics, @NotNull C0482iS c0482iS) {
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(c0482iS.getExp());
        float totalRequiredEXPForRank = (r0 - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired();
        int y = (getY() + this.height) - 16;
        int i = (int) (this.width * totalRequiredEXPForRank);
        int i2 = c0482iS.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0119bk.m415a(guiGraphics, getX(), y, this.width, 1, C0119bk.f726bC);
        C0119bk.m517a(guiGraphics, getX(), y, i, 1);
        C0119bk.m415a(guiGraphics, getX(), y, this.width, 1, i2);
        guiGraphics.disableScissor();
    }

    /* JADX INFO: renamed from: a */
    private void m1568a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0482iS c0482iS, float f) {
        int exp = c0482iS.getExp();
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(exp);
        float fMax = Math.max(0.0f, this.width * ((exp - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired()));
        int y = (getY() + this.height) - 16;
        int i = c0482iS.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        float fSin = Mth.sin(f / 10.0f) * Mth.sin(f / 7.0f) * Mth.sin(f / 5.0f);
        if (exp > 0) {
            C0119bk.m517a(guiGraphics, getX(), getY(), this.width, this.height);
            C0119bk.m446b(poseStack, guiGraphics, C0195cx.f1575aS, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.0f, i);
            C0119bk.m446b(poseStack, guiGraphics, C0195cx.f1575aS, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.5f + fSin, i);
            guiGraphics.disableScissor();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1569a(@NotNull C0622l c0622l, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = this.width + 25;
        C0119bk.m447b(poseStack, guiGraphics, C0195cx.f1576aT, getX() + i, getY() + i2, i3, i3, 0.0f, (0.5f + (((Mth.sin(f / 20.0f) + 1.0f) / 2.0f) * 0.5f)) * c0622l.m2699a().m2596c(1.0f), ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        C0119bk.m491c(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m417a(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.5f);
        C0119bk.m415a(guiGraphics, getX(), getY(), this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, getX(), (getY() + this.height) - 1, this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, getX(), getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, (getX() + this.width) - 1, getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m517a(guiGraphics, getX() + 1, getY() + 1, this.width - 2, this.height - 2);
        C0119bk.m449c(poseStack, guiGraphics, C0564jv.m2555d("textures/gui/gamemode/gamemode_" + c0622l.m2699a().m2584a().getId() + ".png"), getX() + i, getY() + i2, 520.0f, 520.0f, 0.25f, 0.25f);
        float fM366g = C0119bk.m366g() * 3.0f;
        int x = getX() + i;
        int y = getY() + i2;
        poseStack.pushPose();
        poseStack.translate(x, y, 0.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(fM366g));
        C0119bk.m413a(poseStack, 0.0f, 0.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 2);
        C0119bk.m413a(poseStack, 0.0f, -25.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 3);
        poseStack.popPose();
        MutableComponent mutableComponentWithColor = f2250hH.copy().append(Component.literal(" " + c0622l.m2699a().m2586a().toString().toUpperCase(Locale.ROOT))).append(C0116bh.m346a(f)).withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        C0119bk.m415a(guiGraphics, getX(), ((getY() + (this.height / 2)) - 8) + 2, this.width, 16, C0119bk.m365p());
        C0119bk.m399a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, getX() + i, (getY() + (this.height / 2)) - 2);
        guiGraphics.disableScissor();
        float fSin = (Mth.sin(f / 10.0f) + 1.0f) / 2.0f;
        int x2 = getX() + 1;
        int y2 = getY() + 1;
        C0119bk.m417a(guiGraphics, x2, y2, this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0119bk.m417a(guiGraphics, x2, y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0119bk.m417a(guiGraphics, x2 + (this.width - 3), y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0119bk.m417a(guiGraphics, x2, y2 + (this.height - 3), this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        C0482iS c0482iSM1676a = ((C0326fV) c0622lM2667b.m2670a()).m1676a(minecraft);
        boolean zCanPrestige = c0482iSM1676a.canPrestige();
        Optional<MatchParty> party = c0482iSM1676a.getParty();
        boolean z = c0622lM2667b.m2699a().m2597c() || (party.isPresent() && party.get().isSearching());
        float fSin = zCanPrestige ? 0.5f - (Mth.sin(f / 10.0f) / 5.0f) : isHovered() ? 1.0f : 0.0f;
        this.f2254aE = this.f2253aD;
        this.f2253aD = Mth.lerp(0.5f, this.f2253aD, fSin);
        if (isHovered() && !z) {
            if (!this.f2252bE) {
                this.f2252bE = true;
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 2.0f));
                return;
            }
            return;
        }
        if (this.f2252bE) {
            this.f2252bE = false;
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.5f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: E */
    protected boolean mo1520E() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        Optional<MatchParty> party = ((C0326fV) c0622lM2667b.m2670a()).m1676a(minecraft).getParty();
        if (c0622lM2667b.m2699a().m2597c() || (party.isPresent() && party.get().isSearching())) {
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
        minecraft.setScreen(new C0203dE(minecraft.screen));
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        Optional<MatchParty> party = c0482iS.getParty();
        boolean z = c0622l.m2699a().m2597c() || (party.isPresent() && party.get().isSearching());
        GameProfile gameProfile = minecraft.getGameProfile();
        String name = minecraft.getUser().getName();
        if (!z) {
            int i3 = c0482iS.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            C0119bk.m491c(guiGraphics, getX(), getY(), this.width, this.height, C0119bk.m365p());
            int i4 = this.width / 2;
            int i5 = this.height / 2;
            float fM7843e = C1290xm.m7843e(this.f2253aD, this.f2254aE, f2);
            C0119bk.m417a(guiGraphics, getX() - 1, getY() - 1, this.width + 2, 1, i3, fM7843e);
            C0119bk.m417a(guiGraphics, getX() - 1, getY(), 1, this.height, i3, fM7843e);
            C0119bk.m417a(guiGraphics, getX() + this.width, getY(), 1, this.height, i3, fM7843e);
            C0119bk.m417a(guiGraphics, getX() - 1, getY() + this.height, this.width + 2, 1, i3, fM7843e);
            int i6 = this.width;
            C0119bk.m447b(poseStackPose, guiGraphics, C0195cx.f1576aT, getX() + i4, getY() + i5, i6, i6, 0.0f, fM7843e, i3);
        }
        if (z) {
            m1569a(c0622l, font, guiGraphics, poseStackPose, f);
        } else {
            m1565a(minecraft, c0622l, guiGraphics, font, poseStackPose, gameProfile, c0482iS, name, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1522a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        Component componentTranslatable;
        Optional<MatchParty> party = c0482iS.getParty();
        if (c0622l.m2699a().m2597c() || (party.isPresent() && party.get().isSearching())) {
            return List.of();
        }
        int exp = c0482iS.getExp();
        PlayerRank rank = c0482iS.getRank();
        PlayerRank nextRank = PlayerRank.getNextRank(rank.getID());
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank);
        boolean zCanPrestige = c0482iS.canPrestige();
        int totalRequiredEXPForRank2 = PlayerRank.getTotalRequiredEXPForRank(rank);
        int i = zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
        MutableComponent mutableComponentWithColor = Component.literal(C1293xp.m7912a(exp)).withColor(i);
        MutableComponent mutableComponentWithColor2 = Component.literal(C1293xp.m7912a(totalRequiredEXPForRank)).withColor(i);
        MutableComponent mutableComponentWithColor3 = Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE);
        if (zCanPrestige) {
            componentTranslatable = f2249hG;
        } else {
            componentTranslatable = Component.translatable("bf.container.profile.popup.rank", new Object[]{Component.literal(nextRank.getTitle()).withStyle(ChatFormatting.GRAY)});
        }
        MutableComponent mutableComponentAppend = Component.translatable("bf.container.profile.value.exp.progress").append(Component.literal(C1293xp.m7912a(exp - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY)).append(Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE)).append(Component.literal(C1293xp.m7912a(totalRequiredEXPForRank - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY));
        MutableComponent mutableComponentAppend2 = Component.translatable("bf.container.profile.value.exp.total").append(mutableComponentWithColor).append(mutableComponentWithColor3).append(mutableComponentWithColor2);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentAppend);
        int i2 = totalRequiredEXPForRank - exp;
        if (nextRank != rank && i2 > 0) {
            objectArrayList.add(Component.translatable("bf.container.profile.value.exp.remaining").append(Component.literal(C1293xp.m7912a(i2)).withStyle(ChatFormatting.GRAY)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(mutableComponentAppend2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(componentTranslatable);
        return objectArrayList;
    }
}
