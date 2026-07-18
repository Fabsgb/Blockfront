package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0567jy;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bo.class */
public class C0123bo extends AbstractC0194cw {

    /* JADX INFO: renamed from: F */
    @NotNull
    private static final Component f847F = Component.translatable("bf.screen.update.title");

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final Component f848G = Component.translatable("bf.screen.update.button.install");

    /* JADX INFO: renamed from: H */
    @NotNull
    private static final Component f849H = Component.translatable("bf.screen.update.button.install.tip");

    /* JADX INFO: renamed from: I */
    @NotNull
    private static final Component f850I = Component.translatable("bf.screen.update.button.retry");

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final Component f851J = Component.translatable("bf.screen.update.button.retry.tip");

    /* JADX INFO: renamed from: cr */
    private static final int f852cr = 300;

    /* JADX INFO: renamed from: cs */
    private static final int f853cs = 120;

    /* JADX INFO: renamed from: ct */
    private static final int f854ct = 12;

    /* JADX INFO: renamed from: cu */
    private static final int f855cu = 8;

    /* JADX INFO: renamed from: L */
    @NotNull
    private final ResourceLocation f856L;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final ObjectList<FormattedCharSequence> f857m;

    /* JADX INFO: renamed from: cK */
    private static final float f858cK = 0.15f;

    /* JADX INFO: renamed from: cL */
    private static final float f859cL = 0.25f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0127bs f860a;

    /* JADX INFO: renamed from: cM */
    private float f861cM;

    /* JADX INFO: renamed from: cN */
    private float f862cN;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC0567jy.a f863a;

    public C0123bo(@Nullable Screen screen) {
        super(screen, f847F);
        this.f856L = C0564jv.m2555d("textures/gui/popup/" + PopupType.UPDATE.getImage() + ".png");
        this.f857m = new ObjectArrayList();
        this.f861cM = 0.0f;
        this.f862cN = 0.0f;
        this.f863a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        C0834p c0834pM2684a = this.f1586e.m2684a();
        if (c0834pM2684a.m2562a() == AbstractC0567jy.a.IDLE) {
            c0834pM2684a.m2568bb();
        } else {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7556pn.get(), 1.0f, 1.0f));
        }
        int iMax = Math.max(this.font.width(f848G), this.font.width(f850I)) + 10;
        this.f860a = new C0127bs((this.width / 2) - (iMax / 2), ((this.height / 2) + 60) - 30, iMax, 20, f848G, button -> {
            switch (this.f1586e.m2684a().m2562a()) {
                case READY:
                    this.f1586e.m2684a().m2570bd();
                    break;
                case FAILED:
                    this.f1586e.m2684a().m2568bb();
                    break;
            }
        }).m649a(0.0f, 1.0f).m638a(0).m660e(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        this.f860a.visible = false;
        this.f860a.active = false;
        addRenderableWidget(this.f860a);
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        C0834p c0834pM2684a = this.f1586e.m2684a();
        AbstractC0567jy.a aVarA = c0834pM2684a.m2562a();
        this.f857m.clear();
        this.f857m.addAll(this.font.split(m616a(c0834pM2684a, aVarA), 210));
        this.f862cN = this.f861cM;
        this.f861cM = C1290xm.m7835d(this.f861cM, 0.0f, 0.15f);
        if (aVarA == AbstractC0567jy.a.READY && this.f863a != AbstractC0567jy.a.READY) {
            this.f861cM = 1.0f;
            this.f862cN = 1.0f;
        }
        this.f863a = aVarA;
        C0127bs c0127bs = this.f860a;
        if (c0127bs == null) {
        }
        switch (aVarA) {
            case READY:
                c0127bs.visible = true;
                c0127bs.active = true;
                c0127bs.setMessage(f848G);
                c0127bs.m651a(f849H);
                c0127bs.m660e(c0834pM2684a.m4208e());
                break;
            case FAILED:
                c0127bs.visible = true;
                c0127bs.active = true;
                c0127bs.setMessage(f850I);
                c0127bs.m651a(f851J);
                break;
            default:
                c0127bs.visible = false;
                c0127bs.active = false;
                break;
        }
    }

    public boolean shouldCloseOnEsc() {
        return this.f1586e.m2684a().m2562a() != AbstractC0567jy.a.READY;
    }

    public void onClose() {
        this.f1587b.setScreen(this.f1563d);
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw
    /* JADX INFO: renamed from: a */
    public void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fMin;
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), 0.4f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        C0834p c0834pM2684a = this.f1586e.m2684a();
        AbstractC0567jy.a aVarA = c0834pM2684a.m2562a();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 150;
        int i4 = (this.height / 2) - 60;
        C0119bk.m491c(guiGraphics, i3, i4, 300, 120, C0119bk.m365p());
        float fLerp = Mth.lerp(f, this.f862cN, this.f861cM);
        if (fLerp > 0.01f) {
            C0119bk.m417a(guiGraphics, i3, i4, 300, 120, 9633658, 0.25f * fLerp);
        }
        int i5 = i3 + 2;
        int i6 = i4 + 2;
        C0119bk.m367a(poseStack, guiGraphics, i5, i6, Token.M_ARG, 116);
        int iMo2566d = c0834pM2684a.mo2566d();
        C0119bk.m517a(guiGraphics, i5 + 1, i6 + 1, Token.WHITESPACE, C0238dn.f1978gs);
        C0119bk.m447b(poseStack, guiGraphics, this.f856L, ((i3 + 300) - 64) - 2, (i4 + 120) - 64, 128, 128, 0.0f, 1.0f, iMo2566d + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i7 = i3 + 12;
        int i8 = (i4 + 12) - 1;
        C0119bk.m387a(poseStack, this.font, guiGraphics, (Component) f847F.copy().withStyle(C0565jw.f3201b).withColor(iMo2566d), i7, i8, 1.5f);
        C0119bk.m373a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.f857m, i7, i8 + 20, 10);
        if (aVarA != AbstractC0567jy.a.FAILED) {
            long jD = c0834pM2684a.mo2566d();
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
                    fMin = jD > 0 ? Math.min(1.0f, c0834pM2684a.m2565c() / jD) : 0.0f;
                    break;
            }
            float f2 = fMin;
            int i9 = (i4 + 120) - 46;
            C0119bk.m491c(guiGraphics, i7 - 1, i9 - 1, Token.LOR_EQ, 10, ColorReferences.COLOR_BLACK_SOLID);
            C0119bk.m415a(guiGraphics, i7, i9, (int) (276.0f * f2), 8, c0834pM2684a.m4208e());
            if (aVarA == AbstractC0567jy.a.DOWNLOADING) {
                C0119bk.m399a(poseStack, this.font, guiGraphics, (Component) Component.literal(m617a(c0834pM2684a)).withStyle(ChatFormatting.GRAY), this.width / 2, i9 + 8 + 4);
            }
        }
        float fM366g = C0119bk.m366g();
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

    @NotNull
    /* JADX INFO: renamed from: a */
    private Component m616a(@NotNull AbstractC0567jy abstractC0567jy, @NotNull AbstractC0567jy.a aVar) {
        switch (aVar) {
            case READY:
                return Component.translatable("bf.screen.update.message.ready");
            case FAILED:
                String strM2567v = abstractC0567jy.m2567v();
                Object[] objArr = new Object[1];
                objArr[0] = Component.translatable(strM2567v != null ? strM2567v : "bf.screen.update.fail.download");
                return Component.translatable("bf.screen.update.status.failed", objArr).withStyle(ChatFormatting.RED);
            default:
                return Component.translatable("bf.screen.update.message.updating", new Object[]{C0029a.f246a, Component.literal(abstractC0567jy.m2559s()).withStyle(ChatFormatting.YELLOW)});
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private String m617a(@NotNull AbstractC0567jy abstractC0567jy) {
        long jM2565c = abstractC0567jy.m2565c();
        long jMo2566d = abstractC0567jy.mo2566d();
        return jMo2566d <= 0 ? String.format(Locale.ROOT, "%.1f MB", Double.valueOf(jM2565c / 1048576.0d)) : String.format(Locale.ROOT, "%.1f / %.1f MB (%d%%)", Double.valueOf(jM2565c / 1048576.0d), Double.valueOf(jMo2566d / 1048576.0d), Integer.valueOf((int) ((100 * jM2565c) / jMo2566d)));
    }
}
