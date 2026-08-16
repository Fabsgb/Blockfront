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

/* JADX INFO: renamed from: com.boehmod.blockfront.es */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/es.class */
public final class C0297es extends AbstractC0298et {

    /* JADX INFO: renamed from: cg */
    private static final ResourceLocation f2327cg = C0532jO.m2378d("textures/gui/scoreboard/trophy_gold.png");

    /* JADX INFO: renamed from: ch */
    private static final ResourceLocation f2328ch = C0532jO.m2378d("textures/gui/scoreboard/trophy_silver.png");

    /* JADX INFO: renamed from: ci */
    private static final ResourceLocation f2329ci = C0532jO.m2378d("textures/gui/scoreboard/trophy_bronze.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f2330a;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final UUID f2331i;

    /* JADX INFO: renamed from: iW */
    private final int f2332iW;

    /* JADX INFO: renamed from: iX */
    private final int f2333iX;

    /* JADX INFO: renamed from: bZ */
    private boolean f2334bZ = false;

    /* JADX INFO: renamed from: bL */
    private boolean f2335bL = false;

    /* JADX INFO: renamed from: com.boehmod.blockfront.es$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/es$a.class */
    public enum a {
        CLAN,
        PLAYER
    }

    public C0297es(@NotNull UUID uuid, int i, int i2, @NotNull a aVar) {
        this.f2331i = uuid;
        this.f2332iW = i;
        this.f2333iX = i2;
        this.f2330a = aVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) throws MatchException {
        MutableComponent mutableComponentM2515b;
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        if (m1615E()) {
            if (!this.f2335bL) {
                this.f2335bL = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 2.0f));
            }
        } else {
            this.f2335bL = false;
        }
        int i3 = this.f2339iY + 3;
        int i4 = this.f2340iZ + 3;
        int iMo866x = mo866x() - 4;
        int iHeight = height() - 3;
        C0129bt.m591c(guiGraphics, i3, i4, iMo866x, iHeight, C0129bt.m465t());
        if (this.f2334bZ) {
            C0129bt.m515a(guiGraphics, i3, i4, iMo866x, iHeight, 301989887);
        }
        int i5 = 16777215;
        int i6 = 587202559;
        if (this.f2333iX == 1) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -13995;
        } else if (this.f2333iX == 2) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -3419944;
        } else if (this.f2333iX == 3) {
            i5 = ColorReferences.COLOR_BLACK_SOLID;
            i6 = -4096689;
        }
        MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(this.f2333iX)).withColor(i5);
        C0129bt.m515a(guiGraphics, i3, i4, 13, iHeight, i6);
        C0129bt.m483c(font, guiGraphics, (Component) mutableComponentWithColor, i3 + 7, i4 + 5);
        int i7 = 0;
        if (this.f2330a == a.PLAYER) {
            i7 = 0 + iHeight + 2;
            C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, c0396gl.mo1154a(this.f2331i).m2522a(), i3 + 13 + 1, i4, iHeight);
        }
        switch (this.f2330a) {
            case CLAN:
                mutableComponentM2515b = C0548je.m2478a(c0396gl.mo1154a(this.f2331i));
                break;
            case PLAYER:
                mutableComponentM2515b = c0396gl.mo1154a(this.f2331i).m2515b();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        MutableComponent mutableComponentWithColor2 = mutableComponentM2515b;
        if (m1615E()) {
            mutableComponentWithColor2 = Component.literal(mutableComponentWithColor2.getString()).withColor(ColorReferences.COLOR_THEME_YELLOW);
        }
        C0129bt.m470a(font, guiGraphics, (Component) mutableComponentWithColor2, i3 + i7 + 13 + 2, i4 + 5);
        C0129bt.m470a(font, guiGraphics, (Component) Component.literal(C1273xM.m7239b(this.f2332iW)).withStyle(ChatFormatting.GREEN), i3 + C0358g.f2490g, i4 + 5);
        int i8 = iHeight - 4;
        int i9 = ((i3 + iMo866x) - i8) - 2;
        int i10 = i4 + 2;
        ResourceLocation resourceLocation = null;
        switch (this.f2333iX) {
            case 1:
                resourceLocation = f2327cg;
                break;
            case 2:
                resourceLocation = f2328ch;
                break;
            case 3:
                resourceLocation = f2329ci;
                break;
        }
        if (resourceLocation != null) {
            C0129bt.m531a(poseStack, guiGraphics, resourceLocation, i9, i10, i8, i8);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0297es m1610a(boolean z) {
        this.f2334bZ = z;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return this.f2330a == a.PLAYER;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        if (this.f2330a == a.PLAYER) {
            C0555jl c0555jlA = c0396gl.mo1154a(this.f2331i);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 2.0f));
            minecraft.setScreen(new C0215dP(this.f2338a.m358a(), c0555jlA));
            return;
        }
        super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x() - 15;
    }
}
