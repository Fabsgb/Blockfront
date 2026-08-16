package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bx.class */
public class C0133bx extends AbstractC0142cF {

    /* JADX INFO: renamed from: F */
    @NotNull
    private static final Component f982F = Component.translatable("bf.screen.update.title");

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final Component f983G = Component.translatable("bf.screen.update.button.install");

    /* JADX INFO: renamed from: H */
    @NotNull
    private static final Component f984H = Component.translatable("bf.screen.update.button.install.tip");

    /* JADX INFO: renamed from: I */
    @NotNull
    private static final Component f985I = Component.translatable("bf.screen.update.button.retry");

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final Component f986J = Component.translatable("bf.screen.update.button.retry.tip");

    /* JADX INFO: renamed from: dj */
    private static final int f987dj = 300;

    /* JADX INFO: renamed from: dk */
    private static final int f988dk = 120;

    /* JADX INFO: renamed from: dl */
    private static final int f989dl = 12;

    /* JADX INFO: renamed from: dm */
    private static final int f990dm = 8;

    /* JADX INFO: renamed from: L */
    @NotNull
    private final ResourceLocation f991L;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final ObjectList<FormattedCharSequence> f992v;

    /* JADX INFO: renamed from: cQ */
    private static final float f993cQ = 0.15f;

    /* JADX INFO: renamed from: cR */
    private static final float f994cR = 0.25f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0085bB f995a;

    /* JADX INFO: renamed from: cS */
    private float f996cS;

    /* JADX INFO: renamed from: cT */
    private float f997cT;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0535jR.a f998a;

    public C0133bx(@Nullable Screen screen) {
        super(screen, f982F);
        this.f991L = C0532jO.m2378d("textures/gui/popup/" + PopupType.UPDATE.getImage() + ".png");
        this.f992v = new ObjectArrayList();
        this.f996cS = 0.0f;
        this.f997cT = 0.0f;
        this.f998a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        C0835p c0835pM2870a = this.f1057f.m2870a();
        if (c0835pM2870a.m2387a() == AbstractC0535jR.a.IDLE) {
            c0835pM2870a.m2392bn();
        } else {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7968pp.get(), 1.0f, 1.0f));
        }
        int iMax = Math.max(this.font.width(f983G), this.font.width(f985I)) + 10;
        this.f995a = new C0085bB((this.width / 2) - (iMax / 2), ((this.height / 2) + 60) - 30, iMax, 20, f983G, button -> {
            switch (this.f1057f.m2870a().m2387a()) {
                case READY:
                    this.f1057f.m2870a().m2394bp();
                    break;
                case FAILED:
                    this.f1057f.m2870a().m2392bn();
                    break;
            }
        }).m324a(0.0f, 1.0f).m313a(0).m335e(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        this.f995a.visible = false;
        this.f995a.active = false;
        addRenderableWidget(this.f995a);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        C0835p c0835pM2870a = this.f1057f.m2870a();
        AbstractC0535jR.a aVarA = c0835pM2870a.m2387a();
        this.f992v.clear();
        this.f992v.addAll(this.font.split(m721a(c0835pM2870a, aVarA), 210));
        this.f997cT = this.f996cS;
        this.f996cS = C1270xJ.m7161d(this.f996cS, 0.0f, 0.15f);
        if (aVarA == AbstractC0535jR.a.READY && this.f998a != AbstractC0535jR.a.READY) {
            this.f996cS = 1.0f;
            this.f997cT = 1.0f;
        }
        this.f998a = aVarA;
        C0085bB c0085bB = this.f995a;
        if (c0085bB == null) {
        }
        switch (aVarA) {
            case READY:
                c0085bB.visible = true;
                c0085bB.active = true;
                c0085bB.setMessage(f983G);
                c0085bB.m326a(f984H);
                c0085bB.m335e(c0835pM2870a.mo2390e());
                break;
            case FAILED:
                c0085bB.visible = true;
                c0085bB.active = true;
                c0085bB.setMessage(f985I);
                c0085bB.m326a(f986J);
                break;
            default:
                c0085bB.visible = false;
                c0085bB.active = false;
                break;
        }
    }

    public boolean shouldCloseOnEsc() {
        return this.f1057f.m2870a().m2387a() != AbstractC0535jR.a.READY;
    }

    public void onClose() {
        this.f1058a.setScreen(this.f1035c);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo720a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fMin;
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t(), 0.4f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        C0835p c0835pM2870a = this.f1057f.m2870a();
        AbstractC0535jR.a aVarA = c0835pM2870a.m2387a();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 150;
        int i4 = (this.height / 2) - 60;
        C0129bt.m591c(guiGraphics, i3, i4, 300, 120, C0129bt.m465t());
        float fLerp = Mth.lerp(f, this.f997cT, this.f996cS);
        if (fLerp > 0.01f) {
            C0129bt.m517a(guiGraphics, i3, i4, 300, 120, 9633658, 0.25f * fLerp);
        }
        int i5 = i3 + 2;
        int i6 = i4 + 2;
        C0129bt.m467a(poseStack, guiGraphics, i5, i6, Token.M_ARG, 116);
        int iMo2389d = c0835pM2870a.mo2389d();
        C0129bt.m618a(guiGraphics, i5 + 1, i6 + 1, Token.WHITESPACE, C0248dw.f2042hx);
        C0129bt.m547b(poseStack, guiGraphics, this.f991L, ((i3 + 300) - 64) - 2, (i4 + 120) - 64, 128, 128, 0.0f, 1.0f, iMo2389d + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i7 = i3 + 12;
        int i8 = (i4 + 12) - 1;
        C0129bt.m487a(poseStack, this.font, guiGraphics, (Component) f982F.copy().withStyle(C0533jP.f3185b).withColor(iMo2389d), i7, i8, 1.5f);
        C0129bt.m473a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.f992v, i7, i8 + 20, 10);
        if (aVarA != AbstractC0535jR.a.FAILED) {
            long jE = c0835pM2870a.mo2390e();
            switch (aVarA) {
                case READY:
                case VERIFYING:
                    fMin = 1.0f;
                    break;
                case FAILED:
                default:
                    fMin = 0.0f;
                    break;
                case DOWNLOADING:
                    fMin = jE > 0 ? Math.min(1.0f, c0835pM2870a.mo2389d() / jE) : 0.0f;
                    break;
            }
            float f2 = fMin;
            int i9 = (i4 + 120) - 46;
            C0129bt.m591c(guiGraphics, i7 - 1, i9 - 1, Token.LOR_EQ, 10, ColorReferences.COLOR_BLACK_SOLID);
            C0129bt.m515a(guiGraphics, i7, i9, (int) (276.0f * f2), 8, c0835pM2870a.mo2390e());
            if (aVarA == AbstractC0535jR.a.DOWNLOADING) {
                C0129bt.m499a(poseStack, this.font, guiGraphics, (Component) Component.literal(m722a(c0835pM2870a)).withStyle(ChatFormatting.GRAY), this.width / 2, i9 + 8 + 4);
            }
        }
        float fM466g = C0129bt.m466g();
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

    @NotNull
    /* JADX INFO: renamed from: a */
    private Component m721a(@NotNull AbstractC0535jR abstractC0535jR, @NotNull AbstractC0535jR.a aVar) {
        switch (aVar) {
            case READY:
                return Component.translatable("bf.screen.update.message.ready");
            case FAILED:
                String strM2391z = abstractC0535jR.m2391z();
                Object[] objArr = new Object[1];
                objArr[0] = Component.translatable(strM2391z != null ? strM2391z : "bf.screen.update.fail.download");
                return Component.translatable("bf.screen.update.status.failed", objArr).withStyle(ChatFormatting.RED);
            default:
                return Component.translatable("bf.screen.update.message.updating", new Object[]{C0030a.f263a, Component.literal(abstractC0535jR.m2383w()).withStyle(ChatFormatting.YELLOW)});
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private String m722a(@NotNull AbstractC0535jR abstractC0535jR) {
        long jMo2389d = abstractC0535jR.mo2389d();
        long jMo2390e = abstractC0535jR.mo2390e();
        return jMo2390e <= 0 ? String.format(Locale.ROOT, "%.1f MB", Double.valueOf(jMo2389d / 1048576.0d)) : String.format(Locale.ROOT, "%.1f / %.1f MB (%d%%)", Double.valueOf(jMo2389d / 1048576.0d), Double.valueOf(jMo2390e / 1048576.0d), Integer.valueOf((int) ((100 * jMo2389d) / jMo2390e)));
    }
}
