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

/* JADX INFO: renamed from: com.boehmod.blockfront.id */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/id.class */
public class C0494id {

    /* JADX INFO: renamed from: de */
    private static final ResourceLocation f3003de = C0532jO.m2378d("textures/gui/menu/icons/check_white.png");

    /* JADX INFO: renamed from: df */
    private static final ResourceLocation f3004df = C0532jO.m2378d("textures/gui/menu/icons/cross_white.png");

    /* JADX INFO: renamed from: at */
    private final String f3005at;

    /* JADX INFO: renamed from: au */
    private final String f3006au;

    /* JADX INFO: renamed from: av */
    private final String f3007av;

    /* JADX INFO: renamed from: cP */
    private final boolean f3008cP;

    /* JADX INFO: renamed from: dh */
    float f3009dh;

    /* JADX INFO: renamed from: di */
    float f3010di = 0.0f;

    /* JADX INFO: renamed from: cQ */
    private boolean f3011cQ;

    /* JADX INFO: renamed from: c */
    Consumer<C0494id> f3012c;

    C0494id(@NotNull String str, @NotNull String str2, @NotNull C0497ig c0497ig, boolean z) {
        C0495ie.f3013U.add(this);
        this.f3005at = str;
        this.f3006au = str + ".desc";
        this.f3007av = str2;
        this.f3008cP = z;
        this.f3011cQ = z;
        c0497ig.m2235a(this);
    }

    /* JADX INFO: renamed from: a */
    public C0494id m2227a(Consumer<C0494id> consumer) {
        this.f3012c = consumer;
        return this;
    }

    /* JADX INFO: renamed from: m */
    public static float m2228m(float f) {
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
        return m2230U() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
    }

    /* JADX INFO: renamed from: a */
    public void mo2222a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            m2231x(!this.f3011cQ);
        } else if (i == 1) {
            m2231x(this.f3008cP);
        }
        C0495ie.f3075cR = true;
        this.f3009dh = 1.0f;
    }

    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        this.f3011cQ = jsonObject.has(this.f3007av) ? jsonObject.get(this.f3007av).getAsBoolean() : this.f3008cP;
    }

    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(this.f3007av, Boolean.valueOf(this.f3011cQ));
    }

    public String getName() {
        return this.f3005at;
    }

    /* JADX INFO: renamed from: t */
    public String m2229t() {
        return this.f3006au;
    }

    public String getKey() {
        return this.f3007av;
    }

    /* JADX INFO: renamed from: U */
    public boolean m2230U() {
        return this.f3011cQ;
    }

    /* JADX INFO: renamed from: x */
    public void m2231x(boolean z) {
        if (this.f3011cQ != z) {
            this.f3011cQ = z;
            if (this.f3012c != null) {
                this.f3012c.accept(this);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo2017a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = m2230U() ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_THEME_RED_SOLID;
        C0129bt.m517a(guiGraphics, i, i2, i3, i4, i7, C1270xJ.m7170f(this.f3009dh, this.f3010di, f2));
        C0129bt.m515a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        C0129bt.m537a(poseStack, guiGraphics, this.f3011cQ ? f3003de : f3004df, i5 - 8, i6 - 8, 16, 16, 0.0f, 1.0f, i7);
    }

    public void onUpdate() {
        this.f3010di = this.f3009dh;
        this.f3009dh = (float) Mth.lerp(0.35d, this.f3009dh, 0.0d);
    }
}
