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

/* JADX INFO: renamed from: com.boehmod.blockfront.dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dh.class */
public class C0091dh extends AbstractC0084da {
    private static final Component ed = Component.translatable("bf.message.intro.patreon.title");
    private static final Component ee = Component.translatable("bf.message.intro.patreon.message");
    private static final Component ef = Component.translatable("bf.message.intro.patreon.visit.button.tip").withColor(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID);
    private static final Component eg = Component.translatable("bf.message.intro.patreon.skip.button.tip");
    private static final Component eh = Component.translatable("bf.message.visit");
    private static final Component ei = Component.translatable("bf.message.skip");

    @NotNull
    private static final ResourceLocation bt = C0265jv.d("textures/gui/background/intro/background_patreon.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0088de(eh, button -> {
            C0093dj.b(this.b, C0261jr.aC);
            hN.V.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(ef).a(ColorReferences.COLOR_THEME_PATREON_SOLID, ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0088de(ei, button2 -> {
            hN.V.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(eg));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return (SoundEvent) C0624xc.pB.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return bt;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) ed.copy().withStyle(C0266jw.b), i3, i4 - 45, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(ee, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        b(guiGraphics, 5, 5);
    }
}
