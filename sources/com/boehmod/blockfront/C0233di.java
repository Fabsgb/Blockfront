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

/* JADX INFO: renamed from: com.boehmod.blockfront.di */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/di.class */
public class C0233di extends AbstractC0225da {

    /* JADX INFO: renamed from: ej */
    private static final Component f1909ej = Component.translatable("bf.message.intro.rules.title");

    /* JADX INFO: renamed from: ek */
    private static final Component f1910ek = Component.translatable("bf.message.intro.rules.message");

    /* JADX INFO: renamed from: el */
    private static final Component f1911el = Component.translatable("bf.message.intro.accept.rules.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: em */
    private static final Component f1912em = Component.translatable("bf.message.intro.rules.button");

    /* JADX INFO: renamed from: en */
    private static final Component f1913en = Component.translatable("bf.message.intro.rules.button.tip");

    /* JADX INFO: renamed from: eo */
    private static final Component f1914eo = Component.translatable("bf.message.intro.privacy.button");

    /* JADX INFO: renamed from: ep */
    private static final Component f1915ep = Component.translatable("bf.message.intro.privacy.button.tip");

    /* JADX INFO: renamed from: eq */
    private static final Component f1916eq = Component.translatable("bf.message.accept");

    /* JADX INFO: renamed from: bu */
    @NotNull
    public static final ResourceLocation f1917bu = C0564jv.m2555d("textures/gui/background/intro/background_rules.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @NotNull
    /* JADX INFO: renamed from: f */
    protected List<C0229de> mo1328f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0229de(f1916eq, button -> {
            C0424hN.f2765S.m1997x(true);
            C0427hQ.m2004d(this.f1586e);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1911el).m1342a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1340a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0229de(f1912em, button2 -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3185aE);
        }).m1341a(f1913en));
        objectArrayList.add(new C0229de(f1914eo, button3 -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3186aF);
        }).m1341a(f1915ep));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1329b() {
        return (SoundEvent) C1280xc.f7567py.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1330i() {
        return f1917bu;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m394c(poseStackPose, this.font, guiGraphics, (Component) f1909ej.copy().withStyle(C0565jw.f3201b), i3, i4 - 45, 2.0f);
        C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1910ek, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1333b(guiGraphics, 2, 5);
    }
}
