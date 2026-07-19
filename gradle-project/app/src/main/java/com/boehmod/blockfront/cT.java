package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cT.class */
public final class cT extends C0051bv {
    private static final int fu = 16;
    private static final int fv = 12;
    private static final int fw = 12;

    @NotNull
    private final C0531tr a;

    @NotNull
    private final ResourceLocation bc;

    @NotNull
    private final ObjectList<ResourceLocation> w;

    public cT(int i, int i2, int i3, int i4, @NotNull Screen screen, @NotNull C0531tr c0531tr) {
        super(i, i2, i3, i4, screen);
        this.w = new ObjectArrayList();
        this.a = c0531tr;
        this.bc = C0265jv.d("textures/gui/maps/" + (c0531tr.getName().toLowerCase(Locale.ROOT) + "_" + c0531tr.aq().toLowerCase(Locale.ROOT)) + ".png");
        Iterator<sZ> it = c0531tr.A().iterator();
        while (it.hasNext()) {
            this.w.add(C0265jv.d("textures/misc/flag_" + it.next().ao() + "_12x.png"));
        }
        a();
    }

    @Override // com.boehmod.blockfront.C0051bv
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull iS iSVar, int i, int i2, float f, float f2) {
        super.a(minecraft, c0297l, fVVar, poseStack, guiGraphics, font, iSVar, i, i2, f, f2);
        if (c0297l.m592d()) {
            f(false);
        }
        Set<UUID> setH = this.a.h();
        int i3 = this.cM / 2;
        int i4 = this.cN / 2;
        C0040bk.c(guiGraphics, this.bm, this.bn, this.cM, this.cN, ColorReferences.COLOR_BLACK_SOLID, 0.5f);
        if (q()) {
            C0040bk.c(guiGraphics, this.bm - 1, this.bn - 1, this.cM + 2, this.cN + 2, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        float f3 = 1.0f + (q() ? 0.2f : 0.0f);
        C0040bk.a(guiGraphics, this.bm, this.bn, this.cM, this.cN);
        C0040bk.c(poseStack, guiGraphics, this.bc, this.bm + i3, this.bn + i4, this.cM, this.cN, f3);
        guiGraphics.disableScissor();
        C0040bk.a(guiGraphics, this.bm, this.bn + (this.cN - 28), this.cM, 28, ColorReferences.COLOR_BLACK_TRANSPARENT, -872415232);
        sW sWVarA = sW.a(n());
        String string = sWVarA != null ? sWVarA.getDisplayName().getString() : "Unknown";
        MutableComponent mutableComponentWithStyle = Component.literal(m()).withStyle(q() ? Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID) : Style.EMPTY.withColor(ChatFormatting.WHITE));
        String strAq = this.a.aq();
        if (!strAq.equals("default")) {
            mutableComponentWithStyle.append(" - ").append(Component.translatable("bf.message.environment." + strAq));
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(C0637xp.p(string)).withStyle(ChatFormatting.GRAY);
        C0040bk.b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.bm + 3, this.bn + (this.cN - 18), q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, this.bm + 3, r0 + 8, q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        int size = setH.size();
        if (size > 0) {
            C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal(C0637xp.a(size)), ((this.bm + this.cM) - font.width(r0)) - 2, (this.bn + this.cN) - 10, q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        }
        int i5 = 0;
        for (UUID uuid : setH) {
            int i6 = this.bm + 3 + (4 * (i5 % 16));
            int i7 = this.bn + 3 + (2 * (i5 / 16));
            iS iSVarA = fVVar.mo306a(uuid);
            C0040bk.a(guiGraphics, i6 - 1, i7 - 1, 14, 14, C0040bk.p());
            C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, iSVarA.m491a(), i6, i7, 12);
            i5++;
        }
        int size2 = (14 * this.w.size()) + 2;
        int i8 = ((this.bm + this.cM) - size2) - 2;
        int i9 = this.bn + 2;
        int iP = C0040bk.p();
        C0040bk.a(guiGraphics, i8 + 1, i9, size2 - 2, 1, iP);
        C0040bk.a(guiGraphics, i8, i9 + 1, size2, 14, iP);
        C0040bk.a(guiGraphics, i8 + 1, (i9 + 16) - 1, size2 - 2, 1, iP);
        for (int i10 = 0; i10 < this.w.size(); i10++) {
            C0040bk.a(poseStack, guiGraphics, (ResourceLocation) this.w.get(i10), i8 + (i10 * 14) + 2, i9 + 2, 12);
        }
    }

    @Override // com.boehmod.blockfront.C0051bv
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, double d, double d2, int i) {
        if (q()) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.a.h().contains(minecraft.getUser().getProfileId())) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oU.get(), 1.0f));
                return true;
            }
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            C0582vo.c(new C0617ww(m(), n()));
            return true;
        }
        return false;
    }

    @NotNull
    private String m() {
        return this.a.getName();
    }

    @NotNull
    private String n() {
        return this.a.ar();
    }
}
