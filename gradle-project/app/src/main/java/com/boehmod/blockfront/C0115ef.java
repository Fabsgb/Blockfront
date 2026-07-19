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

/* JADX INFO: renamed from: com.boehmod.blockfront.ef, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ef.class */
public final class C0115ef extends AbstractC0116eg {
    private static final ResourceLocation ch = C0265jv.d("textures/gui/scoreboard/trophy_gold.png");
    private static final ResourceLocation ci = C0265jv.d("textures/gui/scoreboard/trophy_silver.png");
    private static final ResourceLocation cj = C0265jv.d("textures/gui/scoreboard/trophy_bronze.png");

    @NotNull
    private final a a;

    @NotNull
    private final UUID i;
    private final int hG;
    private final int hH;
    private boolean bQ = false;
    private boolean bE = false;

    /* JADX INFO: renamed from: com.boehmod.blockfront.ef$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ef$a.class */
    public enum a {
        CLAN,
        PLAYER
    }

    public C0115ef(@NotNull UUID uuid, int i, int i2, @NotNull a aVar) {
        this.i = uuid;
        this.hG = i;
        this.hH = i2;
        this.a = aVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) throws MatchException {
        MutableComponent mutableComponentB;
        super.a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        if (D()) {
            if (!this.bE) {
                this.bE = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 2.0f));
            }
        } else {
            this.bE = false;
        }
        int i3 = this.hI + 3;
        int i4 = this.hJ + 3;
        int iMo265t = mo265t() - 4;
        int iHeight = height() - 3;
        C0040bk.c(guiGraphics, i3, i4, iMo265t, iHeight, C0040bk.p());
        if (this.bQ) {
            C0040bk.a(guiGraphics, i3, i4, iMo265t, iHeight, 301989887);
        }
        int i5 = 16777215;
        int i6 = 587202559;
        if (this.hH == 1) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -13995;
        } else if (this.hH == 2) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -3419944;
        } else if (this.hH == 3) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -4096689;
        }
        MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(this.hH)).withColor(i5);
        C0040bk.a(guiGraphics, i3, i4, 13, iHeight, i6);
        C0040bk.c(font, guiGraphics, (Component) mutableComponentWithColor, i3 + 7, i4 + 5);
        int i7 = 0;
        if (this.a == a.PLAYER) {
            i7 = 0 + iHeight + 2;
            C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, fVVar.mo306a(this.i).m491a(), i3 + 13 + 1, i4, iHeight);
        }
        switch (this.a) {
            case CLAN:
                mutableComponentB = iL.a(fVVar.mo306a(this.i));
                break;
            case PLAYER:
                mutableComponentB = fVVar.mo306a(this.i).b();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        MutableComponent mutableComponentWithColor2 = mutableComponentB;
        if (D()) {
            mutableComponentWithColor2 = Component.literal(mutableComponentWithColor2.getString()).withColor(ColorReferences.COLOR_THEME_YELLOW);
        }
        C0040bk.a(font, guiGraphics, (Component) mutableComponentWithColor2, i3 + i7 + 13 + 2, i4 + 5);
        C0040bk.a(font, guiGraphics, (Component) Component.literal(C0637xp.a(this.hG)).withStyle(ChatFormatting.GREEN), i3 + C0163g.g, i4 + 5);
        int i8 = iHeight - 4;
        int i9 = ((i3 + iMo265t) - i8) - 2;
        int i10 = i4 + 2;
        ResourceLocation resourceLocation = null;
        switch (this.hH) {
            case 1:
                resourceLocation = ch;
                break;
            case 2:
                resourceLocation = ci;
                break;
            case 3:
                resourceLocation = cj;
                break;
        }
        if (resourceLocation != null) {
            C0040bk.a(poseStack, guiGraphics, resourceLocation, i9, i10, i8, i8);
        }
    }

    @NotNull
    public C0115ef a(boolean z) {
        this.bQ = z;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return this.a == a.PLAYER;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        if (this.a == a.PLAYER) {
            iS iSVarA = fVVar.mo306a(this.i);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 2.0f));
            minecraft.setScreen(new dE(this.a.a(), iSVarA));
            return;
        }
        super.a(minecraft, c0297l, fVVar, i, i2, i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return this.a.t() - 15;
    }
}
