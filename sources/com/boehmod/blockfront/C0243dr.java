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

/* JADX INFO: renamed from: com.boehmod.blockfront.dr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dr.class */
public class C0243dr extends AbstractC0235dj {

    /* JADX INFO: renamed from: el */
    private static final Component f1969el = Component.translatable("bf.message.intro.rules.title");

    /* JADX INFO: renamed from: em */
    private static final Component f1970em = Component.translatable("bf.message.intro.rules.message");

    /* JADX INFO: renamed from: en */
    private static final Component f1971en = Component.translatable("bf.message.intro.accept.rules.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: eo */
    private static final Component f1972eo = Component.translatable("bf.message.intro.rules.button");

    /* JADX INFO: renamed from: ep */
    private static final Component f1973ep = Component.translatable("bf.message.intro.rules.button.tip");

    /* JADX INFO: renamed from: eq */
    private static final Component f1974eq = Component.translatable("bf.message.intro.privacy.button");

    /* JADX INFO: renamed from: er */
    private static final Component f1975er = Component.translatable("bf.message.intro.privacy.button.tip");

    /* JADX INFO: renamed from: es */
    private static final Component f1976es = Component.translatable("bf.message.accept");

    /* JADX INFO: renamed from: bs */
    @NotNull
    public static final ResourceLocation f1977bs = C0532jO.m2378d("textures/gui/background/intro/background_rules.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0239dn(f1976es, button -> {
            C0495ie.f3066S.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1971en).m1368a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0239dn(f1972eo, button2 -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3168aK);
        }).m1367a(f1973ep));
        objectArrayList.add(new C0239dn(f1974eq, button3 -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3169aL);
        }).m1367a(f1975er));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return (SoundEvent) C1312xz.f7979pA.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return f1977bs;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m494c(poseStackPose, this.font, guiGraphics, (Component) f1969el.copy().withStyle(C0533jP.f3185b), i3, i4 - 45, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1970em, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1359b(guiGraphics, 2, 5);
    }
}
