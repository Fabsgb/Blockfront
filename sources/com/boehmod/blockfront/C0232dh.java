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

/* JADX INFO: renamed from: com.boehmod.blockfront.dh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dh.class */
public class C0232dh extends AbstractC0225da {

    /* JADX INFO: renamed from: ed */
    private static final Component f1902ed = Component.translatable("bf.message.intro.patreon.title");

    /* JADX INFO: renamed from: ee */
    private static final Component f1903ee = Component.translatable("bf.message.intro.patreon.message");

    /* JADX INFO: renamed from: ef */
    private static final Component f1904ef = Component.translatable("bf.message.intro.patreon.visit.button.tip").withColor(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID);

    /* JADX INFO: renamed from: eg */
    private static final Component f1905eg = Component.translatable("bf.message.intro.patreon.skip.button.tip");

    /* JADX INFO: renamed from: eh */
    private static final Component f1906eh = Component.translatable("bf.message.visit");

    /* JADX INFO: renamed from: ei */
    private static final Component f1907ei = Component.translatable("bf.message.skip");

    /* JADX INFO: renamed from: bt */
    @NotNull
    private static final ResourceLocation f1908bt = C0564jv.m2555d("textures/gui/background/intro/background_patreon.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @NotNull
    /* JADX INFO: renamed from: f */
    protected List<C0229de> mo1328f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0229de(f1906eh, button -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3183aC);
            C0424hN.f2768V.m1997x(true);
            C0427hQ.m2004d(this.f1586e);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1904ef).m1342a(ColorReferences.COLOR_THEME_PATREON_SOLID, ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID).m1340a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0229de(f1907ei, button2 -> {
            C0424hN.f2768V.m1997x(true);
            C0427hQ.m2004d(this.f1586e);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1905eg));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1329b() {
        return (SoundEvent) C1280xc.f7570pB.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1330i() {
        return f1908bt;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m394c(poseStackPose, this.font, guiGraphics, (Component) f1902ed.copy().withStyle(C0565jw.f3201b), i3, i4 - 45, 2.0f);
        C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1903ee, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1333b(guiGraphics, 5, 5);
    }
}
