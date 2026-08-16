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

/* JADX INFO: renamed from: com.boehmod.blockfront.dm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dm.class */
public class C0238dm extends AbstractC0235dj {

    /* JADX INFO: renamed from: dR */
    @NotNull
    private static final Component f1925dR = Component.translatable("bf.message.intro.epilepsy.title");

    /* JADX INFO: renamed from: dS */
    @NotNull
    private static final Component f1926dS = Component.translatable("bf.message.intro.epilepsy.message");

    /* JADX INFO: renamed from: dT */
    @NotNull
    private static final Component f1927dT = Component.translatable("bf.message.intro.epilepsy.understand.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: dU */
    @NotNull
    private static final Component f1928dU = Component.translatable("bf.message.understand");

    /* JADX INFO: renamed from: bm */
    @NotNull
    private static final ResourceLocation f1929bm = C0532jO.m2378d("textures/gui/background/intro/background_epilepsy.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0239dn(f1928dU, button -> {
            C0495ie.f3065R.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1927dT).m1368a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return f1929bm;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m494c(poseStackPose, this.font, guiGraphics, (Component) f1925dR.copy().withStyle(C0533jP.f3185b), i3, i4 - 45, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1926dS, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1359b(guiGraphics, 1, 5);
    }
}
