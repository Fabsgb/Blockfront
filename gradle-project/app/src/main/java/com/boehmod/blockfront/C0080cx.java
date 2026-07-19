package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cx.class */
public class C0080cx extends C0081cy {
    public static final ResourceLocation aH = C0265jv.d("textures/gui/menu/icons/return.png");
    public static final ResourceLocation aI = C0265jv.d("textures/gui/logo/blockfront.png");
    public static final ResourceLocation aJ = C0265jv.d("textures/gui/backshadow.png");
    public static final ResourceLocation aK = C0265jv.d("textures/gui/effects/fade.png");
    public static final ResourceLocation aL = C0265jv.d("textures/gui/effects/fade_yellow.png");
    public static final ResourceLocation aM = C0265jv.d("textures/gui/effects/starburst.png");
    public static final ResourceLocation aN = C0265jv.d("textures/gui/shadoweffect_strong.png");
    public static final ResourceLocation aO = C0265jv.d("textures/gui/shadoweffect.png");
    public static final ResourceLocation aP = C0265jv.d("textures/misc/ranks/bg_us.png");
    public static final ResourceLocation aQ = C0265jv.d("textures/gui/credits/line.png");
    public static final ResourceLocation aR = C0265jv.d("textures/gui/trophy.png");
    public static final ResourceLocation aS = C0265jv.d("textures/gui/menu/flare_white.png");
    public static final ResourceLocation aT = C0265jv.d("textures/gui/backshadow_white.png");
    public static final ResourceLocation aU = C0265jv.d("textures/gui/cornershadow.png");

    @NotNull
    public static final ObjectList<AbstractC0100dr> t = new ObjectArrayList();

    @NotNull
    protected static final ObjectList<bJ> u = new ObjectArrayList();

    @NotNull
    private static final ResourceLocation aV = C0265jv.d("texts/splashes.txt");
    private static final String E = I18n.get("bf.cloud.popup.title.error", new Object[0]);

    @NotNull
    public static String F = k();
    protected final List<C0051bv> p;

    @NotNull
    public Component bj;

    static {
        t.add(new C0104dv());
        t.add(new C0107dy());
        t.add(new C0101ds());
        t.add(new C0106dx());
        t.add(new C0103du());
        t.add(new C0102dt());
        t.add(new C0105dw());
    }

    public C0080cx(@NotNull Component component, @NotNull Component component2) {
        super(component);
        this.p = new ObjectArrayList();
        this.bj = component2;
    }

    public C0080cx(@NotNull Component component) {
        this(component, Component.empty());
    }

    public static void b(@NotNull Minecraft minecraft, @NotNull String str) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pm.get(), 1.0f));
        Util.getPlatform().openUri(str);
    }

    public static boolean a(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.AND_EQ);
    }

    public static boolean b(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), 256);
    }

    public static boolean c(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.CHARACTER);
    }

    @NotNull
    public static String k() {
        try {
            ObjectArrayList objectArrayList = new ObjectArrayList(Minecraft.getInstance().getResourceManager().openAsReader(aV).lines().map((v0) -> {
                return v0.trim();
            }).filter(str -> {
                return !str.startsWith("#");
            }).toList());
            return (String) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        } catch (IOException e) {
            C0263jt.a("Error while updating splash text.", e, new Object[0]);
            return E;
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull bJ bJVar) {
        u.add(bJVar);
        bJVar.m(minecraft);
    }

    public void tick() {
        super.tick();
        float fG = C0040bk.g();
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, this.e, this.a, fG);
        }
        for (AbstractC0120ek abstractC0120ek : this.renderables) {
            if (abstractC0120ek instanceof AbstractC0120ek) {
                abstractC0120ek.a(fG);
            }
        }
        ObjectListIterator it2 = t.iterator();
        while (it2.hasNext()) {
            ((AbstractC0100dr) it2.next()).a(this.b, this.e, this, fG);
        }
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        fV fVVar = (fV) this.e.a();
        ClientLevel clientLevel = this.b.level;
        iS iSVarM404a = fVVar.m404a(this.b);
        RenderSystem.disableDepthTest();
        poseStackPose.pushPose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -100.0f);
        renderBackground(guiGraphics, i, i2, f);
        poseStackPose.popPose();
        super.render(guiGraphics, i, i2, f);
        if (clientLevel == null) {
            ObjectListIterator it = t.iterator();
            while (it.hasNext()) {
                ((AbstractC0100dr) it.next()).a(this.b, this.e, iSVarM404a, this, guiGraphics, poseStackPose, this.font, this.width, this.height, i, i2, fG, f);
            }
        }
        a(this.b, fVVar, poseStackPose, guiGraphics, iSVarM404a, i, i2, fG, f);
        if (clientLevel == null) {
            ObjectListIterator it2 = t.iterator();
            while (it2.hasNext()) {
                ((AbstractC0100dr) it2.next()).a(this.b, this.e, this, poseStackPose, guiGraphics, this.font, this.width, this.height, i, i2, fG, f);
            }
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
        poseStackPose.popPose();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull iS iSVar, int i, int i2, float f, float f2) {
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, this.e, fVVar, poseStack, guiGraphics, this.font, iSVar, i, i2, f, f2);
        }
        Iterator<C0051bv> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().a(minecraft, this.e, fVVar, this.font, guiGraphics, i, i2, f2);
        }
    }

    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ClientLevel clientLevel = this.b.level;
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        if (clientLevel != null && !this.b.hasSingleplayerServer()) {
            C0040bk.b(this.b, f);
            C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p());
            return;
        }
        if (clientLevel == null) {
            C0040bk.a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStackPose.pushPose();
        ObjectListIterator it = t.iterator();
        while (it.hasNext()) {
            ((AbstractC0100dr) it.next()).a(this.e, this.a, this.b, this, poseStackPose, this.font, guiGraphics, this.width, this.height, i, i2, fG, f);
        }
        poseStackPose.popPose();
    }

    @NotNull
    public List<bJ> d() {
        return u;
    }

    public void init() {
        super.init();
        k();
        mo280G();
        E();
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, this.e, this.a);
        }
    }

    public boolean mouseClicked(double d, double d2, int i) {
        try {
            Iterator<C0051bv> it = this.p.iterator();
            while (it.hasNext()) {
                if (it.next().a(this.b, this.e, this.a, d, d2, i)) {
                    return true;
                }
            }
            return super.mouseClicked(d, d2, i);
        } catch (ConcurrentModificationException e) {
            return false;
        }
    }

    public boolean mouseReleased(double d, double d2, int i) {
        boolean z = false;
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            if (it.next().mouseReleased(d, d2, i)) {
                z = true;
            }
        }
        if (z) {
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        Iterator<C0051bv> it = this.p.iterator();
        while (it.hasNext()) {
            if (it.next().keyPressed(i, i2, i3)) {
                return true;
            }
        }
        return super.keyPressed(i, i2, i3);
    }

    /* JADX INFO: renamed from: G */
    public void mo280G() {
    }

    @OverridingMethodsMustInvokeSuper
    public void E() {
        K();
    }

    public void K() {
        this.p.clear();
    }

    @OverridingMethodsMustInvokeSuper
    public void a(C0051bv c0051bv) {
        this.p.add(c0051bv);
    }

    public boolean a(@NotNull C0048bs c0048bs) {
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            if (((Renderable) it.next()) == c0048bs) {
                return true;
            }
        }
        Iterator<C0051bv> it2 = this.p.iterator();
        while (it2.hasNext()) {
            if (it2.next().b((AbstractWidget) c0048bs)) {
                return true;
            }
        }
        return false;
    }
}
