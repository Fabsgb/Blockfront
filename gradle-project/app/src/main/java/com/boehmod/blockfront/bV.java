package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bV.class */
public abstract class bV<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0063cg<G, P> {

    @Nullable
    private FormattedCharSequence b;

    public bV() {
        super(1);
        this.b = null;
    }

    public void a(@Nullable Component component) {
        this.b = component == null ? null : component.getVisualOrderText();
    }

    protected void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (this.b != null) {
            C0040bk.a(poseStack, font, guiGraphics, this.b, i + (a(font) / 2), i2 + 4);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        a(guiGraphics, poseStack, font, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        if (this.b != null) {
            return font.width(this.b) + 6;
        }
        return super.a(font);
    }
}
