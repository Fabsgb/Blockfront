package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bU.class */
public abstract class AbstractC0103bU<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0104bV<G, P> {

    /* JADX INFO: renamed from: T */
    @Nullable
    private ResourceLocation f664T = null;

    /* JADX INFO: renamed from: a */
    public void m327a(@Nullable ResourceLocation resourceLocation) {
        this.f664T = resourceLocation;
    }

    @Override // com.boehmod.blockfront.AbstractC0104bV, com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        if (this.f664T == null) {
            return;
        }
        C0119bk.m431a(poseStack, guiGraphics, this.f664T, i + 3, i2 + 2, 11, 11);
    }

    @Override // com.boehmod.blockfront.AbstractC0104bV
    /* JADX INFO: renamed from: a */
    protected void mo328a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        super.mo328a(guiGraphics, poseStack, font, i + (this.f664T != null ? 7 : 0), i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0104bV, com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return super.mo322a(font) + (this.f664T != null ? 12 : 0);
    }
}
