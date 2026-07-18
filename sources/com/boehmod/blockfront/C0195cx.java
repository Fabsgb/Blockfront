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

/* JADX INFO: renamed from: com.boehmod.blockfront.cx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cx.class */
public class C0195cx extends C0196cy {

    /* JADX INFO: renamed from: aH */
    public static final ResourceLocation f1564aH = C0564jv.m2555d("textures/gui/menu/icons/return.png");

    /* JADX INFO: renamed from: aI */
    public static final ResourceLocation f1565aI = C0564jv.m2555d("textures/gui/logo/blockfront.png");

    /* JADX INFO: renamed from: aJ */
    public static final ResourceLocation f1566aJ = C0564jv.m2555d("textures/gui/backshadow.png");

    /* JADX INFO: renamed from: aK */
    public static final ResourceLocation f1567aK = C0564jv.m2555d("textures/gui/effects/fade.png");

    /* JADX INFO: renamed from: aL */
    public static final ResourceLocation f1568aL = C0564jv.m2555d("textures/gui/effects/fade_yellow.png");

    /* JADX INFO: renamed from: aM */
    public static final ResourceLocation f1569aM = C0564jv.m2555d("textures/gui/effects/starburst.png");

    /* JADX INFO: renamed from: aN */
    public static final ResourceLocation f1570aN = C0564jv.m2555d("textures/gui/shadoweffect_strong.png");

    /* JADX INFO: renamed from: aO */
    public static final ResourceLocation f1571aO = C0564jv.m2555d("textures/gui/shadoweffect.png");

    /* JADX INFO: renamed from: aP */
    public static final ResourceLocation f1572aP = C0564jv.m2555d("textures/misc/ranks/bg_us.png");

    /* JADX INFO: renamed from: aQ */
    public static final ResourceLocation f1573aQ = C0564jv.m2555d("textures/gui/credits/line.png");

    /* JADX INFO: renamed from: aR */
    public static final ResourceLocation f1574aR = C0564jv.m2555d("textures/gui/trophy.png");

    /* JADX INFO: renamed from: aS */
    public static final ResourceLocation f1575aS = C0564jv.m2555d("textures/gui/menu/flare_white.png");

    /* JADX INFO: renamed from: aT */
    public static final ResourceLocation f1576aT = C0564jv.m2555d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: aU */
    public static final ResourceLocation f1577aU = C0564jv.m2555d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final ObjectList<AbstractC0242dr> f1578t = new ObjectArrayList();

    /* JADX INFO: renamed from: u */
    @NotNull
    protected static final ObjectList<InterfaceC0092bJ> f1579u = new ObjectArrayList();

    /* JADX INFO: renamed from: aV */
    @NotNull
    private static final ResourceLocation f1580aV = C0564jv.m2555d("texts/splashes.txt");

    /* JADX INFO: renamed from: E */
    private static final String f1581E = I18n.get("bf.cloud.popup.title.error", new Object[0]);

    /* JADX INFO: renamed from: F */
    @NotNull
    public static String f1582F = m1190k();

    /* JADX INFO: renamed from: p */
    protected final List<C0130bv> f1583p;

    /* JADX INFO: renamed from: bj */
    @NotNull
    public Component f1584bj;

    static {
        f1578t.add(new C0246dv());
        f1578t.add(new C0249dy());
        f1578t.add(new C0243ds());
        f1578t.add(new C0248dx());
        f1578t.add(new C0245du());
        f1578t.add(new C0244dt());
        f1578t.add(new C0247dw());
    }

    public C0195cx(@NotNull Component component, @NotNull Component component2) {
        super(component);
        this.f1583p = new ObjectArrayList();
        this.f1584bj = component2;
    }

    public C0195cx(@NotNull Component component) {
        this(component, Component.empty());
    }

    /* JADX INFO: renamed from: b */
    public static void m1186b(@NotNull Minecraft minecraft, @NotNull String str) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7555pm.get(), 1.0f));
        Util.getPlatform().openUri(str);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1187a(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.AND_EQ);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1188b(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), 256);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1189c(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.CHARACTER);
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public static String m1190k() {
        try {
            ObjectArrayList objectArrayList = new ObjectArrayList(Minecraft.getInstance().getResourceManager().openAsReader(f1580aV).lines().map((v0) -> {
                return v0.trim();
            }).filter(str -> {
                return !str.startsWith("#");
            }).toList());
            return (String) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        } catch (IOException e) {
            C0562jt.m2516a("Error while updating splash text.", e, new Object[0]);
            return f1581E;
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m1191a(@NotNull Minecraft minecraft, @NotNull InterfaceC0092bJ interfaceC0092bJ) {
        f1579u.add(interfaceC0092bJ);
        interfaceC0092bJ.mo289m(minecraft);
    }

    public void tick() {
        super.tick();
        float fM366g = C0119bk.m366g();
        Iterator<C0130bv> it = this.f1583p.iterator();
        while (it.hasNext()) {
            it.next().mo686a(this.f1587b, this.f1586e, this.f1585a, fM366g);
        }
        for (AbstractC0288ek abstractC0288ek : this.renderables) {
            if (abstractC0288ek instanceof AbstractC0288ek) {
                abstractC0288ek.mo1519a(fM366g);
            }
        }
        ObjectListIterator it2 = f1578t.iterator();
        while (it2.hasNext()) {
            ((AbstractC0242dr) it2.next()).mo1413a(this.f1587b, this.f1586e, this, fM366g);
        }
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        C0326fV c0326fV = (C0326fV) this.f1586e.m2670a();
        ClientLevel clientLevel = this.f1587b.level;
        C0482iS c0482iSM1676a = c0326fV.m1676a(this.f1587b);
        RenderSystem.disableDepthTest();
        poseStackPose.pushPose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -100.0f);
        renderBackground(guiGraphics, i, i2, f);
        poseStackPose.popPose();
        super.render(guiGraphics, i, i2, f);
        if (clientLevel == null) {
            ObjectListIterator it = f1578t.iterator();
            while (it.hasNext()) {
                ((AbstractC0242dr) it.next()).mo1411a(this.f1587b, this.f1586e, c0482iSM1676a, this, guiGraphics, poseStackPose, this.font, this.width, this.height, i, i2, fM366g, f);
            }
        }
        m1192a(this.f1587b, c0326fV, poseStackPose, guiGraphics, c0482iSM1676a, i, i2, fM366g, f);
        if (clientLevel == null) {
            ObjectListIterator it2 = f1578t.iterator();
            while (it2.hasNext()) {
                ((AbstractC0242dr) it2.next()).mo1412a(this.f1587b, this.f1586e, this, poseStackPose, guiGraphics, this.font, this.width, this.height, i, i2, fM366g, f);
            }
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m1192a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0482iS c0482iS, int i, int i2, float f, float f2) {
        Iterator<C0130bv> it = this.f1583p.iterator();
        while (it.hasNext()) {
            it.next().mo687a(minecraft, this.f1586e, c0326fV, poseStack, guiGraphics, this.font, c0482iS, i, i2, f, f2);
        }
        Iterator<C0130bv> it2 = this.f1583p.iterator();
        while (it2.hasNext()) {
            it2.next().m688a(minecraft, this.f1586e, c0326fV, this.font, guiGraphics, i, i2, f2);
        }
    }

    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ClientLevel clientLevel = this.f1587b.level;
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        if (clientLevel != null && !this.f1587b.hasSingleplayerServer()) {
            C0119bk.m526b(this.f1587b, f);
            C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p());
            return;
        }
        if (clientLevel == null) {
            C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStackPose.pushPose();
        ObjectListIterator it = f1578t.iterator();
        while (it.hasNext()) {
            ((AbstractC0242dr) it.next()).mo1410a(this.f1586e, this.f1585a, this.f1587b, this, poseStackPose, this.font, guiGraphics, this.width, this.height, i, i2, fM366g, f);
        }
        poseStackPose.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public List<InterfaceC0092bJ> m1193d() {
        return f1579u;
    }

    public void init() {
        super.init();
        m1190k();
        mo744G();
        mo775E();
        Iterator<C0130bv> it = this.f1583p.iterator();
        while (it.hasNext()) {
            it.next().mo685a(this.f1587b, this.f1586e, this.f1585a);
        }
    }

    public boolean mouseClicked(double d, double d2, int i) {
        try {
            Iterator<C0130bv> it = this.f1583p.iterator();
            while (it.hasNext()) {
                if (it.next().mo691a(this.f1587b, this.f1586e, this.f1585a, d, d2, i)) {
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
        Iterator<C0130bv> it = this.f1583p.iterator();
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
        Iterator<C0130bv> it = this.f1583p.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        Iterator<C0130bv> it = this.f1583p.iterator();
        while (it.hasNext()) {
            if (it.next().keyPressed(i, i2, i3)) {
                return true;
            }
        }
        return super.keyPressed(i, i2, i3);
    }

    /* JADX INFO: renamed from: G */
    public void mo744G() {
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        m1194K();
    }

    /* JADX INFO: renamed from: K */
    public void m1194K() {
        this.f1583p.clear();
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void m1195a(C0130bv c0130bv) {
        this.f1583p.add(c0130bv);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1196a(@NotNull C0127bs c0127bs) {
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            if (((Renderable) it.next()) == c0127bs) {
                return true;
            }
        }
        Iterator<C0130bv> it2 = this.f1583p.iterator();
        while (it2.hasNext()) {
            if (it2.next().m698b((AbstractWidget) c0127bs)) {
                return true;
            }
        }
        return false;
    }
}
