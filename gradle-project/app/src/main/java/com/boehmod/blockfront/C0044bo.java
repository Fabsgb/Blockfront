package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0268jy;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bo.class */
public class C0044bo extends AbstractC0079cw {

    @NotNull
    private static final Component F = Component.translatable("bf.screen.update.title");

    @NotNull
    private static final Component G = Component.translatable("bf.screen.update.button.install");

    @NotNull
    private static final Component H = Component.translatable("bf.screen.update.button.install.tip");

    @NotNull
    private static final Component I = Component.translatable("bf.screen.update.button.retry");

    @NotNull
    private static final Component J = Component.translatable("bf.screen.update.button.retry.tip");
    private static final int cr = 300;
    private static final int cs = 120;
    private static final int ct = 12;
    private static final int cu = 8;

    @NotNull
    private final ResourceLocation L;

    @NotNull
    private final ObjectList<FormattedCharSequence> m;
    private static final float cK = 0.15f;
    private static final float cL = 0.25f;

    @Nullable
    private C0048bs a;
    private float cM;
    private float cN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private AbstractC0268jy.a f64a;

    public C0044bo(@Nullable Screen screen) {
        super(screen, F);
        this.L = C0265jv.d("textures/gui/popup/" + PopupType.UPDATE.getImage() + ".png");
        this.m = new ObjectArrayList();
        this.cM = 0.0f;
        this.cN = 0.0f;
        this.f64a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        C0405p c0405pM588a = this.e.m588a();
        if (c0405pM588a.a() == AbstractC0268jy.a.IDLE) {
            c0405pM588a.bb();
        } else {
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pn.get(), 1.0f, 1.0f));
        }
        int iMax = Math.max(this.font.width(G), this.font.width(I)) + 10;
        this.a = new C0048bs((this.width / 2) - (iMax / 2), ((this.height / 2) + 60) - 30, iMax, 20, G, button -> {
            switch (this.e.m588a().a()) {
                case READY:
                    this.e.m588a().bd();
                    break;
                case FAILED:
                    this.e.m588a().bb();
                    break;
            }
        }).a(0.0f, 1.0f).a(0).e(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        this.a.visible = false;
        this.a.active = false;
        addRenderableWidget(this.a);
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        C0405p c0405pM588a = this.e.m588a();
        AbstractC0268jy.a aVarA = c0405pM588a.a();
        this.m.clear();
        this.m.addAll(this.font.split(a(c0405pM588a, aVarA), 210));
        this.cN = this.cM;
        this.cM = C0634xm.d(this.cM, 0.0f, 0.15f);
        if (aVarA == AbstractC0268jy.a.READY && this.f64a != AbstractC0268jy.a.READY) {
            this.cM = 1.0f;
            this.cN = 1.0f;
        }
        this.f64a = aVarA;
        C0048bs c0048bs = this.a;
        if (c0048bs == null) {
        }
        switch (aVarA) {
            case READY:
                c0048bs.visible = true;
                c0048bs.active = true;
                c0048bs.setMessage(G);
                c0048bs.a(H);
                c0048bs.e(c0405pM588a.e());
                break;
            case FAILED:
                c0048bs.visible = true;
                c0048bs.active = true;
                c0048bs.setMessage(I);
                c0048bs.a(J);
                break;
            default:
                c0048bs.visible = false;
                c0048bs.active = false;
                break;
        }
    }

    public boolean shouldCloseOnEsc() {
        return this.e.m588a().a() != AbstractC0268jy.a.READY;
    }

    public void onClose() {
        this.b.setScreen(this.d);
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fMin;
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), 0.4f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        C0405p c0405pM588a = this.e.m588a();
        AbstractC0268jy.a aVarA = c0405pM588a.a();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 150;
        int i4 = (this.height / 2) - 60;
        C0040bk.c(guiGraphics, i3, i4, 300, 120, C0040bk.p());
        float fLerp = Mth.lerp(f, this.cN, this.cM);
        if (fLerp > 0.01f) {
            C0040bk.a(guiGraphics, i3, i4, 300, 120, 9633658, 0.25f * fLerp);
        }
        int i5 = i3 + 2;
        int i6 = i4 + 2;
        C0040bk.a(poseStack, guiGraphics, i5, i6, Token.M_ARG, 116);
        int iD = c0405pM588a.d();
        C0040bk.a(guiGraphics, i5 + 1, i6 + 1, Token.WHITESPACE, C0097dn.gs);
        C0040bk.b(poseStack, guiGraphics, this.L, ((i3 + 300) - 64) - 2, (i4 + 120) - 64, 128, 128, 0.0f, 1.0f, iD + ColorReferences.COLOR_BLACK_SOLID);
        guiGraphics.disableScissor();
        int i7 = i3 + 12;
        int i8 = (i4 + 12) - 1;
        C0040bk.a(poseStack, this.font, guiGraphics, (Component) F.copy().withStyle(C0266jw.b).withColor(iD), i7, i8, 1.5f);
        C0040bk.a(poseStack, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) this.m, i7, i8 + 20, 10);
        if (aVarA != AbstractC0268jy.a.FAILED) {
            long jD = c0405pM588a.d();
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
                    fMin = jD > 0 ? Math.min(1.0f, c0405pM588a.c() / jD) : 0.0f;
                    break;
            }
            float f2 = fMin;
            int i9 = (i4 + 120) - 46;
            C0040bk.c(guiGraphics, i7 - 1, i9 - 1, Token.LOR_EQ, 10, ColorReferences.COLOR_BLACK_SOLID);
            C0040bk.a(guiGraphics, i7, i9, (int) (276.0f * f2), 8, c0405pM588a.e());
            if (aVarA == AbstractC0268jy.a.DOWNLOADING) {
                C0040bk.a(poseStack, this.font, guiGraphics, (Component) Component.literal(a(c0405pM588a)).withStyle(ChatFormatting.GRAY), this.width / 2, i9 + 8 + 4);
            }
        }
        float fG = C0040bk.g();
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

    @NotNull
    private Component a(@NotNull AbstractC0268jy abstractC0268jy, @NotNull AbstractC0268jy.a aVar) {
        switch (aVar) {
            case READY:
                return Component.translatable("bf.screen.update.message.ready");
            case FAILED:
                String strV = abstractC0268jy.v();
                Object[] objArr = new Object[1];
                objArr[0] = Component.translatable(strV != null ? strV : "bf.screen.update.fail.download");
                return Component.translatable("bf.screen.update.status.failed", objArr).withStyle(ChatFormatting.RED);
            default:
                return Component.translatable("bf.screen.update.message.updating", new Object[]{C0002a.a, Component.literal(abstractC0268jy.s()).withStyle(ChatFormatting.YELLOW)});
        }
    }

    @NotNull
    private String a(@NotNull AbstractC0268jy abstractC0268jy) {
        long jC = abstractC0268jy.c();
        long jD = abstractC0268jy.d();
        return jD <= 0 ? String.format(Locale.ROOT, "%.1f MB", Double.valueOf(jC / 1048576.0d)) : String.format(Locale.ROOT, "%.1f / %.1f MB (%d%%)", Double.valueOf(jC / 1048576.0d), Double.valueOf(jD / 1048576.0d), Integer.valueOf((int) ((100 * jC) / jD)));
    }
}
