package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.eF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eF.class */
public final class C0258eF extends AbstractC0302ex {

    /* JADX INFO: renamed from: hP */
    @NotNull
    private static final Component f2119hP = Component.translatable("bf.container.profile.popup.prestige").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID);

    /* JADX INFO: renamed from: hQ */
    @NotNull
    private static final Component f2120hQ = Component.translatable("bf.menu.lobby.searching");

    /* JADX INFO: renamed from: jt */
    private static final int f2121jt = 16;

    /* JADX INFO: renamed from: bL */
    private boolean f2122bL;

    /* JADX INFO: renamed from: aI */
    private float f2123aI;

    /* JADX INFO: renamed from: aJ */
    private float f2124aJ;

    public C0258eF(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2122bL = false;
        this.f2124aJ = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private void m1467a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GameProfile gameProfile, @NotNull C0555jl c0555jl, @NotNull String str, float f) {
        CloudRegistry cloudRegistryA = c0623l.m2855a();
        String suffixForDisplay = "default";
        C0550jg inventory = c0555jl.getInventory();
        CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.CARD);
        if (cloudItemStackM2487a != null && cloudItemStackM2487a.getCloudItem(cloudRegistryA) != null) {
            suffixForDisplay = cloudItemStackM2487a.getCloudItem(cloudRegistryA).getSuffixForDisplay();
        }
        C0129bt.m535a(poseStack, guiGraphics, C0532jO.m2378d("textures/gui/callingcard/" + suffixForDisplay + ".png"), getX(), getY(), this.width, 25, 0.0f, 0.75f);
        C0129bt.m515a(guiGraphics, getX(), getY() + 26, this.width, 14, C0129bt.m465t());
        C0129bt.m517a(guiGraphics, getX(), getY() + 2, this.width, 21, 0, 0.5f);
        MutableComponent mutableComponentEmpty = Component.empty();
        Optional<PlayerGroup> group = c0555jl.getGroup();
        if (group.isPresent()) {
            mutableComponentEmpty.append(C0552ji.m2500a(group.get())).append(" ");
        }
        mutableComponentEmpty.append(Component.literal(str).withColor(ColorReferences.COLOR_WHITE));
        C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, gameProfile, getX() + 1, getY() + 3, 19);
        C0129bt.m479b(font, guiGraphics, (Component) mutableComponentEmpty, getX() + 22, getY() + 4);
        CloudItemStack cloudItemStackM2487a2 = inventory.m2487a(CloudItemType.COIN);
        if (cloudItemStackM2487a2 != null) {
            CloudItem<?> cloudItem = cloudItemStackM2487a2.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a2, poseStack, minecraft, guiGraphics, getX(), getY(), 16.0f, 16.0f, 1.0f);
            }
        }
        m1468a(guiGraphics, font, poseStack, c0555jl);
        m1469a(guiGraphics, c0555jl);
        m1470a(poseStack, guiGraphics, c0555jl, f);
        C0129bt.m479b(font, guiGraphics, (Component) Component.literal(C1273xM.m7239b(c0555jl.getTrophies())).withColor(ColorReferences.COLOR_STOPWATCH), getX() + 32, getY() + 13);
        C0129bt.m537a(poseStack, guiGraphics, C0143cG.f1045aP, getX() + 22, getY() + 13, 8, 8, 0.0f, 1.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    /* JADX INFO: renamed from: a */
    private void m1468a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull C0555jl c0555jl) {
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(c0555jl.getExp());
        boolean zCanPrestige = c0555jl.canPrestige();
        int prestigeLevel = c0555jl.getPrestigeLevel();
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/misc/ranks/" + rankFromEXP.getTexture() + ".png");
        C0129bt.m479b(font, guiGraphics, (Component) Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID).append(Component.literal(rankFromEXP.getTitle()).withColor(zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID)), getX() + 17, getY() + 29);
        C0129bt.m531a(poseStack, guiGraphics, C0143cG.f1044aO, getX(), getY() + 26, 14, 14);
        C0129bt.m531a(poseStack, guiGraphics, resourceLocationM2378d, getX(), getY() + 26, 14, 14);
    }

    /* JADX INFO: renamed from: a */
    private void m1469a(@NotNull GuiGraphics guiGraphics, @NotNull C0555jl c0555jl) {
        int exp = c0555jl.getExp();
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(exp);
        float totalRequiredEXPForRank = (exp - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired();
        int y = (getY() + this.height) - 16;
        int i = (int) (this.width * totalRequiredEXPForRank);
        int i2 = c0555jl.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        C0129bt.m515a(guiGraphics, getX(), y, this.width, 1, C0129bt.f861cu);
        C0129bt.m618a(guiGraphics, getX(), y, i, 1);
        C0129bt.m515a(guiGraphics, getX(), y, this.width, 1, i2);
        guiGraphics.disableScissor();
    }

    /* JADX INFO: renamed from: a */
    private void m1470a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0555jl c0555jl, float f) {
        int exp = c0555jl.getExp();
        PlayerRank rankFromEXP = PlayerRank.getRankFromEXP(exp);
        float fMax = Math.max(0.0f, this.width * ((exp - PlayerRank.getTotalRequiredEXPForRank(rankFromEXP)) / PlayerRank.getNextRank(rankFromEXP.getID()).getEXPRequired()));
        int y = (getY() + this.height) - 16;
        int i = c0555jl.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
        float fSin = Mth.sin(f / 10.0f) * Mth.sin(f / 7.0f) * Mth.sin(f / 5.0f);
        if (exp > 0) {
            C0129bt.m618a(guiGraphics, getX(), getY(), this.width, this.height);
            C0129bt.m546b(poseStack, guiGraphics, C0143cG.f1046aQ, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.0f, i);
            C0129bt.m546b(poseStack, guiGraphics, C0143cG.f1046aQ, getX() + fMax, y + 0.5f, 88.0f, 43.0f, 0.0f, 1.5f + fSin, i);
            guiGraphics.disableScissor();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1471a(@NotNull C0623l c0623l, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = this.width + 25;
        C0129bt.m547b(poseStack, guiGraphics, C0143cG.f1047aR, getX() + i, getY() + i2, i3, i3, 0.0f, (0.5f + (((Mth.sin(f / 20.0f) + 1.0f) / 2.0f) * 0.5f)) * c0623l.m2885a().m2585c(1.0f), ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        C0129bt.m591c(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m517a(guiGraphics, getX(), getY(), this.width, this.height, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.5f);
        C0129bt.m515a(guiGraphics, getX(), getY(), this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m515a(guiGraphics, getX(), (getY() + this.height) - 1, this.width, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m515a(guiGraphics, getX(), getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m515a(guiGraphics, (getX() + this.width) - 1, getY() + 1, 1, this.height - 2, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m618a(guiGraphics, getX() + 1, getY() + 1, this.width - 2, this.height - 2);
        C0129bt.m549c(poseStack, guiGraphics, C0532jO.m2378d("textures/gui/gamemode/gamemode_" + c0623l.m2885a().m2573a().getId() + ".png"), getX() + i, getY() + i2, 520.0f, 520.0f, 0.25f, 0.25f);
        float fM466g = C0129bt.m466g() * 3.0f;
        int x = getX() + i;
        int y = getY() + i2;
        poseStack.pushPose();
        poseStack.translate(x, y, 0.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(fM466g));
        C0129bt.m513a(poseStack, 0.0f, 0.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 2);
        C0129bt.m513a(poseStack, 0.0f, -25.0f, 60.0f, 25.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 3);
        poseStack.popPose();
        MutableComponent mutableComponentWithColor = f2120hQ.copy().append(Component.literal(" " + c0623l.m2885a().m2575a().toString().toUpperCase(Locale.ROOT))).append(C0125bp.m439a(f)).withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        C0129bt.m515a(guiGraphics, getX(), ((getY() + (this.height / 2)) - 8) + 2, this.width, 16, C0129bt.m465t());
        C0129bt.m499a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, getX() + i, (getY() + (this.height / 2)) - 2);
        guiGraphics.disableScissor();
        float fSin = (Mth.sin(f / 10.0f) + 1.0f) / 2.0f;
        int x2 = getX() + 1;
        int y2 = getY() + 1;
        C0129bt.m517a(guiGraphics, x2, y2, this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0129bt.m517a(guiGraphics, x2, y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0129bt.m517a(guiGraphics, x2 + (this.width - 3), y2 + 1, 1, this.height - 4, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
        C0129bt.m517a(guiGraphics, x2, y2 + (this.height - 3), this.width - 2, 1, ColorReferences.COLOR_TEAM_ALLIES_SOLID, fSin);
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
        float f2;
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        C0555jl c0555jlM1886a = ((C0396gl) c0623lM2852b.m2855a()).m1886a(minecraft);
        boolean zCanPrestige = c0555jlM1886a.canPrestige();
        Optional<MatchParty> party = c0555jlM1886a.getParty();
        boolean z = c0623lM2852b.m2885a().m2586c() || (party.isPresent() && party.get().isSearching());
        float fSin = Mth.sin(f / 10.0f);
        if (zCanPrestige) {
            f2 = 0.5f - (fSin / 5.0f);
        } else {
            f2 = isHovered() ? 1.0f : 0.0f;
        }
        this.f2124aJ = this.f2123aI;
        this.f2123aI = Mth.lerp(0.5f, this.f2123aI, f2);
        if (isHovered() && !z) {
            if (!this.f2122bL) {
                this.f2122bL = true;
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 2.0f));
                return;
            }
            return;
        }
        if (this.f2122bL) {
            this.f2122bL = false;
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.5f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: F */
    protected boolean mo1444F() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        Optional<MatchParty> party = ((C0396gl) c0623lM2852b.m2855a()).m1886a(minecraft).getParty();
        if (c0623lM2852b.m2885a().m2586c() || (party.isPresent() && party.get().isSearching())) {
            return;
        }
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
        minecraft.setScreen(new C0215dP(minecraft.screen));
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        Optional<MatchParty> party = c0555jl.getParty();
        boolean z = c0623l.m2885a().m2586c() || (party.isPresent() && party.get().isSearching());
        GameProfile gameProfile = minecraft.getGameProfile();
        String name = minecraft.getUser().getName();
        if (!z) {
            int i3 = c0555jl.canPrestige() ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            C0129bt.m591c(guiGraphics, getX(), getY(), this.width, this.height, C0129bt.m465t());
            int i4 = this.width / 2;
            int i5 = this.height / 2;
            float fM7170f = C1270xJ.m7170f(this.f2123aI, this.f2124aJ, f2);
            C0129bt.m517a(guiGraphics, getX() - 1, getY() - 1, this.width + 2, 1, i3, fM7170f);
            C0129bt.m517a(guiGraphics, getX() - 1, getY(), 1, this.height, i3, fM7170f);
            C0129bt.m517a(guiGraphics, getX() + this.width, getY(), 1, this.height, i3, fM7170f);
            C0129bt.m517a(guiGraphics, getX() - 1, getY() + this.height, this.width + 2, 1, i3, fM7170f);
            int i6 = this.width;
            C0129bt.m547b(poseStackPose, guiGraphics, C0143cG.f1047aR, getX() + i4, getY() + i5, i6, i6, 0.0f, fM7170f, i3);
        }
        if (z) {
            m1471a(c0623l, font, guiGraphics, poseStackPose, f);
        } else {
            m1467a(minecraft, c0623l, guiGraphics, font, poseStackPose, gameProfile, c0555jl, name, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1441a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        Component componentTranslatable;
        Optional<MatchParty> party = c0555jl.getParty();
        if (c0623l.m2885a().m2586c() || (party.isPresent() && party.get().isSearching())) {
            return List.of();
        }
        int exp = c0555jl.getExp();
        PlayerRank rank = c0555jl.getRank();
        PlayerRank nextRank = PlayerRank.getNextRank(rank.getID());
        int totalRequiredEXPForRank = PlayerRank.getTotalRequiredEXPForRank(nextRank);
        boolean zCanPrestige = c0555jl.canPrestige();
        int totalRequiredEXPForRank2 = PlayerRank.getTotalRequiredEXPForRank(rank);
        int i = zCanPrestige ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
        MutableComponent mutableComponentWithColor = Component.literal(C1273xM.m7239b(exp)).withColor(i);
        MutableComponent mutableComponentWithColor2 = Component.literal(C1273xM.m7239b(totalRequiredEXPForRank)).withColor(i);
        MutableComponent mutableComponentWithColor3 = Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE);
        if (zCanPrestige) {
            componentTranslatable = f2119hP;
        } else {
            componentTranslatable = Component.translatable("bf.container.profile.popup.rank", new Object[]{Component.literal(nextRank.getTitle()).withStyle(ChatFormatting.GRAY)});
        }
        MutableComponent mutableComponentAppend = Component.translatable("bf.container.profile.value.exp.progress").append(Component.literal(C1273xM.m7239b(exp - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY)).append(Component.literal(" / ").withColor(ColorReferences.COLOR_WHITE)).append(Component.literal(C1273xM.m7239b(totalRequiredEXPForRank - totalRequiredEXPForRank2)).withStyle(ChatFormatting.GRAY));
        MutableComponent mutableComponentAppend2 = Component.translatable("bf.container.profile.value.exp.total").append(mutableComponentWithColor).append(mutableComponentWithColor3).append(mutableComponentWithColor2);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(mutableComponentAppend);
        int i2 = totalRequiredEXPForRank - exp;
        if (nextRank != rank && i2 > 0) {
            objectArrayList.add(Component.translatable("bf.container.profile.value.exp.remaining").append(Component.literal(C1273xM.m7239b(i2)).withStyle(ChatFormatting.GRAY)));
        }
        objectArrayList.add(Component.empty());
        objectArrayList.add(mutableComponentAppend2);
        objectArrayList.add(Component.empty());
        objectArrayList.add(componentTranslatable);
        return objectArrayList;
    }
}
