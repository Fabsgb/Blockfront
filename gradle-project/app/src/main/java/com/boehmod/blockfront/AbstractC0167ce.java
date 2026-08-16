package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ce */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ce.class */
public abstract class AbstractC0167ce<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0188cp<G, P> {

    /* JADX INFO: renamed from: b */
    @Nullable
    private FormattedCharSequence f1345b;

    /* JADX INFO: renamed from: aT */
    @Nullable
    private Component f1346aT;

    public AbstractC0167ce() {
        super(1);
        this.f1345b = null;
        this.f1346aT = null;
    }

    /* JADX INFO: renamed from: a */
    public void m1054a(@Nullable Component component) {
        if (Objects.equals(component, this.f1346aT)) {
            return;
        }
        this.f1346aT = component;
        this.f1345b = component == null ? null : component.getVisualOrderText();
    }

    /* JADX INFO: renamed from: a */
    protected void mo1053a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (this.f1345b != null) {
            C0129bt.m509a(poseStack, font, guiGraphics, this.f1345b, i + (mo1045a(font) / 2), i2 + 4);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        mo1053a(guiGraphics, poseStack, font, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        if (this.f1345b != null) {
            return font.width(this.f1345b) + 6;
        }
        return super.mo1045a(font);
    }
}
