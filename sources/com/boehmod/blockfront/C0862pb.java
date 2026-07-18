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

/* JADX INFO: renamed from: com.boehmod.blockfront.pb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pb.class */
public class C0862pb {

    /* JADX INFO: renamed from: nu */
    public static final int f4508nu = 13;

    /* JADX INFO: renamed from: nv */
    public static final int f4509nv = 9;

    /* JADX INFO: renamed from: nw */
    public static final int f4510nw = 23;

    /* JADX INFO: renamed from: nx */
    private static final int f4511nx = 32;

    /* JADX INFO: renamed from: ny */
    private static final int f4512ny = 16;

    /* JADX INFO: renamed from: nz */
    private static final int f4513nz = 0;

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final ResourceLocation[] f4514c = m4299a("compass");

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final ResourceLocation[] f4515d = m4299a("compass_pointer");

    /* JADX INFO: renamed from: dP */
    @NotNull
    private static final ResourceLocation f4516dP = C0564jv.m2555d("textures/gui/game/notification/compass_background.png");

    /* JADX INFO: renamed from: Z */
    private int f4517Z;

    /* JADX INFO: renamed from: az */
    @NotNull
    private List<Component> f4518az;

    /* JADX INFO: renamed from: aA */
    @NotNull
    private List<FormattedCharSequence> f4519aA;

    /* JADX INFO: renamed from: nA */
    private int f4520nA;

    /* JADX INFO: renamed from: bQ */
    @Nullable
    private final String f4521bQ;

    /* JADX INFO: renamed from: c */
    @Nullable
    private Vec3 f4522c;

    /* JADX INFO: renamed from: nB */
    private int f4523nB;

    /* JADX INFO: renamed from: cv */
    private int f4524cv;

    /* JADX INFO: renamed from: aD */
    private float f4525aD;

    /* JADX INFO: renamed from: aE */
    private float f4526aE;

    /* JADX INFO: renamed from: bs */
    private boolean f4527bs;

    public C0862pb(@NotNull Component component, int i, boolean z, @Nullable String str) {
        this((List<Component>) List.of(component), i, z, str);
    }

    public C0862pb(@NotNull List<Component> list, int i, boolean z, @Nullable String str) {
        this.f4520nA = -1;
        this.f4522c = null;
        this.f4523nB = ColorReferences.COLOR_WHITE;
        this.f4524cv = ColorReferences.COLOR_WHITE;
        this.f4525aD = 1.0f;
        this.f4526aE = 1.0f;
        this.f4517Z = i;
        this.f4518az = List.copyOf(list);
        this.f4519aA = m4300a(this.f4518az);
        this.f4521bQ = str;
        if (!z) {
            this.f4525aD = 0.0f;
            this.f4526aE = 0.0f;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0862pb m4295a(@Nullable Vec3 vec3, int i, int i2) {
        this.f4522c = vec3;
        this.f4523nB = i;
        this.f4524cv = i2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public Vec3 m4296c() {
        return this.f4522c;
    }

    /* JADX INFO: renamed from: bi */
    public int m4297bi() {
        return this.f4523nB;
    }

    /* JADX INFO: renamed from: s */
    public int m4298s() {
        return this.f4524cv;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation[] m4299a(@NotNull String str) {
        ResourceLocation[] resourceLocationArr = new ResourceLocation[32];
        for (int i = 0; i < 32; i++) {
            resourceLocationArr[i] = C0564jv.m2555d(String.format(Locale.ROOT, "textures/gui/game/notification/%s_%02d.png", str, Integer.valueOf(i)));
        }
        return resourceLocationArr;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static List<FormattedCharSequence> m4300a(@NotNull List<Component> list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        Iterator<Component> it = list.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getVisualOrderText());
        }
        return objectArrayList;
    }

    public int getHeight() {
        return 13 + ((this.f4519aA.size() - 1) * 9);
    }

    /* JADX INFO: renamed from: b */
    public void m4301b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.f4520nA < 0) {
            this.f4520nA = m4303a(font, this.f4519aA);
        }
        int i3 = this.f4520nA + 6 + (this.f4522c != null ? 16 : 0);
        int height = getHeight();
        int i4 = (i2 / 2) - (i3 / 2);
        int i5 = 23 + i;
        float fM7843e = C1290xm.m7843e(this.f4525aD, this.f4526aE, f);
        int iM365p = C0119bk.m365p() + C1290xm.m7851a(0, 13421772, fM7843e);
        float f2 = ((iM365p >> 24) & 255) / 255.0f;
        C0119bk.m419b(guiGraphics, i4, i5, i3, height, iM365p, this.f4527bs ? f2 * (1.0f - fM7843e) : f2);
        C0119bk.m517a(guiGraphics, i4, i5, i3, height);
        float f3 = height * fM7843e;
        float f4 = i4 + 3 + (this.f4520nA / 2.0f);
        float f5 = i5 + 3.0f + f3;
        Iterator<FormattedCharSequence> it = this.f4519aA.iterator();
        while (it.hasNext()) {
            C0119bk.m409a(poseStack, font, guiGraphics, it.next(), f4, f5);
            f5 += 9.0f;
        }
        if (this.f4522c != null) {
            m4302a(poseStack, guiGraphics, this.f4522c, ((i4 + i3) - 16) - 0, i5 + ((height - 16) / 2.0f) + f3);
        }
        guiGraphics.disableScissor();
    }

    /* JADX INFO: renamed from: a */
    private void m4302a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Vec3 vec3, float f, float f2) {
        Camera mainCamera = Minecraft.getInstance().gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        int iFloor = Mth.floor((Mth.positiveModulo(1.0d - ((Mth.positiveModulo(((double) mainCamera.getYRot()) / 360.0d, 1.0d) - 0.25d) - (Math.atan2(vec3.z - position.z, vec3.x - position.x) / 6.283185307179586d)), 1.0d) * 32.0d) + 0.5d) % 32;
        C0119bk.m430a(poseStack, guiGraphics, f4514c[iFloor], f, f2, 16.0f, 16.0f);
        C0119bk.m436a(poseStack, guiGraphics, f4515d[iFloor], f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.f4523nB);
        C0119bk.m436a(poseStack, guiGraphics, f4516dP, f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.f4524cv);
    }

    /* JADX INFO: renamed from: a */
    private static int m4303a(@NotNull Font font, @NotNull List<FormattedCharSequence> list) {
        int iMax = 0;
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, font.width(it.next()));
        }
        return iMax;
    }

    /* JADX INFO: renamed from: k */
    public boolean m4304k() {
        int i = this.f4517Z;
        this.f4517Z = i - 1;
        this.f4527bs = i <= 0;
        this.f4526aE = this.f4525aD;
        this.f4525aD = C1290xm.m7856g(this.f4525aD, this.f4527bs ? 1.0f : 0.0f, this.f4527bs ? 0.5f : 0.35f);
        return this.f4527bs && this.f4525aD >= 0.95f;
    }

    /* JADX INFO: renamed from: b */
    public void m4305b(@NotNull Component component, int i) {
        m4306b(List.of(component), i);
    }

    /* JADX INFO: renamed from: b */
    public void m4306b(@NotNull List<Component> list, int i) {
        this.f4518az = List.copyOf(list);
        this.f4519aA = m4300a(this.f4518az);
        this.f4520nA = -1;
        this.f4517Z = i;
    }

    /* JADX INFO: renamed from: aS */
    public void m4307aS() {
        this.f4517Z = 0;
    }

    /* JADX INFO: renamed from: bj */
    public int m4308bj() {
        return this.f4517Z;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public List<Component> m4309E() {
        return this.f4518az;
    }

    @Nullable
    public String getKey() {
        return this.f4521bQ;
    }
}
