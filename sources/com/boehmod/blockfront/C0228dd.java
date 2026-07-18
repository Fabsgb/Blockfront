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

/* JADX INFO: renamed from: com.boehmod.blockfront.dd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dd.class */
public class C0228dd extends AbstractC0225da {

    /* JADX INFO: renamed from: dP */
    @NotNull
    private static final Component f1865dP = Component.translatable("bf.message.intro.epilepsy.title");

    /* JADX INFO: renamed from: dQ */
    @NotNull
    private static final Component f1866dQ = Component.translatable("bf.message.intro.epilepsy.message");

    /* JADX INFO: renamed from: dR */
    @NotNull
    private static final Component f1867dR = Component.translatable("bf.message.intro.epilepsy.understand.button.tip").withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);

    /* JADX INFO: renamed from: dS */
    @NotNull
    private static final Component f1868dS = Component.translatable("bf.message.understand");

    /* JADX INFO: renamed from: bo */
    @NotNull
    private static final ResourceLocation f1869bo = C0564jv.m2555d("textures/gui/background/intro/background_epilepsy.png");

    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @NotNull
    /* JADX INFO: renamed from: f */
    protected List<C0229de> mo1328f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0229de(f1868dS, button -> {
            C0424hN.f2764R.m1997x(true);
            C0427hQ.m2004d(this.f1586e);
            this.f1587b.setScreen(mo1329b());
        }).m1341a(f1867dR).m1342a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1340a(ColorReferences.COLOR_WHITE));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1329b() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1330i() {
        return f1869bo;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m394c(poseStackPose, this.font, guiGraphics, (Component) f1865dP.copy().withStyle(C0565jw.f3201b), i3, i4 - 45, 2.0f);
        C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1866dQ, (int) (this.width * 0.75f)), i3, i4 - 10, 10, true);
        m1333b(guiGraphics, 1, 5);
    }
}
