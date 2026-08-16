package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bw.class */
public class C0132bw extends AbstractC0142cF {

    /* JADX INFO: renamed from: de */
    public static final int f970de = 128;

    /* JADX INFO: renamed from: df */
    public static final int f971df = 10;

    /* JADX INFO: renamed from: dg */
    public static final int f972dg = 12;

    /* JADX INFO: renamed from: cP */
    public static final float f973cP = 0.4f;

    /* JADX INFO: renamed from: E */
    @NotNull
    private final Component f974E;

    /* JADX INFO: renamed from: K */
    private final ResourceLocation f975K;

    /* JADX INFO: renamed from: dh */
    private final int f976dh;

    /* JADX INFO: renamed from: di */
    private final int f977di;

    /* JADX INFO: renamed from: aA */
    private final boolean f978aA;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final ObjectList<FormattedCharSequence> f979t;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final PopupType f980b;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final ObjectList<C0131bv> f981u;

    public C0132bw(@Nullable Screen screen, @NotNull Component component, @NotNull Component component2, @NotNull PopupType popupType, @NotNull C0131bv... c0131bvArr) {
        super(screen, Component.literal(component.getString() + ", " + component2.getString()));
        this.f981u = new ObjectArrayList();
        this.f974E = component;
        this.f980b = popupType;
        this.f975K = C0532jO.m2378d("textures/gui/popup/" + popupType.getImage() + ".png");
        this.f981u.addAll(ObjectList.of(c0131bvArr));
        this.f977di = 300;
        this.f979t = new ObjectArrayList(this.font.split(component2, this.f977di - 90));
        this.f976dh = (this.f979t.size() * 10) + 80;
        this.f978aA = popupType == PopupType.FAIL;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t(), 0.4f);
        float fM466g = C0129bt.m466g();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = this.f977di / 2;
        int i6 = i3 - i5;
        int i7 = i4 - (this.f976dh / 2);
        int i8 = ((i6 + this.f977di) - 64) - 2;
        int i9 = i7 + 64;
        if (this.f976dh > 128) {
            i9 = (i7 + this.f976dh) - 64;
        }
        C0129bt.m591c(guiGraphics, i6, i7, this.f977di, this.f976dh, C0129bt.m465t());
        int i10 = i6 + 2;
        int i11 = i7 + 2;
        int i12 = this.f977di - 4;
        int i13 = this.f976dh - 4;
        C0129bt.m467a(poseStack, guiGraphics, i10, i11, i12, i13);
        C0129bt.m618a(guiGraphics, i10 + 1, i11 + 1, i12 - 2, i13 - 2);
        C0129bt.m547b(poseStack, guiGraphics, this.f975K, i8, i9, 128, 128, 0.0f, 1.0f, this.f980b.getColor() + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i14 = i6 + 12;
        int i15 = (i7 + 12) - 1;
        C0129bt.m487a(poseStack, this.font, guiGraphics, (Component) this.f974E.copy().withStyle(C0533jP.f3185b).withColor(this.f980b.getColor()), i14, i15, 1.5f);
        C0129bt.m473a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.f979t, i14, i15 + 20, 10);
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStack, this.font, guiGraphics, i, i2, fM466g);
            }
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(this.f978aA ? (SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value() : (SoundEvent) C1312xz.f7968pp.get(), this.f978aA ? 0.5f : 1.0f, 1.0f));
        int i = this.width / 2;
        int i2 = this.height / 2;
        int i3 = (i - (this.f977di / 2)) + 8;
        int i4 = ((i2 - (this.f976dh / 2)) + this.f976dh) - 20;
        ObjectListIterator it = this.f981u.iterator();
        while (it.hasNext()) {
            C0131bv c0131bv = (C0131bv) it.next();
            int iWidth = this.font.width(c0131bv.m717d()) + 10;
            C0085bB c0085bBM328a = new C0085bB(i3, i4, iWidth, 13, c0131bv.m717d(), c0131bv.m719a()).m328a(C0085bB.a.NONE);
            Component componentM718e = c0131bv.m718e();
            if (componentM718e != null) {
                c0085bBM328a = c0085bBM328a.m326a(componentM718e);
            }
            addRenderableWidget(c0085bBM328a);
            i3 += iWidth + 5;
        }
    }
}
