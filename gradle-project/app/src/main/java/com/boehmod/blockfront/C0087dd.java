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

/* JADX INFO: renamed from: com.boehmod.blockfront.dd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dd.class */
public class C0087dd extends AbstractC0084da {

    @NotNull
    private static final Component dP = Component.translatable("bf.message.intro.epilepsy.title");

    @NotNull
    private static final Component dQ = Component.translatable("bf.message.intro.epilepsy.message");

    @NotNull
    private static final Component dR = Component.translatable("bf.message.intro.epilepsy.understand.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    @NotNull
    private static final Component dS = Component.translatable("bf.message.understand");

    @NotNull
    private static final ResourceLocation bo = C0265jv.d("textures/gui/background/intro/background_epilepsy.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0088de(dS, button -> {
            hN.f157R.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(dR).a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return bo;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) dP.copy().withStyle(C0266jw.b), i3, i4 - 45, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(dQ, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        b(guiGraphics, 1, 5);
    }
}
