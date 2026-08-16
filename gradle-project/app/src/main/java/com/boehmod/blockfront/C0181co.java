package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.co */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/co.class */
public class C0181co<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0188cp<G, P> {

    /* JADX INFO: renamed from: am */
    @NotNull
    private static final ResourceLocation f1388am = C0532jO.m2378d("textures/gui/stopwatch.png");

    /* JADX INFO: renamed from: g */
    @NotNull
    private FormattedCharSequence f1389g;

    /* JADX INFO: renamed from: aW */
    @Nullable
    private Component f1390aW;

    public C0181co() {
        super(1);
        this.f1389g = FormattedCharSequence.EMPTY;
        this.f1390aW = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentM4330d = abstractC0864pc.m4114a().m4330d();
        if (!mutableComponentM4330d.equals(this.f1390aW)) {
            this.f1390aW = mutableComponentM4330d;
            this.f1389g = mutableComponentM4330d.getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 2;
        C0129bt.m531a(poseStack, guiGraphics, f1388am, i3, i2 + 2, 11, 11);
        C0129bt.m504b(font, guiGraphics, this.f1389g, i3 + 11 + 3, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return 44;
    }
}
