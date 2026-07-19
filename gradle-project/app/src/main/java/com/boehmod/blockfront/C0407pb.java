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

/* JADX INFO: renamed from: com.boehmod.blockfront.pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pb.class */
public class C0407pb {
    public static final int nu = 13;
    public static final int nv = 9;
    public static final int nw = 23;
    private static final int nx = 32;
    private static final int ny = 16;
    private static final int nz = 0;

    @NotNull
    private static final ResourceLocation[] c = a("compass");

    @NotNull
    private static final ResourceLocation[] d = a("compass_pointer");

    @NotNull
    private static final ResourceLocation dP = C0265jv.d("textures/gui/game/notification/compass_background.png");
    private int Z;

    @NotNull
    private List<Component> az;

    @NotNull
    private List<FormattedCharSequence> aA;
    private int nA;

    @Nullable
    private final String bQ;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    private Vec3 f279c;
    private int nB;
    private int cv;
    private float aD;
    private float aE;
    private boolean bs;

    public C0407pb(@NotNull Component component, int i, boolean z, @Nullable String str) {
        this((List<Component>) List.of(component), i, z, str);
    }

    public C0407pb(@NotNull List<Component> list, int i, boolean z, @Nullable String str) {
        this.nA = -1;
        this.f279c = null;
        this.nB = ColorReferences.COLOR_WHITE;
        this.cv = ColorReferences.COLOR_WHITE;
        this.aD = 1.0f;
        this.aE = 1.0f;
        this.Z = i;
        this.az = List.copyOf(list);
        this.aA = a(this.az);
        this.bQ = str;
        if (!z) {
            this.aD = 0.0f;
            this.aE = 0.0f;
        }
    }

    @NotNull
    public C0407pb a(@Nullable Vec3 vec3, int i, int i2) {
        this.f279c = vec3;
        this.nB = i;
        this.cv = i2;
        return this;
    }

    @Nullable
    public Vec3 c() {
        return this.f279c;
    }

    public int bi() {
        return this.nB;
    }

    public int s() {
        return this.cv;
    }

    @NotNull
    private static ResourceLocation[] a(@NotNull String str) {
        ResourceLocation[] resourceLocationArr = new ResourceLocation[32];
        for (int i = 0; i < 32; i++) {
            resourceLocationArr[i] = C0265jv.d(String.format(Locale.ROOT, "textures/gui/game/notification/%s_%02d.png", str, Integer.valueOf(i)));
        }
        return resourceLocationArr;
    }

    @NotNull
    private static List<FormattedCharSequence> a(@NotNull List<Component> list) {
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        Iterator<Component> it = list.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getVisualOrderText());
        }
        return objectArrayList;
    }

    public int getHeight() {
        return 13 + ((this.aA.size() - 1) * 9);
    }

    public void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        if (this.nA < 0) {
            this.nA = a(font, this.aA);
        }
        int i3 = this.nA + 6 + (this.f279c != null ? 16 : 0);
        int height = getHeight();
        int i4 = (i2 / 2) - (i3 / 2);
        int i5 = 23 + i;
        float fE = C0634xm.e(this.aD, this.aE, f);
        int iP = C0040bk.p() + C0634xm.a(0, 13421772, fE);
        float f2 = ((iP >> 24) & 255) / 255.0f;
        C0040bk.b(guiGraphics, i4, i5, i3, height, iP, this.bs ? f2 * (1.0f - fE) : f2);
        C0040bk.a(guiGraphics, i4, i5, i3, height);
        float f3 = height * fE;
        float f4 = i4 + 3 + (this.nA / 2.0f);
        float f5 = i5 + 3.0f + f3;
        Iterator<FormattedCharSequence> it = this.aA.iterator();
        while (it.hasNext()) {
            C0040bk.a(poseStack, font, guiGraphics, it.next(), f4, f5);
            f5 += 9.0f;
        }
        if (this.f279c != null) {
            a(poseStack, guiGraphics, this.f279c, ((i4 + i3) - 16) - 0, i5 + ((height - 16) / 2.0f) + f3);
        }
        guiGraphics.disableScissor();
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Vec3 vec3, float f, float f2) {
        Camera mainCamera = Minecraft.getInstance().gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        int iFloor = Mth.floor((Mth.positiveModulo(1.0d - ((Mth.positiveModulo(((double) mainCamera.getYRot()) / 360.0d, 1.0d) - 0.25d) - (Math.atan2(vec3.z - position.z, vec3.x - position.x) / 6.283185307179586d)), 1.0d) * 32.0d) + 0.5d) % 32;
        C0040bk.a(poseStack, guiGraphics, c[iFloor], f, f2, 16.0f, 16.0f);
        C0040bk.a(poseStack, guiGraphics, d[iFloor], f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.nB);
        C0040bk.a(poseStack, guiGraphics, dP, f, f2, 16.0f, 16.0f, 0.0f, 1.0f, this.cv);
    }

    private static int a(@NotNull Font font, @NotNull List<FormattedCharSequence> list) {
        int iMax = 0;
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, font.width(it.next()));
        }
        return iMax;
    }

    public boolean k() {
        int i = this.Z;
        this.Z = i - 1;
        this.bs = i <= 0;
        this.aE = this.aD;
        this.aD = C0634xm.g(this.aD, this.bs ? 1.0f : 0.0f, this.bs ? 0.5f : 0.35f);
        return this.bs && this.aD >= 0.95f;
    }

    public void b(@NotNull Component component, int i) {
        b(List.of(component), i);
    }

    public void b(@NotNull List<Component> list, int i) {
        this.az = List.copyOf(list);
        this.aA = a(this.az);
        this.nA = -1;
        this.Z = i;
    }

    public void aS() {
        this.Z = 0;
    }

    public int bj() {
        return this.Z;
    }

    @NotNull
    public List<Component> E() {
        return this.az;
    }

    @Nullable
    public String getKey() {
        return this.bQ;
    }
}
