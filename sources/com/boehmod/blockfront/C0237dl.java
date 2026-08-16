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

/* JADX INFO: renamed from: com.boehmod.blockfront.dl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dl.class */
public class C0237dl extends AbstractC0235dj {

    /* JADX INFO: renamed from: dL */
    @NotNull
    private static final Component f1918dL = Component.translatable("bf.message.intro.discord.title");

    /* JADX INFO: renamed from: dM */
    @NotNull
    private static final Component f1919dM = Component.translatable("bf.message.intro.discord.message");

    /* JADX INFO: renamed from: dN */
    @NotNull
    private static final Component f1920dN = Component.translatable("bf.message.intro.discord.join.button.tip").withColor(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID);

    /* JADX INFO: renamed from: dO */
    @NotNull
    private static final Component f1921dO = Component.translatable("bf.message.intro.discord.skip.button.tip");

    /* JADX INFO: renamed from: dP */
    @NotNull
    private static final Component f1922dP = Component.translatable("bf.message.join.now");

    /* JADX INFO: renamed from: dQ */
    @NotNull
    private static final Component f1923dQ = Component.translatable("bf.message.skip");

    /* JADX INFO: renamed from: bl */
    @NotNull
    private static final ResourceLocation f1924bl = C0532jO.m2378d("textures/gui/background/intro/background_discord.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0239dn(f1922dP, button -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3165aH);
            C0495ie.f3068U.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1920dN).m1368a(ColorReferences.COLOR_THEME_DISCORD_SOLID, ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0239dn(f1923dQ, button2 -> {
            C0495ie.f3068U.m2231x(true);
            C0498ih.m2238e(this.f1057f);
            this.f1058a.setScreen(mo1355b());
        }).m1367a(f1921dO));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return (SoundEvent) C1312xz.f7981pC.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return f1924bl;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m494c(poseStackPose, this.font, guiGraphics, (Component) f1918dL.copy().withStyle(C0533jP.f3185b), i3, i4 - 45, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1919dM, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1359b(guiGraphics, 4, 5);
    }
}
