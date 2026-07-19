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

/* JADX INFO: renamed from: com.boehmod.blockfront.db, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/db.class */
public class C0085db extends AbstractC0084da {
    private static final Component dB = Component.translatable("bf.message.accept");
    private static final Component dC = Component.translatable("bf.message.decline");
    private static final Component dD = Component.translatable("bf.message.intro.content.title");
    private static final Component dE = dB.copy().withColor(ColorReferences.COLOR_TEAM_ALLIES_SOLID);
    private static final Component dF = dC.copy().withColor(ColorReferences.COLOR_THEME_RED_SOLID);
    private static final Component dG = Component.translatable("bf.message.intro.content.message", new Object[]{dE, dF});
    private static final Component dH = Component.translatable("bf.message.intro.content.tip.accept").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);
    private static final Component dI = Component.translatable("bf.message.intro.content.tip.decline");

    @NotNull
    public static final ResourceLocation bm = C0265jv.d("textures/gui/background/intro/background_content.png");

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0088de(dB, button -> {
            hN.T.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(dH).a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0088de(dC, button2 -> {
            ((C0163g) this.e.b()).a(EnumC0190h.UNDECIDED);
            this.b.setScreen(b());
        }).a(dI));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return (SoundEvent) C0624xc.px.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return bm;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) dD.copy().withStyle(C0266jw.b), i3, i4 - 45, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(dG, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        b(guiGraphics, 3, 5);
    }
}
