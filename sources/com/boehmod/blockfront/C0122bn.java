package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bn.class */
public class C0122bn extends AbstractC0194cw {

    /* JADX INFO: renamed from: cm */
    public static final int f835cm = 128;

    /* JADX INFO: renamed from: cn */
    public static final int f836cn = 10;

    /* JADX INFO: renamed from: co */
    public static final int f837co = 12;

    /* JADX INFO: renamed from: cJ */
    public static final float f838cJ = 0.4f;

    /* JADX INFO: renamed from: E */
    @NotNull
    private final Component f839E;

    /* JADX INFO: renamed from: K */
    private final ResourceLocation f840K;

    /* JADX INFO: renamed from: cp */
    private final int f841cp;

    /* JADX INFO: renamed from: cq */
    private final int f842cq;

    /* JADX INFO: renamed from: av */
    private final boolean f843av;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final ObjectList<FormattedCharSequence> f844k;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final PopupType f845b;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final ObjectList<C0121bm> f846l;

    public C0122bn(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0121bm... c0121bmArr) {
        super(screen, Component.literal(component.getString() + ", " + component2.getString()));
        this.f846l = new ObjectArrayList();
        this.f839E = component;
        this.f845b = popupType;
        this.f840K = C0564jv.m2555d("textures/gui/popup/" + popupType.getImage() + ".png");
        this.f846l.addAll(ObjectList.of(c0121bmArr));
        this.f842cq = 300;
        this.f844k = new ObjectArrayList(this.font.split(component2, this.f842cq - 90));
        this.f841cp = (this.f844k.size() * 10) + 80;
        this.f843av = popupType == PopupType.FAIL;
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw
    /* JADX INFO: renamed from: a */
    public void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), 0.4f);
        float fM366g = C0119bk.m366g();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = this.f842cq / 2;
        int i6 = i3 - i5;
        int i7 = i4 - (this.f841cp / 2);
        int i8 = ((i6 + this.f842cq) - 64) - 2;
        int i9 = i7 + 64;
        if (this.f841cp > 128) {
            i9 = (i7 + this.f841cp) - 64;
        }
        C0119bk.m491c(guiGraphics, i6, i7, this.f842cq, this.f841cp, C0119bk.m365p());
        int i10 = i6 + 2;
        int i11 = i7 + 2;
        int i12 = this.f842cq - 4;
        int i13 = this.f841cp - 4;
        C0119bk.m367a(poseStack, guiGraphics, i10, i11, i12, i13);
        C0119bk.m517a(guiGraphics, i10 + 1, i11 + 1, i12 - 2, i13 - 2);
        C0119bk.m447b(poseStack, guiGraphics, this.f840K, i8, i9, 128, 128, 0.0f, 1.0f, this.f845b.getColor() + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i14 = i6 + 12;
        int i15 = (i7 + 12) - 1;
        C0119bk.m387a(poseStack, this.font, guiGraphics, (Component) this.f839E.copy().withStyle(C0565jw.f3201b).withColor(this.f845b.getColor()), i14, i15, 1.5f);
        C0119bk.m373a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.f844k, i14, i15 + 20, 10);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStack, this.font, guiGraphics, i, i2, fM366g);
            }
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(this.f843av ? (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value() : (SoundEvent) C1280xc.f7556pn.get(), this.f843av ? 0.5f : 1.0f, 1.0f));
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = (i - (this.f842cq / 2)) + 8;
        int i4 = ((i2 - (this.f841cp / 2)) + this.f841cp) - 20;
        ObjectListIterator it = this.f846l.iterator();
        while (it.hasNext()) {
            C0121bm c0121bm = (C0121bm) it.next();
            int iWidth = this.font.width(c0121bm.m612d()) + 10;
            C0127bs c0127bsM653a = new C0127bs(i3, i4, iWidth, 13, c0121bm.m612d(), c0121bm.m614a()).m653a(C0127bs.a.NONE);
            Component componentM613e = c0121bm.m613e();
            if (componentM613e != null) {
                c0127bsM653a = c0127bsM653a.m651a(componentM613e);
            }
            addRenderableWidget(c0127bsM653a);
            i3 += iWidth + 5;
        }
    }
}
