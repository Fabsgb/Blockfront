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

/* JADX INFO: renamed from: com.boehmod.blockfront.dc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dc.class */
public class C0086dc extends AbstractC0084da {

    @NotNull
    private static final Component dJ = Component.translatable("bf.message.intro.discord.title");

    @NotNull
    private static final Component dK = Component.translatable("bf.message.intro.discord.message");

    @NotNull
    private static final Component dL = Component.translatable("bf.message.intro.discord.join.button.tip").withColor(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID);

    @NotNull
    private static final Component dM = Component.translatable("bf.message.intro.discord.skip.button.tip");

    @NotNull
    private static final Component dN = Component.translatable("bf.message.join.now");

    @NotNull
    private static final Component dO = Component.translatable("bf.message.skip");

    @NotNull
    private static final ResourceLocation bn = C0265jv.d("textures/gui/background/intro/background_discord.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0088de(dN, button -> {
            C0093dj.b(this.b, C0261jr.aB);
            hN.U.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(dL).a(ColorReferences.COLOR_THEME_DISCORD_SOLID, ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0088de(dO, button2 -> {
            hN.U.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(dM));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return (SoundEvent) C0624xc.pA.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return bn;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) dJ.copy().withStyle(C0266jw.b), i3, i4 - 45, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(dK, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        b(guiGraphics, 4, 5);
    }
}
