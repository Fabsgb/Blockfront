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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hM.class */
public class hM {

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private static final ResourceLocation f416de = C0265jv.d("textures/gui/menu/icons/check_white.png");
    private static final ResourceLocation df = C0265jv.d("textures/gui/menu/icons/cross_white.png");
    private final String am;
    private final String an;
    private final String ao;
    private final boolean cG;
    float db;
    float dc = 0.0f;
    private boolean cH;
    Consumer<hM> c;

    hM(@NotNull String str, @NotNull String str2, @NotNull hP hPVar, boolean z) {
        hN.R.add(this);
        this.am = str;
        this.an = str + ".desc";
        this.ao = str2;
        this.cG = z;
        this.cH = z;
        hPVar.a(this);
    }

    public hM a(Consumer<hM> consumer) {
        this.c = consumer;
        return this;
    }

    public static float m(float f) {
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
        return T() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            x(!this.cH);
        } else if (i == 1) {
            x(this.cG);
        }
        hN.cI = true;
        this.db = 1.0f;
    }

    public void a(@NotNull JsonObject jsonObject) {
        this.cH = jsonObject.has(this.ao) ? jsonObject.get(this.ao).getAsBoolean() : this.cG;
    }

    public void b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(this.ao, Boolean.valueOf(this.cH));
    }

    public String getName() {
        return this.am;
    }

    public String p() {
        return this.an;
    }

    public String getKey() {
        return this.ao;
    }

    public boolean T() {
        return this.cH;
    }

    public void x(boolean z) {
        if (this.cH != z) {
            this.cH = z;
            if (this.c != null) {
                this.c.accept(this);
            }
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = T() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
        C0040bk.a(guiGraphics, i, i2, i3, i4, i7, C0634xm.e(this.db, this.dc, f2));
        C0040bk.a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        C0040bk.a(poseStack, guiGraphics, this.cH ? f416de : df, i5 - 8, i6 - 8, 16, 16, 0.0f, 1.0f, i7);
    }

    public void onUpdate() {
        this.dc = this.db;
        this.db = (float) Mth.lerp(0.35d, this.db, 0.0d);
    }
}
