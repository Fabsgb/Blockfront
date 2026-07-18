package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hM.class */
public class C0423hM {

    /* JADX INFO: renamed from: de */
    private static final ResourceLocation f2702de = C0564jv.m2555d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: df */
    private static final ResourceLocation f2703df = C0564jv.m2555d("textures/gui/menu/icons/cross_white.png");

    /* JADX INFO: renamed from: am */
    private final String f2704am;

    /* JADX INFO: renamed from: an */
    private final String f2705an;

    /* JADX INFO: renamed from: ao */
    private final String f2706ao;

    /* JADX INFO: renamed from: cG */
    private final boolean f2707cG;

    /* JADX INFO: renamed from: db */
    float f2708db;

    /* JADX INFO: renamed from: dc */
    float f2709dc = 0.0f;

    /* JADX INFO: renamed from: cH */
    private boolean f2710cH;

    /* JADX INFO: renamed from: c */
    Consumer<C0423hM> f2711c;

    C0423hM(@NotNull String str, @NotNull String str2, @NotNull C0426hP c0426hP, boolean z) {
        C0424hN.f2712R.add(this);
        this.f2704am = str;
        this.f2705an = str + ".desc";
        this.f2706ao = str2;
        this.f2707cG = z;
        this.f2710cH = z;
        c0426hP.m2001a(this);
    }

    /* JADX INFO: renamed from: a */
    public C0423hM m1993a(Consumer<C0423hM> consumer) {
        this.f2711c = consumer;
        return this;
    }

    /* JADX INFO: renamed from: m */
    public static float m1994m(float f) {
        if (f == 1.0f) {
            return 0.75f;
        }
        if (f == 0.75f) {
            return 0.5f;
        }
        if (f == 0.5f) {
            return 0.25f;
        }
        if (f == 0.25f) {
            return 1.0f;
        }
        return 1.0f;
    }

    public int getColor() {
        return m1996T() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
    }

    /* JADX INFO: renamed from: a */
    public void mo1991a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            m1997x(!this.f2710cH);
        } else if (i == 1) {
            m1997x(this.f2707cG);
        }
        C0424hN.f2773cI = true;
        this.f2708db = 1.0f;
    }

    /* JADX INFO: renamed from: a */
    public void mo1989a(@NotNull JsonObject jsonObject) {
        this.f2710cH = jsonObject.has(this.f2706ao) ? jsonObject.get(this.f2706ao).getAsBoolean() : this.f2707cG;
    }

    /* JADX INFO: renamed from: b */
    public void mo1990b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(this.f2706ao, Boolean.valueOf(this.f2710cH));
    }

    public String getName() {
        return this.f2704am;
    }

    /* JADX INFO: renamed from: p */
    public String m1995p() {
        return this.f2705an;
    }

    public String getKey() {
        return this.f2706ao;
    }

    /* JADX INFO: renamed from: T */
    public boolean m1996T() {
        return this.f2710cH;
    }

    /* JADX INFO: renamed from: x */
    public void m1997x(boolean z) {
        if (this.f2710cH != z) {
            this.f2710cH = z;
            if (this.f2711c != null) {
                this.f2711c.accept(this);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1986a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = m1996T() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
        C0119bk.m417a(guiGraphics, i, i2, i3, i4, i7, C1290xm.m7843e(this.f2708db, this.f2709dc, f2));
        C0119bk.m415a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        C0119bk.m437a(poseStack, guiGraphics, this.f2710cH ? f2702de : f2703df, i5 - 8, i6 - 8, 16, 16, 0.0f, 1.0f, i7);
    }

    public void onUpdate() {
        this.f2709dc = this.f2708db;
        this.f2708db = (float) Mth.lerp(0.35d, this.f2708db, 0.0d);
    }
}
