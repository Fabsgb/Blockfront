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
import java.net.URI;
import java.net.URISyntaxException;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cG.class */
public class C0143cG extends C0144cH {

    /* JADX INFO: renamed from: aH */
    @NotNull
    public static final ResourceLocation f1037aH = C0532jO.m2378d("textures/gui/menu/icons/return.png");

    /* JADX INFO: renamed from: aI */
    @NotNull
    public static final ResourceLocation f1038aI = C0532jO.m2378d("textures/gui/logo/blockfront.png");

    /* JADX INFO: renamed from: aJ */
    @NotNull
    public static final ResourceLocation f1039aJ = C0532jO.m2378d("textures/gui/backshadow.png");

    /* JADX INFO: renamed from: aK */
    @NotNull
    public static final ResourceLocation f1040aK = C0532jO.m2378d("textures/gui/effects/fade.png");

    /* JADX INFO: renamed from: aL */
    @NotNull
    public static final ResourceLocation f1041aL = C0532jO.m2378d("textures/gui/effects/fade_yellow.png");

    /* JADX INFO: renamed from: aM */
    @NotNull
    public static final ResourceLocation f1042aM = C0532jO.m2378d("textures/gui/effects/starburst.png");

    /* JADX INFO: renamed from: aN */
    @NotNull
    public static final ResourceLocation f1043aN = C0532jO.m2378d("textures/gui/shadoweffect_strong.png");

    /* JADX INFO: renamed from: aO */
    @NotNull
    public static final ResourceLocation f1044aO = C0532jO.m2378d("textures/misc/ranks/bg_us.png");

    /* JADX INFO: renamed from: aP */
    @NotNull
    public static final ResourceLocation f1045aP = C0532jO.m2378d("textures/gui/trophy.png");

    /* JADX INFO: renamed from: aQ */
    @NotNull
    public static final ResourceLocation f1046aQ = C0532jO.m2378d("textures/gui/menu/flare_white.png");

    /* JADX INFO: renamed from: aR */
    @NotNull
    public static final ResourceLocation f1047aR = C0532jO.m2378d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: aS */
    @NotNull
    public static final ResourceLocation f1048aS = C0532jO.m2378d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final ObjectList<AbstractC0200dA> f1049C = new ObjectArrayList();

    /* JADX INFO: renamed from: D */
    @NotNull
    protected static final ObjectList<InterfaceC0102bS> f1050D = new ObjectArrayList();

    /* JADX INFO: renamed from: aT */
    @NotNull
    private static final ResourceLocation f1051aT = C0532jO.m2378d("texts/splashes.txt");

    /* JADX INFO: renamed from: K */
    private static final String f1052K = I18n.get("bf.cloud.popup.title.error", new Object[0]);

    /* JADX INFO: renamed from: L */
    @NotNull
    public static String f1053L = m789o();

    /* JADX INFO: renamed from: r */
    protected final List<C0088bE> f1054r;

    /* JADX INFO: renamed from: bl */
    @NotNull
    public Component f1055bl;

    static {
        f1049C.add(new C0204dE());
        f1049C.add(new C0207dH());
        f1049C.add(new C0201dB());
        f1049C.add(new C0206dG());
        f1049C.add(new C0203dD());
        f1049C.add(new C0202dC());
        f1049C.add(new C0205dF());
    }

    public C0143cG(@NotNull Component component, @NotNull Component component2) {
        super(component);
        this.f1054r = new ObjectArrayList();
        this.f1055bl = component2;
    }

    public C0143cG(@NotNull Component component) {
        this(component, Component.empty());
    }

    /* JADX INFO: renamed from: b */
    public static void m784b(@NotNull Minecraft minecraft, @NotNull String str) {
        if (!m785c(str)) {
            C0530jM.log("[GUI] Refused to open a URL that is not http(s). ('%s')", str);
        } else {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7967po.get(), 1.0f));
            Util.getPlatform().openUri(str);
        }
    }

    /* JADX INFO: renamed from: c */
    private static boolean m785c(@NotNull String str) {
        try {
            String scheme = new URI(str).getScheme();
            return "https".equalsIgnoreCase(scheme) || "http".equalsIgnoreCase(scheme);
        } catch (URISyntaxException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m786a(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.AND_EQ);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m787b(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), 256);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m788c(@NotNull Minecraft minecraft) {
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), Token.CHARACTER);
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public static String m789o() {
        try {
            ObjectArrayList objectArrayList = new ObjectArrayList(Minecraft.getInstance().getResourceManager().openAsReader(f1051aT).lines().map((v0) -> {
                return v0.trim();
            }).filter(str -> {
                return !str.startsWith("#");
            }).toList());
            return (String) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        } catch (IOException e) {
            C0530jM.m2338a("Error while updating splash text.", e, new Object[0]);
            return f1052K;
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m790a(@NotNull Minecraft minecraft, @NotNull InterfaceC0102bS interfaceC0102bS) {
        f1050D.add(interfaceC0102bS);
        interfaceC0102bS.mo394n(minecraft);
    }

    public void tick() {
        super.tick();
        float fM466g = C0129bt.m466g();
        Iterator<C0088bE> it = this.f1054r.iterator();
        while (it.hasNext()) {
            it.next().mo361a(this.f1058a, this.f1057f, this.f1056a, fM466g);
        }
        for (AbstractC0302ex abstractC0302ex : this.renderables) {
            if (abstractC0302ex instanceof AbstractC0302ex) {
                abstractC0302ex.mo1443a(fM466g);
            }
        }
        ObjectListIterator it2 = f1049C.iterator();
        while (it2.hasNext()) {
            ((AbstractC0200dA) it2.next()).mo1239a(this.f1058a, this.f1057f, this, fM466g);
        }
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        C0396gl c0396gl = (C0396gl) this.f1057f.m2855a();
        ClientLevel clientLevel = this.f1058a.level;
        C0555jl c0555jlM1886a = c0396gl.m1886a(this.f1058a);
        RenderSystem.disableDepthTest();
        poseStackPose.pushPose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -100.0f);
        renderBackground(guiGraphics, i, i2, f);
        poseStackPose.popPose();
        super.render(guiGraphics, i, i2, f);
        if (clientLevel == null) {
            ObjectListIterator it = f1049C.iterator();
            while (it.hasNext()) {
                ((AbstractC0200dA) it.next()).mo1237a(this.f1058a, this.f1057f, c0555jlM1886a, this, guiGraphics, poseStackPose, this.font, this.width, this.height, i, i2, fM466g, f);
            }
        }
        m791a(this.f1058a, c0396gl, poseStackPose, guiGraphics, c0555jlM1886a, i, i2, fM466g, f);
        if (clientLevel == null) {
            ObjectListIterator it2 = f1049C.iterator();
            while (it2.hasNext()) {
                ((AbstractC0200dA) it2.next()).mo1238a(this.f1058a, this.f1057f, this, poseStackPose, guiGraphics, this.font, this.width, this.height, i, i2, fM466g, f);
            }
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public void m791a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0555jl c0555jl, int i, int i2, float f, float f2) {
        Iterator<C0088bE> it = this.f1054r.iterator();
        while (it.hasNext()) {
            it.next().mo362a(minecraft, this.f1057f, c0396gl, poseStack, guiGraphics, this.font, c0555jl, i, i2, f, f2);
        }
        Iterator<C0088bE> it2 = this.f1054r.iterator();
        while (it2.hasNext()) {
            it2.next().m363a(minecraft, this.f1057f, c0396gl, this.font, guiGraphics, i, i2, f2);
        }
    }

    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ClientLevel clientLevel = this.f1058a.level;
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        if (clientLevel != null && !this.f1058a.hasSingleplayerServer()) {
            C0129bt.m628b(this.f1058a, f);
            C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t());
            return;
        }
        if (clientLevel == null) {
            C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStackPose.pushPose();
        ObjectListIterator it = f1049C.iterator();
        while (it.hasNext()) {
            ((AbstractC0200dA) it.next()).mo1236a(this.f1057f, this.f1056a, this.f1058a, this, poseStackPose, this.font, guiGraphics, this.width, this.height, i, i2, fM466g, f);
        }
        poseStackPose.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public List<InterfaceC0102bS> m792e() {
        return f1050D;
    }

    public void init() {
        super.init();
        m789o();
        mo776K();
        mo777H();
        Iterator<C0088bE> it = this.f1054r.iterator();
        while (it.hasNext()) {
            it.next().mo360a(this.f1058a, this.f1057f, this.f1056a);
        }
    }

    public boolean mouseClicked(double d, double d2, int i) {
        try {
            Iterator<C0088bE> it = this.f1054r.iterator();
            while (it.hasNext()) {
                if (it.next().mo366a(this.f1058a, this.f1057f, this.f1056a, d, d2, i)) {
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
        Iterator<C0088bE> it = this.f1054r.iterator();
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
        Iterator<C0088bE> it = this.f1054r.iterator();
        while (it.hasNext()) {
            if (it.next().mouseScrolled(d, d2, d3, d4)) {
                return true;
            }
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        Iterator<C0088bE> it = this.f1054r.iterator();
        while (it.hasNext()) {
            if (it.next().keyPressed(i, i2, i3)) {
                return true;
            }
        }
        return super.keyPressed(i, i2, i3);
    }

    /* JADX INFO: renamed from: K */
    public void mo776K() {
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        m793O();
    }

    /* JADX INFO: renamed from: O */
    public void m793O() {
        this.f1054r.clear();
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void m794a(C0088bE c0088bE) {
        this.f1054r.add(c0088bE);
    }

    /* JADX INFO: renamed from: a */
    public boolean m795a(@NotNull C0085bB c0085bB) {
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            if (((Renderable) it.next()) == c0085bB) {
                return true;
            }
        }
        Iterator<C0088bE> it2 = this.f1054r.iterator();
        while (it2.hasNext()) {
            if (it2.next().m373b((AbstractWidget) c0085bB)) {
                return true;
            }
        }
        return false;
    }
}
