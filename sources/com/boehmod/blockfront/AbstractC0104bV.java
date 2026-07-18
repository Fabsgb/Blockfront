package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bV.class */
public abstract class AbstractC0104bV<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0168cg<G, P> {

    /* JADX INFO: renamed from: b */
    @Nullable
    private FormattedCharSequence f665b;

    public AbstractC0104bV() {
        super(1);
        this.f665b = null;
    }

    /* JADX INFO: renamed from: a */
    public void m329a(@Nullable Component component) {
        this.f665b = component == null ? null : component.getVisualOrderText();
    }

    /* JADX INFO: renamed from: a */
    protected void mo328a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (this.f665b != null) {
            C0119bk.m409a(poseStack, font, guiGraphics, this.f665b, i + (mo322a(font) / 2), i2 + 4);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        mo328a(guiGraphics, poseStack, font, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        if (this.f665b != null) {
            return font.width(this.f665b) + 6;
        }
        return super.mo322a(font);
    }
}
