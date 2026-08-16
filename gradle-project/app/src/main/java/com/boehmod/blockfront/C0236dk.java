package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dk.class */
public class C0236dk extends AbstractC0235dj {

    /* JADX INFO: renamed from: dD */
    private static final Component f1909dD = Component.translatable("bf.message.accept");

    /* JADX INFO: renamed from: dE */
    private static final Component f1910dE = Component.translatable("bf.message.decline");

    /* JADX INFO: renamed from: dF */
    private static final Component f1911dF = Component.translatable("bf.message.intro.content.title");

    /* JADX INFO: renamed from: dG */
    private static final Component f1912dG = f1909dD.copy().withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    /* JADX INFO: renamed from: dH */
    private static final Component f1913dH = f1910dE.copy().withColor(ColorReferences.COLOR_THEME_RED_SOLID);

    /* JADX INFO: renamed from: dI */
    private static final Component f1914dI = Component.translatable("bf.message.intro.content.message", new Object[]{f1912dG, f1913dH});

    /* JADX INFO: renamed from: dJ */
    private static final Component f1915dJ = Component.translatable("bf.message.intro.content.tip.accept").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: dK */
    private static final Component f1916dK = Component.translatable("bf.message.intro.content.tip.decline");

    /* JADX INFO: renamed from: bk */
    @NotNull
    public static final ResourceLocation f1917bk = C0532jO.m2378d("textures/gui/background/intro/background_content.png");

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0239dn(f1909dD, button -> {
            C0495ie.f3067T.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1915dJ).m1368a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0239dn(f1910dE, button2 -> {
            ((C0358g) this.f1057f.m2852b()).m1723a(EnumC0411h.UNDECIDED);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1916dK));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return (SoundEvent) C1312xz.f7978pz.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return f1917bk;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m494c(poseStackPose, this.font, guiGraphics, (Component) f1911dF.copy().withStyle(C0533jP.f3185b), i3, i4 - 45, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1914dI, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1359b(guiGraphics, 3, 5);
    }
}
