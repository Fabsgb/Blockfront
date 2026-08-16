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

/* JADX INFO: renamed from: com.boehmod.blockfront.dc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dc.class */
public final class C0228dc extends C0088bE {

    /* JADX INFO: renamed from: gu */
    private static final int f1839gu = 16;

    /* JADX INFO: renamed from: gv */
    private static final int f1840gv = 12;

    /* JADX INFO: renamed from: gw */
    private static final int f1841gw = 12;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1064tP f1842a;

    /* JADX INFO: renamed from: ba */
    @NotNull
    private final ResourceLocation f1843ba;

    /* JADX INFO: renamed from: F */
    @NotNull
    private final ObjectList<ResourceLocation> f1844F;

    public C0228dc(int i, int i2, int i3, int i4, @NotNull Screen screen, @NotNull C1064tP c1064tP) {
        super(i, i2, i3, i4, screen);
        this.f1844F = new ObjectArrayList();
        this.f1842a = c1064tP;
        this.f1843ba = C0532jO.m2378d("textures/gui/maps/" + (c1064tP.getName().toLowerCase(Locale.ROOT) + "_" + c1064tP.m5909ax().toLowerCase(Locale.ROOT)) + ".png");
        Iterator<C1097tw> it = c1064tP.m5911C().iterator();
        while (it.hasNext()) {
            this.f1844F.add(C0532jO.m2378d("textures/misc/flag_" + it.next().m6157av() + "_12x.png"));
        }
        m358a();
    }

    @Override // com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public void mo362a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0555jl c0555jl, int i, int i2, float f, float f2) {
        super.mo362a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, font, c0555jl, i, i2, f, f2);
        if (c0623l.m2875d()) {
            m382f(false);
        }
        Set<UUID> setM5908h = this.f1842a.m5908h();
        int i3 = this.f581dE / 2;
        int i4 = this.f582dF / 2;
        C0129bt.m593c(guiGraphics, this.f579cc, this.f580cd, this.f581dE, this.f582dF, ColorReferences.COLOR_BLACK_SOLID, 0.5f);
        if (m1345r()) {
            C0129bt.m591c(guiGraphics, this.f579cc - 1, this.f580cd - 1, this.f581dE + 2, this.f582dF + 2, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        float f3 = 1.0f + (m1345r() ? 0.2f : 0.0f);
        C0129bt.m618a(guiGraphics, this.f579cc, this.f580cd, this.f581dE, this.f582dF);
        C0129bt.m548c(poseStack, guiGraphics, this.f1843ba, this.f579cc + i3, this.f580cd + i4, this.f581dE, this.f582dF, f3);
        guiGraphics.disableScissor();
        C0129bt.m523a(guiGraphics, this.f579cc, this.f580cd + (this.f582dF - 28), this.f581dE, 28, ColorReferences.COLOR_BLACK_TRANSPARENT, -872415232);
        C1094tt c1094ttM6019a = C1094tt.m6019a(m1345r());
        String string = c1094ttM6019a != null ? c1094ttM6019a.getDisplayName().getString() : "Unknown";
        MutableComponent mutableComponentWithStyle = Component.literal(m1344q()).withStyle(m1345r() ? Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID) : Style.EMPTY.withColor(ChatFormatting.WHITE));
        String strM5909ax = this.f1842a.m5909ax();
        if (!strM5909ax.equals("default")) {
            mutableComponentWithStyle.append(" - ").append(Component.translatable("bf.message.environment." + strM5909ax));
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(C1273xM.m7244p(string)).withStyle(ChatFormatting.GRAY);
        int i5 = this.f580cd + (this.f582dF - 18);
        C0129bt.m480b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f579cc + 3, i5, m1345r() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m480b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, this.f579cc + 3, i5 + 8, m1345r() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        int size = setM5908h.size();
        if (size > 0) {
            MutableComponent mutableComponentLiteral = Component.literal(C1273xM.m7239b(size));
            C0129bt.m480b(poseStack, font, guiGraphics, (Component) mutableComponentLiteral, ((this.f579cc + this.f581dE) - font.width(mutableComponentLiteral)) - 2, (this.f580cd + this.f582dF) - 10, m1345r() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        }
        int i6 = 0;
        for (UUID uuid : setM5908h) {
            int i7 = this.f579cc + 3 + (4 * (i6 % 16));
            int i8 = this.f580cd + 3 + (2 * (i6 / 16));
            C0555jl c0555jlA = c0396gl.mo1154a(uuid);
            C0129bt.m515a(guiGraphics, i7 - 1, i8 - 1, 14, 14, C0129bt.m465t());
            C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, c0555jlA.m2522a(), i7, i8, 12);
            i6++;
        }
        int size2 = (14 * this.f1844F.size()) + 2;
        int i9 = ((this.f579cc + this.f581dE) - size2) - 2;
        int i10 = this.f580cd + 2;
        C0129bt.m518b(guiGraphics, i9, i10, size2, 16, C0129bt.m465t());
        for (int i11 = 0; i11 < this.f1844F.size(); i11++) {
            C0129bt.m529a(poseStack, guiGraphics, (ResourceLocation) this.f1844F.get(i11), i9 + (i11 * 14) + 2, i10 + 2, 12);
        }
    }

    @Override // com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public boolean mo366a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, double d, double d2, int i) {
        if (m1345r()) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.f1842a.m5908h().contains(minecraft.getUser().getProfileId())) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7949oW.get(), 1.0f));
                return true;
            }
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            C1169vO.m6648c(new C1228wU(m1344q(), m1345r()));
            return true;
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    private String m1344q() {
        return this.f1842a.getName();
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    private String m1345r() {
        return this.f1842a.m5910ay();
    }
}
