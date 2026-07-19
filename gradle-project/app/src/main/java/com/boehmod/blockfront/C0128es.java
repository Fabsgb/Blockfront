package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.mm.MatchParty;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.es, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/es.class */
public final class C0128es extends AbstractC0120ek {

    @NotNull
    private static final Component hG = Component.translatable("bf.container.profile.popup.prestige").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);

    @NotNull
    private static final Component hH = Component.translatable("bf.menu.lobby.searching");
    private static final int id = 16;
    private boolean bE;
    private float aD;
    private float aE;

    public C0128es(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.bE = false;
        this.aE = 0.0f;
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GameProfile gameProfile, @NotNull iS iSVar, @NotNull String str, float f) {
        CloudRegistry cloudRegistryA = c0297l.a();
        String suffixForDisplay = "default";
        iN inventory = iSVar.getInventory();
        CloudItemStack cloudItemStackA = inventory.a(CloudItemType.CARD);
        if (cloudItemStackA != null && cloudItemStackA.getCloudItem(cloudRegistryA) != null) {
            suffixForDisplay = cloudItemStackA.getCloudItem(cloudRegistryA).getSuffixForDisplay();
        }
        C0040bk.a(poseStack, guiGraphics, C0265jv.d("textures/gui/callingcard/" + suffixForDisplay + ".png"), getX(), getY(), this.width, 25, 0.0f, 0.75f);
        C0040bk.a(guiGraphics, getX(), getY() + 26, this.width, 14, C0040bk.p());
        C0040bk.a(guiGraphics, getX(), getY() + 2, this.width, 21, 0, 0.5f);
        MutableComponent mutableComponentEmpty = Component.empty();
        Optional<PlayerGroup> group = iSVar.getGroup();
        if (group.isPresent()) {
            mutableComponentEmpty.append(iP.a(group.get())).append(" ");
        }
        mutableComponentEmpty.append(Component.literal(str).withColor(ColorReferences.COLOR_WHITE));
        C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, gameProfile, getX() + 1, getY() + 3, 19);
        C0040bk.b(font, guiGraphics, (Component) mutableComponentEmpty, getX() + 22, getY() + 4);
        CloudItemStack cloudItemStackA2 = inventory.a(CloudItemType.COIN);
        if (cloudItemStackA2 != null) {
            CloudItem<?> cloudItem = cloudItemStackA2.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA2, poseStack, minecraft, guiGraphics, getX(), getY(), 16.0f, 16.0f, 1.0f);
            }
        }
        a(guiGraphics, font, poseStack, iSVar);
        a(guiGraphics, iSVar);
        a(poseStack, guiGraphics, iSVar, f);
        C0040bk.b(font, guiGraphics, (Component) Component.literal(C0637xp.a(iSVar.getTrophies())).withColor(ColorReferences.COLOR_STOPWATCH), getX() + 32, getY() + 13);
        C0040bk.a(poseStack, guiGraphics, C0080cx.aR, getX() + 22, getY() + 13, 8, 8, 0.0f, 1.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull iS iSVar) {
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(iSVar.getExp());
        boolean zCanPrestige = iSVar.canPrestige();
        int prestigeLevel = iSVar.getPrestigeLevel();
        ResourceLocation resourceLocationD = C0265jv.d("textures/misc/ranks/" + rankFromEXP.getTexture() + ".png");
        C0040bk.a(font, guiGraphics, (Component) Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).append(Component.literal(rankFromEXP.getTitle()).withColor(zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID)), getX() + 17, getY() + 29);
        C0040bk.a(poseStack, guiGraphics, C0080cx.aP, getX(), getY() + 26, 14, 14);
        C0040bk.a(poseStack, guiGraphics, resourceLocationD, getX(), getY() + 26, 14, 14);
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull iS iSVar) {
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(iSVar.getExp());
        float totalRequiredEXPForRank = (r0 - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired();
        int y = (getY() + this.height) - 16;
        int i = (int) (this.width * totalRequiredEXPForRank);
        int i2 = iSVar.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0040bk.a(guiGraphics, getX(), y, this.width, 1, C0040bk.bC);
        C0040bk.a(guiGraphics, getX(), y, i, 1);
        C0040bk.a(guiGraphics, getX(), y, this.width, 1, i2);
        guiGraphics.disableScissor();
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull iS iSVar, float f) {
        int exp = iSVar.getExp();
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(exp);
        float fMax = Math.max(0.0f, this.width * ((exp - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired()));
        int y = (getY() + this.height) - 16;
        int i = iSVar.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        float fSin = Mth.sin(f / 10.0f) * Mth.sin(f / 7.0f) * Mth.sin(f / 5.0f);
        if (exp > 0) {
            C0040bk.a(guiGraphics, getX(), getY(), this.width, this.height);
            C0040bk.b(poseStack, guiGraphics, C0080cx.aS, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.0f, i);
            C0040bk.b(poseStack, guiGraphics, C0080cx.aS, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.5f + fSin, i);
            guiGraphics.disableScissor();
        }
    }

    private void a(@NotNull C0297l c0297l, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = this.width + 25;
        C0040bk.b(poseStack, guiGraphics, C0080cx.aT, getX() + i, getY() + i2, i3, i3, 0.0f, (0.5f + (((Mth.sin(f / 20.0f) + 1.0f) / 2.0f) * 0.5f)) * c0297l.m596a().c(1.0f), ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        C0040bk.c(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.5f);
        C0040bk.a(guiGraphics, getX(), getY(), this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, getX(), (getY() + this.height) - 1, this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, getX(), getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, (getX() + this.width) - 1, getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, getX() + 1, getY() + 1, this.width - 2, this.height - 2);
        C0040bk.c(poseStack, guiGraphics, C0265jv.d("textures/gui/gamemode/gamemode_" + c0297l.m596a().a().getId() + ".png"), getX() + i, getY() + i2, 520.0f, 520.0f, 0.25f, 0.25f);
        float fG = C0040bk.g() * 3.0f;
        int x = getX() + i;
        int y = getY() + i2;
        poseStack.pushPose();
        poseStack.translate(x, y, 0.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(fG));
        C0040bk.a(poseStack, 0.0f, 0.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 2);
        C0040bk.a(poseStack, 0.0f, -25.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 3);
        poseStack.popPose();
        MutableComponent mutableComponentWithColor = hH.copy().append(Component.literal(" " + c0297l.m596a().m543a().toString().toUpperCase(Locale.ROOT))).append(C0037bh.a(f)).withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        C0040bk.a(guiGraphics, getX(), ((getY() + (this.height / 2)) - 8) + 2, this.width, 16, C0040bk.p());
        C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, getX() + i, (getY() + (this.height / 2)) - 2);
        guiGraphics.disableScissor();
        float fSin = (Mth.sin(f / 10.0f) + 1.0f) / 2.0f;
        int x2 = getX() + 1;
        int y2 = getY() + 1;
        C0040bk.a(guiGraphics, x2, y2, this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0040bk.a(guiGraphics, x2, y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0040bk.a(guiGraphics, x2 + (this.width - 3), y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0040bk.a(guiGraphics, x2, y2 + (this.height - 3), this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public void a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        iS iSVarM404a = ((fV) c0297lB.a()).m404a(minecraft);
        boolean zCanPrestige = iSVarM404a.canPrestige();
        Optional<MatchParty> party = iSVarM404a.getParty();
        boolean z = c0297lB.m596a().m544c() || (party.isPresent() && party.get().isSearching());
        float fSin = zCanPrestige ? 0.5f - (Mth.sin(f / 10.0f) / 5.0f) : isHovered() ? 1.0f : 0.0f;
        this.aE = this.aD;
        this.aD = Mth.lerp(0.5f, this.aD, fSin);
        if (isHovered() && !z) {
            if (!this.bE) {
                this.bE = true;
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 2.0f));
                return;
            }
            return;
        }
        if (this.bE) {
            this.bE = false;
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.5f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected boolean E() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        Optional<MatchParty> party = ((fV) c0297lB.a()).m404a(minecraft).getParty();
        if (c0297lB.m596a().m544c() || (party.isPresent() && party.get().isSearching())) {
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
        minecraft.setScreen(new dE(minecraft.screen));
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        Optional<MatchParty> party = iSVar.getParty();
        boolean z = c0297l.m596a().m544c() || (party.isPresent() && party.get().isSearching());
        GameProfile gameProfile = minecraft.getGameProfile();
        String name = minecraft.getUser().getName();
        if (!z) {
            int i3 = iSVar.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            C0040bk.c(guiGraphics, getX(), getY(), this.width, this.height, C0040bk.p());
            int i4 = this.width / 2;
            int i5 = this.height / 2;
            float fE = C0634xm.e(this.aD, this.aE, f2);
            C0040bk.a(guiGraphics, getX() - 1, getY() - 1, this.width + 2, 1, i3, fE);
            C0040bk.a(guiGraphics, getX() - 1, getY(), 1, this.height, i3, fE);
            C0040bk.a(guiGraphics, getX() + this.width, getY(), 1, this.height, i3, fE);
            C0040bk.a(guiGraphics, getX() - 1, getY() + this.height, this.width + 2, 1, i3, fE);
            int i6 = this.width;
            C0040bk.b(poseStackPose, guiGraphics, C0080cx.aT, getX() + i4, getY() + i5, i6, i6, 0.0f, fE, i3);
        }
        if (z) {
            a(c0297l, font, guiGraphics, poseStackPose, f);
        } else {
            a(minecraft, c0297l, guiGraphics, font, poseStackPose, gameProfile, iSVar, name, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    @NotNull
    protected List<Component> a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull iS iSVar) {
        Component componentTranslatable;
        Optional<MatchParty> party = iSVar.getParty();
        if (c0297l.m596a().m544c() || (party.isPresent() && party.get().isSearching())) {
            return List.of();
        }
        int exp = iSVar.getExp();
        PlayerRank rank = iSVar.getRank();
        PlayerRank nextRank = PlayerRank.getNextRank(rank.getID());
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank);
        boolean zCanPrestige = iSVar.canPrestige();
        int totalRequiredEXPForRank2 = PlayerRank.getTotalRequiredEXPForRank(rank);
        int i = zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
        MutableComponent mutableComponentWithColor = Component.literal(C0637xp.a(exp)).withColor(i);
        MutableComponent mutableComponentWithColor2 = Component.literal(C0637xp.a(totalRequiredEXPForRank)).withColor(i);
        MutableComponent mutableComponentWithColor3 = Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE);
        if (zCanPrestige) {
            componentTranslatable = hG;
        } else {
            componentTranslatable = Component.translatable("bf.container.profile.popup.rank", new Object[]{Component.literal(nextRank.getTitle()).withStyle(ChatFormatting.GRAY)});
        }
        MutableComponent mutableComponentAppend = Component.translatable("bf.container.profile.value.exp.progress").append(Component.literal(C0637xp.a(exp - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY)).append(Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE)).append(Component.literal(C0637xp.a(totalRequiredEXPForRank - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY));
        MutableComponent mutableComponentAppend2 = Component.translatable("bf.container.profile.value.exp.total").append(mutableComponentWithColor).append(mutableComponentWithColor3).append(mutableComponentWithColor2);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentAppend);
        int i2 = totalRequiredEXPForRank - exp;
        if (nextRank != rank && i2 > 0) {
            objectArrayList.add(Component.translatable("bf.container.profile.value.exp.remaining").append(Component.literal(C0637xp.a(i2)).withStyle(ChatFormatting.GRAY)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(mutableComponentAppend2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(componentTranslatable);
        return objectArrayList;
    }
}
