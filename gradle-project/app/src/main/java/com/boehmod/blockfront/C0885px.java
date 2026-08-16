package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.px */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/px.class */
public class C0885px {

    /* JADX INFO: renamed from: pt */
    public static final int f4841pt = 13;

    /* JADX INFO: renamed from: pu */
    public static final int f4842pu = 9;

    /* JADX INFO: renamed from: pv */
    public static final int f4843pv = 23;

    /* JADX INFO: renamed from: pw */
    private static final int f4844pw = 32;

    /* JADX INFO: renamed from: px */
    private static final int f4845px = 16;

    /* JADX INFO: renamed from: py */
    private static final int f4846py = 0;

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final ResourceLocation[] f4847d = m4624a("compass");

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final ResourceLocation[] f4848e = m4624a("compass_pointer");

    /* JADX INFO: renamed from: dN */
    @NotNull
    private static final ResourceLocation f4849dN = C0532jO.m2378d("textures/gui/game/notification/compass_background.png");

    /* JADX INFO: renamed from: aN */
    private int f4850aN;

    /* JADX INFO: renamed from: aG */
    @NotNull
    private List<Component> f4851aG;

    /* JADX INFO: renamed from: aH */
    @NotNull
    private List<FormattedCharSequence> f4852aH;

    /* JADX INFO: renamed from: pz */
    private int f4853pz;

    /* JADX INFO: renamed from: ca */
    @Nullable
    private final String f4854ca;

    /* JADX INFO: renamed from: c */
    @Nullable
    private Vec3 f4855c;

    /* JADX INFO: renamed from: pA */
    private int f4856pA;

    /* JADX INFO: renamed from: dn */
    private int f4857dn;

    /* JADX INFO: renamed from: aI */
    private float f4858aI;

    /* JADX INFO: renamed from: aJ */
    private float f4859aJ;

    /* JADX INFO: renamed from: bw */
    private boolean f4860bw;

    public C0885px(@NotNull Component component, int i, boolean z, @Nullable String str) {
        this((List<Component>) List.of(component), i, z, str);
    }

    public C0885px(@NotNull List<Component> list, int i, boolean z, @Nullable String str) {
        this.f4853pz = -1;
        this.f4855c = null;
        this.f4856pA = ColorReferences.COLOR_WHITE;
        this.f4857dn = ColorReferences.COLOR_WHITE;
        this.f4858aI = 1.0f;
        this.f4859aJ = 1.0f;
        this.f4850aN = i;
        this.f4851aG = List.copyOf(list);
        this.f4852aH = m4625a(this.f4851aG);
        this.f4854ca = str;
        if (!z) {
            this.f4858aI = 0.0f;
            this.f4859aJ = 0.0f;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0885px m4620a(@Nullable Vec3 vec3, int i, int i2) {
        this.f4855c = vec3;
        this.f4856pA = i;
        this.f4857dn = i2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public Vec3 m4621c() {
        return this.f4855c;
    }

    /* JADX INFO: renamed from: bx */
    public int m4622bx() {
        return this.f4856pA;
    }

    /* JADX INFO: renamed from: w */
    public int m4623w() {
        return this.f4857dn;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation[] m4624a(@NotNull String str) {
        ResourceLocation[] resourceLocationArr = new ResourceLocation[32];
        for (int i = 0; i < 32; i++) {
            resourceLocationArr[i] = C0532jO.m2378d(String.format(Locale.ROOT, "textures/gui/game/notification/%s_%02d.png", str, Integer.valueOf(i)));
        }
        return resourceLocationArr;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static List<FormattedCharSequence> m4625a(@NotNull List<Component> list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        Iterator<Component> it = list.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getVisualOrderText());
        }
        return objectArrayList;
    }

    public int getHeight() {
        return 13 + ((this.f4852aH.size() - 1) * 9);
    }

    /* JADX INFO: renamed from: b */
    public void m4626b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.f4853pz < 0) {
            this.f4853pz = m4628a(font, this.f4852aH);
        }
        int i3 = this.f4853pz + 6 + (this.f4855c != null ? 16 : 0);
        int height = getHeight();
        int i4 = (i2 / 2) - (i3 / 2);
        int i5 = 23 + i;
        float fM7170f = C1270xJ.m7170f(this.f4858aI, this.f4859aJ, f);
        int iM465t = C0129bt.m465t() + C1270xJ.m7178a(0, 13421772, fM7170f);
        float f2 = ((iM465t >> 24) & 255) / 255.0f;
        C0129bt.m519b(guiGraphics, i4, i5, i3, height, iM465t, this.f4860bw ? f2 * (1.0f - fM7170f) : f2);
        C0129bt.m618a(guiGraphics, i4, i5, i3, height);
        float f3 = height * fM7170f;
        float f4 = i4 + 3 + (this.f4853pz / 2.0f);
        float f5 = i5 + 3.0f + f3;
        Iterator<FormattedCharSequence> it = this.f4852aH.iterator();
        while (it.hasNext()) {
            C0129bt.m509a(poseStack, font, guiGraphics, it.next(), f4, f5);
            f5 += 9.0f;
        }
        if (this.f4855c != null) {
            m4627a(poseStack, guiGraphics, this.f4855c, ((i4 + i3) - 16) - 0, i5 + ((height - 16) / 2.0f) + f3);
        }
        guiGraphics.disableScissor();
    }

    /* JADX INFO: renamed from: a */
    private void m4627a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Vec3 vec3, float f, float f2) {
        Camera mainCamera = Minecraft.getInstance().gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        int iFloor = Mth.floor((Mth.positiveModulo(1.0d - ((Mth.positiveModulo(((double) mainCamera.getYRot()) / 360.0d, 1.0d) - 0.25d) - (Math.atan2(vec3.z - position.z, vec3.x - position.x) / 6.283185307179586d)), 1.0d) * 32.0d) + 0.5d) % 32;
        C0129bt.m530a(poseStack, guiGraphics, f4847d[iFloor], f, f2, 16.0f, 16.0f);
        C0129bt.m536a(poseStack, guiGraphics, f4848e[iFloor], f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.f4856pA);
        C0129bt.m536a(poseStack, guiGraphics, f4849dN, f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.f4857dn);
    }

    /* JADX INFO: renamed from: a */
    private static int m4628a(@NotNull Font font, @NotNull List<FormattedCharSequence> list) {
        int iMax = 0;
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, font.width(it.next()));
        }
        return iMax;
    }

    /* JADX INFO: renamed from: l */
    public boolean m4629l() {
        int i = this.f4850aN;
        this.f4850aN = i - 1;
        this.f4860bw = i <= 0;
        this.f4859aJ = this.f4858aI;
        this.f4858aI = C1270xJ.m7183h(this.f4858aI, this.f4860bw ? 1.0f : 0.0f, this.f4860bw ? 0.5f : 0.35f);
        return this.f4860bw && this.f4858aI >= 0.95f;
    }

    /* JADX INFO: renamed from: b */
    public void m4630b(@NotNull Component component, int i) {
        m4631b(List.of(component), i);
    }

    /* JADX INFO: renamed from: b */
    public void m4631b(@NotNull List<Component> list, int i) {
        this.f4851aG = List.copyOf(list);
        this.f4852aH = m4625a(this.f4851aG);
        this.f4853pz = -1;
        this.f4850aN = i;
    }

    /* JADX INFO: renamed from: ba */
    public void m4632ba() {
        this.f4850aN = 0;
    }

    /* JADX INFO: renamed from: by */
    public int m4633by() {
        return this.f4850aN;
    }

    @NotNull
    /* JADX INFO: renamed from: G */
    public List<Component> m4634G() {
        return this.f4851aG;
    }

    @Nullable
    public String getKey() {
        return this.f4854ca;
    }
}
