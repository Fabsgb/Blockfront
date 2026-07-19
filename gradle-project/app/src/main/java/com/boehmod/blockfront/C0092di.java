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

/* JADX INFO: renamed from: com.boehmod.blockfront.di, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/di.class */
public class C0092di extends AbstractC0084da {
    private static final Component ej = Component.translatable("bf.message.intro.rules.title");
    private static final Component ek = Component.translatable("bf.message.intro.rules.message");
    private static final Component el = Component.translatable("bf.message.intro.accept.rules.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);
    private static final Component em = Component.translatable("bf.message.intro.rules.button");
    private static final Component en = Component.translatable("bf.message.intro.rules.button.tip");
    private static final Component eo = Component.translatable("bf.message.intro.privacy.button");
    private static final Component ep = Component.translatable("bf.message.intro.privacy.button.tip");
    private static final Component eq = Component.translatable("bf.message.accept");

    @NotNull
    public static final ResourceLocation bu = C0265jv.d("textures/gui/background/intro/background_rules.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0088de(eq, button -> {
            hN.S.x(true);
            hQ.d(this.e);
            this.b.setScreen(b());
        }).a(el).a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE));
        objectArrayList.add(new C0088de(em, button2 -> {
            C0093dj.b(this.b, C0261jr.aE);
        }).a(en));
        objectArrayList.add(new C0088de(eo, button3 -> {
            C0093dj.b(this.b, C0261jr.aF);
        }).a(ep));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return (SoundEvent) C0624xc.py.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return bu;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, this.font, guiGraphics, (Component) ej.copy().withStyle(C0266jw.b), i3, i4 - 45, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(ek, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        b(guiGraphics, 2, 5);
    }
}
