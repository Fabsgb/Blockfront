package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ef */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ef.class */
public final class C0283ef extends AbstractC0284eg {

    /* JADX INFO: renamed from: ch */
    private static final ResourceLocation f2154ch = C0564jv.m2555d("textures/gui/scoreboard/trophy_gold.png");

    /* JADX INFO: renamed from: ci */
    private static final ResourceLocation f2155ci = C0564jv.m2555d("textures/gui/scoreboard/trophy_silver.png");

    /* JADX INFO: renamed from: cj */
    private static final ResourceLocation f2156cj = C0564jv.m2555d("textures/gui/scoreboard/trophy_bronze.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f2157a;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final UUID f2158i;

    /* JADX INFO: renamed from: hG */
    private final int f2159hG;

    /* JADX INFO: renamed from: hH */
    private final int f2160hH;

    /* JADX INFO: renamed from: bQ */
    private boolean f2161bQ = false;

    /* JADX INFO: renamed from: bE */
    private boolean f2162bE = false;

    /* JADX INFO: renamed from: com.boehmod.blockfront.ef$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ef$a.class */
    public enum a {
        CLAN,
        PLAYER
    }

    public C0283ef(@NotNull UUID uuid, int i, int i2, @NotNull a aVar) {
        this.f2158i = uuid;
        this.f2159hG = i;
        this.f2160hH = i2;
        this.f2157a = aVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) throws MatchException {
        MutableComponent mutableComponentM2188b;
        super.mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        if (m1499D()) {
            if (!this.f2162bE) {
                this.f2162bE = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 2.0f));
            }
        } else {
            this.f2162bE = false;
        }
        int i3 = this.f2166hI + 3;
        int i4 = this.f2167hJ + 3;
        int iMo812t = mo812t() - 4;
        int iHeight = height() - 3;
        C0119bk.m491c(guiGraphics, i3, i4, iMo812t, iHeight, C0119bk.m365p());
        if (this.f2161bQ) {
            C0119bk.m415a(guiGraphics, i3, i4, iMo812t, iHeight, 301989887);
        }
        int i5 = 16777215;
        int i6 = 587202559;
        if (this.f2160hH == 1) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -13995;
        } else if (this.f2160hH == 2) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -3419944;
        } else if (this.f2160hH == 3) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -4096689;
        }
        MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(this.f2160hH)).withColor(i5);
        C0119bk.m415a(guiGraphics, i3, i4, 13, iHeight, i6);
        C0119bk.m383c(font, guiGraphics, (Component) mutableComponentWithColor, i3 + 7, i4 + 5);
        int i7 = 0;
        if (this.f2157a == a.PLAYER) {
            i7 = 0 + iHeight + 2;
            C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, c0326fV.mo1137a(this.f2158i).m2195a(), i3 + 13 + 1, i4, iHeight);
        }
        switch (this.f2157a) {
            case CLAN:
                mutableComponentM2188b = C0475iL.m2151a(c0326fV.mo1137a(this.f2158i));
                break;
            case PLAYER:
                mutableComponentM2188b = c0326fV.mo1137a(this.f2158i).m2188b();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        MutableComponent mutableComponentWithColor2 = mutableComponentM2188b;
        if (m1499D()) {
            mutableComponentWithColor2 = Component.literal(mutableComponentWithColor2.getString()).withColor(ColorReferences.COLOR_THEME_YELLOW);
        }
        C0119bk.m370a(font, guiGraphics, (Component) mutableComponentWithColor2, i3 + i7 + 13 + 2, i4 + 5);
        C0119bk.m370a(font, guiGraphics, (Component) Component.literal(C1293xp.m7912a(this.f2159hG)).withStyle(ChatFormatting.GREEN), i3 + C0357g.f2439g, i4 + 5);
        int i8 = iHeight - 4;
        int i9 = ((i3 + iMo812t) - i8) - 2;
        int i10 = i4 + 2;
        ResourceLocation resourceLocation = null;
        switch (this.f2160hH) {
            case 1:
                resourceLocation = f2154ch;
                break;
            case 2:
                resourceLocation = f2155ci;
                break;
            case 3:
                resourceLocation = f2156cj;
                break;
        }
        if (resourceLocation != null) {
            C0119bk.m431a(poseStack, guiGraphics, resourceLocation, i9, i10, i8, i8);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0283ef m1494a(boolean z) {
        this.f2161bQ = z;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return this.f2157a == a.PLAYER;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        if (this.f2157a == a.PLAYER) {
            C0482iS c0482iSA = c0326fV.mo1137a(this.f2158i);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 2.0f));
            minecraft.setScreen(new C0203dE(this.f2165a.m683a(), c0482iSA));
            return;
        }
        super.mo817a(minecraft, c0622l, c0326fV, i, i2, i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f2165a.m699t() - 15;
    }
}
