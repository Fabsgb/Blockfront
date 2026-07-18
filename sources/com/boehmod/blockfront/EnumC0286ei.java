package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ei */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ei.class */
public enum EnumC0286ei {
    CLIENT_NOTIFICATION(-9143992),
    MOD_UPDATE_NOTIFICATION(ColorReferences.COLOR_THEME_YELLOW_SOLID, "update"),
    CHALLENGE_NOTIFICATION(ColorReferences.COLOR_THEME_YELLOW_SOLID, "challenge");

    private final int color;

    @NotNull
    private final ResourceLocation icon;

    EnumC0286ei(int i) {
        this(i, "bf");
    }

    EnumC0286ei(int i, @NotNull String str) {
        this.color = i;
        this.icon = C0564jv.m2555d("textures/gui/toast/" + str + ".png");
    }

    public int getColor() {
        return this.color;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
