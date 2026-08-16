package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cd.class */
public abstract class AbstractC0166cd<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0167ce<G, P> {

    /* JADX INFO: renamed from: T */
    @Nullable
    private ResourceLocation f1344T = null;

    /* JADX INFO: renamed from: a */
    public void m1052a(@Nullable ResourceLocation resourceLocation) {
        this.f1344T = resourceLocation;
    }

    @Override // com.boehmod.blockfront.AbstractC0167ce, com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        if (this.f1344T == null) {
            return;
        }
        C0129bt.m531a(poseStack, guiGraphics, this.f1344T, i + 2, i2 + 2, 11, 11);
    }

    @Override // com.boehmod.blockfront.AbstractC0167ce
    /* JADX INFO: renamed from: a */
    protected void mo1053a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        super.mo1053a(guiGraphics, poseStack, font, i + (this.f1344T != null ? 7 : 0), i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0167ce, com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return super.mo1045a(font) + (this.f1344T != null ? 12 : 0);
    }
}
