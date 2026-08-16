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

/* JADX INFO: renamed from: com.boehmod.blockfront.dq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dq.class */
public class C0242dq extends AbstractC0235dj {

    /* JADX INFO: renamed from: ef */
    private static final Component f1962ef = Component.translatable("bf.message.intro.patreon.title");

    /* JADX INFO: renamed from: eg */
    private static final Component f1963eg = Component.translatable("bf.message.intro.patreon.message");

    /* JADX INFO: renamed from: eh */
    private static final Component f1964eh = Component.translatable("bf.message.intro.patreon.visit.button.tip").withColor(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID);

    /* JADX INFO: renamed from: ei */
    private static final Component f1965ei = Component.translatable("bf.message.intro.patreon.skip.button.tip");

    /* JADX INFO: renamed from: ej */
    private static final Component f1966ej = Component.translatable("bf.message.visit");

    /* JADX INFO: renamed from: ek */
    private static final Component f1967ek = Component.translatable("bf.message.skip");

    /* JADX INFO: renamed from: br */
    @NotNull
    private static final ResourceLocation f1968br = C0532jO.m2378d("textures/gui/background/intro/background_patreon.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0239dn(f1966ej, button -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3166aI);
            C0495ie.f3069V.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1964eh).m1368a(ColorReferences.COLOR_THEME_PATREON_SOLID, ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0239dn(f1967ek, button2 -> {
            C0495ie.f3069V.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1965ei));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return (SoundEvent) C1312xz.f7982pD.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return f1968br;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m494c(poseStackPose, this.font, guiGraphics, (Component) f1962ef.copy().withStyle(C0533jP.f3185b), i3, i4 - 45, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1963eg, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1359b(guiGraphics, 5, 5);
    }
}
