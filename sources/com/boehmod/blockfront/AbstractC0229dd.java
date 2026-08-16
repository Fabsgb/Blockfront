package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dd.class */
public abstract class AbstractC0229dd extends C0143cG {

    /* JADX INFO: renamed from: bb */
    private static final ResourceLocation f1845bb = C0532jO.m2378d("textures/gui/stopwatch.png");

    /* JADX INFO: renamed from: g */
    private static final MutableComponent f1846g = Component.translatable("bf.message.game.match.summary.button.skip");

    /* JADX INFO: renamed from: h */
    private static final MutableComponent f1847h = Component.translatable("bf.message.game.match.summary.button.skip.tip");

    /* JADX INFO: renamed from: gx */
    private static final int f1848gx = 256;

    /* JADX INFO: renamed from: gy */
    private static final int f1849gy = 30;

    /* JADX INFO: renamed from: gz */
    private final int f1850gz;

    /* JADX INFO: renamed from: fi */
    private int f1851fi;

    /* JADX INFO: renamed from: gA */
    private int f1852gA;

    /* JADX INFO: renamed from: bn */
    private boolean f1853bn;

    /* JADX INFO: renamed from: bo */
    private boolean f1854bo;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final UUID f1855e;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract SoundEvent mo1337a();

    /* JADX INFO: renamed from: K */
    protected abstract int mo1338K();

    @NotNull
    /* JADX INFO: renamed from: g */
    protected abstract Component mo1339g();

    @NotNull
    /* JADX INFO: renamed from: h */
    protected abstract Component mo1340h();

    @NotNull
    /* JADX INFO: renamed from: i */
    protected abstract Component mo1341i();

    public AbstractC0229dd(@NotNull UUID uuid) {
        super(Component.empty());
        this.f1850gz = mo1338K();
        this.f1853bn = false;
        this.f1854bo = false;
        this.f1855e = uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0229dd m1346a(boolean z) {
        this.f1853bn = z;
        return this;
    }

    /* JADX INFO: renamed from: y */
    public boolean mo1347y() {
        return this.f1851fi >= this.f1850gz;
    }

    /* JADX INFO: renamed from: a */
    private void m1348a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        float fM7170f = (C1270xJ.m7170f(this.f1851fi, this.f1852gA, f) / this.f1850gz) * this.width;
        C0129bt.m516a(poseStack, guiGraphics, 0.0f, 30.0f, this.width, 2.0f, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
        C0129bt.m514a(poseStack, guiGraphics, 0.0f, 30.0f, fM7170f, 2.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        if (!this.f1853bn) {
            addRenderableWidget(new C0085bB((this.width - 5) - 50, (this.height - 5) - 20, 50, 20, f1846g, button -> {
                mo1349ac();
            }).m326a((Component) f1847h).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.NONE));
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: ac */
    public void mo1349ac() {
        this.f1851fi = this.f1850gz;
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = this.f1058a.font;
        if (!this.f1853bn) {
            m1348a(guiGraphics, poseStackPose, f);
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = this.f1057f.m2878a();
        if (abstractC0864pcM2878a != null) {
            C0873pl c0873plM4114a = abstractC0864pcM2878a.m4114a();
            C0129bt.m531a(poseStackPose, guiGraphics, f1845bb, 10, 7, 16, 16);
            C0129bt.m489b(poseStackPose, font, guiGraphics, (Component) c0873plM4114a.m4330d(), 30.0f, 10.0f, ColorReferences.COLOR_WHITE, 1.5f);
        }
        C0129bt.m491b(poseStackPose, font, guiGraphics, mo1339g(), i3, 6, 2.0f);
        Window window = this.f1058a.getWindow();
        MouseHandler mouseHandler = this.f1058a.mouseHandler;
        this.f1058a.gui.getChat().render(guiGraphics, this.f1058a.gui.getGuiTicks(), Mth.floor((mouseHandler.xpos() * ((double) window.getGuiScaledWidth())) / ((double) window.getScreenWidth())), Mth.floor((mouseHandler.ypos() * ((double) window.getGuiScaledHeight())) / ((double) window.getScreenHeight())), false);
        boolean zIsKeyDown = InputConstants.isKeyDown(this.f1058a.getWindow().getWindow(), this.f1058a.options.keyPlayerList.getKey().getValue());
        if (abstractC0864pcM2878a != null && this.f1058a.player != null && zIsKeyDown) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1200.0f);
            abstractC0864pcM2878a.m4148a(poseStackPose, guiGraphics, font, this.f1058a, this.f1057f, this.f1058a.player, ((C0396gl) this.f1057f.m2855a()).m1886a(this.f1058a), this.width, this.height, f);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0129bt.m628b(this.f1058a, f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t(), 0.25f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, 30, C0129bt.m465t(), 0.35f);
    }

    @Override // com.boehmod.blockfront.C0143cG
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a == null || !abstractC0863pbM2874a.m4064e().equals(this.f1855e)) {
            this.f1058a.setScreen((Screen) null);
            return;
        }
        this.f1058a.gui.getChat().tick();
        if (!this.f1854bo) {
            this.f1854bo = true;
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(mo1337a(), (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), 1.5f));
        }
        this.f1852gA = this.f1851fi;
        this.f1851fi++;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == this.f1058a.options.keyChat.getKey().getValue()) {
            if (C0485iU.m2173f(this.f1058a)) {
                this.f1058a.setScreen(new C0231df(this));
                return false;
            }
            if (C0485iU.m2174Y()) {
                C0485iU.m2172c(this.f1058a, C0485iU.f2956hW);
                return false;
            }
            return false;
        }
        if (i == 256) {
            this.f1058a.setScreen(new C0150cN(this));
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
