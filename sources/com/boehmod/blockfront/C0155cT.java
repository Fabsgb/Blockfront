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

/* JADX INFO: renamed from: com.boehmod.blockfront.cT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cT.class */
public final class C0155cT extends C0130bv {

    /* JADX INFO: renamed from: fu */
    private static final int f1268fu = 16;

    /* JADX INFO: renamed from: fv */
    private static final int f1269fv = 12;

    /* JADX INFO: renamed from: fw */
    private static final int f1270fw = 12;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1091tr f1271a;

    /* JADX INFO: renamed from: bc */
    @NotNull
    private final ResourceLocation f1272bc;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final ObjectList<ResourceLocation> f1273w;

    public C0155cT(int i, int i2, int i3, int i4, @NotNull Screen screen, @NotNull C1091tr c1091tr) {
        super(i, i2, i3, i4, screen);
        this.f1273w = new ObjectArrayList();
        this.f1271a = c1091tr;
        this.f1272bc = C0564jv.m2555d("textures/gui/maps/" + (c1091tr.getName().toLowerCase(Locale.ROOT) + "_" + c1091tr.m6023aq().toLowerCase(Locale.ROOT)) + ".png");
        Iterator<C1019sZ> it = c1091tr.m6025A().iterator();
        while (it.hasNext()) {
            this.f1273w.add(C0564jv.m2555d("textures/misc/flag_" + it.next().m5669ao() + "_12x.png"));
        }
        m683a();
    }

    @Override // com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public void mo687a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0482iS c0482iS, int i, int i2, float f, float f2) {
        super.mo687a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, font, c0482iS, i, i2, f, f2);
        if (c0622l.m2689d()) {
            m707f(false);
        }
        Set<UUID> setM6022h = this.f1271a.m6022h();
        int i3 = this.f942cM / 2;
        int i4 = this.f943cN / 2;
        C0119bk.m493c(guiGraphics, this.f940bm, this.f941bn, this.f942cM, this.f943cN, ColorReferences.COLOR_BLACK_SOLID, 0.5f);
        if (m706q()) {
            C0119bk.m491c(guiGraphics, this.f940bm - 1, this.f941bn - 1, this.f942cM + 2, this.f943cN + 2, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        float f3 = 1.0f + (m706q() ? 0.2f : 0.0f);
        C0119bk.m517a(guiGraphics, this.f940bm, this.f941bn, this.f942cM, this.f943cN);
        C0119bk.m448c(poseStack, guiGraphics, this.f1272bc, this.f940bm + i3, this.f941bn + i4, this.f942cM, this.f943cN, f3);
        guiGraphics.disableScissor();
        C0119bk.m423a(guiGraphics, this.f940bm, this.f941bn + (this.f943cN - 28), this.f942cM, 28, ColorReferences.COLOR_BLACK_TRANSPARENT, -872415232);
        C1016sW c1016sWM5531a = C1016sW.m5531a(m990n());
        String string = c1016sWM5531a != null ? c1016sWM5531a.getDisplayName().getString() : "Unknown";
        MutableComponent mutableComponentWithStyle = Component.literal(m989m()).withStyle(m706q() ? Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID) : Style.EMPTY.withColor(ChatFormatting.WHITE));
        String strM6023aq = this.f1271a.m6023aq();
        if (!strM6023aq.equals("default")) {
            mutableComponentWithStyle.append(" - ").append(Component.translatable("bf.message.environment." + strM6023aq));
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(C1293xp.m7917p(string)).withStyle(ChatFormatting.GRAY);
        C0119bk.m380b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, this.f940bm + 3, this.f941bn + (this.f943cN - 18), m706q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m380b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, this.f940bm + 3, r0 + 8, m706q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        int size = setM6022h.size();
        if (size > 0) {
            C0119bk.m380b(poseStack, font, guiGraphics, (Component) Component.literal(C1293xp.m7912a(size)), ((this.f940bm + this.f942cM) - font.width(r0)) - 2, (this.f941bn + this.f943cN) - 10, m706q() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
        }
        int i5 = 0;
        for (UUID uuid : setM6022h) {
            int i6 = this.f940bm + 3 + (4 * (i5 % 16));
            int i7 = this.f941bn + 3 + (2 * (i5 / 16));
            C0482iS c0482iSA = c0326fV.mo1137a(uuid);
            C0119bk.m415a(guiGraphics, i6 - 1, i7 - 1, 14, 14, C0119bk.m365p());
            C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, c0482iSA.m2195a(), i6, i7, 12);
            i5++;
        }
        int size2 = (14 * this.f1273w.size()) + 2;
        int i8 = ((this.f940bm + this.f942cM) - size2) - 2;
        int i9 = this.f941bn + 2;
        int iM365p = C0119bk.m365p();
        C0119bk.m415a(guiGraphics, i8 + 1, i9, size2 - 2, 1, iM365p);
        C0119bk.m415a(guiGraphics, i8, i9 + 1, size2, 14, iM365p);
        C0119bk.m415a(guiGraphics, i8 + 1, (i9 + 16) - 1, size2 - 2, 1, iM365p);
        for (int i10 = 0; i10 < this.f1273w.size(); i10++) {
            C0119bk.m429a(poseStack, guiGraphics, (ResourceLocation) this.f1273w.get(i10), i8 + (i10 * 14) + 2, i9 + 2, 12);
        }
    }

    @Override // com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public boolean mo691a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, double d, double d2, int i) {
        if (m706q()) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (this.f1271a.m6022h().contains(minecraft.getUser().getProfileId())) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7537oU.get(), 1.0f));
                return true;
            }
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            C1194vo.m6653c(new C1255ww(m989m(), m990n()));
            return true;
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    private String m989m() {
        return this.f1271a.getName();
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    private String m990n() {
        return this.f1271a.m6024ar();
    }
}
