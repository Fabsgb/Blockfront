package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bn.class */
public class C0043bn extends AbstractC0079cw {
    public static final int cm = 128;
    public static final int cn = 10;
    public static final int co = 12;
    public static final float cJ = 0.4f;

    @NotNull
    private final Component E;
    private final ResourceLocation K;
    private final int cp;
    private final int cq;
    private final boolean av;

    @NotNull
    private final ObjectList<FormattedCharSequence> k;

    @NotNull
    private final PopupType b;

    @NotNull
    private final ObjectList<C0042bm> l;

    public C0043bn(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0042bm... c0042bmArr) {
        super(screen, Component.literal(component.getString() + ", " + component2.getString()));
        this.l = new ObjectArrayList();
        this.E = component;
        this.b = popupType;
        this.K = C0265jv.d("textures/gui/popup/" + popupType.getImage() + ".png");
        this.l.addAll(ObjectList.of(c0042bmArr));
        this.cq = 300;
        this.k = new ObjectArrayList(this.font.split(component2, this.cq - 90));
        this.cp = (this.k.size() * 10) + 80;
        this.av = popupType == PopupType.FAIL;
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), 0.4f);
        float fG = C0040bk.g();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = this.cq / 2;
        int i6 = i3 - i5;
        int i7 = i4 - (this.cp / 2);
        int i8 = ((i6 + this.cq) - 64) - 2;
        int i9 = i7 + 64;
        if (this.cp > 128) {
            i9 = (i7 + this.cp) - 64;
        }
        C0040bk.c(guiGraphics, i6, i7, this.cq, this.cp, C0040bk.p());
        int i10 = i6 + 2;
        int i11 = i7 + 2;
        int i12 = this.cq - 4;
        int i13 = this.cp - 4;
        C0040bk.a(poseStack, guiGraphics, i10, i11, i12, i13);
        C0040bk.a(guiGraphics, i10 + 1, i11 + 1, i12 - 2, i13 - 2);
        C0040bk.b(poseStack, guiGraphics, this.K, i8, i9, 128, 128, 0.0f, 1.0f, this.b.getColor() + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i14 = i6 + 12;
        int i15 = (i7 + 12) - 1;
        C0040bk.a(poseStack, this.font, guiGraphics, (Component) this.E.copy().withStyle(C0266jw.b).withColor(this.b.getColor()), i14, i15, 1.5f);
        C0040bk.a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.k, i14, i15 + 20, 10);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStack, this.font, guiGraphics, i, i2, fG);
            }
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        this.b.getSoundManager().play(SimpleSoundInstance.forUI(this.av ? (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value() : (SoundEvent) C0624xc.pn.get(), this.av ? 0.5f : 1.0f, 1.0f));
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = (i - (this.cq / 2)) + 8;
        int i4 = ((i2 - (this.cp / 2)) + this.cp) - 20;
        ObjectListIterator it = this.l.iterator();
        while (it.hasNext()) {
            C0042bm c0042bm = (C0042bm) it.next();
            int iWidth = this.font.width(c0042bm.d()) + 10;
            C0048bs c0048bsA = new C0048bs(i3, i4, iWidth, 13, c0042bm.d(), c0042bm.a()).a(C0048bs.a.NONE);
            Component componentE = c0042bm.e();
            if (componentE != null) {
                c0048bsA = c0048bsA.a(componentE);
            }
            addRenderableWidget(c0048bsA);
            i3 += iWidth + 5;
        }
    }
}
