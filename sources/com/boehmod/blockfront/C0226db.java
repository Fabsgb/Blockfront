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

/* JADX INFO: renamed from: com.boehmod.blockfront.db */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/db.class */
public class C0226db extends AbstractC0225da {

    /* JADX INFO: renamed from: dB */
    private static final Component f1849dB = Component.translatable("bf.message.accept");

    /* JADX INFO: renamed from: dC */
    private static final Component f1850dC = Component.translatable("bf.message.decline");

    /* JADX INFO: renamed from: dD */
    private static final Component f1851dD = Component.translatable("bf.message.intro.content.title");

    /* JADX INFO: renamed from: dE */
    private static final Component f1852dE = f1849dB.copy().withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);

    /* JADX INFO: renamed from: dF */
    private static final Component f1853dF = f1850dC.copy().withColor(ColorReferences.COLOR_THEME_RED_SOLID);

    /* JADX INFO: renamed from: dG */
    private static final Component f1854dG = Component.translatable("bf.message.intro.content.message", new Object[]{f1852dE, f1853dF});

    /* JADX INFO: renamed from: dH */
    private static final Component f1855dH = Component.translatable("bf.message.intro.content.tip.accept").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: dI */
    private static final Component f1856dI = Component.translatable("bf.message.intro.content.tip.decline");

    /* JADX INFO: renamed from: bm */
    @NotNull
    public static final ResourceLocation f1857bm = C0564jv.m2555d("textures/gui/background/intro/background_content.png");

    @Override // com.boehmod.blockfront.AbstractC0225da
    @NotNull
    /* JADX INFO: renamed from: f */
    protected List<C0229de> mo1328f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0229de(f1849dB, button -> {
            C0424hN.f2766T.m1997x(true);
            C0427hQ.m2004d(this.f1586e);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1855dH).m1342a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1340a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0229de(f1850dC, button2 -> {
            ((C0357g) this.f1586e.m2667b()).m1717a(EnumC0410h.UNDECIDED);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1856dI));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1329b() {
        return (SoundEvent) C1280xc.f7566px.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1330i() {
        return f1857bm;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m394c(poseStackPose, this.font, guiGraphics, (Component) f1851dD.copy().withStyle(C0565jw.f3201b), i3, i4 - 45, 2.0f);
        C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1854dG, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1333b(guiGraphics, 3, 5);
    }
}
